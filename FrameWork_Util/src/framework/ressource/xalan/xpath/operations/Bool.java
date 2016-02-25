// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Bool.java

package framework.ressource.xalan.xpath.operations;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XBoolean;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.operations:
//            UnaryOperation

public class Bool extends UnaryOperation
{

    public Bool()
    {
    }

    public XObject operate(XObject right)
        throws TransformerException
    {
        if(1 == right.getType())
            return right;
        else
            return right.bool() ? XBoolean.S_TRUE : XBoolean.S_FALSE;
    }

    public boolean bool(XPathContext xctxt)
        throws TransformerException
    {
        return super.m_right.bool(xctxt);
    }

    static final long serialVersionUID = 0x9ed34d4f9cfd0bL;
}
