// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExpressionNode.java

package framework.ressource.xalan.xpath;

import javax.xml.transform.SourceLocator;

public interface ExpressionNode
    extends SourceLocator
{

    public abstract void exprSetParent(ExpressionNode expressionnode);

    public abstract ExpressionNode exprGetParent();

    public abstract void exprAddChild(ExpressionNode expressionnode, int i);

    public abstract ExpressionNode exprGetChild(int i);

    public abstract int exprGetNumChildren();
}
