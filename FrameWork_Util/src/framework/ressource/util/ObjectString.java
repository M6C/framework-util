/**
 * ObjectString extends SortableObject
 * keeps a string associated with the object,
 * which is not the sort (toString) string
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
public class ObjectString extends SortableObject {

  /**
   * the associated string
   */
  String objectString;

  /**
   * default constructors
   */
  public ObjectString(Object object) {
    this(object,object.toString());
  }
  public ObjectString(Object object,String sortString) {
    this(object,sortString,object.toString());
  }

  /**
   * real constructor
   */
  public ObjectString(Object object,String sortString,String objectString) {
    super(object,sortString);
    setObjectString(objectString);
  }

  /**
 * sets the object string
 * @uml.property  name="objectString"
 */
  public void setObjectString(String string) {
    if (string!=null)
      objectString=string;
  }

  /**
 * gets the object string
 * @uml.property  name="objectString"
 */
  public String getObjectString() {
    return objectString;
  }

}
