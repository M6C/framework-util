/**
 * Sorter
 * different sorts on different objects
 * the algorithm is the quick sort by default or bubble sort
 * This class contains several methods on string
 * manipulation as well since the default sort is
 * based on the toString() result.
 * @version 1.0.1
 * @author Alexandre David
 */

/**
 * version history
 * 1.0: first version
 * 1.0.1 991011: "null" returned when calling toString(null)
 */

package framework.ressource.util;

import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Vector;


public class Sorter {

  /**
   * to control whether we put quotes or not around strings
   */
  static boolean putQuotes=true;

  /**
   * the list separator
   */
  static String sepList=" ";

  /**
   * manage the list separator
   */
  public static String getListSeparator() {
    return sepList;
  }
  public static void setListSeparator(String sep) {
    if (sep!=null)
      sepList=sep;
  }

  /**
   * manage the quote flag
   */
  public static boolean isQuoted() {
    return putQuotes;
  }
  public static void setQuoted(boolean b) {
    putQuotes=b;
  }

  /**
   * reverse an array, returns a copy
   */
  public static Object[] reverse(Object[] objs) {
    Object[] copy=new Object[objs.length];
    System.arraycopy(objs,0,copy,0,objs.length);
    if (copy.length>1)
      reverse(copy,0,copy.length-1);
    return copy;
  }

  /**
   * reverse a sub array, no copy is made
   */
  public static void reverse(Object[] objs,int min,int max) {
    int n=(max-min+1)/2;
    for(int i=0;i<n;i++) {
      Object tmp=objs[min+i];
      objs[min+i]=objs[max-i];
      objs[max-i]=tmp;
    }
  }

  /**
   * sort a matching list with a keyword
   */
  public static String[] matchSort(String key,String[] strings,boolean newone) {
    if (strings.length<2)
      return strings;
    String[] sortStrings=(String[])sortI(strings); //pre sort->equal suffixes are sorted with this prefix
    for(int i=0;i<sortStrings.length;i++)
      sortStrings[i]=UtilClass.shortName(strings[i]).toLowerCase();
    if (newone) {
      String[] copy=new String[strings.length];
      System.arraycopy(strings,0,copy,0,strings.length);
      strings=copy;
    }
    matchSort(sortStrings,strings,0,strings.length-1,key);
    return strings;
  }
  static void matchSort(String[] objs,String[] content,int min,int max,String key) {
    if (max-min>1) {
      String middle=objs[(min+max)/2].toString();
      int i=min;
      int j=max;
      do {
	while (isBefore(objs[i],middle,key)) i++;
	while (isBefore(middle,objs[j],key)) j--;
	if (i<=j) {
	  String tmp=objs[i];
	  objs[i]=objs[j];
	  objs[j]=tmp;
	  tmp=content[i];
	  content[i++]=content[j];
	  content[j--]=tmp;
	}
      } while (i<=j);
      if (min<j) matchSort(objs,content,min,j,key);
      if (i<max) matchSort(objs,content,i,max,key);
    }
    else if (isBefore(objs[max],objs[min],key)) {
      String tmp=objs[min];
      objs[min]=objs[max];
      objs[max]=tmp;
      tmp=content[min];
      content[min]=content[max];
      content[max]=tmp;
    }
  }

  /**
   * order law for the match sort if str1<str2 with the key
   */
  public static boolean isBefore(String str1,String str2,String key) {
    int index1=str1.indexOf(key);
    int index2=str2.indexOf(key);
    if (index1>=0) {
      if (index2>=0) {
	if (index1==index2)
	  return (str1.compareTo(str2)<0);
	else
	  return (index1<index2);
      }
      else //index2<0
	return true;
    }
    else { //index1<0
      if (index2>=0)
	return false;
      else
	return (str1.compareTo(str2)<0);
    }
  }

  /**
   * copy the string array, and sort it in increase order
   */
  public static Object[] sortI(Object[] strings) {
    Object[] copy=new Object[strings.length];
    System.arraycopy(strings,0,copy,0,strings.length);
    if (strings.length<2)
      return copy;
    sortI(copy,0,copy.length-1);
    return copy;
  }
  public static Object[] bubbleSortI(Object[] strings) {
    Object[] copy=new Object[strings.length];
    System.arraycopy(strings,0,copy,0,strings.length);
    if (strings.length<2)
      return copy;
    bubbleSortI(copy,0,copy.length-1);
    return copy;
  }

  /**
   * copy the class array, and sort it in increase order
   */
  public static Class[] sortI(Class[] classes) {
    Class[] copy=new Class[classes.length];
    System.arraycopy(classes,0,copy,0,classes.length);
    if (classes.length<2)
      return copy;
    sortI(copy,0,copy.length-1);
    return copy;
  }
  public static Class[] bubbleSortI(Class[] classes) {
    Class[] copy=new Class[classes.length];
    System.arraycopy(classes,0,copy,0,classes.length);
    if (classes.length<2)
      return copy;
    bubbleSortI(copy,0,copy.length-1);
    return copy;
  }

  /**
   * sort a sub array, no copy is made ; increase order
   */
  public static void sortI(Object[] objs,int min,int max) {
    if (max-min>1) {
      String middle=objs[(min+max)/2].toString();
      int i=min;
      int j=max;
      do {
          while (middle.compareTo(objs[i].toString())>0) i++;
          while (middle.compareTo(objs[j].toString())<0) j--;
          if (i<=j) {
            Object tmp=objs[i];
            objs[i++]=objs[j];
            objs[j--]=tmp;
          }
      } while (i<=j);
      if (min<j) sortI(objs,min,j);
      if (i<max) sortI(objs,i,max);
    }
    else if (objs[max].toString().compareTo(objs[min].toString())<0) {
      Object tmp=objs[min];
      objs[min]=objs[max];
      objs[max]=tmp;
    }
  }

  /**
   * sort a sub array, no copy is made ; increase order
   */
  public static void sortI(Vector objs) {
    sortI(objs, 0, objs.size()-1);
  }
  public static void sortI(Vector objs,int min,int max) {
    if (max-min>1) {
      String middle=objs.elementAt((min+max)/2).toString();
      int i=min;
      int j=max;
      do {
          while ((i<objs.size())&&(middle.compareTo(objs.elementAt(i).toString())>0)) i++;
          while ((j>0)&&(j<objs.size())&&(middle.compareTo(objs.elementAt(j).toString())<0)) j--;
          if (i<=j) {
            Object tmp=objs.elementAt(i);
            objs.setElementAt(objs.elementAt(j), i++);
            objs.setElementAt(tmp, j--);
          }
      } while (i<=j);
      if (min<j) sortI(objs,min,j);
      if (i<max) sortI(objs,i,max);
    }
    else if (objs.elementAt(max).toString().compareTo(objs.elementAt(min).toString())<0) {
      Object tmp=objs.elementAt(min);
      objs.setElementAt(objs.elementAt(max),min);
      objs.setElementAt(tmp,max);
    }
  }
  public static Enumeration sortI(Enumeration objs) {
    Vector ret = new Vector();
    if(objs!=null)
    {
      while(objs.hasMoreElements())
        ret.add(objs.nextElement());
      sortI(ret);
    }
    return ret.elements();
  }
  public static void bubbleSortI(Object[] objs,int min,int max) {
    for(int i=min;i<=max;i++) {
      String first=objs[i].toString();
      for(int j=i+1;j<=max;j++) {
	String second=objs[j].toString();
	if (first.compareTo(second)>0) {
	  first=second;
	  Object tmp=objs[i];
	  objs[i]=objs[j];
	  objs[j]=tmp;
	}
      }
    }
  }

  /**
   * copy the string array, and sort it in decrease order
   */
  public static String[] sortD(String[] strings) {
    String[] copy=new String[strings.length];
    System.arraycopy(strings,0,copy,0,strings.length);
    if (copy.length>1)
      sortD(copy,0,copy.length-1);
    return copy;
  }
  public static String[] bubbleSortD(String[] strings) {
    String[] copy=new String[strings.length];
    System.arraycopy(strings,0,copy,0,strings.length);
    if (copy.length>1)
      bubbleSortD(copy,0,copy.length-1);
    return copy;
  }

  /**
   * copy the class array, and sort it in increase order
   */
  public static Class[] sortD(Class[] classes) {
    Class[] copy=new Class[classes.length];
    System.arraycopy(classes,0,copy,0,classes.length);
    if (copy.length>1)
      sortD(copy,0,copy.length-1);
    return copy;
  }
  public static Class[] bubbleSortD(Class[] classes) {
    Class[] copy=new Class[classes.length];
    System.arraycopy(classes,0,copy,0,classes.length);
    if (copy.length>1)
      bubbleSortD(copy,0,copy.length-1);
    return copy;
  }

  /**
   * sort a sub array, no copy is made ; decrease order
   */
  public static void sortD(Object[] objs,int min,int max) {
    if (max-min>1) {
      String middle=objs[(min+max)/2].toString();
      int i=min;
      int j=max;
      do {
	  while (middle.compareTo(objs[i].toString())<0) i++;
	  while (middle.compareTo(objs[j].toString())>0) j--;
	  if (i<=j) {
	    Object tmp=objs[i];
	    objs[i++]=objs[j];
	    objs[j--]=tmp;
	  }
      } while (i<=j);
      if (min<j) sortD(objs,min,j);
      if (i<max) sortD(objs,i,max);
    }
    else if (objs[max].toString().compareTo(objs[min].toString())>0) {
      Object tmp=objs[min];
      objs[min]=objs[max];
      objs[max]=tmp;
    }
  }
  public static void bubbleSortD(Object[] objs,int min,int max) {
    for(int i=min;i<=max;i++) {
      String first=objs[i].toString();
      for(int j=i+1;j<=max;j++) {
	String second=objs[j].toString();
	if (first.compareTo(second)<0) {
	  first=second;
	  Object tmp=objs[i];
	  objs[i]=objs[j];
	  objs[j]=tmp;
	}
      }
    }
  }

  /**
   * copy the Sortable array, and sort it in increase order
   */
  public static Sortable[] sortI(Sortable[] objs) {
    Sortable[] copy=new Sortable[objs.length];
    System.arraycopy(objs,0,copy,0,objs.length);
    if (objs.length<2)
      return copy;
    sortI(copy,0,copy.length-1);
    return copy;
  }
  public static Sortable[] bubbleSortI(Sortable[] objs) {
    Sortable[] copy=new Sortable[objs.length];
    System.arraycopy(objs,0,copy,0,objs.length);
    if (objs.length<2)
      return copy;
    bubbleSortI(copy,0,copy.length-1);
    return copy;
  }

  /**
   * sort a sub array, no copy is made ; increase order
   */
  public static void sortI(Sortable[] objs,int min,int max) {
    if (max-min>1) {
      Sortable middle=objs[(min+max)/2];
      int i=min;
      int j=max;
      do {
	  while (middle.isGreaterThan(objs[i])) i++;
	  while (middle.isLessThan(objs[j])) j--;
	  if (i<=j) {
	    Sortable tmp=objs[i];
	    objs[i++]=objs[j];
	    objs[j--]=tmp;
	  }
      } while (i<=j);
      if (min<j) sortI(objs,min,j);
      if (i<max) sortI(objs,i,max);
    }
    else if (objs[max].isLessThan(objs[min])) {
      Sortable tmp=objs[min];
      objs[min]=objs[max];
      objs[max]=tmp;
    }
  }
  public static void bubbleSortI(Sortable[] objs,int min,int max) {
    for(int i=min;i<=max;i++)
      for(int j=i+1;j<=max;j++)
	if (objs[i].isGreaterThan(objs[j])) {
	  Sortable tmp=objs[i];
	  objs[i]=objs[j];
	  objs[j]=tmp;
	}
  }

  /**
   * copy the sortable array, and sort it in decrease order
   */
  public static Sortable[] sortD(Sortable[] objs) {
    Sortable[] copy=new Sortable[objs.length];
    System.arraycopy(objs,0,copy,0,objs.length);
    if (objs.length<2)
      return copy;
    sortD(copy,0,copy.length-1);
    return copy;
  }
  public static Sortable[] bubbleSortD(Sortable[] objs) {
    Sortable[] copy=new Sortable[objs.length];
    System.arraycopy(objs,0,copy,0,objs.length);
    if (objs.length<2)
      return copy;
    bubbleSortD(copy,0,copy.length-1);
    return copy;
  }

  /**
   * sort a sub array, no copy is made ; increase order
   */
  public static void sortD(Sortable[] objs,int min,int max) {
    if (max-min>1) {
      Sortable middle=objs[(min+max)/2];
      int i=min;
      int j=max;
      do {
	  while (middle.isLessThan(objs[i])) i++;
	  while (middle.isGreaterThan(objs[j])) j--;
	  if (i<=j) {
	    Sortable tmp=objs[i];
	    objs[i++]=objs[j];
	    objs[j--]=tmp;
	  }
      } while (i<=j);
      if (min<j) sortD(objs,min,j);
      if (i<max) sortD(objs,i,max);
    }
    else if (objs[max].isGreaterThan(objs[min])) {
      Sortable tmp=objs[min];
      objs[min]=objs[max];
      objs[max]=tmp;
    }
  }
  public static void bubbleSortD(Sortable[] objs,int min,int max) {
    for(int i=min;i<=max;i++)
      for(int j=i+1;j<=max;j++)
	if (objs[i].isLessThan(objs[j])) {
	  Sortable tmp=objs[i];
	  objs[i]=objs[j];
	  objs[j]=tmp;
	}
  }

  /**
   * different string transformations, note that they does not work
   * properly when we use array of primitive types
   */

  /**
   * array string representation
   */
  public static String toString(Object[] array) {
      if (array==null)
	  return "null";
    synchronized(array) {
      StringBuffer buffer=new StringBuffer(array.length*7);
      buffer.append("[ ");
      for(int i=0;i<array.length;i++)
	buffer.append(toString(array[i])).append(sepList);
      buffer.append(']');
      return buffer.toString();
    }
  }

  /**
   * vector string representation
   */
  public static String toString(Vector vector) {
      if (vector==null)
	  return "null";
    synchronized(vector) {
      int n=vector.size();
      StringBuffer buffer=new StringBuffer(n*7);
      buffer.append("{ ");
      for(int i=0;i<n;i++)
	buffer.append(toString(vector.elementAt(i))).append(sepList);
      buffer.append('}');
      return buffer.toString();
    }
  }

  /**
   * any object string representation, treats correctly
   * vectors and arrays, even if they are recursive
   */
  public static String toString(Object obj) {
      if (obj==null)
	  return "null";
    if (obj instanceof Object[])
      return toString((Object[])obj);
    else if (obj instanceof Vector)
      return toString((Vector)obj);
    else if (obj instanceof ObjectString)
      return ((ObjectString)obj).getObjectString(); //we are cheating here!
    else if (obj instanceof String) {
      if (putQuotes) {
	StringBuffer buffer=new StringBuffer();
	return buffer.append('\"').append((String)obj).append('\"').toString();
      }
      else
	return (String)obj;
    }
    else
      return obj.toString();
  }

  /**
   * convenient method to get arrays of strings
   */
  public static String[] toStrings(Object[] objs) {
      if (objs==null)
	  return new String[0];
    int n=objs.length;
    String[] result=new String[n];
    for(int i=0;i<n;i++)
      result[i]=toString(objs[i]);
    return result;
  }

  /**
   * convenient method to get arrays of strings
   */
  public static String[] toStrings(Vector objs) {
      if (objs==null)
	  return new String[0];
    int n=objs.size();
    String[] result=new String[n];
    for(int i=0;i<n;i++)
      result[i]=toString(objs.elementAt(i));
    return result;
  }

  /**
   * convenient method to get arrays of objects
   */
  public static Object[] toObjects(Vector objs) {
    int n=objs.size();
    Object[] result=new Object[n];
    for(int i=0;i<n;i++) {
      Object obj=objs.elementAt(i);
      if (obj instanceof Vector)
	result[i]=toObjects((Vector)obj);
      else if (obj instanceof Object[])
	result[i]=toObjects((Object[])obj);
      else
	result[i]=obj;
    }
    return result;
  }

  /**
   * convenient method to get arrays of objects
   */
  public static Object[] toObjects(Object[] objs) {
    int n=objs.length;
    Object[] result=new Object[n];
    for(int i=0;i<n;i++) {
      Object obj=objs[i];
      if (obj instanceof Vector)
	result[i]=toObjects((Vector)obj);
      else if (obj instanceof Object[])
	result[i]=toObjects((Object[])obj);
      else
	result[i]=obj;
    }
    return result;
  }

  /**
   * we want to do something for Enumeration, but the problem is that
   * when we use one , then we consume it and we can not use any more,
   * for this reason, we have this special function which produces one
   * copy and prints an Enumeration to the given PrintStream
   * the boolean tells whether to replace sub-enumeration objects by copies
   * or not, and thus to print them or not
   * Enumeration inside Vector or arrays are not printed!
   */
  public static Enumeration print(Enumeration list,PrintStream out,boolean subEnum) {
    Vector copy=new Vector();
    out.print("< ");
    while(list.hasMoreElements()) {
      Object item=list.nextElement();
      if (subEnum && item instanceof Enumeration)
	item=print((Enumeration)item,out,true);
      else
	out.print(toString(item));
      out.print(sepList);
      copy.addElement(item);
    }
    out.print(">");
    return copy.elements();
  }

}
