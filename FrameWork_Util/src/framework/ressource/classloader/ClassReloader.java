package framework.ressource.classloader;

import framework.ressource.util.UtilString;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Class that can be used to dynamically load a class, and then reload an updated version This is set up to only load classes whose names end with "Special", but you can change that easy enough You may use this class as you wish, either as a basis for your own code or just drop it into your project However, I will not be held responisble if your program doesn't work, or your computer blows up
 * @author  Simon Macneall macneall@iinet.net.au
 */
public class ClassReloader extends ClassLoader
{
  private Hashtable classes_hash = new Hashtable();
  private String path = null;
  private String jar = null;

  public ClassReloader() {
  }

  public ClassReloader(String path) {
    setPath(path);
  }

  public ClassReloader(ClassLoader classLoader) {
    super(classLoader);
  }

  public ClassReloader(ClassLoader classLoader, String path) {
    this(classLoader);
    setPath(path);
  }

  public ClassReloader(ClassLoader classLoader, String path, String jar) {
    this(classLoader, path);
    setJar(jar);
  }

  public synchronized Class loadClass(String typeName, boolean resolveIt) throws ClassNotFoundException {
    Class ret = null;
    if ( (typeName.startsWith("java.")) ||
        (typeName.startsWith("javax."))) {
      ret = ClassLoader.getSystemClassLoader().loadClass(typeName);//Class.forName(typeName);
    }
    else
    {
      // Regarde si la class n'a pas déja été charger
      // par le classloader
      ret = findLoadedClass(typeName);
      if (ret == null) {
        // Test si le fichier existe
        if (!checkFile(typeName)) {
          // La class n'a pas été lu
          try {
            // Charge la Class par le classloader system
            ret = super.findSystemClass(typeName);
          }
          catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
          }
        }
        else {
          // Essai de charger la class
          byte typeData[] = getType(typeName);
          if (typeData != null)

            // Créé l'objet Class
            ret = defineClass(typeName, typeData, 0, typeData.length);
          if (ret == null) {
            throw new ClassFormatError();
          }

          if (resolveIt) {
            resolveClass(ret);
          }
        }
      }
      else {
        ClassReloader clr = new ClassReloader(getParent(), getPath());
        ret = clr.loadClass(typeName, resolveIt);
      }
    }
    // return class
    return ret;
  }

  protected byte[] readClassFromDisk(String classname) {
    System.out.println("classname=" + classname);

    byte[] ret;
    String fileName = formatFileName(classname);
    try {
      InputStream fi = loadFile(fileName);
      ret = new byte[fi.available()];
      fi.read(ret);
      return ret;
    }
    catch (Exception e) {
      return null;
    }
  }

  protected byte[] getType(String typeName) {
    InputStream fis = loadFile(typeName);
    BufferedInputStream bis = new BufferedInputStream(fis);
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    try {
      int c = bis.read();
      while (c != -1) {
        out.write(c);
        c = bis.read();
      }
    }
    catch (IOException e) {
      System.out.println("io exception");
      return null;
    }
    return out.toByteArray();
  }

  protected String formatFileName(String typeName) {
    String ret = typeName;
    if (isJar())
      ret = formatFileNameJar(typeName);
    else
      ret = formatFileNameClass(typeName);
    return ret;
  }

  protected InputStream loadFile(String typeName) {
    InputStream ret;
    if (isJar())
      ret = loadFileJar(typeName);
    else
      ret = loadFileClass(typeName);
    return ret;
  }

  protected boolean checkFile(String typeName) {
    boolean ret;
    if (isJar())
      ret = checkFileJar(typeName);
    else
      ret = checkFileClass(typeName);
    return ret;
  }

  protected InputStream loadFileClass(String typeName) {
    FileInputStream ret;
    String fileName = formatFileName(typeName);
    try {
      ret = new FileInputStream(fileName);
    }
    catch (FileNotFoundException e) {
      System.out.println("file not found");
      return null;
    }
    return ret;
  }

  protected InputStream loadFileJar(String typeName) {
    InputStream ret;
    try {
      ZipFile zipFile;
      ZipEntry zipEntry;
      String fileName = formatFileName(typeName);
      zipFile = new ZipFile(getJar());
      if (null == zipFile)
        throw new ClassNotFoundException(getJar() + " introuvable");

      zipEntry = zipFile.getEntry(fileName);
      if (null == zipEntry)
        throw new ClassNotFoundException(typeName + " introuvable dans" +
                                         getJar());

      ret = zipFile.getInputStream(zipEntry);
    }
    catch (FileNotFoundException e) {
      System.out.println("file not found");
      return null;
    }
    catch (ClassNotFoundException e) {
      System.out.println("class not found");
      return null;
    }
    catch (IOException e) {
      System.out.println("IOException");
      return null;
    }
    return ret;
  }

  protected String formatFileNameClass(String typeName) {
    String ret = typeName.replace('.', File.separatorChar) + ".class";
    if (getPath() != null) {
      String separator = (!getPath().endsWith(File.separator)) ? File.separator :
          "";
      ret = getPath() + separator + ret;
    }
    return ret;
  }

  protected String formatFileNameJar(String typeName) {
    return typeName.replace('.', File.separatorChar) + ".class";
  }

  protected boolean checkFileClass(String typeName) {
    boolean ret = false;
    try {
      String fileName = formatFileName(typeName);
      ret = new File(fileName).exists();
    }
    catch (Exception ex) {
    }
    return ret;
  }

  protected boolean checkFileJar(String typeName) {
    boolean ret = false;
    try {
      ZipFile zipFile = null;
      ZipEntry zipEntry = null;
      String fileName = formatFileName(typeName);
      zipFile = new ZipFile(getJar());
      if (null == zipFile)
        ret = false;
      else
        zipEntry = zipFile.getEntry(fileName);
      ret = (null != zipEntry);
    }
    catch (Exception ex) {
    }
    return ret;
  }

  public boolean isJar()
  {
    return UtilString.isNotEmpty(getJar());
  }

  /**
 * @return  the jar
 * @uml.property  name="jar"
 */
public String getJar() {
    return jar;
  }

  /**
 * @param jar  the jar to set
 * @uml.property  name="jar"
 */
public void setJar(String jar) {
    this.jar = jar;
  }
  /**
 * @return  the path
 * @uml.property  name="path"
 */
public String getPath() {
    return path;
  }
  /**
 * @param path  the path to set
 * @uml.property  name="path"
 */
public void setPath(String path) {
    this.path = path;
  }
}

