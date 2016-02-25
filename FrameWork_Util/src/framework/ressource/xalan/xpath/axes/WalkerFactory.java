// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WalkerFactory.java

package framework.ressource.xalan.xpath.axes;

import java.io.PrintStream;
import javax.xml.transform.TransformerException;
import org.apache.xml.dtm.DTMIterator;
import framework.ressource.xalan.xpath.Expression;
import framework.ressource.xalan.xpath.compiler.Compiler;
import framework.ressource.xalan.xpath.compiler.OpMap;
import framework.ressource.xalan.xpath.objects.XNumber;
import framework.ressource.xalan.xpath.patterns.*;
import framework.ressource.xalan.xpath.res.XPATHMessages;

// Referenced classes of package framework.ressource.xalan.xpath.axes:
//            SelfIteratorNoPredicate, ChildIterator, ChildTestIterator, AttributeIterator, 
//            OneStepIteratorForward, OneStepIterator, DescendantIterator, WalkingIterator, 
//            WalkingIteratorSorted, LocPathIterator, FilterExprWalker, AxesWalker, 
//            ReverseAxesWalker, MatchPatternIterator

public class WalkerFactory
{

    public WalkerFactory()
    {
    }

    static AxesWalker loadOneWalker(WalkingIterator lpi, Compiler compiler, int stepOpCodePos)
        throws TransformerException
    {
        AxesWalker firstWalker = null;
        int stepType = compiler.getOp(stepOpCodePos);
        if(stepType != -1)
        {
            firstWalker = createDefaultWalker(compiler, stepType, lpi, 0);
            firstWalker.init(compiler, stepOpCodePos, stepType);
        }
        return firstWalker;
    }

    static AxesWalker loadWalkers(WalkingIterator lpi, Compiler compiler, int stepOpCodePos, int stepIndex)
        throws TransformerException
    {
        AxesWalker firstWalker = null;
        AxesWalker prevWalker = null;
        int analysis = analyze(compiler, stepOpCodePos, stepIndex);
        int i;
        while(-1 != (i = compiler.getOp(stepOpCodePos))) 
        {
            AxesWalker walker = createDefaultWalker(compiler, stepOpCodePos, lpi, analysis);
            walker.init(compiler, stepOpCodePos, i);
            walker.exprSetParent(lpi);
            if(null == firstWalker)
            {
                firstWalker = walker;
            } else
            {
                prevWalker.setNextWalker(walker);
                walker.setPrevWalker(prevWalker);
            }
            prevWalker = walker;
            stepOpCodePos = compiler.getNextStepPos(stepOpCodePos);
            if(stepOpCodePos < 0)
                break;
        }
        return firstWalker;
    }

    public static boolean isSet(int analysis, int bits)
    {
        return 0 != (analysis & bits);
    }

    public static void diagnoseIterator(String name, int analysis, Compiler compiler)
    {
        System.out.println(compiler.toString() + ", " + name + ", " + Integer.toBinaryString(analysis) + ", " + getAnalysisString(analysis));
    }

    public static DTMIterator newDTMIterator(Compiler compiler, int opPos, boolean isTopLevel)
        throws TransformerException
    {
        int firstStepPos = OpMap.getFirstChildPos(opPos);
        int analysis = analyze(compiler, firstStepPos, 0);
        boolean isOneStep = isOneStep(analysis);
        DTMIterator iter;
        if(isOneStep && walksSelfOnly(analysis) && isWild(analysis) && !hasPredicate(analysis))
            iter = new SelfIteratorNoPredicate(compiler, opPos, analysis);
        else
        if(walksChildrenOnly(analysis) && isOneStep)
        {
            if(isWild(analysis) && !hasPredicate(analysis))
                iter = new ChildIterator(compiler, opPos, analysis);
            else
                iter = new ChildTestIterator(compiler, opPos, analysis);
        } else
        if(isOneStep && walksAttributes(analysis))
            iter = new AttributeIterator(compiler, opPos, analysis);
        else
        if(isOneStep && !walksFilteredList(analysis))
        {
            if(!walksNamespaces(analysis) && (walksInDocOrder(analysis) || isSet(analysis, 0x400000)))
                iter = new OneStepIteratorForward(compiler, opPos, analysis);
            else
                iter = new OneStepIterator(compiler, opPos, analysis);
        } else
        if(isOptimizableForDescendantIterator(compiler, firstStepPos, 0))
            iter = new DescendantIterator(compiler, opPos, analysis);
        else
        if(isNaturalDocOrder(compiler, firstStepPos, 0, analysis))
            iter = new WalkingIterator(compiler, opPos, analysis, true);
        else
            iter = new WalkingIteratorSorted(compiler, opPos, analysis, true);
        if(iter instanceof LocPathIterator)
            ((LocPathIterator)iter).setIsTopLevel(isTopLevel);
        return iter;
    }

    public static int getAxisFromStep(Compiler compiler, int stepOpCodePos)
        throws TransformerException
    {
        int stepType = compiler.getOp(stepOpCodePos);
        switch(stepType)
        {
        case 43: // '+'
            return 6;

        case 44: // ','
            return 7;

        case 46: // '.'
            return 11;

        case 47: // '/'
            return 12;

        case 45: // '-'
            return 10;

        case 49: // '1'
            return 9;

        case 37: // '%'
            return 0;

        case 38: // '&'
            return 1;

        case 39: // '\''
            return 2;

        case 50: // '2'
            return 19;

        case 40: // '('
            return 3;

        case 42: // '*'
            return 5;

        case 41: // ')'
            return 4;

        case 48: // '0'
            return 13;

        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
            return 20;

        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        case 29: // '\035'
        case 30: // '\036'
        case 31: // '\037'
        case 32: // ' '
        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        default:
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NULL_ERROR_HANDLER", new Object[] {
                Integer.toString(stepType)
            }));
        }
    }

    public static int getAnalysisBitFromAxes(int axis)
    {
        switch(axis)
        {
        case 0: // '\0'
            return 8192;

        case 1: // '\001'
            return 16384;

        case 2: // '\002'
            return 32768;

        case 3: // '\003'
            return 0x10000;

        case 4: // '\004'
            return 0x20000;

        case 5: // '\005'
            return 0x40000;

        case 6: // '\006'
            return 0x80000;

        case 7: // '\007'
            return 0x100000;

        case 8: // '\b'
        case 9: // '\t'
            return 0x200000;

        case 10: // '\n'
            return 0x400000;

        case 11: // '\013'
            return 0x800000;

        case 12: // '\f'
            return 0x1000000;

        case 13: // '\r'
            return 0x2000000;

        case 14: // '\016'
            return 0x40000;

        case 16: // '\020'
        case 17: // '\021'
        case 18: // '\022'
            return 0x20000000;

        case 19: // '\023'
            return 0x8000000;

        case 20: // '\024'
            return 0x4000000;

        case 15: // '\017'
        default:
            return 0x4000000;
        }
    }

    static boolean functionProximateOrContainsProximate(Compiler compiler, int opPos)
    {
        int endFunc = (opPos + compiler.getOp(opPos + 1)) - 1;
        opPos = OpMap.getFirstChildPos(opPos);
        int funcID = compiler.getOp(opPos);
        switch(funcID)
        {
        case 1: // '\001'
        case 2: // '\002'
            return true;
        }
        opPos++;
        int i = 0;
        for(int p = opPos; p < endFunc;)
        {
            int innerExprOpPos = p + 2;
            int argOp = compiler.getOp(innerExprOpPos);
            boolean prox = isProximateInnerExpr(compiler, innerExprOpPos);
            if(prox)
                return true;
            p = compiler.getNextOpPos(p);
            i++;
        }

        return false;
    }

    static boolean isProximateInnerExpr(Compiler compiler, int opPos)
    {
        int op = compiler.getOp(opPos);
        int innerExprOpPos = opPos + 2;
        switch(op)
        {
        case 21: // '\025'
        case 22: // '\026'
        case 27: // '\033'
        case 28: // '\034'
            break;

        case 26: // '\032'
        {
            if(isProximateInnerExpr(compiler, innerExprOpPos))
                return true;
            break;
        }

        case 25: // '\031'
        {
            boolean isProx = functionProximateOrContainsProximate(compiler, opPos);
            if(isProx)
                return true;
            break;
        }

        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        {
            int leftPos = OpMap.getFirstChildPos(op);
            int rightPos = compiler.getNextOpPos(leftPos);
            boolean isProx = isProximateInnerExpr(compiler, leftPos);
            if(isProx)
                return true;
            isProx = isProximateInnerExpr(compiler, rightPos);
            if(isProx)
                return true;
            break;
        }

        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        case 16: // '\020'
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
        case 20: // '\024'
        case 23: // '\027'
        case 24: // '\030'
        default:
        {
            return true;
        }
        }
        return false;
    }

    public static boolean mightBeProximate(Compiler compiler, int opPos, int stepType)
        throws TransformerException
    {
        boolean mightBeProximate = false;
        int argLen;
        switch(stepType)
        {
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
            argLen = compiler.getArgLength(opPos);
            break;

        default:
            argLen = compiler.getArgLengthOfStep(opPos);
            break;
        }
        int predPos = compiler.getFirstPredicateOpPos(opPos);
        int count = 0;
        for(; 29 == compiler.getOp(predPos); predPos = compiler.getNextOpPos(predPos))
        {
            count++;
            int innerExprOpPos = predPos + 2;
            int predOp = compiler.getOp(innerExprOpPos);
            switch(predOp)
            {
            case 22: // '\026'
            {
                return true;
            }

            case 28: // '\034'
                break;

            case 19: // '\023'
            case 27: // '\033'
            {
                return true;
            }

            case 25: // '\031'
            {
                boolean isProx = functionProximateOrContainsProximate(compiler, innerExprOpPos);
                if(isProx)
                    return true;
                break;
            }

            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
            {
                int leftPos = OpMap.getFirstChildPos(innerExprOpPos);
                int rightPos = compiler.getNextOpPos(leftPos);
                boolean isProx = isProximateInnerExpr(compiler, leftPos);
                if(isProx)
                    return true;
                isProx = isProximateInnerExpr(compiler, rightPos);
                if(isProx)
                    return true;
                break;
            }

            case 10: // '\n'
            case 11: // '\013'
            case 12: // '\f'
            case 13: // '\r'
            case 14: // '\016'
            case 15: // '\017'
            case 16: // '\020'
            case 17: // '\021'
            case 18: // '\022'
            case 20: // '\024'
            case 21: // '\025'
            case 23: // '\027'
            case 24: // '\030'
            case 26: // '\032'
            default:
            {
                return true;
            }
            }
        }

        return mightBeProximate;
    }

    private static boolean isOptimizableForDescendantIterator(Compiler compiler, int stepOpCodePos, int stepIndex)
        throws TransformerException
    {
        int stepCount = 0;
        boolean foundDorDS = false;
        boolean foundSelf = false;
        boolean foundDS = false;
        int nodeTestType = 1033;
        int i;
        while(-1 != (i = compiler.getOp(stepOpCodePos))) 
        {
            if(nodeTestType != 1033 && nodeTestType != 35)
                return false;
            if(++stepCount > 3)
                return false;
            boolean mightBeProximate = mightBeProximate(compiler, stepOpCodePos, i);
            if(mightBeProximate)
                return false;
            switch(i)
            {
            case 22: // '\026'
            case 23: // '\027'
            case 24: // '\030'
            case 25: // '\031'
            case 37: // '%'
            case 38: // '&'
            case 39: // '\''
            case 43: // '+'
            case 44: // ','
            case 45: // '-'
            case 46: // '.'
            case 47: // '/'
            case 49: // '1'
            case 51: // '3'
            case 52: // '4'
            case 53: // '5'
                return false;

            case 50: // '2'
                if(1 != stepCount)
                    return false;
                break;

            case 40: // '('
                if(!foundDS && (!foundDorDS || !foundSelf))
                    return false;
                break;

            case 42: // '*'
                foundDS = true;
                // fall through

            case 41: // ')'
                if(3 == stepCount)
                    return false;
                foundDorDS = true;
                break;

            case 48: // '0'
                if(1 != stepCount)
                    return false;
                foundSelf = true;
                break;

            case 26: // '\032'
            case 27: // '\033'
            case 28: // '\034'
            case 29: // '\035'
            case 30: // '\036'
            case 31: // '\037'
            case 32: // ' '
            case 33: // '!'
            case 34: // '"'
            case 35: // '#'
            case 36: // '$'
            default:
                throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NULL_ERROR_HANDLER", new Object[] {
                    Integer.toString(i)
                }));
            }
            nodeTestType = compiler.getStepTestType(stepOpCodePos);
            int nextStepOpCodePos = compiler.getNextStepPos(stepOpCodePos);
            if(nextStepOpCodePos < 0)
                break;
            if(-1 != compiler.getOp(nextStepOpCodePos) && compiler.countPredicates(stepOpCodePos) > 0)
                return false;
            stepOpCodePos = nextStepOpCodePos;
        }
        return true;
    }

    private static int analyze(Compiler compiler, int stepOpCodePos, int stepIndex)
        throws TransformerException
    {
        int stepCount = 0;
        int analysisResult = 0;
        int i;
        while(-1 != (i = compiler.getOp(stepOpCodePos))) 
        {
            stepCount++;
            boolean predAnalysis = analyzePredicate(compiler, stepOpCodePos, i);
            if(predAnalysis)
                analysisResult |= 0x1000;
            switch(i)
            {
            case 22: // '\026'
            case 23: // '\027'
            case 24: // '\030'
            case 25: // '\031'
                analysisResult |= 0x4000000;
                break;

            case 50: // '2'
                analysisResult |= 0x8000000;
                break;

            case 37: // '%'
                analysisResult |= 0x2000;
                break;

            case 38: // '&'
                analysisResult |= 0x4000;
                break;

            case 39: // '\''
                analysisResult |= 0x8000;
                break;

            case 49: // '1'
                analysisResult |= 0x200000;
                break;

            case 40: // '('
                analysisResult |= 0x10000;
                break;

            case 41: // ')'
                analysisResult |= 0x20000;
                break;

            case 42: // '*'
                if(2 == stepCount && 0x8000000 == analysisResult)
                    analysisResult |= 0x20000000;
                analysisResult |= 0x40000;
                break;

            case 43: // '+'
                analysisResult |= 0x80000;
                break;

            case 44: // ','
                analysisResult |= 0x100000;
                break;

            case 46: // '.'
                analysisResult |= 0x800000;
                break;

            case 47: // '/'
                analysisResult |= 0x1000000;
                break;

            case 45: // '-'
                analysisResult |= 0x400000;
                break;

            case 48: // '0'
                analysisResult |= 0x2000000;
                break;

            case 51: // '3'
                analysisResult |= 0x80008000;
                break;

            case 52: // '4'
                analysisResult |= 0x80002000;
                break;

            case 53: // '5'
                analysisResult |= 0x80400000;
                break;

            case 26: // '\032'
            case 27: // '\033'
            case 28: // '\034'
            case 29: // '\035'
            case 30: // '\036'
            case 31: // '\037'
            case 32: // ' '
            case 33: // '!'
            case 34: // '"'
            case 35: // '#'
            case 36: // '$'
            default:
                throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NULL_ERROR_HANDLER", new Object[] {
                    Integer.toString(i)
                }));
            }
            if(1033 == compiler.getOp(stepOpCodePos + 3))
                analysisResult |= 0x40000000;
            stepOpCodePos = compiler.getNextStepPos(stepOpCodePos);
            if(stepOpCodePos < 0)
                break;
        }
        analysisResult |= stepCount & 0xff;
        return analysisResult;
    }

    public static boolean isDownwardAxisOfMany(int axis)
    {
        return 5 == axis || 4 == axis || 6 == axis || 11 == axis;
    }

    static StepPattern loadSteps(MatchPatternIterator mpi, Compiler compiler, int stepOpCodePos, int stepIndex)
        throws TransformerException
    {
        StepPattern step = null;
        StepPattern firstStep = null;
        StepPattern prevStep = null;
        int analysis = analyze(compiler, stepOpCodePos, stepIndex);
        int stepType;
        while(-1 != (stepType = compiler.getOp(stepOpCodePos))) 
        {
            step = createDefaultStepPattern(compiler, stepOpCodePos, mpi, analysis, firstStep, prevStep);
            if(null == firstStep)
                firstStep = step;
            else
                step.setRelativePathPattern(prevStep);
            prevStep = step;
            stepOpCodePos = compiler.getNextStepPos(stepOpCodePos);
            if(stepOpCodePos < 0)
                break;
        }
        int axis = 13;
        int paxis = 13;
        StepPattern tail = step;
        for(StepPattern pat = step; null != pat; pat = pat.getRelativePathPattern())
        {
            int nextAxis = pat.getAxis();
            pat.setAxis(axis);
            int whatToShow = pat.getWhatToShow();
            if(whatToShow == 2 || whatToShow == 4096)
            {
                int newAxis = whatToShow != 2 ? 9 : 2;
                if(isDownwardAxisOfMany(axis))
                {
                    StepPattern attrPat = new StepPattern(whatToShow, pat.getNamespace(), pat.getLocalName(), newAxis, 0);
                    XNumber score = pat.getStaticScore();
                    pat.setNamespace(null);
                    pat.setLocalName("*");
                    attrPat.setPredicates(pat.getPredicates());
                    pat.setPredicates(null);
                    pat.setWhatToShow(1);
                    StepPattern rel = pat.getRelativePathPattern();
                    pat.setRelativePathPattern(attrPat);
                    attrPat.setRelativePathPattern(rel);
                    attrPat.setStaticScore(score);
                    if(11 == pat.getAxis())
                        pat.setAxis(15);
                    else
                    if(4 == pat.getAxis())
                        pat.setAxis(5);
                    pat = attrPat;
                } else
                if(3 == pat.getAxis())
                    pat.setAxis(2);
            }
            axis = nextAxis;
            tail = pat;
        }

        if(axis < 16)
        {
            StepPattern selfPattern = new ContextMatchStepPattern(axis, paxis);
            XNumber score = tail.getStaticScore();
            tail.setRelativePathPattern(selfPattern);
            tail.setStaticScore(score);
            selfPattern.setStaticScore(score);
        }
        return step;
    }

    private static StepPattern createDefaultStepPattern(Compiler compiler, int opPos, MatchPatternIterator mpi, int analysis, StepPattern tail, StepPattern head)
        throws TransformerException
    {
        int stepType = compiler.getOp(opPos);
        boolean simpleInit = false;
        boolean prevIsOneStepDown = true;
        int whatToShow = compiler.getWhatToShow(opPos);
        StepPattern ai = null;
        int axis;
        int predicateAxis;
        switch(stepType)
        {
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
            prevIsOneStepDown = false;
            Expression expr;
            switch(stepType)
            {
            case 22: // '\026'
            case 23: // '\027'
            case 24: // '\030'
            case 25: // '\031'
                expr = compiler.compile(opPos);
                break;

            default:
                expr = compiler.compile(opPos + 2);
                break;
            }
            axis = 20;
            predicateAxis = 20;
            ai = new FunctionPattern(expr, axis, predicateAxis);
            simpleInit = true;
            break;

        case 50: // '2'
            whatToShow = 1280;
            axis = 19;
            predicateAxis = 19;
            ai = new StepPattern(1280, axis, predicateAxis);
            break;

        case 39: // '\''
            whatToShow = 2;
            axis = 10;
            predicateAxis = 2;
            break;

        case 49: // '1'
            whatToShow = 4096;
            axis = 10;
            predicateAxis = 9;
            break;

        case 37: // '%'
            axis = 4;
            predicateAxis = 0;
            break;

        case 40: // '('
            axis = 10;
            predicateAxis = 3;
            break;

        case 38: // '&'
            axis = 5;
            predicateAxis = 1;
            break;

        case 48: // '0'
            axis = 13;
            predicateAxis = 13;
            break;

        case 45: // '-'
            axis = 3;
            predicateAxis = 10;
            break;

        case 47: // '/'
            axis = 7;
            predicateAxis = 12;
            break;

        case 46: // '.'
            axis = 6;
            predicateAxis = 11;
            break;

        case 44: // ','
            axis = 12;
            predicateAxis = 7;
            break;

        case 43: // '+'
            axis = 11;
            predicateAxis = 6;
            break;

        case 42: // '*'
            axis = 1;
            predicateAxis = 5;
            break;

        case 41: // ')'
            axis = 0;
            predicateAxis = 4;
            break;

        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        case 29: // '\035'
        case 30: // '\036'
        case 31: // '\037'
        case 32: // ' '
        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        default:
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NULL_ERROR_HANDLER", new Object[] {
                Integer.toString(stepType)
            }));
        }
        if(null == ai)
        {
            whatToShow = compiler.getWhatToShow(opPos);
            ai = new StepPattern(whatToShow, compiler.getStepNS(opPos), compiler.getStepLocalName(opPos), axis, predicateAxis);
        }
        int argLen = compiler.getFirstPredicateOpPos(opPos);
        ai.setPredicates(compiler.getCompiledPredicates(argLen));
        return ai;
    }

    static boolean analyzePredicate(Compiler compiler, int opPos, int stepType)
        throws TransformerException
    {
        int argLen;
        switch(stepType)
        {
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
            argLen = compiler.getArgLength(opPos);
            break;

        default:
            argLen = compiler.getArgLengthOfStep(opPos);
            break;
        }
        int pos = compiler.getFirstPredicateOpPos(opPos);
        int nPredicates = compiler.countPredicates(pos);
        return nPredicates > 0;
    }

    private static AxesWalker createDefaultWalker(Compiler compiler, int opPos, WalkingIterator lpi, int analysis)
    {
        AxesWalker ai = null;
        int stepType = compiler.getOp(opPos);
        boolean simpleInit = false;
        int totalNumberWalkers = analysis & 0xff;
        boolean prevIsOneStepDown = true;
        switch(stepType)
        {
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
            prevIsOneStepDown = false;
            ai = new FilterExprWalker(lpi);
            simpleInit = true;
            break;

        case 50: // '2'
            ai = new AxesWalker(lpi, 19);
            break;

        case 37: // '%'
            prevIsOneStepDown = false;
            ai = new ReverseAxesWalker(lpi, 0);
            break;

        case 38: // '&'
            prevIsOneStepDown = false;
            ai = new ReverseAxesWalker(lpi, 1);
            break;

        case 39: // '\''
            ai = new AxesWalker(lpi, 2);
            break;

        case 49: // '1'
            ai = new AxesWalker(lpi, 9);
            break;

        case 40: // '('
            ai = new AxesWalker(lpi, 3);
            break;

        case 41: // ')'
            prevIsOneStepDown = false;
            ai = new AxesWalker(lpi, 4);
            break;

        case 42: // '*'
            prevIsOneStepDown = false;
            ai = new AxesWalker(lpi, 5);
            break;

        case 43: // '+'
            prevIsOneStepDown = false;
            ai = new AxesWalker(lpi, 6);
            break;

        case 44: // ','
            prevIsOneStepDown = false;
            ai = new AxesWalker(lpi, 7);
            break;

        case 46: // '.'
            prevIsOneStepDown = false;
            ai = new ReverseAxesWalker(lpi, 11);
            break;

        case 47: // '/'
            prevIsOneStepDown = false;
            ai = new ReverseAxesWalker(lpi, 12);
            break;

        case 45: // '-'
            prevIsOneStepDown = false;
            ai = new ReverseAxesWalker(lpi, 10);
            break;

        case 48: // '0'
            ai = new AxesWalker(lpi, 13);
            break;

        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        case 29: // '\035'
        case 30: // '\036'
        case 31: // '\037'
        case 32: // ' '
        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        default:
            throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NULL_ERROR_HANDLER", new Object[] {
                Integer.toString(stepType)
            }));
        }
        if(simpleInit)
        {
            ai.initNodeTest(-1);
        } else
        {
            int whatToShow = compiler.getWhatToShow(opPos);
            if(0 == (whatToShow & 0x1043) || whatToShow == -1)
                ai.initNodeTest(whatToShow);
            else
                ai.initNodeTest(whatToShow, compiler.getStepNS(opPos), compiler.getStepLocalName(opPos));
        }
        return ai;
    }

    public static String getAnalysisString(int analysis)
    {
        StringBuffer buf = new StringBuffer();
        buf.append("count: " + getStepCount(analysis) + " ");
        if((analysis & 0x40000000) != 0)
            buf.append("NTANY|");
        if((analysis & 0x1000) != 0)
            buf.append("PRED|");
        if((analysis & 0x2000) != 0)
            buf.append("ANC|");
        if((analysis & 0x4000) != 0)
            buf.append("ANCOS|");
        if((analysis & 0x8000) != 0)
            buf.append("ATTR|");
        if((analysis & 0x10000) != 0)
            buf.append("CH|");
        if((analysis & 0x20000) != 0)
            buf.append("DESC|");
        if((analysis & 0x40000) != 0)
            buf.append("DESCOS|");
        if((analysis & 0x80000) != 0)
            buf.append("FOL|");
        if((analysis & 0x100000) != 0)
            buf.append("FOLS|");
        if((analysis & 0x200000) != 0)
            buf.append("NS|");
        if((analysis & 0x400000) != 0)
            buf.append("P|");
        if((analysis & 0x800000) != 0)
            buf.append("PREC|");
        if((analysis & 0x1000000) != 0)
            buf.append("PRECS|");
        if((analysis & 0x2000000) != 0)
            buf.append(".|");
        if((analysis & 0x4000000) != 0)
            buf.append("FLT|");
        if((analysis & 0x8000000) != 0)
            buf.append("R|");
        return buf.toString();
    }

    public static boolean hasPredicate(int analysis)
    {
        return 0 != (analysis & 0x1000);
    }

    public static boolean isWild(int analysis)
    {
        return 0 != (analysis & 0x40000000);
    }

    public static boolean walksAncestors(int analysis)
    {
        return isSet(analysis, 24576);
    }

    public static boolean walksAttributes(int analysis)
    {
        return 0 != (analysis & 0x8000);
    }

    public static boolean walksNamespaces(int analysis)
    {
        return 0 != (analysis & 0x200000);
    }

    public static boolean walksChildren(int analysis)
    {
        return 0 != (analysis & 0x10000);
    }

    public static boolean walksDescendants(int analysis)
    {
        return isSet(analysis, 0x60000);
    }

    public static boolean walksSubtree(int analysis)
    {
        return isSet(analysis, 0x70000);
    }

    public static boolean walksSubtreeOnlyMaybeAbsolute(int analysis)
    {
        return walksSubtree(analysis) && !walksExtraNodes(analysis) && !walksUp(analysis) && !walksSideways(analysis);
    }

    public static boolean walksSubtreeOnly(int analysis)
    {
        return walksSubtreeOnlyMaybeAbsolute(analysis) && !isAbsolute(analysis);
    }

    public static boolean walksFilteredList(int analysis)
    {
        return isSet(analysis, 0x4000000);
    }

    public static boolean walksSubtreeOnlyFromRootOrContext(int analysis)
    {
        return walksSubtree(analysis) && !walksExtraNodes(analysis) && !walksUp(analysis) && !walksSideways(analysis) && !isSet(analysis, 0x4000000);
    }

    public static boolean walksInDocOrder(int analysis)
    {
        return (walksSubtreeOnlyMaybeAbsolute(analysis) || walksExtraNodesOnly(analysis) || walksFollowingOnlyMaybeAbsolute(analysis)) && !isSet(analysis, 0x4000000);
    }

    public static boolean walksFollowingOnlyMaybeAbsolute(int analysis)
    {
        return isSet(analysis, 0x2180000) && !walksSubtree(analysis) && !walksUp(analysis) && !walksSideways(analysis);
    }

    public static boolean walksUp(int analysis)
    {
        return isSet(analysis, 0x406000);
    }

    public static boolean walksSideways(int analysis)
    {
        return isSet(analysis, 0x1980000);
    }

    public static boolean walksExtraNodes(int analysis)
    {
        return isSet(analysis, 0x208000);
    }

    public static boolean walksExtraNodesOnly(int analysis)
    {
        return walksExtraNodes(analysis) && !isSet(analysis, 0x2000000) && !walksSubtree(analysis) && !walksUp(analysis) && !walksSideways(analysis) && !isAbsolute(analysis);
    }

    public static boolean isAbsolute(int analysis)
    {
        return isSet(analysis, 0xc000000);
    }

    public static boolean walksChildrenOnly(int analysis)
    {
        return walksChildren(analysis) && !isSet(analysis, 0x2000000) && !walksExtraNodes(analysis) && !walksDescendants(analysis) && !walksUp(analysis) && !walksSideways(analysis) && (!isAbsolute(analysis) || isSet(analysis, 0x8000000));
    }

    public static boolean walksChildrenAndExtraAndSelfOnly(int analysis)
    {
        return walksChildren(analysis) && !walksDescendants(analysis) && !walksUp(analysis) && !walksSideways(analysis) && (!isAbsolute(analysis) || isSet(analysis, 0x8000000));
    }

    public static boolean walksDescendantsAndExtraAndSelfOnly(int analysis)
    {
        return !walksChildren(analysis) && walksDescendants(analysis) && !walksUp(analysis) && !walksSideways(analysis) && (!isAbsolute(analysis) || isSet(analysis, 0x8000000));
    }

    public static boolean walksSelfOnly(int analysis)
    {
        return isSet(analysis, 0x2000000) && !walksSubtree(analysis) && !walksUp(analysis) && !walksSideways(analysis) && !isAbsolute(analysis);
    }

    public static boolean walksUpOnly(int analysis)
    {
        return !walksSubtree(analysis) && walksUp(analysis) && !walksSideways(analysis) && !isAbsolute(analysis);
    }

    public static boolean walksDownOnly(int analysis)
    {
        return walksSubtree(analysis) && !walksUp(analysis) && !walksSideways(analysis) && !isAbsolute(analysis);
    }

    public static boolean walksDownExtraOnly(int analysis)
    {
        return walksSubtree(analysis) && walksExtraNodes(analysis) && !walksUp(analysis) && !walksSideways(analysis) && !isAbsolute(analysis);
    }

    public static boolean canSkipSubtrees(int analysis)
    {
        return isSet(analysis, 0x10000) | walksSideways(analysis);
    }

    public static boolean canCrissCross(int analysis)
    {
        if(walksSelfOnly(analysis))
            return false;
        if(walksDownOnly(analysis) && !canSkipSubtrees(analysis))
            return false;
        if(walksChildrenAndExtraAndSelfOnly(analysis))
            return false;
        if(walksDescendantsAndExtraAndSelfOnly(analysis))
            return false;
        if(walksUpOnly(analysis))
            return false;
        if(walksExtraNodesOnly(analysis))
            return false;
        return walksSubtree(analysis) && (walksSideways(analysis) || walksUp(analysis) || canSkipSubtrees(analysis));
    }

    public static boolean isNaturalDocOrder(int analysis)
    {
        if(canCrissCross(analysis) || isSet(analysis, 0x200000) || walksFilteredList(analysis))
            return false;
        return walksInDocOrder(analysis);
    }

    private static boolean isNaturalDocOrder(Compiler compiler, int stepOpCodePos, int stepIndex, int analysis)
        throws TransformerException
    {
        if(canCrissCross(analysis))
            return false;
        if(isSet(analysis, 0x200000))
            return false;
        if(isSet(analysis, 0x180000) && isSet(analysis, 0x1800000))
            return false;
        int stepCount = 0;
        boolean foundWildAttribute = false;
        int potentialDuplicateMakingStepCount = 0;
        int i;
        while(-1 != (i = compiler.getOp(stepOpCodePos))) 
        {
            stepCount++;
            switch(i)
            {
            case 39: // '\''
            case 51: // '3'
                if(foundWildAttribute)
                    return false;
                String localName = compiler.getStepLocalName(stepOpCodePos);
                if(localName.equals("*"))
                    foundWildAttribute = true;
                break;

            case 22: // '\026'
            case 23: // '\027'
            case 24: // '\030'
            case 25: // '\031'
            case 37: // '%'
            case 38: // '&'
            case 41: // ')'
            case 42: // '*'
            case 43: // '+'
            case 44: // ','
            case 45: // '-'
            case 46: // '.'
            case 47: // '/'
            case 49: // '1'
            case 52: // '4'
            case 53: // '5'
                if(potentialDuplicateMakingStepCount > 0)
                    return false;
                potentialDuplicateMakingStepCount++;
                // fall through

            case 40: // '('
            case 48: // '0'
            case 50: // '2'
                if(foundWildAttribute)
                    return false;
                break;

            case 26: // '\032'
            case 27: // '\033'
            case 28: // '\034'
            case 29: // '\035'
            case 30: // '\036'
            case 31: // '\037'
            case 32: // ' '
            case 33: // '!'
            case 34: // '"'
            case 35: // '#'
            case 36: // '$'
            default:
                throw new RuntimeException(XPATHMessages.createXPATHMessage("ER_NULL_ERROR_HANDLER", new Object[] {
                    Integer.toString(i)
                }));
            }
            int nextStepOpCodePos = compiler.getNextStepPos(stepOpCodePos);
            if(nextStepOpCodePos < 0)
                break;
            stepOpCodePos = nextStepOpCodePos;
        }
        return true;
    }

    public static boolean isOneStep(int analysis)
    {
        return (analysis & 0xff) == 1;
    }

    public static int getStepCount(int analysis)
    {
        return analysis & 0xff;
    }

    static final boolean DEBUG_PATTERN_CREATION = false;
    static final boolean DEBUG_WALKER_CREATION = false;
    static final boolean DEBUG_ITERATOR_CREATION = false;
    public static final int BITS_COUNT = 255;
    public static final int BITS_RESERVED = 3840;
    public static final int BIT_PREDICATE = 4096;
    public static final int BIT_ANCESTOR = 8192;
    public static final int BIT_ANCESTOR_OR_SELF = 16384;
    public static final int BIT_ATTRIBUTE = 32768;
    public static final int BIT_CHILD = 0x10000;
    public static final int BIT_DESCENDANT = 0x20000;
    public static final int BIT_DESCENDANT_OR_SELF = 0x40000;
    public static final int BIT_FOLLOWING = 0x80000;
    public static final int BIT_FOLLOWING_SIBLING = 0x100000;
    public static final int BIT_NAMESPACE = 0x200000;
    public static final int BIT_PARENT = 0x400000;
    public static final int BIT_PRECEDING = 0x800000;
    public static final int BIT_PRECEDING_SIBLING = 0x1000000;
    public static final int BIT_SELF = 0x2000000;
    public static final int BIT_FILTER = 0x4000000;
    public static final int BIT_ROOT = 0x8000000;
    public static final int BITMASK_TRAVERSES_OUTSIDE_SUBTREE = 0xdf86000;
    public static final int BIT_BACKWARDS_SELF = 0x10000000;
    public static final int BIT_ANY_DESCENDANT_FROM_ROOT = 0x20000000;
    public static final int BIT_NODETEST_ANY = 0x40000000;
    public static final int BIT_MATCH_PATTERN = 0x80000000;
}
