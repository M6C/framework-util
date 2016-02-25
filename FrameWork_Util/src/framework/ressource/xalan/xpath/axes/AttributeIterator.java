// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AttributeIterator.java

package framework.ressource.xalan.xpath.axes;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import framework.ressource.xalan.xpath.compiler.Compiler;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            ChildTestIterator, LocPathIterator

public class AttributeIterator extends ChildTestIterator
{

    AttributeIterator(Compiler compiler, int opPos, int analysis)
        throws TransformerException
    {
        super(compiler, opPos, analysis);
    }

    protected int getNextNode()
    {
        super.m_lastFetched = -1 != super.m_lastFetched ? super.m_cdtm.getNextAttribute(super.m_lastFetched) : super.m_cdtm.getFirstAttribute(super.m_context);
        return super.m_lastFetched;
    }

    public int getAxis()
    {
        return 2;
    }

    static final long serialVersionUID = 0x8b2d4db23415c4caL;
}
