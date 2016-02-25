// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UnionChildIterator.java

package framework.ressource.xalan.xpath.axes;

import java.util.Vector;
import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.XPathContext;
import framework.ressource.xalan.xpath.objects.XObject;
import framework.ressource.xalan.xpath.patterns.NodeTest;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            ChildTestIterator, PredicatedNodeTest, LocPathIterator

public class UnionChildIterator extends ChildTestIterator
{

    public UnionChildIterator()
    {
        super(null);
        m_nodeTests = null;
    }

    public void addNodeTest(PredicatedNodeTest test)
    {
        if(null == m_nodeTests)
        {
            m_nodeTests = new PredicatedNodeTest[1];
            m_nodeTests[0] = test;
        } else
        {
            PredicatedNodeTest tests[] = m_nodeTests;
            int len = m_nodeTests.length;
            m_nodeTests = new PredicatedNodeTest[len + 1];
            System.arraycopy(tests, 0, m_nodeTests, 0, len);
            m_nodeTests[len] = test;
        }
        test.exprSetParent(this);
    }

    public void fixupVariables(Vector vars, int globalsSize)
    {
        super.fixupVariables(vars, globalsSize);
        if(m_nodeTests != null)
        {
            for(int i = 0; i < m_nodeTests.length; i++)
                m_nodeTests[i].fixupVariables(vars, globalsSize);

        }
    }

    public short acceptNode(int n)
    {
        XPathContext xctxt = getXPathContext();
        try
        {
            xctxt.pushCurrentNode(n);
            for(int i = 0; i < m_nodeTests.length; i++)
            {
                PredicatedNodeTest pnt = m_nodeTests[i];
                XObject score = pnt.execute(xctxt, n);
                if(score != NodeTest.SCORE_NONE)
                    if(pnt.getPredicateCount() > 0)
                    {
                        if(pnt.executePredicates(n, xctxt))
                        {
                            short word0 = 1;
                            return word0;
                        }
                    } else
                    {
                        short word1 = 1;
                        return word1;
                    }
            }

        }
        catch(TransformerException se)
        {
            throw new RuntimeException(se.getMessage());
        }
        finally
        {
            xctxt.popCurrentNode();
        }
        return 3;
    }

    static final long serialVersionUID = 0x30938eec96f3f3e7L;
    private PredicatedNodeTest m_nodeTests[];
}
