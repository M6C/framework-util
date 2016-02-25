// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FunctionPattern.java

package framework.ressource.xalan.xpath.patterns;

import java.util.Vector;
import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import org.apache.xml.dtm.DTMIterator;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.patterns:
//            StepPattern, NodeTest

public class FunctionPattern extends StepPattern
{
    class FunctionOwner
        implements ExpressionOwner
    {

        public Expression getExpression()
        {
            return m_functionExpr;
        }

        public void setExpression(Expression exp)
        {
            exp.exprSetParent(FunctionPattern.this);
            m_functionExpr = exp;
        }

        FunctionOwner()
        {
        }
    }


    public FunctionPattern(Expression expr, int axis, int predaxis)
    {
        super(0, null, null, axis, predaxis);
        m_functionExpr = expr;
    }

    public final void calcScore()
    {
        super.m_score = NodeTest.SCORE_OTHER;
        if(null == super.m_targetString)
            calcTargetString();
    }

    public void fixupVariables(Vector vars, int globalsSize)
    {
        super.fixupVariables(vars, globalsSize);
        m_functionExpr.fixupVariables(vars, globalsSize);
    }

    public XObject execute(XPathContext xctxt, int context)
        throws TransformerException
    {
        DTMIterator nl = m_functionExpr.asIterator(xctxt, context);
        XNumber score = NodeTest.SCORE_NONE;
        int i;
        if(null != nl)
            while(-1 != (i = nl.nextNode())) 
            {
                score = i != context ? NodeTest.SCORE_NONE : NodeTest.SCORE_OTHER;
                if(score == NodeTest.SCORE_OTHER)
                {
                    context = i;
                    break;
                }
            }
        nl.detach();
        return score;
    }

    public XObject execute(XPathContext xctxt, int context, DTM dtm, int expType)
        throws TransformerException
    {
        DTMIterator nl = m_functionExpr.asIterator(xctxt, context);
        XNumber score = NodeTest.SCORE_NONE;
        if(null != nl)
        {
            int i;
            while(-1 != (i = nl.nextNode())) 
            {
                score = i != context ? NodeTest.SCORE_NONE : NodeTest.SCORE_OTHER;
                if(score == NodeTest.SCORE_OTHER)
                {
                    context = i;
                    break;
                }
            }
            nl.detach();
        }
        return score;
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        int context = xctxt.getCurrentNode();
        DTMIterator nl = m_functionExpr.asIterator(xctxt, context);
        XNumber score = NodeTest.SCORE_NONE;
        if(null != nl)
        {
            int i;
            while(-1 != (i = nl.nextNode())) 
            {
                score = i != context ? NodeTest.SCORE_NONE : NodeTest.SCORE_OTHER;
                if(score == NodeTest.SCORE_OTHER)
                {
                    context = i;
                    break;
                }
            }
            nl.detach();
        }
        return score;
    }

    protected void callSubtreeVisitors(XPathVisitor visitor)
    {
        m_functionExpr.callVisitors(new FunctionOwner(), visitor);
        super.callSubtreeVisitors(visitor);
    }

    static final long serialVersionUID = 0xb4b02824a744cd28L;
    Expression m_functionExpr;
}
