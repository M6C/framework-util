package framework.ressource.util.classbean;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 * @author  non attribuable
 * @version  1.0
 */

public class CClass {
  private CPackage cPackage = null;
  private Class classe = null;
  public CClass(Class classe) {
    setClasse(classe);
  }
  public CClass(CPackage cPackage, Class classe) {
    this(classe);
    setCPackage(cPackage);
  }
  /**
 * @return  the cPackage
 * @uml.property  name="cPackage"
 */
public CPackage getCPackage() {
    return cPackage;
  }
  /**
 * @param cPackage  the cPackage to set
 * @uml.property  name="cPackage"
 */
public void setCPackage(CPackage cPackage) {
    this.cPackage = cPackage;
  }
  /**
 * @return  the classe
 * @uml.property  name="classe"
 */
public Class getClasse() {
    return classe;
  }
  /**
 * @param classe  the classe to set
 * @uml.property  name="classe"
 */
public void setClasse(Class classe) {
    this.classe = classe;
  }
  public String toString()
  {
    return getClasse().getName();
  }
}