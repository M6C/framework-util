/**
 * SortableObject
 * extends SortableAdapter,
 * to change the default string based comparison
 * to a customized string comparison
 * @version 1.0
 * @author Alexandre David
 */

/**
 * version history:
 * 1.0: first version
 */

package framework.ressource.util;

/**
 * @author  HP_Administrateur
 */
public class SortableObject extends SortableAdapter {

  /**
   * the kept string representation
   */
  String string;

  /**
   * default constructor, uses object.toString()
   */
  public SortableObject(Object object) {
    this(object,object.toString());
  }

  /**
   * custom constructor: any string
   */
  public SortableObject(Object object,String string) {
    super(object);
    setString(string);//if someone wants to override the method
  }

  /**
   * convenient method to build arrays of sortable elements
   */
  public static SortableObject[] toSortableObjects(Object[] objs) {
    int n=objs.length;
    SortableObject[] result=new SortableObject[n];
    for(int i=0;i<n;i++)
      result[i]=new SortableObject(objs[i]);
    return result;
  }

  /**
   * overrides SortableAdapter.toString()
   * to return the customized string
   */
  public String toString() {
    return string;
  }

  /**
 * method to change the string
 * @uml.property  name="string"
 */
  public void setString(String string) {
    if (string!=null)
      this.string=string;
  }

}
