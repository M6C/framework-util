package framework.ressource.util;

import java.util.Vector;
import java.util.List;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author non attribuable
 * @version 1.0
 */

public class UtilVector {
  private UtilVector() {
  }

  public static int safeSize(List list) {
    return (list!=null) ? list.size() : 0;
  }

  public static boolean safeEmpty(List list) {
    return safeSize(list)==0;
  }

  public static boolean safeNotEmpty(List list) {
    return safeSize(list)>0;
  }

  public static Object safeGetElementAt(List list, int index) {
    Object ret = null;
    if ( (index < safeSize(list)) && (index >= 0))
      ret = list.get(index);
    return ret;
  }

  public static void safeSetElementAt(List list, Object obj, int index) {
    if (list != null) {
      while(index >= safeSize(list))
        list.add(null);
      list.set(index, obj);
    }
  }

  public static void safeAddElementAt(List list, Object obj) {
    if (list != null) {
      list.add(obj);
    }
  }

  public static boolean isContainsString(List list, String str) {
    boolean ret = false;
    for( int i=0 ; (i<safeSize(list))&&(!ret) ; i++ ) {
      Object obj = list.get(i);
      ret=(obj!=null)&&(obj.toString().equals(str));
    }
    return ret;
  }
  public static List invertElements(List list) {
    Vector ret = new Vector();
    for(int i=(list.size()-1) ; i>=0 ; i--) {
      ret.add(list.get(i));
    }
    return ret;
  }
  public static void addElements(List list, Object[] array) {
    int size = array.length;
    for(int i=0 ; i<size ; list.add(array[i++]));
  }
  public static void addElements(List list, List elements) {
    int size = safeSize(elements);
    for(int i=0 ; i<size ; list.add(elements.get(i++)));
  }
}
