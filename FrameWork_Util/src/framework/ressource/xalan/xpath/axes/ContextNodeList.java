// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ContextNodeList.java

package framework.ressource.xalan.xpath.axes;

import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;

public interface ContextNodeList
{

    public abstract Node getCurrentNode();

    public abstract int getCurrentPos();

    public abstract void reset();

    public abstract void setShouldCacheNodes(boolean flag);

    public abstract void runTo(int i);

    public abstract void setCurrentPos(int i);

    public abstract int size();

    public abstract boolean isFresh();

    public abstract NodeIterator cloneWithReset()
        throws CloneNotSupportedException;

    public abstract Object clone()
        throws CloneNotSupportedException;

    public abstract int getLast();

    public abstract void setLast(int i);
}
