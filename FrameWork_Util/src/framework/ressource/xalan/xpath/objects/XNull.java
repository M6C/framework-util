// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XNull.java

package framework.ressource.xalan.xpath.objects;

import framework.ressource.xalan.xpath.XPathContext;

// Referenced classes of package framework.ressource.xalan.xpath.objects:
//            XNodeSet, XObject

public class XNull extends XNodeSet
{

    public XNull()
    {
    }

    public int getType()
    {
        return -1;
    }

    public String getTypeString()
    {
        return "#CLASS_NULL";
    }

    public double num()
    {
        return 0.0D;
    }

    public boolean bool()
    {
        return false;
    }

    public String str()
    {
        return "";
    }

    public int rtf(XPathContext support)
    {
        return -1;
    }

    public boolean equals(XObject obj2)
    {
        return obj2.getType() == -1;
    }

    static final long serialVersionUID = 0xa10d74e9c8e943a3L;
}
