// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XNodeSet.java

package framework.ressource.xalan.xpath.objects;

import org.apache.xml.utils.XMLString;

// Referenced classes of package framework.ressource.xalan.xpath.objects:
//            Comparator

class LessThanOrEqualComparator extends Comparator
{

    LessThanOrEqualComparator()
    {
    }

    boolean compareStrings(XMLString s1, XMLString s2)
    {
        return s1.toDouble() <= s2.toDouble();
    }

    boolean compareNumbers(double n1, double n2)
    {
        return n1 <= n2;
    }
}
