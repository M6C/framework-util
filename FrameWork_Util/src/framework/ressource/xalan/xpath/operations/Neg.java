// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Neg.java

package framework.ressource.xalan.xpath.operations;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.operations:
//            UnaryOperation

public class Neg extends UnaryOperation
{

    public Neg()
    {
    }

    public XObject operate(XObject right)
        throws TransformerException
    {
        return new XNumber(-right.num());
    }

    public double num(XPathContext xctxt)
        throws TransformerException
    {
        return -super.m_right.num(xctxt);
    }

    static final long serialVersionUID = 0xa8d6cc921e5060edL;
}
