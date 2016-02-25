// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExpressionContext.java

package framework.ressource.xalan.extensions;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;
import org.apache.xml.utils.QName;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;

import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;

public interface ExpressionContext
{

    public abstract Node getContextNode();

    public abstract NodeIterator getContextNodes();

    public abstract ErrorListener getErrorListener();

    public abstract double toNumber(Node node);

    public abstract String toString(Node node);

    public abstract XObject getVariableOrParam(QName qname)
        throws TransformerException;

    public abstract XPathContext getXPathContext()
        throws TransformerException;
}
