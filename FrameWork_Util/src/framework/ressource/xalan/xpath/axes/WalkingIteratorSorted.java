// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WalkingIteratorSorted.java

package framework.ressource.xalan.xpath.axes;

import java.util.Vector;
import javax.xml.transform.TransformerException;
import org.apache.xml.utils.PrefixResolver;
import framework.ressource.xalan.xpath.compiler.Compiler;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            WalkingIterator, AxesWalker, WalkerFactory

public class WalkingIteratorSorted extends WalkingIterator
{

    public WalkingIteratorSorted(PrefixResolver nscontext)
    {
        super(nscontext);
        m_inNaturalOrderStatic = false;
    }

    WalkingIteratorSorted(Compiler compiler, int opPos, int analysis, boolean shouldLoadWalkers)
        throws TransformerException
    {
        super(compiler, opPos, analysis, shouldLoadWalkers);
        m_inNaturalOrderStatic = false;
    }

    public boolean isDocOrdered()
    {
        return m_inNaturalOrderStatic;
    }

    boolean canBeWalkedInNaturalDocOrderStatic()
    {
        if(null != super.m_firstWalker)
        {
            AxesWalker walker = super.m_firstWalker;
            int prevAxis = -1;
            boolean prevIsSimpleDownAxis = true;
            for(int i = 0; null != walker; i++)
            {
                int axis = walker.getAxis();
                if(walker.isDocOrdered())
                {
                    boolean isSimpleDownAxis = axis == 3 || axis == 13 || axis == 19;
                    if(isSimpleDownAxis || axis == -1)
                    {
                        walker = walker.getNextWalker();
                    } else
                    {
                        boolean isLastWalker = null == walker.getNextWalker();
                        return isLastWalker && (walker.isDocOrdered() && (axis == 4 || axis == 5 || axis == 17 || axis == 18) || axis == 2);
                    }
                } else
                {
                    return false;
                }
            }

            return true;
        } else
        {
            return false;
        }
    }

    public void fixupVariables(Vector vars, int globalsSize)
    {
        super.fixupVariables(vars, globalsSize);
        int analysis = getAnalysisBits();
        if(WalkerFactory.isNaturalDocOrder(analysis))
            m_inNaturalOrderStatic = true;
        else
            m_inNaturalOrderStatic = false;
    }

    static final long serialVersionUID = 0xc160563cc9c0982bL;
    protected boolean m_inNaturalOrderStatic;
}
