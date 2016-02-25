// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncSubstring.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import org.apache.xml.utils.XMLString;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.objects.XString;
import framework.ressource.xalan.xpath.res.XPATHMessages;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            Function3Args, WrongNumberArgsException, FunctionOneArg, Function2Args

public class FuncSubstring extends Function3Args
{

    public FuncSubstring()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        XMLString s1 = super.m_arg0.execute(xctxt).xstr();
        double start = super.m_arg1.execute(xctxt).num();
        int lenOfS1 = s1.length();
        if(lenOfS1 <= 0)
            return XString.EMPTYSTRING;
        int startIndex;
        if(Double.isNaN(start))
        {
            start = -1000000D;
            startIndex = 0;
        } else
        {
            start = Math.round(start);
            startIndex = start <= 0.0D ? 0 : (int)start - 1;
        }
        XMLString substr;
        if(null != super.m_arg2)
        {
            double len = super.m_arg2.num(xctxt);
            int end = (int)((double)Math.round(len) + start) - 1;
            if(end < 0)
                end = 0;
            else
            if(end > lenOfS1)
                end = lenOfS1;
            if(startIndex > lenOfS1)
                startIndex = lenOfS1;
            substr = s1.substring(startIndex, end);
        } else
        {
            if(startIndex > lenOfS1)
                startIndex = lenOfS1;
            substr = s1.substring(startIndex);
        }
        return (XString)substr;
    }

    public void checkNumberArgs(int argNum)
        throws WrongNumberArgsException
    {
        if(argNum < 2)
            reportWrongNumberArgs();
    }

    protected void reportWrongNumberArgs()
        throws WrongNumberArgsException
    {
        throw new WrongNumberArgsException(XPATHMessages.createXPATHMessage("ER_TWO_OR_THREE", null));
    }

    static final long serialVersionUID = 0xacc786dd02f9a912L;
}
