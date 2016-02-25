// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPathExpressionImpl.java

package framework.ressource.xalan.xpath.domapi;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.XPath;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.res.XPATHMessages;
import framework.ressource.xpath.XPathException;
import framework.ressource.xpath.XPathExpression;

import org.w3c.dom.*;
//import org.w3c.dom.xpath.XPathException;
//import org.w3c.dom.xpath.XPathExpression;

// Referenced classes of package framework.ressource.xalan.xpath.domapi:
//            XPathResultImpl

class XPathExpressionImpl
    implements XPathExpression
{

    XPathExpressionImpl(XPath xpath, Document doc)
    {
        m_xpath = xpath;
        m_doc = doc;
    }

    public Object evaluate(Node contextNode, short type, Object result)
        throws XPathException, DOMException
    {
        if(m_doc != null)
        {
            if(contextNode != m_doc && !contextNode.getOwnerDocument().equals(m_doc))
            {
                String fmsg = XPATHMessages.createXPATHMessage("ER_WRONG_DOCUMENT", null);
                throw new DOMException((short)4, fmsg);
            }
            short nodeType = contextNode.getNodeType();
            if(nodeType != 9 && nodeType != 1 && nodeType != 2 && nodeType != 3 && nodeType != 4 && nodeType != 8 && nodeType != 7 && nodeType != 13)
            {
                String fmsg = XPATHMessages.createXPATHMessage("ER_WRONG_NODETYPE", null);
                throw new DOMException((short)9, fmsg);
            }
        }
        if(!XPathResultImpl.isValidType(type))
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_INVALID_XPATH_TYPE", new Object[] {
                new Integer(type)
            });
            throw new XPathException((short)52, fmsg);
        }
        XPathContext xpathSupport = new XPathContext(false);
        if(null != m_doc)
            xpathSupport.getDTMHandleFromNode(m_doc);
        XObject xobj = null;
        try
        {
            xobj = m_xpath.execute(xpathSupport, contextNode, null);
        }
        catch(TransformerException te)
        {
            throw new XPathException((short)51, te.getMessageAndLocation());
        }
        return new XPathResultImpl(type, xobj, contextNode, m_xpath);
    }

    private final XPath m_xpath;
    private final Document m_doc;
}
