// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPathFactoryImpl.java

package framework.ressource.xalan.xpath.jaxp;

import javax.xml.xpath.*;
import framework.ressource.xalan.xpath.res.XPATHMessages;

// Referenced classes of package framework.ressource.xalan.xpath.jaxp:
//            XPathImpl

public class XPathFactoryImpl extends XPathFactory
{

    public XPathFactoryImpl()
    {
        xPathFunctionResolver = null;
        xPathVariableResolver = null;
        featureSecureProcessing = false;
    }

    public boolean isObjectModelSupported(String objectModel)
    {
        if(objectModel == null)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_OBJECT_MODEL_NULL", new Object[] {
                getClass().getName()
            });
            throw new NullPointerException(fmsg);
        }
        if(objectModel.length() == 0)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_OBJECT_MODEL_EMPTY", new Object[] {
                getClass().getName()
            });
            throw new IllegalArgumentException(fmsg);
        }
        return objectModel.equals("http://java.sun.com/jaxp/xpath/dom");
    }

    public XPath newXPath()
    {
        return new XPathImpl(xPathVariableResolver, xPathFunctionResolver, featureSecureProcessing);
    }

    public void setFeature(String name, boolean value)
        throws XPathFactoryConfigurationException
    {
        if(name == null)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_FEATURE_NAME_NULL", new Object[] {
                "XPathFactoryImpl", new Boolean(value)
            });
            throw new NullPointerException(fmsg);
        }
        if(name.equals("http://javax.xml.XMLConstants/feature/secure-processing"))
        {
            featureSecureProcessing = value;
            return;
        } else
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_FEATURE_UNKNOWN", new Object[] {
                name, "XPathFactoryImpl", new Boolean(value)
            });
            throw new XPathFactoryConfigurationException(fmsg);
        }
    }

    public boolean getFeature(String name)
        throws XPathFactoryConfigurationException
    {
        if(name == null)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_GETTING_NULL_FEATURE", new Object[] {
                "XPathFactoryImpl"
            });
            throw new NullPointerException(fmsg);
        }
        if(name.equals("http://javax.xml.XMLConstants/feature/secure-processing"))
        {
            return featureSecureProcessing;
        } else
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_GETTING_UNKNOWN_FEATURE", new Object[] {
                name, "XPathFactoryImpl"
            });
            throw new XPathFactoryConfigurationException(fmsg);
        }
    }

    public void setXPathFunctionResolver(XPathFunctionResolver resolver)
    {
        if(resolver == null)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_NULL_XPATH_FUNCTION_RESOLVER", new Object[] {
                "XPathFactoryImpl"
            });
            throw new NullPointerException(fmsg);
        } else
        {
            xPathFunctionResolver = resolver;
            return;
        }
    }

    public void setXPathVariableResolver(XPathVariableResolver resolver)
    {
        if(resolver == null)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_NULL_XPATH_VARIABLE_RESOLVER", new Object[] {
                "XPathFactoryImpl"
            });
            throw new NullPointerException(fmsg);
        } else
        {
            xPathVariableResolver = resolver;
            return;
        }
    }

    private static final String CLASS_NAME = "XPathFactoryImpl";
    private XPathFunctionResolver xPathFunctionResolver;
    private XPathVariableResolver xPathVariableResolver;
    private boolean featureSecureProcessing;
}
