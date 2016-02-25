// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DTMXRTreeFrag.java

package framework.ressource.xalan.xpath.objects;

import org.apache.xml.dtm.DTM;
import framework.ressource.xalan.xpath.XPathContext;

public final class DTMXRTreeFrag
{

    public DTMXRTreeFrag(int dtmIdentity, XPathContext xctxt)
    {
        m_dtmIdentity = -1;
        m_xctxt = xctxt;
        m_dtmIdentity = dtmIdentity;
        m_dtm = xctxt.getDTM(dtmIdentity);
    }

    public final void destruct()
    {
        m_dtm = null;
        m_xctxt = null;
    }

    final DTM getDTM()
    {
        return m_dtm;
    }

    public final int getDTMIdentity()
    {
        return m_dtmIdentity;
    }

    final XPathContext getXPathContext()
    {
        return m_xctxt;
    }

    public final int hashCode()
    {
        return m_dtmIdentity;
    }

    public final boolean equals(Object obj)
    {
        if(obj instanceof DTMXRTreeFrag)
            return m_dtmIdentity == ((DTMXRTreeFrag)obj).getDTMIdentity();
        else
            return false;
    }

    private DTM m_dtm;
    private int m_dtmIdentity;
    private XPathContext m_xctxt;
}
