package framework.ressource.util;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author non attribuable
 * @version 1.0
 */

public class UtilClass {
  private UtilClass() {
  }

  /**
   * give the short name of a class
   */
  public static String shortName(Class c) {
    return shortName(c.getName());
  }

  /**
   * give the short name of a class name
   */
  public static String shortName(String longName) {
    return shortName(longName,'.');
  }

  /**
   * give the short name with separator as separator
   */
  public static String shortName(String longName,char separator) {
    int index=longName.lastIndexOf(separator);
    if (index<0)
      return longName;
    else if (index<longName.length()-1)
      return longName.substring(index+1);
    else
      return "";
  }
}