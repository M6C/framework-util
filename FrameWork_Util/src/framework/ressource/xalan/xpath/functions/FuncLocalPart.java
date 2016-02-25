// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncLocalPart.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.objects.XString;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionDef1Arg

public class FuncLocalPart extends FunctionDef1Arg
{

    public FuncLocalPart()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        int context = getArg0AsNode(xctxt);
        if(-1 == context)
            return XString.EMPTYSTRING;
        DTM dtm = xctxt.getDTM(context);
        String s = context == -1 ? "" : dtm.getLocalName(context);
        if(s.startsWith("#") || s.equals("xmlns"))
            return XString.EMPTYSTRING;
        else
            return new XString(s);
    }

    static final long serialVersionUID = 0x695b7cc22f847ddaL;
}
