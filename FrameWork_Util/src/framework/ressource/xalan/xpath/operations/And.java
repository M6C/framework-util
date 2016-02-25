// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   And.java

package framework.ressource.xalan.xpath.operations;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XBoolean;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.operations:
//            Operation

public class And extends Operation
{

    public And()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        XObject expr1 = super.m_left.execute(xctxt);
        if(expr1.bool())
        {
            XObject expr2 = super.m_right.execute(xctxt);
            return expr2.bool() ? XBoolean.S_TRUE : XBoolean.S_FALSE;
        } else
        {
            return XBoolean.S_FALSE;
        }
    }

    public boolean bool(XPathContext xctxt)
        throws TransformerException
    {
        return super.m_left.bool(xctxt) && super.m_right.bool(xctxt);
    }

    static final long serialVersionUID = 0x571d62061d42386L;
}
