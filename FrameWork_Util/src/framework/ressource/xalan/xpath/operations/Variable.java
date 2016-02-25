// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Variable.java

package framework.ressource.xalan.xpath.operations;

import java.util.Vector;

import javax.xml.transform.TransformerException;

import org.apache.xalan.templates.ElemTemplateElement;
import org.apache.xalan.templates.ElemVariable;
import org.apache.xalan.templates.Stylesheet;
import org.apache.xml.utils.QName;
import org.apache.xml.utils.WrappedRuntimeException;

import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.ExpressionOwner;
import framework.ressource.xalan.xpath.XPath;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.XPathVisitor;
import framework.ressource.xalan.xpath.axes.PathComponent;
import framework.ressource.xalan.xpath.objects.XNodeSet;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.res.XPATHMessages;

public class Variable extends Expression
    implements PathComponent
{

    public Variable()
    {
        m_fixUpWasCalled = false;
        m_isGlobal = false;
    }

    public void setIndex(int index)
    {
        m_index = index;
    }

    public int getIndex()
    {
        return m_index;
    }

    public void setIsGlobal(boolean isGlobal)
    {
        m_isGlobal = isGlobal;
    }

    public boolean getGlobal()
    {
        return m_isGlobal;
    }

    public void fixupVariables(Vector vars, int globalsSize)
    {
        m_fixUpWasCalled = true;
        int sz = vars.size();
        for(int i = vars.size() - 1; i >= 0; i--)
        {
            QName qn = (QName)vars.elementAt(i);
            if(qn.equals(m_qname))
            {
                if(i < globalsSize)
                {
                    m_isGlobal = true;
                    m_index = i;
                } else
                {
                    m_index = i - globalsSize;
                }
                return;
            }
        }

        java.lang.String msg = XPATHMessages.createXPATHMessage("ER_COULD_NOT_FIND_VAR", new Object[] {
            m_qname.toString()
        });
        TransformerException te = new TransformerException(msg, this);
        throw new WrappedRuntimeException(te);
    }

    public void setQName(QName qname)
    {
        m_qname = qname;
    }

    public QName getQName()
    {
        return m_qname;
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        return execute(xctxt, false);
    }

    public XObject execute(XPathContext xctxt, boolean destructiveOK)
        throws TransformerException
    {
        org.apache.xml.utils.PrefixResolver xprefixResolver = xctxt.getNamespaceContext();
        XObject result;
        if(m_fixUpWasCalled)
        {
            if(m_isGlobal)
                result = xctxt.getVarStack().getGlobalVariable(xctxt, m_index, destructiveOK);
            else
                result = xctxt.getVarStack().getLocalVariable(xctxt, m_index, destructiveOK);
        } else
        {
            result = xctxt.getVarStack().getVariableOrParam(xctxt, m_qname);
        }
        if(null == result)
        {
            warn(xctxt, "WG_ILLEGAL_VARIABLE_REFERENCE", new Object[] {
                m_qname.getLocalPart()
            });
            result = new XNodeSet(xctxt.getDTMManager());
        }
        return result;
    }

    public ElemVariable getElemVariable()
    {
        ElemVariable vvar = null;
        framework.ressource.xalan.xpath.ExpressionNode owner = getExpressionOwner();
        if(null != owner && (owner instanceof ElemTemplateElement))
        {
            ElemTemplateElement prev = (ElemTemplateElement)owner;
            if(!(prev instanceof Stylesheet))
            {
                ElemTemplateElement savedprev;
                for(; prev != null && !(prev.getParentNode() instanceof Stylesheet); prev = savedprev.getParentElem())
                {
                    savedprev = prev;
                    while(null != (prev = prev.getPreviousSiblingElem())) 
                        if(prev instanceof ElemVariable)
                        {
                            vvar = (ElemVariable)prev;
                            if(vvar.getName().equals(m_qname))
                                return vvar;
                            vvar = null;
                        }
                }

            }
            if(prev != null)
                vvar = prev.getStylesheetRoot().getVariableOrParamComposed(m_qname);
        }
        return vvar;
    }

    public boolean isStableNumber()
    {
        return true;
    }

    public int getAnalysisBits()
    {
   /*DROCA
        ElemVariable vvar = getElemVariable();
        if(null != vvar)
        {
            XPath xpath = vvar.getSelect();
            if(null != xpath)
            {
                Expression expr = xpath.getExpression();
                if(null != expr && (expr instanceof PathComponent))
                    return ((PathComponent)expr).getAnalysisBits();
            }
        }
*/
        return 0x4000000;
    }

    public void callVisitors(ExpressionOwner owner, XPathVisitor visitor)
    {
        visitor.visitVariableRef(owner, this);
    }

    public boolean deepEquals(Expression expr)
    {
        if(!isSameClass(expr))
            return false;
        if(!m_qname.equals(((Variable)expr).m_qname))
            return false;
        return getElemVariable() == ((Variable)expr).getElemVariable();
    }

    public boolean isPsuedoVarRef()
    {
        java.lang.String ns = m_qname.getNamespaceURI();
        return null != ns && ns.equals("http://xml.apache.org/xalan/psuedovar") && m_qname.getLocalName().startsWith("#");
    }

    static final long serialVersionUID = 0xc3d712dd12be0767L;
    private boolean m_fixUpWasCalled;
    protected QName m_qname;
    protected int m_index;
    protected boolean m_isGlobal;
    static final java.lang.String PSUEDOVARNAMESPACE = "http://xml.apache.org/xalan/psuedovar";
}
