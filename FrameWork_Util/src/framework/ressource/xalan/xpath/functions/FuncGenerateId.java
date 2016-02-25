// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncGenerateId.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.objects.XString;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionDef1Arg

public class FuncGenerateId extends FunctionDef1Arg
{

    public FuncGenerateId()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        int which = getArg0AsNode(xctxt);
        if(-1 != which)
            return new XString("N" + Integer.toHexString(which).toUpperCase());
        else
            return XString.EMPTYSTRING;
    }

    static final long serialVersionUID = 0xd82b9e035ca7df1L;
}
