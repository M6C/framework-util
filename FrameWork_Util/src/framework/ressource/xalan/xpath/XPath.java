// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPath.java

package framework.ressource.xalan.xpath;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Vector;
import javax.xml.transform.*;
import org.apache.xml.utils.*;
import framework.ressource.xalan.xpath.compiler.Compiler;
import framework.ressource.xalan.xpath.compiler.FunctionTable;
import framework.ressource.xalan.xpath.compiler.XPathParser;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.res.XPATHMessages;
import org.w3c.dom.Node;

// Referenced classes of package framework.ressource.xalan.xpath:
//            ExpressionNode, ExpressionOwner, Expression, XPathContext, 
//            XPathVisitor

public class XPath
    implements Serializable, ExpressionOwner
{

    private void initFunctionTable()
    {
        m_funcTable = new FunctionTable();
    }

    public Expression getExpression()
    {
        return m_mainExp;
    }

    public void fixupVariables(Vector vars, int globalsSize)
    {
        m_mainExp.fixupVariables(vars, globalsSize);
    }

    public void setExpression(Expression exp)
    {
        if(null != m_mainExp)
            exp.exprSetParent(m_mainExp.exprGetParent());
        m_mainExp = exp;
    }

    public SourceLocator getLocator()
    {
        return m_mainExp;
    }

    public String getPatternString()
    {
        return m_patternString;
    }

    public XPath(String exprString, SourceLocator locator, PrefixResolver prefixResolver, int type, ErrorListener errorListener)
        throws TransformerException
    {
        m_funcTable = null;
        initFunctionTable();
        if(null == errorListener)
            errorListener = new DefaultErrorHandler();
        m_patternString = exprString;
        XPathParser parser = new XPathParser(errorListener, locator);
        Compiler compiler = new Compiler(errorListener, locator, m_funcTable);
        if(0 == type)
            parser.initXPath(compiler, exprString, prefixResolver);
        else
        if(1 == type)
            parser.initMatchPattern(compiler, exprString, prefixResolver);
        else
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_CANNOT_DEAL_XPATH_TYPE", new Object[] {
                Integer.toString(type)
            }));
        Expression expr = compiler.compile(0);
        setExpression(expr);
        if(null != locator && (locator instanceof ExpressionNode))
            expr.exprSetParent((ExpressionNode)locator);
    }

    public XPath(String exprString, SourceLocator locator, PrefixResolver prefixResolver, int type, ErrorListener errorListener, FunctionTable aTable)
        throws TransformerException
    {
        m_funcTable = null;
        m_funcTable = aTable;
        if(null == errorListener)
            errorListener = new DefaultErrorHandler();
        m_patternString = exprString;
        XPathParser parser = new XPathParser(errorListener, locator);
        Compiler compiler = new Compiler(errorListener, locator, m_funcTable);
        if(0 == type)
            parser.initXPath(compiler, exprString, prefixResolver);
        else
        if(1 == type)
            parser.initMatchPattern(compiler, exprString, prefixResolver);
        else
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_CANNOT_DEAL_XPATH_TYPE", new Object[] {
                Integer.toString(type)
            }));
        Expression expr = compiler.compile(0);
        setExpression(expr);
        if(null != locator && (locator instanceof ExpressionNode))
            expr.exprSetParent((ExpressionNode)locator);
    }

    public XPath(String exprString, SourceLocator locator, PrefixResolver prefixResolver, int type)
        throws TransformerException
    {
        this(exprString, locator, prefixResolver, type, null);
    }

    public XPath(Expression expr)
    {
        m_funcTable = null;
        setExpression(expr);
        initFunctionTable();
    }

    public XObject execute(XPathContext xctxt, Node contextNode, PrefixResolver namespaceContext)
        throws TransformerException
    {
        return execute(xctxt, xctxt.getDTMHandleFromNode(contextNode), namespaceContext);
    }

    public XObject execute(XPathContext xctxt, int contextNode, PrefixResolver namespaceContext)
        throws TransformerException
    {
        xctxt.pushNamespaceContext(namespaceContext);
        xctxt.pushCurrentNodeAndExpression(contextNode, contextNode);
        XObject xobj = null;
        try
        {
            xobj = m_mainExp.execute(xctxt);
        }
        catch(TransformerException te)
        {
            te.setLocator(getLocator());
            ErrorListener el = xctxt.getErrorListener();
            if(null != el)
                el.error(te);
            else
                throw te;
        }
        catch(Exception e)
        {
            for(; e instanceof WrappedRuntimeException; e = ((WrappedRuntimeException)e).getException());
            String msg = e.getMessage();
            if(msg == null || msg.length() == 0)
                msg = XPATHMessages.createXPATHMessage("ER_XPATH_ERROR", null);
            TransformerException te = new TransformerException(msg, getLocator(), e);
            ErrorListener el = xctxt.getErrorListener();
            if(null != el)
                el.fatalError(te);
            else
                throw te;
        }
        finally
        {
            xctxt.popNamespaceContext();
            xctxt.popCurrentNodeAndExpression();
        }
        return xobj;
    }

    public boolean bool(XPathContext xctxt, int contextNode, PrefixResolver namespaceContext)
        throws TransformerException
    {
        xctxt.pushNamespaceContext(namespaceContext);
        xctxt.pushCurrentNodeAndExpression(contextNode, contextNode);
        try
        {
            boolean flag = m_mainExp.bool(xctxt);
            return flag;
        }
        catch(TransformerException te)
        {
            te.setLocator(getLocator());
            ErrorListener el = xctxt.getErrorListener();
            if(null != el)
                el.error(te);
            else
                throw te;
        }
        catch(Exception e)
        {
            for(; e instanceof WrappedRuntimeException; e = ((WrappedRuntimeException)e).getException());
            String msg = e.getMessage();
            if(msg == null || msg.length() == 0)
                msg = XPATHMessages.createXPATHMessage("ER_XPATH_ERROR", null);
            TransformerException te = new TransformerException(msg, getLocator(), e);
            ErrorListener el = xctxt.getErrorListener();
            if(null != el)
                el.fatalError(te);
            else
                throw te;
        }
        finally
        {
            xctxt.popNamespaceContext();
            xctxt.popCurrentNodeAndExpression();
        }
        return false;
    }

    public double getMatchScore(XPathContext xctxt, int context)
        throws TransformerException
    {
        xctxt.pushCurrentNode(context);
        xctxt.pushCurrentExpressionNode(context);
        try
        {
            XObject score = m_mainExp.execute(xctxt);
            double d = score.num();
            return d;
        }
        finally
        {
            xctxt.popCurrentNode();
            xctxt.popCurrentExpressionNode();
        }
    }

    public void warn(XPathContext xctxt, int sourceNode, String msg, Object args[])
        throws TransformerException
    {
        String fmsg = XPATHMessages.createXPATHWarning(msg, args);
        ErrorListener ehandler = xctxt.getErrorListener();
        if(null != ehandler)
            ehandler.warning(new TransformerException(fmsg, (SAXSourceLocator)xctxt.getSAXLocator()));
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

    public void error(XPathContext xctxt, int sourceNode, String msg, Object args[])
        throws TransformerException
    {
        String fmsg = XPATHMessages.createXPATHMessage(msg, args);
        ErrorListener ehandler = xctxt.getErrorListener();
        if(null != ehandler)
        {
            ehandler.fatalError(new TransformerException(fmsg, (SAXSourceLocator)xctxt.getSAXLocator()));
        } else
        {
            SourceLocator slocator = xctxt.getSAXLocator();
            System.out.println(fmsg + "; file " + slocator.getSystemId() + "; line " + slocator.getLineNumber() + "; column " + slocator.getColumnNumber());
        }
    }

    public void callVisitors(ExpressionOwner owner, XPathVisitor visitor)
    {
        m_mainExp.callVisitors(this, visitor);
    }

    static final long serialVersionUID = 0x372f57bff437e299L;
    private Expression m_mainExp;
    private transient FunctionTable m_funcTable;
    String m_patternString;
    public static final int SELECT = 0;
    public static final int MATCH = 1;
    private static final boolean DEBUG_MATCHES = false;
    public static final double MATCH_SCORE_NONE = (-1.0D / 0.0D);
    public static final double MATCH_SCORE_QNAME = 0D;
    public static final double MATCH_SCORE_NSWILD = -0.25D;
    public static final double MATCH_SCORE_NODETEST = -0.5D;
    public static final double MATCH_SCORE_OTHER = 0.5D;
}
