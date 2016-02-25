/**
 * SortableAdapter
 * simple adapter for the interface Sortable
 * the sort test is based on the string representation
 * of the contained object
 * this class "wraps" any kind of object into a Sortable
 * @version 1.0
 * @author Alexandre David
 */

/**
 * version history
 * 1.0: first version
 */

package framework.ressource.util;


/**
 * @author  HP_Administrateur
 */
public class SortableAdapter implements Sortable {

  /**
   * the wrapped object
   */
  Object object;

  /**
   * constructor: the object to be wrapped
   * the object must not be null!
   * if it is null, a NullPointerException will
   * be raised one day, which is a good thing because
   * one is not supposed to sort null objects
   */
  public SortableAdapter(Object object) {
    setObject(object); //if someone wants to override the method
  }

  /**
   * convenient method to build arrays of sortable elements
   */
  public static SortableAdapter[] toSortableAdapters(Object[] objs) {
    int n=objs.length;
    SortableAdapter[] result=new SortableAdapter[n];
    for(int i=0;i<n;i++)
      result[i]=new SortableAdapter(objs[i]);
    return result;
  }

  /**
   * gives the string representation of this object,
   * used also for the test. Overriding this method
   * may be useful... it is done for ObjectString
   */
  public String toString() {
    return object.toString();
  }

  /**
   * returns true if the given sortable is less (strictly) than this object
   */
  public boolean isLessThan(Sortable s) {
    return (toString().compareTo(s.toString())<0);
  }

  /**
   * returns true if the given sortable is greater (strictly) than this object
   */
  public boolean isGreaterThan(Sortable s) {
    return (toString().compareTo(s.toString())>0);
  }

  /**
   * returns true if the given sortable is equal to this object
   */
  public boolean equals(Sortable s) {
    return toString().equals(s.toString());
  }

  /**
 * methods to give access to the wrapped object
 * @uml.property  name="object"
 */
  public Object getObject() {
    return object;
  }
  /**
 * @param object  the object to set
 * @uml.property  name="object"
 */
public void setObject(Object o) {
    if (o!=null) //change the object only if the new one is not null
      object=o;
  }


}
