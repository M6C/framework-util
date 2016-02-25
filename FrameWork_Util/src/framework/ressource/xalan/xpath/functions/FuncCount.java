// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncCount.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTMIterator;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionOneArg

public class FuncCount extends FunctionOneArg
{

    public FuncCount()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        DTMIterator nl = super.m_arg0.asIterator(xctxt, xctxt.getCurrentNode());
        int i = nl.getLength();
        nl.detach();
        return new XNumber(i);
    }

    static final long serialVersionUID = 0x9d3e16f9788504e9L;
}
