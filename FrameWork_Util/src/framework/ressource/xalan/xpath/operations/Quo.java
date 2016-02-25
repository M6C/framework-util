// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Quo.java

package framework.ressource.xalan.xpath.operations;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.operations:
//            Operation

/**
 * @deprecated Class Quo is deprecated
 */

public class Quo extends Operation
{

    public Quo()
    {
    }

    public XObject operate(XObject left, XObject right)
        throws TransformerException
    {
        return new XNumber((int)(left.num() / right.num()));
    }

    static final long serialVersionUID = 0x9a0bfdd28148eb1L;
}
