// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HasPositionalPredChecker.java

package framework.ressource.xalan.xpath.axes;

import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.functions.*;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.operations.*;
import framework.ressource.xalan.xpath.operations.Number;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            LocPathIterator

public class HasPositionalPredChecker extends XPathVisitor
{

    public HasPositionalPredChecker()
    {
        m_hasPositionalPred = false;
        m_predDepth = 0;
    }

    public static boolean check(LocPathIterator path)
    {
        HasPositionalPredChecker hppc = new HasPositionalPredChecker();
        path.callVisitors(null, hppc);
        return hppc.m_hasPositionalPred;
    }

    public boolean visitFunction(ExpressionOwner owner, Function func)
    {
        if((func instanceof FuncPosition) || (func instanceof FuncLast))
            m_hasPositionalPred = true;
        return true;
    }

    public boolean visitPredicate(ExpressionOwner owner, Expression pred)
    {
        m_predDepth++;
        if(m_predDepth == 1)
            if((pred instanceof Variable) || (pred instanceof XNumber) || (pred instanceof Div) || (pred instanceof Plus) || (pred instanceof Minus) || (pred instanceof Mod) || (pred instanceof Quo) || (pred instanceof Mult) || (pred instanceof Number) || (pred instanceof Function))
                m_hasPositionalPred = true;
            else
                pred.callVisitors(owner, this);
        m_predDepth--;
        return false;
    }

    private boolean m_hasPositionalPred;
    private int m_predDepth;
}
