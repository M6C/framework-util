// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncTrue.java

package framework.ressource.xalan.xpath.functions;

import java.util.Vector;
import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XBoolean;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            Function

public class FuncTrue extends Function
{

    public FuncTrue()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        return XBoolean.S_TRUE;
    }

    public void fixupVariables(Vector vector, int i)
    {
    }

    static final long serialVersionUID = 0x4e98229345e17677L;
}
