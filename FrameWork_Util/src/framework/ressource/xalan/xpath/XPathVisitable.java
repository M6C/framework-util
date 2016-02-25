// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPathVisitable.java

package framework.ressource.xalan.xpath;


// Referenced classes of package framework.ressource.xalan.xpath:
//            ExpressionOwner, XPathVisitor

public interface XPathVisitable
{

    public abstract void callVisitors(ExpressionOwner expressionowner, XPathVisitor xpathvisitor);
}
