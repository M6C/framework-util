// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncQname.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.objects.XString;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionDef1Arg

public class FuncQname extends FunctionDef1Arg
{

    public FuncQname()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        int context = getArg0AsNode(xctxt);
        XObject val;
        if(-1 != context)
        {
            DTM dtm = xctxt.getDTM(context);
            String qname = dtm.getNodeNameX(context);
            val = null != qname ? ((XObject) (new XString(qname))) : ((XObject) (XString.EMPTYSTRING));
        } else
        {
            val = XString.EMPTYSTRING;
        }
        return val;
    }

    static final long serialVersionUID = 0xeabc261b1058495cL;
}
