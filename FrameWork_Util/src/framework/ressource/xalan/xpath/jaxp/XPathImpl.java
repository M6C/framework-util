// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPathImpl.java

package framework.ressource.xalan.xpath.jaxp;

import java.io.IOException;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFunctionException;
import javax.xml.xpath.XPathFunctionResolver;
import javax.xml.xpath.XPathVariableResolver;
import framework.ressource.xalan.xpath.XPath;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.res.XPATHMessages;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

// Referenced classes of package framework.ressource.xalan.xpath.jaxp:
//            JAXPPrefixResolver, JAXPExtensionsProvider, JAXPVariableStack, XPathExpressionImpl

public class XPathImpl
    implements javax.xml.xpath.XPath
{

    XPathImpl(XPathVariableResolver vr, XPathFunctionResolver fr)
    {
        namespaceContext = null;
        featureSecureProcessing = false;
        origVariableResolver = variableResolver = vr;
        origFunctionResolver = functionResolver = fr;
    }

    XPathImpl(XPathVariableResolver vr, XPathFunctionResolver fr, boolean featureSecureProcessing)
    {
        namespaceContext = null;
        this.featureSecureProcessing = false;
        origVariableResolver = variableResolver = vr;
        origFunctionResolver = functionResolver = fr;
        this.featureSecureProcessing = featureSecureProcessing;
    }

    public void setXPathVariableResolver(XPathVariableResolver resolver)
    {
        if(resolver == null)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_ARG_CANNOT_BE_NULL", new Object[] {
                "XPathVariableResolver"
            });
            throw new NullPointerException(fmsg);
        } else
        {
            variableResolver = resolver;
            return;
        }
    }

    public XPathVariableResolver getXPathVariableResolver()
    {
        return variableResolver;
    }

    public void setXPathFunctionResolver(XPathFunctionResolver resolver)
    {
        if(resolver == null)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_ARG_CANNOT_BE_NULL", new Object[] {
                "XPathFunctionResolver"
            });
            throw new NullPointerException(fmsg);
        } else
        {
            functionResolver = resolver;
            return;
        }
    }

    public XPathFunctionResolver getXPathFunctionResolver()
    {
        return functionResolver;
    }

    public void setNamespaceContext(NamespaceContext nsContext)
    {
        if(nsContext == null)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_ARG_CANNOT_BE_NULL", new Object[] {
                "NamespaceContext"
            });
            throw new NullPointerException(fmsg);
        } else
        {
            namespaceContext = nsContext;
            prefixResolver = new JAXPPrefixResolver(nsContext);
            return;
        }
    }

    public NamespaceContext getNamespaceContext()
    {
        return namespaceContext;
    }

    private static DocumentBuilder getParser()
    {
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            dbf.setValidating(false);
            return dbf.newDocumentBuilder();
        }
        catch(ParserConfigurationException e)
        {
            throw new Error(e.toString());
        }
    }

    private static Document getDummyDocument()
    {
        if(d == null)
        {
            DOMImplementation dim = getParser().getDOMImplementation();
            d = dim.createDocument("http://java.sun.com/jaxp/xpath", "dummyroot", null);
        }
        return d;
    }

    private XObject eval(String expression, Object contextItem)
        throws TransformerException
    {
        XPath xpath = new XPath(expression, null, prefixResolver, 0);
        XPathContext xpathSupport = null;
        if(functionResolver != null)
        {
            JAXPExtensionsProvider jep = new JAXPExtensionsProvider(functionResolver, featureSecureProcessing);
            xpathSupport = new XPathContext(jep, false);
        } else
        {
            xpathSupport = new XPathContext(false);
        }
        XObject xobj = null;
        xpathSupport.setVarStack(new JAXPVariableStack(variableResolver));
        if(contextItem instanceof Node)
            xobj = xpath.execute(xpathSupport, (Node)contextItem, prefixResolver);
        else
            xobj = xpath.execute(xpathSupport, -1, prefixResolver);
        return xobj;
    }

    public Object evaluate(String expression, Object item, QName returnType)
        throws XPathExpressionException
    {
        if(expression == null)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_ARG_CANNOT_BE_NULL", new Object[] {
                "XPath expression"
            });
            throw new NullPointerException(fmsg);
        }
        if(returnType == null)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_ARG_CANNOT_BE_NULL", new Object[] {
                "returnType"
            });
            throw new NullPointerException(fmsg);
        }
        if(!isSupported(returnType))
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_UNSUPPORTED_RETURN_TYPE", new Object[] {
                returnType.toString()
            });
            throw new IllegalArgumentException(fmsg);
        }
        try
        {
            XObject resultObject = eval(expression, item);
            return getResultAsType(resultObject, returnType);
        }
        catch(NullPointerException npe)
        {
            throw new XPathExpressionException(npe);
        }
        catch(TransformerException te)
        {
            Throwable nestedException = te.getException();
            if(nestedException instanceof XPathFunctionException)
                throw (XPathFunctionException)nestedException;
            else
                throw new XPathExpressionException(te);
        }
    }

    private boolean isSupported(QName returnType)
    {
        return returnType.equals(XPathConstants.STRING) || returnType.equals(XPathConstants.NUMBER) || returnType.equals(XPathConstants.BOOLEAN) || returnType.equals(XPathConstants.NODE) || returnType.equals(XPathConstants.NODESET);
    }

    private Object getResultAsType(XObject resultObject, QName returnType)
        throws TransformerException
    {
        if(returnType.equals(XPathConstants.STRING))
            return resultObject.str();
        if(returnType.equals(XPathConstants.NUMBER))
            return new Double(resultObject.num());
        if(returnType.equals(XPathConstants.BOOLEAN))
            return new Boolean(resultObject.bool());
        if(returnType.equals(XPathConstants.NODESET))
            return resultObject.nodelist();
        if(returnType.equals(XPathConstants.NODE))
        {
            NodeIterator ni = resultObject.nodeset();
            return ni.nextNode();
        } else
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_UNSUPPORTED_RETURN_TYPE", new Object[] {
                returnType.toString()
            });
            throw new IllegalArgumentException(fmsg);
        }
    }

    public String evaluate(String expression, Object item)
        throws XPathExpressionException
    {
        return (String)evaluate(expression, item, XPathConstants.STRING);
    }

    public XPathExpression compile(String expression)
        throws XPathExpressionException
    {
        if(expression == null)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_ARG_CANNOT_BE_NULL", new Object[] {
                "XPath expression"
            });
            throw new NullPointerException(fmsg);
        }
        try
        {
            XPath xpath = new XPath(expression, null, prefixResolver, 0);
            XPathExpressionImpl ximpl = new XPathExpressionImpl(xpath, prefixResolver, functionResolver, variableResolver, featureSecureProcessing);
            return ximpl;
        }
        catch(TransformerException te)
        {
            throw new XPathExpressionException(te);
        }
    }

    public Object evaluate(String expression, InputSource source, QName returnType)
        throws XPathExpressionException
    {
        if(source == null)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_ARG_CANNOT_BE_NULL", new Object[] {
                "source"
            });
            throw new NullPointerException(fmsg);
        }
        if(expression == null)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_ARG_CANNOT_BE_NULL", new Object[] {
                "XPath expression"
            });
            throw new NullPointerException(fmsg);
        }
        if(returnType == null)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_ARG_CANNOT_BE_NULL", new Object[] {
                "returnType"
            });
            throw new NullPointerException(fmsg);
        }
        if(!isSupported(returnType))
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_UNSUPPORTED_RETURN_TYPE", new Object[] {
                returnType.toString()
            });
            throw new IllegalArgumentException(fmsg);
        }
        try
        {
            Document document = getParser().parse(source);
            XObject resultObject = eval(expression, document);
            return getResultAsType(resultObject, returnType);
        }
        catch(SAXException e)
        {
            throw new XPathExpressionException(e);
        }
        catch(IOException e)
        {
            throw new XPathExpressionException(e);
        }
        catch(TransformerException te)
        {
            Throwable nestedException = te.getException();
            if(nestedException instanceof XPathFunctionException)
                throw (XPathFunctionException)nestedException;
            else
                throw new XPathExpressionException(te);
        }
    }

    public String evaluate(String expression, InputSource source)
        throws XPathExpressionException
    {
        return (String)evaluate(expression, source, XPathConstants.STRING);
    }

    public void reset()
    {
        variableResolver = origVariableResolver;
        functionResolver = origFunctionResolver;
        namespaceContext = null;
    }

    private XPathVariableResolver variableResolver;
    private XPathFunctionResolver functionResolver;
    private XPathVariableResolver origVariableResolver;
    private XPathFunctionResolver origFunctionResolver;
    private NamespaceContext namespaceContext;
    private JAXPPrefixResolver prefixResolver;
    private boolean featureSecureProcessing;
    private static Document d = null;

}
