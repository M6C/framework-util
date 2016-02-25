// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XStringForChars.java

package framework.ressource.xalan.xpath.objects;

import org.apache.xml.utils.FastStringBuffer;
import framework.ressource.xalan.xpath.res.XPATHMessages;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

// Referenced classes of package framework.ressource.xalan.xpath.objects:
//            XString, XObject

public class XStringForChars extends XString
{

    public XStringForChars(char val[], int start, int length)
    {
        super(val);
        m_strCache = null;
        m_start = start;
        m_length = length;
        if(null == val)
            throw new IllegalArgumentException(XPATHMessages.createXPATHMessage("ER_FASTSTRINGBUFFER_CANNOT_BE_NULL", null));
        else
            return;
    }

    private XStringForChars(String val)
    {
        super(val);
        m_strCache = null;
        throw new IllegalArgumentException(XPATHMessages.createXPATHMessage("ER_XSTRINGFORCHARS_CANNOT_TAKE_STRING", null));
    }

    public FastStringBuffer fsb()
    {
        throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_FSB_NOT_SUPPORTED_XSTRINGFORCHARS", null));
    }

    public void appendToFsb(FastStringBuffer fsb)
    {
        fsb.append((char[])super.m_obj, m_start, m_length);
    }

    public boolean hasString()
    {
        return null != m_strCache;
    }

    public String str()
    {
        if(null == m_strCache)
            m_strCache = new String((char[])super.m_obj, m_start, m_length);
        return m_strCache;
    }

    public Object object()
    {
        return str();
    }

    public void dispatchCharactersEvents(ContentHandler ch)
        throws SAXException
    {
        ch.characters((char[])super.m_obj, m_start, m_length);
    }

    public void dispatchAsComment(LexicalHandler lh)
        throws SAXException
    {
        lh.comment((char[])super.m_obj, m_start, m_length);
    }

    public int length()
    {
        return m_length;
    }

    public char charAt(int index)
    {
        return ((char[])super.m_obj)[index + m_start];
    }

    public void getChars(int srcBegin, int srcEnd, char dst[], int dstBegin)
    {
        System.arraycopy((char[])super.m_obj, m_start + srcBegin, dst, dstBegin, srcEnd);
    }

    static final long serialVersionUID = 0xe0faccfadc9d30ddL;
    int m_start;
    int m_length;
    protected String m_strCache;
}
