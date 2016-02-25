// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPATHErrorResources_es.java

package framework.ressource.xalan.xpath.res;

import java.util.*;

// Referenced classes of package framework.ressource.xalan.xpath.res:
//            XPATHErrorResources

public class XPATHErrorResources_es extends ListResourceBundle
{

    public XPATHErrorResources_es()
    {
    }

    public Object[][] getContents()
    {
        return (new Object[][] {
            new Object[] {
                "ERROR0000", "{0}"
            }, new Object[] {
                "ER_CURRENT_NOT_ALLOWED_IN_MATCH", "No est\341 permitida la funci\363n current() en un patr\363n de coincidencia."
            }, new Object[] {
                "ER_CURRENT_TAKES_NO_ARGS", "La funci\363n current() no acepta argumentos."
            }, new Object[] {
                "ER_DOCUMENT_REPLACED", "La implementaci\363n de la funci\363n document() ha sido sustituida por org.apache.xalan.xslt.FuncDocument."
            }, new Object[] {
                "ER_CONTEXT_HAS_NO_OWNERDOC", "El contexto no tiene un documento propietario."
            }, new Object[] {
                "ER_LOCALNAME_HAS_TOO_MANY_ARGS", "local-name() tiene demasiados argumentos."
            }, new Object[] {
                "ER_NAMESPACEURI_HAS_TOO_MANY_ARGS", "namespace-uri() tiene demasiados argumentos."
            }, new Object[] {
                "ER_NORMALIZESPACE_HAS_TOO_MANY_ARGS", "normalize-space() tiene demasiados argumentos."
            }, new Object[] {
                "ER_NUMBER_HAS_TOO_MANY_ARGS", "number() tiene demasiados argumentos."
            }, new Object[] {
                "ER_NAME_HAS_TOO_MANY_ARGS", "name() tiene demasiados argumentos."
            }, new Object[] {
                "ER_STRING_HAS_TOO_MANY_ARGS", "string() tiene demasiados argumentos."
            }, new Object[] {
                "ER_STRINGLENGTH_HAS_TOO_MANY_ARGS", "string-length() tiene demasiados argumentos."
            }, new Object[] {
                "ER_TRANSLATE_TAKES_3_ARGS", "La funci\363n translate() utiliza tres argumentos."
            }, new Object[] {
                "ER_UNPARSEDENTITYURI_TAKES_1_ARG", "La funci\363n unparsed-entity-uri deber\355a utilizar un solo argumento."
            }, new Object[] {
                "ER_NAMESPACEAXIS_NOT_IMPLEMENTED", "Eje de espacio de nombres a\372n no implementado."
            }, new Object[] {
                "ER_UNKNOWN_AXIS", "Eje desconocido: {0}"
            }, new Object[] {
                "ER_UNKNOWN_MATCH_OPERATION", "Operaci\363n de coincidencia desconocida."
            }, new Object[] {
                "ER_INCORRECT_ARG_LENGTH", "La longitud del argumento de prueba del nodo processing-instruction() es incorrecta."
            }, new Object[] {
                "ER_CANT_CONVERT_TO_NUMBER", "No se puede convertir {0} a un n\372mero"
            }, new Object[] {
                "ER_CANT_CONVERT_TO_NODELIST", "No se puede convertir {0} a NodeList."
            }, new Object[] {
                "ER_CANT_CONVERT_TO_MUTABLENODELIST", "No se puede convertir {0} a NodeSetDTM."
            }, new Object[] {
                "ER_CANT_CONVERT_TO_TYPE", "No se puede convertir {0} a un tipo {1}"
            }, new Object[] {
                "ER_EXPECTED_MATCH_PATTERN", "Se esperaba un patr\363n de coincidencia en getMatchScore."
            }, new Object[] {
                "ER_COULDNOT_GET_VAR_NAMED", "No se ha podido obtener la variable de nombre {0}"
            }, new Object[] {
                "ER_UNKNOWN_OPCODE", "ERROR. C\363digo de operaci\363n desconocido: {0}"
            }, new Object[] {
                "ER_EXTRA_ILLEGAL_TOKENS", "Se\361ales extra no permitidas: {0}"
            }, new Object[] {
                "ER_EXPECTED_DOUBLE_QUOTE", "Literal sin entrecomillar... Se esperaban comillas dobles."
            }, new Object[] {
                "ER_EXPECTED_SINGLE_QUOTE", "Literal sin entrecomillar... Se esperaban comillas simples."
            }, new Object[] {
                "ER_EMPTY_EXPRESSION", "Expresi\363n vac\355a."
            }, new Object[] {
                "ER_EXPECTED_BUT_FOUND", "Se esperaba {0}, pero se ha encontrado: {1}"
            }, new Object[] {
                "ER_INCORRECT_PROGRAMMER_ASSERTION", "La aserci\363n del programador es incorrecta. - {0}"
            }, new Object[] {
                "ER_BOOLEAN_ARG_NO_LONGER_OPTIONAL", "El argumento boolean(...) ya no es opcional con el borrador de XPath 19990709."
            }, new Object[] {
                "ER_FOUND_COMMA_BUT_NO_PRECEDING_ARG", "Se ha encontrado ',' pero sin argumento precedente."
            }, new Object[] {
                "ER_FOUND_COMMA_BUT_NO_FOLLOWING_ARG", "Se ha encontrado ',' pero sin argumento siguiente."
            }, new Object[] {
                "ER_PREDICATE_ILLEGAL_SYNTAX", "'..[predicate]' o '.[predicate]' es una sintaxis no permitida. Utilice 'self::node()[predicate]' en su lugar."
            }, new Object[] {
                "ER_ILLEGAL_AXIS_NAME", "Nombre de eje no permitido: {0}"
            }, new Object[] {
                "ER_UNKNOWN_NODETYPE", "nodetype desconocido: {0}"
            }, new Object[] {
                "ER_PATTERN_LITERAL_NEEDS_BE_QUOTED", "El literal del patr\363n ({0}) tiene que estar entrecomillado."
            }, new Object[] {
                "ER_COULDNOT_BE_FORMATTED_TO_NUMBER", "No se ha podido formatear {0} como un n\372mero."
            }, new Object[] {
                "ER_COULDNOT_CREATE_XMLPROCESSORLIAISON", "No se ha podido crear Liaison TransformerFactory XML: {0}"
            }, new Object[] {
                "ER_DIDNOT_FIND_XPATH_SELECT_EXP", "Error. No se ha encontrado la expresi\363n de selecci\363n (-select) de xpath."
            }, new Object[] {
                "ER_COULDNOT_FIND_ENDOP_AFTER_OPLOCATIONPATH", "ERROR. No se ha podido encontrar ENDOP despu\351s de OP_LOCATIONPATH"
            }, new Object[] {
                "ER_ERROR_OCCURED", "Se ha producido un error."
            }, new Object[] {
                "ER_ILLEGAL_VARIABLE_REFERENCE", "VariableReference dada para la variable est\341 fuera de contexto o sin definici\363n.  Nombre = {0}"
            }, new Object[] {
                "ER_AXES_NOT_ALLOWED", "S\363lo se permiten los ejes child:: y attribute:: en patrones de coincidencia.  Ejes incorrectos = {0}"
            }, new Object[] {
                "ER_KEY_HAS_TOO_MANY_ARGS", "key() tiene un n\372mero incorrecto de argumentos."
            }, new Object[] {
                "ER_COUNT_TAKES_1_ARG", "La funci\363n count deber\355a utilizar un solo argumento."
            }, new Object[] {
                "ER_COULDNOT_FIND_FUNCTION", "No se ha podido encontrar la funci\363n: {0}"
            }, new Object[] {
                "ER_UNSUPPORTED_ENCODING", "Codificaci\363n no soportada: {0}"
            }, new Object[] {
                "ER_PROBLEM_IN_DTM_NEXTSIBLING", "Se ha producido un problema en DTM en getNextSibling... Intentando recuperar"
            }, new Object[] {
                "ER_CANNOT_WRITE_TO_EMPTYNODELISTIMPL", "Error del programador: No se puede escribir enEmptyNodeList."
            }, new Object[] {
                "ER_SETDOMFACTORY_NOT_SUPPORTED", "setDOMFactory no soportada por XPathContext."
            }, new Object[] {
                "ER_PREFIX_MUST_RESOLVE", "El prefijo debe resolverse como un espacio de nombres: {0}"
            }, new Object[] {
                "ER_PARSE_NOT_SUPPORTED", "parse (InputSource source) no soportada en XPathContext. No se puede abrir {0}"
            }, new Object[] {
                "ER_SAX_API_NOT_HANDLED", "API SAX characters(char ch[]... no manejada por DTM."
            }, new Object[] {
                "ER_IGNORABLE_WHITESPACE_NOT_HANDLED", "ignorableWhitespace(char ch[]... no manejada por DTM."
            }, new Object[] {
                "ER_DTM_CANNOT_HANDLE_NODES", "DTMLiaison no puede manejar nodos de tipo {0}"
            }, new Object[] {
                "ER_XERCES_CANNOT_HANDLE_NODES", "DOM2Helper no puede manejar nodos de tipo {0}"
            }, new Object[] {
                "ER_XERCES_PARSE_ERROR_DETAILS", "Error DOM2Helper.parse: SystemID - {0} l\355nea - {1}"
            }, new Object[] {
                "ER_XERCES_PARSE_ERROR", "Error DOM2Helper.parse"
            }, new Object[] {
                "ER_INVALID_UTF16_SURROGATE", "\277Se ha detectado un sustituto UTF-16 no v\341lido: {0}?"
            }, new Object[] {
                "ER_OIERROR", "Error de ES"
            }, new Object[] {
                "ER_CANNOT_CREATE_URL", "No se puede crear url para: {0}"
            }, new Object[] {
                "ER_XPATH_READOBJECT", "En XPath.readObject: {0}"
            }, new Object[] {
                "ER_FUNCTION_TOKEN_NOT_FOUND", "Se\361al de funci\363n no encontrada."
            }, new Object[] {
                "ER_CANNOT_DEAL_XPATH_TYPE", "No se puede tratar con el tipo XPath: {0}"
            }, new Object[] {
                "ER_NODESET_NOT_MUTABLE", "Este NodeSet no es mutable"
            }, new Object[] {
                "ER_NODESETDTM_NOT_MUTABLE", "Este NodeSetDTM no es mutable"
            }, new Object[] {
                "ER_VAR_NOT_RESOLVABLE", "Variable no resoluble: {0}"
            }, new Object[] {
                "ER_NULL_ERROR_HANDLER", "Manejador de error nulo"
            }, new Object[] {
                "ER_PROG_ASSERT_UNKNOWN_OPCODE", "Aserci\363n del programador: opcode desconocido: {0} "
            }, new Object[] {
                "ER_ZERO_OR_ONE", "0 \363 1"
            }, new Object[] {
                "ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "rtf() no soportada por XRTreeFragSelectWrapper"
            }, new Object[] {
                "ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "asNodeIterator() no soportada por XRTreeFragSelectWrapper"
            }, new Object[] {
                "ER_DETACH_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "detach() no soportada por XRTreeFragSelectWrapper "
            }, new Object[] {
                "ER_NUM_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "num() no soportada por XRTreeFragSelectWrapper"
            }, new Object[] {
                "ER_XSTR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "xstr() no soportada por XRTreeFragSelectWrapper "
            }, new Object[] {
                "ER_STR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "str() no soportada por XRTreeFragSelectWrapper"
            }, new Object[] {
                "ER_FSB_NOT_SUPPORTED_XSTRINGFORCHARS", "fsb() no soportada para XStringForChars"
            }, new Object[] {
                "ER_COULD_NOT_FIND_VAR", "No se ha podido encontrar la variable con el nombre {0}"
            }, new Object[] {
                "ER_XSTRINGFORCHARS_CANNOT_TAKE_STRING", "XStringForChars no puede utilizar una serie para un argumento"
            }, new Object[] {
                "ER_FASTSTRINGBUFFER_CANNOT_BE_NULL", "El argumento FastStringBuffer no puede ser nulo"
            }, new Object[] {
                "ER_TWO_OR_THREE", "2 \363 3"
            }, new Object[] {
                "ER_VARIABLE_ACCESSED_BEFORE_BIND", "Se ha accedido a la variable antes de enlazarla."
            }, new Object[] {
                "ER_FSB_CANNOT_TAKE_STRING", "XStringForFSB no puede utilizar una serie para un argumento."
            }, new Object[] {
                "ER_SETTING_WALKER_ROOT_TO_NULL", "\n Error. Estableciendo ra\355z de walker como nulo."
            }, new Object[] {
                "ER_NODESETDTM_CANNOT_ITERATE", "Este NodeSetDTM no puede iterar a un nodo previo."
            }, new Object[] {
                "ER_NODESET_CANNOT_ITERATE", "Este NodeSet no puede iterar a un nodo previo."
            }, new Object[] {
                "ER_NODESETDTM_CANNOT_INDEX", "Este NodeSetDTM no puede realizar funciones de indexaci\363n o recuento."
            }, new Object[] {
                "ER_NODESET_CANNOT_INDEX", "Este NodeSet no puede realizar funciones de indexaci\363n o recuento."
            }, new Object[] {
                "ER_CANNOT_CALL_SETSHOULDCACHENODE", "No se puede llamar a setShouldCacheNodes despu\351s de llamar a nextNode."
            }, new Object[] {
                "ER_ONLY_ALLOWS", "{0} s\363lo admite {1} argumentos"
            }, new Object[] {
                "ER_UNKNOWN_STEP", "Aserci\363n del programador en getNextStepPos: stepType desconocido: {0} "
            }, new Object[] {
                "ER_EXPECTED_REL_LOC_PATH", "Se esperaba una v\355a de acceso de ubicaci\363n relativa despu\351s de la se\361al '/' o '//'."
            }, new Object[] {
                "ER_EXPECTED_LOC_PATH", "Se esperaba una v\355a de acceso de ubicaci\363n, pero se ha encontrado la se\361al siguiente:  {0}"
            }, new Object[] {
                "ER_EXPECTED_LOC_PATH_AT_END_EXPR", "Se esperaba una v\355a de acceso de ubicaci\363n, pero en su lugar se ha encontrado el final de la expresi\363n XPath."
            }, new Object[] {
                "ER_EXPECTED_LOC_STEP", "Se esperaba un paso de ubicaci\363n despu\351s de la se\361al '/' o '//'."
            }, new Object[] {
                "ER_EXPECTED_NODE_TEST", "Se esperaba una prueba de nodo coincidente con NCName:* o QName."
            }, new Object[] {
                "ER_EXPECTED_STEP_PATTERN", "Se esperaba un patr\363n de paso, pero se ha encontrado '/'."
            }, new Object[] {
                "ER_EXPECTED_REL_PATH_PATTERN", "Se esperaba un patr\363n de v\355a de acceso relativa."
            }, new Object[] {
                "ER_CANT_CONVERT_TO_BOOLEAN", "XPathResult de la expresi\363n XPath ''{0}'' tiene un XPathResultType de {1} que no se puede convertir a booleano."
            }, new Object[] {
                "ER_CANT_CONVERT_TO_SINGLENODE", "XPathResult de la expresi\363n XPath ''{0}'' tiene un XPathResultType de {1} que no se puede convertir a un solo nodo. El m\351todo getSingleNodeValue se aplica s\363lo a tipos ANY_UNORDERED_NODE_TYPE and FIRST_ORDERED_NODE_TYPE."
            }, new Object[] {
                "ER_CANT_GET_SNAPSHOT_LENGTH", "No se puede llamar al m\351todo getSnapshotLength en XPathResult de la expresi\363n XPath ''{0}'' porque su XPathResultType es {1}. Este m\351todo se aplica s\363lo a los tipos UNORDERED_NODE_SNAPSHOT_TYPE y ORDERED_NODE_SNAPSHOT_TYPE. "
            }, new Object[] {
                "ER_NON_ITERATOR_TYPE", "No se puede llamar al m\351todo iterateNext en XPathResult de la expresi\363n XPath ''{0}'' porque su XPathResultType es {1}. Este m\351todo se aplica s\363lo a los tipos UNORDERED_NODE_ITERATOR_TYPE y ORDERED_NODE_ITERATOR_TYPE. "
            }, new Object[] {
                "ER_DOC_MUTATED", "El documento ha mutado desde que se devolvi\363 el resultado. El iterador no es v\341lido."
            }, new Object[] {
                "ER_INVALID_XPATH_TYPE", "Argumento de tipo XPath no v\341lido: {0}"
            }, new Object[] {
                "ER_EMPTY_XPATH_RESULT", "Objeto de resultado XPath vac\355o"
            }, new Object[] {
                "ER_INCOMPATIBLE_TYPES", "XPathResult de la expresi\363n XPath ''{0}'' tiene un XPathResultType de {1} que no se puede forzar al  XPathResultType especificado de {2}"
            }, new Object[] {
                "ER_NULL_RESOLVER", "Imposible resolver prefijo con un solucionador de prefijo nulo."
            }, new Object[] {
                "ER_CANT_CONVERT_TO_STRING", "XPathResult de la expresi\363n XPath ''{0}'' tiene un XPathResultType de {1} que no se puede convertir a una serie."
            }, new Object[] {
                "ER_NON_SNAPSHOT_TYPE", "No se puede llamar al m\351todo snapshotItem en XPathResult de la expresi\363n XPath ''{0}'' porque su XPathResultType es {1}. Este m\351todo se aplica s\363lo a los tipos UNORDERED_NODE_SNAPSHOT_TYPE y ORDERED_NODE_SNAPSHOT_TYPE. "
            }, new Object[] {
                "ER_WRONG_DOCUMENT", "El nodo de contexto no pertenece al documento que est\341 enlazado a este XPathEvaluator."
            }, new Object[] {
                "ER_WRONG_NODETYPE", "El tipo de nodo de contexto no est\341 soportado."
            }, new Object[] {
                "ER_XPATH_ERROR", "Error desconocido en XPath."
            }, new Object[] {
                "ER_CANT_CONVERT_XPATHRESULTTYPE_TO_NUMBER", "XPathResult de la expresi\363n XPath ''{0}'' tiene un XPathResultType de {1} que no se puede convertir a un n\372mero."
            }, new Object[] {
                "ER_EXTENSION_FUNCTION_CANNOT_BE_INVOKED", "La funci\363n de extensi\363n: ''{0}'' no se puede invocar si la caracter\355stica XMLConstants.FEATURE_SECURE_PROCESSING est\341 establecida en true."
            }, new Object[] {
                "ER_RESOLVE_VARIABLE_RETURNS_NULL", "resolveVariable para la variable {0} devuelve null"
            }, new Object[] {
                "ER_UNSUPPORTED_RETURN_TYPE", "Tipo devuelto no soportado : {0}"
            }, new Object[] {
                "ER_SOURCE_RETURN_TYPE_CANNOT_BE_NULL", "El tipo de origen y/o devuelto no puede ser null"
            }, new Object[] {
                "ER_ARG_CANNOT_BE_NULL", "El argumento {0} no puede ser null"
            }, new Object[] {
                "ER_OBJECT_MODEL_NULL", "No se puede llamar a {0}#isObjectModelSupported( String objectModel ) con objectModel == null"
            }, new Object[] {
                "ER_OBJECT_MODEL_EMPTY", "No se puede llamar a {0}#isObjectModelSupported( String objectModel ) con objectModel == \"\""
            }, new Object[] {
                "ER_FEATURE_NAME_NULL", "Se ha intentado establecer una caracter\355stica con un nombre null: {0}#setFeature( null, {1})"
            }, new Object[] {
                "ER_FEATURE_UNKNOWN", "Se ha intentado establecer la caracter\355stica \"{0}\":{1}#setFeature({0},{2}) desconocida"
            }, new Object[] {
                "ER_GETTING_NULL_FEATURE", "Se ha intentado obtener una caracter\355stica con un nombre null: {0}#getFeature(null)"
            }, new Object[] {
                "ER_GETTING_UNKNOWN_FEATURE", "Se ha intentado obtener la caracter\355stica desconocida \"{0}\":{1}#getFeature({0})"
            }, new Object[] {
                "ER_NULL_XPATH_FUNCTION_RESOLVER", "Se ha intentado establecer un XPathFunctionResolver:{0}#setXPathFunctionResolver(null) null"
            }, new Object[] {
                "ER_NULL_XPATH_VARIABLE_RESOLVER", "Se ha intentado establecer un XPathVariableResolver:{0}#setXPathVariableResolver(null) null"
            }, new Object[] {
                "WG_LOCALE_NAME_NOT_HANDLED", "No se maneja a\372n el nombre de entorno local en la funci\363n format-number."
            }, new Object[] {
                "WG_PROPERTY_NOT_SUPPORTED", "Propiedad XSL no soportada: {0}"
            }, new Object[] {
                "WG_DONT_DO_ANYTHING_WITH_NS", "No hacer nada actualmente con el espacio de nombres {0} en la propiedad: {1}"
            }, new Object[] {
                "WG_SECURITY_EXCEPTION", "SecurityException al intentar acceder a la propiedad del sistema XSL: {0}"
            }, new Object[] {
                "WG_QUO_NO_LONGER_DEFINED", "La antigua sintaxis: quo(...) ya no est\341 definida en XPath."
            }, new Object[] {
                "WG_NEED_DERIVED_OBJECT_TO_IMPLEMENT_NODETEST", "XPath necesita un objeto derivado para implementar nodeTest."
            }, new Object[] {
                "WG_FUNCTION_TOKEN_NOT_FOUND", "Se\361al de funci\363n no encontrada."
            }, new Object[] {
                "WG_COULDNOT_FIND_FUNCTION", "No se ha podido encontrar la funci\363n: {0}"
            }, new Object[] {
                "WG_CANNOT_MAKE_URL_FROM", "No se puede crear URL desde: {0}"
            }, new Object[] {
                "WG_EXPAND_ENTITIES_NOT_SUPPORTED", "Opci\363n -E no soportada para analizador DTM"
            }, new Object[] {
                "WG_ILLEGAL_VARIABLE_REFERENCE", "VariableReference dada para la variable est\341 fuera de contexto o sin definici\363n  Nombre = {0}"
            }, new Object[] {
                "WG_UNSUPPORTED_ENCODING", "Codificaci\363n no soportada: {0}"
            }, new Object[] {
                "ui_language", "es"
            }, new Object[] {
                "help_language", "es"
            }, new Object[] {
                "language", "es"
            }, new Object[] {
                "BAD_CODE", "El par\341metro para createMessage estaba fuera de los l\355mites"
            }, new Object[] {
                "FORMAT_FAILED", "Se ha generado una excepci\363n durante la llamada messageFormat"
            }, new Object[] {
                "version", ">>>>>>> Xalan versi\363n "
            }, new Object[] {
                "version2", "<<<<<<<"
            }, new Object[] {
                "yes", "s\355"
            }, new Object[] {
                "line", "L\355nea n\372m."
            }, new Object[] {
                "column", "Columna n\372m."
            }, new Object[] {
                "xsldone", "XSLProcessor: terminado"
            }, new Object[] {
                "xpath_option", "Opciones de xpath: "
            }, new Object[] {
                "optionIN", "[-in URLXMLEntrada]"
            }, new Object[] {
                "optionSelect", "[-select expresi\363n xpath]"
            }, new Object[] {
                "optionMatch", "[-match patr\363n de coincidencia (para diagn\363sticos de coincidencia)]"
            }, new Object[] {
                "optionAnyExpr", "O simplemente una expresi\363n xpath realizar\341 un vuelco de diagn\363stico"
            }, new Object[] {
                "noParsermsg1", "El proceso XSL no ha sido satisfactorio."
            }, new Object[] {
                "noParsermsg2", "** No se ha podido encontrar el analizador **"
            }, new Object[] {
                "noParsermsg3", "Compruebe la classpath."
            }, new Object[] {
                "noParsermsg4", "Si no dispone del analizador XML para Java de IBM, puede descargarlo de"
            }, new Object[] {
                "noParsermsg5", "IBM AlphaWorks: http://www.alphaworks.ibm.com/formula/xml"
            }, new Object[] {
                "gtone", ">1"
            }, new Object[] {
                "zero", "0"
            }, new Object[] {
                "one", "1"
            }, new Object[] {
                "two", "2"
            }, new Object[] {
                "three", "3"
            }
        });
    }

    public static final XPATHErrorResources loadResourceBundle(String className)
        throws MissingResourceException
    {
        Locale locale = Locale.getDefault();
        String suffix = getResourceSuffix(locale);
        try
        {
            return (XPATHErrorResources)ResourceBundle.getBundle(className + suffix, locale);
        }
        catch(MissingResourceException e) { }
        try
        {
            return (XPATHErrorResources)ResourceBundle.getBundle(className, new Locale("es", "ES"));
        }
        catch(MissingResourceException e2)
        {
            throw new MissingResourceException("Could not load any resource bundles.", className, "");
        }
    }

    private static final String getResourceSuffix(Locale locale)
    {
        String suffix = "_" + locale.getLanguage();
        String country = locale.getCountry();
        if(country.equals("TW"))
            suffix = suffix + "_" + country;
        return suffix;
    }

    public static final String ERROR0000 = "ERROR0000";
    public static final String ER_CURRENT_NOT_ALLOWED_IN_MATCH = "ER_CURRENT_NOT_ALLOWED_IN_MATCH";
    public static final String ER_CURRENT_TAKES_NO_ARGS = "ER_CURRENT_TAKES_NO_ARGS";
    public static final String ER_DOCUMENT_REPLACED = "ER_DOCUMENT_REPLACED";
    public static final String ER_CONTEXT_HAS_NO_OWNERDOC = "ER_CONTEXT_HAS_NO_OWNERDOC";
    public static final String ER_LOCALNAME_HAS_TOO_MANY_ARGS = "ER_LOCALNAME_HAS_TOO_MANY_ARGS";
    public static final String ER_NAMESPACEURI_HAS_TOO_MANY_ARGS = "ER_NAMESPACEURI_HAS_TOO_MANY_ARGS";
    public static final String ER_NORMALIZESPACE_HAS_TOO_MANY_ARGS = "ER_NORMALIZESPACE_HAS_TOO_MANY_ARGS";
    public static final String ER_NUMBER_HAS_TOO_MANY_ARGS = "ER_NUMBER_HAS_TOO_MANY_ARGS";
    public static final String ER_NAME_HAS_TOO_MANY_ARGS = "ER_NAME_HAS_TOO_MANY_ARGS";
    public static final String ER_STRING_HAS_TOO_MANY_ARGS = "ER_STRING_HAS_TOO_MANY_ARGS";
    public static final String ER_STRINGLENGTH_HAS_TOO_MANY_ARGS = "ER_STRINGLENGTH_HAS_TOO_MANY_ARGS";
    public static final String ER_TRANSLATE_TAKES_3_ARGS = "ER_TRANSLATE_TAKES_3_ARGS";
    public static final String ER_UNPARSEDENTITYURI_TAKES_1_ARG = "ER_UNPARSEDENTITYURI_TAKES_1_ARG";
    public static final String ER_NAMESPACEAXIS_NOT_IMPLEMENTED = "ER_NAMESPACEAXIS_NOT_IMPLEMENTED";
    public static final String ER_UNKNOWN_AXIS = "ER_UNKNOWN_AXIS";
    public static final String ER_UNKNOWN_MATCH_OPERATION = "ER_UNKNOWN_MATCH_OPERATION";
    public static final String ER_INCORRECT_ARG_LENGTH = "ER_INCORRECT_ARG_LENGTH";
    public static final String ER_CANT_CONVERT_TO_NUMBER = "ER_CANT_CONVERT_TO_NUMBER";
    public static final String ER_CANT_CONVERT_XPATHRESULTTYPE_TO_NUMBER = "ER_CANT_CONVERT_XPATHRESULTTYPE_TO_NUMBER";
    public static final String ER_CANT_CONVERT_TO_NODELIST = "ER_CANT_CONVERT_TO_NODELIST";
    public static final String ER_CANT_CONVERT_TO_MUTABLENODELIST = "ER_CANT_CONVERT_TO_MUTABLENODELIST";
    public static final String ER_CANT_CONVERT_TO_TYPE = "ER_CANT_CONVERT_TO_TYPE";
    public static final String ER_EXPECTED_MATCH_PATTERN = "ER_EXPECTED_MATCH_PATTERN";
    public static final String ER_COULDNOT_GET_VAR_NAMED = "ER_COULDNOT_GET_VAR_NAMED";
    public static final String ER_UNKNOWN_OPCODE = "ER_UNKNOWN_OPCODE";
    public static final String ER_EXTRA_ILLEGAL_TOKENS = "ER_EXTRA_ILLEGAL_TOKENS";
    public static final String ER_EXPECTED_DOUBLE_QUOTE = "ER_EXPECTED_DOUBLE_QUOTE";
    public static final String ER_EXPECTED_SINGLE_QUOTE = "ER_EXPECTED_SINGLE_QUOTE";
    public static final String ER_EMPTY_EXPRESSION = "ER_EMPTY_EXPRESSION";
    public static final String ER_EXPECTED_BUT_FOUND = "ER_EXPECTED_BUT_FOUND";
    public static final String ER_INCORRECT_PROGRAMMER_ASSERTION = "ER_INCORRECT_PROGRAMMER_ASSERTION";
    public static final String ER_BOOLEAN_ARG_NO_LONGER_OPTIONAL = "ER_BOOLEAN_ARG_NO_LONGER_OPTIONAL";
    public static final String ER_FOUND_COMMA_BUT_NO_PRECEDING_ARG = "ER_FOUND_COMMA_BUT_NO_PRECEDING_ARG";
    public static final String ER_FOUND_COMMA_BUT_NO_FOLLOWING_ARG = "ER_FOUND_COMMA_BUT_NO_FOLLOWING_ARG";
    public static final String ER_PREDICATE_ILLEGAL_SYNTAX = "ER_PREDICATE_ILLEGAL_SYNTAX";
    public static final String ER_ILLEGAL_AXIS_NAME = "ER_ILLEGAL_AXIS_NAME";
    public static final String ER_UNKNOWN_NODETYPE = "ER_UNKNOWN_NODETYPE";
    public static final String ER_PATTERN_LITERAL_NEEDS_BE_QUOTED = "ER_PATTERN_LITERAL_NEEDS_BE_QUOTED";
    public static final String ER_COULDNOT_BE_FORMATTED_TO_NUMBER = "ER_COULDNOT_BE_FORMATTED_TO_NUMBER";
    public static final String ER_COULDNOT_CREATE_XMLPROCESSORLIAISON = "ER_COULDNOT_CREATE_XMLPROCESSORLIAISON";
    public static final String ER_DIDNOT_FIND_XPATH_SELECT_EXP = "ER_DIDNOT_FIND_XPATH_SELECT_EXP";
    public static final String ER_COULDNOT_FIND_ENDOP_AFTER_OPLOCATIONPATH = "ER_COULDNOT_FIND_ENDOP_AFTER_OPLOCATIONPATH";
    public static final String ER_ERROR_OCCURED = "ER_ERROR_OCCURED";
    public static final String ER_ILLEGAL_VARIABLE_REFERENCE = "ER_ILLEGAL_VARIABLE_REFERENCE";
    public static final String ER_AXES_NOT_ALLOWED = "ER_AXES_NOT_ALLOWED";
    public static final String ER_KEY_HAS_TOO_MANY_ARGS = "ER_KEY_HAS_TOO_MANY_ARGS";
    public static final String ER_COUNT_TAKES_1_ARG = "ER_COUNT_TAKES_1_ARG";
    public static final String ER_COULDNOT_FIND_FUNCTION = "ER_COULDNOT_FIND_FUNCTION";
    public static final String ER_UNSUPPORTED_ENCODING = "ER_UNSUPPORTED_ENCODING";
    public static final String ER_PROBLEM_IN_DTM_NEXTSIBLING = "ER_PROBLEM_IN_DTM_NEXTSIBLING";
    public static final String ER_CANNOT_WRITE_TO_EMPTYNODELISTIMPL = "ER_CANNOT_WRITE_TO_EMPTYNODELISTIMPL";
    public static final String ER_SETDOMFACTORY_NOT_SUPPORTED = "ER_SETDOMFACTORY_NOT_SUPPORTED";
    public static final String ER_PREFIX_MUST_RESOLVE = "ER_PREFIX_MUST_RESOLVE";
    public static final String ER_PARSE_NOT_SUPPORTED = "ER_PARSE_NOT_SUPPORTED";
    public static final String ER_SAX_API_NOT_HANDLED = "ER_SAX_API_NOT_HANDLED";
    public static final String ER_IGNORABLE_WHITESPACE_NOT_HANDLED = "ER_IGNORABLE_WHITESPACE_NOT_HANDLED";
    public static final String ER_DTM_CANNOT_HANDLE_NODES = "ER_DTM_CANNOT_HANDLE_NODES";
    public static final String ER_XERCES_CANNOT_HANDLE_NODES = "ER_XERCES_CANNOT_HANDLE_NODES";
    public static final String ER_XERCES_PARSE_ERROR_DETAILS = "ER_XERCES_PARSE_ERROR_DETAILS";
    public static final String ER_XERCES_PARSE_ERROR = "ER_XERCES_PARSE_ERROR";
    public static final String ER_INVALID_UTF16_SURROGATE = "ER_INVALID_UTF16_SURROGATE";
    public static final String ER_OIERROR = "ER_OIERROR";
    public static final String ER_CANNOT_CREATE_URL = "ER_CANNOT_CREATE_URL";
    public static final String ER_XPATH_READOBJECT = "ER_XPATH_READOBJECT";
    public static final String ER_FUNCTION_TOKEN_NOT_FOUND = "ER_FUNCTION_TOKEN_NOT_FOUND";
    public static final String ER_CANNOT_DEAL_XPATH_TYPE = "ER_CANNOT_DEAL_XPATH_TYPE";
    public static final String ER_NODESET_NOT_MUTABLE = "ER_NODESET_NOT_MUTABLE";
    public static final String ER_NODESETDTM_NOT_MUTABLE = "ER_NODESETDTM_NOT_MUTABLE";
    public static final String ER_VAR_NOT_RESOLVABLE = "ER_VAR_NOT_RESOLVABLE";
    public static final String ER_NULL_ERROR_HANDLER = "ER_NULL_ERROR_HANDLER";
    public static final String ER_PROG_ASSERT_UNKNOWN_OPCODE = "ER_PROG_ASSERT_UNKNOWN_OPCODE";
    public static final String ER_ZERO_OR_ONE = "ER_ZERO_OR_ONE";
    public static final String ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER = "ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER";
    public static final String ER_ASNODEITERATOR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER = "ER_ASNODEITERATOR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER";
    public static final String ER_FSB_NOT_SUPPORTED_XSTRINGFORCHARS = "ER_FSB_NOT_SUPPORTED_XSTRINGFORCHARS";
    public static final String ER_COULD_NOT_FIND_VAR = "ER_COULD_NOT_FIND_VAR";
    public static final String ER_XSTRINGFORCHARS_CANNOT_TAKE_STRING = "ER_XSTRINGFORCHARS_CANNOT_TAKE_STRING";
    public static final String ER_FASTSTRINGBUFFER_CANNOT_BE_NULL = "ER_FASTSTRINGBUFFER_CANNOT_BE_NULL";
    public static final String ER_TWO_OR_THREE = "ER_TWO_OR_THREE";
    public static final String ER_VARIABLE_ACCESSED_BEFORE_BIND = "ER_VARIABLE_ACCESSED_BEFORE_BIND";
    public static final String ER_FSB_CANNOT_TAKE_STRING = "ER_FSB_CANNOT_TAKE_STRING";
    public static final String ER_SETTING_WALKER_ROOT_TO_NULL = "ER_SETTING_WALKER_ROOT_TO_NULL";
    public static final String ER_NODESETDTM_CANNOT_ITERATE = "ER_NODESETDTM_CANNOT_ITERATE";
    public static final String ER_NODESET_CANNOT_ITERATE = "ER_NODESET_CANNOT_ITERATE";
    public static final String ER_NODESETDTM_CANNOT_INDEX = "ER_NODESETDTM_CANNOT_INDEX";
    public static final String ER_NODESET_CANNOT_INDEX = "ER_NODESET_CANNOT_INDEX";
    public static final String ER_CANNOT_CALL_SETSHOULDCACHENODE = "ER_CANNOT_CALL_SETSHOULDCACHENODE";
    public static final String ER_ONLY_ALLOWS = "ER_ONLY_ALLOWS";
    public static final String ER_UNKNOWN_STEP = "ER_UNKNOWN_STEP";
    public static final String ER_EXPECTED_REL_LOC_PATH = "ER_EXPECTED_REL_LOC_PATH";
    public static final String ER_EXPECTED_LOC_PATH = "ER_EXPECTED_LOC_PATH";
    public static final String ER_EXPECTED_LOC_PATH_AT_END_EXPR = "ER_EXPECTED_LOC_PATH_AT_END_EXPR";
    public static final String ER_EXPECTED_LOC_STEP = "ER_EXPECTED_LOC_STEP";
    public static final String ER_EXPECTED_NODE_TEST = "ER_EXPECTED_NODE_TEST";
    public static final String ER_EXPECTED_STEP_PATTERN = "ER_EXPECTED_STEP_PATTERN";
    public static final String ER_EXPECTED_REL_PATH_PATTERN = "ER_EXPECTED_REL_PATH_PATTERN";
    public static final String ER_CANT_CONVERT_TO_BOOLEAN = "ER_CANT_CONVERT_TO_BOOLEAN";
    public static final String ER_CANT_CONVERT_TO_SINGLENODE = "ER_CANT_CONVERT_TO_SINGLENODE";
    public static final String ER_CANT_GET_SNAPSHOT_LENGTH = "ER_CANT_GET_SNAPSHOT_LENGTH";
    public static final String ER_NON_ITERATOR_TYPE = "ER_NON_ITERATOR_TYPE";
    public static final String ER_DOC_MUTATED = "ER_DOC_MUTATED";
    public static final String ER_INVALID_XPATH_TYPE = "ER_INVALID_XPATH_TYPE";
    public static final String ER_EMPTY_XPATH_RESULT = "ER_EMPTY_XPATH_RESULT";
    public static final String ER_INCOMPATIBLE_TYPES = "ER_INCOMPATIBLE_TYPES";
    public static final String ER_NULL_RESOLVER = "ER_NULL_RESOLVER";
    public static final String ER_CANT_CONVERT_TO_STRING = "ER_CANT_CONVERT_TO_STRING";
    public static final String ER_NON_SNAPSHOT_TYPE = "ER_NON_SNAPSHOT_TYPE";
    public static final String ER_WRONG_DOCUMENT = "ER_WRONG_DOCUMENT";
    public static final String ER_WRONG_NODETYPE = "ER_WRONG_NODETYPE";
    public static final String ER_XPATH_ERROR = "ER_XPATH_ERROR";
    public static final String ER_EXTENSION_FUNCTION_CANNOT_BE_INVOKED = "ER_EXTENSION_FUNCTION_CANNOT_BE_INVOKED";
    public static final String ER_RESOLVE_VARIABLE_RETURNS_NULL = "ER_RESOLVE_VARIABLE_RETURNS_NULL";
    public static final String ER_UNSUPPORTED_RETURN_TYPE = "ER_UNSUPPORTED_RETURN_TYPE";
    public static final String ER_SOURCE_RETURN_TYPE_CANNOT_BE_NULL = "ER_SOURCE_RETURN_TYPE_CANNOT_BE_NULL";
    public static final String ER_ARG_CANNOT_BE_NULL = "ER_ARG_CANNOT_BE_NULL";
    public static final String ER_OBJECT_MODEL_NULL = "ER_OBJECT_MODEL_NULL";
    public static final String ER_OBJECT_MODEL_EMPTY = "ER_OBJECT_MODEL_EMPTY";
    public static final String ER_FEATURE_NAME_NULL = "ER_FEATURE_NAME_NULL";
    public static final String ER_FEATURE_UNKNOWN = "ER_FEATURE_UNKNOWN";
    public static final String ER_GETTING_NULL_FEATURE = "ER_GETTING_NULL_FEATURE";
    public static final String ER_GETTING_UNKNOWN_FEATURE = "ER_GETTING_UNKNOWN_FEATURE";
    public static final String ER_NULL_XPATH_FUNCTION_RESOLVER = "ER_NULL_XPATH_FUNCTION_RESOLVER";
    public static final String ER_NULL_XPATH_VARIABLE_RESOLVER = "ER_NULL_XPATH_VARIABLE_RESOLVER";
    public static final String WG_LOCALE_NAME_NOT_HANDLED = "WG_LOCALE_NAME_NOT_HANDLED";
    public static final String WG_PROPERTY_NOT_SUPPORTED = "WG_PROPERTY_NOT_SUPPORTED";
    public static final String WG_DONT_DO_ANYTHING_WITH_NS = "WG_DONT_DO_ANYTHING_WITH_NS";
    public static final String WG_SECURITY_EXCEPTION = "WG_SECURITY_EXCEPTION";
    public static final String WG_QUO_NO_LONGER_DEFINED = "WG_QUO_NO_LONGER_DEFINED";
    public static final String WG_NEED_DERIVED_OBJECT_TO_IMPLEMENT_NODETEST = "WG_NEED_DERIVED_OBJECT_TO_IMPLEMENT_NODETEST";
    public static final String WG_FUNCTION_TOKEN_NOT_FOUND = "WG_FUNCTION_TOKEN_NOT_FOUND";
    public static final String WG_COULDNOT_FIND_FUNCTION = "WG_COULDNOT_FIND_FUNCTION";
    public static final String WG_CANNOT_MAKE_URL_FROM = "WG_CANNOT_MAKE_URL_FROM";
    public static final String WG_EXPAND_ENTITIES_NOT_SUPPORTED = "WG_EXPAND_ENTITIES_NOT_SUPPORTED";
    public static final String WG_ILLEGAL_VARIABLE_REFERENCE = "WG_ILLEGAL_VARIABLE_REFERENCE";
    public static final String WG_UNSUPPORTED_ENCODING = "WG_UNSUPPORTED_ENCODING";
    public static final String ER_DETACH_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER = "ER_DETACH_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER";
    public static final String ER_NUM_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER = "ER_NUM_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER";
    public static final String ER_XSTR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER = "ER_XSTR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER";
    public static final String ER_STR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER = "ER_STR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER";
    public static final String BAD_CODE = "BAD_CODE";
    public static final String FORMAT_FAILED = "FORMAT_FAILED";
    public static final String ERROR_RESOURCES = "framework.ressource.xalan.xpath.res.XPATHErrorResources";
    public static final String ERROR_STRING = "#error";
    public static final String ERROR_HEADER = "Error: ";
    public static final String WARNING_HEADER = "Aviso: ";
    public static final String XSL_HEADER = "XSL ";
    public static final String XML_HEADER = "XML ";
    public static final String QUERY_HEADER = "PATTERN ";
}
