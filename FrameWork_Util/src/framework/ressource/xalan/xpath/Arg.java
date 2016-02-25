// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Arg.java

package framework.ressource.xalan.xpath;

import org.apache.xml.utils.QName;
import framework.ressource.xalan.xpath.objects.XObject;

public class Arg
{

    public final QName getQName()
    {
        return m_qname;
    }

    public final void setQName(QName name)
    {
        m_qname = name;
    }

    public final XObject getVal()
    {
        return m_val;
    }

    public final void setVal(XObject val)
    {
        m_val = val;
    }

    public void detach()
    {
        if(null != m_val)
        {
            m_val.allowDetachToRelease(true);
            m_val.detach();
        }
    }

    public String getExpression()
    {
        return m_expression;
    }

    public void setExpression(String expr)
    {
        m_expression = expr;
    }

    public boolean isFromWithParam()
    {
        return m_isFromWithParam;
    }

    public boolean isVisible()
    {
        return m_isVisible;
    }

    public void setIsVisible(boolean b)
    {
        m_isVisible = b;
    }

    public Arg()
    {
        m_qname = new QName("");
        m_val = null;
        m_expression = null;
        m_isVisible = true;
        m_isFromWithParam = false;
    }

    public Arg(QName qname, String expression, boolean isFromWithParam)
    {
        m_qname = qname;
        m_val = null;
        m_expression = expression;
        m_isFromWithParam = isFromWithParam;
        m_isVisible = !isFromWithParam;
    }

    public Arg(QName qname, XObject val)
    {
        m_qname = qname;
        m_val = val;
        m_isVisible = true;
        m_isFromWithParam = false;
        m_expression = null;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof QName)
            return m_qname.equals(obj);
        else
            return super.equals(obj);
    }

    public Arg(QName qname, XObject val, boolean isFromWithParam)
    {
        m_qname = qname;
        m_val = val;
        m_isFromWithParam = isFromWithParam;
        m_isVisible = !isFromWithParam;
        m_expression = null;
    }

    private QName m_qname;
    private XObject m_val;
    private String m_expression;
    private boolean m_isFromWithParam;
    private boolean m_isVisible;
}
