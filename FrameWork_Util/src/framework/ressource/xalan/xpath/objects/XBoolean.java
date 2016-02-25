// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XBoolean.java

package framework.ressource.xalan.xpath.objects;

import javax.xml.transform.TransformerException;
import org.apache.xml.utils.WrappedRuntimeException;

// Referenced classes of package framework.ressource.xalan.xpath.objects:
//            XObject, XBooleanStatic

public class XBoolean extends XObject
{

    public XBoolean(boolean b)
    {
        m_val = b;
    }

    public XBoolean(Boolean b)
    {
        m_val = b.booleanValue();
        setObject(b);
    }

    public int getType()
    {
        return 1;
    }

    public String getTypeString()
    {
        return "#BOOLEAN";
    }

    public double num()
    {
        return m_val ? 1.0D : 0.0D;
    }

    public boolean bool()
    {
        return m_val;
    }

    public String str()
    {
        return m_val ? "true" : "false";
    }

    public Object object()
    {
        if(null == super.m_obj)
            setObject(new Boolean(m_val));
        return super.m_obj;
    }

    public boolean equals(XObject obj2)
    {
        if(obj2.getType() == 4)
            return obj2.equals(this);
        try
        {
            return m_val == obj2.bool();
        }
        catch(TransformerException te)
        {
            throw new WrappedRuntimeException(te);
        }
    }

    static final long serialVersionUID = 0xd6da71178379456fL;
    public static final XBoolean S_TRUE = new XBooleanStatic(true);
    public static final XBoolean S_FALSE = new XBooleanStatic(false);
    private final boolean m_val;

}
