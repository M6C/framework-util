// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FilterExprWalker.java

package framework.ressource.xalan.xpath.axes;

import java.util.Vector;
import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.compiler.Compiler;
import framework.ressource.xalan.xpath.objects.XNodeSet;
import framework.ressource.xalan.xpath.operations.Variable;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            AxesWalker, PathComponent, NodeSequence, PredicatedNodeTest, 
//            LocPathIterator, FilterExprIteratorSimple, WalkingIterator

public class FilterExprWalker extends AxesWalker
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
            exp.exprSetParent(FilterExprWalker.this);
            m_expr = exp;
        }

        filterExprOwner()
        {
        }
    }


    public FilterExprWalker(WalkingIterator locPathIterator)
    {
        super(locPathIterator, 20);
        m_mustHardReset = false;
        m_canDetachNodeset = true;
    }

    public void init(Compiler compiler, int opPos, int stepType)
        throws TransformerException
    {
        super.init(compiler, opPos, stepType);
        switch(stepType)
        {
        case 24: // '\030'
        case 25: // '\031'
            m_mustHardReset = true;
            // fall through

        case 22: // '\026'
        case 23: // '\027'
            m_expr = compiler.compile(opPos);
            m_expr.exprSetParent(this);
            if(m_expr instanceof Variable)
                m_canDetachNodeset = false;
            break;

        default:
            m_expr = compiler.compile(opPos + 2);
            m_expr.exprSetParent(this);
            break;
        }
    }

    public void detach()
    {
        super.detach();
        if(m_canDetachNodeset)
            m_exprObj.detach();
        m_exprObj = null;
    }

    public void setRoot(int root)
    {
        super.setRoot(root);
        m_exprObj = FilterExprIteratorSimple.executeFilterExpr(root, super.m_lpi.getXPathContext(), super.m_lpi.getPrefixResolver(), super.m_lpi.getIsTopLevel(), super.m_lpi.m_stackFrame, m_expr);
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        FilterExprWalker clone = (FilterExprWalker)super.clone();
        if(null != m_exprObj)
            clone.m_exprObj = (XNodeSet)m_exprObj.clone();
        return clone;
    }

    public short acceptNode(int n)
    {
        try
        {
            if(getPredicateCount() > 0)
            {
                countProximityPosition(0);
                if(!executePredicates(n, super.m_lpi.getXPathContext()))
                    return 3;
            }
            return 1;
        }
        catch(TransformerException se)
        {
            throw new RuntimeException(se.getMessage());
        }
    }

    public int getNextNode()
    {
        if(null != m_exprObj)
        {
            int next = m_exprObj.nextNode();
            return next;
        } else
        {
            return -1;
        }
    }

    public int getLastPos(XPathContext xctxt)
    {
        return m_exprObj.getLength();
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

    public int getAxis()
    {
        return m_exprObj.getAxis();
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
        FilterExprWalker walker = (FilterExprWalker)expr;
        return m_expr.deepEquals(walker.m_expr);
    }

    static final long serialVersionUID = 0x4bbbce8b5bbeb3b7L;
    private Expression m_expr;
    private transient XNodeSet m_exprObj;
    private boolean m_mustHardReset;
    private boolean m_canDetachNodeset;


}
