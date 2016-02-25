// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ContextMatchStepPattern.java

package framework.ressource.xalan.xpath.patterns;

import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTM;
import org.apache.xml.dtm.DTMAxisTraverser;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.axes.WalkerFactory;
import framework.ressource.xalan.xpath.objects.XObject;

// Referenced classes of package framework.ressource.xalan.xpath.patterns:
//            StepPattern, NodeTest

public class ContextMatchStepPattern extends StepPattern
{

    public ContextMatchStepPattern(int axis, int paxis)
    {
        super(-1, axis, paxis);
    }

    public XObject execute(XPathContext xctxt)
        throws TransformerException
    {
        if(xctxt.getIteratorRoot() == xctxt.getCurrentNode())
            return getStaticScore();
        else
            return NodeTest.SCORE_NONE;
    }

    public XObject executeRelativePathPattern(XPathContext xctxt, StepPattern prevStep)
        throws TransformerException
    {
        XObject score = NodeTest.SCORE_NONE;
        int context = xctxt.getCurrentNode();
        DTM dtm = xctxt.getDTM(context);
        if(null != dtm)
        {
            int predContext = xctxt.getCurrentNode();
            int axis = super.m_axis;
            boolean needToTraverseAttrs = WalkerFactory.isDownwardAxisOfMany(axis);
            boolean iterRootIsAttr = dtm.getNodeType(xctxt.getIteratorRoot()) == 2;
            if(11 == axis && iterRootIsAttr)
                axis = 15;
            DTMAxisTraverser traverser = dtm.getAxisTraverser(axis);
            for(int relative = traverser.first(context); -1 != relative; relative = traverser.next(context, relative))
                try
                {
                    xctxt.pushCurrentNode(relative);
                    score = execute(xctxt);
                    if(score != NodeTest.SCORE_NONE)
                    {
                        if(executePredicates(xctxt, dtm, context))
                        {
                            XObject xobject = score;
                            return xobject;
                        }
                        score = NodeTest.SCORE_NONE;
                    }
                    if(needToTraverseAttrs && iterRootIsAttr && 1 == dtm.getNodeType(relative))
                    {
                        int xaxis = 2;
                        for(int i = 0; i < 2; i++)
                        {
                            DTMAxisTraverser atraverser = dtm.getAxisTraverser(xaxis);
                            for(int arelative = atraverser.first(relative); -1 != arelative; arelative = atraverser.next(relative, arelative))
                                try
                                {
                                    xctxt.pushCurrentNode(arelative);
                                    score = execute(xctxt);
                                    if(score != NodeTest.SCORE_NONE && score != NodeTest.SCORE_NONE)
                                    {
                                        XObject xobject1 = score;
                                        return xobject1;
                                    }
                                }
                                finally
                                {
                                    xctxt.popCurrentNode();
                                }

                            xaxis = 9;
                        }

                    }
                }
                finally
                {
                    xctxt.popCurrentNode();
                }

        }
        return score;
    }

    static final long serialVersionUID = 0xe5cc259eea0e55daL;
}
