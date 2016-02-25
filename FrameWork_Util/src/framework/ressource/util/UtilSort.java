package framework.ressource.util;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author non attribuable
 * @version 1.0
 */

import java.util.Arrays;
import java.util.Comparator;

public class UtilSort {
  private UtilSort() {
  }

  /**
   * copy the class array, and sort it in increase order
   */
  public static Object[] sortIncrease(Object[] objs) {
    return sortIncrease(objs, null);
  }

  public static Object[] sortIncrease(Object[] objs, final String methodName) {
    Object[] copy=new Object[objs.length];
    System.arraycopy(objs,0,copy,0,objs.length);
    if (copy.length>1) {
      Comparator myComparator = new Comparator() {
        public int compare(Object obj1, Object obj2) {
          String val1 = "";
          String val2 = "";
          String[] listMethodeName = UtilString.split(methodName, ';');
          String[] listSubMethodeName = null;
          if (listMethodeName!=null) {
            int size = listMethodeName.length;
            for(int i=0 ; i<size ; i++) {
              listSubMethodeName = UtilString.split(listMethodeName[i], '.');
              if (listSubMethodeName!=null) {
                Object item1=obj1, item2=obj2;
                int subSize = listSubMethodeName.length;
                for (int j = 0; j < subSize; j++) {
                  item1 = getMethodObject(item1, listSubMethodeName[j]);
                  item2 = getMethodObject(item2, listSubMethodeName[j]);
                }
                val1 += item1;
                val2 += item2;
              }
            }
          }
          return val1.compareToIgnoreCase(val2);
        }
      };
      Arrays.sort(copy, myComparator);
    }
    return copy;
  }

  /**
   * Return a value from an object method. Or 'toString' of the object if the method name is null;
   * @param obj An object
   * @param methodName The name of the method
   */
  protected static String getMethodValue(Object obj, String methodName) {
    String ret = "";
    if (obj!=null) {
      if (methodName!=null) {
        Object tmp = UtilReflect.safeInvokeMethod(obj, methodName, null, null);
        if (tmp!=null)
          ret = tmp.toString();
        else
          ret = obj.toString();
      }
      else
        ret = obj.toString();
    }
    return ret;
  }

  /**
   * Return a object from an object method. Or the first object if the result of the method name is null;
   * @param obj An object
   * @param methodName The name of the method
   */
  protected static Object getMethodObject(Object obj, String methodName) {
    Object ret = null;
    if (obj!=null) {
      if (methodName!=null) {
        ret = UtilReflect.safeInvokeMethod(obj, methodName, null, null);
        if (ret==null)
          ret = obj;
      }
      else
        ret = obj;
    }
    return ret;
  }
}
