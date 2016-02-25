// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncContains.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XBoolean;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            Function2Args, FunctionOneArg

public class FuncContains extends Function2Args
{

    public FuncContains()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        String s1 = super.m_arg0.execute(xctxt).str();
        String s2 = super.m_arg1.execute(xctxt).str();
        if(s1.length() == 0 && s2.length() == 0)
        {
            return XBoolean.S_TRUE;
        } else
        {
            int index = s1.indexOf(s2);
            return index <= -1 ? XBoolean.S_FALSE : XBoolean.S_TRUE;
        }
    }

    static final long serialVersionUID = 0x4690ac9fdbc0e66bL;
}
