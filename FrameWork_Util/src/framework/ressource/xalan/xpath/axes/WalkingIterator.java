// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WalkingIterator.java

package framework.ressource.xalan.xpath.axes;

import java.util.Vector;
import javax.xml.transform.TransformerException;
import org.apache.xml.utils.PrefixResolver;
import framework.ressource.xalan.xpath.*;
import framework.ressource.xalan.xpath.compiler.Compiler;
import framework.ressource.xalan.xpath.compiler.OpMap;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            LocPathIterator, AxesWalker, WalkerFactory, PredicatedNodeTest

public class WalkingIterator extends LocPathIterator
    implements ExpressionOwner
{

    WalkingIterator(Compiler compiler, int opPos, int analysis, boolean shouldLoadWalkers)
        throws TransformerException
    {
        super(compiler, opPos, analysis, shouldLoadWalkers);
        int firstStepPos = OpMap.getFirstChildPos(opPos);
        if(shouldLoadWalkers)
        {
            m_firstWalker = WalkerFactory.loadWalkers(this, compiler, firstStepPos, 0);
            m_lastUsedWalker = m_firstWalker;
        }
    }

    public WalkingIterator(PrefixResolver nscontext)
    {
        super(nscontext);
    }

    public int getAnalysisBits()
    {
        int bits = 0;
        if(null != m_firstWalker)
        {
            for(AxesWalker walker = m_firstWalker; null != walker; walker = walker.getNextWalker())
            {
                int bit = walker.getAnalysisBits();
                bits |= bit;
            }

        }
        return bits;
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        WalkingIterator clone = (WalkingIterator)super.clone();
        if(null != m_firstWalker)
            clone.m_firstWalker = m_firstWalker.cloneDeep(clone, null);
        return clone;
    }

    public void reset()
    {
        super.reset();
        if(null != m_firstWalker)
        {
            m_lastUsedWalker = m_firstWalker;
            m_firstWalker.setRoot(super.m_context);
        }
    }

    public void setRoot(int context, Object environment)
    {
        super.setRoot(context, environment);
        if(null != m_firstWalker)
        {
            m_firstWalker.setRoot(context);
            m_lastUsedWalker = m_firstWalker;
        }
    }

    public int nextNode()
    {
        if(super.m_foundLast)
            return -1;
        if(-1 == super.m_stackFrame)
        {
            return returnNextNode(m_firstWalker.nextNode());
        } else
        {
            VariableStack vars = super.m_execContext.getVarStack();
            int savedStart = vars.getStackFrame();
            vars.setStackFrame(super.m_stackFrame);
            int n = returnNextNode(m_firstWalker.nextNode());
            vars.setStackFrame(savedStart);
            return n;
        }
    }

    public final AxesWalker getFirstWalker()
    {
        return m_firstWalker;
    }

    public final void setFirstWalker(AxesWalker walker)
    {
        m_firstWalker = walker;
    }

    public final void setLastUsedWalker(AxesWalker walker)
    {
        m_lastUsedWalker = walker;
    }

    public final AxesWalker getLastUsedWalker()
    {
        return m_lastUsedWalker;
    }

    public void detach()
    {
        if(super.m_allowDetach)
        {
            for(AxesWalker walker = m_firstWalker; null != walker; walker = walker.getNextWalker())
                walker.detach();

            m_lastUsedWalker = null;
            super.detach();
        }
    }

    public void fixupVariables(Vector vars, int globalsSize)
    {
        super.m_predicateIndex = -1;
        for(AxesWalker walker = m_firstWalker; null != walker; walker = walker.getNextWalker())
            walker.fixupVariables(vars, globalsSize);

    }

    public void callVisitors(ExpressionOwner owner, XPathVisitor visitor)
    {
        if(visitor.visitLocationPath(owner, this) && null != m_firstWalker)
            m_firstWalker.callVisitors(this, visitor);
    }

    public Expression getExpression()
    {
        return m_firstWalker;
    }

    public void setExpression(Expression exp)
    {
        exp.exprSetParent(this);
        m_firstWalker = (AxesWalker)exp;
    }

    public boolean deepEquals(Expression expr)
    {
        if(!super.deepEquals(expr))
            return false;
        AxesWalker walker1 = m_firstWalker;
        AxesWalker walker2;
        for(walker2 = ((WalkingIterator)expr).m_firstWalker; null != walker1 && null != walker2; walker2 = walker2.getNextWalker())
        {
            if(!walker1.deepEquals(walker2))
                return false;
            walker1 = walker1.getNextWalker();
        }

        return null == walker1 && null == walker2;
    }

    static final long serialVersionUID = 0x7e6e0639dd78a4f2L;
    protected AxesWalker m_lastUsedWalker;
    protected AxesWalker m_firstWalker;
}
