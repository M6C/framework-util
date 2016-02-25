// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Equals.java

package framework.ressource.xalan.xpath.operations;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XBoolean;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.operations:
//            Operation

public class Equals extends Operation
{

    public Equals()
    {
    }

    public XObject operate(XObject left, XObject right)
        throws TransformerException
    {
        return left.equals(right) ? XBoolean.S_TRUE : XBoolean.S_FALSE;
    }

    public boolean bool(XPathContext xctxt)
        throws TransformerException
    {
        XObject left = super.m_left.execute(xctxt, true);
        XObject right = super.m_right.execute(xctxt, true);
        boolean result = left.equals(right);
        left.detach();
        right.detach();
        return result;
    }

    static final long serialVersionUID = 0xdb1bc403ec51a5aaL;
}
