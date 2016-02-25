// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XObjectFactory.java

package framework.ressource.xalan.xpath.objects;

import org.apache.xml.dtm.*;
import org.apache.xml.utils.WrappedRuntimeException;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.axes.OneStepIterator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.NodeIterator;

// Referenced classes of package framework.ressource.xalan.xpath.objects:
//            XObject, XString, XBoolean, XNumber, 
//            XNodeSet, XNodeSetForDOM

public class XObjectFactory
{

    public XObjectFactory()
    {
    }

    public static XObject create(Object val)
    {
        XObject result;
        if(val instanceof XObject)
            result = (XObject)val;
        else
        if(val instanceof String)
            result = new XString((String)val);
        else
        if(val instanceof Boolean)
            result = new XBoolean((Boolean)val);
        else
        if(val instanceof Double)
            result = new XNumber((Double)val);
        else
            result = new XObject(val);
        return result;
    }

    public static XObject create(Object val, XPathContext xctxt)
    {
        XObject result;
        if(val instanceof XObject)
            result = (XObject)val;
        else
        if(val instanceof String)
            result = new XString((String)val);
        else
        if(val instanceof Boolean)
            result = new XBoolean((Boolean)val);
        else
        if(val instanceof Number)
            result = new XNumber((Number)val);
        else
        if(val instanceof DTM)
        {
            DTM dtm = (DTM)val;
            try
            {
                int dtmRoot = dtm.getDocument();
                DTMAxisIterator iter = dtm.getAxisIterator(13);
                iter.setStartNode(dtmRoot);
                DTMIterator iterator = new OneStepIterator(iter, 13);
                iterator.setRoot(dtmRoot, xctxt);
                result = new XNodeSet(iterator);
            }
            catch(Exception ex)
            {
                throw new WrappedRuntimeException(ex);
            }
        } else
        if(val instanceof DTMAxisIterator)
        {
            DTMAxisIterator iter = (DTMAxisIterator)val;
            try
            {
                DTMIterator iterator = new OneStepIterator(iter, 13);
                iterator.setRoot(iter.getStartNode(), xctxt);
                result = new XNodeSet(iterator);
            }
            catch(Exception ex)
            {
                throw new WrappedRuntimeException(ex);
            }
        } else
        if(val instanceof DTMIterator)
            result = new XNodeSet((DTMIterator)val);
        else
        if(val instanceof Node)
            result = new XNodeSetForDOM((Node)val, xctxt);
        else
        if(val instanceof NodeList)
            result = new XNodeSetForDOM((NodeList)val, xctxt);
        else
        if(val instanceof NodeIterator)
            result = new XNodeSetForDOM((NodeIterator)val, xctxt);
        else
            result = new XObject(val);
        return result;
    }
}
