// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NodeTest.java

package framework.ressource.xalan.xpath.patterns;

import java.io.PrintStream;
import java.util.Vector;
import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.objects.XObject;

public class NodeTest extends Expression
{

    public int getWhatToShow()
    {
        return m_whatToShow;
    }

    public void setWhatToShow(int what)
    {
        m_whatToShow = what;
    }

    public String getNamespace()
    {
        return m_namespace;
    }

    public void setNamespace(String ns)
    {
        m_namespace = ns;
    }

    public String getLocalName()
    {
        return null != m_name ? m_name : "";
    }

    public void setLocalName(String name)
    {
        m_name = name;
    }

    public NodeTest(int whatToShow, String namespace, String name)
    {
        initNodeTest(whatToShow, namespace, name);
    }

    public NodeTest(int whatToShow)
    {
        initNodeTest(whatToShow);
    }

    public boolean deepEquals(Expression expr)
    {
        if(!isSameClass(expr))
            return false;
        NodeTest nt = (NodeTest)expr;
        if(null != nt.m_name)
        {
            if(null == m_name)
                return false;
            if(!nt.m_name.equals(m_name))
                return false;
        } else
        if(null != m_name)
            return false;
        if(null != nt.m_namespace)
        {
            if(null == m_namespace)
                return false;
            if(!nt.m_namespace.equals(m_namespace))
                return false;
        } else
        if(null != m_namespace)
            return false;
        if(m_whatToShow != nt.m_whatToShow)
            return false;
        return m_isTotallyWild == nt.m_isTotallyWild;
    }

    public NodeTest()
    {
    }

    public void initNodeTest(int whatToShow)
    {
        m_whatToShow = whatToShow;
        calcScore();
    }

    public void initNodeTest(int whatToShow, String namespace, String name)
    {
        m_whatToShow = whatToShow;
        m_namespace = namespace;
        m_name = name;
        calcScore();
    }

    public XNumber getStaticScore()
    {
        return m_score;
    }

    public void setStaticScore(XNumber score)
    {
        m_score = score;
    }

    protected void calcScore()
    {
        if(m_namespace == null && m_name == null)
            m_score = SCORE_NODETEST;
        else
        if((m_namespace == "*" || m_namespace == null) && m_name == "*")
            m_score = SCORE_NODETEST;
        else
        if(m_namespace != "*" && m_name == "*")
            m_score = SCORE_NSWILD;
        else
            m_score = SCORE_QNAME;
        m_isTotallyWild = m_namespace == null && m_name == "*";
    }

    public double getDefaultScore()
    {
        return m_score.num();
    }

    public static int getNodeTypeTest(int whatToShow)
    {
        if(0 != (whatToShow & 1))
            return 1;
        if(0 != (whatToShow & 2))
            return 2;
        if(0 != (whatToShow & 4))
            return 3;
        if(0 != (whatToShow & 0x100))
            return 9;
        if(0 != (whatToShow & 0x400))
            return 11;
        if(0 != (whatToShow & 0x1000))
            return 13;
        if(0 != (whatToShow & 0x80))
            return 8;
        if(0 != (whatToShow & 0x40))
            return 7;
        if(0 != (whatToShow & 0x200))
            return 10;
        if(0 != (whatToShow & 0x20))
            return 6;
        if(0 != (whatToShow & 0x10))
            return 5;
        if(0 != (whatToShow & 0x800))
            return 12;
        return 0 == (whatToShow & 8) ? 0 : 4;
    }

    public static void debugWhatToShow(int whatToShow)
    {
        Vector v = new Vector();
        if(0 != (whatToShow & 2))
            v.addElement("SHOW_ATTRIBUTE");
        if(0 != (whatToShow & 0x1000))
            v.addElement("SHOW_NAMESPACE");
        if(0 != (whatToShow & 8))
            v.addElement("SHOW_CDATA_SECTION");
        if(0 != (whatToShow & 0x80))
            v.addElement("SHOW_COMMENT");
        if(0 != (whatToShow & 0x100))
            v.addElement("SHOW_DOCUMENT");
        if(0 != (whatToShow & 0x400))
            v.addElement("SHOW_DOCUMENT_FRAGMENT");
        if(0 != (whatToShow & 0x200))
            v.addElement("SHOW_DOCUMENT_TYPE");
        if(0 != (whatToShow & 1))
            v.addElement("SHOW_ELEMENT");
        if(0 != (whatToShow & 0x20))
            v.addElement("SHOW_ENTITY");
        if(0 != (whatToShow & 0x10))
            v.addElement("SHOW_ENTITY_REFERENCE");
        if(0 != (whatToShow & 0x800))
            v.addElement("SHOW_NOTATION");
        if(0 != (whatToShow & 0x40))
            v.addElement("SHOW_PROCESSING_INSTRUCTION");
        if(0 != (whatToShow & 4))
            v.addElement("SHOW_TEXT");
        int n = v.size();
        for(int i = 0; i < n; i++)
        {
            if(i > 0)
                System.out.print(" | ");
            System.out.print(v.elementAt(i));
        }

        if(0 == n)
            System.out.print("empty whatToShow: " + whatToShow);
        System.out.println();
    }

    private static final boolean subPartMatch(String p, String t)
    {
        return p == t || null != p && (t == "*" || p.equals(t));
    }

    private static final boolean subPartMatchNS(String p, String t)
    {
        return p == t || null != p && (p.length() <= 0 ? null == t : t == "*" || p.equals(t));
    }

    public XObject execute(XPathContext xctxt, int context)
        throws TransformerException
    {
        DTM dtm = xctxt.getDTM(context);
        short nodeType = dtm.getNodeType(context);
        if(m_whatToShow == -1)
            return m_score;
        int nodeBit = m_whatToShow & 1 << nodeType - 1;
        switch(nodeBit)
        {
        case 256: 
        case 1024: 
            return SCORE_OTHER;

        case 128: 
            return m_score;

        case 4: // '\004'
        case 8: // '\b'
            return m_score;

        case 64: // '@'
            return subPartMatch(dtm.getNodeName(context), m_name) ? m_score : SCORE_NONE;

        case 4096: 
            String ns = dtm.getLocalName(context);
            return subPartMatch(ns, m_name) ? m_score : SCORE_NONE;

        case 1: // '\001'
        case 2: // '\002'
            return !m_isTotallyWild && (!subPartMatchNS(dtm.getNamespaceURI(context), m_namespace) || !subPartMatch(dtm.getLocalName(context), m_name)) ? SCORE_NONE : m_score;
        }
        return SCORE_NONE;
    }

    public XObject execute(XPathContext xctxt, int context, DTM dtm, int expType)
        throws TransformerException
    {
        if(m_whatToShow == -1)
            return m_score;
        int nodeBit = m_whatToShow & 1 << dtm.getNodeType(context) - 1;
        switch(nodeBit)
        {
        case 256: 
        case 1024: 
            return SCORE_OTHER;

        case 128: 
            return m_score;

        case 4: // '\004'
        case 8: // '\b'
            return m_score;

        case 64: // '@'
            return subPartMatch(dtm.getNodeName(context), m_name) ? m_score : SCORE_NONE;

        case 4096: 
            String ns = dtm.getLocalName(context);
            return subPartMatch(ns, m_name) ? m_score : SCORE_NONE;

        case 1: // '\001'
        case 2: // '\002'
            return !m_isTotallyWild && (!subPartMatchNS(dtm.getNamespaceURI(context), m_namespace) || !subPartMatch(dtm.getLocalName(context), m_name)) ? SCORE_NONE : m_score;
        }
        return SCORE_NONE;
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        return execute(xctxt, xctxt.getCurrentNode());
    }

    public void fixupVariables(Vector vector, int i)
    {
    }

    public void callVisitors(ExpressionOwner owner, XPathVisitor visitor)
    {
        assertion(false, "callVisitors should not be called for this object!!!");
    }

    static final long serialVersionUID = 0xb06311db4d46777aL;
    public static final String WILD = "*";
    public static final String SUPPORTS_PRE_STRIPPING = "http://xml.apache.org/xpath/features/whitespace-pre-stripping";
    protected int m_whatToShow;
    public static final int SHOW_BYFUNCTION = 0x10000;
    String m_namespace;
    protected String m_name;
    XNumber m_score;
    public static final XNumber SCORE_NODETEST = new XNumber(-0.5D);
    public static final XNumber SCORE_NSWILD = new XNumber(-0.25D);
    public static final XNumber SCORE_QNAME = new XNumber(0.0D);
    public static final XNumber SCORE_OTHER = new XNumber(0.5D);
    public static final XNumber SCORE_NONE = new XNumber((-1.0D / 0.0D));
    private boolean m_isTotallyWild;

}
