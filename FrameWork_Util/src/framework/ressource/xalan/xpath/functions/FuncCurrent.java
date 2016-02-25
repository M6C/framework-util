// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncCurrent.java

package framework.ressource.xalan.xpath.functions;

import java.util.Vector;
import javax.xml.transform.TransformerException;
import org.apache.xalan.res.XSLMessages;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.axes.LocPathIterator;
import framework.ressource.xalan.xpath.axes.PredicatedNodeTest;
import framework.ressource.xalan.xpath.objects.XNodeSet;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.patterns.StepPattern;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            Function

public class FuncCurrent extends Function
{

    public FuncCurrent()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        framework.ressource.xalan.xpath.axes.SubContextList subContextList = xctxt.getCurrentNodeList();
        int currentNode = -1;
        if(null != subContextList)
        {
            if(subContextList instanceof PredicatedNodeTest)
            {
                LocPathIterator iter = ((PredicatedNodeTest)subContextList).getLocPathIterator();
                currentNode = iter.getCurrentContextNode();
            } else
            if(subContextList instanceof StepPattern)
                throw new RuntimeException(XSLMessages.createMessage("ER_PROCESSOR_ERROR", null));
        } else
        {
            currentNode = xctxt.getContextNode();
        }
        return new XNodeSet(currentNode, xctxt.getDTMManager());
    }

    public void fixupVariables(Vector vector, int i)
    {
    }

    static final long serialVersionUID = 0x4f50e25a5d8e8640L;
}
