// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncConcat.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.objects.XString;
import framework.ressource.xalan.xpath.res.XPATHMessages;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionMultiArgs, WrongNumberArgsException, FunctionOneArg, Function2Args, 
//            Function3Args

public class FuncConcat extends FunctionMultiArgs
{

    public FuncConcat()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        StringBuffer sb = new StringBuffer();
        sb.append(super.m_arg0.execute(xctxt).str());
        sb.append(super.m_arg1.execute(xctxt).str());
        if(null != super.m_arg2)
            sb.append(super.m_arg2.execute(xctxt).str());
        if(null != super.m_args)
        {
            for(int i = 0; i < super.m_args.length; i++)
                sb.append(super.m_args[i].execute(xctxt).str());

        }
        return new XString(sb.toString());
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
        throw new WrongNumberArgsException(XPATHMessages.createXPATHMessage("gtone", null));
    }

    static final long serialVersionUID = 0x181be077840824adL;
}
