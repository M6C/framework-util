// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BasicTestIterator.java

package framework.ressource.xalan.xpath.axes;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTMIterator;
import org.apache.xml.utils.PrefixResolver;
import framework.ressource.xalan.xpath.VariableStack;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.compiler.Compiler;
import framework.ressource.xalan.xpath.compiler.OpMap;
import framework.ressource.xalan.xpath.patterns.NodeTest;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            LocPathIterator, ChildTestIterator, PredicatedNodeTest

public abstract class BasicTestIterator extends LocPathIterator
{

    protected BasicTestIterator()
    {
    }

    protected BasicTestIterator(PrefixResolver nscontext)
    {
        super(nscontext);
    }

    protected BasicTestIterator(Compiler compiler, int opPos, int analysis)
        throws TransformerException
    {
        super(compiler, opPos, analysis, false);
        int firstStepPos = OpMap.getFirstChildPos(opPos);
        int whatToShow = compiler.getWhatToShow(firstStepPos);
        if(0 == (whatToShow & 0x1043) || whatToShow == -1)
            initNodeTest(whatToShow);
        else
            initNodeTest(whatToShow, compiler.getStepNS(firstStepPos), compiler.getStepLocalName(firstStepPos));
        initPredicateInfo(compiler, firstStepPos);
    }

    protected BasicTestIterator(Compiler compiler, int opPos, int analysis, boolean shouldLoadWalkers)
        throws TransformerException
    {
        super(compiler, opPos, analysis, shouldLoadWalkers);
    }

    protected abstract int getNextNode();

    public int nextNode()
    {
        if(super.m_foundLast)
        {
            super.m_lastFetched = -1;
            return -1;
        }
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
                next = getNextNode();
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

    public DTMIterator cloneWithReset()
        throws CloneNotSupportedException
    {
        ChildTestIterator clone = (ChildTestIterator)super.cloneWithReset();
        clone.resetProximityPositions();
        return clone;
    }

    static final long serialVersionUID = 0x30a59aca78c5c1efL;
}
