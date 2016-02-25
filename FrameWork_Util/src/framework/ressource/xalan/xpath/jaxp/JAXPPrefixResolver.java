// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JAXPPrefixResolver.java

package framework.ressource.xalan.xpath.jaxp;

import javax.xml.namespace.NamespaceContext;
import org.apache.xml.utils.PrefixResolver;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class JAXPPrefixResolver
    implements PrefixResolver
{

    public JAXPPrefixResolver(NamespaceContext nsContext)
    {
        namespaceContext = nsContext;
    }

    public String getNamespaceForPrefix(String prefix)
    {
        return namespaceContext.getNamespaceURI(prefix);
    }

    public String getBaseIdentifier()
    {
        return null;
    }

    public boolean handlesNullPrefixes()
    {
        return false;
    }

    public String getNamespaceForPrefix(String prefix, Node namespaceContext)
    {
        Node parent = namespaceContext;
        String namespace = null;
        if(prefix.equals("xml"))
        {
            namespace = "http://www.w3.org/XML/1998/namespace";
        } else
        {
            int type;
            for(; null != parent && null == namespace && ((type = parent.getNodeType()) == 1 || type == 5); parent = parent.getParentNode())
                if(type == 1)
                {
                    NamedNodeMap nnm = parent.getAttributes();
                    for(int i = 0; i < nnm.getLength(); i++)
                    {
                        Node attr = nnm.item(i);
                        String aname = attr.getNodeName();
                        boolean isPrefix = aname.startsWith("xmlns:");
                        if(!isPrefix && !aname.equals("xmlns"))
                            continue;
                        int index = aname.indexOf(':');
                        String p = isPrefix ? aname.substring(index + 1) : "";
                        if(!p.equals(prefix))
                            continue;
                        namespace = attr.getNodeValue();
                        break;
                    }

                }

        }
        return namespace;
    }

    private NamespaceContext namespaceContext;
    public static final String S_XMLNAMESPACEURI = "http://www.w3.org/XML/1998/namespace";
}
