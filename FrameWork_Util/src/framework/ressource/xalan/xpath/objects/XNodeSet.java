// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XNodeSet.java

package framework.ressource.xalan.xpath.objects;

import java.util.Vector;

import javax.xml.transform.TransformerException;

import org.apache.xml.dtm.DTMIterator;
import org.apache.xml.dtm.DTMManager;
import org.apache.xml.dtm.ref.DTMNodeIterator;
import org.apache.xml.dtm.ref.DTMNodeList;
import org.apache.xml.utils.FastStringBuffer;
import org.apache.xml.utils.WrappedRuntimeException;
import org.apache.xml.utils.XMLString;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import framework.ressource.xalan.xpath.NodeSetDTM;
import framework.ressource.xalan.xpath.axes.NodeSequence;

// Referenced classes of package framework.ressource.xalan.xpath.objects:
//            XString, XObject, LessThanComparator, LessThanOrEqualComparator, 
//            GreaterThanComparator, GreaterThanOrEqualComparator, EqualComparator, NotEqualComparator, 
//            Comparator

public class XNodeSet extends NodeSequence
{

    protected XNodeSet()
    {
    }

    public XNodeSet(DTMIterator val)
    {
        if(val instanceof XNodeSet)
        {
            XNodeSet nodeSet = (XNodeSet)val;
            setIter(((NodeSequence) (nodeSet)).m_iter);
            super.m_dtmMgr = ((NodeSequence) (nodeSet)).m_dtmMgr;
            super.m_last = ((NodeSequence) (nodeSet)).m_last;
            if(!nodeSet.hasCache())
                nodeSet.setShouldCacheNodes(true);
            setObject(nodeSet.getIteratorCache());
        } else
        {
            setIter(val);
        }
    }

    public XNodeSet(XNodeSet val)
    {
        setIter(((NodeSequence) (val)).m_iter);
        super.m_dtmMgr = ((NodeSequence) (val)).m_dtmMgr;
        super.m_last = ((NodeSequence) (val)).m_last;
        if(!val.hasCache())
            val.setShouldCacheNodes(true);
        setObject(((XObject) (val)).m_obj);
    }

    public XNodeSet(DTMManager dtmMgr)
    {
        this(-1, dtmMgr);
    }

    public XNodeSet(int n, DTMManager dtmMgr)
    {
        super(new NodeSetDTM(dtmMgr));
        super.m_dtmMgr = dtmMgr;
        if(-1 != n)
        {
            ((NodeSetDTM)super.m_obj).addNode(n);
            super.m_last = 1;
        } else
        {
            super.m_last = 0;
        }
    }

    public int getType()
    {
        return 4;
    }

    public String getTypeString()
    {
        return "#NODESET";
    }

    public double getNumberFromNode(int n)
    {
        XMLString xstr = super.m_dtmMgr.getDTM(n).getStringValue(n);
        return xstr.toDouble();
    }

    public double num()
    {
        int node = item(0);
        return node == -1 ? (0.0D / 0.0D) : getNumberFromNode(node);
    }

    public double numWithSideEffects()
    {
        int node = nextNode();
        return node == -1 ? (0.0D / 0.0D) : getNumberFromNode(node);
    }

    public boolean bool()
    {
        return item(0) != -1;
    }

    public boolean boolWithSideEffects()
    {
        return nextNode() != -1;
    }

    public XMLString getStringFromNode(int n)
    {
        if(-1 != n)
            return super.m_dtmMgr.getDTM(n).getStringValue(n);
        else
            return XString.EMPTYSTRING;
    }

    public void dispatchCharactersEvents(ContentHandler ch)
        throws SAXException
    {
        int node = item(0);
        if(node != -1)
            super.m_dtmMgr.getDTM(node).dispatchCharactersEvents(node, ch, false);
    }

    public XMLString xstr()
    {
        int node = item(0);
        return ((XMLString) (node == -1 ? XString.EMPTYSTRING : getStringFromNode(node)));
    }

    public void appendToFsb(FastStringBuffer fsb)
    {
        XString xstring = (XString)xstr();
        xstring.appendToFsb(fsb);
    }

    public String str()
    {
        int node = item(0);
        return node == -1 ? "" : getStringFromNode(node).toString();
    }

    public Object object()
    {
        if(null == super.m_obj)
            return this;
        else
            return super.m_obj;
    }

    public NodeIterator nodeset()
        throws TransformerException
    {
        return new DTMNodeIterator(iter());
    }

    public NodeList nodelist()
        throws TransformerException
    {
        DTMNodeList nodelist = new DTMNodeList(this);
        XNodeSet clone = (XNodeSet)nodelist.getDTMIterator();
        SetVector(clone.getVector());
        return nodelist;
    }

    public DTMIterator iterRaw()
    {
        return this;
    }

    public void release(DTMIterator dtmiterator)
    {
    }

    public DTMIterator iter()
    {
        try
        {
            if(hasCache())
                return cloneWithReset();
            else
                return this;
        }
        catch(CloneNotSupportedException cnse)
        {
            throw new RuntimeException(cnse.getMessage());
        }
    }

    public XObject getFresh()
    {
        try
        {
            if(hasCache())
                return (XObject)cloneWithReset();
            else
                return this;
        }
        catch(CloneNotSupportedException cnse)
        {
            throw new RuntimeException(cnse.getMessage());
        }
    }

    public NodeSetDTM mutableNodeset()
    {
        NodeSetDTM mnl;
        if(super.m_obj instanceof NodeSetDTM)
        {
            mnl = (NodeSetDTM)super.m_obj;
        } else
        {
            mnl = new NodeSetDTM(iter());
            setObject(mnl);
            setCurrentPos(0);
        }
        return mnl;
    }

    public boolean compare(XObject obj2, Comparator comparator)
        throws TransformerException
    {
        boolean result = false;
        int type = obj2.getType();
        if(4 == type)
        {
            DTMIterator list1 = iterRaw();
            DTMIterator list2 = ((XNodeSet)obj2).iterRaw();
            Vector node2Strings = null;
            int j;
            while(-1 != (j = list1.nextNode())) 
            {
                XMLString s1 = getStringFromNode(j);
                int j1;
                if(null == node2Strings)
                {
                    while(-1 != (j1 = list2.nextNode())) 
                    {
                        XMLString s2 = getStringFromNode(j1);
                        if(comparator.compareStrings(s1, s2))
                        {
                            result = true;
                            break;
                        }
                        if(null == node2Strings)
                            node2Strings = new Vector();
                        node2Strings.addElement(s2);
                    }
                } else
                {
                    int n = node2Strings.size();
                    for(int i = 0; i < n; i++)
                    {
                        if(!comparator.compareStrings(s1, (XMLString)node2Strings.elementAt(i)))
                            continue;
                        result = true;
                        break;
                    }

                }
            }
            list1.reset();
            list2.reset();
        } else
        if(1 == type)
        {
            double num1 = bool() ? 1.0D : 0.0D;
            double num2 = obj2.num();
            result = comparator.compareNumbers(num1, num2);
        } else
        if(2 == type)
        {
            DTMIterator list1 = iterRaw();
            double num2 = obj2.num();
            int i1;
            while(-1 != (i1 = list1.nextNode())) 
            {
                double num1 = getNumberFromNode(i1);
                if(comparator.compareNumbers(num1, num2))
                {
                    result = true;
                    break;
                }
            }
            list1.reset();
        } else
        if(5 == type)
        {
            XMLString s2 = obj2.xstr();
            DTMIterator list1 = iterRaw();
            int k;
            while(-1 != (k = list1.nextNode())) 
            {
                XMLString s1 = getStringFromNode(k);
                if(comparator.compareStrings(s1, s2))
                {
                    result = true;
                    break;
                }
            }
            list1.reset();
        } else
        if(3 == type)
        {
            XMLString s2 = obj2.xstr();
            DTMIterator list1 = iterRaw();
            int l;
            while(-1 != (l = list1.nextNode())) 
            {
                XMLString s1 = getStringFromNode(l);
                if(comparator.compareStrings(s1, s2))
                {
                    result = true;
                    break;
                }
            }
            list1.reset();
        } else
        {
            result = comparator.compareNumbers(num(), obj2.num());
        }
        return result;
    }

    public boolean lessThan(XObject obj2)
        throws TransformerException
    {
        return compare(obj2, S_LT);
    }

    public boolean lessThanOrEqual(XObject obj2)
        throws TransformerException
    {
        return compare(obj2, S_LTE);
    }

    public boolean greaterThan(XObject obj2)
        throws TransformerException
    {
        return compare(obj2, S_GT);
    }

    public boolean greaterThanOrEqual(XObject obj2)
        throws TransformerException
    {
        return compare(obj2, S_GTE);
    }

    public boolean equals(XObject obj2)
    {
        try
        {
            return compare(obj2, S_EQ);
        }
        catch(TransformerException te)
        {
            throw new WrappedRuntimeException(te);
        }
    }

    public boolean notEquals(XObject obj2)
        throws TransformerException
    {
        return compare(obj2, S_NEQ);
    }

    static final long serialVersionUID = 0x1a9717d4870bd173L;
    static final LessThanComparator S_LT = new LessThanComparator();
    static final LessThanOrEqualComparator S_LTE = new LessThanOrEqualComparator();
    static final GreaterThanComparator S_GT = new GreaterThanComparator();
    static final GreaterThanOrEqualComparator S_GTE = new GreaterThanOrEqualComparator();
    static final EqualComparator S_EQ = new EqualComparator();
    static final NotEqualComparator S_NEQ = new NotEqualComparator();

}
