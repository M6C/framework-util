// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   String.java

package framework.ressource.xalan.xpath.operations;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.objects.XString;

// Referenced classes of package framework.ressource.xalan.xpath.operations:
//            UnaryOperation

public class String extends UnaryOperation
{

    public String()
    {
    }

    public XObject operate(XObject right)
        throws TransformerException
    {
        return (XString)right.xstr();
    }

    static final long serialVersionUID = 0x29438c3e2055eea8L;
}
