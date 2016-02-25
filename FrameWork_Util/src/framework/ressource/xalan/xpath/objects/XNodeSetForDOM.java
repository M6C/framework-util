// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XNodeSetForDOM.java

package framework.ressource.xalan.xpath.objects;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTMManager;
import framework.ressource.xalan.xpath.NodeSetDTM;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.axes.NodeSequence;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.NodeIterator;

// Referenced classes of package framework.ressource.xalan.xpath.objects:
//            XNodeSet, XObject

public class XNodeSetForDOM extends XNodeSet
{

    public XNodeSetForDOM(Node node, DTMManager dtmMgr)
    {
        super.m_dtmMgr = dtmMgr;
        m_origObj = node;
        int dtmHandle = dtmMgr.getDTMHandleFromNode(node);
        setObject(new NodeSetDTM(dtmMgr));
        ((NodeSetDTM)super.m_obj).addNode(dtmHandle);
    }

    public XNodeSetForDOM(XNodeSet val)
    {
        super(val);
        if(val instanceof XNodeSetForDOM)
            m_origObj = ((XNodeSetForDOM)val).m_origObj;
    }

    public XNodeSetForDOM(NodeList nodeList, XPathContext xctxt)
    {
        super.m_dtmMgr = xctxt.getDTMManager();
        m_origObj = nodeList;
        NodeSetDTM nsdtm = new NodeSetDTM(nodeList, xctxt);
        super.m_last = nsdtm.getLength();
        setObject(nsdtm);
    }

    public XNodeSetForDOM(NodeIterator nodeIter, XPathContext xctxt)
    {
        super.m_dtmMgr = xctxt.getDTMManager();
        m_origObj = nodeIter;
        NodeSetDTM nsdtm = new NodeSetDTM(nodeIter, xctxt);
        super.m_last = nsdtm.getLength();
        setObject(nsdtm);
    }

    public Object object()
    {
        return m_origObj;
    }

    public NodeIterator nodeset()
        throws TransformerException
    {
        return (m_origObj instanceof NodeIterator) ? (NodeIterator)m_origObj : super.nodeset();
    }

    public NodeList nodelist()
        throws TransformerException
    {
        return (m_origObj instanceof NodeList) ? (NodeList)m_origObj : super.nodelist();
    }

    static final long serialVersionUID = 0x8b7abd07e038dd80L;
    Object m_origObj;
}
