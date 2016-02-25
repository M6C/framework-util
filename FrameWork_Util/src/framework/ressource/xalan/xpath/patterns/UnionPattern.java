// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UnionPattern.java

package framework.ressource.xalan.xpath.patterns;

import java.util.Vector;
import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.patterns:
//            StepPattern, NodeTest

public class UnionPattern extends Expression
{
    class UnionPathPartOwner
        implements ExpressionOwner
    {

        public Expression getExpression()
        {
            return m_patterns[m_index];
        }

        public void setExpression(Expression exp)
        {
            exp.exprSetParent(UnionPattern.this);
            m_patterns[m_index] = (StepPattern)exp;
        }

        int m_index;

        UnionPathPartOwner(int index)
        {
            m_index = index;
        }
    }


    public UnionPattern()
    {
    }

    public void fixupVariables(Vector vars, int globalsSize)
    {
        for(int i = 0; i < m_patterns.length; i++)
            m_patterns[i].fixupVariables(vars, globalsSize);

    }

    public boolean canTraverseOutsideSubtree()
    {
        if(null != m_patterns)
        {
            int n = m_patterns.length;
            for(int i = 0; i < n; i++)
                if(m_patterns[i].canTraverseOutsideSubtree())
                    return true;

        }
        return false;
    }

    public void setPatterns(StepPattern patterns[])
    {
        m_patterns = patterns;
        if(null != patterns)
        {
            for(int i = 0; i < patterns.length; i++)
                patterns[i].exprSetParent(this);

        }
    }

    public StepPattern[] getPatterns()
    {
        return m_patterns;
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        XObject bestScore = null;
        int n = m_patterns.length;
        for(int i = 0; i < n; i++)
        {
            XObject score = m_patterns[i].execute(xctxt);
            if(score != NodeTest.SCORE_NONE)
                if(null == bestScore)
                    bestScore = score;
                else
                if(score.num() > bestScore.num())
                    bestScore = score;
        }

        if(null == bestScore)
            bestScore = NodeTest.SCORE_NONE;
        return bestScore;
    }

    public void callVisitors(ExpressionOwner owner, XPathVisitor visitor)
    {
        visitor.visitUnionPattern(owner, this);
        if(null != m_patterns)
        {
            int n = m_patterns.length;
            for(int i = 0; i < n; i++)
                m_patterns[i].callVisitors(new UnionPathPartOwner(i), visitor);

        }
    }

    public boolean deepEquals(Expression expr)
    {
        if(!isSameClass(expr))
            return false;
        UnionPattern up = (UnionPattern)expr;
        if(null != m_patterns)
        {
            int n = m_patterns.length;
            if(null == up.m_patterns || up.m_patterns.length != n)
                return false;
            for(int i = 0; i < n; i++)
                if(!m_patterns[i].deepEquals(up.m_patterns[i]))
                    return false;

        } else
        if(up.m_patterns != null)
            return false;
        return true;
    }

    static final long serialVersionUID = 0xa36dcd18b1fb12a4L;
    private StepPattern m_patterns[];

}
