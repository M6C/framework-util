// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StepPattern.java

package framework.ressource.xalan.xpath.patterns;

import java.util.Vector;

import javax.xml.transform.TransformerException;

import org.apache.xml.dtm.Axis;
import org.apache.xml.dtm.DTM;
import org.apache.xml.dtm.DTMAxisTraverser;

import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.ExpressionOwner;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.XPathVisitor;
import framework.ressource.xalan.xpath.axes.SubContextList;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.patterns:
//            NodeTest

public class StepPattern extends NodeTest
    implements SubContextList, ExpressionOwner
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
            exp.exprSetParent(StepPattern.this);
            m_predicates[m_index] = exp;
        }

        int m_index;

        PredOwner(int index)
        {
            m_index = index;
        }
    }


    public StepPattern(int whatToShow, String namespace, String name, int axis, int axisForPredicate)
    {
        super(whatToShow, namespace, name);
        m_axis = axis;
    }

    public StepPattern(int whatToShow, int axis, int axisForPredicate)
    {
        super(whatToShow);
        m_axis = axis;
    }

    public void calcTargetString()
    {
        int whatToShow = getWhatToShow();
        switch(whatToShow)
        {
        case 128: 
            m_targetString = "#comment";
            break;

        case 4: // '\004'
        case 8: // '\b'
        case 12: // '\f'
            m_targetString = "#text";
            break;

        case -1: 
            m_targetString = "*";
            break;

        case 256: 
        case 1280: 
            m_targetString = "/";
            break;

        case 1: // '\001'
            if("*" == super.m_name)
                m_targetString = "*";
            else
                m_targetString = super.m_name;
            break;

        default:
            m_targetString = "*";
            break;
        }
    }

    public String getTargetString()
    {
        return m_targetString;
    }

    public void fixupVariables(Vector vars, int globalsSize)
    {
        super.fixupVariables(vars, globalsSize);
        if(null != m_predicates)
        {
            for(int i = 0; i < m_predicates.length; i++)
                m_predicates[i].fixupVariables(vars, globalsSize);

        }
        if(null != m_relativePathPattern)
            m_relativePathPattern.fixupVariables(vars, globalsSize);
    }

    public void setRelativePathPattern(StepPattern expr)
    {
        m_relativePathPattern = expr;
        expr.exprSetParent(this);
        calcScore();
    }

    public StepPattern getRelativePathPattern()
    {
        return m_relativePathPattern;
    }

    public Expression[] getPredicates()
    {
        return m_predicates;
    }

    public boolean canTraverseOutsideSubtree()
    {
        int n = getPredicateCount();
        for(int i = 0; i < n; i++)
            if(getPredicate(i).canTraverseOutsideSubtree())
                return true;

        return false;
    }

    public Expression getPredicate(int i)
    {
        return m_predicates[i];
    }

    public final int getPredicateCount()
    {
        return null != m_predicates ? m_predicates.length : 0;
    }

    public void setPredicates(Expression predicates[])
    {
        m_predicates = predicates;
        if(null != predicates)
        {
            for(int i = 0; i < predicates.length; i++)
                predicates[i].exprSetParent(this);

        }
        calcScore();
    }

    public void calcScore()
    {
        if(getPredicateCount() > 0 || null != m_relativePathPattern)
            super.m_score = NodeTest.SCORE_OTHER;
        else
            super.calcScore();
        if(null == m_targetString)
            calcTargetString();
    }

    public XObject execute(XPathContext xctxt, int currentNode)
        throws TransformerException
    {
        DTM dtm = xctxt.getDTM(currentNode);
        if(dtm != null)
        {
            int expType = dtm.getExpandedTypeID(currentNode);
            return execute(xctxt, currentNode, dtm, expType);
        } else
        {
            return NodeTest.SCORE_NONE;
        }
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        return execute(xctxt, xctxt.getCurrentNode());
    }

    public XObject execute(XPathContext xctxt, int currentNode, DTM dtm, int expType)
        throws TransformerException
    {
        if(super.m_whatToShow == 0x10000)
            if(null != m_relativePathPattern)
                return m_relativePathPattern.execute(xctxt);
            else
                return NodeTest.SCORE_NONE;
        XObject score = super.execute(xctxt, currentNode, dtm, expType);
        if(score == NodeTest.SCORE_NONE)
            return NodeTest.SCORE_NONE;
        if(getPredicateCount() != 0 && !executePredicates(xctxt, dtm, currentNode))
            return NodeTest.SCORE_NONE;
        if(null != m_relativePathPattern)
            return m_relativePathPattern.executeRelativePathPattern(xctxt, dtm, currentNode);
        else
            return score;
    }

    private final boolean checkProximityPosition(XPathContext xctxt, int predPos, DTM dtm, int context, int pos)
    {
        try
        {
            DTMAxisTraverser traverser = dtm.getAxisTraverser(12);
            for(int child = traverser.first(context); -1 != child; child = traverser.next(context, child))
                try
                {
                    xctxt.pushCurrentNode(child);
                    if(NodeTest.SCORE_NONE != super.execute(xctxt, child))
                    {
                        boolean pass = true;
                        try
                        {
                            xctxt.pushSubContextList(this);
                            for(int i = 0; i < predPos; i++)
                            {
                                xctxt.pushPredicatePos(i);
                                try
                                {
                                    XObject pred = m_predicates[i].execute(xctxt);
                                    try
                                    {
                                        if(2 == pred.getType())
                                            throw new Error("Why: Should never have been called");
                                        if(!pred.boolWithSideEffects())
                                        {
                                            pass = false;
                                            break;
                                        }
                                    }
                                    finally
                                    {
                                        pred.detach();
                                    }
                                    continue;
                                }
                                finally
                                {
                                    xctxt.popPredicatePos();
                                }
                            }

                        }
                        finally
                        {
                            xctxt.popSubContextList();
                        }
                        if(pass)
                            pos--;
                        if(pos < 1)
                        {
                            boolean flag = false;
                            return flag;
                        }
                    }
                }
                finally
                {
                    xctxt.popCurrentNode();
                }

        }
        catch(TransformerException se)
        {
            throw new RuntimeException(se.getMessage());
        }
        return pos == 1;
    }

    private final int getProximityPosition(XPathContext xctxt, int predPos, boolean findLast)
    {
        int pos = 0;
        int context = xctxt.getCurrentNode();
        DTM dtm = xctxt.getDTM(context);
        int parent = dtm.getParent(context);
        try
        {
            DTMAxisTraverser traverser = dtm.getAxisTraverser(3);
            for(int child = traverser.first(parent); -1 != child; child = traverser.next(parent, child))
                try
                {
                    xctxt.pushCurrentNode(child);
                    if(NodeTest.SCORE_NONE != super.execute(xctxt, child))
                    {
                        boolean pass = true;
                        try
                        {
                            xctxt.pushSubContextList(this);
                            for(int i = 0; i < predPos; i++)
                            {
                                xctxt.pushPredicatePos(i);
                                try
                                {
                                    XObject pred = m_predicates[i].execute(xctxt);
                                    try
                                    {
                                        if(2 == pred.getType())
                                        {
                                            if(pos + 1 != (int)pred.numWithSideEffects())
                                            {
                                                pass = false;
                                                break;
                                            }
                                        } else
                                        if(!pred.boolWithSideEffects())
                                        {
                                            pass = false;
                                            break;
                                        }
                                    }
                                    finally
                                    {
                                        pred.detach();
                                    }
                                    continue;
                                }
                                finally
                                {
                                    xctxt.popPredicatePos();
                                }
                            }

                        }
                        finally
                        {
                            xctxt.popSubContextList();
                        }
                        if(pass)
                            pos++;
                        if(!findLast && child == context)
                        {
                            int j = pos;
                            return j;
                        }
                    }
                }
                finally
                {
                    xctxt.popCurrentNode();
                }

        }
        catch(TransformerException se)
        {
            throw new RuntimeException(se.getMessage());
        }
        return pos;
    }

    public int getProximityPosition(XPathContext xctxt)
    {
        return getProximityPosition(xctxt, xctxt.getPredicatePos(), false);
    }

    public int getLastPos(XPathContext xctxt)
    {
        return getProximityPosition(xctxt, xctxt.getPredicatePos(), true);
    }

    protected final XObject executeRelativePathPattern(XPathContext xctxt, DTM dtm, int currentNode)
        throws TransformerException
    {
        XObject score = NodeTest.SCORE_NONE;
        int context = currentNode;
        DTMAxisTraverser traverser = dtm.getAxisTraverser(m_axis);
        for(int relative = traverser.first(context); -1 != relative; relative = traverser.next(context, relative))
            try
            {
                xctxt.pushCurrentNode(relative);
                score = execute(xctxt);
                if(score != NodeTest.SCORE_NONE)
                    break;
                continue;
            }
            finally
            {
                xctxt.popCurrentNode();
            }

        return score;
    }

    protected final boolean executePredicates(XPathContext xctxt, DTM dtm, int currentNode)
        throws TransformerException
    {
        boolean result = true;
        boolean positionAlreadySeen = false;
        int n = getPredicateCount();
        try
        {
            xctxt.pushSubContextList(this);
            for(int i = 0; i < n; i++)
            {
                xctxt.pushPredicatePos(i);
                try
                {
                    XObject pred = m_predicates[i].execute(xctxt);
                    try
                    {
                        if(2 == pred.getType())
                        {
                            int pos = (int)pred.num();
                            if(positionAlreadySeen)
                            {
                                result = pos == 1;
                                break;
                            }
                            positionAlreadySeen = true;
                            if(!checkProximityPosition(xctxt, i, dtm, currentNode, pos))
                            {
                                result = false;
                                break;
                            }
                        } else
                        if(!pred.boolWithSideEffects())
                        {
                            result = false;
                            break;
                        }
                    }
                    finally
                    {
                        pred.detach();
                    }
                    continue;
                }
                finally
                {
                    xctxt.popPredicatePos();
                }
            }

        }
        finally
        {
            xctxt.popSubContextList();
        }
        return result;
    }

    public String toString()
    {
        StringBuffer buf = new StringBuffer();
        for(StepPattern pat = this; pat != null; pat = pat.m_relativePathPattern)
        {
            if(pat != this)
                buf.append("/");
            buf.append(Axis.getNames(pat.m_axis));
            buf.append("::");
            if(20480 == ((NodeTest) (pat)).m_whatToShow)
                buf.append("doc()");
            else
            if(0x10000 == ((NodeTest) (pat)).m_whatToShow)
                buf.append("function()");
            else
            if(-1 == ((NodeTest) (pat)).m_whatToShow)
                buf.append("node()");
            else
            if(4 == ((NodeTest) (pat)).m_whatToShow)
                buf.append("text()");
            else
            if(64 == ((NodeTest) (pat)).m_whatToShow)
            {
                buf.append("processing-instruction(");
                if(null != ((NodeTest) (pat)).m_name)
                    buf.append(((NodeTest) (pat)).m_name);
                buf.append(")");
            } else
            if(128 == ((NodeTest) (pat)).m_whatToShow)
                buf.append("comment()");
            else
            if(null != ((NodeTest) (pat)).m_name)
            {
                if(2 == ((NodeTest) (pat)).m_whatToShow)
                    buf.append("@");
                if(null != ((NodeTest) (pat)).m_namespace)
                {
                    buf.append("{");
                    buf.append(((NodeTest) (pat)).m_namespace);
                    buf.append("}");
                }
                buf.append(((NodeTest) (pat)).m_name);
            } else
            if(2 == ((NodeTest) (pat)).m_whatToShow)
                buf.append("@");
            else
            if(1280 == ((NodeTest) (pat)).m_whatToShow)
                buf.append("doc-root()");
            else
                buf.append("?" + Integer.toHexString(((NodeTest) (pat)).m_whatToShow));
            if(null != pat.m_predicates)
            {
                for(int i = 0; i < pat.m_predicates.length; i++)
                {
                    buf.append("[");
                    buf.append(pat.m_predicates[i]);
                    buf.append("]");
                }

            }
        }

        return buf.toString();
    }

    public double getMatchScore(XPathContext xctxt, int context)
        throws TransformerException
    {
        xctxt.pushCurrentNode(context);
        xctxt.pushCurrentExpressionNode(context);
        try
        {
            XObject score = execute(xctxt);
            double d = score.num();
            return d;
        }
        finally
        {
            xctxt.popCurrentNode();
            xctxt.popCurrentExpressionNode();
        }
    }

    public void setAxis(int axis)
    {
        m_axis = axis;
    }

    public int getAxis()
    {
        return m_axis;
    }

    public void callVisitors(ExpressionOwner owner, XPathVisitor visitor)
    {
        if(visitor.visitMatchPattern(owner, this))
            callSubtreeVisitors(visitor);
    }

    protected void callSubtreeVisitors(XPathVisitor visitor)
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
        if(null != m_relativePathPattern)
            m_relativePathPattern.callVisitors(this, visitor);
    }

    public Expression getExpression()
    {
        return m_relativePathPattern;
    }

    public void setExpression(Expression exp)
    {
        exp.exprSetParent(this);
        m_relativePathPattern = (StepPattern)exp;
    }

    public boolean deepEquals(Expression expr)
    {
        if(!super.deepEquals(expr))
            return false;
        StepPattern sp = (StepPattern)expr;
        if(null != m_predicates)
        {
            int n = m_predicates.length;
            if(null == sp.m_predicates || sp.m_predicates.length != n)
                return false;
            for(int i = 0; i < n; i++)
                if(!m_predicates[i].deepEquals(sp.m_predicates[i]))
                    return false;

        } else
        if(null != sp.m_predicates)
            return false;
        if(null != m_relativePathPattern)
        {
            if(!m_relativePathPattern.deepEquals(((Expression) (sp.m_relativePathPattern))))
                return false;
        } else
        if(sp.m_relativePathPattern != null)
            return false;
        return true;
    }

    static final long serialVersionUID = 0x7de50adb02c28e44L;
    protected int m_axis;
    String m_targetString;
    StepPattern m_relativePathPattern;
    Expression m_predicates[];
    private static final boolean DEBUG_MATCHES = false;
}
