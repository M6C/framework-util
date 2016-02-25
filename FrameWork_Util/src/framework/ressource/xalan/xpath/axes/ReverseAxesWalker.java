// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ReverseAxesWalker.java

package framework.ressource.xalan.xpath.axes;

import org.apache.xml.dtm.DTM;
import org.apache.xml.dtm.DTMAxisIterator;
import framework.ressource.xalan.xpath.XPathContext;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            AxesWalker, PredicatedNodeTest, WalkingIterator, LocPathIterator

public class ReverseAxesWalker extends AxesWalker
{

    ReverseAxesWalker(LocPathIterator locPathIterator, int axis)
    {
        super(locPathIterator, axis);
    }

    public void setRoot(int root)
    {
        super.setRoot(root);
        m_iterator = getDTM(root).getAxisIterator(super.m_axis);
        m_iterator.setStartNode(root);
    }

    public void detach()
    {
        m_iterator = null;
        super.detach();
    }

    protected int getNextNode()
    {
        if(super.m_foundLast)
            return -1;
        int next = m_iterator.next();
        if(super.m_isFresh)
            super.m_isFresh = false;
        if(-1 == next)
            super.m_foundLast = true;
        return next;
    }

    public boolean isReverseAxes()
    {
        return true;
    }

    protected int getProximityPosition(int predicateIndex)
    {
        if(predicateIndex < 0)
            return -1;
        int count = super.m_proximityPositions[predicateIndex];
        if(count <= 0)
        {
            AxesWalker savedWalker = wi().getLastUsedWalker();
            try
            {
                ReverseAxesWalker clone = (ReverseAxesWalker)clone();
                clone.setRoot(getRoot());
                clone.setPredicateCount(predicateIndex);
                clone.setPrevWalker(null);
                clone.setNextWalker(null);
                wi().setLastUsedWalker(clone);
                int next;
                for(count++; -1 != (next = clone.nextNode()); count++);
                super.m_proximityPositions[predicateIndex] = count;
            }
            catch(CloneNotSupportedException cnse) { }
            finally
            {
                wi().setLastUsedWalker(savedWalker);
            }
        }
        return count;
    }

    protected void countProximityPosition(int i)
    {
        if(i < super.m_proximityPositions.length)
            super.m_proximityPositions[i]--;
    }

    public int getLastPos(XPathContext xctxt)
    {
        int count = 0;
        AxesWalker savedWalker = wi().getLastUsedWalker();
        try
        {
            ReverseAxesWalker clone = (ReverseAxesWalker)clone();
            clone.setRoot(getRoot());
            clone.setPredicateCount(super.m_predicateIndex);
            clone.setPrevWalker(null);
            clone.setNextWalker(null);
            wi().setLastUsedWalker(clone);
            int next;
            while(-1 != (next = clone.nextNode())) 
                count++;
        }
        catch(CloneNotSupportedException cnse) { }
        finally
        {
            wi().setLastUsedWalker(savedWalker);
        }
        return count;
    }

    public boolean isDocOrdered()
    {
        return false;
    }

    static final long serialVersionUID = 0x27829a5f21e481adL;
    protected DTMAxisIterator m_iterator;
}
