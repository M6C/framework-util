// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncStartsWith.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import org.apache.xml.utils.XMLString;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XBoolean;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            Function2Args, FunctionOneArg

public class FuncStartsWith extends Function2Args
{

    public FuncStartsWith()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        return super.m_arg0.execute(xctxt).xstr().startsWith(super.m_arg1.execute(xctxt).xstr()) ? XBoolean.S_TRUE : XBoolean.S_FALSE;
    }

    static final long serialVersionUID = 0x1e74bc227a17db38L;
}
