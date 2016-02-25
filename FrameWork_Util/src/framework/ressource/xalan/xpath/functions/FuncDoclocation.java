// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncDoclocation.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.objects.XString;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionDef1Arg

public class FuncDoclocation extends FunctionDef1Arg
{

    public FuncDoclocation()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        int whereNode = getArg0AsNode(xctxt);
        String fileLocation = null;
        if(-1 != whereNode)
        {
            DTM dtm = xctxt.getDTM(whereNode);
            if(11 == dtm.getNodeType(whereNode))
                whereNode = dtm.getFirstChild(whereNode);
            if(-1 != whereNode)
                fileLocation = dtm.getDocumentBaseURI();
        }
        return new XString(null == fileLocation ? "" : fileLocation);
    }

    static final long serialVersionUID = 0x67a7fa82b733b581L;
}
