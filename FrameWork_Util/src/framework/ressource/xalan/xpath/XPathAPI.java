// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPathAPI.java

package framework.ressource.xalan.xpath;

import javax.xml.transform.TransformerException;
import org.apache.xml.utils.PrefixResolver;
import org.apache.xml.utils.PrefixResolverDefault;
import framework.ressource.xalan.xpath.objects.XObject;
import org.w3c.dom.*;
import org.w3c.dom.traversal.NodeIterator;

// Referenced classes of package framework.ressource.xalan.xpath:
//            XPathContext, XPath

public class XPathAPI
{

    public XPathAPI()
    {
    }

    public static Node selectSingleNode(Node contextNode, String str)
        throws TransformerException
    {
        return selectSingleNode(contextNode, str, contextNode);
    }

    public static Node selectSingleNode(Node contextNode, String str, Node namespaceNode)
        throws TransformerException
    {
        NodeIterator nl = selectNodeIterator(contextNode, str, namespaceNode);
        return nl.nextNode();
    }

    public static NodeIterator selectNodeIterator(Node contextNode, String str)
        throws TransformerException
    {
        return selectNodeIterator(contextNode, str, contextNode);
    }

    public static NodeIterator selectNodeIterator(Node contextNode, String str, Node namespaceNode)
        throws TransformerException
    {
        XObject list = eval(contextNode, str, namespaceNode);
        return list.nodeset();
    }

    public static NodeList selectNodeList(Node contextNode, String str)
        throws TransformerException
    {
        return selectNodeList(contextNode, str, contextNode);
    }

    public static NodeList selectNodeList(Node contextNode, String str, Node namespaceNode)
        throws TransformerException
    {
        XObject list = eval(contextNode, str, namespaceNode);
        return list.nodelist();
    }

    public static XObject eval(Node contextNode, String str)
        throws TransformerException
    {
        return eval(contextNode, str, contextNode);
    }

    public static XObject eval(Node contextNode, String str, Node namespaceNode)
        throws TransformerException
    {
        XPathContext xpathSupport = new XPathContext(false);
        PrefixResolverDefault prefixResolver = new PrefixResolverDefault(((Node) (namespaceNode.getNodeType() != 9 ? namespaceNode : ((Node) (((Document)namespaceNode).getDocumentElement())))));
        XPath xpath = new XPath(str, null, prefixResolver, 0, null);
        int ctxtNode = xpathSupport.getDTMHandleFromNode(contextNode);
        return xpath.execute(xpathSupport, ctxtNode, prefixResolver);
    }

    public static XObject eval(Node contextNode, String str, PrefixResolver prefixResolver)
        throws TransformerException
    {
        XPath xpath = new XPath(str, null, prefixResolver, 0, null);
        XPathContext xpathSupport = new XPathContext(false);
        int ctxtNode = xpathSupport.getDTMHandleFromNode(contextNode);
        return xpath.execute(xpathSupport, ctxtNode, prefixResolver);
    }
}
