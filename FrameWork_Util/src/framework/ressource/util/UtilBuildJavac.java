package framework.ressource.util;

import java.io.OutputStream;

import framework.ressource.util.javac.Main;

/**
 * Main program of the Java compiler
 */

public class UtilBuildJavac {

  public static synchronized boolean buildClass(String className, String pathSrc, String pathDst, String classPath) {
    return buildClass(System.out, className, pathSrc, pathDst, classPath);
  }

  public static synchronized boolean buildClass(OutputStream out,String className, String pathSrc, String pathDst, String classPath) {
    String javaFileName = pathSrc + "\\" + className.replace('.', '\\');
    if (UtilString.isNotEndBy(javaFileName, ".java"))
      javaFileName += ".java";
    return build(out, javaFileName, pathDst, classPath);
  }

  public static synchronized boolean build(String javaFileName, String pathDst, String classPath) {
    return build(System.out, javaFileName, pathDst, classPath);
  }

  public static synchronized boolean build(OutputStream out, String javaFileName, String pathDst, String classPath) {
    String[] args = new String[] {"-nowarn", "-d", pathDst, "-classpath", classPath, javaFileName};
    System.out.print("Execute:");
    return build(out, args);
  }

  public static synchronized boolean build(String[] argv) {
    return build(System.out, argv);
  }

  public static synchronized boolean build(OutputStream out, String argv[]) {
    for (int i=0 ; i<argv.length ; System.out.print(argv[i++]+" "));
    System.out.println();
    Main compiler = new Main(out, "javac");
    compiler.compile(argv);
    return compiler.compilationReportedErrors();
  }
}
