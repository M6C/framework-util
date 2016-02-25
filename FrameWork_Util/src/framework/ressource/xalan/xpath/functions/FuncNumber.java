// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncNumber.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionDef1Arg

public class FuncNumber extends FunctionDef1Arg
{

    public FuncNumber()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        return new XNumber(getArg0AsNumber(xctxt));
    }

    static final long serialVersionUID = 0x64d8aa634ee113f4L;
}
