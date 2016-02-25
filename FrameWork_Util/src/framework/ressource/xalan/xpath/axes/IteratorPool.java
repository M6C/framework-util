// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IteratorPool.java

package framework.ressource.xalan.xpath.axes;

import java.io.Serializable;
import java.util.ArrayList;
import org.apache.xml.dtm.DTMIterator;
import org.apache.xml.utils.WrappedRuntimeException;

public final class IteratorPool
    implements Serializable
{

    public IteratorPool(DTMIterator original)
    {
        m_orig = original;
    }

    public synchronized DTMIterator getInstanceOrThrow()
        throws CloneNotSupportedException
    {
        if(m_freeStack.isEmpty())
        {
            return (DTMIterator)m_orig.clone();
        } else
        {
            DTMIterator result = (DTMIterator)m_freeStack.remove(m_freeStack.size() - 1);
            return result;
        }
    }

    public synchronized DTMIterator getInstance()
    {
        if(m_freeStack.isEmpty())
        {
            try
            {
                return (DTMIterator)m_orig.clone();
            }
            catch(Exception ex)
            {
                throw new WrappedRuntimeException(ex);
            }
        } else
        {
            DTMIterator result = (DTMIterator)m_freeStack.remove(m_freeStack.size() - 1);
            return result;
        }
    }

    public synchronized void freeInstance(DTMIterator obj)
    {
        m_freeStack.add(obj);
    }

    static final long serialVersionUID = 0xf99a7508cf8fabeaL;
    private final DTMIterator m_orig;
    private final ArrayList m_freeStack = new ArrayList();
}
