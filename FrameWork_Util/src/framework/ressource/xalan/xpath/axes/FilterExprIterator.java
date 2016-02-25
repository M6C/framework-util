// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FilterExprIterator.java

package framework.ressource.xalan.xpath.axes;

import java.util.Vector;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.objects.XNodeSet;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            BasicTestIterator, PathComponent, LocPathIterator, FilterExprIteratorSimple, 
//            NodeSequence, PredicatedNodeTest

public class FilterExprIterator extends BasicTestIterator
{
    class filterExprOwner
        implements ExpressionOwner
    {

        public Expression getExpression()
        {
            return m_expr;
        }

        public void setExpression(Expression exp)
        {
            exp.exprSetParent(FilterExprIterator.this);
            m_expr = exp;
        }

        filterExprOwner()
        {
        }
    }


    public FilterExprIterator()
    {
        super(null);
        m_mustHardReset = false;
        m_canDetachNodeset = true;
    }

    public FilterExprIterator(Expression expr)
    {
        super(null);
        m_mustHardReset = false;
        m_canDetachNodeset = true;
        m_expr = expr;
    }

    public void setRoot(int context, Object environment)
    {
        super.setRoot(context, environment);
        m_exprObj = FilterExprIteratorSimple.executeFilterExpr(context, super.m_execContext, getPrefixResolver(), getIsTopLevel(), super.m_stackFrame, m_expr);
    }

    protected int getNextNode()
    {
        if(null != m_exprObj)
            super.m_lastFetched = m_exprObj.nextNode();
        else
            super.m_lastFetched = -1;
        return super.m_lastFetched;
    }

    public void detach()
    {
        super.detach();
        m_exprObj.detach();
        m_exprObj = null;
    }

    public void fixupVariables(Vector vars, int globalsSize)
    {
        super.fixupVariables(vars, globalsSize);
        m_expr.fixupVariables(vars, globalsSize);
    }

    public Expression getInnerExpression()
    {
        return m_expr;
    }

    public void setInnerExpression(Expression expr)
    {
        expr.exprSetParent(this);
        m_expr = expr;
    }

    public int getAnalysisBits()
    {
        if(null != m_expr && (m_expr instanceof PathComponent))
            return ((PathComponent)m_expr).getAnalysisBits();
        else
            return 0x4000000;
    }

    public boolean isDocOrdered()
    {
        return m_exprObj.isDocOrdered();
    }

    public void callPredicateVisitors(XPathVisitor visitor)
    {
        m_expr.callVisitors(new filterExprOwner(), visitor);
        super.callPredicateVisitors(visitor);
    }

    public boolean deepEquals(Expression expr)
    {
        if(!super.deepEquals(expr))
            return false;
        FilterExprIterator fet = (FilterExprIterator)expr;
        return m_expr.deepEquals(fet.m_expr);
    }

    static final long serialVersionUID = 0x236b26a548a4ce8eL;
    private Expression m_expr;
    private transient XNodeSet m_exprObj;
    private boolean m_mustHardReset;
    private boolean m_canDetachNodeset;


}
