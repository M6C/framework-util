// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OneStepIteratorForward.java

package framework.ressource.xalan.xpath.axes;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import org.apache.xml.dtm.DTMAxisTraverser;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.compiler.Compiler;
import framework.ressource.xalan.xpath.compiler.OpMap;
import framework.ressource.xalan.xpath.patterns.NodeTest;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            ChildTestIterator, WalkerFactory, LocPathIterator, PredicatedNodeTest

public class OneStepIteratorForward extends ChildTestIterator
{

    OneStepIteratorForward(Compiler compiler, int opPos, int analysis)
        throws TransformerException
    {
        super(compiler, opPos, analysis);
        m_axis = -1;
        int firstStepPos = OpMap.getFirstChildPos(opPos);
        m_axis = WalkerFactory.getAxisFromStep(compiler, firstStepPos);
    }

    public OneStepIteratorForward(int axis)
    {
        super(null);
        m_axis = -1;
        m_axis = axis;
        int whatToShow = -1;
        initNodeTest(whatToShow);
    }

    public void setRoot(int context, Object environment)
    {
        super.setRoot(context, environment);
        super.m_traverser = super.m_cdtm.getAxisTraverser(m_axis);
    }

    protected int getNextNode()
    {
        super.m_lastFetched = -1 != super.m_lastFetched ? super.m_traverser.next(super.m_context, super.m_lastFetched) : super.m_traverser.first(super.m_context);
        return super.m_lastFetched;
    }

    public int getAxis()
    {
        return m_axis;
    }

    public boolean deepEquals(Expression expr)
    {
        if(!super.deepEquals(expr))
            return false;
        return m_axis == ((OneStepIteratorForward)expr).m_axis;
    }

    static final long serialVersionUID = 0xea1d9882fb705b1aL;
    protected int m_axis;
}
