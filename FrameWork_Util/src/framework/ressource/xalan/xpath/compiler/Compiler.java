// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Compiler.java

package framework.ressource.xalan.xpath.compiler;

import java.io.PrintStream;
import javax.xml.transform.*;
import org.apache.xml.utils.*;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.axes.UnionPathIterator;
import framework.ressource.xalan.xpath.axes.WalkerFactory;
import framework.ressource.xalan.xpath.functions.*;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.objects.XString;
import framework.ressource.xalan.xpath.operations.*;
import framework.ressource.xalan.xpath.operations.Number;
import framework.ressource.xalan.xpath.operations.String;
import framework.ressource.xalan.xpath.patterns.*;
import framework.ressource.xalan.xpath.res.XPATHMessages;

// Referenced classes of package framework.ressource.xalan.xpath.compiler:
//            OpMap, FunctionTable

public class Compiler extends OpMap
{

    public Compiler(ErrorListener errorHandler, SourceLocator locator, FunctionTable fTable)
    {
        locPathDepth = -1;
        m_currentPrefixResolver = null;
        m_errorHandler = errorHandler;
        m_locator = locator;
        m_functionTable = fTable;
    }

    public Compiler()
    {
        locPathDepth = -1;
        m_currentPrefixResolver = null;
        m_errorHandler = null;
        m_locator = null;
    }

    public Expression compile(int opPos)
        throws TransformerException
    {
        int op = getOp(opPos);
        Expression expr = null;
        switch(op)
        {
        case 1: // '\001'
            expr = compile(opPos + 2);
            break;

        case 2: // '\002'
            expr = or(opPos);
            break;

        case 3: // '\003'
            expr = and(opPos);
            break;

        case 4: // '\004'
            expr = notequals(opPos);
            break;

        case 5: // '\005'
            expr = equals(opPos);
            break;

        case 6: // '\006'
            expr = lte(opPos);
            break;

        case 7: // '\007'
            expr = lt(opPos);
            break;

        case 8: // '\b'
            expr = gte(opPos);
            break;

        case 9: // '\t'
            expr = gt(opPos);
            break;

        case 10: // '\n'
            expr = plus(opPos);
            break;

        case 11: // '\013'
            expr = minus(opPos);
            break;

        case 12: // '\f'
            expr = mult(opPos);
            break;

        case 13: // '\r'
            expr = div(opPos);
            break;

        case 14: // '\016'
            expr = mod(opPos);
            break;

        case 16: // '\020'
            expr = neg(opPos);
            break;

        case 17: // '\021'
            expr = string(opPos);
            break;

        case 18: // '\022'
            expr = bool(opPos);
            break;

        case 19: // '\023'
            expr = number(opPos);
            break;

        case 20: // '\024'
            expr = union(opPos);
            break;

        case 21: // '\025'
            expr = literal(opPos);
            break;

        case 22: // '\026'
            expr = variable(opPos);
            break;

        case 23: // '\027'
            expr = group(opPos);
            break;

        case 27: // '\033'
            expr = numberlit(opPos);
            break;

        case 26: // '\032'
            expr = arg(opPos);
            break;

        case 24: // '\030'
            expr = compileExtension(opPos);
            break;

        case 25: // '\031'
            expr = compileFunction(opPos);
            break;

        case 28: // '\034'
            expr = locationPath(opPos);
            break;

        case 29: // '\035'
            expr = null;
            break;

        case 30: // '\036'
            expr = matchPattern(opPos + 2);
            break;

        case 31: // '\037'
            expr = locationPathPattern(opPos);
            break;

        case 15: // '\017'
            error("ER_UNKNOWN_OPCODE", new Object[] {
                "quo"
            });
            break;

        default:
            error("ER_UNKNOWN_OPCODE", new Object[] {
                Integer.toString(getOp(opPos))
            });
            break;
        }
        return expr;
    }

    private Expression compileOperation(Operation operation, int opPos)
        throws TransformerException
    {
        int leftPos = OpMap.getFirstChildPos(opPos);
        int rightPos = getNextOpPos(leftPos);
        operation.setLeftRight(compile(leftPos), compile(rightPos));
        return operation;
    }

    private Expression compileUnary(UnaryOperation unary, int opPos)
        throws TransformerException
    {
        int rightPos = OpMap.getFirstChildPos(opPos);
        unary.setRight(compile(rightPos));
        return unary;
    }

    protected Expression or(int opPos)
        throws TransformerException
    {
        return compileOperation(new Or(), opPos);
    }

    protected Expression and(int opPos)
        throws TransformerException
    {
        return compileOperation(new And(), opPos);
    }

    protected Expression notequals(int opPos)
        throws TransformerException
    {
        return compileOperation(new NotEquals(), opPos);
    }

    protected Expression equals(int opPos)
        throws TransformerException
    {
        return compileOperation(new Equals(), opPos);
    }

    protected Expression lte(int opPos)
        throws TransformerException
    {
        return compileOperation(new Lte(), opPos);
    }

    protected Expression lt(int opPos)
        throws TransformerException
    {
        return compileOperation(new Lt(), opPos);
    }

    protected Expression gte(int opPos)
        throws TransformerException
    {
        return compileOperation(new Gte(), opPos);
    }

    protected Expression gt(int opPos)
        throws TransformerException
    {
        return compileOperation(new Gt(), opPos);
    }

    protected Expression plus(int opPos)
        throws TransformerException
    {
        return compileOperation(new Plus(), opPos);
    }

    protected Expression minus(int opPos)
        throws TransformerException
    {
        return compileOperation(new Minus(), opPos);
    }

    protected Expression mult(int opPos)
        throws TransformerException
    {
        return compileOperation(new Mult(), opPos);
    }

    protected Expression div(int opPos)
        throws TransformerException
    {
        return compileOperation(new Div(), opPos);
    }

    protected Expression mod(int opPos)
        throws TransformerException
    {
        return compileOperation(new Mod(), opPos);
    }

    protected Expression neg(int opPos)
        throws TransformerException
    {
        return compileUnary(new Neg(), opPos);
    }

    protected Expression string(int opPos)
        throws TransformerException
    {
        return compileUnary(new String(), opPos);
    }

    protected Expression bool(int opPos)
        throws TransformerException
    {
        return compileUnary(new Bool(), opPos);
    }

    protected Expression number(int opPos)
        throws TransformerException
    {
        return compileUnary(new Number(), opPos);
    }

    protected Expression literal(int opPos)
    {
        opPos = OpMap.getFirstChildPos(opPos);
        return (XString)getTokenQueue().elementAt(getOp(opPos));
    }

    protected Expression numberlit(int opPos)
    {
        opPos = OpMap.getFirstChildPos(opPos);
        return (XNumber)getTokenQueue().elementAt(getOp(opPos));
    }

    protected Expression variable(int opPos)
        throws TransformerException
    {
        Variable var = new Variable();
        opPos = OpMap.getFirstChildPos(opPos);
        int nsPos = getOp(opPos);
        java.lang.String namespace = -2 != nsPos ? (java.lang.String)getTokenQueue().elementAt(nsPos) : null;
        java.lang.String localname = (java.lang.String)getTokenQueue().elementAt(getOp(opPos + 1));
        QName qname = new QName(namespace, localname);
        var.setQName(qname);
        return var;
    }

    protected Expression group(int opPos)
        throws TransformerException
    {
        return compile(opPos + 2);
    }

    protected Expression arg(int opPos)
        throws TransformerException
    {
        return compile(opPos + 2);
    }

    protected Expression union(int opPos)
        throws TransformerException
    {
        locPathDepth++;
        try
        {
            framework.ressource.xalan.xpath.axes.LocPathIterator locpathiterator = UnionPathIterator.createUnionIterator(this, opPos);
            return locpathiterator;
        }
        finally
        {
            locPathDepth--;
        }
    }

    public int getLocationPathDepth()
    {
        return locPathDepth;
    }

    FunctionTable getFunctionTable()
    {
        return m_functionTable;
    }

    public Expression locationPath(int opPos)
        throws TransformerException
    {
        locPathDepth++;
        try
        {
            org.apache.xml.dtm.DTMIterator iter = WalkerFactory.newDTMIterator(this, opPos, locPathDepth == 0);
            Expression expression = (Expression)iter;
            return expression;
        }
        finally
        {
            locPathDepth--;
        }
    }

    public Expression predicate(int opPos)
        throws TransformerException
    {
        return compile(opPos + 2);
    }

    protected Expression matchPattern(int opPos)
        throws TransformerException
    {
        locPathDepth++;
        try
        {
            int nextOpPos = opPos;
            int i;
            for(i = 0; getOp(nextOpPos) == 31; i++)
                nextOpPos = getNextOpPos(nextOpPos);

            if(i == 1)
            {
                Expression expression = compile(opPos);
                return expression;
            }
            UnionPattern up = new UnionPattern();
            StepPattern patterns[] = new StepPattern[i];
            for(i = 0; getOp(opPos) == 31; i++)
            {
                nextOpPos = getNextOpPos(opPos);
                patterns[i] = (StepPattern)compile(opPos);
                opPos = nextOpPos;
            }

            up.setPatterns(patterns);
            UnionPattern unionpattern = up;
            return unionpattern;
        }
        finally
        {
            locPathDepth--;
        }
    }

    public Expression locationPathPattern(int opPos)
        throws TransformerException
    {
        opPos = OpMap.getFirstChildPos(opPos);
        return stepPattern(opPos, 0, null);
    }

    public int getWhatToShow(int opPos)
    {
        int axesType = getOp(opPos);
        int testType = getOp(opPos + 3);
        switch(testType)
        {
        case 1030: 
            return 128;

        case 1031: 
            return 12;

        case 1032: 
            return 64;

        case 1033: 
            switch(axesType)
            {
            case 49: // '1'
                return 4096;

            case 39: // '\''
            case 51: // '3'
                return 2;

            case 38: // '&'
            case 42: // '*'
            case 48: // '0'
                return -1;
            }
            return getOp(0) != 30 ? -3 : -1283;

        case 35: // '#'
            return 1280;

        case 1034: 
            return 0x10000;

        case 34: // '"'
            switch(axesType)
            {
            case 49: // '1'
                return 4096;

            case 39: // '\''
            case 51: // '3'
                return 2;

            case 52: // '4'
            case 53: // '5'
                return 1;

            case 40: // '('
            case 41: // ')'
            case 42: // '*'
            case 43: // '+'
            case 44: // ','
            case 45: // '-'
            case 46: // '.'
            case 47: // '/'
            case 48: // '0'
            case 50: // '2'
            default:
                return 1;
            }
        }
        return -1;
    }

    protected StepPattern stepPattern(int opPos, int stepCount, StepPattern ancestorPattern)
        throws TransformerException
    {
        int startOpPos = opPos;
        int stepType = getOp(opPos);
        if(-1 == stepType)
            return null;
        boolean addMagicSelf = true;
        int endStep = getNextOpPos(opPos);
        StepPattern pattern;
        int argLen;
        switch(stepType)
        {
        case 25: // '\031'
            addMagicSelf = false;
            argLen = getOp(opPos + 1);
            pattern = new FunctionPattern(compileFunction(opPos), 10, 3);
            break;

        case 50: // '2'
            addMagicSelf = false;
            argLen = getArgLengthOfStep(opPos);
            opPos = OpMap.getFirstChildPosOfStep(opPos);
            pattern = new StepPattern(1280, 10, 3);
            break;

        case 51: // '3'
            argLen = getArgLengthOfStep(opPos);
            opPos = OpMap.getFirstChildPosOfStep(opPos);
            pattern = new StepPattern(2, getStepNS(startOpPos), getStepLocalName(startOpPos), 10, 2);
            break;

        case 52: // '4'
            argLen = getArgLengthOfStep(opPos);
            opPos = OpMap.getFirstChildPosOfStep(opPos);
            int what = getWhatToShow(startOpPos);
            if(1280 == what)
                addMagicSelf = false;
            pattern = new StepPattern(getWhatToShow(startOpPos), getStepNS(startOpPos), getStepLocalName(startOpPos), 0, 3);
            break;

        case 53: // '5'
            argLen = getArgLengthOfStep(opPos);
            opPos = OpMap.getFirstChildPosOfStep(opPos);
            pattern = new StepPattern(getWhatToShow(startOpPos), getStepNS(startOpPos), getStepLocalName(startOpPos), 10, 3);
            break;

        default:
            error("ER_UNKNOWN_MATCH_OPERATION", null);
            return null;
        }
        pattern.setPredicates(getCompiledPredicates(opPos + argLen));
        if(null != ancestorPattern)
            pattern.setRelativePathPattern(ancestorPattern);
        StepPattern relativePathPattern = stepPattern(endStep, stepCount + 1, pattern);
        return null == relativePathPattern ? pattern : relativePathPattern;
    }

    public Expression[] getCompiledPredicates(int opPos)
        throws TransformerException
    {
        int count = countPredicates(opPos);
        if(count > 0)
        {
            Expression predicates[] = new Expression[count];
            compilePredicates(opPos, predicates);
            return predicates;
        } else
        {
            return null;
        }
    }

    public int countPredicates(int opPos)
        throws TransformerException
    {
        int count = 0;
        for(; 29 == getOp(opPos); opPos = getNextOpPos(opPos))
            count++;

        return count;
    }

    private void compilePredicates(int opPos, Expression predicates[])
        throws TransformerException
    {
        for(int i = 0; 29 == getOp(opPos); i++)
        {
            predicates[i] = predicate(opPos);
            opPos = getNextOpPos(opPos);
        }

    }

    Expression compileFunction(int opPos)
        throws TransformerException
    {
        int endFunc = (opPos + getOp(opPos + 1)) - 1;
        opPos = OpMap.getFirstChildPos(opPos);
        int funcID = getOp(opPos);
        opPos++;
        if(-1 != funcID)
        {
            Function func = m_functionTable.getFunction(funcID);
            if(func instanceof FuncExtFunctionAvailable)
                ((FuncExtFunctionAvailable)func).setFunctionTable(m_functionTable);
            func.postCompileStep(this);
            try
            {
                int i = 0;
                for(int p = opPos; p < endFunc;)
                {
                    func.setArg(compile(p), i);
                    p = getNextOpPos(p);
                    i++;
                }

                func.checkNumberArgs(i);
            }
            catch(WrongNumberArgsException wnae)
            {
            	java.lang.String name = m_functionTable.getFunctionName(funcID);
                m_errorHandler.fatalError(new TransformerException(XPATHMessages.createXPATHMessage("ER_ONLY_ALLOWS", new Object[] {
                    name, wnae.getMessage()
                }), m_locator));
            }
            return func;
        } else
        {
            error("ER_FUNCTION_TOKEN_NOT_FOUND", null);
            return null;
        }
    }

    private synchronized long getNextMethodId()
    {
        if(s_nextMethodId == 0x7fffffffffffffffL)
            s_nextMethodId = 0L;
        return s_nextMethodId++;
    }

    private Expression compileExtension(int opPos)
        throws TransformerException
    {
        int endExtFunc = (opPos + getOp(opPos + 1)) - 1;
        opPos = OpMap.getFirstChildPos(opPos);
        java.lang.String ns = (java.lang.String)getTokenQueue().elementAt(getOp(opPos));
        opPos++;
        java.lang.String funcName = (java.lang.String)getTokenQueue().elementAt(getOp(opPos));
        opPos++;
        Function extension = new FuncExtFunction(ns, funcName, java.lang.String.valueOf(getNextMethodId()));
        try
        {
            for(int i = 0; opPos < endExtFunc; i++)
            {
                int nextOpPos = getNextOpPos(opPos);
                extension.setArg(compile(opPos), i);
                opPos = nextOpPos;
            }

        }
        catch(WrongNumberArgsException wnae) { }
        return extension;
    }

    public void warn(java.lang.String msg, Object args[])
        throws TransformerException
    {
    	java.lang.String fmsg = XPATHMessages.createXPATHWarning(msg, args);
        if(null != m_errorHandler)
            m_errorHandler.warning(new TransformerException(fmsg, m_locator));
        else
            System.out.println(fmsg + "; file " + m_locator.getSystemId() + "; line " + m_locator.getLineNumber() + "; column " + m_locator.getColumnNumber());
    }

    public void assertion(boolean b, java.lang.String msg)
    {
        if(!b)
        {
        	java.lang.String fMsg = XPATHMessages.createXPATHMessage("ER_INCORRECT_PROGRAMMER_ASSERTION", new Object[] {
                msg
            });
            throw new RuntimeException(fMsg);
        } else
        {
            return;
        }
    }

    public void error(java.lang.String msg, Object args[])
        throws TransformerException
    {
    	java.lang.String fmsg = XPATHMessages.createXPATHMessage(msg, args);
        if(null != m_errorHandler)
            m_errorHandler.fatalError(new TransformerException(fmsg, m_locator));
        else
            throw new TransformerException(fmsg, (SAXSourceLocator)m_locator);
    }

    public PrefixResolver getNamespaceContext()
    {
        return m_currentPrefixResolver;
    }

    public void setNamespaceContext(PrefixResolver pr)
    {
        m_currentPrefixResolver = pr;
    }

    private int locPathDepth;
    private static final boolean DEBUG = false;
    private static long s_nextMethodId = 0L;
    private PrefixResolver m_currentPrefixResolver;
    ErrorListener m_errorHandler;
    SourceLocator m_locator;
    private FunctionTable m_functionTable;

}
