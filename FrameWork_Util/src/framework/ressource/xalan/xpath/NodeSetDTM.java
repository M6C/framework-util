// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NodeSetDTM.java

package framework.ressource.xalan.xpath;

import org.apache.xml.dtm.*;
import org.apache.xml.utils.NodeVector;
import framework.ressource.xalan.xpath.res.XPATHMessages;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.NodeIterator;

// Referenced classes of package framework.ressource.xalan.xpath:
//            XPathContext

public class NodeSetDTM extends NodeVector
    implements DTMIterator, Cloneable
{

    public NodeSetDTM(DTMManager dtmManager)
    {
        m_next = 0;
        m_mutable = true;
        m_cacheNodes = true;
        m_root = -1;
        m_last = 0;
        m_manager = dtmManager;
    }

    public NodeSetDTM(int blocksize, int dummy, DTMManager dtmManager)
    {
        super(blocksize);
        m_next = 0;
        m_mutable = true;
        m_cacheNodes = true;
        m_root = -1;
        m_last = 0;
        m_manager = dtmManager;
    }

    public NodeSetDTM(NodeSetDTM nodelist)
    {
        m_next = 0;
        m_mutable = true;
        m_cacheNodes = true;
        m_root = -1;
        m_last = 0;
        m_manager = nodelist.getDTMManager();
        m_root = nodelist.getRoot();
        addNodes(nodelist);
    }

    public NodeSetDTM(DTMIterator ni)
    {
        m_next = 0;
        m_mutable = true;
        m_cacheNodes = true;
        m_root = -1;
        m_last = 0;
        m_manager = ni.getDTMManager();
        m_root = ni.getRoot();
        addNodes(ni);
    }

    public NodeSetDTM(NodeIterator iterator, XPathContext xctxt)
    {
        m_next = 0;
        m_mutable = true;
        m_cacheNodes = true;
        m_root = -1;
        m_last = 0;
        m_manager = xctxt.getDTMManager();
        org.w3c.dom.Node node1;
        while(null != (node1 = iterator.nextNode())) 
        {
            int handle = xctxt.getDTMHandleFromNode(node1);
            addNodeInDocOrder(handle, xctxt);
        }
    }

    public NodeSetDTM(NodeList nodeList, XPathContext xctxt)
    {
        m_next = 0;
        m_mutable = true;
        m_cacheNodes = true;
        m_root = -1;
        m_last = 0;
        m_manager = xctxt.getDTMManager();
        int n = nodeList.getLength();
        for(int i = 0; i < n; i++)
        {
            org.w3c.dom.Node node = nodeList.item(i);
            int handle = xctxt.getDTMHandleFromNode(node);
            addNode(handle);
        }

    }

    public NodeSetDTM(int node, DTMManager dtmManager)
    {
        m_next = 0;
        m_mutable = true;
        m_cacheNodes = true;
        m_root = -1;
        m_last = 0;
        m_manager = dtmManager;
        addNode(node);
    }

    public void setEnvironment(Object obj)
    {
    }

    public int getRoot()
    {
        if(-1 == m_root)
        {
            if(size() > 0)
                return item(0);
            else
                return -1;
        } else
        {
            return m_root;
        }
    }

    public void setRoot(int i, Object obj)
    {
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        NodeSetDTM clone = (NodeSetDTM)super.clone();
        return clone;
    }

    public DTMIterator cloneWithReset()
        throws CloneNotSupportedException
    {
        NodeSetDTM clone = (NodeSetDTM)clone();
        clone.reset();
        return clone;
    }

    public void reset()
    {
        m_next = 0;
    }

    public int getWhatToShow()
    {
        return -17;
    }

    public DTMFilter getFilter()
    {
        return null;
    }

    public boolean getExpandEntityReferences()
    {
        return true;
    }

    public DTM getDTM(int nodeHandle)
    {
        return m_manager.getDTM(nodeHandle);
    }

    public DTMManager getDTMManager()
    {
        return m_manager;
    }

    public int nextNode()
    {
        if(m_next < size())
        {
            int next = elementAt(m_next);
            m_next++;
            return next;
        } else
        {
            return -1;
        }
    }

    public int previousNode()
    {
        if(!m_cacheNodes)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_CANNOT_ITERATE", null));
        if(m_next - 1 > 0)
        {
            m_next--;
            return elementAt(m_next);
        } else
        {
            return -1;
        }
    }

    public void detach()
    {
    }

    public void allowDetachToRelease(boolean flag)
    {
    }

    public boolean isFresh()
    {
        return m_next == 0;
    }

    public void runTo(int index)
    {
        if(!m_cacheNodes)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_CANNOT_INDEX", null));
        if(index >= 0 && m_next < super.m_firstFree)
            m_next = index;
        else
            m_next = super.m_firstFree - 1;
    }

    public int item(int index)
    {
        runTo(index);
        return elementAt(index);
    }

    public int getLength()
    {
        runTo(-1);
        return size();
    }

    public void addNode(int n)
    {
        if(!m_mutable)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_NOT_MUTABLE", null));
        } else
        {
            addElement(n);
            return;
        }
    }

    public void insertNode(int n, int pos)
    {
        if(!m_mutable)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_NOT_MUTABLE", null));
        } else
        {
            insertElementAt(n, pos);
            return;
        }
    }

    public void removeNode(int n)
    {
        if(!m_mutable)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_NOT_MUTABLE", null));
        } else
        {
            removeElement(n);
            return;
        }
    }

    public void addNodes(DTMIterator iterator)
    {
        if(!m_mutable)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_NOT_MUTABLE", null));
        int i;
        if(null != iterator)
            while(-1 != (i = iterator.nextNode())) 
                addElement(i);
    }

    public void addNodesInDocOrder(DTMIterator iterator, XPathContext support)
    {
        if(!m_mutable)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_NOT_MUTABLE", null));
        int i;
        while(-1 != (i = iterator.nextNode())) 
            addNodeInDocOrder(i, support);
    }

    public int addNodeInDocOrder(int node, boolean test, XPathContext support)
    {
        if(!m_mutable)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_NOT_MUTABLE", null));
        int insertIndex = -1;
        if(test)
        {
            int size = size();
            int i;
            for(i = size - 1; i >= 0; i--)
            {
                int child = elementAt(i);
                if(child == node)
                {
                    i = -2;
                    break;
                }
                DTM dtm = support.getDTM(node);
                if(!dtm.isNodeAfter(node, child))
                    break;
            }

            if(i != -2)
            {
                insertIndex = i + 1;
                insertElementAt(node, insertIndex);
            }
        } else
        {
            insertIndex = size();
            boolean foundit = false;
            for(int i = 0; i < insertIndex; i++)
            {
                if(i != node)
                    continue;
                foundit = true;
                break;
            }

            if(!foundit)
                addElement(node);
        }
        return insertIndex;
    }

    public int addNodeInDocOrder(int node, XPathContext support)
    {
        if(!m_mutable)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_NOT_MUTABLE", null));
        else
            return addNodeInDocOrder(node, true, support);
    }

    public int size()
    {
        return super.size();
    }

    public void addElement(int value)
    {
        if(!m_mutable)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_NOT_MUTABLE", null));
        } else
        {
            super.addElement(value);
            return;
        }
    }

    public void insertElementAt(int value, int at)
    {
        if(!m_mutable)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_NOT_MUTABLE", null));
        } else
        {
            super.insertElementAt(value, at);
            return;
        }
    }

    public void appendNodes(NodeVector nodes)
    {
        if(!m_mutable)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_NOT_MUTABLE", null));
        } else
        {
            super.appendNodes(nodes);
            return;
        }
    }

    public void removeAllElements()
    {
        if(!m_mutable)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_NOT_MUTABLE", null));
        } else
        {
            super.removeAllElements();
            return;
        }
    }

    public boolean removeElement(int s)
    {
        if(!m_mutable)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_NOT_MUTABLE", null));
        else
            return super.removeElement(s);
    }

    public void removeElementAt(int i)
    {
        if(!m_mutable)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_NOT_MUTABLE", null));
        } else
        {
            super.removeElementAt(i);
            return;
        }
    }

    public void setElementAt(int node, int index)
    {
        if(!m_mutable)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_NOT_MUTABLE", null));
        } else
        {
            super.setElementAt(node, index);
            return;
        }
    }

    public void setItem(int node, int index)
    {
        if(!m_mutable)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_NOT_MUTABLE", null));
        } else
        {
            super.setElementAt(node, index);
            return;
        }
    }

    public int elementAt(int i)
    {
        runTo(i);
        return super.elementAt(i);
    }

    public boolean contains(int s)
    {
        runTo(-1);
        return super.contains(s);
    }

    public int indexOf(int elem, int index)
    {
        runTo(-1);
        return super.indexOf(elem, index);
    }

    public int indexOf(int elem)
    {
        runTo(-1);
        return super.indexOf(elem);
    }

    public int getCurrentPos()
    {
        return m_next;
    }

    public void setCurrentPos(int i)
    {
        if(!m_cacheNodes)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESETDTM_CANNOT_INDEX", null));
        } else
        {
            m_next = i;
            return;
        }
    }

    public int getCurrentNode()
    {
        if(!m_cacheNodes)
        {
            throw new RuntimeException("This NodeSetDTM can not do indexing or counting functions!");
        } else
        {
            int saved = m_next;
            int current = m_next <= 0 ? m_next : m_next - 1;
            int n = current >= super.m_firstFree ? -1 : elementAt(current);
            m_next = saved;
            return n;
        }
    }

    public boolean getShouldCacheNodes()
    {
        return m_cacheNodes;
    }

    public void setShouldCacheNodes(boolean b)
    {
        if(!isFresh())
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_CANNOT_CALL_SETSHOULDCACHENODE", null));
        } else
        {
            m_cacheNodes = b;
            m_mutable = true;
            return;
        }
    }

    public boolean isMutable()
    {
        return m_mutable;
    }

    public int getLast()
    {
        return m_last;
    }

    public void setLast(int last)
    {
        m_last = last;
    }

    public boolean isDocOrdered()
    {
        return true;
    }

    public int getAxis()
    {
        return -1;
    }

    static final long serialVersionUID = 0x6aabdcf4e04f714eL;
    DTMManager m_manager;
    protected transient int m_next;
    protected transient boolean m_mutable;
    protected transient boolean m_cacheNodes;
    protected int m_root;
    private transient int m_last;
}
