// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncBoolean.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XBoolean;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionOneArg

public class FuncBoolean extends FunctionOneArg
{

    public FuncBoolean()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        return super.m_arg0.execute(xctxt).bool() ? XBoolean.S_TRUE : XBoolean.S_FALSE;
    }

    static final long serialVersionUID = 0x3c127e06ed2594a0L;
}
