// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FilterExprIteratorSimple.java

package framework.ressource.xalan.xpath.axes;

import java.util.Vector;
import javax.xml.transform.TransformerException;
import org.apache.xml.utils.PrefixResolver;
import org.apache.xml.utils.WrappedRuntimeException;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.objects.XNodeSet;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            LocPathIterator, PathComponent, NodeSequence, PredicatedNodeTest

public class FilterExprIteratorSimple extends LocPathIterator
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
            exp.exprSetParent(FilterExprIteratorSimple.this);
            m_expr = exp;
        }

        filterExprOwner()
        {
        }
    }


    public FilterExprIteratorSimple()
    {
        super(null);
        m_mustHardReset = false;
        m_canDetachNodeset = true;
    }

    public FilterExprIteratorSimple(Expression expr)
    {
        super(null);
        m_mustHardReset = false;
        m_canDetachNodeset = true;
        m_expr = expr;
    }

    public void setRoot(int context, Object environment)
    {
        super.setRoot(context, environment);
        m_exprObj = executeFilterExpr(context, super.m_execContext, getPrefixResolver(), getIsTopLevel(), super.m_stackFrame, m_expr);
    }

    public static XNodeSet executeFilterExpr(int context, XPathContext xctxt, PrefixResolver prefixResolver, boolean isTopLevel, int stackFrame, Expression expr)
        throws WrappedRuntimeException
    {
        PrefixResolver savedResolver = xctxt.getNamespaceContext();
        XNodeSet result = null;
        try
        {
            xctxt.pushCurrentNode(context);
            xctxt.setNamespaceContext(prefixResolver);
            if(isTopLevel)
            {
                VariableStack vars = xctxt.getVarStack();
                int savedStart = vars.getStackFrame();
                vars.setStackFrame(stackFrame);
                result = (XNodeSet)expr.execute(xctxt);
                result.setShouldCacheNodes(true);
                vars.setStackFrame(savedStart);
            } else
            {
                result = (XNodeSet)expr.execute(xctxt);
            }
        }
        catch(TransformerException se)
        {
            throw new WrappedRuntimeException(se);
        }
        finally
        {
            xctxt.popCurrentNode();
            xctxt.setNamespaceContext(savedResolver);
        }
        return result;
    }

    public int nextNode()
    {
        if(super.m_foundLast)
            return -1;
        int next;
        if(null != m_exprObj)
            super.m_lastFetched = next = m_exprObj.nextNode();
        else
            super.m_lastFetched = next = -1;
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

    public void detach()
    {
        if(super.m_allowDetach)
        {
            super.detach();
            m_exprObj.detach();
            m_exprObj = null;
        }
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
        FilterExprIteratorSimple fet = (FilterExprIteratorSimple)expr;
        return m_expr.deepEquals(fet.m_expr);
    }

    public int getAxis()
    {
        if(null != m_exprObj)
            return m_exprObj.getAxis();
        else
            return 20;
    }

    static final long serialVersionUID = 0x9f25b1397fcc2ea5L;
    private Expression m_expr;
    private transient XNodeSet m_exprObj;
    private boolean m_mustHardReset;
    private boolean m_canDetachNodeset;


}
