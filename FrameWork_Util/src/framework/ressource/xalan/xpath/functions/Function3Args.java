// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Function3Args.java

package framework.ressource.xalan.xpath.functions;

import java.util.Vector;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.res.XPATHMessages;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            Function2Args, WrongNumberArgsException

public class Function3Args extends Function2Args
{
    class Arg2Owner
        implements ExpressionOwner
    {

        public Expression getExpression()
        {
            return m_arg2;
        }

        public void setExpression(Expression exp)
        {
            exp.exprSetParent(Function3Args.this);
            m_arg2 = exp;
        }

        Arg2Owner()
        {
        }
    }


    public Function3Args()
    {
    }

    public Expression getArg2()
    {
        return m_arg2;
    }

    public void fixupVariables(Vector vars, int globalsSize)
    {
        super.fixupVariables(vars, globalsSize);
        if(null != m_arg2)
            m_arg2.fixupVariables(vars, globalsSize);
    }

    public void setArg(Expression arg, int argNum)
        throws WrongNumberArgsException
    {
        if(argNum < 2)
            super.setArg(arg, argNum);
        else
        if(2 == argNum)
        {
            m_arg2 = arg;
            arg.exprSetParent(this);
        } else
        {
            reportWrongNumberArgs();
        }
    }

    public void checkNumberArgs(int argNum)
        throws WrongNumberArgsException
    {
        if(argNum != 3)
            reportWrongNumberArgs();
    }

    protected void reportWrongNumberArgs()
        throws WrongNumberArgsException
    {
        throw new WrongNumberArgsException(XPATHMessages.createXPATHMessage("three", null));
    }

    public boolean canTraverseOutsideSubtree()
    {
        return super.canTraverseOutsideSubtree() ? true : m_arg2.canTraverseOutsideSubtree();
    }

    public void callArgVisitors(XPathVisitor visitor)
    {
        super.callArgVisitors(visitor);
        if(null != m_arg2)
            m_arg2.callVisitors(new Arg2Owner(), visitor);
    }

    public boolean deepEquals(Expression expr)
    {
        if(!super.deepEquals(expr))
            return false;
        if(null != m_arg2)
        {
            if(null == ((Function3Args)expr).m_arg2)
                return false;
            if(!m_arg2.deepEquals(((Function3Args)expr).m_arg2))
                return false;
        } else
        if(null != ((Function3Args)expr).m_arg2)
            return false;
        return true;
    }

    static final long serialVersionUID = 0x6dd89585d6425356L;
    Expression m_arg2;
}
