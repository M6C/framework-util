// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncSum.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import org.apache.xml.dtm.DTMIterator;
import org.apache.xml.utils.XMLString;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionOneArg

public class FuncSum extends FunctionOneArg
{

    public FuncSum()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        DTMIterator nodes = super.m_arg0.asIterator(xctxt, xctxt.getCurrentNode());
        double sum = 0.0D;
        int i;
        while(-1 != (i = nodes.nextNode())) 
        {
            DTM dtm = nodes.getDTM(i);
            XMLString s = dtm.getStringValue(i);
            if(null != s)
                sum += s.toDouble();
        }
        nodes.detach();
        return new XNumber(sum);
    }

    static final long serialVersionUID = 0xda43ff1ac4432ff1L;
}
