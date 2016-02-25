package framework.ressource.util;

import java.io.File;
import java.io.IOException;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */

public class UtilCompile {

  public static final int MODERN_COMPILER_SUCCESS = 0;

  public UtilCompile() {
  }

  public static void buildJavaFile_ExecDos(String javaFileName, String szPathDst, String jdkCompiler) {
    String classPath = UtilPackage.getPackageClassPath();
    buildJavaFile_ExecDos(javaFileName, szPathDst, jdkCompiler, classPath);
  }

  public static void buildJavaFile_ExecDos(String javaFileName, String szPathDst, String jdkCompiler, String classPath) {
          if ((UtilString.isNotEmpty(javaFileName)) &&
                  (UtilString.isNotEmpty(szPathDst)) &&
                  (UtilString.isNotEmpty(jdkCompiler)) &&
                  (UtilString.isNotEmpty(classPath))) {
                try {
                  localJavaFile_ExecDos(javaFileName, szPathDst, jdkCompiler, classPath);
                }
                catch (Exception ex) {
                  ex.printStackTrace();
                }
          }
          else
                System.out.println("No path to build");
  }

  public static void buildClass_ExecDos(String className, String szPathSrc, String szPathDst, String jdkCompiler) {
          String classPath = UtilPackage.getPackageClassPath();
        buildClass_ExecDos(className, szPathSrc, szPathDst, jdkCompiler, classPath);
  }

  public static void buildClass_ExecDos(String className, String szPathSrc, String szPathDst, String jdkCompiler, String classPath) {
          if ((UtilString.isNotEmpty(className)) &&
                  (UtilString.isNotEmpty(szPathSrc)) &&
                  (UtilString.isNotEmpty(szPathDst)) &&
                  (UtilString.isNotEmpty(jdkCompiler)) &&
                  (UtilString.isNotEmpty(classPath))) {
                try {
                  localBuildClass_ExecDos(className, szPathSrc, szPathDst, jdkCompiler, classPath);
                }
                catch (Exception ex) {
                  ex.printStackTrace();
                }
          }
          else
                System.out.println("No path to build");
  }

  public static void buildClass_ExecDos(String className, String szPathSrc, String szPathDst, String jdkCompilerPath, String jdkCompilerExe, String classPath) {
          if ((UtilString.isNotEmpty(className)) &&
                  (UtilString.isNotEmpty(szPathSrc)) &&
                  (UtilString.isNotEmpty(szPathDst)) &&
                  (UtilString.isNotEmpty(jdkCompilerPath)) &&
                  (UtilString.isNotEmpty(jdkCompilerExe)) &&
                  (UtilString.isNotEmpty(classPath))) {
                try {
                  localBuildClass_ExecDos(className, szPathSrc, szPathDst, jdkCompilerPath, jdkCompilerExe, classPath);
                }
                catch (Exception ex) {
                  ex.printStackTrace();
                }
          }
          else
                System.out.println("No path to build");
  }

  public static void buildJar_ExecDos(String szPathCls, String szJarFile, String szPrgName, String jdkArchiverPath, String jdkArchiverExe) {
//		String szPathCls = Constante.getDefaultPath(Constante.CST_FILE_INITIALISE_ELEMENT_DEFAULT_PATH_CLASS_COMPILED);
//		String szJarFile = Constante.getDefaultPath(Constante.CST_FILE_INITIALISE_ELEMENT_DEFAULT_PATH_JAR_FILE_TAGLIB);
//		String szPrgName = Constante.getParameter(Constante.CST_FILE_INITIALISE_ELEMENT_PARAMETER_PKG_PROJECT_NAME);
          if ((UtilString.isNotEmpty(jdkArchiverPath))&&
                  (UtilString.isNotEmpty(jdkArchiverExe))){
                        StringBuffer jdkArchiver = new StringBuffer(jdkArchiverPath);
                        if(!jdkArchiverPath.endsWith(File.separator))
                                jdkArchiver.append(File.separator);
                        jdkArchiver.append(jdkArchiverExe);
                        buildJar_ExecDos(szPathCls, szJarFile, szPrgName, jdkArchiver.toString());
          }
  }
  public static void buildJar_ExecDos(String szPathCls, String szJarFile, String szPrgName, String jdkArchiver) {
//			  String szPathCls = Constante.getDefaultPath(Constante.CST_FILE_INITIALISE_ELEMENT_DEFAULT_PATH_CLASS_COMPILED);
//			  String szJarFile = Constante.getDefaultPath(Constante.CST_FILE_INITIALISE_ELEMENT_DEFAULT_PATH_JAR_FILE_TAGLIB);
//			  String szPrgName = Constante.getParameter(Constante.CST_FILE_INITIALISE_ELEMENT_PARAMETER_PKG_PROJECT_NAME);
        if ((UtilString.isNotEmpty(szJarFile))&&
                (UtilString.isNotEmpty(szPrgName))&&
                (UtilString.isNotEmpty(szPathCls))&&
                (UtilString.isNotEmpty(jdkArchiver)))
        {
        try {
          if(szPathCls.endsWith(File.separator))
            // Supprime le dernier File.separator (sinon erreur d'execution)
            szPathCls = szPathCls.substring(0, szPathCls.length() - 1);
          StringBuffer szExec = new StringBuffer();
          szExec.append("\"").append(jdkArchiver).append("\"")
              .append(" -cf \"").append(szJarFile).append("\"")
              .append(" -C \"").append(szPathCls).append("\"")
              .append(" \"").append(szPrgName).append("\"");
          System.out.println("Execute: " + szExec.toString() + "\r\n");
          Runtime.getRuntime().exec(szExec.toString());
        }
        catch( Exception ex )
        {
          ex.printStackTrace();
        }
      }
      else
        System.out.println("No path to build");
  }

  protected static void localBuildClass_ExecDos(String className, String pathSrc, String pathDst, String jdkCompilerPath, String jdkCompilerExec, String classPath) throws IOException, InterruptedException {
          if (UtilString.isNotEmpty(jdkCompilerPath)&&
            UtilString.isNotEmpty(jdkCompilerExec)){
                  StringBuffer jdkCompiler = new StringBuffer(jdkCompilerPath);
                if (!jdkCompilerPath.endsWith(File.separator))
                        jdkCompiler.append(File.separator);
                jdkCompiler.append(jdkCompilerExec);
                localBuildClass_ExecDos(className, pathSrc, pathDst, jdkCompiler.toString(), classPath);
        }
  }

  protected static void localBuildClass_ExecDos(String className, String pathSrc, String pathDst, String jdkCompiler, String classPath) throws IOException, InterruptedException {
    String javaFileName = pathSrc + "\\" + className.replace('.', '\\');
    if (UtilString.isNotEndBy(javaFileName, ".java"))
      javaFileName += ".java";
    localJavaFile_ExecDos(javaFileName, pathDst, jdkCompiler, classPath);
  }

  protected static void localJavaFile_ExecDos(String javaFileName, String pathDst, String jdkCompiler, String classPath) throws IOException, InterruptedException {
    StringBuffer szExec = new StringBuffer();
    szExec.append("\"").append(jdkCompiler).append("\" -nowarn -d \"").append(pathDst).append("\"");
    if(UtilString.isNotEmpty(classPath))
      szExec.append(" -classpath \"").append(classPath).append("\"");
    szExec.append(" \"").append(javaFileName).append("\"");
    System.out.println("Execute: " + szExec.toString() + "\r\n");
    Runtime.getRuntime().exec(szExec.toString()).waitFor();
  }
}
