// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncSubstringAfter.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import org.apache.xml.utils.XMLString;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.objects.XString;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            Function2Args, FunctionOneArg

public class FuncSubstringAfter extends Function2Args
{

    public FuncSubstringAfter()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        XMLString s1 = super.m_arg0.execute(xctxt).xstr();
        XMLString s2 = super.m_arg1.execute(xctxt).xstr();
        int index = s1.indexOf(s2);
        return -1 != index ? (XString)s1.substring(index + s2.length()) : XString.EMPTYSTRING;
    }

    static final long serialVersionUID = 0x8f50eaddc95571beL;
}
