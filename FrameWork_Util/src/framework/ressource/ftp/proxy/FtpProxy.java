package framework.ressource.ftp.proxy;
/*
Java FTP Proxy Server 1.3.0

src: http://aggemam.dk/ftpproxy
*/

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.BindException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

/**
 * @author  HP_Administrateur
 */
public class FtpProxy extends Thread {
    private final static String defaultConfigFile = "ftpproxy.conf";

    final static int DEFAULT_BACKLOG = 50;
    final static int DATABUFFERSIZE = 512;

    Socket skControlClient;
    Socket skControlServer;
    BufferedReader brClient;
    BufferedReader brServer;
    PrintStream psClient;
    PrintStream osServer;

    ServerSocket ssDataClient;
    ServerSocket ssDataServer;
    Socket skDataClient;
    Socket skDataServer;

    //IP of interface facing client and server respectively
    String sLocalClientIP;
    String sLocalServerIP;

    //private final Configuration config;
    private Configuration config;

    DataConnect dcData;
    boolean serverPassive = false;
    boolean userLoggedIn = false;
    boolean connectionClosed = false;

    final static Map lastPorts = new HashMap();

    //constants for debug output
    final static PrintStream pwDebug = System.out;
    final static String server2proxy = "S->P: ";
    final static String proxy2server = "S<-P: ";
    final static String proxy2client = "P->C: ";
    final static String client2proxy = "P<-C: ";
    final static String server2client = "S->C: ";
    final static String client2server = "S<-C: ";



    //use CRLF instead of println() to ensure that CRLF is used
    //on all platforms
    public static String CRLF = "\r\n";


    public FtpProxy(Configuration config, Socket skControlClient) {
        this.config = config;
        this.skControlClient = skControlClient;

	//sLocalClientIP is initialized in main(), to handle
	//masquerade_host where the IP address for the host is dynamic.
    }

    public static void main(String args[]) {
        Map commandLineArguments = new HashMap(args.length);
        for (int i = 0; i < args.length; i++) {
            int j = args[i].indexOf("=");
            if (j == -1) {
	        System.err.println("Invalid argument: " + args[i]);
	        System.exit(0);
	    }

            String name = args[i].substring(2, j);
            String value = args[i].substring(j + 1);

            if (commandLineArguments.containsKey(name)) {
		System.err.println("Parameter error: --" + name + " may only be specified once.");
		System.exit(0);
            }

            commandLineArguments.put(name, value);
        }

        //read configuration
        String configFile = (String) commandLineArguments.get("config_file");
	if (configFile == null) {
            configFile = defaultConfigFile;
        }
        commandLineArguments.remove("config_file");

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(configFile));
        } catch (IOException e) {
            System.err.println("Configuration file error: " + e.getMessage());
            System.exit(0);
        }

        //command line arguments override those in the config file
        properties.putAll(commandLineArguments);

        Configuration config;
        try {
            config = new Configuration(properties);
        } catch (Exception e) {
            System.err.println("Invalid configuration: " + e.getMessage());
            System.exit(0);
            return; //to make it compile
        }

	//the configuration class removes the configuration variables when
	//reading them - any remaining variables are unknown and thus invalid.
	if (properties.size() > 0) {
	    System.err.println("Invalid configuration variable: " + properties.propertyNames().nextElement());
	    System.exit(0);
	}

        int port = config.bindPort;

        try {
            ServerSocket ssControlClient;

            if (config.bindAddress == null) {
                ssControlClient = new ServerSocket(port);
            } else {
                ssControlClient = new ServerSocket(port, DEFAULT_BACKLOG, config.bindAddress);
            }

            if (config.debug) pwDebug.println("Listening on port " + port);

            while (true) {
                Socket skControlClient = ssControlClient.accept();
                if (config.debug) pwDebug.println("New connection");
                new FtpProxy(config, skControlClient).start();
            }
        } catch (IOException e) {
            if (config.debug) {
                e.printStackTrace(pwDebug);
            } else {
                System.err.println(e.toString());
            }
        }
    }

    public void run() {
        try {
            brClient = new BufferedReader(new InputStreamReader(skControlClient.getInputStream()));
            psClient = new PrintStream(skControlClient.getOutputStream());

            if ((config.allowFrom != null &&
                 !isInSubnetList(config.allowFrom, skControlClient.getInetAddress())) ||
                isInSubnetList(config.denyFrom, skControlClient.getInetAddress())) {

                String toClient = config.msgOriginAccessDenied;
                psClient.print(toClient + CRLF);
                if (config.debug) pwDebug.println(proxy2client + toClient);
                skControlClient.close();
                return;
            }

	    try {
		if (config.masqueradeHostname == null) {
		    sLocalClientIP = skControlClient.getLocalAddress().getHostAddress().replace('.', ',');
		} else {
		    sLocalClientIP = InetAddress.getByName(config.masqueradeHostname.trim()).
		        getHostAddress().replace('.', ',');
		}
	    } catch (UnknownHostException e) {
		String toClient = config.msgMasqHostDNSError;
		psClient.print(toClient + CRLF);
		if (config.debug) pwDebug.println(proxy2client + toClient);
		skControlClient.close();
		return;
	    }

            String username = null;
            String hostname = null;
            int serverport = 21;

            if (config.onlyAuto && config.autoHostname != null) {
                username = null; //value will not be used
                hostname = config.autoHostname;
                serverport = config.autoPort;

            } else {
                if (config.onlyAuto) { //and autoHostname == null
                    throw new RuntimeException("only_auto is enabled, but no auto_host is set");
                }

                String toClient = config.msgConnect;
                psClient.print(toClient + CRLF);
                psClient.flush();
                if (config.debug) pwDebug.println(proxy2client + toClient);

                //the username is read from the client
                String fromClient = brClient.readLine();
                if (config.debug) pwDebug.println(client2proxy + fromClient);

                String userString = fromClient.substring(5);

                int a = userString.indexOf('@');
                int c = userString.lastIndexOf(':');

                if (a == -1 && config.isUrlSyntaxEnabled) {
                    int a1 = userString.indexOf('*');
                    if (a1 != -1) {
                        a = a1;
                        c = userString.lastIndexOf('*');
                        if (c == a) c = -1;
                    }
                }
                if (a == -1) {
                    username = userString;
                    hostname = config.autoHostname;
                    serverport = config.autoPort;
                } else if (c == -1) {
                    username = userString.substring(0, a);
                    hostname = userString.substring(a + 1);
                } else {
                    username = userString.substring(0, a);
                    hostname = userString.substring(a + 1, c);
                    serverport = Integer.parseInt(userString.substring(c + 1));
                }
            }

            //don't know which host to connect to
            if (hostname == null) {
                String toClient = config.msgIncorrectSyntax;
                if (config.debug) pwDebug.println(proxy2client + toClient);
                psClient.print(toClient + CRLF);
                skControlClient.close();
                return;
            }

            InetAddress serverAddress = InetAddress.getByName(hostname);

            if ((config.allowTo != null &&
                 !isInSubnetList(config.allowTo, serverAddress)) ||
                isInSubnetList(config.denyTo, serverAddress)) {

                String toClient = config.msgDestinationAccessDenied;

                psClient.print(toClient + CRLF);
                skControlClient.close();
                return;
            }

            serverPassive = config.useActive != null && !isInSubnetList(config.useActive, serverAddress) ||
                            isInSubnetList(config.usePassive, serverAddress);

            if (config.debug) pwDebug.println("Connecting to " + hostname + " on port " + serverport);

            try {
                skControlServer = new Socket(serverAddress, serverport);
            } catch (ConnectException e) {
                String toClient = config.msgConnectionRefused;
                psClient.print(toClient + CRLF);
                psClient.flush();
                if (config.debug) pwDebug.println(proxy2client + toClient);
                return;
            }

            brServer = new BufferedReader(new InputStreamReader(skControlServer.getInputStream()));
            osServer = new PrintStream(skControlServer.getOutputStream(), true);
            sLocalServerIP = skControlServer.getLocalAddress().getHostAddress().replace('.' ,',');

            if (!config.onlyAuto) {
                String fromServer = readResponseFromServer(false);

                if (fromServer.startsWith("421")) {
                    String toClient = fromServer;
                    psClient.print(toClient + CRLF);
                    psClient.flush();
                    return;
                }
                String toServer = "USER " + username;
                osServer.print(toServer + CRLF); //USER user
                osServer.flush();
                if (config.debug) pwDebug.println(proxy2server + toServer);
            }

            readResponseFromServer(true);

            for (;;) {
                String s = brClient.readLine();
                if (s == null) {
                    break;
                }
                readCommandFromClient(s);
                //exit if connection closed (response == 221,421,530)
                if (connectionClosed) {
                    break;
                }
            }

        } catch (Exception e) {
            String toClient = config.msgInternalError;
            if (config.debug) {
                pwDebug.println(proxy2client + toClient + e.toString());
                e.printStackTrace(pwDebug);
            }
            psClient.print(toClient + CRLF);
            psClient.flush();

        } finally {
            if (ssDataClient != null && !config.clientOneBindPort) {
                try {ssDataClient.close();} catch (IOException ioe) {}
            }
            if (ssDataServer != null && !config.serverOneBindPort) {
                try {ssDataServer.close();} catch (IOException ioe) {}
            }
            if (skDataClient != null) try {skDataClient.close();} catch (IOException ioe) {}
            if (skDataServer != null) try {skDataServer.close();} catch (IOException ioe) {}
            if (psClient != null) psClient.close();
            if (osServer != null) osServer.close();
            if (dcData != null) dcData.close();
        }
    }

    private void readCommandFromClient(String fromClient) throws IOException {
        String cmd = fromClient.toUpperCase();

        if (!userLoggedIn && (cmd.startsWith("PASV") || cmd.startsWith("PORT"))) {
            //do not process PASV if user has not logged in yet.
            psClient.print("530 Not logged in." + CRLF);
            psClient.flush();
            return;
        }

        if (cmd.startsWith("PASV")) {
            if (config.debug) pwDebug.println(client2proxy + fromClient);

            if (ssDataClient != null && !config.clientOneBindPort) {
                try { ssDataClient.close(); } catch (IOException ioe) {}
            }
            if (skDataClient != null) try { skDataClient.close(); } catch (IOException ioe) {}
            if (dcData != null) dcData.close();

            if (ssDataClient == null || !config.clientOneBindPort) {
                ssDataClient = getServerSocket(config.clientBindPorts, skControlClient.getLocalAddress());
            }

            if (ssDataClient != null) {
                int port = ssDataClient.getLocalPort();

                String toClient = "227 Entering Passive Mode (" + sLocalClientIP + "," +
                        (int) (port / 256) + "," + (port % 256) + ")";
                psClient.print(toClient + CRLF);
                psClient.flush();
                if (config.debug) pwDebug.println(proxy2client + toClient);

                setupServerConnection(ssDataClient);

            } else {
                String toClient = "425 Cannot allocate local port..";
                psClient.print(toClient + CRLF);
                psClient.flush();
                if (config.debug) pwDebug.println(proxy2client + toClient);
            }

        } else if (cmd.startsWith("PORT")) {
            int port = parsePort(fromClient);

            if (ssDataClient != null && !config.clientOneBindPort) {
                try {ssDataClient.close();} catch (IOException ioe) {}
                ssDataClient = null;
            }
            if (skDataClient != null) try {skDataClient.close();} catch (IOException ioe) {}
            if (dcData != null) dcData.close();


            if (config.debug) pwDebug.println(client2proxy + fromClient);

            try {
                skDataClient = new Socket(skControlClient.getInetAddress(), port);

                String toClient = "200 PORT command successful.";
                psClient.print(toClient + CRLF);
                psClient.flush();
                if (config.debug) pwDebug.println(proxy2client + toClient);

                setupServerConnection(skDataClient);

            } catch (IOException e) {
                String toClient = "425 PORT command failed - try using PASV instead.";
                psClient.print(toClient + CRLF);
                psClient.flush();
                if (config.debug) pwDebug.println(proxy2client + toClient);

                return;
            }


        } else {
            osServer.print(fromClient + CRLF);
            osServer.flush();
            if (config.debug) {
                pwDebug.print(client2server);
                if (cmd.startsWith("PASS")) {
                    pwDebug.println("PASS *******");
                } else {
                    pwDebug.println(fromClient);
                }
            }

            readResponseFromServer(true);
        }
    }

    private String readResponseFromServer(boolean forwardToClient) throws IOException {
        String fromServer = brServer.readLine();
        String firstLine = fromServer;

        int response = Integer.parseInt(fromServer.substring(0, 3));
        if (fromServer.charAt(3) == '-') {
            String multiLine = fromServer.substring(0, 3) + ' ';
            while (!fromServer.startsWith(multiLine)) {
                if (forwardToClient) {
                    psClient.print(fromServer + CRLF);
                    psClient.flush();
                }
                if (config.debug) pwDebug.println((forwardToClient ? server2client : server2proxy) + fromServer);

                fromServer = brServer.readLine();
            }
        }

        //check for successful login
        if (response == 230) {
            userLoggedIn = true;
        } else if (response == 221 || response == 421 || response == 530) {
            if (userLoggedIn) {
        	connectionClosed = true;
            }
            userLoggedIn = false;
        }

        if (forwardToClient || response == 110) {
            psClient.print(fromServer + CRLF);
            psClient.flush();
        }
        if (config.debug) pwDebug.println((forwardToClient ? server2client : server2proxy) + fromServer);

        if (response >= 100 && response <= 199) {
            firstLine = readResponseFromServer(true);
        }

        return firstLine;
    }

    private void setupServerConnection(Object s) throws IOException {
	if (skDataServer != null) {
	    try {skDataServer.close();} catch (IOException ioe) {}
	}

        if (serverPassive) {
            String toServer = "PASV";
            osServer.print(toServer + CRLF);
            osServer.flush();
            if (config.debug) pwDebug.println(proxy2server + toServer);

            String fromServer = readResponseFromServer(false);

            int port = parsePort(fromServer);

            if (config.debug) pwDebug.println("Server: " + skControlServer.getInetAddress() + ":" + port);

            skDataServer = new Socket(skControlServer.getInetAddress(), port);

            (dcData = new DataConnect(s, skDataServer)).start();
        } else {
	    if (ssDataServer != null && !config.serverOneBindPort) {
		try {ssDataServer.close();} catch (IOException ioe) {}
	    }

            if (ssDataServer == null || !config.serverOneBindPort) {
                ssDataServer = getServerSocket(config.serverBindPorts, skControlServer.getLocalAddress());
            }

            if (ssDataServer != null) {
                int port = ssDataServer.getLocalPort();
                String toServer = "PORT " + sLocalServerIP + ',' + (int) (port / 256) + ',' + (port % 256);

                osServer.print(toServer + CRLF);
                osServer.flush();
                if (config.debug) pwDebug.println(proxy2server + toServer);

                readResponseFromServer(false);

                (dcData = new DataConnect(s, ssDataServer)).start();

            } else {
                String toClient = "425 Cannot allocate local port.";
                psClient.print(toClient + CRLF);
                psClient.flush();
                if (config.debug) pwDebug.println(proxy2client + toClient);
            }
        }
    }

    public static boolean isInSubnetList(List list, InetAddress ia) {
        if (list == null) return false;

        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            Subnet subnet = (Subnet) iterator.next();

            if (subnet.isInSubnet(ia)) return true;
        }
        return false;
    }

    public static int parsePort(String s) throws IOException {
        int port;
        try {
            int i = s.lastIndexOf('(');
            int j = s.lastIndexOf(')');
            if ((i != -1) && (j != -1) && (i < j)) {
                s = s.substring(i + 1, j);
            }

            i = s.lastIndexOf(',');
            j = s.lastIndexOf(',', i - 1);

            port = Integer.parseInt(s.substring(i + 1));
            port += 256 * Integer.parseInt(s.substring(j + 1, i));
        } catch (Exception e) {
            throw new IOException();
        }
        return port;
    }

    public static synchronized ServerSocket getServerSocket(int[] portRanges, InetAddress ia) throws IOException {
        ServerSocket ss = null;
        if (portRanges != null) {
            int i; //current index of portRanges array
            int port;

            Integer lastPort = (Integer) lastPorts.get(portRanges);
            if (lastPort != null) {
                port = lastPort.intValue();
                for (i = 0; i < portRanges.length && port > portRanges[i + 1]; i += 2);
                port++;
            } else {
                port = portRanges[0];
                i = 0;
            }

            for (int lastTry = -2; port != lastTry; port++) {
                if (port > portRanges[i + 1]) {
                    i = (i + 2) % portRanges.length;
                    port = portRanges[i];
                }
                if (lastTry == -1) lastTry = port;
                try {
                    ss = new ServerSocket(port, 1, ia);
                    lastPorts.put(portRanges, new Integer(port));
                    break;
                } catch(BindException e) {
                    //port already in use
                }
            }
        } else {
            ss = new ServerSocket(0, 1, ia);
        }
        return ss;
    }

    public class DataConnect extends Thread {
        private byte buffer[] = new byte[DATABUFFERSIZE];
        private final Socket[] sockets = new Socket[2];
        private boolean isInitialized;
        private final Object[] o;
        private boolean validDataConnection;

        private Object mutex = new Object();

        //each argument may be either a Socket or a ServerSocket
        public DataConnect (Object o1, Object o2) {
            this.o = new Object[] {o1, o2};
        }

        public void run() {
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            validDataConnection = false;

            try {
                // n = 0 - Thread Copy socket 0 to socket 1
                // n = 1 - Thread Copy socket 1 to socket 0
                int n = isInitialized ? 1 : 0;
                if (!isInitialized) {
                    for (int i = 0; i < 2; i++) {
                        if (o[i] instanceof ServerSocket) {
                            ServerSocket ss = (ServerSocket) o[i];
                            sockets[i] = ss.accept();
                            if (ss == ssDataServer && !config.serverOneBindPort ||
                                ss == ssDataClient && !config.clientOneBindPort) {

                                ss.close();
                            }
                        } else {
                            sockets[i] = (Socket) o[i];
                        }
                        //check to see if DataConnection is from same IP address
                        //as the ControlConnection
                        if (skControlClient.getInetAddress().getHostAddress().
                            compareTo(sockets[i].getInetAddress().getHostAddress()) == 0) {

                            validDataConnection = true;
                        }
                    }
                    //check to see if Data InetAddress == Control InetAddress, otherwise
                    //somebody else opened a connection!  Close all the connections
                    if (config.validateDataConnection && !validDataConnection) {
                        pwDebug.println("Invalid DataConnection - not from Control Client");
                        throw new SocketException("Invalid DataConnection - not from Control Client");
                    }

                    isInitialized = true;

                    //in some cases thread socket[0] -> socket[1] thread can
               	    //finish before socket[1] -> socket[0] has a chance to start,
               	    //so synchronize on a semaphore
                    synchronized(mutex) {
                        new Thread(this).start();
                        try {
                            mutex.wait();
                        } catch (InterruptedException e) {
                            //Never occur
                        }
                    }

                }

                bis = new BufferedInputStream(sockets[n].getInputStream());
                bos = new BufferedOutputStream(sockets[1 - n].getOutputStream());

                synchronized(mutex) {
                   mutex.notify();
                }

                for (;;) {
                    for (int i; (i = bis.read(buffer, 0, DATABUFFERSIZE)) != -1; ) {
                        bos.write(buffer, 0, i);
                    }
                    break;
                }
                bos.flush();
            } catch (SocketException e) {
                //socket closed
            } catch (IOException e) {
                if (config.debug) e.printStackTrace(pwDebug);
            }
            close();
        }

        public void close() {
            try { sockets[0].close(); } catch (Exception e) {}
            try { sockets[1].close(); } catch (Exception e) {}
        }
    }
}

class Configuration {
    Properties properties;

    int bindPort;
    InetAddress bindAddress;

    //variables read from configuration file
    boolean onlyAuto;
    String autoHostname;
    int autoPort;
    String masqueradeHostname;
    boolean isUrlSyntaxEnabled;
    int[] serverBindPorts;
    int[] clientBindPorts;
    boolean serverOneBindPort;
    boolean clientOneBindPort;
    boolean validateDataConnection;
    boolean debug;

    //lists of subnets
    List useActive;
    //lists of subnets
    List usePassive;
    List allowFrom;
    List denyFrom;
    List allowTo;
    List denyTo;

    //messages
    String msgConnect;
    String msgConnectionRefused;
    String msgOriginAccessDenied;
    String msgDestinationAccessDenied;
    String msgIncorrectSyntax;
    String msgInternalError;
    String msgMasqHostDNSError;

    public Configuration(Properties properties) throws UnknownHostException {
    	this.properties = properties;

        bindPort = getInt("bind_port", 8089);
        String ba = getString("bind_address");
        bindAddress = ba == null ? null : InetAddress.getByName(ba.trim());

        serverBindPorts = getPortRanges("server_bind_ports");
        clientBindPorts = getPortRanges("client_bind_ports");
        serverOneBindPort = serverBindPorts != null && serverBindPorts.length == 2 &&
                            serverBindPorts[0] == serverBindPorts[1];
        clientOneBindPort = clientBindPorts != null && clientBindPorts.length == 2 &&
                            clientBindPorts[0] == clientBindPorts[1];

	masqueradeHostname = getString("masquerade_host");
        if (masqueradeHostname != null) {
            //This is just to throw an UnknownHostException
            //if the config is incorrectly set up.
	    InetAddress.getByName(masqueradeHostname.trim());
	}

        useActive  = getSubnets("use_active");
        usePassive = getSubnets("use_passive");
        allowFrom  = getSubnets("allow_from");
        denyFrom   = getSubnets("deny_from");
        allowTo    = getSubnets("allow_to");
        denyTo     = getSubnets("deny_to");

        onlyAuto   = getBool("only_auto", false);
        autoHostname = getString("auto_host");
        if (autoHostname != null) {
            autoHostname = autoHostname.trim();
        }
        autoPort = getInt("auto_port", 21);

        isUrlSyntaxEnabled = getBool("enable_url_syntax", true);
        validateDataConnection = getBool("validate_data_connection", true);
        debug = getBool("output_debug_info", false);


        msgConnect = "220 " +
            getString("msg_connect", "Java FTP Proxy Server (usage: USERID=user@site) ready.");

        msgConnectionRefused = "421 " +
            getString("msg_connection_refused", "Connection refused, closing connection.");

        msgOriginAccessDenied = "531 " +
            getString("msg_origin_access_denied", "Access denied - closing connection.");

        msgDestinationAccessDenied = "531 " +
            getString("msg_destination_access_denied", "Access denied - closing connection.");

        msgIncorrectSyntax = "531 " +
            getString("msg_incorrect_syntax", "Incorrect usage - closing connection.");

        msgInternalError = "421 " +
            getString("msg_internal_error", "Internal error, closing connection.");

	msgMasqHostDNSError = "421 " +
	    getString("msg_masqerade_hostname_dns_error",
	              "Unable to resolve address for " + masqueradeHostname +
	               " - closing connection.");
    }

    public boolean getBool(String name, boolean defaultValue) {
    	String value = getString(name);
    	return value == null ? defaultValue : value.trim().equals("1");
    }

    public int getInt(String name, int defaultValue) {
    	String value = properties.getProperty(name);
    	properties.remove(name);
    	return value == null ? defaultValue : Integer.parseInt(value.trim());
    }

    public String getString(String name) {
    	return getString(name, null);
    }

    public String getString(String name, String defaultValue) {
    	String value = properties.getProperty(name, defaultValue);
    	properties.remove(name);
    	return value;
    }

    public List getSubnets(String name) {
    	String s = getString(name);
        if (s == null) return null;

        List list = new LinkedList();
        StringTokenizer st = new StringTokenizer(s.trim(), ",");
        while (st.hasMoreTokens()) {
            list.add(new Subnet(st.nextToken().trim()));
        }

        return list;
    }

    /**
     * Returns an array of length 2n, where n is the number of port
     * ranges specified. Index 2i will contain the first port number
     * in the i'th range, and index 2i+1 will contain the last.
     * E.g. the string "111,222-333,444-555,666" will result in the
     * following array: {111, 111, 222, 333, 444, 555, 666, 666}
     */
    public int[] getPortRanges(String name) {
    	String s = getString(name);
        if (s == null) return null;

        StringTokenizer st = new StringTokenizer(s.trim(), ",");
        int[] ports = new int[st.countTokens() * 2];

        if (ports.length == 0) return null;

        int lastPort = 0;
        for (int p = 0; st.hasMoreTokens(); p += 2) {
            String range = st.nextToken().trim();
            int i = range.indexOf('-');

            if (i == -1) {
                ports[p] = ports[p + 1] = Integer.parseInt(range);
            } else {
                ports[p] = Integer.parseInt(range.substring(0, i));
                ports[p + 1] = Integer.parseInt(range.substring(i + 1));
            }
            if (ports[p] < lastPort || ports[p] > ports[p + 1]) {
                throw new RuntimeException("Ports should be listed in increasing order.");
            }
            lastPort = ports[p + 1];
        }

        return ports;
    }
}

