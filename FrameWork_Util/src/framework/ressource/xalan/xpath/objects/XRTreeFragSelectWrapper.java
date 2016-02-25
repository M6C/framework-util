// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XRTreeFragSelectWrapper.java

package framework.ressource.xalan.xpath.objects;

import java.util.Vector;
import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTMIterator;
import org.apache.xml.utils.XMLString;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.res.XPATHMessages;

// Referenced classes of package framework.ressource.xalan.xpath.objects:
//            XRTreeFrag, XString, XObject

public class XRTreeFragSelectWrapper extends XRTreeFrag
    implements Cloneable
{

    public XRTreeFragSelectWrapper(Expression expr)
    {
        super(expr);
    }

    public void fixupVariables(Vector vars, int globalsSize)
    {
        ((Expression)super.m_obj).fixupVariables(vars, globalsSize);
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        XObject m_selected = ((Expression)super.m_obj).execute(xctxt);
        m_selected.allowDetachToRelease(super.m_allowRelease);
        if(m_selected.getType() == 3)
            return m_selected;
        else
            return new XString(m_selected.str());
    }

    public void detach()
    {
        throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_DETACH_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", null));
    }

    public double num()
        throws TransformerException
    {
        throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NUM_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", null));
    }

    public XMLString xstr()
    {
        throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_XSTR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", null));
    }

    public String str()
    {
        throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_STR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", null));
    }

    public int getType()
    {
        return 3;
    }

    public int rtf()
    {
        throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", null));
    }

    public DTMIterator asNodeIterator()
    {
        throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", null));
    }

    static final long serialVersionUID = 0xa56e5bc5a4471cbdL;
}
