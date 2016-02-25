// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncRound.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionOneArg

public class FuncRound extends FunctionOneArg
{

    public FuncRound()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        XObject obj = super.m_arg0.execute(xctxt);
        double val = obj.num();
        if(val >= -0.5D && val < 0.0D)
            return new XNumber(-0D);
        if(val == 0.0D)
            return new XNumber(val);
        else
            return new XNumber(Math.floor(val + 0.5D));
    }

    static final long serialVersionUID = 0x9162cc2baaa3edcdL;
}
