// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XMLStringFactoryImpl.java

package framework.ressource.xalan.xpath.objects;

import org.apache.xml.utils.*;

// Referenced classes of package framework.ressource.xalan.xpath.objects:
//            XString, XStringForFSB, XStringForChars

public class XMLStringFactoryImpl extends XMLStringFactory
{

    public XMLStringFactoryImpl()
    {
    }

    public static XMLStringFactory getFactory()
    {
        return m_xstringfactory;
    }

    public XMLString newstr(String string)
    {
        return new XString(string);
    }

    public XMLString newstr(FastStringBuffer fsb, int start, int length)
    {
        return new XStringForFSB(fsb, start, length);
    }

    public XMLString newstr(char string[], int start, int length)
    {
        return new XStringForChars(string, start, length);
    }

    public XMLString emptystr()
    {
        return XString.EMPTYSTRING;
    }

    private static XMLStringFactory m_xstringfactory = new XMLStringFactoryImpl();

}
