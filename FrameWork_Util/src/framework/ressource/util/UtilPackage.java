package framework.ressource.util;

import java.io.File;
import java.io.FileFilter;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.zip.ZipEntry;

import framework.ressource.util.classbean.CPackage;
import java.util.ArrayList;
import java.util.zip.ZipFile;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author non attribuable
 * @version 1.0
 */

public class UtilPackage {

  public final static boolean windoze=(File.separatorChar=='\\');
  public static boolean trace = false;

  protected UtilPackage() {
  }

  /**
   * this computes the packages found in
   * the virtual machine. This loads the zip file
   * and explores the directories. The previous functions
   * test if the entries are valid or not.
   *
   * DRO: List of CPackage class
   */
  public static Vector getListPackageClassPath() {
    String listpath = System.getProperty("java.class.path");
    //System.out.println(Sorter.toString(listpath));
    String[] classPaths = getUniqueStrings(new StringTokenizer(listpath, File.pathSeparator));
    StringBuffer buffer=new StringBuffer(256);
    Vector ret = new Vector();

    for (int i = 0; i < classPaths.length; i++) {
      String item = classPaths[i];
      CPackage cPackage = new CPackage();
      cPackage.setPack(item);
      cPackage.setPath(UtilFile.pathName(item));
      cPackage.setName(UtilFile.fileName(item));
      ret.add(cPackage );
    }
    return ret;
  }

  public static String getPackageClassPath() {
/*
    StringBuffer ret = new StringBuffer();
    Vector listClassPath = UtilPackage.getListPackageClassPath();
    for(int i=0 ; i<listClassPath.size() ; i++)
      ret.append(((CPackage)listClassPath.elementAt(i)).getPack()).append(";");
    return ret.toString();
*/
    return System.getProperty("java.class.path");
  }

  /**
   * this computes the packages found in
   * the virtual machine. This loads the zip file
   * and explores the directories. The previous functions
   * test if the entries are valid or not.
   */
  public static String[] getClassPathResources() {
    String listpath = System.getProperty("java.class.path");
    //System.out.println(Sorter.toString(listpath));
    return getUniqueStrings(new StringTokenizer(listpath, File.pathSeparator));
  }

  /**
   * this computes the packages found in
   * the virtual machine. This loads the zip file
   * and explores the directories. The previous functions
   * test if the entries are valid or not.
   */
  public static Vector computePackageResources() {
    String[] classPaths = getClassPathResources();
    Vector ret = new Vector();

    for (int i = 0; i < classPaths.length; i++) {
      String path = classPaths[i];
      Vector list = computePackageResources(path);
      // DRO: TRACE
      if (trace) {
        StringBuffer buffer=new StringBuffer(256);
        buffer.setLength(0);
        buffer.append("class path ").append(i + 1).append(File.separatorChar).append(classPaths.length).append(" : ").
            append(path);
        System.out.println(buffer.toString());
      }
      // Copie de la liste
      for(int j=0 ; j<list.size() ; ret.add(list.elementAt(j++)));
    }
    return ret;
  }

  public static Vector computePackageResources(String path) {
    Vector ret = new Vector();
    StringBuffer buffer = new StringBuffer(256);
    File file = new File(path);
    if (file.exists()) {

      if (file.isDirectory()) {
        //URL url=new URL("systemresource:/FILE"+i+"/+/.");
        if (notEmpty(path, file, ret)) {
          UtilPackageResource res = new UtilPackageResource(path, "");
          ret.addElement(res);
          packEcho(res);
        }
      }
      else {
        try {
          //ZipFile zip=new ZipFile(file);
          /*ZipFile zip=UtilPackageResource.getZipFile(file);
                     Vector entryNames=new Vector();
                     Vector entryDir=new Vector();
                     Enumeration entries=zip.entries();
                     while(entries.hasMoreElements()) {
            ZipEntry entry=(ZipEntry)entries.nextElement();
            if (entry.isDirectory())
              entryDir.addElement(entry.getName());
            else
              entryNames.addElement(entry.getName());
                     }
                     int nNames=entryNames.size();
                     int nDir=entryDir.size();
                     for(int j=0;j<nDir;j++) {
            String nameDir=(String)entryDir.elementAt(j);
            //URL url=new URL("systemresource:/ZIP"+i+"/+/"+nameDir);
            String pack=nameDir.replace(File.separatorChar,'.');
            pack=pack.substring(0,pack.length()-1);
            if (notEmpty(entryNames,nameDir,pack,nNames)) {
              UtilPackageResource res=new UtilPackageResource(path,pack);
              ret.addElement(res);
              packEcho(res);
            }
                     }*/
          //this was the former version
          //zip.close(); //no, since it is in a hash table

          //zip files should not contain a drive name as c:\...
          ZipEntry[] entries = UtilPackageResource.getZipEntries(file);
          Vector restPack = new Vector(), passed = new Vector();
          if (entries != null) {
            for (int j = 0; j < entries.length; j++)
              if (entries[j].isDirectory()) {
                String nameDir = entries[j].getName();
                //System.out.println("dir:"+nameDir);
                String pack = nameDir.replace('/' /*File.separatorChar*/, '.');
                passed.addElement(nameDir);
                pack = pack.substring(0, pack.length() - 1);
                if (notEmpty(entries, nameDir, j + 1, pack)) {
                  UtilPackageResource res = new UtilPackageResource(path, pack);
                  ret.addElement(res);
                  packEcho(res);
                }
              }
              else {
                String filename = entries[j].getName();
                //System.out.println("file:"+filename);
                int index = filename.lastIndexOf('/' /*File.separatorChar*/);
                filename = filename.substring(0, index + 1);
                if (!restPack.contains(filename))
                  restPack.addElement(filename);
              }

            int n = restPack.size();
            for (int j = 0; j < n; j++)
              if (!passed.contains(restPack.elementAt(j))) {
                //System.out.println("not taken:"+restPack.elementAt(j)+" from "+file);
                UtilPackageResource res = tryPackageResource( (String) restPack.elementAt(j), entries, path);
                if (res != null) {
                  //System.out.println("take "+restPack.elementAt(j));
                  ret.addElement(res);
                  packEcho(res);
                }
              }
          }

        }
        catch (Exception e) {
          //System.err.println(e);
        }
      }
    }
// DRO: quel est l'interet ???
//    ret.copyInto(new UtilPackageResource[ret.size()]);
    return ret;
  }

  public static Vector computePackageResources(String path, String pack) {
    Vector ret = new Vector();
    StringBuffer buffer = new StringBuffer(256);
    File file = new File(path);
    if (file.exists()) {

      if (file.isDirectory()) {
        //URL url=new URL("systemresource:/FILE"+i+"/+/.");
        if (notEmpty(path, file, ret)) {
          UtilPackageResource res = new UtilPackageResource(path, "");
          ret.addElement(res);
          packEcho(res);
        }
      }
      else {
        try {
          String packPath = pack.replace('.', '/' /*File.separatorChar*/);
          //zip files should not contain a drive name as c:\...
          ZipEntry[] entries = UtilPackageResource.getZipEntries(file);
          ZipFile zip = new ZipFile(file);
          ZipEntry entriePack= zip.getEntry(packPath);
          if (entriePack!=null) {
            if (entriePack.isDirectory()) {

            }
          }
          Vector restPack = new Vector(), passed = new Vector();
          if (entries != null) {
            for (int j = 0; j < entries.length; j++)
              if (entries[j].isDirectory()) {
                String nameDir = entries[j].getName();
                //System.out.println("dir:"+nameDir);
                if (notEmpty(entries, nameDir, j + 1, pack)) {
                  UtilPackageResource res = new UtilPackageResource(path, pack);
                  ret.addElement(res);
                  packEcho(res);
                }
              }
              else {
                String filename = entries[j].getName();
                //System.out.println("file:"+filename);
                int index = filename.lastIndexOf('/' /*File.separatorChar*/);
                filename = filename.substring(0, index + 1);
                if (!restPack.contains(filename))
                  restPack.addElement(filename);
              }

            int n = restPack.size();
            for (int j = 0; j < n; j++)
              if (!passed.contains(restPack.elementAt(j))) {
                //System.out.println("not taken:"+restPack.elementAt(j)+" from "+file);
                UtilPackageResource res = tryPackageResource( (String) restPack.elementAt(j), entries, path);
                if (res != null) {
                  //System.out.println("take "+restPack.elementAt(j));
                  ret.addElement(res);
                  packEcho(res);
                }
              }
          }
        }
        catch (Exception e) {
          //System.err.println(e);
        }
      }
    }
// DRO: quel est l'interet ???
//    ret.copyInto(new UtilPackageResource[ret.size()]);
    return ret;
  }

  public static Vector computePackageClasses(CPackage pack, String packPath) {
    Vector ret = new Vector();
    StringBuffer buffer = new StringBuffer(256);
    File file = new File(pack.getPack());
    if (file.exists()) {
      if (file.isDirectory()) {
        String path = pack.getPack();
        if (!path.endsWith(File.separator))
          path += File.separator;
        if (packPath != null)
          path += getClassNameToFileName(packPath);
        int iPathLen = path.length();
        file = new File(path);
        File[] fileList = file.listFiles(new FileFilter() {
          public boolean accept(File file) {
            return UtilFile.isExtFile(file.getName(), ".class");
          }
        });
        for (int i = 0; i < fileList.length; i++) {
          File fileItem = fileList[i];
          String filename = packPath + "." + fileItem.getName();
          ret.addElement(getFileNameToClassName(filename));
        }
        Sorter.sortI(ret);
      }
      else {
        try {
          ZipEntry[] entries = UtilPackageResource.getZipEntries(file);
          if (entries != null) {
            for (int j = 0; j < entries.length; j++) {
              if (!entries[j].isDirectory()) {
                String filename = entries[j].getName();
                if (UtilFile.isExtFile(filename, ".class")) { // Transforme le chemin du fichier en chemin
                  // de la classe et Supprime l'extention
                  filename = getFileNameToClassName(filename);
                  if ( (UtilPackage.isPathClass(filename, packPath)) || (packPath == null)) {
                    ret.addElement(filename);
                  }
                }
              }
            }
          }
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return ret;
  }

  /**
   * returns true if the string name start with path
   */
  public static boolean isPathClass(String name, String path) {
    int index = name.lastIndexOf('.');
    if (index < 0)
      return name.equals(path);
    else
      return name.substring(0, index).equals(path);
  }

  public static String getFileNameToClassName(String path) {
    String ret = new String(path);
    if (UtilFile.isExtFile(ret, ".class"))
      ret = UtilFile.shortName(ret);
    return getFilePathToPackPath(ret);
  }

  public static String getClassNameToFileName(String cls) {
    String ret = new String(cls);
    return ret.replace('.', File.separatorChar);
  }

  public static String getFilePathToPackPath(String file) {
    String ret = new String(file);
    ret.replace('\\', '.');
    return ret.replace('/', '.');
  }

    /**
     * @return an array of unique strings got from the
     * tokenizer
     * @param tokenizer the tokenizer to get string from
     */
  private static String[] getUniqueStrings(StringTokenizer tokenizer) {
    Vector result = new Vector();
    while (tokenizer.hasMoreTokens()) {
      String string = tokenizer.nextToken();
      if (!result.contains(string))
        result.addElement(string);
    }
    int n = result.size();
    String[] strings = new String[n];
    result.copyInto(strings);
    //System.out.println(Sorter.toString(strings));
    return strings;
  }
  /**
   * this function basically tests a path from a zip file entry list to
   * know if this path can be a valid package entry, i.e. if it contains valid classes.
   * @return true if the entry is recognized as a sub package entry
   * @param entries the zip entries to look at
   * @param path the sub package entry to validate
   * @param i where to begin the search, to speed up the process: the principle
   * is that we used this on a sorted list of entries so that assumption on the
   * location of a possible class is valid, which is we do not have to look at
   * the entire list of entries. Of course, we have to sort the list in n*log(n)
   * but we need to do this for each directory entry (or all possible entries
   * which can be sub-package entries).
   * @param pack the package name
   */
  private static boolean notEmpty(ZipEntry[] entries, String path, int i, String pack) {
    pathEcho(path);
    for (; i < entries.length; i++) {
      String filename = entries[i].getName();
      //System.out.println("path: "+path+", try "+filename+" for pack="+pack);
      if (filename.lastIndexOf('/' /*File.separatorChar*/) == pack.length()
          && filename.indexOf(path) == 0) {
        if (UtilFile.isExtFile(filename, ".class")) {
          try {
            //sun.jws.Debugger.Agent makes crash
            //System.out.println(filename+"?");
/*
            Class thisClass = Class.forName(UtilFile.shortName(
                filename.replace('/' /*File.separatorChar*-/, '.')));
*/
            Class thisClass = framework.ressource.util.UtilReflect.loadClass(UtilFile.shortName(
                filename.replace('/' /*File.separatorChar*/, '.')));
            //System.out.println("OK:"+filename);
            return true;
          }
          catch (Throwable e) {
            //System.err.println(e);
          }
        }
      }
      else
        return false;
    }
    return false;
  }

  /**
   * this is the equivalent of the previous notEmpty, but for directories
   * this time.
   * @return true if the path is recognized as a sub-package entry
   * @param path the sub package location, absolute path
   * @param dir the directory to look at
   * @param ret to register the packages which were found
   */
  private static boolean notEmpty(String path, File dir, Vector ret) {
    String[] list = dir.list();
    boolean empty = !dir.getPath().equals(".");
    //if the path is "." then it is not empty because this
    //depends on where it is executed, so we take this package
    //by default, so that it is always present

    String dirName = dir.getPath();
    int cutindex = path.length();
    if (dirName.length() > cutindex) {
      //the if is there because of different behaviours of java
      //or because a forgotten bug ;), oh yes in case of // in the path
      //but does not work for ///, who's got /// in his path???
      if (dirName.charAt(cutindex) == File.separatorChar)
        dirName = dirName.substring(++cutindex);
      else
        dirName = dirName.substring(cutindex + 1);
    }
    else
      dirName = "";
    pathEcho(dirName);

    if (list == null) {
      System.err.println("Could not get list of " + dir);
      return false;
    }

    for (int i = 0; i < list.length; i++) {
      String filename = list[i];
      File file = new File(dir, filename);
      //not very efficient here, I have to change this later
      String packPath = file.getPath().substring(cutindex);
      String pack = packPath.replace(File.separatorChar, '.');
      if (empty && !file.isDirectory()
          && UtilFile.isExtFile(filename, ".class")) {
        pack = UtilFile.shortName(pack);
        try {
          //System.out.println("Trying "+pack+" path="+path+" packpath="+packPath);
          Class thisClass = framework.ressource.util.UtilReflect.loadClass(pack);//Class.forName(pack);
          empty = false;
        }
        catch (Throwable e) {
          //System.err.println(e);
          //if windoze the path is upper-cased!
          if (windoze) {
            //try with lower cases!
            int lastdot = pack.lastIndexOf('.');
            if (lastdot >= 0) {
              String origpack = pack.substring(0, lastdot);
              String newpack = origpack.toLowerCase();
              pack = newpack + pack.substring(lastdot);
              try {
                Class thisClass = framework.ressource.util.UtilReflect.loadClass(pack);//Class.forName(pack);
                empty = false;
              }
              catch (Throwable ee) { //no hope now!
              }
            }
          }
        }
      }
      else if (file.isDirectory()) {
        //URL url=new URL("systemresource:/FILE"+index+"/+/"+packPath);
        if (notEmpty(path, file, ret)) {
          UtilPackageResource res;
          if (windoze)
            res = new UtilPackageResource(path, pack/*.toLowerCase()*/);
          else
            res = new UtilPackageResource(path, pack);
          ret.addElement(res);
          packEcho(res);
        }
      }
    }
    return (!empty);
  }


  /**
   * try to find a package which is located in path, in the zip entries entries
   * beginning with the path pathName in the package.
   * @param pathName sub package path
   * @param entries the zip entries of the zip class to look at
   * @param path the location of the zip file in fact
   */
  static UtilPackageResource tryPackageResource(String pathName, ZipEntry[] entries, String path) {
    int sep = pathName.length() - 1;
    for (int i = 0; i < entries.length; i++) {
      String name = entries[i].getName();
      //System.out.println("from "+pathName+" ->"+name);
      if (!entries[i].isDirectory() &&
          (sep < 0 || (name.lastIndexOf('/' /*File.separatorChar*/) == sep &&
                       name.indexOf(pathName) == 0)) &&
          UtilFile.isExtFile(name, ".class")) {
        try {
/*
          Class thisClass = Class.forName(UtilFile.shortName(
              name.replace('/' /*File.separatorChar*-/, '.')));
*/
          Class thisClass = framework.ressource.util.UtilReflect.loadClass(UtilFile.shortName(
              name.replace('/' /*File.separatorChar*/, '.')));
          //System.out.println("got "+pathName);
          return new UtilPackageResource(path,
                                     (sep < 0) ? "" :
                                     pathName.substring(0, sep).replace('/' /*File.separatorChar*/, '.'));
        }
        catch (Throwable whatever) {}
      }
    }
    return null;
  }

  private static void pathEcho(String path) {
    if (trace)
      System.out.println("CLASSPATH: "+path);
  }

  /**
   * prints information on the current package if the label
   * is set to some non null value.
   */
  private static void packEcho(UtilPackageResource resource) {
    if (trace)
      System.out.println("Package "+resource.pack);
  }


}
