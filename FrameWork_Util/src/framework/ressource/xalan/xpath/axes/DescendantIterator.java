// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DescendantIterator.java

package framework.ressource.xalan.xpath.axes;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.*;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.compiler.Compiler;
import framework.ressource.xalan.xpath.compiler.OpMap;
import framework.ressource.xalan.xpath.patterns.NodeTest;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            LocPathIterator, PredicatedNodeTest

public class DescendantIterator extends LocPathIterator
{

    DescendantIterator(Compiler compiler, int opPos, int analysis)
        throws TransformerException
    {
        super(compiler, opPos, analysis, false);
        int firstStepPos = OpMap.getFirstChildPos(opPos);
        int stepType = compiler.getOp(firstStepPos);
        boolean orSelf = 42 == stepType;
        boolean fromRoot = false;
        int nextStepPos;
        if(48 == stepType)
            orSelf = true;
        else
        if(50 == stepType)
        {
            fromRoot = true;
            nextStepPos = compiler.getNextStepPos(firstStepPos);
            if(compiler.getOp(nextStepPos) == 42)
                orSelf = true;
        }
        nextStepPos = firstStepPos;
        do
        {
            nextStepPos = compiler.getNextStepPos(nextStepPos);
            if(nextStepPos <= 0)
                break;
            int stepOp = compiler.getOp(nextStepPos);
            if(-1 == stepOp)
                break;
            firstStepPos = nextStepPos;
        } while(true);
        if((analysis & 0x10000) != 0)
            orSelf = false;
        if(fromRoot)
        {
            if(orSelf)
                m_axis = 18;
            else
                m_axis = 17;
        } else
        if(orSelf)
            m_axis = 5;
        else
            m_axis = 4;
        int whatToShow = compiler.getWhatToShow(firstStepPos);
        if(0 == (whatToShow & 0x43) || whatToShow == -1)
            initNodeTest(whatToShow);
        else
            initNodeTest(whatToShow, compiler.getStepNS(firstStepPos), compiler.getStepLocalName(firstStepPos));
        initPredicateInfo(compiler, firstStepPos);
    }

    public DescendantIterator()
    {
        super(null);
        m_axis = 18;
        int whatToShow = -1;
        initNodeTest(whatToShow);
    }

    public DTMIterator cloneWithReset()
        throws CloneNotSupportedException
    {
        DescendantIterator clone = (DescendantIterator)super.cloneWithReset();
        clone.m_traverser = m_traverser;
        clone.resetProximityPositions();
        return clone;
    }

    public int nextNode()
    {
        if(super.m_foundLast)
            return -1;
        if(-1 == super.m_lastFetched)
            resetProximityPositions();
        VariableStack vars;
        int savedStart;
        if(-1 != super.m_stackFrame)
        {
            vars = super.m_execContext.getVarStack();
            savedStart = vars.getStackFrame();
            vars.setStackFrame(super.m_stackFrame);
        } else
        {
            vars = null;
            savedStart = 0;
        }
        try
        {
            int next;
            do
                if(0 == m_extendedTypeID)
                    next = super.m_lastFetched = -1 != super.m_lastFetched ? m_traverser.next(super.m_context, super.m_lastFetched) : m_traverser.first(super.m_context);
                else
                    next = super.m_lastFetched = -1 != super.m_lastFetched ? m_traverser.next(super.m_context, super.m_lastFetched, m_extendedTypeID) : m_traverser.first(super.m_context, m_extendedTypeID);
            while(-1 != next && 1 != acceptNode(next) && next != -1);
            if(-1 != next)
            {
                super.m_pos++;
                int i = next;
                return i;
            }
            super.m_foundLast = true;
            byte byte0 = -1;
            return byte0;
        }
        finally
        {
            if(-1 != super.m_stackFrame)
                vars.setStackFrame(savedStart);
        }
    }

    public void setRoot(int context, Object environment)
    {
        super.setRoot(context, environment);
        m_traverser = super.m_cdtm.getAxisTraverser(m_axis);
        String localName = getLocalName();
        String namespace = getNamespace();
        int what = super.m_whatToShow;
        if(-1 == what || "*".equals(localName) || "*".equals(namespace))
        {
            m_extendedTypeID = 0;
        } else
        {
            int type = NodeTest.getNodeTypeTest(what);
            m_extendedTypeID = super.m_cdtm.getExpandedTypeID(namespace, localName, type);
        }
    }

    public int asNode(XPathContext xctxt)
        throws TransformerException
    {
        if(getPredicateCount() > 0)
            return super.asNode(xctxt);
        int current = xctxt.getCurrentNode();
        DTM dtm = xctxt.getDTM(current);
        DTMAxisTraverser traverser = dtm.getAxisTraverser(m_axis);
        String localName = getLocalName();
        String namespace = getNamespace();
        int what = super.m_whatToShow;
        if(-1 == what || localName == "*" || namespace == "*")
        {
            return traverser.first(current);
        } else
        {
            int type = NodeTest.getNodeTypeTest(what);
            int extendedType = dtm.getExpandedTypeID(namespace, localName, type);
            return traverser.first(current, extendedType);
        }
    }

    public void detach()
    {
        if(super.m_allowDetach)
        {
            m_traverser = null;
            m_extendedTypeID = 0;
            super.detach();
        }
    }

    public int getAxis()
    {
        return m_axis;
    }

    public boolean deepEquals(Expression expr)
    {
        if(!super.deepEquals(expr))
            return false;
        return m_axis == ((DescendantIterator)expr).m_axis;
    }

    static final long serialVersionUID = 0xef7b1157cafcba16L;
    protected transient DTMAxisTraverser m_traverser;
    protected int m_axis;
    protected int m_extendedTypeID;
}
