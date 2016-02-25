// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExtensionsProvider.java

package framework.ressource.xalan.xpath;

import java.util.Vector;
import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.functions.FuncExtFunction;

public interface ExtensionsProvider
{

    public abstract boolean functionAvailable(String s, String s1)
        throws TransformerException;

    public abstract boolean elementAvailable(String s, String s1)
        throws TransformerException;

    public abstract Object extFunction(String s, String s1, Vector vector, Object obj)
        throws TransformerException;

    public abstract Object extFunction(FuncExtFunction funcextfunction, Vector vector)
        throws TransformerException;
}
