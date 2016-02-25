// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SubContextList.java

package framework.ressource.xalan.xpath.axes;

import framework.ressource.xalan.xpath.XPathContext;

public interface SubContextList
{

    public abstract int getLastPos(XPathContext xpathcontext);

    public abstract int getProximityPosition(XPathContext xpathcontext);
}
