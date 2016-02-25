// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPathException.java

package framework.ressource.xalan.xpath;

import java.io.PrintStream;
import java.io.PrintWriter;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Node;

// Referenced classes of package framework.ressource.xalan.xpath:
//            Expression, ExpressionNode

public class XPathException extends TransformerException
{

    public Object getStylesheetNode()
    {
        return m_styleNode;
    }

    public void setStylesheetNode(Object styleNode)
    {
        m_styleNode = styleNode;
    }

    public XPathException(String message, ExpressionNode ex)
    {
        super(message);
        m_styleNode = null;
        setLocator(ex);
        setStylesheetNode(getStylesheetNode(ex));
    }

    public XPathException(String message)
    {
        super(message);
        m_styleNode = null;
    }

    public Node getStylesheetNode(ExpressionNode ex)
    {
        ExpressionNode owner = getExpressionOwner(ex);
        if(null != owner && (owner instanceof Node))
            return (Node)owner;
        else
            return null;
    }

    protected ExpressionNode getExpressionOwner(ExpressionNode ex)
    {
        ExpressionNode parent;
        for(parent = ex.exprGetParent(); null != parent && (parent instanceof Expression); parent = parent.exprGetParent());
        return parent;
    }

    public XPathException(String message, Object styleNode)
    {
        super(message);
        m_styleNode = null;
        m_styleNode = styleNode;
    }

    public XPathException(String message, Node styleNode, Exception e)
    {
        super(message);
        m_styleNode = null;
        m_styleNode = styleNode;
        m_exception = e;
    }

    public XPathException(String message, Exception e)
    {
        super(message);
        m_styleNode = null;
        m_exception = e;
    }

    public void printStackTrace(PrintStream s)
    {
        if(s == null)
            s = System.err;
        try
        {
            super.printStackTrace(s);
        }
        catch(Exception e) { }
        Throwable exception = m_exception;
        for(int i = 0; i < 10 && null != exception; i++)
        {
            s.println("---------");
            exception.printStackTrace(s);
            if(exception instanceof TransformerException)
            {
                TransformerException se = (TransformerException)exception;
                Throwable prev = exception;
                exception = se.getException();
                if(prev == exception)
                    break;
            } else
            {
                exception = null;
            }
        }

    }

    public String getMessage()
    {
        String lastMessage = super.getMessage();
        for(Throwable exception = m_exception; null != exception;)
        {
            String nextMessage = exception.getMessage();
            if(null != nextMessage)
                lastMessage = nextMessage;
            if(exception instanceof TransformerException)
            {
                TransformerException se = (TransformerException)exception;
                Throwable prev = exception;
                exception = se.getException();
                if(prev == exception)
                    break;
            } else
            {
                exception = null;
            }
        }

        return null == lastMessage ? "" : lastMessage;
    }

    public void printStackTrace(PrintWriter s)
    {
        if(s == null)
            s = new PrintWriter(System.err);
        try
        {
            super.printStackTrace(s);
        }
        catch(Exception e) { }
        boolean isJdk14OrHigher = false;
        try
        {
            (java.lang.Throwable.class).getMethod("getCause", null);
            isJdk14OrHigher = true;
        }
        catch(NoSuchMethodException nsme) { }
        if(!isJdk14OrHigher)
        {
            Throwable exception = m_exception;
            for(int i = 0; i < 10 && null != exception; i++)
            {
                s.println("---------");
                try
                {
                    exception.printStackTrace(s);
                }
                catch(Exception e)
                {
                    s.println("Could not print stack trace...");
                }
                if(exception instanceof TransformerException)
                {
                    TransformerException se = (TransformerException)exception;
                    Throwable prev = exception;
                    exception = se.getException();
                    if(prev != exception)
                        continue;
                    exception = null;
                    break;
                }
                exception = null;
            }

        }
    }

    public Throwable getException()
    {
        return m_exception;
    }

    static final long serialVersionUID = 0x3b2b2be100e6764bL;
    Object m_styleNode;
    protected Exception m_exception;
}
