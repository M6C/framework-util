// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncTranslate.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.objects.XString;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            Function3Args, FunctionOneArg, Function2Args

public class FuncTranslate extends Function3Args
{

    public FuncTranslate()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        String theFirstString = super.m_arg0.execute(xctxt).str();
        String theSecondString = super.m_arg1.execute(xctxt).str();
        String theThirdString = super.m_arg2.execute(xctxt).str();
        int theFirstStringLength = theFirstString.length();
        int theThirdStringLength = theThirdString.length();
        StringBuffer sbuffer = new StringBuffer();
        for(int i = 0; i < theFirstStringLength; i++)
        {
            char theCurrentChar = theFirstString.charAt(i);
            int theIndex = theSecondString.indexOf(theCurrentChar);
            if(theIndex < 0)
                sbuffer.append(theCurrentChar);
            else
            if(theIndex < theThirdStringLength)
                sbuffer.append(theThirdString.charAt(theIndex));
        }

        return new XString(sbuffer.toString());
    }

    static final long serialVersionUID = 0xe8c8e607e2ab167eL;
}
