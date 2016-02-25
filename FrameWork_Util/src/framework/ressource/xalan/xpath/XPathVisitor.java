// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPathVisitor.java

package framework.ressource.xalan.xpath;

import framework.ressource.xalan.xpath.axes.LocPathIterator;
import framework.ressource.xalan.xpath.axes.UnionPathIterator;
import framework.ressource.xalan.xpath.functions.Function;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.objects.XString;
import framework.ressource.xalan.xpath.operations.Operation;
import framework.ressource.xalan.xpath.operations.UnaryOperation;
import framework.ressource.xalan.xpath.operations.Variable;
import framework.ressource.xalan.xpath.patterns.NodeTest;
import framework.ressource.xalan.xpath.patterns.StepPattern;
import framework.ressource.xalan.xpath.patterns.UnionPattern;

// Referenced classes of package framework.ressource.xalan.xpath:
//            ExpressionOwner, Expression

public class XPathVisitor
{

    public XPathVisitor()
    {
    }

    public boolean visitLocationPath(ExpressionOwner owner, LocPathIterator path)
    {
        return true;
    }

    public boolean visitUnionPath(ExpressionOwner owner, UnionPathIterator path)
    {
        return true;
    }

    public boolean visitStep(ExpressionOwner owner, NodeTest step)
    {
        return true;
    }

    public boolean visitPredicate(ExpressionOwner owner, Expression pred)
    {
        return true;
    }

    public boolean visitBinaryOperation(ExpressionOwner owner, Operation op)
    {
        return true;
    }

    public boolean visitUnaryOperation(ExpressionOwner owner, UnaryOperation op)
    {
        return true;
    }

    public boolean visitVariableRef(ExpressionOwner owner, Variable var)
    {
        return true;
    }

    public boolean visitFunction(ExpressionOwner owner, Function func)
    {
        return true;
    }

    public boolean visitMatchPattern(ExpressionOwner owner, StepPattern pattern)
    {
        return true;
    }

    public boolean visitUnionPattern(ExpressionOwner owner, UnionPattern pattern)
    {
        return true;
    }

    public boolean visitStringLiteral(ExpressionOwner owner, XString str)
    {
        return true;
    }

    public boolean visitNumberLiteral(ExpressionOwner owner, XNumber num)
    {
        return true;
    }
}
