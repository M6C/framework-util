// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VariableStack.java

package framework.ressource.xalan.xpath;

import javax.xml.transform.TransformerException;
import org.apache.xalan.templates.*;
import org.apache.xml.utils.QName;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.res.XPATHMessages;

// Referenced classes of package framework.ressource.xalan.xpath:
//            XPathContext

public class VariableStack
    implements Cloneable
{

    public VariableStack()
    {
        reset();
    }

    public VariableStack(int initStackSize)
    {
        reset(initStackSize, initStackSize * 2);
    }

    public synchronized Object clone()
        throws CloneNotSupportedException
    {
        VariableStack vs = (VariableStack)super.clone();
        vs._stackFrames = (XObject[])_stackFrames.clone();
        vs._links = (int[])_links.clone();
        return vs;
    }

    public XObject elementAt(int i)
    {
        return _stackFrames[i];
    }

    public int size()
    {
        return _frameTop;
    }

    public void reset()
    {
        int linksSize = _links != null ? _links.length : 4096;
        int varArraySize = _stackFrames != null ? _stackFrames.length : 8192;
        reset(linksSize, varArraySize);
    }

    protected void reset(int linksSize, int varArraySize)
    {
        _frameTop = 0;
        _linksTop = 0;
        if(_links == null)
            _links = new int[linksSize];
        _links[_linksTop++] = 0;
        _stackFrames = new XObject[varArraySize];
    }

    public void setStackFrame(int sf)
    {
        _currentFrameBottom = sf;
    }

    public int getStackFrame()
    {
        return _currentFrameBottom;
    }

    public int link(int size)
    {
        _currentFrameBottom = _frameTop;
        _frameTop += size;
        if(_frameTop >= _stackFrames.length)
        {
            XObject newsf[] = new XObject[_stackFrames.length + 4096 + size];
            System.arraycopy(_stackFrames, 0, newsf, 0, _stackFrames.length);
            _stackFrames = newsf;
        }
        if(_linksTop + 1 >= _links.length)
        {
            int newlinks[] = new int[_links.length + 2048];
            System.arraycopy(_links, 0, newlinks, 0, _links.length);
            _links = newlinks;
        }
        _links[_linksTop++] = _currentFrameBottom;
        return _currentFrameBottom;
    }

    public void unlink()
    {
        _frameTop = _links[--_linksTop];
        _currentFrameBottom = _links[_linksTop - 1];
    }

    public void unlink(int currentFrame)
    {
        _frameTop = _links[--_linksTop];
        _currentFrameBottom = currentFrame;
    }

    public void setLocalVariable(int index, XObject val)
    {
        _stackFrames[index + _currentFrameBottom] = val;
    }

    public void setLocalVariable(int index, XObject val, int stackFrame)
    {
        _stackFrames[index + stackFrame] = val;
    }

    public XObject getLocalVariable(XPathContext xctxt, int index)
        throws TransformerException
    {
        index += _currentFrameBottom;
        XObject val = _stackFrames[index];
        if(null == val)
            throw new TransformerException(XPATHMessages.createXPATHMessage("ER_VARIABLE_ACCESSED_BEFORE_BIND", null), xctxt.getSAXLocator());
        if(val.getType() == 600)
            return _stackFrames[index] = val.execute(xctxt);
        else
            return val;
    }

    public XObject getLocalVariable(int index, int frame)
        throws TransformerException
    {
        index += frame;
        XObject val = _stackFrames[index];
        return val;
    }

    public XObject getLocalVariable(XPathContext xctxt, int index, boolean destructiveOK)
        throws TransformerException
    {
        index += _currentFrameBottom;
        XObject val = _stackFrames[index];
        if(null == val)
            throw new TransformerException(XPATHMessages.createXPATHMessage("ER_VARIABLE_ACCESSED_BEFORE_BIND", null), xctxt.getSAXLocator());
        if(val.getType() == 600)
            return _stackFrames[index] = val.execute(xctxt);
        else
            return destructiveOK ? val : val.getFresh();
    }

    public boolean isLocalSet(int index)
        throws TransformerException
    {
        return _stackFrames[index + _currentFrameBottom] != null;
    }

    public void clearLocalSlots(int start, int len)
    {
        start += _currentFrameBottom;
        System.arraycopy(m_nulls, 0, _stackFrames, start, len);
    }

    public void setGlobalVariable(int index, XObject val)
    {
        _stackFrames[index] = val;
    }

    public XObject getGlobalVariable(XPathContext xctxt, int index)
        throws TransformerException
    {
        XObject val = _stackFrames[index];
        if(val.getType() == 600)
            return _stackFrames[index] = val.execute(xctxt);
        else
            return val;
    }

    public XObject getGlobalVariable(XPathContext xctxt, int index, boolean destructiveOK)
        throws TransformerException
    {
        XObject val = _stackFrames[index];
        if(val.getType() == 600)
            return _stackFrames[index] = val.execute(xctxt);
        else
            return destructiveOK ? val : val.getFresh();
    }

    public XObject getVariableOrParam(XPathContext xctxt, QName qname)
        throws TransformerException
    {
        org.apache.xml.utils.PrefixResolver prefixResolver = xctxt.getNamespaceContext();
        if(prefixResolver instanceof ElemTemplateElement)
        {
            ElemTemplateElement prev = (ElemTemplateElement)prefixResolver;
            ElemVariable vvar;
            if(!(prev instanceof Stylesheet))
            {
                ElemTemplateElement savedprev;
                for(; !(prev.getParentNode() instanceof Stylesheet); prev = savedprev.getParentElem())
                {
                    savedprev = prev;
                    while(null != (prev = prev.getPreviousSiblingElem())) 
                        if(prev instanceof ElemVariable)
                        {
                            vvar = (ElemVariable)prev;
                            if(vvar.getName().equals(qname))
                                return getLocalVariable(xctxt, vvar.getIndex());
                        }
                }

            }
            vvar = prev.getStylesheetRoot().getVariableOrParamComposed(qname);
            if(null != vvar)
                return getGlobalVariable(xctxt, vvar.getIndex());
        }
        throw new TransformerException(XPATHMessages.createXPATHMessage("ER_VAR_NOT_RESOLVABLE", new Object[] {
            qname.toString()
        }));
    }

    public static final int CLEARLIMITATION = 1024;
    XObject _stackFrames[];
    int _frameTop;
    private int _currentFrameBottom;
    int _links[];
    int _linksTop;
    private static XObject m_nulls[] = new XObject[1024];

}
