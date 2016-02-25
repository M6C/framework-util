package framework.ressource.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.Vector;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author non attribuable
 * @version 1.0
 */

public class UtilFile {
  protected UtilFile() {
  }

  /**
   * returns true if the string name ends with extension ext
   */
  public static boolean isExtFile(String name, String ext) {
    boolean ret = false;
    int index = name.lastIndexOf('.');
    if (index > -1) {
      String nameExt = name.substring(index);
      String[] listExt = UtilString.split(ext, ';');
      for( int i=0 ; (i<listExt.length)&&(!ret) ; i++ ) {
        ret = nameExt.equalsIgnoreCase(listExt[i]);
      }
    }
    return ret;
  }

  /**
   * returns true if the string name start with path
   */
  public static boolean isPathFile(String name, String path) {
    int index = name.lastIndexOf('\\');
    if (index < 0) index = name.lastIndexOf('/');
    if (index < 0)
      return name.equals(path);
    else
      return name.substring(0, index).equals(path);
  }

  /**
   * returns the short name of the string name, which is the name without
   * the last extension beginning with a dot.
   */
  public static String shortName(String name) {
    int index=name.lastIndexOf('.');
    if (index<0)
      return name;
    else
      return name.substring(0,index);
  }

  /**
   * returns the file name of the string name, which is the name without
   * the path.
  */
  public static String fileName(String name) {
    name = (name.endsWith(File.separator) ? name.substring(0, name.length()-File.separator.length()) : name);
    int index=name.lastIndexOf(File.separatorChar);
    if (index<0)
      return name;
    else
      return name.substring(index+1);
  }

  /**
   * returns the path name of the string name, which is the complete path
   * without the file name.
   */
  public static String pathName(String name) {
    int index = name.lastIndexOf(File.separatorChar);
    if (index < 0)
      return name;
    else
      return name.substring(0, index);
  }

  public static String formatPath(String path, String fileName) {
	String ret = path;
//	if (UtilString.isNotEmpty(path))
//	  ret = (path.endsWith(File.separator)) ? ret : ret + File.separator;
//	if (UtilString.isNotEmpty(fileName))
//	  ret += fileName;
  if (UtilString.isNotEmpty(fileName))
    ret = new File(new File(path), fileName).getPath();
	return ret;
  }

  public static String formatPath(String path) {
	return (new File(path).isDirectory()) ? formatDirectory(path) : path;
  }

  public static String formatDirectory(String path) {
    String ret = path;
    if (UtilString.isNotEmpty(path)&&(new File(path).isDirectory()))
      ret = (path.endsWith(File.separator)) ? ret : ret + File.separator;
    return ret;
  }

  public static Vector dir(String path) throws IOException {
    return dir(path, false);
  }

  public static Vector dir(String path, boolean recursive) throws IOException {
    return dir(path, recursive, null);
  }

  public static Vector dir(String path, boolean recursive, String ext) throws
      IOException {
    return dir(path, recursive, ext, false);
  }

  public static Vector dir(String path, boolean recursive, String ext, boolean relative) throws IOException {
    return dir(path, recursive, ext, relative, false);
  }

  public static Vector dir(String path, boolean recursive, final String ext, boolean relative, boolean withSubDirectory) throws IOException {
    FilenameFilter filenameFilter = new FilenameFilter() {
      public boolean accept(File file, String string) {
        return UtilFile.isExtFile(string, ext);
      }
    };
    return dir(path, recursive, filenameFilter, relative, withSubDirectory);
  }

  public static Vector dir(String path, boolean recursive, FilenameFilter filenameFilter, boolean relative, boolean withSubDirectory) throws IOException {
    Vector ret = new Vector();
    Vector tmp = new Vector();
//    boolean bFiltre = UtilString.isNotEmpty(ext);
    tmp.addElement(path);
    if (withSubDirectory && !relative)
        ret.addElement(path);
    for( int i=0 ; i<tmp.size() ; i++ ) {
      File f = new File((String)tmp.elementAt(i));
//      File[] fList = f.listFiles(filenameFilter);
      File[] fList = f.listFiles(filenameFilter);
      if (fList!=null) {
        for (int j=0 ; j<fList.length ; j++) {
          String szName = fList[j].getCanonicalPath();
          if (fList[j].isDirectory()) {
            if (withSubDirectory) {
              if (relative)
                szName = szName.substring(path.length()+1);
              ret.addElement(szName);
            }
            if (recursive)
              tmp.addElement(szName);
          }
          else {
            if (relative)
              szName = szName.substring(path.length()+1);
//            if ((!bFiltre)||(isExtFile(szName, ext)))
              ret.addElement(szName);
          }
        }
      }
    }
    return ret;
  }

  public static Vector dirFile(String path) {
    return dirFile(path, false);
  }

  public static Vector dirFile(String path, boolean recursive) {
    return dirFile(path, recursive, null);
  }

  public static Vector dirFile(String path, boolean recursive, String ext) {
    return dirFile(path, recursive, ext, false);
  }

  /**
   * 
   * @param path
   * @param recursive
   * @param ext
   * @param relative LE CHEMIN RELATIF NE FONCTIONNE PAS
   * @return
   */
  public static Vector dirFile(String path, boolean recursive, String ext, boolean relative) {
    return dirFile(path, recursive, ext, relative, false);
  }

  /**
   * 
   * @param path
   * @param recursive
   * @param ext
   * @param relative LE CHEMIN RELATIF NE FONCTIONNE PAS
   * @param withSubDirectory
   * @return
   */
  public static Vector dirFile(String path, boolean recursive, String ext, boolean relative, boolean withSubDirectory) {
    return dirFile(path, recursive, ext, relative, withSubDirectory, true);
  }

  /**
   * 
   * @param path
   * @param recursive
   * @param ext
   * @param relative LE CHEMIN RELATIF NE FONCTIONNE PAS
   * @param withSubDirectory
   * @param withFileContent
   * @return
   */
  public static Vector dirFile(String path, boolean recursive, final String ext, boolean relative, boolean withSubDirectory, boolean withFileContent) {
    FilenameFilter filenameFilter = new FilenameFilter() {
      public boolean accept(File file, String string) {
        return (UtilString.isEmpty(ext) || UtilFile.isExtFile(string, ext));
      }
    };
    return dirFile(path, recursive, filenameFilter, relative, withSubDirectory, withFileContent);
  }

  /**
   * 
   * @param path
   * @param recursive
   * @param filenameFilter
   * @param relative LE CHEMIN RELATIF NE FONCTIONNE PAS
   * @param withSubDirectory
   * @param withFileContent
   * @return
   */
  public static Vector dirFile(String path, boolean recursive, FilenameFilter filenameFilter, boolean relative, boolean withSubDirectory, boolean withFileContent) {
    Vector ret = new Vector();
    Vector tmp = new Vector();
//    boolean bFiltre = UtilString.isNotEmpty(ext);
    tmp.addElement(path);
    if (withSubDirectory && !relative)
        ret.addElement(new File(path));
    for( int i=0 ; i<tmp.size() ; i++ ) {
      File f = new File((String)tmp.elementAt(i));
//      File[] fList = f.listFiles();
      File[] fList = f.listFiles(filenameFilter);
      if (fList!=null) {
        for (int j=0 ; j<fList.length ; j++) {
          String szName = fList[j].getAbsolutePath();
          if (fList[j].isDirectory()) {
            if (withSubDirectory) {
              ret.addElement(fList[j]);
            }
            if (recursive)
              tmp.addElement(szName);
          }
          else {
            if (relative)
              szName = szName.substring(path.length()+1);
//            if (withFileContent && ((!bFiltre)||(isExtFile(szName, ext))))
            if (withFileContent)
              ret.addElement(fList[j]);
          }
        }
      }
    }
    return ret;
  }

  public static void copyFile(String in, String out) throws Exception {
    copyFile(new File(in), new File(out));
  }
  public static void copyFile(File in, String out) throws Exception {
    copyFile(in, new File(out));
  }
  public static void copyFile(File in, File out) throws Exception {
    String szOut = out.getCanonicalPath();
    new File(szOut.substring(0, szOut.lastIndexOf(File.separatorChar))).mkdirs();
    if (!out.exists()) out.createNewFile();
    FileChannel sourceChannel = new FileInputStream(in).getChannel();
    FileChannel destinationChannel = new FileOutputStream(out).getChannel();
    sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
    sourceChannel.close();
    destinationChannel.close();
  }
  public static void renameFile(String oldName, String newName) throws Exception {
    renameFile(new File(oldName), new File(newName));
  }
  public static void renameFile(File oldFile, String newName) throws Exception {
    renameFile(oldFile, new File(newName));
  }
  public static void renameFile(File oldFile, File newFile) throws Exception {
    oldFile.renameTo(newFile);
  }
  public static void deleteFile(String name) throws Exception {
    deleteFile(new File(name));
  }
  public static void deleteFile(File file) throws Exception {
    file.delete();
  }

  public static void sortByPathDepth(File[] fileList) {
    Arrays.sort(fileList, new Comparator() {
      public int compare(Object object, Object object1) {
        int ret = 0;
        try {
          String path1 = ((File)object).getCanonicalPath();
          String path2 = ((File)object1).getCanonicalPath();
          int path1Depth = UtilString.countOf(path1, File.separatorChar);
          int path2Depth = UtilString.countOf(path2, File.separatorChar);
          if(path1Depth==path2Depth)
            ret = path2.compareTo(path1);
          else
            ret = path2Depth-path1Depth;
        }
        catch (IOException ex) {}
        return ret;
      }
      public boolean equals(Object object) {
        return false;
      }
    });
  }

  public static void sortByPathDepthAscendant(File[] fileList) {
    Arrays.sort(fileList, new Comparator() {
      public int compare(Object object, Object object1) {
        int ret = 0;
        try {
          String path1 = ((File)object).getCanonicalPath();
          String path2 = ((File)object1).getCanonicalPath();
          int path1Depth = UtilString.countOf(path1, File.separatorChar);
          int path2Depth = UtilString.countOf(path2, File.separatorChar);
          if(path1Depth==path2Depth)
            ret = path1.compareTo(path2);
          else
            ret = path1Depth-path2Depth;
        }
        catch (IOException ex) {}
        return ret;
      }
      public boolean equals(Object object) {
        return false;
      }
    });
  }

  public static int findText(File file, String text) throws FileNotFoundException, IOException {
    int ret = 0;
    boolean find = false;
    BufferedReader in = new BufferedReader(new FileReader(file)) ;
    String line = null;
    int index = 0;
    while(((line=in.readLine())!=null) && !find){
      index = line.indexOf(text);
      find = index>=0;
      ret += find ? index : line.length();
    }
    return find ? ret : -1;
  }

  public static int findLine(File file, String text) throws FileNotFoundException, IOException {
    int ret = -1;
    boolean find = false;
    BufferedReader in = new BufferedReader(new FileReader(file)) ;
    String line = null;
    while(((line=in.readLine())!=null) && !find){
      find = UtilString.isEquals(line, text);
      if (!find)
        ret++;
    }
    return find ? ret : -1;
  }

  public static String read(File file) throws FileNotFoundException, IOException {
    StringBuffer ret = new StringBuffer();
    BufferedReader in = new BufferedReader(new FileReader(file)) ;
    String line = null;
    while((line=in.readLine())!=null){
		ret.append(line).append("\r\n");
    }
    return ret.toString();
  }

  public static void write(File file, String text) throws FileNotFoundException, IOException {
	  BufferedWriter out = new BufferedWriter(new FileWriter(file));
	  out.write(text);
	  out.close();
  }

  public static String getPathRelative(File rootFile, File file) {
    String ret = null;
/*
    boolean absolute =	(File.separatorChar=='\\' && (file.getPath().indexOf(":/")>0) || (file.getPath().indexOf(":\\")>0)) ||
    					// MODIF Pour Google App Engine
    					(File.separatorChar=='/' && file.getPath().startsWith(File.separator));
    if (absolute) {
	    if (rootFile!=null) {
	      String filePath = null;
	      String rootFilePath = null;
	      try {filePath = file.getCanonicalPath();} catch(Exception ex) {filePath = file.getAbsolutePath();}
	      try {rootFilePath = rootFile.getCanonicalPath();} catch(Exception ex) {rootFilePath = rootFile.getAbsolutePath();}
	      if (filePath.startsWith(rootFilePath))
	          ret = filePath.substring(rootFilePath.length());
	    }
    }
    else {
    	ret = file.getPath();
    }

    // MODIF Pour Google App Engine
    if (ret.startsWith(File.separator))
    	ret = ret.substring(1);
*/
    if (rootFile!=null) {
    	String filePath = null;
    	String rootFilePath = null;
    	try {filePath = file.getCanonicalPath();} 
    	catch(Exception ex) {filePath = file.getAbsolutePath();}
    	try {rootFilePath = rootFile.getCanonicalPath();} 
    	catch(Exception ex) {rootFilePath = rootFile.getAbsolutePath();}
    	if (filePath.startsWith(rootFilePath))
    		ret = filePath.substring(rootFilePath.length());
    	else
    		ret = file.getPath();
    }
    else {
        boolean absolute =	(File.separatorChar=='\\' && (file.getPath().indexOf(":/")>0) || (file.getPath().indexOf(":\\")>0)) ||
							// MODIF Pour Google App Engine
							(File.separatorChar=='/' && file.getPath().startsWith(File.separator));
		if (absolute)
	    	ret = file.getPath();
    }

    return ret;
  }
  static public boolean delete(File path) {
	    boolean resultat = true;
	    if(path.exists()) {
	      if (path.isDirectory()) {
	        File[] files = path.listFiles();
	        for(int i=0; i<files.length; i++) {
	            resultat &= delete(files[i]);
	        }
	      }
	      resultat &= path.delete();
	    }
	    return(resultat);
	  }
}
