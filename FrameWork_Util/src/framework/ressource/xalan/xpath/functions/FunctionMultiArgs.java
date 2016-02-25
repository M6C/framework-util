// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FunctionMultiArgs.java

package framework.ressource.xalan.xpath.functions;

import java.util.Vector;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.res.XPATHMessages;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            Function3Args, WrongNumberArgsException

public class FunctionMultiArgs extends Function3Args
{
    class ArgMultiOwner
        implements ExpressionOwner
    {

        public Expression getExpression()
        {
            return m_args[m_argIndex];
        }

        public void setExpression(Expression exp)
        {
            exp.exprSetParent(FunctionMultiArgs.this);
            m_args[m_argIndex] = exp;
        }

        int m_argIndex;

        ArgMultiOwner(int index)
        {
            m_argIndex = index;
        }
    }


    public FunctionMultiArgs()
    {
    }

    public Expression[] getArgs()
    {
        return m_args;
    }

    public void setArg(Expression arg, int argNum)
        throws WrongNumberArgsException
    {
        if(argNum < 3)
        {
            super.setArg(arg, argNum);
        } else
        {
            if(null == m_args)
            {
                m_args = new Expression[1];
                m_args[0] = arg;
            } else
            {
                Expression args[] = new Expression[m_args.length + 1];
                System.arraycopy(m_args, 0, args, 0, m_args.length);
                args[m_args.length] = arg;
                m_args = args;
            }
            arg.exprSetParent(this);
        }
    }

    public void fixupVariables(Vector vars, int globalsSize)
    {
        super.fixupVariables(vars, globalsSize);
        if(null != m_args)
        {
            for(int i = 0; i < m_args.length; i++)
                m_args[i].fixupVariables(vars, globalsSize);

        }
    }

    public void checkNumberArgs(int i)
        throws WrongNumberArgsException
    {
    }

    protected void reportWrongNumberArgs()
        throws WrongNumberArgsException
    {
        String fMsg = XPATHMessages.createXPATHMessage("ER_INCORRECT_PROGRAMMER_ASSERTION", new Object[] {
            "Programmer's assertion:  the method FunctionMultiArgs.reportWrongNumberArgs() should never be called."
        });
        throw new RuntimeException(fMsg);
    }

    public boolean canTraverseOutsideSubtree()
    {
        if(super.canTraverseOutsideSubtree())
            return true;
        int n = m_args.length;
        for(int i = 0; i < n; i++)
            if(m_args[i].canTraverseOutsideSubtree())
                return true;

        return false;
    }

    public void callArgVisitors(XPathVisitor visitor)
    {
        super.callArgVisitors(visitor);
        if(null != m_args)
        {
            int n = m_args.length;
            for(int i = 0; i < n; i++)
                m_args[i].callVisitors(new ArgMultiOwner(i), visitor);

        }
    }

    public boolean deepEquals(Expression expr)
    {
        if(!super.deepEquals(expr))
            return false;
        FunctionMultiArgs fma = (FunctionMultiArgs)expr;
        if(null != m_args)
        {
            int n = m_args.length;
            if(null == fma || fma.m_args.length != n)
                return false;
            for(int i = 0; i < n; i++)
                if(!m_args[i].deepEquals(fma.m_args[i]))
                    return false;

        } else
        if(null != fma.m_args)
            return false;
        return true;
    }

    static final long serialVersionUID = 0x62c59436157a481dL;
    Expression m_args[];
}
