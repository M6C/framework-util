// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPathResultImpl.java

package framework.ressource.xalan.xpath.domapi;

import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.XPath;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.res.XPATHMessages;
import framework.ressource.xpath.XPathException;
import framework.ressource.xpath.XPathResult;

import org.w3c.dom.*;
import org.w3c.dom.events.*;
import org.w3c.dom.traversal.NodeIterator;
//import org.w3c.dom.xpath.XPathException;
//import org.w3c.dom.xpath.XPathResult;

// Referenced classes of package framework.ressource.xalan.xpath.domapi:
//            XPathNamespaceImpl

class XPathResultImpl
    implements XPathResult, EventListener
{

    XPathResultImpl(short type, XObject result, Node contextNode, XPath xpath)
    {
        m_isInvalidIteratorState = false;
        m_iterator = null;
        m_list = null;
        if(!isValidType(type))
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_INVALID_XPATH_TYPE", new Object[] {
                new Integer(type)
            });
            throw new XPathException((short)52, fmsg);
        }
        if(null == result)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_EMPTY_XPATH_RESULT", null);
            throw new XPathException((short)51, fmsg);
        }
        m_resultObj = result;
        m_contextNode = contextNode;
        m_xpath = xpath;
        if(type == 0)
            m_resultType = getTypeFromXObject(result);
        else
            m_resultType = type;
        if(m_resultType == 5 || m_resultType == 4)
            addEventListener();
        if(m_resultType == 5 || m_resultType == 4 || m_resultType == 8 || m_resultType == 9)
            try
            {
                m_iterator = m_resultObj.nodeset();
            }
            catch(TransformerException te)
            {
                String fmsg = XPATHMessages.createXPATHMessage("ER_INCOMPATIBLE_TYPES", new Object[] {
                    m_xpath.getPatternString(), getTypeString(getTypeFromXObject(m_resultObj)), getTypeString(m_resultType)
                });
                throw new XPathException((short)52, fmsg);
            }
        else
        if(m_resultType == 6 || m_resultType == 7)
            try
            {
                m_list = m_resultObj.nodelist();
            }
            catch(TransformerException te)
            {
                String fmsg = XPATHMessages.createXPATHMessage("ER_INCOMPATIBLE_TYPES", new Object[] {
                    m_xpath.getPatternString(), getTypeString(getTypeFromXObject(m_resultObj)), getTypeString(m_resultType)
                });
                throw new XPathException((short)52, fmsg);
            }
    }

    public short getResultType()
    {
        return m_resultType;
    }

    public double getNumberValue()
        throws XPathException
    {
        if(getResultType() != 1)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_CANT_CONVERT_XPATHRESULTTYPE_TO_NUMBER", new Object[] {
                m_xpath.getPatternString(), getTypeString(m_resultType)
            });
            throw new XPathException((short)52, fmsg);
        }
        try
        {
            return m_resultObj.num();
        }
        catch(Exception e)
        {
            throw new XPathException((short)52, e.getMessage());
        }
    }

    public String getStringValue()
        throws XPathException
    {
        if(getResultType() != 2)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_CANT_CONVERT_TO_STRING", new Object[] {
                m_xpath.getPatternString(), m_resultObj.getTypeString()
            });
            throw new XPathException((short)52, fmsg);
        }
        try
        {
            return m_resultObj.str();
        }
        catch(Exception e)
        {
            throw new XPathException((short)52, e.getMessage());
        }
    }

    public boolean getBooleanValue()
        throws XPathException
    {
        if(getResultType() != 3)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_CANT_CONVERT_TO_BOOLEAN", new Object[] {
                m_xpath.getPatternString(), getTypeString(m_resultType)
            });
            throw new XPathException((short)52, fmsg);
        }
        try
        {
            return m_resultObj.bool();
        }
        catch(TransformerException e)
        {
            throw new XPathException((short)52, e.getMessage());
        }
    }

    public Node getSingleNodeValue()
        throws XPathException
    {
        if(m_resultType != 8 && m_resultType != 9)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_CANT_CONVERT_TO_SINGLENODE", new Object[] {
                m_xpath.getPatternString(), getTypeString(m_resultType)
            });
            throw new XPathException((short)52, fmsg);
        }
        NodeIterator result = null;
        try
        {
            result = m_resultObj.nodeset();
        }
        catch(TransformerException te)
        {
            throw new XPathException((short)52, te.getMessage());
        }
        if(null == result)
            return null;
        Node node = result.nextNode();
        if(isNamespaceNode(node))
            return new XPathNamespaceImpl(node);
        else
            return node;
    }

    public boolean getInvalidIteratorState()
    {
        return m_isInvalidIteratorState;
    }

    public int getSnapshotLength()
        throws XPathException
    {
        if(m_resultType != 6 && m_resultType != 7)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_CANT_GET_SNAPSHOT_LENGTH", new Object[] {
                m_xpath.getPatternString(), getTypeString(m_resultType)
            });
            throw new XPathException((short)52, fmsg);
        } else
        {
            return m_list.getLength();
        }
    }

    public Node iterateNext()
        throws XPathException, DOMException
    {
        if(m_resultType != 4 && m_resultType != 5)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_NON_ITERATOR_TYPE", new Object[] {
                m_xpath.getPatternString(), getTypeString(m_resultType)
            });
            throw new XPathException((short)52, fmsg);
        }
        if(getInvalidIteratorState())
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_DOC_MUTATED", null);
            throw new DOMException((short)11, fmsg);
        }
        Node node = m_iterator.nextNode();
        if(null == node)
            removeEventListener();
        if(isNamespaceNode(node))
            return new XPathNamespaceImpl(node);
        else
            return node;
    }

    public Node snapshotItem(int index)
        throws XPathException
    {
        if(m_resultType != 6 && m_resultType != 7)
        {
            String fmsg = XPATHMessages.createXPATHMessage("ER_NON_SNAPSHOT_TYPE", new Object[] {
                m_xpath.getPatternString(), getTypeString(m_resultType)
            });
            throw new XPathException((short)52, fmsg);
        }
        Node node = m_list.item(index);
        if(isNamespaceNode(node))
            return new XPathNamespaceImpl(node);
        else
            return node;
    }

    static boolean isValidType(short type)
    {
        switch(type)
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
            return true;
        }
        return false;
    }

    public void handleEvent(Event event)
    {
        if(event.getType().equals("DOMSubtreeModified"))
        {
            m_isInvalidIteratorState = true;
            removeEventListener();
        }
    }

    private String getTypeString(int type)
    {
        switch(type)
        {
        case 0: // '\0'
            return "ANY_TYPE";

        case 8: // '\b'
            return "ANY_UNORDERED_NODE_TYPE";

        case 3: // '\003'
            return "BOOLEAN";

        case 9: // '\t'
            return "FIRST_ORDERED_NODE_TYPE";

        case 1: // '\001'
            return "NUMBER_TYPE";

        case 5: // '\005'
            return "ORDERED_NODE_ITERATOR_TYPE";

        case 7: // '\007'
            return "ORDERED_NODE_SNAPSHOT_TYPE";

        case 2: // '\002'
            return "STRING_TYPE";

        case 4: // '\004'
            return "UNORDERED_NODE_ITERATOR_TYPE";

        case 6: // '\006'
            return "UNORDERED_NODE_SNAPSHOT_TYPE";
        }
        return "#UNKNOWN";
    }

    private short getTypeFromXObject(XObject object)
    {
        switch(object.getType())
        {
        case 1: // '\001'
            return 3;

        case 4: // '\004'
            return 4;

        case 2: // '\002'
            return 1;

        case 3: // '\003'
            return 2;

        case 5: // '\005'
            return 4;

        case -1: 
            return 0;

        case 0: // '\0'
        default:
            return 0;
        }
    }

    private boolean isNamespaceNode(Node node)
    {
        return null != node && node.getNodeType() == 2 && (node.getNodeName().startsWith("xmlns:") || node.getNodeName().equals("xmlns"));
    }

    private void addEventListener()
    {
        if(m_contextNode instanceof EventTarget)
            ((EventTarget)m_contextNode).addEventListener("DOMSubtreeModified", this, true);
    }

    private void removeEventListener()
    {
        if(m_contextNode instanceof EventTarget)
            ((EventTarget)m_contextNode).removeEventListener("DOMSubtreeModified", this, true);
    }

    private final XObject m_resultObj;
    private final XPath m_xpath;
    private final short m_resultType;
    private boolean m_isInvalidIteratorState;
    private final Node m_contextNode;
    private NodeIterator m_iterator;
    private NodeList m_list;
}
