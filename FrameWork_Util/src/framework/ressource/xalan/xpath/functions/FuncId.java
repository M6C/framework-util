// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncId.java

package framework.ressource.xalan.xpath.functions;

import java.util.StringTokenizer;
import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import org.apache.xml.dtm.DTMIterator;
import org.apache.xml.utils.StringVector;
import org.apache.xml.utils.XMLString;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.objects.XNodeSet;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionOneArg

public class FuncId extends FunctionOneArg
{

    public FuncId()
    {
    }

    private StringVector getNodesByID(XPathContext xctxt, int docContext, String refval, StringVector usedrefs, NodeSetDTM nodeSet, boolean mayBeMore)
    {
        if(null != refval)
        {
            String ref = null;
            StringTokenizer tokenizer = new StringTokenizer(refval);
            boolean hasMore = tokenizer.hasMoreTokens();
            DTM dtm = xctxt.getDTM(docContext);
            while(hasMore) 
            {
                ref = tokenizer.nextToken();
                hasMore = tokenizer.hasMoreTokens();
                if(null != usedrefs && usedrefs.contains(ref))
                {
                    ref = null;
                } else
                {
                    int node = dtm.getElementById(ref);
                    if(-1 != node)
                        nodeSet.addNodeInDocOrder(node, xctxt);
                    if(null != ref && (hasMore || mayBeMore))
                    {
                        if(null == usedrefs)
                            usedrefs = new StringVector();
                        usedrefs.addElement(ref);
                    }
                }
            }
        }
        return usedrefs;
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        int context = xctxt.getCurrentNode();
        DTM dtm = xctxt.getDTM(context);
        int docContext = dtm.getDocument();
        if(-1 == docContext)
            error(xctxt, "ER_CONTEXT_HAS_NO_OWNERDOC", null);
        XObject arg = super.m_arg0.execute(xctxt);
        int argType = arg.getType();
        XNodeSet nodes = new XNodeSet(xctxt.getDTMManager());
        NodeSetDTM nodeSet = nodes.mutableNodeset();
        if(4 == argType)
        {
            DTMIterator ni = arg.iter();
            StringVector usedrefs = null;
            for(int pos = ni.nextNode(); -1 != pos;)
            {
                DTM ndtm = ni.getDTM(pos);
                String refval = ndtm.getStringValue(pos).toString();
                pos = ni.nextNode();
                usedrefs = getNodesByID(xctxt, docContext, refval, usedrefs, nodeSet, -1 != pos);
            }

        } else
        {
            if(-1 == argType)
                return nodes;
            String refval = arg.str();
            getNodesByID(xctxt, docContext, refval, null, nodeSet, false);
        }
        return nodes;
    }

    static final long serialVersionUID = 0x7befc5b4bc56b5ceL;
}
