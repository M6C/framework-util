// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OpMapVector.java

package framework.ressource.xalan.xpath.compiler;


public class OpMapVector
{

    public OpMapVector(int blocksize, int increaseSize, int lengthPos)
    {
        m_lengthPos = 0;
        m_blocksize = increaseSize;
        m_mapSize = blocksize;
        m_lengthPos = lengthPos;
        m_map = new int[blocksize];
    }

    public final int elementAt(int i)
    {
        return m_map[i];
    }

    public final void setElementAt(int value, int index)
    {
        if(index >= m_mapSize)
        {
            int oldSize = m_mapSize;
            m_mapSize += m_blocksize;
            int newMap[] = new int[m_mapSize];
            System.arraycopy(m_map, 0, newMap, 0, oldSize);
            m_map = newMap;
        }
        m_map[index] = value;
    }

    public final void setToSize(int size)
    {
        int newMap[] = new int[size];
        System.arraycopy(m_map, 0, newMap, 0, m_map[m_lengthPos]);
        m_mapSize = size;
        m_map = newMap;
    }

    protected int m_blocksize;
    protected int m_map[];
    protected int m_lengthPos;
    protected int m_mapSize;
}
