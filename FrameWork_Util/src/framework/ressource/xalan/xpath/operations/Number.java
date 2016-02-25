// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Number.java

package framework.ressource.xalan.xpath.operations;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.operations:
//            UnaryOperation

public class Number extends UnaryOperation
{

    public Number()
    {
    }

    public XObject operate(XObject right)
        throws TransformerException
    {
        if(2 == right.getType())
            return right;
        else
            return new XNumber(right.num());
    }

    public double num(XPathContext xctxt)
        throws TransformerException
    {
        return super.m_right.num(xctxt);
    }

    static final long serialVersionUID = 0x63e0b7f89837d0b5L;
}
