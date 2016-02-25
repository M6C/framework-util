// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncLast.java

package framework.ressource.xalan.xpath.functions;

import java.util.Vector;
import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTMIterator;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.axes.SubContextList;
import framework.ressource.xalan.xpath.compiler.Compiler;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            Function

public class FuncLast extends Function
{

    public FuncLast()
    {
    }

    public void postCompileStep(Compiler compiler)
    {
        m_isTopLevel = compiler.getLocationPathDepth() == -1;
    }

    public int getCountOfContextNodeList(XPathContext xctxt)
        throws TransformerException
    {
        SubContextList iter = m_isTopLevel ? null : xctxt.getSubContextList();
        if(null != iter)
            return iter.getLastPos(xctxt);
        DTMIterator cnl = xctxt.getContextNodeList();
        int count;
        if(null != cnl)
            count = cnl.getLength();
        else
            count = 0;
        return count;
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        XNumber xnum = new XNumber(getCountOfContextNodeList(xctxt));
        return xnum;
    }

    public void fixupVariables(Vector vector, int i)
    {
    }

    static final long serialVersionUID = 0x7fc19d9b2acad86fL;
    private boolean m_isTopLevel;
}
