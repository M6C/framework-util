/**
 * Sortable: interface for objects which are
 * to be sorted
 * @version 1.0
 * @author Alexandre David
 */

/**
 * version history
 * 1.0: first version
 */

package framework.ressource.util;


public interface Sortable {

  public boolean equals(Sortable s);
  public boolean isLessThan(Sortable s);
  public boolean isGreaterThan(Sortable s);
  public String toString();

}
