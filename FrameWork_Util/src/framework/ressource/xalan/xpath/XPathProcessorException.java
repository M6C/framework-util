// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPathProcessorException.java

package framework.ressource.xalan.xpath;


// Referenced classes of package framework.ressource.xalan.xpath:
//            XPathException

public class XPathProcessorException extends XPathException
{

    public XPathProcessorException(String message)
    {
        super(message);
    }

    public XPathProcessorException(String message, Exception e)
    {
        super(message, e);
    }

    static final long serialVersionUID = 0x10de5b603c804fabL;
}
