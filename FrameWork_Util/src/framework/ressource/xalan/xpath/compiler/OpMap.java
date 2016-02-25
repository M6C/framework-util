// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OpMap.java

package framework.ressource.xalan.xpath.compiler;

import javax.xml.transform.TransformerException;
import org.apache.xml.utils.ObjectVector;
import framework.ressource.xalan.xpath.res.XPATHMessages;

// Referenced classes of package framework.ressource.xalan.xpath.compiler:
//            OpMapVector

public class OpMap
{

    public OpMap()
    {
        m_tokenQueue = new ObjectVector(500, 500);
        m_opMap = null;
    }

    public String toString()
    {
        return m_currentPattern;
    }

    public String getPatternString()
    {
        return m_currentPattern;
    }

    public ObjectVector getTokenQueue()
    {
        return m_tokenQueue;
    }

    public Object getToken(int pos)
    {
        return m_tokenQueue.elementAt(pos);
    }

    public int getTokenQueueSize()
    {
        return m_tokenQueue.size();
    }

    public OpMapVector getOpMap()
    {
        return m_opMap;
    }

    void shrink()
    {
        int n = m_opMap.elementAt(1);
        m_opMap.setToSize(n + 4);
        m_opMap.setElementAt(0, n);
        m_opMap.setElementAt(0, n + 1);
        m_opMap.setElementAt(0, n + 2);
        n = m_tokenQueue.size();
        m_tokenQueue.setToSize(n + 4);
        m_tokenQueue.setElementAt(null, n);
        m_tokenQueue.setElementAt(null, n + 1);
        m_tokenQueue.setElementAt(null, n + 2);
    }

    public int getOp(int opPos)
    {
        return m_opMap.elementAt(opPos);
    }

    public void setOp(int opPos, int value)
    {
        m_opMap.setElementAt(value, opPos);
    }

    public int getNextOpPos(int opPos)
    {
        return opPos + m_opMap.elementAt(opPos + 1);
    }

    public int getNextStepPos(int opPos)
    {
        int stepType = getOp(opPos);
        if(stepType >= 37 && stepType <= 53)
            return getNextOpPos(opPos);
        if(stepType >= 22 && stepType <= 25)
        {
            int newOpPos;
            for(newOpPos = getNextOpPos(opPos); 29 == getOp(newOpPos); newOpPos = getNextOpPos(newOpPos));
            stepType = getOp(newOpPos);
            if(stepType < 37 || stepType > 53)
                return -1;
            else
                return newOpPos;
        } else
        {
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_UNKNOWN_STEP", new Object[] {
                String.valueOf(stepType)
            }));
        }
    }

    public static int getNextOpPos(int opMap[], int opPos)
    {
        return opPos + opMap[opPos + 1];
    }

    public int getFirstPredicateOpPos(int opPos)
        throws TransformerException
    {
        int stepType = m_opMap.elementAt(opPos);
        if(stepType >= 37 && stepType <= 53)
            return opPos + m_opMap.elementAt(opPos + 2);
        if(stepType >= 22 && stepType <= 25)
            return opPos + m_opMap.elementAt(opPos + 1);
        if(-2 == stepType)
        {
            return -2;
        } else
        {
            error("ER_UNKNOWN_OPCODE", new Object[] {
                String.valueOf(stepType)
            });
            return -1;
        }
    }

    public void error(String msg, Object args[])
        throws TransformerException
    {
        String fmsg = XPATHMessages.createXPATHMessage(msg, args);
        throw new TransformerException(fmsg);
    }

    public static int getFirstChildPos(int opPos)
    {
        return opPos + 2;
    }

    public int getArgLength(int opPos)
    {
        return m_opMap.elementAt(opPos + 1);
    }

    public int getArgLengthOfStep(int opPos)
    {
        return m_opMap.elementAt(opPos + 1 + 1) - 3;
    }

    public static int getFirstChildPosOfStep(int opPos)
    {
        return opPos + 3;
    }

    public int getStepTestType(int opPosOfStep)
    {
        return m_opMap.elementAt(opPosOfStep + 3);
    }

    public String getStepNS(int opPosOfStep)
    {
        int argLenOfStep = getArgLengthOfStep(opPosOfStep);
        if(argLenOfStep == 3)
        {
            int index = m_opMap.elementAt(opPosOfStep + 4);
            if(index >= 0)
                return (String)m_tokenQueue.elementAt(index);
            if(-3 == index)
                return "*";
            else
                return null;
        } else
        {
            return null;
        }
    }

    public String getStepLocalName(int opPosOfStep)
    {
        int argLenOfStep = getArgLengthOfStep(opPosOfStep);
        int index;
        switch(argLenOfStep)
        {
        case 0: // '\0'
            index = -2;
            break;

        case 1: // '\001'
            index = -3;
            break;

        case 2: // '\002'
            index = m_opMap.elementAt(opPosOfStep + 4);
            break;

        case 3: // '\003'
            index = m_opMap.elementAt(opPosOfStep + 5);
            break;

        default:
            index = -2;
            break;
        }
        if(index >= 0)
            return m_tokenQueue.elementAt(index).toString();
        if(-3 == index)
            return "*";
        else
            return null;
    }

    protected String m_currentPattern;
    static final int MAXTOKENQUEUESIZE = 500;
    static final int BLOCKTOKENQUEUESIZE = 500;
    ObjectVector m_tokenQueue;
    OpMapVector m_opMap;
    public static final int MAPINDEX_LENGTH = 1;
}
