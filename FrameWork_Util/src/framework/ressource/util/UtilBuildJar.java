package framework.ressource.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipException;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */

public class UtilBuildJar {

  public static final int MODERN_COMPILER_SUCCESS = 0;

  public UtilBuildJar() {
  }

  public static void build(String pathMain, String[] listPathCls, String[] listPathTo, String szJarFile) throws FileNotFoundException, IOException {
    if ((UtilString.isNotEmpty(szJarFile))&&
    	(listPathCls!=null)) {
      OutputStream out = new FileOutputStream(szJarFile);
      JarOutputStream outJar = new JarOutputStream(out);
      String path = null;
      for (int i = 0; i < listPathCls.length; i++) {
        path = UtilFile.formatPath(pathMain, listPathCls[i]);
        build(outJar, path, listPathTo[i], szJarFile);
      }
      // Fermeture du Jar
      outJar.finish();
      // Fermeture du flux d'ecriture
      out.close();
    }
  }

  public static void build(String[] listPathCls, String[] listPathSrcTo, String szJarFile) throws FileNotFoundException, IOException {
    if ((UtilString.isNotEmpty(szJarFile))&&
        	(listPathCls!=null)) {
      OutputStream out = new FileOutputStream(szJarFile);
      JarOutputStream outJar = new JarOutputStream(out);
      String path = null;
      for (int i = 0; i < listPathCls.length; i++) {
        build(outJar, listPathCls[i], listPathSrcTo[i], szJarFile);
      }
      // Fermeture du Jar
      outJar.finish();
      // Fermeture du flux d'ecriture
      out.close();
    }
  }

  public static void build(Collection listPathCls, Collection listPathTo, String szJarFile) throws FileNotFoundException, IOException {
    if ((UtilString.isNotEmpty(szJarFile))&&
        (listPathCls!=null)) {
      OutputStream out = new FileOutputStream(szJarFile);
      JarOutputStream outJar = new JarOutputStream(out);
      String path = null;
      Iterator iterTo = listPathTo.iterator();
      for (Iterator iter = listPathCls.iterator(); iter.hasNext(); ) {
        build(outJar, (String) iter.next(), (String) iterTo.next(), szJarFile);
      }
      // Fermeture du Jar
      outJar.finish();
      // Fermeture du flux d'ecriture
      out.close();
    }
  }

  public static void build(JarOutputStream outJar, String szPathCls, String szPathTo, String szJarFile) throws FileNotFoundException, IOException {
    if (UtilString.isNotEmpty(szJarFile)) {
      build(outJar, szPathCls, szPathTo, szJarFile, true);
    }
  }

  public static void build(String szPathCls, String szPathTo, String szJarFile) throws FileNotFoundException, IOException {
    if (UtilString.isNotEmpty(szJarFile)) {
      OutputStream out = new FileOutputStream(szJarFile);
      JarOutputStream outJar = new JarOutputStream(out);
      String path = null;
      build(outJar, szPathCls, szPathCls, szJarFile, true);
      // Fermeture du Jar
      outJar.finish();
      // Fermeture du flux d'ecriture
      out.close();
    }
  }

  public static void build(String[] listPathCls, String[] listPathSrcTo, String szJarFile, boolean relativePath) throws FileNotFoundException, IOException {
    if ((UtilString.isNotEmpty(szJarFile))&&
    	(listPathCls!=null)) {
      OutputStream out = new FileOutputStream(szJarFile);
      JarOutputStream outJar = new JarOutputStream(out);
      for (int i = 0; i < listPathCls.length; i++) {
        build(outJar, listPathCls[i], listPathSrcTo[i], szJarFile, relativePath);
      }
      // Fermeture du Jar
      outJar.finish();
      // Fermeture du flux d'ecriture
      out.close();
    }
  }

  public static void build(Collection listPathCls, Collection listPathTo, String szJarFile, boolean relativePath) throws FileNotFoundException, IOException {
    if ((UtilString.isNotEmpty(szJarFile))&&
    	(listPathCls!=null)) {
      OutputStream out = new FileOutputStream(szJarFile);
      JarOutputStream outJar = new JarOutputStream(out);
      String path = null;
      Iterator iterTo = listPathTo.iterator();
      for (Iterator iter = listPathCls.iterator(); iter.hasNext(); ) {
        build(outJar, (String) iter.next(), (String)iterTo.next(), szJarFile, relativePath);
      }
      // Fermeture du Jar
      outJar.finish();
      // Fermeture du flux d'ecriture
      out.close();
    }
  }

  public static void build(String szPathCls, String szPathTo, String szJarFile, boolean relativePath) throws FileNotFoundException, IOException {
    if (UtilString.isNotEmpty(szJarFile)) {
        OutputStream out = new FileOutputStream(szJarFile);
        JarOutputStream outJar = new JarOutputStream(out);
        build(outJar, szPathCls, szPathTo, szJarFile, relativePath);
        // Fermeture du Jar
        outJar.finish();
        // Fermeture du flux d'ecriture
        out.close();
      }
  }

  public static void build(JarOutputStream outJar, String szPathCls, String szPathTo, String szJarFile, boolean relativePath) throws FileNotFoundException, IOException {
    if ((UtilString.isNotEmpty(szPathCls))) {
          byte[] array = null;
          File file = null;
          String path = null;
          Vector listFile = null;
          File fPathCls = new File(szPathCls);
          if (fPathCls.isDirectory()) {
        	  listFile = UtilFile.dirFile(szPathCls, true, null, false/*true*/);
          }
          else {
        	  szPathCls = fPathCls.getParent();
        	  listFile = new Vector();
        	  listFile.add(fPathCls);
          }
          int max = UtilVector.safeSize(listFile);
          for (int i=0 ; i<max ; i++) {
            file = (File)UtilVector.safeGetElementAt(listFile, i);
            if (file.isFile()&&file.canRead()){
              // nouveau tableau de caractere
              array = new byte[(int)file.length()];
              // Lecture du fichier
              new FileInputStream(file).read(array);
              // Construction du chemin de l'entree
              if (relativePath)
                // Chemin Relatif
                path = file.getPath().substring(new File(szPathCls).getPath().length() + 1);
              else
                // Chemin Absolut
                path = file.getPath();
              if (UtilString.isNotEmpty(szPathTo)) {
	              if (!path.startsWith("/") && !path.startsWith("\\"))
	            	  path = "/" + path;
	              if (szPathTo.startsWith("/") || szPathTo.startsWith("\\"))
	            	  szPathTo = szPathTo.substring(1);
	              if (szPathTo.endsWith("/") || szPathTo.endsWith("\\"))
	            	  szPathTo = szPathTo.substring(0, szPathTo.length());
	              path = szPathTo + path;
              }
              path = path.replace('\\', '/');
              try {
	              // Ajout d'une entree dans le jar
	              outJar.putNextEntry(new JarEntry(path));
	              // Ecriture du jar
	              outJar.write(array);
	              outJar.flush();
	              outJar.flush();
	              // Fermeture de toutes les entrees
	              outJar.closeEntry();
              }
              catch(ZipException ex) {
            	  // Gestion du cas où l'entrée existe déjà dans le Jar (duplicate entry)
              }
            }
          }
          if (max>0) {
	          // Fermeture de toutes les entrees
	          outJar.flush();
	          outJar.flush();
	          outJar.closeEntry();
	          //outJar.finish();
	          // Fermeture du jar
	          //outJar.close();
          }
      }
      else
        System.out.println("No path to build");
  }
}