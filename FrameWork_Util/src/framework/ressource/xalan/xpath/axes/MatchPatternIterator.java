// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MatchPatternIterator.java

package framework.ressource.xalan.xpath.axes;

import javax.xml.transform.TransformerException;

import org.apache.xml.dtm.DTMAxisTraverser;

import framework.ressource.xalan.xpath.VariableStack;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.compiler.Compiler;
import framework.ressource.xalan.xpath.compiler.OpMap;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.patterns.NodeTest;
import framework.ressource.xalan.xpath.patterns.StepPattern;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            LocPathIterator, WalkerFactory, PredicatedNodeTest

public class MatchPatternIterator extends LocPathIterator
{

    MatchPatternIterator(Compiler compiler, int opPos, int analysis)
        throws TransformerException
    {
        super(compiler, opPos, analysis, false);
        m_superAxis = -1;
        int firstStepPos = OpMap.getFirstChildPos(opPos);
        m_pattern = WalkerFactory.loadSteps(this, compiler, firstStepPos, 0);
        boolean fromRoot = false;
        boolean walkBack = false;
        boolean walkDescendants = false;
        boolean walkAttributes = false;
        if(0 != (analysis & 0x28000000))
            fromRoot = true;
        if(0 != (analysis & 0x5d86000))
            walkBack = true;
        if(0 != (analysis & 0x70000))
            walkDescendants = true;
        if(0 != (analysis & 0x208000))
            walkAttributes = true;
        if(fromRoot || walkBack)
        {
            if(walkAttributes)
                m_superAxis = 16;
            else
                m_superAxis = 17;
        } else
        if(walkDescendants)
        {
            if(walkAttributes)
                m_superAxis = 14;
            else
                m_superAxis = 5;
        } else
        {
            m_superAxis = 16;
        }
    }

    public void setRoot(int context, Object environment)
    {
        super.setRoot(context, environment);
        m_traverser = super.m_cdtm.getAxisTraverser(m_superAxis);
    }

    public void detach()
    {
        if(super.m_allowDetach)
        {
            m_traverser = null;
            super.detach();
        }
    }

    protected int getNextNode()
    {
        super.m_lastFetched = -1 != super.m_lastFetched ? m_traverser.next(super.m_context, super.m_lastFetched) : m_traverser.first(super.m_context);
        return super.m_lastFetched;
    }

    public int nextNode()
    {
        if(super.m_foundLast)
            return -1;
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
                next = getNextNode();
            while(-1 != next && 1 != acceptNode(next, super.m_execContext) && next != -1);
            if(-1 != next)
            {
                incrementCurrentPos();
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

    public short acceptNode(int n, XPathContext xctxt)
    {
        try
        {
            xctxt.pushCurrentNode(n);
            xctxt.pushIteratorRoot(super.m_context);
            XObject score = m_pattern.execute(xctxt);
            short word0 = (short) (score != NodeTest.SCORE_NONE ? 1 : 3);
            return word0;
        }
        catch(TransformerException se)
        {
            throw new RuntimeException(se.getMessage());
        }
        finally
        {
            xctxt.popCurrentNode();
            xctxt.popIteratorRoot();
        }
    }

    static final long serialVersionUID = 0xb7d1ca349828b8e6L;
    protected StepPattern m_pattern;
    protected int m_superAxis;
    protected DTMAxisTraverser m_traverser;
    private static final boolean DEBUG = false;
}
