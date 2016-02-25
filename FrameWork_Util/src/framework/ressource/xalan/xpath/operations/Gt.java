// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Gt.java

package framework.ressource.xalan.xpath.operations;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.objects.XBoolean;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.operations:
//            Operation

public class Gt extends Operation
{

    public Gt()
    {
    }

    public XObject operate(XObject left, XObject right)
        throws TransformerException
    {
        return left.greaterThan(right) ? XBoolean.S_TRUE : XBoolean.S_FALSE;
    }

    static final long serialVersionUID = 0x7be35ad38c26520eL;
}
