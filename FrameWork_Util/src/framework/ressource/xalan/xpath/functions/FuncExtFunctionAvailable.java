// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncExtFunctionAvailable.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import org.apache.xml.utils.PrefixResolver;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.compiler.FunctionTable;
import framework.ressource.xalan.xpath.objects.XBoolean;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionOneArg

public class FuncExtFunctionAvailable extends FunctionOneArg
{

    public FuncExtFunctionAvailable()
    {
        m_functionTable = null;
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
        if(namespace.equals("http://www.w3.org/1999/XSL/Transform"))
        {
            try
            {
                if(null == m_functionTable)
                    m_functionTable = new FunctionTable();
                return m_functionTable.functionAvailable(methName) ? XBoolean.S_TRUE : XBoolean.S_FALSE;
            }
            catch(Exception e)
            {
                return XBoolean.S_FALSE;
            }
        } else
        {
            ExtensionsProvider extProvider = (ExtensionsProvider)xctxt.getOwnerObject();
            return extProvider.functionAvailable(namespace, methName) ? XBoolean.S_TRUE : XBoolean.S_FALSE;
        }
    }

    public void setFunctionTable(FunctionTable aTable)
    {
        m_functionTable = aTable;
    }

    static final long serialVersionUID = 0x4709ae7fafe83ef1L;
    private transient FunctionTable m_functionTable;
}
