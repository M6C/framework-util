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
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */

public class UtilBuildZip {

  public static final int MODERN_COMPILER_SUCCESS = 0;

  public UtilBuildZip() {
  }

  public static void build(String[] listPathCls, String szZipFile) throws FileNotFoundException, IOException {
    if (listPathCls!=null) {
      for (int i = 0; i < listPathCls.length; i++) {
        build(listPathCls[i], szZipFile);
      }
    }
  }

  public static void build(Collection listPathCls, String szZipFile) throws FileNotFoundException, IOException {
    if (listPathCls!=null) {
      for (Iterator iter = listPathCls.iterator(); iter.hasNext(); ) {
        build( (String) iter.next(), szZipFile);
      }
    }
  }

  public static void build(String szPathCls, String szZipFile) throws FileNotFoundException, IOException {
    build(szPathCls, szZipFile, true);
  }

  public static void build(String[] listPathCls, String szZipFile, boolean relativePath) throws FileNotFoundException, IOException {
    if (listPathCls!=null) {
      for (int i = 0; i < listPathCls.length; i++) {
        build(listPathCls[i], szZipFile, relativePath);
      }
    }
  }

  public static void build(Collection listPathCls, String szZipFile, boolean relativePath) throws FileNotFoundException, IOException {
    if (listPathCls!=null) {
      for (Iterator iter = listPathCls.iterator(); iter.hasNext(); ) {
        build( (String) iter.next(), szZipFile, relativePath);
      }
    }
  }

  public static void build(String szPathCls, String szZipFile, boolean relativePath) throws FileNotFoundException, IOException {
    if ((UtilString.isNotEmpty(szZipFile))&&
        (UtilString.isNotEmpty(szPathCls))) {
          byte[] array = null;
          File file = null;
          String path = null;
          OutputStream out = new FileOutputStream(szZipFile);
          ZipOutputStream outZip = new ZipOutputStream(out);
          Vector listFile = UtilFile.dirFile(szPathCls, true, null, true);
          int max = UtilVector.safeSize(listFile);
          for(int i=0 ; i<max ; i++){
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
              // Ajout d'une entree dans le zip
              outZip.putNextEntry(new ZipEntry(path));
              // Ecriture du zip
              outZip.write(array);
            }
          }
          // Fermeture de toutes les entrees
          outZip.closeEntry();
          // Fermeture du zip
          outZip.close();
          // Fermeture du flux d'ecriture
          out.close();
      }
      else
        System.out.println("No path to build");
  }
}
