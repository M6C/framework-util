// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncString.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.objects.XString;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionDef1Arg

public class FuncString extends FunctionDef1Arg
{

    public FuncString()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        return (XString)getArg0AsString(xctxt);
    }

    static final long serialVersionUID = 0xe1604ed2f2379f0dL;
}
