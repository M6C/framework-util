// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AxesWalker.java

package framework.ressource.xalan.xpath.axes;

import java.util.Vector;
import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import org.apache.xml.dtm.DTMAxisTraverser;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.compiler.Compiler;
import framework.ressource.xalan.xpath.res.XPATHMessages;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            PredicatedNodeTest, WalkingIterator, PathComponent, WalkerFactory, 
//            LocPathIterator

public class AxesWalker extends PredicatedNodeTest
    implements Cloneable, PathComponent, ExpressionOwner
{

    public AxesWalker(LocPathIterator locPathIterator, int axis)
    {
        super(locPathIterator);
        m_root = -1;
        m_currentNode = -1;
        m_axis = -1;
        m_axis = axis;
    }

    public final WalkingIterator wi()
    {
        return (WalkingIterator)super.m_lpi;
    }

    public void init(Compiler compiler, int opPos, int stepType)
        throws TransformerException
    {
        initPredicateInfo(compiler, opPos);
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        AxesWalker clone = (AxesWalker)super.clone();
        return clone;
    }

    AxesWalker cloneDeep(WalkingIterator cloneOwner, Vector cloneList)
        throws CloneNotSupportedException
    {
        AxesWalker clone = findClone(this, cloneList);
        if(null != clone)
            return clone;
        clone = (AxesWalker)clone();
        clone.setLocPathIterator(cloneOwner);
        if(null != cloneList)
        {
            cloneList.addElement(this);
            cloneList.addElement(clone);
        }
        if(wi().m_lastUsedWalker == this)
            cloneOwner.m_lastUsedWalker = clone;
        if(null != m_nextWalker)
            clone.m_nextWalker = m_nextWalker.cloneDeep(cloneOwner, cloneList);
        if(null != cloneList)
        {
            if(null != m_prevWalker)
                clone.m_prevWalker = m_prevWalker.cloneDeep(cloneOwner, cloneList);
        } else
        if(null != m_nextWalker)
            clone.m_nextWalker.m_prevWalker = clone;
        return clone;
    }

    static AxesWalker findClone(AxesWalker key, Vector cloneList)
    {
        if(null != cloneList)
        {
            int n = cloneList.size();
            for(int i = 0; i < n; i += 2)
                if(key == cloneList.elementAt(i))
                    return (AxesWalker)cloneList.elementAt(i + 1);

        }
        return null;
    }

    public void detach()
    {
        m_currentNode = -1;
        m_dtm = null;
        m_traverser = null;
        m_isFresh = true;
        m_root = -1;
    }

    public int getRoot()
    {
        return m_root;
    }

    public int getAnalysisBits()
    {
        int axis = getAxis();
        int bit = WalkerFactory.getAnalysisBitFromAxes(axis);
        return bit;
    }

    public void setRoot(int root)
    {
        XPathContext xctxt = wi().getXPathContext();
        m_dtm = xctxt.getDTM(root);
        m_traverser = m_dtm.getAxisTraverser(m_axis);
        m_isFresh = true;
        super.m_foundLast = false;
        m_root = root;
        m_currentNode = root;
        if(-1 == root)
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_SETTING_WALKER_ROOT_TO_NULL", null));
        } else
        {
            resetProximityPositions();
            return;
        }
    }

    public final int getCurrentNode()
    {
        return m_currentNode;
    }

    public void setNextWalker(AxesWalker walker)
    {
        m_nextWalker = walker;
    }

    public AxesWalker getNextWalker()
    {
        return m_nextWalker;
    }

    public void setPrevWalker(AxesWalker walker)
    {
        m_prevWalker = walker;
    }

    public AxesWalker getPrevWalker()
    {
        return m_prevWalker;
    }

    private int returnNextNode(int n)
    {
        return n;
    }

    protected int getNextNode()
    {
        if(super.m_foundLast)
            return -1;
        if(m_isFresh)
        {
            m_currentNode = m_traverser.first(m_root);
            m_isFresh = false;
        } else
        if(-1 != m_currentNode)
            m_currentNode = m_traverser.next(m_root, m_currentNode);
        if(-1 == m_currentNode)
            super.m_foundLast = true;
        return m_currentNode;
    }

    public int nextNode()
    {
        int nextNode = -1;
        AxesWalker walker = wi().getLastUsedWalker();
        do
        {
            if(null == walker)
                break;
            nextNode = walker.getNextNode();
            if(-1 == nextNode)
            {
                walker = walker.m_prevWalker;
                continue;
            }
            if(walker.acceptNode(nextNode) != 1)
                continue;
            if(null == walker.m_nextWalker)
            {
                wi().setLastUsedWalker(walker);
                break;
            }
            AxesWalker prev = walker;
            walker = walker.m_nextWalker;
            walker.setRoot(nextNode);
            walker.m_prevWalker = prev;
        } while(true);
        return nextNode;
    }

    public int getLastPos(XPathContext xctxt)
    {
        int pos = getProximityPosition();
        AxesWalker walker;
        try
        {
            walker = (AxesWalker)clone();
        }
        catch(CloneNotSupportedException cnse)
        {
            return -1;
        }
        walker.setPredicateCount(super.m_predicateIndex);
        walker.setNextWalker(null);
        walker.setPrevWalker(null);
        WalkingIterator lpi = wi();
        AxesWalker savedWalker = lpi.getLastUsedWalker();
        try
        {
            lpi.setLastUsedWalker(walker);
            int next;
            while(-1 != (next = walker.nextNode())) 
                pos++;
        }
        finally
        {
            lpi.setLastUsedWalker(savedWalker);
        }
        return pos;
    }

    public void setDefaultDTM(DTM dtm)
    {
        m_dtm = dtm;
    }

    public DTM getDTM(int node)
    {
        return wi().getXPathContext().getDTM(node);
    }

    public boolean isDocOrdered()
    {
        return true;
    }

    public int getAxis()
    {
        return m_axis;
    }

    public void callVisitors(ExpressionOwner owner, XPathVisitor visitor)
    {
        if(visitor.visitStep(owner, this))
        {
            callPredicateVisitors(visitor);
            if(null != m_nextWalker)
                m_nextWalker.callVisitors(((ExpressionOwner) (this)), visitor);
        }
    }

    public Expression getExpression()
    {
        return m_nextWalker;
    }

    public void setExpression(Expression exp)
    {
        exp.exprSetParent(this);
        m_nextWalker = (AxesWalker)exp;
    }

    public boolean deepEquals(Expression expr)
    {
        if(!super.deepEquals(expr))
            return false;
        AxesWalker walker = (AxesWalker)expr;
        return m_axis == walker.m_axis;
    }

    static final long serialVersionUID = 0xd6d689a7ade94ce1L;
    private DTM m_dtm;
    transient int m_root;
    private transient int m_currentNode;
    transient boolean m_isFresh;
    protected AxesWalker m_nextWalker;
    AxesWalker m_prevWalker;
    protected int m_axis;
    protected DTMAxisTraverser m_traverser;
}
