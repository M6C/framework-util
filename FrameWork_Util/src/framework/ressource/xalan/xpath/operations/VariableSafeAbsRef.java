// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VariableSafeAbsRef.java

package framework.ressource.xalan.xpath.operations;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import org.apache.xml.dtm.DTMManager;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.axes.NodeSequence;
import framework.ressource.xalan.xpath.objects.XNodeSet;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.operations:
//            Variable

public class VariableSafeAbsRef extends Variable
{

    public VariableSafeAbsRef()
    {
    }

    public XObject execute(XPathContext xctxt, boolean destructiveOK)
        throws TransformerException
    {
        XNodeSet xns = (XNodeSet)super.execute(xctxt, destructiveOK);
        DTMManager dtmMgr = xctxt.getDTMManager();
        int context = xctxt.getContextNode();
        if(dtmMgr.getDTM(xns.getRoot()).getDocument() != dtmMgr.getDTM(context).getDocument())
        {
            Expression expr = (Expression)xns.getContainedIter();
            xns = (XNodeSet)expr.asIterator(xctxt, context);
        }
        return xns;
    }

    static final long serialVersionUID = 0x80ad0d875ee5ce24L;
}
