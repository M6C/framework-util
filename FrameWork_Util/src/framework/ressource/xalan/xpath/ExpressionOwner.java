// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExpressionOwner.java

package framework.ressource.xalan.xpath;


// Referenced classes of package framework.ressource.xalan.xpath:
//            Expression

public interface ExpressionOwner
{

    public abstract Expression getExpression();

    public abstract void setExpression(Expression expression);
}
