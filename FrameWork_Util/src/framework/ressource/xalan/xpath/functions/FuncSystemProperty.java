// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncSystemProperty.java

package framework.ressource.xalan.xpath.functions;

import java.io.BufferedInputStream;
import java.util.Properties;
import javax.xml.transform.TransformerException;
import org.apache.xml.utils.PrefixResolver;
import org.apache.xml.utils.WrappedRuntimeException;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.objects.XString;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionOneArg, SecuritySupport, ObjectFactory

public class FuncSystemProperty extends FunctionOneArg
{

    public FuncSystemProperty()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        String fullName = super.m_arg0.execute(xctxt).str();
        int indexOfNSSep = fullName.indexOf(':');
        String propName = "";
        Properties xsltInfo = new Properties();
        loadPropertyFile("org/apache/xalan/res/XSLTInfo.properties", xsltInfo);
        String result;
        if(indexOfNSSep > 0)
        {
            String prefix = indexOfNSSep < 0 ? "" : fullName.substring(0, indexOfNSSep);
            String namespace = xctxt.getNamespaceContext().getNamespaceForPrefix(prefix);
            propName = indexOfNSSep >= 0 ? fullName.substring(indexOfNSSep + 1) : fullName;
            if(namespace.startsWith("http://www.w3.org/XSL/Transform") || namespace.equals("http://www.w3.org/1999/XSL/Transform"))
            {
                result = xsltInfo.getProperty(propName);
                if(null == result)
                {
                    warn(xctxt, "WG_PROPERTY_NOT_SUPPORTED", new Object[] {
                        fullName
                    });
                    return XString.EMPTYSTRING;
                }
            } else
            {
                warn(xctxt, "WG_DONT_DO_ANYTHING_WITH_NS", new Object[] {
                    namespace, fullName
                });
                try
                {
                    result = System.getProperty(propName);
                    if(null == result)
                        return XString.EMPTYSTRING;
                }
                catch(SecurityException se)
                {
                    warn(xctxt, "WG_SECURITY_EXCEPTION", new Object[] {
                        fullName
                    });
                    return XString.EMPTYSTRING;
                }
            }
        } else
        {
            try
            {
                result = System.getProperty(fullName);
                if(null == result)
                    return XString.EMPTYSTRING;
            }
            catch(SecurityException se)
            {
                warn(xctxt, "WG_SECURITY_EXCEPTION", new Object[] {
                    fullName
                });
                return XString.EMPTYSTRING;
            }
        }
        if(propName.equals("version") && result.length() > 0)
            try
            {
                return new XString("1.0");
            }
            catch(Exception ex)
            {
                return new XString(result);
            }
        else
            return new XString(result);
    }

    public void loadPropertyFile(String file, Properties target)
    {
        try
        {
            SecuritySupport ss = SecuritySupport.getInstance();
            java.io.InputStream is = ss.getResourceAsStream(ObjectFactory.findClassLoader(), file);
            BufferedInputStream bis = new BufferedInputStream(is);
            target.load(bis);
            bis.close();
        }
        catch(Exception ex)
        {
            throw new WrappedRuntimeException(ex);
        }
    }

    static final long serialVersionUID = 0x3346d5380b84c043L;
    static final String XSLT_PROPERTIES = "org/apache/xalan/res/XSLTInfo.properties";
}
