package framework.ressource.util.classbean;

import framework.ressource.util.UtilFile;
import java.io.Serializable;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 * @author  non attribuable
 * @version  1.0
 */

public class CPackage implements Serializable {
  private String pack;
  private String path;
  private String name;
  public CPackage(String pack) {
    setPack(pack);
    setPath(UtilFile.pathName(pack));
    setName(UtilFile.fileName(pack));
  }
  public CPackage() {
  }
  /**
 * @return  the name
 * @uml.property  name="name"
 */
public String getName() {
    return name;
  }
  /**
 * @param name  the name to set
 * @uml.property  name="name"
 */
public void setName(String name) {
    this.name = name;
  }
  /**
 * @return  the path
 * @uml.property  name="path"
 */
public String getPath() {
    return path;
  }
  /**
 * @param path  the path to set
 * @uml.property  name="path"
 */
public void setPath(String path) {
    this.path = path;
  }
  /**
 * @return  the pack
 * @uml.property  name="pack"
 */
public String getPack() {
    return pack;
  }
  /**
 * @param pack  the pack to set
 * @uml.property  name="pack"
 */
public void setPack(String pack) {
    this.pack = pack;
  }
}