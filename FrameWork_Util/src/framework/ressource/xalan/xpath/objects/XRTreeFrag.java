// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XRTreeFrag.java

package framework.ressource.xalan.xpath.objects;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import org.apache.xml.dtm.DTMIterator;
import org.apache.xml.dtm.ref.DTMNodeIterator;
import org.apache.xml.dtm.ref.DTMNodeList;
import org.apache.xml.utils.*;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.axes.RTFIterator;
import org.w3c.dom.NodeList;

// Referenced classes of package framework.ressource.xalan.xpath.objects:
//            XObject, XString, DTMXRTreeFrag

public class XRTreeFrag extends XObject
    implements Cloneable
{

    public XRTreeFrag(int root, XPathContext xctxt, ExpressionNode parent)
    {
        super(null);
        m_dtmRoot = -1;
        m_allowRelease = false;
        m_xmlStr = null;
        exprSetParent(parent);
        initDTM(root, xctxt);
    }

    public XRTreeFrag(int root, XPathContext xctxt)
    {
        super(null);
        m_dtmRoot = -1;
        m_allowRelease = false;
        m_xmlStr = null;
        initDTM(root, xctxt);
    }

    private final void initDTM(int root, XPathContext xctxt)
    {
        m_dtmRoot = root;
        DTM dtm = xctxt.getDTM(root);
        if(dtm != null)
            m_DTMXRTreeFrag = xctxt.getDTMXRTreeFrag(xctxt.getDTMIdentity(dtm));
    }

    public Object object()
    {
        if(m_DTMXRTreeFrag.getXPathContext() != null)
            return new DTMNodeIterator(new NodeSetDTM(m_dtmRoot, m_DTMXRTreeFrag.getXPathContext().getDTMManager()));
        else
            return super.object();
    }

    public XRTreeFrag(Expression expr)
    {
        super(expr);
        m_dtmRoot = -1;
        m_allowRelease = false;
        m_xmlStr = null;
    }

    public void allowDetachToRelease(boolean allowRelease)
    {
        m_allowRelease = allowRelease;
    }

    public void detach()
    {
        if(m_allowRelease)
        {
            m_DTMXRTreeFrag.destruct();
            setObject(null);
        }
    }

    public int getType()
    {
        return 5;
    }

    public String getTypeString()
    {
        return "#RTREEFRAG";
    }

    public double num()
        throws TransformerException
    {
        XMLString s = xstr();
        return s.toDouble();
    }

    public boolean bool()
    {
        return true;
    }

    public XMLString xstr()
    {
        if(null == m_xmlStr)
            m_xmlStr = m_DTMXRTreeFrag.getDTM().getStringValue(m_dtmRoot);
        return m_xmlStr;
    }

    public void appendToFsb(FastStringBuffer fsb)
    {
        XString xstring = (XString)xstr();
        xstring.appendToFsb(fsb);
    }

    public String str()
    {
        String str = m_DTMXRTreeFrag.getDTM().getStringValue(m_dtmRoot).toString();
        return null != str ? str : "";
    }

    public int rtf()
    {
        return m_dtmRoot;
    }

    public DTMIterator asNodeIterator()
    {
        return new RTFIterator(m_dtmRoot, m_DTMXRTreeFrag.getXPathContext().getDTMManager());
    }

    public NodeList convertToNodeset()
    {
        if(super.m_obj instanceof NodeList)
            return (NodeList)super.m_obj;
        else
            return new DTMNodeList(asNodeIterator());
    }

    public boolean equals(XObject obj2)
    {
        try
        {
            if(4 == obj2.getType())
                return obj2.equals(this);
            if(1 == obj2.getType())
                return bool() == obj2.bool();
            if(2 == obj2.getType())
                return num() == obj2.num();
            if(4 == obj2.getType())
                return xstr().equals(obj2.xstr());
            if(3 == obj2.getType())
                return xstr().equals(obj2.xstr());
            if(5 == obj2.getType())
                return xstr().equals(obj2.xstr());
            else
                return super.equals(obj2);
        }
        catch(TransformerException te)
        {
            throw new WrappedRuntimeException(te);
        }
    }

    static final long serialVersionUID = 0xd391cbc2df33afb1L;
    private DTMXRTreeFrag m_DTMXRTreeFrag;
    private int m_dtmRoot;
    protected boolean m_allowRelease;
    private XMLString m_xmlStr;
}
