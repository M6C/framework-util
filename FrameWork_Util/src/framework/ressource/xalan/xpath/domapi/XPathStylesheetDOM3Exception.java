// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPathStylesheetDOM3Exception.java

package framework.ressource.xalan.xpath.domapi;

import javax.xml.transform.SourceLocator;
import javax.xml.transform.TransformerException;

public final class XPathStylesheetDOM3Exception extends TransformerException
{

    public XPathStylesheetDOM3Exception(String msg, SourceLocator arg1)
    {
        super(msg, arg1);
    }
}
