package framework.ressource.util;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

import com.wutka.dtd.DTD;
import com.wutka.dtd.DTDAttribute;
import com.wutka.dtd.DTDContainer;
import com.wutka.dtd.DTDDecl;
import com.wutka.dtd.DTDElement;
import com.wutka.dtd.DTDItem;
import com.wutka.dtd.DTDName;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class UtilDTD {

  private UtilDTD() {
  }

  public static Vector getAttributes(DTDElement element) {
    Vector ret = new Vector();
    if (element!=null) {
      Enumeration enumKey = element.attributes.keys();
      while(enumKey.hasMoreElements()) {
        ret.add(element.attributes.get(enumKey.nextElement()));
      }
    }
    return ret;
  }

  public static Vector getAttributes(DTDElement element, DTDDecl dtdDecl) {
    Vector ret = new Vector();
    if ((element!=null)&&(dtdDecl!=null)) {
      Enumeration enumKey = element.attributes.keys();
      while(enumKey.hasMoreElements()) {
        DTDAttribute attr = (DTDAttribute)element.attributes.get(enumKey.nextElement());
        if ((attr.getDecl()!=null)&&(attr.getDecl().equals(dtdDecl)))
          ret.add(attr);
      }
    }
    return ret;
  }

  public static Vector getAttributesFixed(DTDElement element) {
    return getAttributes(element, DTDDecl.FIXED);
  }

  public static Vector getAttributesImplied(DTDElement element) {
    return getAttributes(element, DTDDecl.IMPLIED);
  }

  public static Vector getAttributesRequired(DTDElement element) {
    return getAttributes(element, DTDDecl.REQUIRED);
  }

  public static Vector getAttributesValue(DTDElement element) {
    return getAttributes(element, DTDDecl.VALUE);
  }

  public static void expandContainer(DTDContainer container, Vector v, DTD dtd) {
    DTDItem[] items = container.getItems();
    for (int i=0; i < items.length; i++) {
      if (items[i] instanceof DTDContainer) {
        expandContainer((DTDContainer) items[i], v, dtd);
        continue;
      }
      else if (!(items[i] instanceof DTDName)) {
        continue;
      }
      DTDElement currElem = (DTDElement) dtd.elements.get(((DTDName) items[i]).value);
      if (currElem == null) continue;
      v.addElement(currElem);
    }
  }
  public static String makePipePad(String pad) {
    StringBuffer buffer = new StringBuffer(pad.length());
     int len = pad.length();
    for (int i=0; i < len; i++) {
      char ch = pad.charAt(i);
      if (ch == '|') {
        buffer.append('|');
      }
      else if (ch == '-') {
        if ((i > 0) && (i < len-2) && (pad.charAt(i-1) == ' ') &&
            (pad.charAt(i+1) == '-') && (pad.charAt(i+2) == ' ')) {
          buffer.append('|');
        }
        else {
          buffer.append(' ');
        }
      }
      else {
        buffer.append(' ');
      }
    }
    return buffer.toString();
  }
  public static void removeElements(Hashtable h, DTD dtd, DTDItem item) {
    if (item instanceof DTDName) {
      h.remove(((DTDName) item).value);
    }
    else if (item instanceof DTDContainer) {
      Enumeration e = ((DTDContainer) item).getItemsVec().elements();
      while (e.hasMoreElements()) {
        removeElements(h, dtd, (DTDItem) e.nextElement());
      }
    }
  }

  public static Vector getRootListName(DTD dtd) {
    Vector ret = new Vector();
    Hashtable roots = getRootList( dtd);
    Enumeration e = roots.keys();
    while (e.hasMoreElements()) {
      ret.addElement(e.nextElement());
    }
    return ret;
  }

  public static Hashtable getRootList(DTD dtd) {
    Hashtable roots = new Hashtable();
    Enumeration e = dtd.elements.elements();
    while (e.hasMoreElements()) {
      DTDElement element = (DTDElement) e.nextElement();
      roots.put(element.name, element);
    }
    e = dtd.elements.elements();
    while (e.hasMoreElements()) {
      DTDElement element = (DTDElement) e.nextElement();
      if (!(element.content instanceof DTDContainer)) continue;
      Enumeration items = ((DTDContainer) element.content).getItemsVec().elements();
      while (items.hasMoreElements()) {
        removeElements(roots, dtd, (DTDItem) items.nextElement());
      }
    }
    return roots;
  }

  public static void printElementTree(DTD dtd, DTDElement element, String pad, Stack stack) {
    if (stack.contains(element.name)) {
      System.out.println(pad+" -- "+element.name);
      return;
    }

    stack.push(element.name);

    if (!(element.content instanceof DTDContainer)) {
      System.out.println(pad+" -- "+element.name);
    }
    else {
      DTDItem[] items = ((DTDContainer) element.content).getItems();

      Vector elems = new Vector();

      for (int i=0; i < items.length; i++) {
        if (items[i] instanceof DTDContainer) {
          expandContainer((DTDContainer) items[i], elems, dtd);
          continue;
        }
        else if (!(items[i] instanceof DTDName)) {
          continue;
        }

        DTDElement currElem = (DTDElement) dtd.elements.get(((DTDName) items[i]).value);

        if (currElem == null) continue;
        elems.addElement(currElem);
      }

      if (elems.size() == 0)
      {
        System.out.println(pad);
//                stack.pop();
        return;
      }

      String pipePad = makePipePad(pad);

      for (int i=0; i < elems.size(); i++)
      {
        DTDElement currElem = (DTDElement) elems.elementAt(i);

        if (i == 0)
        {
          printElementTree(dtd, currElem, pad+" -- "+currElem.name, stack);
        }
        else if (i < elems.size()-1)
        {
          printElementTree(dtd, currElem, pipePad+" |- "+currElem.name, stack);
        }
        else
        {
          printElementTree(dtd, currElem, pipePad+" +- "+currElem.name, stack);
        }
      }
    }
//        stack.pop();
  }
}