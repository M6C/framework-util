// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncUnparsedEntityURI.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.objects.XString;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionOneArg

public class FuncUnparsedEntityURI extends FunctionOneArg
{

    public FuncUnparsedEntityURI()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        String name = super.m_arg0.execute(xctxt).str();
        int context = xctxt.getCurrentNode();
        DTM dtm = xctxt.getDTM(context);
        int doc = dtm.getDocument();
        String uri = dtm.getUnparsedEntityURI(name);
        return new XString(uri);
    }

    static final long serialVersionUID = 0xbbb24bf4c2ca6f2L;
}
