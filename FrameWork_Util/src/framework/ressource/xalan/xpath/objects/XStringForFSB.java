// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XStringForFSB.java

package framework.ressource.xalan.xpath.objects;

import org.apache.xml.utils.*;
import framework.ressource.xalan.xpath.res.XPATHMessages;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

// Referenced classes of package framework.ressource.xalan.xpath.objects:
//            XString, XNumber, XNodeSet, XObject, 
//            XMLStringFactoryImpl

public class XStringForFSB extends XString
{

    public XStringForFSB(FastStringBuffer val, int start, int length)
    {
        super(val);
        m_strCache = null;
        m_hash = 0;
        m_start = start;
        m_length = length;
        if(null == val)
            throw new IllegalArgumentException(XPATHMessages.createXPATHMessage("ER_FASTSTRINGBUFFER_CANNOT_BE_NULL", null));
        else
            return;
    }

    private XStringForFSB(String val)
    {
        super(val);
        m_strCache = null;
        m_hash = 0;
        throw new IllegalArgumentException(XPATHMessages.createXPATHMessage("ER_FSB_CANNOT_TAKE_STRING", null));
    }

    public FastStringBuffer fsb()
    {
        return (FastStringBuffer)super.m_obj;
    }

    public void appendToFsb(FastStringBuffer fsb)
    {
        fsb.append(str());
    }

    public boolean hasString()
    {
        return null != m_strCache;
    }

    public Object object()
    {
        return str();
    }

    public String str()
    {
        if(null == m_strCache)
            m_strCache = fsb().getString(m_start, m_length);
        return m_strCache;
    }

    public void dispatchCharactersEvents(ContentHandler ch)
        throws SAXException
    {
        fsb().sendSAXcharacters(ch, m_start, m_length);
    }

    public void dispatchAsComment(LexicalHandler lh)
        throws SAXException
    {
        fsb().sendSAXComment(lh, m_start, m_length);
    }

    public int length()
    {
        return m_length;
    }

    public char charAt(int index)
    {
        return fsb().charAt(m_start + index);
    }

    public void getChars(int srcBegin, int srcEnd, char dst[], int dstBegin)
    {
        int n = srcEnd - srcBegin;
        if(n > m_length)
            n = m_length;
        if(n > dst.length - dstBegin)
            n = dst.length - dstBegin;
        int end = srcBegin + m_start + n;
        int d = dstBegin;
        FastStringBuffer fsb = fsb();
        for(int i = srcBegin + m_start; i < end; i++)
            dst[d++] = fsb.charAt(i);

    }

    public boolean equals(XMLString obj2)
    {
        if(this == obj2)
            return true;
        int n = m_length;
        if(n == obj2.length())
        {
            FastStringBuffer fsb = fsb();
            int i = m_start;
            for(int j = 0; n-- != 0; j++)
            {
                if(fsb.charAt(i) != obj2.charAt(j))
                    return false;
                i++;
            }

            return true;
        } else
        {
            return false;
        }
    }

    public boolean equals(XObject obj2)
    {
        if(this == obj2)
            return true;
        if(obj2.getType() == 2)
            return obj2.equals(this);
        String str = obj2.str();
        int n = m_length;
        if(n == str.length())
        {
            FastStringBuffer fsb = fsb();
            int i = m_start;
            for(int j = 0; n-- != 0; j++)
            {
                if(fsb.charAt(i) != str.charAt(j))
                    return false;
                i++;
            }

            return true;
        } else
        {
            return false;
        }
    }

    public boolean equals(String anotherString)
    {
        int n = m_length;
        if(n == anotherString.length())
        {
            FastStringBuffer fsb = fsb();
            int i = m_start;
            for(int j = 0; n-- != 0; j++)
            {
                if(fsb.charAt(i) != anotherString.charAt(j))
                    return false;
                i++;
            }

            return true;
        } else
        {
            return false;
        }
    }

    public boolean equals(Object obj2)
    {
        if(null == obj2)
            return false;
        if(obj2 instanceof XNumber)
            return obj2.equals(this);
        if(obj2 instanceof XNodeSet)
            return obj2.equals(this);
        if(obj2 instanceof XStringForFSB)
            return equals((XMLString)obj2);
        else
            return equals(obj2.toString());
    }

    public boolean equalsIgnoreCase(String anotherString)
    {
        return m_length != anotherString.length() ? false : str().equalsIgnoreCase(anotherString);
    }

    public int compareTo(XMLString xstr)
    {
        int len1 = m_length;
        int len2 = xstr.length();
        int n = Math.min(len1, len2);
        FastStringBuffer fsb = fsb();
        int i = m_start;
        for(int j = 0; n-- != 0; j++)
        {
            char c1 = fsb.charAt(i);
            char c2 = xstr.charAt(j);
            if(c1 != c2)
                return c1 - c2;
            i++;
        }

        return len1 - len2;
    }

    public int compareToIgnoreCase(XMLString xstr)
    {
        int len1 = m_length;
        int len2 = xstr.length();
        int n = Math.min(len1, len2);
        FastStringBuffer fsb = fsb();
        int i = m_start;
        for(int j = 0; n-- != 0; j++)
        {
            char c1 = Character.toLowerCase(fsb.charAt(i));
            char c2 = Character.toLowerCase(xstr.charAt(j));
            if(c1 != c2)
                return c1 - c2;
            i++;
        }

        return len1 - len2;
    }

    public int hashCode()
    {
        return super.hashCode();
    }

    public boolean startsWith(XMLString prefix, int toffset)
    {
        FastStringBuffer fsb = fsb();
        int to = m_start + toffset;
        int tlim = m_start + m_length;
        int po = 0;
        int pc = prefix.length();
        if(toffset < 0 || toffset > m_length - pc)
            return false;
        while(--pc >= 0) 
        {
            if(fsb.charAt(to) != prefix.charAt(po))
                return false;
            to++;
            po++;
        }
        return true;
    }

    public boolean startsWith(XMLString prefix)
    {
        return startsWith(prefix, 0);
    }

    public int indexOf(int ch)
    {
        return indexOf(ch, 0);
    }

    public int indexOf(int ch, int fromIndex)
    {
        int max = m_start + m_length;
        FastStringBuffer fsb = fsb();
        if(fromIndex < 0)
            fromIndex = 0;
        else
        if(fromIndex >= m_length)
            return -1;
        for(int i = m_start + fromIndex; i < max; i++)
            if(fsb.charAt(i) == ch)
                return i - m_start;

        return -1;
    }

    public XMLString substring(int beginIndex)
    {
        int len = m_length - beginIndex;
        if(len <= 0)
        {
            return XString.EMPTYSTRING;
        } else
        {
            int start = m_start + beginIndex;
            return new XStringForFSB(fsb(), start, len);
        }
    }

    public XMLString substring(int beginIndex, int endIndex)
    {
        int len = endIndex - beginIndex;
        if(len > m_length)
            len = m_length;
        if(len <= 0)
        {
            return XString.EMPTYSTRING;
        } else
        {
            int start = m_start + beginIndex;
            return new XStringForFSB(fsb(), start, len);
        }
    }

    public XMLString concat(String str)
    {
        return new XString(str().concat(str));
    }

    public XMLString trim()
    {
        return fixWhiteSpace(true, true, false);
    }

    private static boolean isSpace(char ch)
    {
        return XMLCharacterRecognizer.isWhiteSpace(ch);
    }

    public XMLString fixWhiteSpace(boolean trimHead, boolean trimTail, boolean doublePunctuationSpaces)
    {
        int end = m_length + m_start;
        char buf[] = new char[m_length];
        FastStringBuffer fsb = fsb();
        boolean edit = false;
        int d = 0;
        boolean pres = false;
        for(int s = m_start; s < end; s++)
        {
            char c = fsb.charAt(s);
            if(isSpace(c))
            {
                if(!pres)
                {
                    if(' ' != c)
                        edit = true;
                    buf[d++] = ' ';
                    if(doublePunctuationSpaces && d != 0)
                    {
                        char prevChar = buf[d - 1];
                        if(prevChar != '.' && prevChar != '!' && prevChar != '?')
                            pres = true;
                    } else
                    {
                        pres = true;
                    }
                } else
                {
                    edit = true;
                    pres = true;
                }
            } else
            {
                buf[d++] = c;
                pres = false;
            }
        }

        if(trimTail && 1 <= d && ' ' == buf[d - 1])
        {
            edit = true;
            d--;
        }
        int start = 0;
        if(trimHead && 0 < d && ' ' == buf[0])
        {
            edit = true;
            start++;
        }
        XMLStringFactory xsf = XMLStringFactoryImpl.getFactory();
        return ((XMLString) (edit ? xsf.newstr(buf, start, d - start) : this));
    }

    public double toDouble()
    {
        if(m_length == 0)
            return (0.0D / 0.0D);
        String valueString = fsb().getString(m_start, m_length);
        int i;
        for(i = 0; i < m_length; i++)
            if(!XMLCharacterRecognizer.isWhiteSpace(valueString.charAt(i)))
                break;

        if(i == m_length)
            return (0.0D / 0.0D);
        if(valueString.charAt(i) == '-')
            i++;
        for(; i < m_length; i++)
        {
            char c = valueString.charAt(i);
            if(c != '.' && (c < '0' || c > '9'))
                break;
        }

        for(; i < m_length; i++)
            if(!XMLCharacterRecognizer.isWhiteSpace(valueString.charAt(i)))
                break;

        if(i != m_length)
            return (0.0D / 0.0D);
        try
        {
            return (new Double(valueString)).doubleValue();
        }
        catch(NumberFormatException nfe)
        {
            return (0.0D / 0.0D);
        }
    }

    static final long serialVersionUID = 0xeab98cfb72e4ab8cL;
    int m_start;
    int m_length;
    protected String m_strCache;
    protected int m_hash;
}
