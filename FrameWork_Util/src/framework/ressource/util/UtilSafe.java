package framework.ressource.util;

import java.util.Collection;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.Iterator;
import java.util.Enumeration;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class UtilSafe {
  private UtilSafe() {
  }

  public static Object safeListGetElementAt(Object data, int index) {
    Object ret = null;
    if (data!=null) {
      if (data instanceof List)
        ret = ((List)data).get(index);
      else if (data instanceof Collection) {
        Iterator it = ((Collection)data).iterator();
        for(int i=0 ; it.hasNext() ; i++) {
          if (i==index) {ret = it.next(); break;}
          else           it.next();
        }
      }
      else if (data instanceof Enumeration) {
        Enumeration lEnum = ((Enumeration)data);
        for(int i=0 ; lEnum.hasMoreElements() ; i++) {
          if (i==index) {ret = lEnum.nextElement(); break;}
          else           lEnum.nextElement();
        }
      }
      else if (data instanceof Map)
        ret = safeListGetElementAt(((Map)data).values(), index);
      else if (data instanceof Dictionary)
        ret = safeListGetElementAt(((Dictionary)data).elements(), index);
      else if(data instanceof Object[])
        ret = (index<((Object[])data).length) ? ((Object[])data)[index] : null;
    }
    return ret;
  }

  public static void safeListSetElementAt(Object data, Object value, int index) {
    if (data!=null) {
      if (data instanceof List)
        ((List)data).set(index, value);
      else if (data instanceof Collection)
        ((Collection)data).add(value);
      else if(data instanceof Object[])
        ((Object[])data)[index] = value;
    }
  }

  public static void safeListSetElementAt(Object data, Object key, Object value, int index) {
    if (data!=null) {
      if (data instanceof Map)
        ((Map)data).put(key, value);
      else if (data instanceof Dictionary)
        ((Dictionary)data).put(key, value);
    }
  }

  public static int safeListSize(Object data) {
    int ret = 0;
    if (data!=null) {
      if (data instanceof Object[])
        ret = ((Object[])data).length;
      else if (data instanceof List)
        ret = ((List)data).size();
      else if (data instanceof Collection)
        ret = ((Collection)data).size();
      else if (data instanceof Map)
        ret = ((Map)data).size();
      else if (data instanceof Dictionary)
        ret = ((Dictionary)data).size();
    }
    return ret;
  }
}
