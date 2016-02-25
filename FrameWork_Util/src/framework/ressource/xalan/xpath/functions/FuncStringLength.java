// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncStringLength.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import org.apache.xml.utils.XMLString;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionDef1Arg

public class FuncStringLength extends FunctionDef1Arg
{

    public FuncStringLength()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        return new XNumber(getArg0AsString(xctxt).length());
    }

    static final long serialVersionUID = 0xfdc8edb6a8ff4661L;
}
