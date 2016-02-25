// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ChildIterator.java

package framework.ressource.xalan.xpath.axes;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.compiler.Compiler;
import framework.ressource.xalan.xpath.patterns.NodeTest;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            LocPathIterator, PredicatedNodeTest

public class ChildIterator extends LocPathIterator
{

    ChildIterator(Compiler compiler, int opPos, int analysis)
        throws TransformerException
    {
        super(compiler, opPos, analysis, false);
        initNodeTest(-1);
    }

    public int asNode(XPathContext xctxt)
        throws TransformerException
    {
        int current = xctxt.getCurrentNode();
        DTM dtm = xctxt.getDTM(current);
        return dtm.getFirstChild(current);
    }

    public int nextNode()
    {
        if(super.m_foundLast)
            return -1;
        int next;
        super.m_lastFetched = next = -1 != super.m_lastFetched ? super.m_cdtm.getNextSibling(super.m_lastFetched) : super.m_cdtm.getFirstChild(super.m_context);
        if(-1 != next)
        {
            super.m_pos++;
            return next;
        } else
        {
            super.m_foundLast = true;
            return -1;
        }
    }

    public int getAxis()
    {
        return 3;
    }

    static final long serialVersionUID = 0x9fc068f7381c0151L;
}
