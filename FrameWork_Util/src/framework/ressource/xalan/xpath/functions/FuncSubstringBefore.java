// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncSubstringBefore.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.objects.XString;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            Function2Args, FunctionOneArg

public class FuncSubstringBefore extends Function2Args
{

    public FuncSubstringBefore()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        String s1 = super.m_arg0.execute(xctxt).str();
        String s2 = super.m_arg1.execute(xctxt).str();
        int index = s1.indexOf(s2);
        return -1 != index ? new XString(s1.substring(0, index)) : XString.EMPTYSTRING;
    }

    static final long serialVersionUID = 0x390b98dd6bf9b89fL;
}
