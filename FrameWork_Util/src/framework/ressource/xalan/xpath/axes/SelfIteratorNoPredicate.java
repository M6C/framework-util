// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SelfIteratorNoPredicate.java

package framework.ressource.xalan.xpath.axes;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.compiler.Compiler;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            LocPathIterator, PredicatedNodeTest

public class SelfIteratorNoPredicate extends LocPathIterator
{

    SelfIteratorNoPredicate(Compiler compiler, int opPos, int analysis)
        throws TransformerException
    {
        super(compiler, opPos, analysis, false);
    }

    public SelfIteratorNoPredicate()
        throws TransformerException
    {
        super(null);
    }

    public int nextNode()
    {
        if(super.m_foundLast)
            return -1;
        int next;
        super.m_lastFetched = next = -1 != super.m_lastFetched ? -1 : super.m_context;
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

    public int asNode(XPathContext xctxt)
        throws TransformerException
    {
        return xctxt.getCurrentNode();
    }

    public int getLastPos(XPathContext xctxt)
    {
        return 1;
    }

    static final long serialVersionUID = 0xc55713d85c66d5c7L;
}
