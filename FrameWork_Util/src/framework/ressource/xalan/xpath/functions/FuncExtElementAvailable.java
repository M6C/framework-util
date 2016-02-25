// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncExtElementAvailable.java

package framework.ressource.xalan.xpath.functions;

import java.util.HashMap;
import javax.xml.transform.TransformerException;
import org.apache.xalan.templates.StylesheetRoot;
import org.apache.xalan.transformer.TransformerImpl;
import org.apache.xml.utils.PrefixResolver;
import org.apache.xml.utils.QName;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.objects.XBoolean;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionOneArg

public class FuncExtElementAvailable extends FunctionOneArg
{

    public FuncExtElementAvailable()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        String fullName = super.m_arg0.execute(xctxt).str();
        int indexOfNSSep = fullName.indexOf(':');
        String namespace;
        String methName;
        if(indexOfNSSep < 0)
        {
            String prefix = "";
            namespace = "http://www.w3.org/1999/XSL/Transform";
            methName = fullName;
        } else
        {
            String prefix = fullName.substring(0, indexOfNSSep);
            namespace = xctxt.getNamespaceContext().getNamespaceForPrefix(prefix);
            if(null == namespace)
                return XBoolean.S_FALSE;
            methName = fullName.substring(indexOfNSSep + 1);
        }
        if(namespace.equals("http://www.w3.org/1999/XSL/Transform") || namespace.equals("http://xml.apache.org/xalan"))
        {
            try
            {
                TransformerImpl transformer = (TransformerImpl)xctxt.getOwnerObject();
                return transformer.getStylesheet().getAvailableElements().containsKey(new QName(namespace, methName)) ? XBoolean.S_TRUE : XBoolean.S_FALSE;
            }
            catch(Exception e)
            {
                return XBoolean.S_FALSE;
            }
        } else
        {
            ExtensionsProvider extProvider = (ExtensionsProvider)xctxt.getOwnerObject();
            return extProvider.elementAvailable(namespace, methName) ? XBoolean.S_TRUE : XBoolean.S_FALSE;
        }
    }

    static final long serialVersionUID = 0xf971391aa753d85eL;
}
