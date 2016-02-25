package framework.ressource.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class UtilProxy {

  private UtilProxy() {
  }
  public static URL getURL(String url) {
    String strProxy = "proxy.alti.fr";;
    int iProxyPort = 3128; //-1

    URL ret = null;
    URLConnection c = null;

    try {
      System.out.println("\nHTTP Request: " + url);

      URL urlOriginal = new URL(url);

      if ((null != strProxy) && (0 < strProxy.length())) {
        URL urlProxy = new URL(urlOriginal.getProtocol(),
                               strProxy,
                               iProxyPort,// A value of -1 means use the default port for the specified protocol.
                               url);// The original URL is passed as "the file on the host".

        System.out.println("Using Proxy: " + strProxy);
        if (-1 != iProxyPort) {
          System.out.println("Using Proxy Port: " + iProxyPort);
        }

        ret = urlProxy;
      }
      else {
        ret = urlOriginal;
      }

      c = ret.openConnection();

      // In this example, we only consider HTTP connections.
      if (c instanceof HttpURLConnection) {// instanceof returns true only if the object is not null.
        HttpURLConnection h = (HttpURLConnection) c;
        h.connect();
        String strStatus = h.getResponseMessage() + " (" + h.getResponseCode() + ")";
        System.out.println("HTTP Status: " + strStatus);
        System.out.println("HTTP Response Headers: ");
        // Evidently, index 0 always returns null, so we start with index 1.
        for (int i = 1; ; i++) {
          String strKey = h.getHeaderFieldKey(i);
          if (null == strKey) {
            break;
          }
          System.out.println(i + ": " + strKey + ": " + h.getHeaderField(i));
        }

        // Normally at this point, one would download data from the connection.
        // For example, if the MIME type is html, then download the string and display it.
        String strContentType = h.getContentType();
        if ((null != strContentType) && (0 == strContentType.compareTo("text/html"))) {
          // Set boolean bDebug to true if you want verbose output.
          // For simplicity's sake, we just count the number of lines of text.
          System.out.println("Received text/html:[");

          int iNumLines = 0;

          try {
            InputStream in = h.getInputStream();
            BufferedReader data = new BufferedReader(new InputStreamReader(in));

            String line = null;
            while((line = data.readLine()) != null) {
              System.out.println(line);
              iNumLines++;
            }
          }
          catch(Exception exc2) {
            System.out.println("**** IO failure: " + exc2.toString());
          }
          finally {
            System.out.println("]");
            System.out.println("Received text/html has " + iNumLines + " lines");
          }
        }
        h.disconnect();
      }
      else {
        System.out.println("**** No download: connection was not HTTP");
      }
    }
    // Catch all exceptions.
    catch(Exception exc) {
      System.out.println("**** Connection failure: " + exc.toString());
    // TraceFrame.getInstance().INFO("**** Connection failure: " + exc.getMessage());// Same as above line but without the exception class name.
    }
    finally {
      // Do cleanup here.
      // For example, the following, in theory, could make garbage collection more efficient.
      // This might be the place where you choose to put your method call to your connection's "disconnect()";
      // curiously, while every URLConnection has a connect() method, they don't necessarily have a disconnect() method.
      // HttpURLConnection has a disconnect() which is called above.
      c = null;
      url = null;

      return ret;
    }
  }
}
