// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FunctionDef1Arg.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import org.apache.xml.utils.XMLString;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.objects.XString;
import framework.ressource.xalan.xpath.res.XPATHMessages;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionOneArg, WrongNumberArgsException

public class FunctionDef1Arg extends FunctionOneArg
{

    public FunctionDef1Arg()
    {
    }

    protected int getArg0AsNode(XPathContext xctxt)
        throws TransformerException
    {
        return null != super.m_arg0 ? super.m_arg0.asNode(xctxt) : xctxt.getCurrentNode();
    }

    public boolean Arg0IsNodesetExpr()
    {
        return null != super.m_arg0 ? super.m_arg0.isNodesetExpr() : true;
    }

    protected XMLString getArg0AsString(XPathContext xctxt)
        throws TransformerException
    {
        if(null == super.m_arg0)
        {
            int currentNode = xctxt.getCurrentNode();
            if(-1 == currentNode)
            {
                return XString.EMPTYSTRING;
            } else
            {
                DTM dtm = xctxt.getDTM(currentNode);
                return dtm.getStringValue(currentNode);
            }
        } else
        {
            return super.m_arg0.execute(xctxt).xstr();
        }
    }

    protected double getArg0AsNumber(XPathContext xctxt)
        throws TransformerException
    {
        if(null == super.m_arg0)
        {
            int currentNode = xctxt.getCurrentNode();
            if(-1 == currentNode)
            {
                return 0.0D;
            } else
            {
                DTM dtm = xctxt.getDTM(currentNode);
                XMLString str = dtm.getStringValue(currentNode);
                return str.toDouble();
            }
        } else
        {
            return super.m_arg0.execute(xctxt).num();
        }
    }

    public void checkNumberArgs(int argNum)
        throws WrongNumberArgsException
    {
        if(argNum > 1)
            reportWrongNumberArgs();
    }

    protected void reportWrongNumberArgs()
        throws WrongNumberArgsException
    {
        throw new WrongNumberArgsException(XPATHMessages.createXPATHMessage("ER_ZERO_OR_ONE", null));
    }

    public boolean canTraverseOutsideSubtree()
    {
        return null != super.m_arg0 ? super.canTraverseOutsideSubtree() : false;
    }

    static final long serialVersionUID = 0x2044bb739a495690L;
}
