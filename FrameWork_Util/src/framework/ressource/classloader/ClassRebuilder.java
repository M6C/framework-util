package framework.ressource.classloader;

import framework.ressource.util.UtilCompile;
import framework.ressource.util.UtilFile;
import framework.ressource.util.UtilPackage;
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
 */
public class ClassRebuilder extends ClassLoader
{
  private String CST_EXTENSION_JAVA = ".java";
  private String CST_EXTENSION_CLASS = ".class";
  private String CST_DEFAUT_PACKAGE_PROJECT = "framework.";

  private Hashtable classes_hash = new Hashtable();
  private String project = null;
  private String pathSrc = null;
  private String pathCls = null;
  private String jdkCompiler = null;
  private String jdkArchiver = null;
  private String classPath = UtilPackage.getPackageClassPath();
  private String jar = null;

  public ClassRebuilder() {
  }

  public ClassRebuilder(ClassLoader classLoader, String project, String pathSrc, String pathCls, String jdkCompiler, String jdkArchiver) {
    this(classLoader, project, pathSrc, pathCls, null, jdkCompiler, jdkArchiver);
  }

  public ClassRebuilder(ClassLoader classLoader, String project, String pathSrc, String pathCls, String jar, String jdkCompiler, String jdkArchiver) {
    setProject(project);
    setPathSrc(pathSrc);
    setPathCls(pathCls);
    setJar(jar);
    setJdkCompiler(jdkCompiler);
    setJdkArchiver(jdkArchiver);
  }

  public synchronized Class loadClass(String typeName, boolean resolveIt) throws ClassNotFoundException {
    Class ret = null;
    String szProject = getProject();
    szProject = (!"".equals(szProject)) ? szProject+"." : CST_DEFAUT_PACKAGE_PROJECT;
    if (typeName.startsWith(szProject)) {
      // Récupere le chemin vers les sources java
      String szPathSrc = getPathSrc();
      // Récupere le chemin vers les class compilé java
      String szPathCls = getPathCls();
      if ( (szPathSrc != null) && (szPathCls != null) ) {
        szPathSrc = UtilFile.formatPath(szPathSrc);
        szPathCls = UtilFile.formatPath(szPathCls);
        String szFileName = UtilPackage.getClassNameToFileName(typeName);
        File fileJavaSrc = new File(szPathSrc + szFileName + CST_EXTENSION_JAVA);
        File fileJavaCls = new File(szPathCls + szFileName + CST_EXTENSION_CLASS);
        if (((fileJavaSrc.exists() && fileJavaCls.exists()) &&
            (fileJavaSrc.lastModified() > fileJavaCls.lastModified())) ||
            ((fileJavaSrc.exists() && !fileJavaCls.exists()))) {
          // Compile la class
          UtilCompile.buildClass_ExecDos(typeName, szPathSrc, szPathCls, getJdkCompiler(), getClassPath());
          // Compile le Jar
//          UtilCompile.buildJar(szPathCls, getJar(), szProject, getJdkArchiver());
          UtilCompile.buildJar_ExecDos(szPathCls, getJar(), szProject, getJdkArchiver());
          // Supprime la date de modification de la class
          classes_hash.remove(fileJavaCls.getName());
        }
      }
      if (szPathCls != null) {
        szPathCls = UtilFile.formatPath(szPathCls);
        String szFileName = UtilPackage.getClassNameToFileName(typeName);
        File fileJavaCls = new File(szPathCls + szFileName + CST_EXTENSION_CLASS);
        BeanClass beanFileJava = (BeanClass)classes_hash.get(fileJavaCls.getName());
        if ( ( (fileJavaCls != null) && fileJavaCls.exists()) &&
            ( (beanFileJava == null) || (fileJavaCls.lastModified() > beanFileJava.getTime().longValue()))) {
          // Essai de charger la class
          byte typeData[] = getType(typeName);
          if (typeData != null) {
            ClassRebuilder clr = new ClassRebuilder(getParent(), getProject(), getPathSrc(), getPathCls(), getJar(), getJdkCompiler(), getJdkArchiver());
            // Créé l'objet Class
            ret = clr.defineClass(typeName, typeData, 0, typeData.length);
            if (ret == null) {
              throw new ClassFormatError();
            }

            if (resolveIt) {
              resolveClass(ret);
            }
          }
          classes_hash.put(fileJavaCls.getName(), new BeanClass(new Long(fileJavaCls.lastModified()), ret));
        }
        else if (beanFileJava!=null)
          ret = beanFileJava.getObj();
      }
    }
    if (ret == null) {
      try{
        ret = this.getParent().loadClass(typeName); //Class.forName(typeName);
      }
      catch( Exception ex ) {}
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
    String ret = typeName.replace('.', File.separatorChar) + CST_EXTENSION_CLASS;
    if (getPathSrc() != null) {
      String separator = (!getPathSrc().endsWith(File.separator)) ? File.separator :
          "";
      ret = getPathSrc() + separator + ret;
    }
    return ret;
  }

  protected String formatFileNameJar(String typeName) {
    return typeName.replace('.', File.separatorChar) + CST_EXTENSION_CLASS;
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
 * @return  the project
 * @uml.property  name="project"
 */
public String getProject() {
    return project;
  }

  /**
 * @return  the pathSrc
 * @uml.property  name="pathSrc"
 */
public String getPathSrc() {
    return pathSrc;
  }

  /**
 * @return  the pathCls
 * @uml.property  name="pathCls"
 */
public String getPathCls() {
    return pathCls;
  }

  /**
 * @param jar  the jar to set
 * @uml.property  name="jar"
 */
public void setJar(String jar) {
    this.jar = jar;
  }

  /**
 * @param project  the project to set
 * @uml.property  name="project"
 */
public void setProject(String project) {
    this.project = project;
  }

  /**
 * @param pathSrc  the pathSrc to set
 * @uml.property  name="pathSrc"
 */
public void setPathSrc(String pathSrc) {
    this.pathSrc = pathSrc;
  }

  /**
 * @param pathCls  the pathCls to set
 * @uml.property  name="pathCls"
 */
public void setPathCls(String pathCls) {
    this.pathCls = pathCls;
  }

  /**
 * @return  the jdkCompiler
 * @uml.property  name="jdkCompiler"
 */
public String getJdkCompiler() {
	return jdkCompiler;
  }

  /**
 * @param jdkCompiler  the jdkCompiler to set
 * @uml.property  name="jdkCompiler"
 */
public void setJdkCompiler(String string) {
	jdkCompiler = string;
  }

  /**
 * @return  the jdkArchiver
 * @uml.property  name="jdkArchiver"
 */
public String getJdkArchiver() {
	return jdkArchiver;
  }

  /**
 * @param jdkArchiver  the jdkArchiver to set
 * @uml.property  name="jdkArchiver"
 */
public void setJdkArchiver(String string) {
	jdkArchiver = string;
  }

  /**
 * @return  the classPath
 * @uml.property  name="classPath"
 */
public String getClassPath() {
	  return classPath;
  }

  /**
 * @param classPath  the classPath to set
 * @uml.property  name="classPath"
 */
public void setClassPath(String string) {
	  classPath = string;
  }

  /**
 * @author  HP_Administrateur
 */
private class BeanClass {
    private Long time = null;
    private Class obj = null;
    public BeanClass(Long time, Class obj){
      setTime(time);
      setObj(obj);
    }
    /**
	 * @return  the time
	 * @uml.property  name="time"
	 */
    public Long getTime() {
      return time;
    }
    /**
	 * @param time  the time to set
	 * @uml.property  name="time"
	 */
    public void setTime(Long time) {
      this.time = time;
    }
    /**
	 * @return  the obj
	 * @uml.property  name="obj"
	 */
    public Class getObj() {
      return obj;
    }
    /**
	 * @param obj  the obj to set
	 * @uml.property  name="obj"
	 */
    public void setObj(Class obj) {
      this.obj = obj;
    }
  }
}
