package framework.ressource.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringWriter;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */

public class UtilSerialize {

  public UtilSerialize() {
  }

  public static Object readFile(String path, String fileName) {
    String szPath = "";
    if ( (UtilString.isNotEmpty(path)) && (!path.endsWith(File.separator)))
      szPath = path + File.separatorChar;
    return readFile(szPath + fileName);
  }
  public static Object readFile(String fileName) {
    Object ret = null;
    if (UtilString.isNotEmpty(fileName))
    {
      File file = new File(fileName);
      if( (file!=null)&&(file.exists()) ) {
        try {
          FileInputStream fInStream = new FileInputStream(fileName);
          ObjectInputStream oOInStream = new ObjectInputStream(fInStream);
          ret = oOInStream.readObject();
          oOInStream.close();
          fInStream.close();
        }
        catch (InvalidClassException ex) {
          // N'affiche pas le message de difference de class
        }
        catch (FileNotFoundException ex) {
          UtilTrace.formatTrace(ex);
        }
        catch (ClassNotFoundException ex) {
          UtilTrace.formatTrace(ex);
        }
        catch (IOException ex) {
          UtilTrace.formatTrace(ex);
        }
      }
    }
    return ret;
  }

  public static void saveFile(String path, String fileName, Object obj) {
    String szPath = "";
    if ( (UtilString.isNotEmpty(path)) && (!path.endsWith(File.separator)))
      szPath = path + File.separatorChar;
    saveFile(szPath + fileName, obj);
  }

  public static void saveFile(String fileName, Object obj) {
    String szPath = UtilFile.pathName(fileName);
    if ( !szPath.equals(fileName) ) {
      File fDir = new File(szPath);
      if (!fDir.exists())
        new File(szPath).mkdirs();
    }
    try {
      StringWriter sw = null;
      FileOutputStream fOutStream = new FileOutputStream(fileName);
      ObjectOutputStream oOutStream = new ObjectOutputStream(fOutStream);
      if (obj instanceof String)
        oOutStream.writeChars((String)obj);
      else
        oOutStream.writeObject(obj);
      oOutStream.flush();
      oOutStream.close();
      fOutStream.close();
    }
    catch (IOException ex) {
      UtilTrace.formatTrace(ex);
    }
  }

  public static void saveFileText(String fileName, String msg) {
    try {
      FileWriter writer = new FileWriter(fileName, true);
      writer.write(msg);
      writer.close();
    }
    catch (IOException ex) {
      UtilTrace.formatTrace(ex);
    }
  }
}
