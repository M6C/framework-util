// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XObject.java

package framework.ressource.xalan.xpath.objects;

import java.io.Serializable;
import java.util.Vector;
import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import org.apache.xml.dtm.DTMIterator;
import org.apache.xml.utils.*;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.res.XPATHMessages;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

// Referenced classes of package framework.ressource.xalan.xpath.objects:
//            XObjectFactory, XMLStringFactoryImpl

public class XObject extends Expression
    implements Serializable, Cloneable
{

    public XObject()
    {
    }

    public XObject(Object obj)
    {
        setObject(obj);
    }

    protected void setObject(Object obj)
    {
        m_obj = obj;
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        return this;
    }

    public void allowDetachToRelease(boolean flag)
    {
    }

    public void detach()
    {
    }

    public void destruct()
    {
        if(null != m_obj)
        {
            allowDetachToRelease(true);
            detach();
            setObject(null);
        }
    }

    public void reset()
    {
    }

    public void dispatchCharactersEvents(ContentHandler ch)
        throws SAXException
    {
        xstr().dispatchCharactersEvents(ch);
    }

    public static XObject create(Object val)
    {
        return XObjectFactory.create(val);
    }

    public static XObject create(Object val, XPathContext xctxt)
    {
        return XObjectFactory.create(val, xctxt);
    }

    public int getType()
    {
        return 0;
    }

    public String getTypeString()
    {
        return "#UNKNOWN (" + object().getClass().getName() + ")";
    }

    public double num()
        throws TransformerException
    {
        error("ER_CANT_CONVERT_TO_NUMBER", new Object[] {
            getTypeString()
        });
        return 0.0D;
    }

    public double numWithSideEffects()
        throws TransformerException
    {
        return num();
    }

    public boolean bool()
        throws TransformerException
    {
        error("ER_CANT_CONVERT_TO_NUMBER", new Object[] {
            getTypeString()
        });
        return false;
    }

    public boolean boolWithSideEffects()
        throws TransformerException
    {
        return bool();
    }

    public XMLString xstr()
    {
        return XMLStringFactoryImpl.getFactory().newstr(str());
    }

    public String str()
    {
        return m_obj == null ? "" : m_obj.toString();
    }

    public String toString()
    {
        return str();
    }

    public int rtf(XPathContext support)
    {
        int result = rtf();
        if(-1 == result)
        {
            DTM frag = support.createDocumentFragment();
            frag.appendTextChild(str());
            result = frag.getDocument();
        }
        return result;
    }

    public DocumentFragment rtree(XPathContext support)
    {
        DocumentFragment docFrag = null;
        int result = rtf();
        if(-1 == result)
        {
            DTM frag = support.createDocumentFragment();
            frag.appendTextChild(str());
            docFrag = (DocumentFragment)frag.getNode(frag.getDocument());
        } else
        {
            DTM frag = support.getDTM(result);
            docFrag = (DocumentFragment)frag.getNode(frag.getDocument());
        }
        return docFrag;
    }

    public DocumentFragment rtree()
    {
        return null;
    }

    public int rtf()
    {
        return -1;
    }

    public Object object()
    {
        return m_obj;
    }

    public DTMIterator iter()
        throws TransformerException
    {
        error("ER_CANT_CONVERT_TO_NODELIST", new Object[] {
            getTypeString()
        });
        return null;
    }

    public XObject getFresh()
    {
        return this;
    }

    public NodeIterator nodeset()
        throws TransformerException
    {
        error("ER_CANT_CONVERT_TO_NODELIST", new Object[] {
            getTypeString()
        });
        return null;
    }

    public NodeList nodelist()
        throws TransformerException
    {
        error("ER_CANT_CONVERT_TO_NODELIST", new Object[] {
            getTypeString()
        });
        return null;
    }

    public NodeSetDTM mutableNodeset()
        throws TransformerException
    {
        error("ER_CANT_CONVERT_TO_MUTABLENODELIST", new Object[] {
            getTypeString()
        });
        return (NodeSetDTM)m_obj;
    }

    public Object castToType(int t, XPathContext support)
        throws TransformerException
    {
        Object result;
        switch(t)
        {
        case 3: // '\003'
            result = str();
            break;

        case 2: // '\002'
            result = new Double(num());
            break;

        case 4: // '\004'
            result = iter();
            break;

        case 1: // '\001'
            result = new Boolean(bool());
            break;

        case 0: // '\0'
            result = m_obj;
            break;

        default:
            error("ER_CANT_CONVERT_TO_TYPE", new Object[] {
                getTypeString(), Integer.toString(t)
            });
            result = null;
            break;
        }
        return result;
    }

    public boolean lessThan(XObject obj2)
        throws TransformerException
    {
        if(obj2.getType() == 4)
            return obj2.greaterThan(this);
        else
            return num() < obj2.num();
    }

    public boolean lessThanOrEqual(XObject obj2)
        throws TransformerException
    {
        if(obj2.getType() == 4)
            return obj2.greaterThanOrEqual(this);
        else
            return num() <= obj2.num();
    }

    public boolean greaterThan(XObject obj2)
        throws TransformerException
    {
        if(obj2.getType() == 4)
            return obj2.lessThan(this);
        else
            return num() > obj2.num();
    }

    public boolean greaterThanOrEqual(XObject obj2)
        throws TransformerException
    {
        if(obj2.getType() == 4)
            return obj2.lessThanOrEqual(this);
        else
            return num() >= obj2.num();
    }

    public boolean equals(XObject obj2)
    {
        if(obj2.getType() == 4)
            return obj2.equals(this);
        if(null != m_obj)
            return m_obj.equals(obj2.m_obj);
        else
            return obj2.m_obj == null;
    }

    public boolean notEquals(XObject obj2)
        throws TransformerException
    {
        if(obj2.getType() == 4)
            return obj2.notEquals(this);
        else
            return !equals(obj2);
    }

    protected void error(String msg)
        throws TransformerException
    {
        error(msg, null);
    }

    protected void error(String msg, Object args[])
        throws TransformerException
    {
        String fmsg = XPATHMessages.createXPATHMessage(msg, args);
        throw new XPathException(fmsg, this);
    }

    public void fixupVariables(Vector vector, int i)
    {
    }

    public void appendToFsb(FastStringBuffer fsb)
    {
        fsb.append(str());
    }

    public void callVisitors(ExpressionOwner owner, XPathVisitor visitor)
    {
        assertion(false, "callVisitors should not be called for this object!!!");
    }

    public boolean deepEquals(Expression expr)
    {
        if(!isSameClass(expr))
            return false;
        return equals((XObject)expr);
    }

    static final long serialVersionUID = 0xf4981209bb7bb619L;
    protected Object m_obj;
    public static final int CLASS_NULL = -1;
    public static final int CLASS_UNKNOWN = 0;
    public static final int CLASS_BOOLEAN = 1;
    public static final int CLASS_NUMBER = 2;
    public static final int CLASS_STRING = 3;
    public static final int CLASS_NODESET = 4;
    public static final int CLASS_RTREEFRAG = 5;
    public static final int CLASS_UNRESOLVEDVARIABLE = 600;
}
