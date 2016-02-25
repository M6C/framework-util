// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPathEvaluatorImpl.java

package framework.ressource.xalan.xpath.domapi;

import javax.xml.transform.TransformerException;

import org.apache.xml.utils.PrefixResolver;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
//import org.w3c.dom.xpath.XPathEvaluator;
//import org.w3c.dom.xpath.XPathException;
//import org.w3c.dom.xpath.XPathExpression;
//import org.w3c.dom.xpath.XPathNSResolver;

import framework.ressource.xalan.xpath.XPath;
import framework.ressource.xalan.xpath.res.XPATHMessages;
import framework.ressource.xpath.XPathException;
import framework.ressource.xpath.XPathEvaluator;
import framework.ressource.xpath.XPathExpression;
import framework.ressource.xpath.XPathNSResolver;

// Referenced classes of package framework.ressource.xalan.xpath.domapi:
//            XPathExpressionImpl, XPathStylesheetDOM3Exception, XPathNSResolverImpl

public final class XPathEvaluatorImpl
    implements XPathEvaluator
{
    private class DummyPrefixResolver
        implements PrefixResolver
    {

        public String getNamespaceForPrefix(String prefix, Node context)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_NULL_RESOLVER", null);
            throw new DOMException((short)14, fmsg);
        }

        public String getNamespaceForPrefix(String prefix)
        {
            return getNamespaceForPrefix(prefix, null);
        }

        public boolean handlesNullPrefixes()
        {
            return false;
        }

        public String getBaseIdentifier()
        {
            return null;
        }

        DummyPrefixResolver()
        {
        }
    }


    public XPathEvaluatorImpl(Document doc)
    {
        m_doc = doc;
    }

    public XPathEvaluatorImpl()
    {
        m_doc = null;
    }

    public XPathExpression createExpression(String expression, XPathNSResolver resolver)
        throws XPathException, DOMException
    {
        try
        {
            XPath xpath = new XPath(expression, null, ((PrefixResolver) (null != resolver ? (PrefixResolver)resolver : ((PrefixResolver) (new DummyPrefixResolver())))), 0);
            return new XPathExpressionImpl(xpath, m_doc);
        }
        catch(TransformerException e)
        {
            if(e instanceof XPathStylesheetDOM3Exception)
                throw new DOMException((short)14, e.getMessageAndLocation());
            else
                throw new XPathException((short)51, e.getMessageAndLocation());
        }
    }

    public XPathNSResolver createNSResolver(Node nodeResolver)
    {
        return new XPathNSResolverImpl(((Node) (nodeResolver.getNodeType() != 9 ? nodeResolver : ((Node) (((Document)nodeResolver).getDocumentElement())))));
    }

    public Object evaluate(String expression, Node contextNode, XPathNSResolver resolver, short type, Object result)
        throws XPathException, DOMException
    {
        XPathExpression xpathExpression = createExpression(expression, resolver);
        return xpathExpression.evaluate(contextNode, type, result);
    }

    private final Document m_doc;
}
