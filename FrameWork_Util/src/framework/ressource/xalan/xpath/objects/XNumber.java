// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XNumber.java

package framework.ressource.xalan.xpath.objects;

import javax.xml.transform.TransformerException;
import org.apache.xml.utils.WrappedRuntimeException;
import framework.ressource.xalan.xpath.*;

// Referenced classes of package framework.ressource.xalan.xpath.objects:
//            XObject

public class XNumber extends XObject
{

    public XNumber(double d)
    {
        m_val = d;
    }

    public XNumber(Number num)
    {
        m_val = num.doubleValue();
        setObject(num);
    }

    public int getType()
    {
        return 2;
    }

    public String getTypeString()
    {
        return "#NUMBER";
    }

    public double num()
    {
        return m_val;
    }

    public double num(XPathContext xctxt)
        throws TransformerException
    {
        return m_val;
    }

    public boolean bool()
    {
        return !Double.isNaN(m_val) && m_val != 0.0D;
    }

    public String str()
    {
        if(Double.isNaN(m_val))
            return "NaN";
        if(Double.isInfinite(m_val))
            if(m_val > 0.0D)
                return "Infinity";
            else
                return "-Infinity";
        double num = m_val;
        String s = Double.toString(num);
        int len = s.length();
        if(s.charAt(len - 2) == '.' && s.charAt(len - 1) == '0')
        {
            s = s.substring(0, len - 2);
            if(s.equals("-0"))
                return "0";
            else
                return s;
        }
        int e = s.indexOf('E');
        if(e < 0)
            if(s.charAt(len - 1) == '0')
                return s.substring(0, len - 1);
            else
                return s;
        int exp = Integer.parseInt(s.substring(e + 1));
        String sign;
        if(s.charAt(0) == '-')
        {
            sign = "-";
            s = s.substring(1);
            e--;
        } else
        {
            sign = "";
        }
        int nDigits = e - 2;
        if(exp >= nDigits)
            return sign + s.substring(0, 1) + s.substring(2, e) + zeros(exp - nDigits);
        for(; s.charAt(e - 1) == '0'; e--);
        if(exp > 0)
            return sign + s.substring(0, 1) + s.substring(2, 2 + exp) + "." + s.substring(2 + exp, e);
        else
            return sign + "0." + zeros(-1 - exp) + s.substring(0, 1) + s.substring(2, e);
    }

    private static String zeros(int n)
    {
        if(n < 1)
            return "";
        char buf[] = new char[n];
        for(int i = 0; i < n; i++)
            buf[i] = '0';

        return new String(buf);
    }

    public Object object()
    {
        if(null == super.m_obj)
            setObject(new Double(m_val));
        return super.m_obj;
    }

    public boolean equals(XObject obj2)
    {
        int t = obj2.getType();
        try
        {
            if(t == 4)
                return obj2.equals(this);
            if(t == 1)
                return obj2.bool() == bool();
            else
                return m_val == obj2.num();
        }
        catch(TransformerException te)
        {
            throw new WrappedRuntimeException(te);
        }
    }

    public boolean isStableNumber()
    {
        return true;
    }

    public void callVisitors(ExpressionOwner owner, XPathVisitor visitor)
    {
        visitor.visitNumberLiteral(owner, this);
    }

    static final long serialVersionUID = 0xda3f31f7c8700e5fL;
    double m_val;
}
