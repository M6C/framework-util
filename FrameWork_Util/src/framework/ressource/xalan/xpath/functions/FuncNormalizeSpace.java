// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncNormalizeSpace.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import org.apache.xml.utils.XMLString;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.objects.XString;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionDef1Arg

public class FuncNormalizeSpace extends FunctionDef1Arg
{

    public FuncNormalizeSpace()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        XMLString s1 = getArg0AsString(xctxt);
        return (XString)s1.fixWhiteSpace(true, true, false);
    }

    public void executeCharsToContentHandler(XPathContext xctxt, ContentHandler handler)
        throws TransformerException, SAXException
    {
        if(Arg0IsNodesetExpr())
        {
            int node = getArg0AsNode(xctxt);
            if(-1 != node)
            {
                DTM dtm = xctxt.getDTM(node);
                dtm.dispatchCharactersEvents(node, handler, true);
            }
        } else
        {
            XObject obj = execute(xctxt);
            obj.dispatchCharactersEvents(handler);
        }
    }

    static final long serialVersionUID = 0xd11f161f3fee7e60L;
}
