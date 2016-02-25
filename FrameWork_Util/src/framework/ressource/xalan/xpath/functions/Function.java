// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Function.java

package framework.ressource.xalan.xpath.functions;

import java.io.PrintStream;
import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.compiler.Compiler;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.res.XPATHMessages;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            WrongNumberArgsException

public abstract class Function extends Expression
{

    public Function()
    {
    }

    public void setArg(Expression arg, int argNum)
        throws WrongNumberArgsException
    {
        reportWrongNumberArgs();
    }

    public void checkNumberArgs(int argNum)
        throws WrongNumberArgsException
    {
        if(argNum != 0)
            reportWrongNumberArgs();
    }

    protected void reportWrongNumberArgs()
        throws WrongNumberArgsException
    {
        throw new WrongNumberArgsException(XPATHMessages.createXPATHMessage("zero", null));
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        System.out.println("Error! Function.execute should not be called!");
        return null;
    }

    public void callArgVisitors(XPathVisitor xpathvisitor)
    {
    }

    public void callVisitors(ExpressionOwner owner, XPathVisitor visitor)
    {
        if(visitor.visitFunction(owner, this))
            callArgVisitors(visitor);
    }

    public boolean deepEquals(Expression expr)
    {
        return isSameClass(expr);
    }

    public void postCompileStep(Compiler compiler1)
    {
    }

    static final long serialVersionUID = 0x6023ff31b9615858L;
}
