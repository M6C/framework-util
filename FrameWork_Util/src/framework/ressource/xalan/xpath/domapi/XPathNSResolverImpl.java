// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPathNSResolverImpl.java

package framework.ressource.xalan.xpath.domapi;

import org.apache.xml.utils.PrefixResolverDefault;
import org.w3c.dom.Node;

import framework.ressource.xpath.XPathNSResolver;
//import org.w3c.dom.xpath.XPathNSResolver;

class XPathNSResolverImpl extends PrefixResolverDefault
    implements XPathNSResolver
{

    public XPathNSResolverImpl(Node xpathExpressionContext)
    {
        super(xpathExpressionContext);
    }

    public String lookupNamespaceURI(String prefix)
    {
        return super.getNamespaceForPrefix(prefix);
    }
}
