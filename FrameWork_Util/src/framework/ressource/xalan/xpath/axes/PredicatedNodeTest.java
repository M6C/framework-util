// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PredicatedNodeTest.java

package framework.ressource.xalan.xpath.axes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;
import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import org.apache.xml.utils.WrappedRuntimeException;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.compiler.Compiler;
import framework.ressource.xalan.xpath.compiler.OpMap;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.patterns.NodeTest;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            LocPathIterator, SubContextList

public abstract class PredicatedNodeTest extends NodeTest
    implements SubContextList
{
    class PredOwner
        implements ExpressionOwner
    {

        public Expression getExpression()
        {
            return m_predicates[m_index];
        }

        public void setExpression(Expression exp)
        {
            exp.exprSetParent(PredicatedNodeTest.this);
            m_predicates[m_index] = exp;
        }

        int m_index;

        PredOwner(int index)
        {
            m_index = index;
        }
    }


    PredicatedNodeTest(LocPathIterator locPathIterator)
    {
        m_predCount = -1;
        m_foundLast = false;
        m_predicateIndex = -1;
        m_lpi = locPathIterator;
    }

    PredicatedNodeTest()
    {
        m_predCount = -1;
        m_foundLast = false;
        m_predicateIndex = -1;
    }

    private void readObject(ObjectInputStream stream)
        throws IOException, TransformerException
    {
        try
        {
            stream.defaultReadObject();
            m_predicateIndex = -1;
            resetProximityPositions();
        }
        catch(ClassNotFoundException cnfe)
        {
            throw new TransformerException(cnfe);
        }
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        PredicatedNodeTest clone = (PredicatedNodeTest)super.clone();
        if(null != m_proximityPositions && m_proximityPositions == clone.m_proximityPositions)
        {
            clone.m_proximityPositions = new int[m_proximityPositions.length];
            System.arraycopy(m_proximityPositions, 0, clone.m_proximityPositions, 0, m_proximityPositions.length);
        }
        if(clone.m_lpi == this)
            clone.m_lpi = (LocPathIterator)clone;
        return clone;
    }

    public int getPredicateCount()
    {
        if(-1 == m_predCount)
            return null != m_predicates ? m_predicates.length : 0;
        else
            return m_predCount;
    }

    public void setPredicateCount(int count)
    {
        if(count > 0)
        {
            Expression newPredicates[] = new Expression[count];
            for(int i = 0; i < count; i++)
                newPredicates[i] = m_predicates[i];

            m_predicates = newPredicates;
        } else
        {
            m_predicates = null;
        }
    }

    protected void initPredicateInfo(Compiler compiler, int opPos)
        throws TransformerException
    {
        int pos = compiler.getFirstPredicateOpPos(opPos);
        if(pos > 0)
        {
            m_predicates = compiler.getCompiledPredicates(pos);
            if(null != m_predicates)
            {
                for(int i = 0; i < m_predicates.length; i++)
                    m_predicates[i].exprSetParent(this);

            }
        }
    }

    public Expression getPredicate(int index)
    {
        return m_predicates[index];
    }

    public int getProximityPosition()
    {
        return getProximityPosition(m_predicateIndex);
    }

    public int getProximityPosition(XPathContext xctxt)
    {
        return getProximityPosition();
    }

    public abstract int getLastPos(XPathContext xpathcontext);

    protected int getProximityPosition(int predicateIndex)
    {
        return predicateIndex < 0 ? 0 : m_proximityPositions[predicateIndex];
    }

    public void resetProximityPositions()
    {
        int nPredicates = getPredicateCount();
        if(nPredicates > 0)
        {
            if(null == m_proximityPositions)
                m_proximityPositions = new int[nPredicates];
            for(int i = 0; i < nPredicates; i++)
                try
                {
                    initProximityPosition(i);
                }
                catch(Exception e)
                {
                    throw new WrappedRuntimeException(e);
                }

        }
    }

    public void initProximityPosition(int i)
        throws TransformerException
    {
        m_proximityPositions[i] = 0;
    }

    protected void countProximityPosition(int i)
    {
        int pp[] = m_proximityPositions;
        if(null != pp && i < pp.length)
            pp[i]++;
    }

    public boolean isReverseAxes()
    {
        return false;
    }

    public int getPredicateIndex()
    {
        return m_predicateIndex;
    }

    boolean executePredicates(int context, XPathContext xctxt)
        throws TransformerException
    {
        int nPredicates = getPredicateCount();
        if(nPredicates == 0)
            return true;
        org.apache.xml.utils.PrefixResolver savedResolver = xctxt.getNamespaceContext();
        try
        {
            m_predicateIndex = 0;
            xctxt.pushSubContextList(this);
            xctxt.pushNamespaceContext(m_lpi.getPrefixResolver());
            xctxt.pushCurrentNode(context);
            for(int i = 0; i < nPredicates; i++)
            {
                XObject pred = m_predicates[i].execute(xctxt);
                if(2 == pred.getType())
                {
                    int proxPos = getProximityPosition(m_predicateIndex);
                    int predIndex = (int)pred.num();
                    if(proxPos != predIndex)
                    {
                        boolean flag1 = false;
                        return flag1;
                    }
                    if(m_predicates[i].isStableNumber() && i == nPredicates - 1)
                        m_foundLast = true;
                } else
                if(!pred.bool())
                {
                    boolean flag = false;
                    return flag;
                }
                countProximityPosition(++m_predicateIndex);
            }

        }
        finally
        {
            xctxt.popCurrentNode();
            xctxt.popNamespaceContext();
            xctxt.popSubContextList();
            m_predicateIndex = -1;
        }
        return true;
    }

    public void fixupVariables(Vector vars, int globalsSize)
    {
        super.fixupVariables(vars, globalsSize);
        int nPredicates = getPredicateCount();
        for(int i = 0; i < nPredicates; i++)
            m_predicates[i].fixupVariables(vars, globalsSize);

    }

    protected String nodeToString(int n)
    {
        if(-1 != n)
        {
            DTM dtm = m_lpi.getXPathContext().getDTM(n);
            return dtm.getNodeName(n) + "{" + (n + 1) + "}";
        } else
        {
            return "null";
        }
    }

    public short acceptNode(int n)
    {
        XPathContext xctxt = m_lpi.getXPathContext();
        try
        {
            xctxt.pushCurrentNode(n);
            XObject score = execute(xctxt, n);
            if(score != NodeTest.SCORE_NONE)
            {
                if(getPredicateCount() > 0)
                {
                    countProximityPosition(0);
                    if(!executePredicates(n, xctxt))
                    {
                        short word0 = 3;
                        return word0;
                    }
                }
                short word1 = 1;
                return word1;
            }
        }
        catch(TransformerException se)
        {
            throw new RuntimeException(se.getMessage());
        }
        finally
        {
            xctxt.popCurrentNode();
        }
        return 3;
    }

    public LocPathIterator getLocPathIterator()
    {
        return m_lpi;
    }

    public void setLocPathIterator(LocPathIterator li)
    {
        m_lpi = li;
        if(this != li)
            li.exprSetParent(this);
    }

    public boolean canTraverseOutsideSubtree()
    {
        int n = getPredicateCount();
        for(int i = 0; i < n; i++)
            if(getPredicate(i).canTraverseOutsideSubtree())
                return true;

        return false;
    }

    public void callPredicateVisitors(XPathVisitor visitor)
    {
        if(null != m_predicates)
        {
            int n = m_predicates.length;
            for(int i = 0; i < n; i++)
            {
                ExpressionOwner predOwner = new PredOwner(i);
                if(visitor.visitPredicate(predOwner, m_predicates[i]))
                    m_predicates[i].callVisitors(predOwner, visitor);
            }

        }
    }

    public boolean deepEquals(Expression expr)
    {
        if(!super.deepEquals(expr))
            return false;
        PredicatedNodeTest pnt = (PredicatedNodeTest)expr;
        if(null != m_predicates)
        {
            int n = m_predicates.length;
            if(null == pnt.m_predicates || pnt.m_predicates.length != n)
                return false;
            for(int i = 0; i < n; i++)
                if(!m_predicates[i].deepEquals(pnt.m_predicates[i]))
                    return false;

        } else
        if(null != pnt.m_predicates)
            return false;
        return true;
    }

    static final long serialVersionUID = 0xaa0c289749e4b1f9L;
    protected int m_predCount;
    protected transient boolean m_foundLast;
    protected LocPathIterator m_lpi;
    transient int m_predicateIndex;
    private Expression m_predicates[];
    protected transient int m_proximityPositions[];
    static final boolean DEBUG_PREDICATECOUNTING = false;

}
