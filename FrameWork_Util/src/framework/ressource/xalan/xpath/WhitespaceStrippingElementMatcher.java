// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WhitespaceStrippingElementMatcher.java

package framework.ressource.xalan.xpath;

import javax.xml.transform.TransformerException;
import org.w3c.dom.Element;

// Referenced classes of package framework.ressource.xalan.xpath:
//            XPathContext

public interface WhitespaceStrippingElementMatcher
{

    public abstract boolean shouldStripWhiteSpace(XPathContext xpathcontext, Element element)
        throws TransformerException;

    public abstract boolean canStripWhiteSpace();
}
