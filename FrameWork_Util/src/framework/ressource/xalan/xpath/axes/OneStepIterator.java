// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OneStepIterator.java

package framework.ressource.xalan.xpath.axes;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.*;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.compiler.Compiler;
import framework.ressource.xalan.xpath.compiler.OpMap;
import framework.ressource.xalan.xpath.patterns.NodeTest;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            ChildTestIterator, WalkerFactory, LocPathIterator, PredicatedNodeTest, 
//            BasicTestIterator

public class OneStepIterator extends ChildTestIterator
{

    OneStepIterator(Compiler compiler, int opPos, int analysis)
        throws TransformerException
    {
        super(compiler, opPos, analysis);
        m_axis = -1;
        int firstStepPos = OpMap.getFirstChildPos(opPos);
        m_axis = WalkerFactory.getAxisFromStep(compiler, firstStepPos);
    }

    public OneStepIterator(DTMAxisIterator iterator, int axis)
        throws TransformerException
    {
        super(null);
        m_axis = -1;
        m_iterator = iterator;
        m_axis = axis;
        int whatToShow = -1;
        initNodeTest(whatToShow);
    }

    public void setRoot(int context, Object environment)
    {
        super.setRoot(context, environment);
        if(m_axis > -1)
            m_iterator = super.m_cdtm.getAxisIterator(m_axis);
        m_iterator.setStartNode(super.m_context);
    }

    public void detach()
    {
        if(super.m_allowDetach)
        {
            if(m_axis > -1)
                m_iterator = null;
            super.detach();
        }
    }

    protected int getNextNode()
    {
        return super.m_lastFetched = m_iterator.next();
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        OneStepIterator clone = (OneStepIterator)super.clone();
        if(m_iterator != null)
            clone.m_iterator = m_iterator.cloneIterator();
        return clone;
    }

    public DTMIterator cloneWithReset()
        throws CloneNotSupportedException
    {
        OneStepIterator clone = (OneStepIterator)super.cloneWithReset();
        clone.m_iterator = m_iterator;
        return clone;
    }

    public boolean isReverseAxes()
    {
        return m_iterator.isReverse();
    }

    protected int getProximityPosition(int predicateIndex)
    {
        if(!isReverseAxes())
            return super.getProximityPosition(predicateIndex);
        if(predicateIndex < 0)
            return -1;
        if(super.m_proximityPositions[predicateIndex] <= 0)
        {
            XPathContext xctxt = getXPathContext();
            try
            {
                OneStepIterator clone = (OneStepIterator)clone();
                int root = getRoot();
                xctxt.pushCurrentNode(root);
                clone.setRoot(root, xctxt);
                clone.m_predCount = predicateIndex;
                int count;
                int next;
                for(count = 1; -1 != (next = clone.nextNode()); count++);
                super.m_proximityPositions[predicateIndex] += count;
            }
            catch(CloneNotSupportedException cnse) { }
            finally
            {
                xctxt.popCurrentNode();
            }
        }
        return super.m_proximityPositions[predicateIndex];
    }

    public int getLength()
    {
        if(!isReverseAxes())
            return super.getLength();
        boolean isPredicateTest = this == super.m_execContext.getSubContextList();
        int predCount = getPredicateCount();
        if(-1 != super.m_length && isPredicateTest && super.m_predicateIndex < 1)
            return super.m_length;
        int count = 0;
        XPathContext xctxt = getXPathContext();
        try
        {
            OneStepIterator clone = (OneStepIterator)cloneWithReset();
            int root = getRoot();
            xctxt.pushCurrentNode(root);
            clone.setRoot(root, xctxt);
            clone.m_predCount = super.m_predicateIndex;
            int next;
            while(-1 != (next = clone.nextNode())) 
                count++;
        }
        catch(CloneNotSupportedException cnse) { }
        finally
        {
            xctxt.popCurrentNode();
        }
        if(isPredicateTest && super.m_predicateIndex < 1)
            super.m_length = count;
        return count;
    }

    protected void countProximityPosition(int i)
    {
        if(!isReverseAxes())
            super.countProximityPosition(i);
        else
        if(i < super.m_proximityPositions.length)
            super.m_proximityPositions[i]--;
    }

    public void reset()
    {
        super.reset();
        if(null != m_iterator)
            m_iterator.reset();
    }

    public int getAxis()
    {
        return m_axis;
    }

    public boolean deepEquals(Expression expr)
    {
        if(!super.deepEquals(expr))
            return false;
        return m_axis == ((OneStepIterator)expr).m_axis;
    }

    static final long serialVersionUID = 0x402ab874e6139f8bL;
    protected int m_axis;
    protected DTMAxisIterator m_iterator;
}
