// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UnaryOperation.java

package framework.ressource.xalan.xpath.operations;

import java.util.Vector;
import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.objects.XObject;

public abstract class UnaryOperation extends Expression
    implements ExpressionOwner
{

    public UnaryOperation()
    {
    }

    public void fixupVariables(Vector vars, int globalsSize)
    {
        m_right.fixupVariables(vars, globalsSize);
    }

    public boolean canTraverseOutsideSubtree()
    {
        return null != m_right && m_right.canTraverseOutsideSubtree();
    }

    public void setRight(Expression r)
    {
        m_right = r;
        r.exprSetParent(this);
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        return operate(m_right.execute(xctxt));
    }

    public abstract XObject operate(XObject xobject)
        throws TransformerException;

    public Expression getOperand()
    {
        return m_right;
    }

    public void callVisitors(ExpressionOwner owner, XPathVisitor visitor)
    {
        if(visitor.visitUnaryOperation(owner, this))
            m_right.callVisitors(this, visitor);
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
        return m_right.deepEquals(((UnaryOperation)expr).m_right);
    }

    static final long serialVersionUID = 0x5ab4d598174fd7d6L;
    protected Expression m_right;
}
