/**
 *
 *  Java FTP client library.
 *
 *  src: www.enterprisedt.com
 *
 */

package framework.main;

import java.io.IOException;

import framework.ressource.ftp.FTPClient;
import framework.ressource.ftp.FTPConnectMode;
import framework.ressource.ftp.FTPException;
import framework.ressource.ftp.FTPTransferType;

public class MainFTPClientTest {

    public static void main(String args[]) {

        // we want remote host, user name and password
        if (args.length < 7) {
            System.out.println(args.length);
            usage();
            System.exit(1);
        }
        try {

            // assign args to make it clear
            String host = args[0];
            String user = args[1];
            String password = args[2];
            String filename = args[3];
            String directory = args[4];
            String mode = args[5];
            String connMode = args[6];

            // connect and test supplying port no.
            FTPClient ftp = new FTPClient(host, 21);
            ftp.login(user, password);
            ftp.quit();

            // connect again
            ftp = new FTPClient(host);

            // switch on debug of responses
            ftp.debugResponses(true);

            ftp.login(user, password);

            // binary transfer
            if (args[5].equalsIgnoreCase("BINARY")) {
                ftp.setType(FTPTransferType.BINARY);
            }
            else if (args[5].equalsIgnoreCase("ASCII")) {
                ftp.setType(FTPTransferType.ASCII);
            }
            else {
                System.out.println("Unknown transfer type: " + args[5]);
                System.exit(-1);
            }

            // PASV or active?
            if (args[6].equalsIgnoreCase("PASV")) {
                ftp.setConnectMode(FTPConnectMode.PASV);
            }
            else if (args[6].equalsIgnoreCase("ACTIVE")) {
                ftp.setConnectMode(FTPConnectMode.ACTIVE);
            }
            else {
                System.out.println("Unknown connect mode: " + args[6]);
                System.exit(-1);
            }

            // change dir
            ftp.chdir(directory);

            // put a local file to remote host
            ftp.put(filename, filename);

            // get bytes
            byte[] buf = ftp.get(filename);
            System.out.println("Got " + buf.length + " bytes");

            // append local file
            try {
                ftp.put(filename, filename, true);
            }
            catch (FTPException ex) {
                System.out.println("Append failed: " + ex.getMessage());
            }

            // get bytes again - should be 2 x
            buf = ftp.get(filename);
            System.out.println("Got " + buf.length + " bytes");

            // rename
            ftp.rename(filename, filename + ".new");

            // get a remote file - the renamed one
            ftp.get(filename + ".tst", filename + ".new");

            // ASCII transfer
            ftp.setType(FTPTransferType.ASCII);

            // test that list() works
            String listing = ftp.list(".");
            System.out.println(listing);

            // test that dir() works in full mode
            String[] listings = ftp.dir(".", true);
            for (int i = 0; i < listings.length; i++)
                System.out.println(listings[i]);

            // try system()
            System.out.println(ftp.system());

            // try pwd()
            System.out.println(ftp.pwd());

            ftp.quit();
        }
        catch (IOException ex) {
            System.out.println("Caught exception: " + ex.getMessage());
        }
        catch (FTPException ex) {
            System.out.println("Caught exception: " + ex.getMessage());
        }
    }


    /**
     *  Basic usage statement
     */
    public static void usage() {

        System.out.println("Usage: ");
        System.out.println("framework.ressource.ftp.MainFTPClientTest " +
                           "remotehost user password filename directory " +
                           "(ascii|binary) (active|pasv)");
    }

}
