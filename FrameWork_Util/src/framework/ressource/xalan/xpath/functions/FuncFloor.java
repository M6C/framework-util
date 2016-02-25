// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncFloor.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionOneArg

public class FuncFloor extends FunctionOneArg
{

    public FuncFloor()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        return new XNumber(Math.floor(super.m_arg0.execute(xctxt).num()));
    }

    static final long serialVersionUID = 0x204a48d41665a511L;
}
