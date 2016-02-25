// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ChildTestIterator.java

package framework.ressource.xalan.xpath.axes;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.*;
import framework.ressource.xalan.xpath.compiler.Compiler;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            BasicTestIterator, LocPathIterator

public class ChildTestIterator extends BasicTestIterator
{

    ChildTestIterator(Compiler compiler, int opPos, int analysis)
        throws TransformerException
    {
        super(compiler, opPos, analysis);
    }

    public ChildTestIterator(DTMAxisTraverser traverser)
    {
        super(null);
        m_traverser = traverser;
    }

    protected int getNextNode()
    {
        super.m_lastFetched = -1 != super.m_lastFetched ? m_traverser.next(super.m_context, super.m_lastFetched) : m_traverser.first(super.m_context);
        return super.m_lastFetched;
    }

    public DTMIterator cloneWithReset()
        throws CloneNotSupportedException
    {
        ChildTestIterator clone = (ChildTestIterator)super.cloneWithReset();
        clone.m_traverser = m_traverser;
        return clone;
    }

    public void setRoot(int context, Object environment)
    {
        super.setRoot(context, environment);
        m_traverser = super.m_cdtm.getAxisTraverser(3);
    }

    public int getAxis()
    {
        return 3;
    }

    public void detach()
    {
        if(super.m_allowDetach)
        {
            m_traverser = null;
            super.detach();
        }
    }

    static final long serialVersionUID = 0x91dab1bf55347946L;
    protected transient DTMAxisTraverser m_traverser;
}
