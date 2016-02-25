// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XNodeSet.java

package framework.ressource.xalan.xpath.objects;

import org.apache.xml.utils.XMLString;

abstract class Comparator
{

    Comparator()
    {
    }

    abstract boolean compareStrings(XMLString xmlstring, XMLString xmlstring1);

    abstract boolean compareNumbers(double d, double d1);
}
