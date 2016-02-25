// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncPosition.java

package framework.ressource.xalan.xpath.functions;

import java.util.Vector;
import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTMIterator;
import org.apache.xml.utils.WrappedRuntimeException;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.axes.SubContextList;
import framework.ressource.xalan.xpath.compiler.Compiler;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            Function

public class FuncPosition extends Function
{

    public FuncPosition()
    {
    }

    public void postCompileStep(Compiler compiler)
    {
        m_isTopLevel = compiler.getLocationPathDepth() == -1;
    }

    public int getPositionInContextNodeList(XPathContext xctxt)
    {
        SubContextList iter = m_isTopLevel ? null : xctxt.getSubContextList();
        if(null != iter)
        {
            int prox = iter.getProximityPosition(xctxt);
            return prox;
        }
        DTMIterator cnl = xctxt.getContextNodeList();
        if(null != cnl)
        {
            int n = cnl.getCurrentNode();
            if(n == -1)
            {
                if(cnl.getCurrentPos() == 0)
                    return 0;
                try
                {
                    cnl = cnl.cloneWithReset();
                }
                catch(CloneNotSupportedException cnse)
                {
                    throw new WrappedRuntimeException(cnse);
                }
                int currentNode = xctxt.getContextNode();
                while(-1 != (n = cnl.nextNode())) 
                    if(n == currentNode)
                        break;
            }
            return cnl.getCurrentPos();
        } else
        {
            return -1;
        }
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        double pos = getPositionInContextNodeList(xctxt);
        return new XNumber(pos);
    }

    public void fixupVariables(Vector vector, int i)
    {
    }

    static final long serialVersionUID = 0x81cfb86c1a7e67e2L;
    private boolean m_isTopLevel;
}
