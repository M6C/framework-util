// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FuncLang.java

package framework.ressource.xalan.xpath.functions;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XBoolean;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            FunctionOneArg

public class FuncLang extends FunctionOneArg
{

    public FuncLang()
    {
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        String lang = super.m_arg0.execute(xctxt).str();
        int parent = xctxt.getCurrentNode();
        boolean isLang = false;
        DTM dtm = xctxt.getDTM(parent);
        for(; -1 != parent; parent = dtm.getParent(parent))
        {
            if(1 != dtm.getNodeType(parent))
                continue;
            int langAttr = dtm.getAttributeNode(parent, "http://www.w3.org/XML/1998/namespace", "lang");
            if(-1 == langAttr)
                continue;
            String langVal = dtm.getNodeValue(langAttr);
            if(langVal.toLowerCase().startsWith(lang.toLowerCase()))
            {
                int valLen = lang.length();
                if(langVal.length() == valLen || langVal.charAt(valLen) == '-')
                    isLang = true;
            }
            break;
        }

        return isLang ? XBoolean.S_TRUE : XBoolean.S_FALSE;
    }

    static final long serialVersionUID = 0x92ccbe5dae765687L;
}
