// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NodeSet.java

package framework.ressource.xalan.xpath;

import org.apache.xml.utils.DOM2Helper;
import framework.ressource.xalan.xpath.axes.ContextNodeList;
import framework.ressource.xalan.xpath.res.XPATHMessages;
import org.w3c.dom.*;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;

// Referenced classes of package framework.ressource.xalan.xpath:
//            XPathContext

public class NodeSet
    implements NodeList, NodeIterator, Cloneable, ContextNodeList
{

    public NodeSet()
    {
        m_next = 0;
        m_mutable = true;
        m_cacheNodes = true;
        m_last = 0;
        m_firstFree = 0;
        m_blocksize = 32;
        m_mapSize = 0;
    }

    public NodeSet(int blocksize)
    {
        m_next = 0;
        m_mutable = true;
        m_cacheNodes = true;
        m_last = 0;
        m_firstFree = 0;
        m_blocksize = blocksize;
        m_mapSize = 0;
    }

    public NodeSet(NodeList nodelist)
    {
        this(32);
        addNodes(nodelist);
    }

    public NodeSet(NodeSet nodelist)
    {
        this(32);
        addNodes(nodelist);
    }

    public NodeSet(NodeIterator ni)
    {
        this(32);
        addNodes(ni);
    }

    public NodeSet(Node node)
    {
        this(32);
        addNode(node);
    }

    public Node getRoot()
    {
        return null;
    }

    public NodeIterator cloneWithReset()
        throws CloneNotSupportedException
    {
        NodeSet clone = (NodeSet)clone();
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

    public NodeFilter getFilter()
    {
        return null;
    }

    public boolean getExpandEntityReferences()
    {
        return true;
    }

    public Node nextNode()
        throws DOMException
    {
        if(m_next < size())
        {
            Node next = elementAt(m_next);
            m_next++;
            return next;
        } else
        {
            return null;
        }
    }

    public Node previousNode()
        throws DOMException
    {
        if(!m_cacheNodes)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_CANNOT_ITERATE", null));
        if(m_next - 1 > 0)
        {
            m_next--;
            return elementAt(m_next);
        } else
        {
            return null;
        }
    }

    public void detach()
    {
    }

    public boolean isFresh()
    {
        return m_next == 0;
    }

    public void runTo(int index)
    {
        if(!m_cacheNodes)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_CANNOT_INDEX", null));
        if(index >= 0 && m_next < m_firstFree)
            m_next = index;
        else
            m_next = m_firstFree - 1;
    }

    public Node item(int index)
    {
        runTo(index);
        return elementAt(index);
    }

    public int getLength()
    {
        runTo(-1);
        return size();
    }

    public void addNode(Node n)
    {
        if(!m_mutable)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_NOT_MUTABLE", null));
        } else
        {
            addElement(n);
            return;
        }
    }

    public void insertNode(Node n, int pos)
    {
        if(!m_mutable)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_NOT_MUTABLE", null));
        } else
        {
            insertElementAt(n, pos);
            return;
        }
    }

    public void removeNode(Node n)
    {
        if(!m_mutable)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_NOT_MUTABLE", null));
        } else
        {
            removeElement(n);
            return;
        }
    }

    public void addNodes(NodeList nodelist)
    {
        if(!m_mutable)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_NOT_MUTABLE", null));
        if(null != nodelist)
        {
            int nChildren = nodelist.getLength();
            for(int i = 0; i < nChildren; i++)
            {
                Node obj = nodelist.item(i);
                if(null != obj)
                    addElement(obj);
            }

        }
    }

    public void addNodes(NodeSet ns)
    {
        if(!m_mutable)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_NOT_MUTABLE", null));
        } else
        {
            addNodes(((NodeIterator) (ns)));
            return;
        }
    }

    public void addNodes(NodeIterator iterator)
    {
        if(!m_mutable)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_NOT_MUTABLE", null));
        Node node;
        if(null != iterator)
            while(null != (node = iterator.nextNode())) 
                addElement(node);
    }

    public void addNodesInDocOrder(NodeList nodelist, XPathContext support)
    {
        if(!m_mutable)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_NOT_MUTABLE", null));
        int nChildren = nodelist.getLength();
        for(int i = 0; i < nChildren; i++)
        {
            Node node = nodelist.item(i);
            if(null != node)
                addNodeInDocOrder(node, support);
        }

    }

    public void addNodesInDocOrder(NodeIterator iterator, XPathContext support)
    {
        if(!m_mutable)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_NOT_MUTABLE", null));
        Node node1;
        while(null != (node1 = iterator.nextNode())) 
            addNodeInDocOrder(node1, support);
    }

    private boolean addNodesInDocOrder(int start, int end, int testIndex, NodeList nodelist, XPathContext support)
    {
        if(!m_mutable)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_NOT_MUTABLE", null));
        boolean foundit = false;
        Node node = nodelist.item(testIndex);
        int i;
        for(i = end; i >= start; i--)
        {
            Node child = elementAt(i);
            if(child == node)
            {
                i = -2;
                break;
            }
            if(DOM2Helper.isNodeAfter(node, child))
                continue;
            insertElementAt(node, i + 1);
            if(--testIndex > 0)
            {
                boolean foundPrev = addNodesInDocOrder(0, i, testIndex, nodelist, support);
                if(!foundPrev)
                    addNodesInDocOrder(i, size() - 1, testIndex, nodelist, support);
            }
            break;
        }

        if(i == -1)
            insertElementAt(node, 0);
        return foundit;
    }

    public int addNodeInDocOrder(Node node, boolean test, XPathContext support)
    {
        if(!m_mutable)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_NOT_MUTABLE", null));
        int insertIndex = -1;
        if(test)
        {
            int size = size();
            int i;
            for(i = size - 1; i >= 0; i--)
            {
                Node child = elementAt(i);
                if(child == node)
                {
                    i = -2;
                    break;
                }
                if(!DOM2Helper.isNodeAfter(node, child))
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
                if(!item(i).equals(node))
                    continue;
                foundit = true;
                break;
            }

            if(!foundit)
                addElement(node);
        }
        return insertIndex;
    }

    public int addNodeInDocOrder(Node node, XPathContext support)
    {
        if(!m_mutable)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_NOT_MUTABLE", null));
        else
            return addNodeInDocOrder(node, true, support);
    }

    public int getCurrentPos()
    {
        return m_next;
    }

    public void setCurrentPos(int i)
    {
        if(!m_cacheNodes)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_CANNOT_INDEX", null));
        } else
        {
            m_next = i;
            return;
        }
    }

    public Node getCurrentNode()
    {
        if(!m_cacheNodes)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_CANNOT_INDEX", null));
        } else
        {
            int saved = m_next;
            Node n = m_next >= m_firstFree ? null : elementAt(m_next);
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

    public int getLast()
    {
        return m_last;
    }

    public void setLast(int last)
    {
        m_last = last;
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        NodeSet clone = (NodeSet)super.clone();
        if(null != m_map && m_map == clone.m_map)
        {
            clone.m_map = new Node[m_map.length];
            System.arraycopy(m_map, 0, clone.m_map, 0, m_map.length);
        }
        return clone;
    }

    public int size()
    {
        return m_firstFree;
    }

    public void addElement(Node value)
    {
        if(!m_mutable)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_NOT_MUTABLE", null));
        if(m_firstFree + 1 >= m_mapSize)
            if(null == m_map)
            {
                m_map = new Node[m_blocksize];
                m_mapSize = m_blocksize;
            } else
            {
                m_mapSize += m_blocksize;
                Node newMap[] = new Node[m_mapSize];
                System.arraycopy(m_map, 0, newMap, 0, m_firstFree + 1);
                m_map = newMap;
            }
        m_map[m_firstFree] = value;
        m_firstFree++;
    }

    public final void push(Node value)
    {
        int ff = m_firstFree;
        if(ff + 1 >= m_mapSize)
            if(null == m_map)
            {
                m_map = new Node[m_blocksize];
                m_mapSize = m_blocksize;
            } else
            {
                m_mapSize += m_blocksize;
                Node newMap[] = new Node[m_mapSize];
                System.arraycopy(m_map, 0, newMap, 0, ff + 1);
                m_map = newMap;
            }
        m_map[ff] = value;
        ff++;
        m_firstFree = ff;
    }

    public final Node pop()
    {
        m_firstFree--;
        Node n = m_map[m_firstFree];
        m_map[m_firstFree] = null;
        return n;
    }

    public final Node popAndTop()
    {
        m_firstFree--;
        m_map[m_firstFree] = null;
        return m_firstFree != 0 ? m_map[m_firstFree - 1] : null;
    }

    public final void popQuick()
    {
        m_firstFree--;
        m_map[m_firstFree] = null;
    }

    public final Node peepOrNull()
    {
        return null == m_map || m_firstFree <= 0 ? null : m_map[m_firstFree - 1];
    }

    public final void pushPair(Node v1, Node v2)
    {
        if(null == m_map)
        {
            m_map = new Node[m_blocksize];
            m_mapSize = m_blocksize;
        } else
        if(m_firstFree + 2 >= m_mapSize)
        {
            m_mapSize += m_blocksize;
            Node newMap[] = new Node[m_mapSize];
            System.arraycopy(m_map, 0, newMap, 0, m_firstFree);
            m_map = newMap;
        }
        m_map[m_firstFree] = v1;
        m_map[m_firstFree + 1] = v2;
        m_firstFree += 2;
    }

    public final void popPair()
    {
        m_firstFree -= 2;
        m_map[m_firstFree] = null;
        m_map[m_firstFree + 1] = null;
    }

    public final void setTail(Node n)
    {
        m_map[m_firstFree - 1] = n;
    }

    public final void setTailSub1(Node n)
    {
        m_map[m_firstFree - 2] = n;
    }

    public final Node peepTail()
    {
        return m_map[m_firstFree - 1];
    }

    public final Node peepTailSub1()
    {
        return m_map[m_firstFree - 2];
    }

    public void insertElementAt(Node value, int at)
    {
        if(!m_mutable)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_NOT_MUTABLE", null));
        if(null == m_map)
        {
            m_map = new Node[m_blocksize];
            m_mapSize = m_blocksize;
        } else
        if(m_firstFree + 1 >= m_mapSize)
        {
            m_mapSize += m_blocksize;
            Node newMap[] = new Node[m_mapSize];
            System.arraycopy(m_map, 0, newMap, 0, m_firstFree + 1);
            m_map = newMap;
        }
        if(at <= m_firstFree - 1)
            System.arraycopy(m_map, at, m_map, at + 1, m_firstFree - at);
        m_map[at] = value;
        m_firstFree++;
    }

    public void appendNodes(NodeSet nodes)
    {
        int nNodes = nodes.size();
        if(null == m_map)
        {
            m_mapSize = nNodes + m_blocksize;
            m_map = new Node[m_mapSize];
        } else
        if(m_firstFree + nNodes >= m_mapSize)
        {
            m_mapSize += nNodes + m_blocksize;
            Node newMap[] = new Node[m_mapSize];
            System.arraycopy(m_map, 0, newMap, 0, m_firstFree + nNodes);
            m_map = newMap;
        }
        System.arraycopy(nodes.m_map, 0, m_map, m_firstFree, nNodes);
        m_firstFree += nNodes;
    }

    public void removeAllElements()
    {
        if(null == m_map)
            return;
        for(int i = 0; i < m_firstFree; i++)
            m_map[i] = null;

        m_firstFree = 0;
    }

    public boolean removeElement(Node s)
    {
        if(!m_mutable)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_NOT_MUTABLE", null));
        if(null == m_map)
            return false;
        for(int i = 0; i < m_firstFree; i++)
        {
            Node node = m_map[i];
            if(null != node && node.equals(s))
            {
                if(i < m_firstFree - 1)
                    System.arraycopy(m_map, i + 1, m_map, i, m_firstFree - i - 1);
                m_firstFree--;
                m_map[m_firstFree] = null;
                return true;
            }
        }

        return false;
    }

    public void removeElementAt(int i)
    {
        if(null == m_map)
            return;
        if(i >= m_firstFree)
            throw new ArrayIndexOutOfBoundsException(i + " >= " + m_firstFree);
        if(i < 0)
            throw new ArrayIndexOutOfBoundsException(i);
        if(i < m_firstFree - 1)
            System.arraycopy(m_map, i + 1, m_map, i, m_firstFree - i - 1);
        m_firstFree--;
        m_map[m_firstFree] = null;
    }

    public void setElementAt(Node node, int index)
    {
        if(!m_mutable)
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NODESET_NOT_MUTABLE", null));
        if(null == m_map)
        {
            m_map = new Node[m_blocksize];
            m_mapSize = m_blocksize;
        }
        m_map[index] = node;
    }

    public Node elementAt(int i)
    {
        if(null == m_map)
            return null;
        else
            return m_map[i];
    }

    public boolean contains(Node s)
    {
        runTo(-1);
        if(null == m_map)
            return false;
        for(int i = 0; i < m_firstFree; i++)
        {
            Node node = m_map[i];
            if(null != node && node.equals(s))
                return true;
        }

        return false;
    }

    public int indexOf(Node elem, int index)
    {
        runTo(-1);
        if(null == m_map)
            return -1;
        for(int i = index; i < m_firstFree; i++)
        {
            Node node = m_map[i];
            if(null != node && node.equals(elem))
                return i;
        }

        return -1;
    }

    public int indexOf(Node elem)
    {
        runTo(-1);
        if(null == m_map)
            return -1;
        for(int i = 0; i < m_firstFree; i++)
        {
            Node node = m_map[i];
            if(null != node && node.equals(elem))
                return i;
        }

        return -1;
    }

    protected transient int m_next;
    protected transient boolean m_mutable;
    protected transient boolean m_cacheNodes;
    private transient int m_last;
    private int m_blocksize;
    Node m_map[];
    protected int m_firstFree;
    private int m_mapSize;
}