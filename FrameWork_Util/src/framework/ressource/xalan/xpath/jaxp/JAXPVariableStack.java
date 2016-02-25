// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JAXPVariableStack.java

package framework.ressource.xalan.xpath.jaxp;

import javax.xml.namespace.QName;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathVariableResolver;
import framework.ressource.xalan.xpath.VariableStack;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.res.XPATHMessages;

public class JAXPVariableStack extends VariableStack
{

    public JAXPVariableStack(XPathVariableResolver resolver)
    {
        super(2);
        this.resolver = resolver;
    }

    public XObject getVariableOrParam(XPathContext xctxt, org.apache.xml.utils.QName qname)
        throws TransformerException, IllegalArgumentException
    {
        if(qname == null)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_ARG_CANNOT_BE_NULL", new Object[] {
                "Variable qname"
            });
            throw new IllegalArgumentException(fmsg);
        }
        QName name = new QName(qname.getNamespace(), qname.getLocalPart());
        Object varValue = resolver.resolveVariable(name);
        if(varValue == null)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_RESOLVE_VARIABLE_RETURNS_NULL", new Object[] {
                name.toString()
            });
            throw new TransformerException(fmsg);
        } else
        {
            return XObject.create(varValue, xctxt);
        }
    }

    private final XPathVariableResolver resolver;
}
