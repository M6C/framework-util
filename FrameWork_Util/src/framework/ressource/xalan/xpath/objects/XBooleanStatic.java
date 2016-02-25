// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XBooleanStatic.java

package framework.ressource.xalan.xpath.objects;

import javax.xml.transform.TransformerException;
import org.apache.xml.utils.WrappedRuntimeException;

// Referenced classes of package framework.ressource.xalan.xpath.objects:
//            XBoolean, XObject

public class XBooleanStatic extends XBoolean
{

    public XBooleanStatic(boolean b)
    {
        super(b);
        m_val = b;
    }

    public boolean equals(XObject obj2)
    {
        try
        {
            return m_val == obj2.bool();
        }
        catch(TransformerException te)
        {
            throw new WrappedRuntimeException(te);
        }
    }

    static final long serialVersionUID = 0x901664c743228bcfL;
    private final boolean m_val;
}
