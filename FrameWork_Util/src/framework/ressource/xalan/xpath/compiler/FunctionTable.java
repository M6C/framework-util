// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FunctionTable.java

package framework.ressource.xalan.xpath.compiler;

import java.util.HashMap;
import javax.xml.transform.TransformerException;
import framework.ressource.xalan.xpath.functions.Function;

public class FunctionTable
{

    public FunctionTable()
    {
        m_functions_customer = new Class[30];
        m_functionID_customer = new HashMap();
        m_funcNextFreeIndex = 37;
    }

    String getFunctionName(int funcID)
    {
        if(funcID < 37)
            return m_functions[funcID].getName();
        else
            return m_functions_customer[funcID - 37].getName();
    }

    Function getFunction(int which)
        throws TransformerException
    {
        try
        {
            if(which < 37)
                return (Function)m_functions[which].newInstance();
            else
                return (Function)m_functions_customer[which - 37].newInstance();
        }
        catch(IllegalAccessException ex)
        {
            throw new TransformerException(ex.getMessage());
        }
        catch(InstantiationException ex)
        {
            throw new TransformerException(ex.getMessage());
        }
    }

    Object getFunctionID(String key)
    {
        Object id = m_functionID_customer.get(key);
        if(null == id)
            id = m_functionID.get(key);
        return id;
    }

    public int installFunction(String name, Class func)
    {
        Object funcIndexObj = getFunctionID(name);
        int funcIndex;
        if(null != funcIndexObj)
        {
            funcIndex = ((Integer)funcIndexObj).intValue();
            if(funcIndex < 37)
            {
                funcIndex = m_funcNextFreeIndex++;
                m_functionID_customer.put(name, new Integer(funcIndex));
            }
            m_functions_customer[funcIndex - 37] = func;
        } else
        {
            funcIndex = m_funcNextFreeIndex++;
            m_functions_customer[funcIndex - 37] = func;
            m_functionID_customer.put(name, new Integer(funcIndex));
        }
        return funcIndex;
    }

    public boolean functionAvailable(String methName)
    {
        Object tblEntry = m_functionID.get(methName);
        if(null != tblEntry)
        {
            return true;
        } else
        {
            tblEntry = m_functionID_customer.get(methName);
            return null != tblEntry;
        }
    }

    static Class _mthclass$(String x0)
    {
        try
        {
            return Class.forName(x0);
        }
        catch(ClassNotFoundException x1)
        {
            throw new NoClassDefFoundError(x1.getMessage());
        }
    }

    public static final int FUNC_CURRENT = 0;
    public static final int FUNC_LAST = 1;
    public static final int FUNC_POSITION = 2;
    public static final int FUNC_COUNT = 3;
    public static final int FUNC_ID = 4;
    public static final int FUNC_KEY = 5;
    public static final int FUNC_LOCAL_PART = 7;
    public static final int FUNC_NAMESPACE = 8;
    public static final int FUNC_QNAME = 9;
    public static final int FUNC_GENERATE_ID = 10;
    public static final int FUNC_NOT = 11;
    public static final int FUNC_TRUE = 12;
    public static final int FUNC_FALSE = 13;
    public static final int FUNC_BOOLEAN = 14;
    public static final int FUNC_NUMBER = 15;
    public static final int FUNC_FLOOR = 16;
    public static final int FUNC_CEILING = 17;
    public static final int FUNC_ROUND = 18;
    public static final int FUNC_SUM = 19;
    public static final int FUNC_STRING = 20;
    public static final int FUNC_STARTS_WITH = 21;
    public static final int FUNC_CONTAINS = 22;
    public static final int FUNC_SUBSTRING_BEFORE = 23;
    public static final int FUNC_SUBSTRING_AFTER = 24;
    public static final int FUNC_NORMALIZE_SPACE = 25;
    public static final int FUNC_TRANSLATE = 26;
    public static final int FUNC_CONCAT = 27;
    public static final int FUNC_SUBSTRING = 29;
    public static final int FUNC_STRING_LENGTH = 30;
    public static final int FUNC_SYSTEM_PROPERTY = 31;
    public static final int FUNC_LANG = 32;
    public static final int FUNC_EXT_FUNCTION_AVAILABLE = 33;
    public static final int FUNC_EXT_ELEM_AVAILABLE = 34;
    public static final int FUNC_UNPARSED_ENTITY_URI = 36;
    public static final int FUNC_DOCLOCATION = 35;
    private static Class m_functions[];
    private static HashMap m_functionID;
    private Class m_functions_customer[];
    private HashMap m_functionID_customer;
    private static final int NUM_BUILT_IN_FUNCS = 37;
    private static final int NUM_ALLOWABLE_ADDINS = 30;
    private int m_funcNextFreeIndex;

    static 
    {
        m_functionID = new HashMap();
        m_functions = new Class[37];
        m_functions[0] = framework.ressource.xalan.xpath.functions.FuncCurrent.class;
        m_functions[1] = framework.ressource.xalan.xpath.functions.FuncLast.class;
        m_functions[2] = framework.ressource.xalan.xpath.functions.FuncPosition.class;
        m_functions[3] = framework.ressource.xalan.xpath.functions.FuncCount.class;
        m_functions[4] = framework.ressource.xalan.xpath.functions.FuncId.class;
        m_functions[5] = org.apache.xalan.templates.FuncKey.class;
        m_functions[7] = framework.ressource.xalan.xpath.functions.FuncLocalPart.class;
        m_functions[8] = framework.ressource.xalan.xpath.functions.FuncNamespace.class;
        m_functions[9] = framework.ressource.xalan.xpath.functions.FuncQname.class;
        m_functions[10] = framework.ressource.xalan.xpath.functions.FuncGenerateId.class;
        m_functions[11] = framework.ressource.xalan.xpath.functions.FuncNot.class;
        m_functions[12] = framework.ressource.xalan.xpath.functions.FuncTrue.class;
        m_functions[13] = framework.ressource.xalan.xpath.functions.FuncFalse.class;
        m_functions[14] = framework.ressource.xalan.xpath.functions.FuncBoolean.class;
        m_functions[32] = framework.ressource.xalan.xpath.functions.FuncLang.class;
        m_functions[15] = framework.ressource.xalan.xpath.functions.FuncNumber.class;
        m_functions[16] = framework.ressource.xalan.xpath.functions.FuncFloor.class;
        m_functions[17] = framework.ressource.xalan.xpath.functions.FuncCeiling.class;
        m_functions[18] = framework.ressource.xalan.xpath.functions.FuncRound.class;
        m_functions[19] = framework.ressource.xalan.xpath.functions.FuncSum.class;
        m_functions[20] = framework.ressource.xalan.xpath.functions.FuncString.class;
        m_functions[21] = framework.ressource.xalan.xpath.functions.FuncStartsWith.class;
        m_functions[22] = framework.ressource.xalan.xpath.functions.FuncContains.class;
        m_functions[23] = framework.ressource.xalan.xpath.functions.FuncSubstringBefore.class;
        m_functions[24] = framework.ressource.xalan.xpath.functions.FuncSubstringAfter.class;
        m_functions[25] = framework.ressource.xalan.xpath.functions.FuncNormalizeSpace.class;
        m_functions[26] = framework.ressource.xalan.xpath.functions.FuncTranslate.class;
        m_functions[27] = framework.ressource.xalan.xpath.functions.FuncConcat.class;
        m_functions[31] = framework.ressource.xalan.xpath.functions.FuncSystemProperty.class;
        m_functions[33] = framework.ressource.xalan.xpath.functions.FuncExtFunctionAvailable.class;
        m_functions[34] = framework.ressource.xalan.xpath.functions.FuncExtElementAvailable.class;
        m_functions[29] = framework.ressource.xalan.xpath.functions.FuncSubstring.class;
        m_functions[30] = framework.ressource.xalan.xpath.functions.FuncStringLength.class;
        m_functions[35] = framework.ressource.xalan.xpath.functions.FuncDoclocation.class;
        m_functions[36] = framework.ressource.xalan.xpath.functions.FuncUnparsedEntityURI.class;
        m_functionID.put("current", new Integer(0));
        m_functionID.put("last", new Integer(1));
        m_functionID.put("position", new Integer(2));
        m_functionID.put("count", new Integer(3));
        m_functionID.put("id", new Integer(4));
        m_functionID.put("key", new Integer(5));
        m_functionID.put("local-name", new Integer(7));
        m_functionID.put("namespace-uri", new Integer(8));
        m_functionID.put("name", new Integer(9));
        m_functionID.put("generate-id", new Integer(10));
        m_functionID.put("not", new Integer(11));
        m_functionID.put("true", new Integer(12));
        m_functionID.put("false", new Integer(13));
        m_functionID.put("boolean", new Integer(14));
        m_functionID.put("lang", new Integer(32));
        m_functionID.put("number", new Integer(15));
        m_functionID.put("floor", new Integer(16));
        m_functionID.put("ceiling", new Integer(17));
        m_functionID.put("round", new Integer(18));
        m_functionID.put("sum", new Integer(19));
        m_functionID.put("string", new Integer(20));
        m_functionID.put("starts-with", new Integer(21));
        m_functionID.put("contains", new Integer(22));
        m_functionID.put("substring-before", new Integer(23));
        m_functionID.put("substring-after", new Integer(24));
        m_functionID.put("normalize-space", new Integer(25));
        m_functionID.put("translate", new Integer(26));
        m_functionID.put("concat", new Integer(27));
        m_functionID.put("system-property", new Integer(31));
        m_functionID.put("function-available", new Integer(33));
        m_functionID.put("element-available", new Integer(34));
        m_functionID.put("substring", new Integer(29));
        m_functionID.put("string-length", new Integer(30));
        m_functionID.put("unparsed-entity-uri", new Integer(36));
        m_functionID.put("document-location", new Integer(35));
    }
}
