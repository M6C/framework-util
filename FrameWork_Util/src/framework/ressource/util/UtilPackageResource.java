/**
 * UtilPackageResource
 * This class can retrieve information on packages
 * like getting the classes in this package, the super
 * classes and the extensions.
 * @version 1.0.2
 * @author Alexandre David
 */

/**
 * version history:
 * 1.0: first version
 * 1.0.1 : 990818 fixed the vector -> array conversion
 *         with copyInto instead of manual
 * 1.0.2 : 990829 windoze fixes
 *         990902 windoze fixes
 */

package framework.ressource.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * UtilPackageResource the package resource information, for one package
 */
public class UtilPackageResource implements /*Sortable,*/Serializable {

  /**
   * initialized with the constructor and may not be
   * modified afterwards
   */
  public final String path;
  /**
   * initialized with the constructor and may not be
   * modified afterwards
   */
  public final String pack;

  /**
   * should not be serialized, this is the file
   * representation of path
   */
  private transient File file=null;

  /**
   * should not be serialized, this is the string representation
   * of this object, better to compute it once
   */
  private transient String string=null;

  /**
   * should not be serialized, this is the prefix name of this package
   */
  private transient String prefixedPack=null;

  /**
   * should not be serialized, this is the list of possible classes
   * in this package
   */
  private transient String[] classNames=null;

  /**
   * should not be serialized, this is a temporary vector
   */
  private transient Vector classList=null;

  /**
   * should not be serialized, this is the table of zip files
   */
  private static transient Hashtable zipTable=new Hashtable();

  /**
   * should not be serialized, this is the table of extension classes
   */
  private transient Hashtable extTable=null;

  /**
   * should not be serialized, this is the lists of classes,
   * top level classes and extension classes of this package, computed when needed
   */
  private transient Class[] classes = null ;
  /**
   * should not be serialized, this is the lists of classes,
   * top level classes and extension classes of this package, computed when needed
   */
  private transient Class[] topClasses = null ;
  /**
   * should not be serialized, this is the lists of classes,
   * top level classes and extension classes of this package, computed when needed
   */
  private transient Class[] extClasses = null ;

  /**
   * contructor: takes the class path and the package name
   */
  public UtilPackageResource(String path,String pack) {
    this.path=path;
    this.pack=pack;
  }

  /**
 * returns a File object to access the class path may be a directory or a zip file
 * @uml.property  name="file"
 */
  public synchronized File getFile() {
    if (file==null)
      file=new File(path);
    return file;
  }

  /**
   * returns the string representation of this object
   */
  public String toString() {
    if (string==null) {
      //if we use string+string, java will transform it to a string bugger, so...
      StringBuffer buffer=new StringBuffer();
      string=buffer.append(path).append(" : package \"").append(pack).append('\"').toString();
    }
    return string;
  }

  /**
   * returns the package prefix of this package: package_name. or ""
   */
  public String getPrefixedPackage() {
    if (prefixedPack==null) {
      if (pack.length()==0)
	prefixedPack="";
      else {
	//if we use string+string, java will transform it to a string bugger, so...
	StringBuffer buffer=new StringBuffer();
	prefixedPack=buffer.append(pack).append('.').toString();
      }
    }
    return prefixedPack;
  }

  /**
 * returns a list of possible classes for this package we say "possible", that means that the classes are not checked! The names are relative to the package
 * @uml.property  name="classNames"
 */
  public synchronized String[] getClassNames() {
    if (classNames==null)
      updateClassNames();
    return classNames;
  }

  /**
 * return the list of classes which are defined in this package
 * @uml.property  name="classes"
 */
  public synchronized Class[] getClasses() {
    if (classes==null) {
      String[] names=getClassNames();
      classList.removeAllElements();
      for(int i=0;i<names.length;i++) {
	try {
	  Class thisClass=framework.ressource.util.UtilReflect.loadClass(makeName(names[i]));//Class.forName(makeName(names[i]));
	  classList.addElement(thisClass);
	}
	catch(Throwable whatever) {}//better for jdk 1.2
      }
      classes=new Class[classList.size()];
      classList.copyInto(classes);
    }
    return classes;
  }

  /**
   * update the class names: useful if they change=reason why it is public
   */
  public synchronized void updateClassNames() {
    classes=null;
    topClasses=null;
    extClasses=null;
    extTable=null;
    File resourceFile=getFile();
    boolean check=path.equals("."); //check if it is "."

    if (classList==null)
      classList=new Vector();
    else
      classList.removeAllElements();

    try {
      if (file.isDirectory()) {
	File dirFile;
        String packPath=pack.replace('.',File.separatorChar);
	//if we use string+string, java will transform it to a string bugger, so...
	StringBuffer buffer=new StringBuffer();
	dirFile=new File(buffer.append(path).append(File.separatorChar).append(packPath).toString());
	String[] list=dirFile.list();
	for(int i=0;i<list.length;i++)
	  if (UtilFile.isExtFile(list[i],".class")) {
	    if (check) {
	      try {
		String thisClassName=UtilFile.shortName(list[i]);
		Class testClass=framework.ressource.util.UtilReflect.loadClass(thisClassName);//Class.forName(thisClassName);
		classList.addElement(thisClassName);
	      }
	      catch(Throwable whatever) {//with java 1.1.5 exception is OK, but not for java 1.2
		//System.out.println(whatever);
	      }
	    }
	    else
	      classList.addElement(UtilFile.shortName(list[i]));
	  }
      }
      else {
	//ZipFile zip=new ZipFile(file);
	/*ZipFile zip=getZipFile(file);
	Enumeration entries=zip.entries();
	while(entries.hasMoreElements()) {
	  ZipEntry entry=(ZipEntry)entries.nextElement();
	  if (!entry.isDirectory()) {
	    String entryName=entry.getName();
	    int lastSeparator=entryName.lastIndexOf(File.separatorChar);
	    if (lastSeparator==packPath.length() &&
		entryName.indexOf(packPath)==0 &&
		UtilFile.isExtFile(entryName,".class"))
	      classList.addElement(entryName.substring(lastSeparator+1,entryName.lastIndexOf('.')));
	  }
	  }*/ //former version
	//zip.close(); //no, since it is in the hash table

        String packPath=pack.replace('.','/'/*File.separatorChar*/);
	ZipEntry[] entries=getZipEntries(file);
	if (pack.length()==0) {
	  for(int i=0;i<entries.length;i++)
	    if (!entries[i].isDirectory()) {
	      String entryName=entries[i].getName();
	      if (entryName.lastIndexOf('/'/*File.separatorChar*/)<0) //no separator
		classList.addElement(entryName.substring(0,entryName.lastIndexOf('.')));
	    }
	}
	else {
	  int pos=0;
	  while(pos<entries.length &&
		(!entries[pos].isDirectory() ||
		 entries[pos].getName().indexOf(packPath)<0)) pos++;
	  pos++;
	  if (pos>=entries.length) { //no directory found??
	    pos=0;
	    //System.out.println("no directory, try weaker with path "+packPath);
	    while(entries[pos].getName().indexOf(packPath)<0) pos++; //weaker
	  }
	  while(pos<entries.length && entries[pos].getName().indexOf(packPath)==0) {
	    String entryName=entries[pos].getName();
	    int lastSeparator=entryName.lastIndexOf('/'/*File.separatorChar*/);
	    if (lastSeparator==packPath.length() &&
		UtilFile.isExtFile(entryName,".class"))
	      classList.addElement(entryName.substring(lastSeparator+1,entryName.lastIndexOf('.')));
	    pos++;
	  }
	}

      }
    }
    catch(Exception whatever) {
      classNames=new String[0];
    }
    int n=classList.size();
    classNames=new String[n];
    classList.copyInto(classNames);
  }

  /**
   * returns the corresponding zip file, null if can not create
   * not public because zipTable should contain only the zip
   * files related to class path resources
   *
  static ZipFile getZipFile(File file) {
    ZipFile zipFile=null;
    synchronized(zipTable) {
      zipFile=(ZipFile)zipTable.get(file);
      if (zipFile==null) {
	try {
	  zipFile=new ZipFile(file);
	  zipTable.put(file,zipFile);
	}
	catch(Exception whatever) {}
      }
    }
    return zipFile;
    }*/ //former version

  /**
   * returns the corresponding sorted entry list of the corresponding
   * zip file, null if there is a problem. Not public because zipTable
   * should contain only zip entries related to class path resources
   */
  static ZipEntry[] getZipEntries(File file) {
    ZipEntry[] entries=null;
    synchronized(zipTable) {
      entries=(ZipEntry[])zipTable.get(file);
      if (entries==null) {
	try{
	  //System.out.println("********* create entry for "+file);
	  ZipFile zip=new ZipFile(file);
	  Enumeration all=zip.entries();
	  //zip.close(); //does not work under Windoze, move it!
	  //this sucks: one can not even know how many entries there are!
	  Vector list=new Vector();
	  while(all.hasMoreElements())
	    list.addElement(all.nextElement());
	  entries=new ZipEntry[list.size()];
	  list.copyInto(entries);
	  //System.out.print("********* sorting ...");
	  //System.out.flush();
	  Sorter.sortI(entries,0,entries.length-1);
	  //System.out.println("********* done");
	  zipTable.put(file,entries);
	  //here windoze is happy
	  zip.close();
	}
	catch(Exception e){}
      }
    }
    return entries;
  }

  /**
 * returns the list of top level (super) classes of this package: the classes which are not extensions of other classes inside this package
 * @uml.property  name="topClasses"
 */
  public synchronized Class[] getTopClasses() {
    if (topClasses==null) {
      Class[] allClasses=getClasses();
      classList.removeAllElements();
      for(int i=0;i<allClasses.length;i++)
	if (!isClassPresent(allClasses[i].getSuperclass(),allClasses))
	  classList.addElement(allClasses[i]);
      topClasses=new Class[classList.size()];
      classList.copyInto(topClasses);
    }
    return topClasses;
  }

  /**
 * returns the list of all extension classes of this package
 * @uml.property  name="extClasses"
 */
  public synchronized Class[] getExtClasses() {
    if (extClasses==null) {
      Class[] allClasses=getClasses();
      classList.removeAllElements();
      for(int i=0;i<allClasses.length;i++)
	if (isClassPresent(allClasses[i].getSuperclass(),allClasses))
	  classList.addElement(allClasses[i]);
      extClasses=new Class[classList.size()];
      classList.copyInto(extClasses);
    }
    return extClasses;
  }

  /**
   * returns true if the class in argument is in this package
   * the test is done on the classes found in this UtilPackageResource
   */
  public boolean hasClass(Class aClass) {
    return isClassPresent(aClass,getClasses());
  }

  /**
   * returns true if the class in argument is in the class list
   * given in argument, null is not a valid class
   */
  public static boolean isClassPresent(Class aClass,Class[] allClasses) {
    if (aClass==null || allClasses==null)
      return false;
    for(int i=0;i<allClasses.length;i++)
      if (aClass.equals(allClasses[i]))
	return true;
    return false;
  }

  /**
   * returns the list of extensions of the specified class within this UtilPackageResource
   */
  public synchronized Class[] extensionsOf(Class aClass) {
    if (aClass==null)
      return new Class[0];
    if (extTable==null)
      extTable=new Hashtable();

    Class[] extensions=(Class[])extTable.get(aClass);
    if (extensions==null) {
      Class[] allClasses=getClasses();
      classList.removeAllElements();
      for(int i=0;i<allClasses.length;i++)
	if (aClass.equals(allClasses[i].getSuperclass()))
	  classList.addElement(allClasses[i]);
      extensions=new Class[classList.size()];
      classList.copyInto(extensions);
      extTable.put(aClass,extensions);
    }
    return extensions;
  }

  /**
   * returns the list of extensions of the specified class within this UtilPackageResource, the name
   * may be relative or absolute
   */
  public Class[] extensionsOf(String name) {
    try {
      return extensionsOf(framework.ressource.util.UtilReflect.loadClass(makeName(name)));//extensionsOf(Class.forName(makeName(name)));
    }
    catch(Exception e1) {
      try {
	return extensionsOf(framework.ressource.util.UtilReflect.loadClass(name));//extensionsOf(Class.forName(name));
      }
      catch(Exception e2) {
	return new Class[0];
      }
    }
  }

  /**
   * returns the absolute name, from the relative name
   */
  public String makeName(String name) {
    String prefix=getPrefixedPackage();
    StringBuffer buffer=new StringBuffer();
    return buffer.append(prefix).append(name).toString();
  }

  /**
   * returns true if the specified class does not have any extensions in this UtilPackageResource
   */
  public boolean isTerminal(Class aClass) {
    return (extensionsOf(aClass).length==0);
  }

  /**
   * opens the stream corresponding to the class name ; null if not found
   */
  public InputStream openStream(String className) {
    //System.out.println(this+".openStream("+className+")");
    String[] names=getClassNames();
    for(int i=0;i<names.length;i++)
      if (names[i].equals(className)) {
	//System.out.println(className+" found in "+this);
	ZipFile zip=null;
	try {
	  File file=getFile();
	  String path=pack.replace('.',File.separatorChar);
	  if (path.length()>0)
	    path+=File.separator;
	  String filename=path+className+".class";
	  if (file.isDirectory())
	    return new FileInputStream(new File(file,filename));
	  else {
	    zip=new ZipFile(file);
	    if (UtilPackage.windoze) //correct to look inside zip files
		filename=filename.replace(File.separatorChar,'/');
	    return zip.getInputStream(zip.getEntry(filename));
	  }
	}
	catch(Exception e) {
	  System.err.println(e);
	  try{zip.close();}catch(Exception whatever){}
	  return null;
	}
      }
    return null;
  }

  /**
   * implements Sortable
   */
  public boolean isLessThan(Sortable s) {
    return (pack.compareTo(((UtilPackageResource)s).pack)<0);
  }
  public boolean isGreaterThan(Sortable s) {
    return (pack.compareTo(((UtilPackageResource)s).pack)>0);
  }
  public boolean equals(Sortable s) {
    return pack.equals(((UtilPackageResource)s).pack);
  }

}
