// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPathFactory.java

package framework.ressource.xalan.xpath;

import javax.xml.transform.SourceLocator;
import org.apache.xml.utils.PrefixResolver;

// Referenced classes of package framework.ressource.xalan.xpath:
//            XPath

public interface XPathFactory
{

    public abstract XPath create(String s, SourceLocator sourcelocator, PrefixResolver prefixresolver, int i);
}
