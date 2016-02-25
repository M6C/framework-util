// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Expression.java

package framework.ressource.xalan.xpath;

import java.io.Serializable;
import java.util.Vector;
import javax.xml.transform.*;
import org.apache.xml.dtm.DTM;
import org.apache.xml.dtm.DTMIterator;
import org.apache.xml.utils.XMLString;
import framework.ressource.xalan.xpath.objects.XNodeSet;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.res.XPATHMessages;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

// Referenced classes of package framework.ressource.xalan.xpath:
//            ExpressionNode, XPathVisitable, XPathContext, ExpressionOwner, 
//            XPathVisitor

public abstract class Expression
    implements Serializable, ExpressionNode, XPathVisitable
{

    public Expression()
    {
    }

    public boolean canTraverseOutsideSubtree()
    {
        return false;
    }

    public XObject execute(XPathContext xctxt, int currentNode)
        throws TransformerException
    {
        return execute(xctxt);
    }

    public XObject execute(XPathContext xctxt, int currentNode, DTM dtm, int expType)
        throws TransformerException
    {
        return execute(xctxt);
    }

    public abstract XObject execute(XPathContext xpathcontext)
        throws TransformerException;

    public XObject execute(XPathContext xctxt, boolean destructiveOK)
        throws TransformerException
    {
        return execute(xctxt);
    }

    public double num(XPathContext xctxt)
        throws TransformerException
    {
        return execute(xctxt).num();
    }

    public boolean bool(XPathContext xctxt)
        throws TransformerException
    {
        return execute(xctxt).bool();
    }

    public XMLString xstr(XPathContext xctxt)
        throws TransformerException
    {
        return execute(xctxt).xstr();
    }

    public boolean isNodesetExpr()
    {
        return false;
    }

    public int asNode(XPathContext xctxt)
        throws TransformerException
    {
        DTMIterator iter = execute(xctxt).iter();
        return iter.nextNode();
    }

    public DTMIterator asIterator(XPathContext xctxt, int contextNode)
        throws TransformerException
    {
        try
        {
            xctxt.pushCurrentNodeAndExpression(contextNode, contextNode);
            DTMIterator dtmiterator = execute(xctxt).iter();
            return dtmiterator;
        }
        finally
        {
            xctxt.popCurrentNodeAndExpression();
        }
    }

    public DTMIterator asIteratorRaw(XPathContext xctxt, int contextNode)
        throws TransformerException
    {
        try
        {
            xctxt.pushCurrentNodeAndExpression(contextNode, contextNode);
            XNodeSet nodeset = (XNodeSet)execute(xctxt);
            DTMIterator dtmiterator = nodeset.iterRaw();
            return dtmiterator;
        }
        finally
        {
            xctxt.popCurrentNodeAndExpression();
        }
    }

    public void executeCharsToContentHandler(XPathContext xctxt, ContentHandler handler)
        throws TransformerException, SAXException
    {
        XObject obj = execute(xctxt);
        obj.dispatchCharactersEvents(handler);
        obj.detach();
    }

    public boolean isStableNumber()
    {
        return false;
    }

    public abstract void fixupVariables(Vector vector, int i);

    public abstract boolean deepEquals(Expression expression);

    protected final boolean isSameClass(Expression expr)
    {
        if(null == expr)
            return false;
        else
            return getClass() == expr.getClass();
    }

    public void warn(XPathContext xctxt, String msg, Object args[])
        throws TransformerException
    {
        String fmsg = XPATHMessages.createXPATHWarning(msg, args);
        if(null != xctxt)
        {
            ErrorListener eh = xctxt.getErrorListener();
            eh.warning(new TransformerException(fmsg, xctxt.getSAXLocator()));
        }
    }

    public void assertion(boolean b, String msg)
    {
        if(!b)
        {
            String fMsg = XPATHMessages.createXPATHMessage("ER_INCORRECT_PROGRAMMER_ASSERTION", new Object[] {
                msg
            });
            throw new RuntimeException(fMsg);
        } else
        {
            return;
        }
    }

    public void error(XPathContext xctxt, String msg, Object args[])
        throws TransformerException
    {
        String fmsg = XPATHMessages.createXPATHMessage(msg, args);
        if(null != xctxt)
        {
            ErrorListener eh = xctxt.getErrorListener();
            TransformerException te = new TransformerException(fmsg, this);
            eh.fatalError(te);
        }
    }

    public ExpressionNode getExpressionOwner()
    {
        ExpressionNode parent;
        for(parent = exprGetParent(); null != parent && (parent instanceof Expression); parent = parent.exprGetParent());
        return parent;
    }

    public void exprSetParent(ExpressionNode n)
    {
        assertion(n != this, "Can not parent an expression to itself!");
        m_parent = n;
    }

    public ExpressionNode exprGetParent()
    {
        return m_parent;
    }

    public void exprAddChild(ExpressionNode n, int i)
    {
        assertion(false, "exprAddChild method not implemented!");
    }

    public ExpressionNode exprGetChild(int i)
    {
        return null;
    }

    public int exprGetNumChildren()
    {
        return 0;
    }

    public String getPublicId()
    {
        if(null == m_parent)
            return null;
        else
            return m_parent.getPublicId();
    }

    public String getSystemId()
    {
        if(null == m_parent)
            return null;
        else
            return m_parent.getSystemId();
    }

    public int getLineNumber()
    {
        if(null == m_parent)
            return 0;
        else
            return m_parent.getLineNumber();
    }

    public int getColumnNumber()
    {
        if(null == m_parent)
            return 0;
        else
            return m_parent.getColumnNumber();
    }

    public abstract void callVisitors(ExpressionOwner expressionowner, XPathVisitor xpathvisitor);

    static final long serialVersionUID = 0x7d9a61c8dacacd6L;
    private ExpressionNode m_parent;
}
