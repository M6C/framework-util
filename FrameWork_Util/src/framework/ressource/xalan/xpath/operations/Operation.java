// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Operation.java

package framework.ressource.xalan.xpath.operations;

import java.util.Vector;
import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.objects.XObject;

public class Operation extends Expression
    implements ExpressionOwner
{
    class LeftExprOwner
        implements ExpressionOwner
    {

        public Expression getExpression()
        {
            return m_left;
        }

        public void setExpression(Expression exp)
        {
            exp.exprSetParent(Operation.this);
            m_left = exp;
        }

        LeftExprOwner()
        {
        }
    }


    public Operation()
    {
    }

    public void fixupVariables(Vector vars, int globalsSize)
    {
        m_left.fixupVariables(vars, globalsSize);
        m_right.fixupVariables(vars, globalsSize);
    }

    public boolean canTraverseOutsideSubtree()
    {
        if(null != m_left && m_left.canTraverseOutsideSubtree())
            return true;
        return null != m_right && m_right.canTraverseOutsideSubtree();
    }

    public void setLeftRight(Expression l, Expression r)
    {
        m_left = l;
        m_right = r;
        l.exprSetParent(this);
        r.exprSetParent(this);
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        XObject left = m_left.execute(xctxt, true);
        XObject right = m_right.execute(xctxt, true);
        XObject result = operate(left, right);
        left.detach();
        right.detach();
        return result;
    }

    public XObject operate(XObject left, XObject right)
        throws TransformerException
    {
        return null;
    }

    public Expression getLeftOperand()
    {
        return m_left;
    }

    public Expression getRightOperand()
    {
        return m_right;
    }

    public void callVisitors(ExpressionOwner owner, XPathVisitor visitor)
    {
        if(visitor.visitBinaryOperation(owner, this))
        {
            m_left.callVisitors(new LeftExprOwner(), visitor);
            m_right.callVisitors(this, visitor);
        }
    }

    public Expression getExpression()
    {
        return m_right;
    }

    public void setExpression(Expression exp)
    {
        exp.exprSetParent(this);
        m_right = exp;
    }

    public boolean deepEquals(Expression expr)
    {
        if(!isSameClass(expr))
            return false;
        if(!m_left.deepEquals(((Operation)expr).m_left))
            return false;
        return m_right.deepEquals(((Operation)expr).m_right);
    }

    static final long serialVersionUID = 0xd5d9e9aeb1a01042L;
    protected Expression m_left;
    protected Expression m_right;
}
