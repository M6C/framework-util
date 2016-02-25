// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncNamespace.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.objects.XString;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionDef1Arg

public class FuncNamespace extends FunctionDef1Arg
{

    public FuncNamespace()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        int context = getArg0AsNode(xctxt);
        String s;
        if(context != -1)
        {
            DTM dtm = xctxt.getDTM(context);
            int t = dtm.getNodeType(context);
            if(t == 1)
                s = dtm.getNamespaceURI(context);
            else
            if(t == 2)
            {
                s = dtm.getNodeName(context);
                if(s.startsWith("xmlns:") || s.equals("xmlns"))
                    return XString.EMPTYSTRING;
                s = dtm.getNamespaceURI(context);
            } else
            {
                return XString.EMPTYSTRING;
            }
        } else
        {
            return XString.EMPTYSTRING;
        }
        return null != s ? new XString(s) : XString.EMPTYSTRING;
    }

    static final long serialVersionUID = 0xbed59cdc3dae04abL;
}
