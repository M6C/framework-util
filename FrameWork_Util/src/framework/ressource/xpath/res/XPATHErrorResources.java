package framework.ressource.xpath.res;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


/**
 * @author  HP_Administrateur
 */
public class XPATHErrorResources extends XResourceBundleBase
{

  /** Field ERROR_SUFFIX          */
  public static final String ERROR_SUFFIX = "ER";

  /** Field WARNING_SUFFIX          */
  public static final String WARNING_SUFFIX = "WR";

  /** Field MAX_CODE          */
  public static final int MAX_CODE = 96;  // this is needed to keep track of the number of messages          

  /** Field MAX_WARNING          */
  public static final int MAX_WARNING = 11;  // this is needed to keep track of the number of warnings

  /** Field MAX_OTHERS          */
  public static final int MAX_OTHERS = 20;

  /** Field MAX_MESSAGES          */
  public static final int MAX_MESSAGES = MAX_CODE + MAX_WARNING + 1;

  /** Field contents          */
  static final Object[][] contents =
    new Object[MAX_MESSAGES + MAX_OTHERS + 1][2];

  /*
  * Now fill in the message keys.
  * This does not need to be updated. If MAX_CODE and MAX_WARNING
  * are correct, the keys will get filled in automatically with
  * the value ERxxxx (WRxxxx for warnings) where xxxx is a
  * formatted number corresponding to the error code (i.e. ER0001).
  */
  static
  {
    for (int i = 0; i < MAX_CODE + 1; i++)
    {
      contents[i][0] = getMKey(i);
    }

    for (int i = 1; i < MAX_WARNING + 1; i++)
    {
      contents[i + MAX_CODE][0] = getWKey(i);
    }
  }

  /*
  * Now fill in the message text.
  * First create an int for the message code. Make sure you
  * update MAX_CODE for error messages and MAX_WARNING for warnings
  * Then fill in the message text for that message code in the
  * array. Use the new error code as the index into the array.
  */

  // Error messages...

  /** Field ERROR0000          */
  public static final int ERROR0000 = 0;

  static
  {
    contents[ERROR0000][1] = "{0}";
  }

  /** Field ER_CURRENT_NOT_ALLOWED_IN_MATCH          */
  public static final int ER_CURRENT_NOT_ALLOWED_IN_MATCH = 1;

  static
  {
    contents[ER_CURRENT_NOT_ALLOWED_IN_MATCH][1] =
      "Funktionen current() \u00e4r inte till\u00e5ten i ett matchningsm\u00f6nster!";
  }

  /** Field ER_CURRENT_TAKES_NO_ARGS          */
  public static final int ER_CURRENT_TAKES_NO_ARGS = 2;

  static
  {
    contents[ER_CURRENT_TAKES_NO_ARGS][1] =
      "Funktionen current() tar inte emot argument!";
  }

  /** Field ER_DOCUMENT_REPLACED          */
  public static final int ER_DOCUMENT_REPLACED = 3;

  static
  {
    contents[ER_DOCUMENT_REPLACED][1] =
      "Implementeringen av funktionen document() har ersatts av org.apache.xalan.xslt.FuncDocument!";
  }

  /** Field ER_CONTEXT_HAS_NO_OWNERDOC          */
  public static final int ER_CONTEXT_HAS_NO_OWNERDOC = 4;

  static
  {
    contents[ER_CONTEXT_HAS_NO_OWNERDOC][1] =
      "Kontext saknar \u00e4gardokument!";
  }

  /** Field ER_LOCALNAME_HAS_TOO_MANY_ARGS          */
  public static final int ER_LOCALNAME_HAS_TOO_MANY_ARGS = 5;

  static
  {
    contents[ER_LOCALNAME_HAS_TOO_MANY_ARGS][1] =
      "local-name() har f\u00f6r m\u00e5nga argument.";
  }

  /** Field ER_NAMESPACEURI_HAS_TOO_MANY_ARGS          */
  public static final int ER_NAMESPACEURI_HAS_TOO_MANY_ARGS = 6;

  static
  {
    contents[ER_NAMESPACEURI_HAS_TOO_MANY_ARGS][1] =
      "namespace-uri() har f\u00f6r m\u00e5nga argument.";
  }

  /** Field ER_NORMALIZESPACE_HAS_TOO_MANY_ARGS          */
  public static final int ER_NORMALIZESPACE_HAS_TOO_MANY_ARGS = 7;

  static
  {
    contents[ER_NORMALIZESPACE_HAS_TOO_MANY_ARGS][1] =
      "normalize-space() har f\u00f6r m\u00e5nga argument.";
  }

  /** Field ER_NUMBER_HAS_TOO_MANY_ARGS          */
  public static final int ER_NUMBER_HAS_TOO_MANY_ARGS = 8;

  static
  {
    contents[ER_NUMBER_HAS_TOO_MANY_ARGS][1] =
      "number() har f\u00f6r m\u00e5nga argument.";
  }

  /** Field ER_NAME_HAS_TOO_MANY_ARGS          */
  public static final int ER_NAME_HAS_TOO_MANY_ARGS = 9;

  static
  {
    contents[ER_NAME_HAS_TOO_MANY_ARGS][1] = "name() har f\u00f6r m\u00e5nga argument.";
  }

  /** Field ER_STRING_HAS_TOO_MANY_ARGS          */
  public static final int ER_STRING_HAS_TOO_MANY_ARGS = 10;

  static
  {
    contents[ER_STRING_HAS_TOO_MANY_ARGS][1] =
      "string() har f\u00f6r m\u00e5nga argument.";
  }

  /** Field ER_STRINGLENGTH_HAS_TOO_MANY_ARGS          */
  public static final int ER_STRINGLENGTH_HAS_TOO_MANY_ARGS = 11;

  static
  {
    contents[ER_STRINGLENGTH_HAS_TOO_MANY_ARGS][1] =
      "string.length() har f\u00f6r m\u00e5nga argument.";
  }

  /** Field ER_TRANSLATE_TAKES_3_ARGS          */
  public static final int ER_TRANSLATE_TAKES_3_ARGS = 12;

  static
  {
    contents[ER_TRANSLATE_TAKES_3_ARGS][1] =
      "Funktionen translate() tar emot tre argument!";
  }

  /** Field ER_UNPARSEDENTITYURI_TAKES_1_ARG          */
  public static final int ER_UNPARSEDENTITYURI_TAKES_1_ARG = 13;

  static
  {
    contents[ER_UNPARSEDENTITYURI_TAKES_1_ARG][1] =
      "Funktionen unparsed-entity-uri borde ta emot ett argument!";
  }

  /** Field ER_NAMESPACEAXIS_NOT_IMPLEMENTED          */
  public static final int ER_NAMESPACEAXIS_NOT_IMPLEMENTED = 14;

  static
  {
    contents[ER_NAMESPACEAXIS_NOT_IMPLEMENTED][1] =
      "Namespace-axel inte implementerad \u00e4n!";
  }

  /** Field ER_UNKNOWN_AXIS          */
  public static final int ER_UNKNOWN_AXIS = 15;

  static
  {
    contents[ER_UNKNOWN_AXIS][1] = "ok\u00e4nd axel: {0}";
  }

  /** Field ER_UNKNOWN_MATCH_OPERATION          */
  public static final int ER_UNKNOWN_MATCH_OPERATION = 16;

  static
  {
    contents[ER_UNKNOWN_MATCH_OPERATION][1] = "ok\u00e4nd matchningshandling!";
  }

  /** Field ER_INCORRECT_ARG_LENGTH          */
  public static final int ER_INCORRECT_ARG_LENGTH = 17;

  static
  {
    contents[ER_INCORRECT_ARG_LENGTH][1] =
      "Nodtests argumentl\u00e4ngd i processing-instruction() \u00e4r inte korrekt!";
  }

  /** Field ER_CANT_CONVERT_TO_NUMBER          */
  public static final int ER_CANT_CONVERT_TO_NUMBER = 18;

  static
  {
    contents[ER_CANT_CONVERT_TO_NUMBER][1] =
      "Kan inte konvertera {0} till ett nummer";
  }

  /** Field ER_CANT_CONVERT_TO_NODELIST          */
  public static final int ER_CANT_CONVERT_TO_NODELIST = 19;

  static
  {
    contents[ER_CANT_CONVERT_TO_NODELIST][1] =
      "Kan inte konvertera {0} till en NodeList!";
  }

  /** Field ER_CANT_CONVERT_TO_MUTABLENODELIST          */
  public static final int ER_CANT_CONVERT_TO_MUTABLENODELIST = 20;

  static
  {
    contents[ER_CANT_CONVERT_TO_MUTABLENODELIST][1] =
      "Kan inte konvertera {0} till en NodeSetDTM!";
  }

  /** Field ER_CANT_CONVERT_TO_TYPE          */
  public static final int ER_CANT_CONVERT_TO_TYPE = 21;

  static
  {
    contents[ER_CANT_CONVERT_TO_TYPE][1] =
      "Kan inte konvertera {0} till en type#{1}";
  }

  /** Field ER_EXPECTED_MATCH_PATTERN          */
  public static final int ER_EXPECTED_MATCH_PATTERN = 22;

  static
  {
    contents[ER_EXPECTED_MATCH_PATTERN][1] =
      "Matchningsm\u00f6nster i getMatchScore f\u00f6rv\u00e4ntat!";
  }

  /** Field ER_COULDNOT_GET_VAR_NAMED          */
  public static final int ER_COULDNOT_GET_VAR_NAMED = 23;

  static
  {
    contents[ER_COULDNOT_GET_VAR_NAMED][1] =
      "Kunde inte h\u00e4mta variabeln {0}";
  }

  /** Field ER_UNKNOWN_OPCODE          */
  public static final int ER_UNKNOWN_OPCODE = 24;

  static
  {
    contents[ER_UNKNOWN_OPCODE][1] = "FEL! Ok\u00e4nd op-kod: {0}";
  }

  /** Field ER_EXTRA_ILLEGAL_TOKENS          */
  public static final int ER_EXTRA_ILLEGAL_TOKENS = 25;

  static
  {
    contents[ER_EXTRA_ILLEGAL_TOKENS][1] = "Ytterligare otill\u00e5tna tecken: {0}";
  }

  /** Field ER_EXPECTED_DOUBLE_QUOTE          */
  public static final int ER_EXPECTED_DOUBLE_QUOTE = 26;

  static
  {
    contents[ER_EXPECTED_DOUBLE_QUOTE][1] =
      "Litteral omges av fel sorts citationstecken... dubbla citationstecken f\u00f6rv\u00e4ntade!";
  }

  /** Field ER_EXPECTED_SINGLE_QUOTE          */
  public static final int ER_EXPECTED_SINGLE_QUOTE = 27;

  static
  {
    contents[ER_EXPECTED_SINGLE_QUOTE][1] =
      "Litteral omges av fel sorts citationstecken... enkla citationstecken f\u00f6rv\u00e4ntade!";
  }

  /** Field ER_EMPTY_EXPRESSION          */
  public static final int ER_EMPTY_EXPRESSION = 28;

  static
  {
    contents[ER_EMPTY_EXPRESSION][1] = "Tomt uttryck!";
  }

  /** Field ER_EXPECTED_BUT_FOUND          */
  public static final int ER_EXPECTED_BUT_FOUND = 29;

  static
  {
    contents[ER_EXPECTED_BUT_FOUND][1] = "{0} f\u00f6rv\u00e4ntat, men hittade: {1}";
  }

  /** Field ER_INCORRECT_PROGRAMMER_ASSERTION          */
  public static final int ER_INCORRECT_PROGRAMMER_ASSERTION = 30;

  static
  {
    contents[ER_INCORRECT_PROGRAMMER_ASSERTION][1] =
      "Programmerares f\u00f6rs\u00e4kran \u00e4r inte korrekt! - {0}";
  }

  /** Field ER_BOOLEAN_ARG_NO_LONGER_OPTIONAL          */
  public static final int ER_BOOLEAN_ARG_NO_LONGER_OPTIONAL = 31;

  static
  {
    contents[ER_BOOLEAN_ARG_NO_LONGER_OPTIONAL][1] =
      "boolean(...)-argument \u00e4r inte l\u00e4ngre valfri med 19990709 XPath-utkast.";
  }

  /** Field ER_FOUND_COMMA_BUT_NO_PRECEDING_ARG          */
  public static final int ER_FOUND_COMMA_BUT_NO_PRECEDING_ARG = 32;

  static
  {
    contents[ER_FOUND_COMMA_BUT_NO_PRECEDING_ARG][1] =
      "Hittade ',' men inget f\u00f6reg\u00e5ende argument!";
  }

  /** Field ER_FOUND_COMMA_BUT_NO_FOLLOWING_ARG          */
  public static final int ER_FOUND_COMMA_BUT_NO_FOLLOWING_ARG = 33;

  static
  {
    contents[ER_FOUND_COMMA_BUT_NO_FOLLOWING_ARG][1] =
      "Hittade ',' men inget efterf\u00f6ljande argument!";
  }

  /** Field ER_PREDICATE_ILLEGAL_SYNTAX          */
  public static final int ER_PREDICATE_ILLEGAL_SYNTAX = 34;

  static
  {
    contents[ER_PREDICATE_ILLEGAL_SYNTAX][1] =
      "'..[predikat]' or '.[predikat]' \u00e4r otill\u00e5ten syntax.  Anv\u00e4nd 'self::node()[predikat]' ist\u00e4llet.";
  }

  /** Field ER_ILLEGAL_AXIS_NAME          */
  public static final int ER_ILLEGAL_AXIS_NAME = 35;

  static
  {
    contents[ER_ILLEGAL_AXIS_NAME][1] = "otill\u00e5tet axel-namn: {0}";
  }

  /** Field ER_UNKNOWN_NODETYPE          */
  public static final int ER_UNKNOWN_NODETYPE = 36;

  static
  {
    contents[ER_UNKNOWN_NODETYPE][1] = "ok\u00e4nd nodtyp: {0}";
  }

  /** Field ER_PATTERN_LITERAL_NEEDS_BE_QUOTED          */
  public static final int ER_PATTERN_LITERAL_NEEDS_BE_QUOTED = 37;

  static
  {
    contents[ER_PATTERN_LITERAL_NEEDS_BE_QUOTED][1] =
      "M\u00f6nsterlitteral {0} m\u00e5ste s\u00e4ttas inom citationstecken!";
  }

  /** Field ER_COULDNOT_BE_FORMATTED_TO_NUMBER          */
  public static final int ER_COULDNOT_BE_FORMATTED_TO_NUMBER = 38;

  static
  {
    contents[ER_COULDNOT_BE_FORMATTED_TO_NUMBER][1] =
      "{0} kunde inte formateras till ett nummer";
  }

  /** Field ER_COULDNOT_CREATE_XMLPROCESSORLIAISON          */
  public static final int ER_COULDNOT_CREATE_XMLPROCESSORLIAISON = 39;

  static
  {
    contents[ER_COULDNOT_CREATE_XMLPROCESSORLIAISON][1] =
      "Kunde inte skapa XML TransformerFactory Liaison: {0}";
  }

  /** Field ER_DIDNOT_FIND_XPATH_SELECT_EXP          */
  public static final int ER_DIDNOT_FIND_XPATH_SELECT_EXP = 40;

  static
  {
    contents[ER_DIDNOT_FIND_XPATH_SELECT_EXP][1] =
      "Fel! Hittade inte xpath select-uttryck (-select).";
  }

  /** Field ER_COULDNOT_FIND_ENDOP_AFTER_OPLOCATIONPATH          */
  public static final int ER_COULDNOT_FIND_ENDOP_AFTER_OPLOCATIONPATH = 41;

  static
  {
    contents[ER_COULDNOT_FIND_ENDOP_AFTER_OPLOCATIONPATH][1] =
      "FEL! Hittade inte ENDOP efter OP_LOCATIONPATH";
  }

  /** Field ER_ERROR_OCCURED          */
  public static final int ER_ERROR_OCCURRED = 42;

  static
  {
    contents[ER_ERROR_OCCURRED][1] = "Fel intr\u00e4ffade!";
  }

  /** Field ER_ILLEGAL_VARIABLE_REFERENCE          */
  public static final int ER_ILLEGAL_VARIABLE_REFERENCE = 43;

  static
  {
    contents[ER_ILLEGAL_VARIABLE_REFERENCE][1] =
      "VariableReference angiven f\u00f6r variabel som \u00e4r utanf\u00f6r sammanhanget eller som saknar definition!  Namn = {0}";
  }

  /** Field ER_AXES_NOT_ALLOWED          */
  public static final int ER_AXES_NOT_ALLOWED = 44;

  static
  {
    contents[ER_AXES_NOT_ALLOWED][1] =
      "Enbart barn::- och attribut::- axlar \u00e4r till\u00e5tna i matchningsm\u00f6nster!  Regelvidriga axlar = {0}";
  }

  /** Field ER_KEY_HAS_TOO_MANY_ARGS          */
  public static final int ER_KEY_HAS_TOO_MANY_ARGS = 45;

  static
  {
    contents[ER_KEY_HAS_TOO_MANY_ARGS][1] =
      "key() har ett felaktigt antal argument.";
  }

  /** Field ER_COUNT_TAKES_1_ARG          */
  public static final int ER_COUNT_TAKES_1_ARG = 46;

  static
  {
    contents[ER_COUNT_TAKES_1_ARG][1] =
      "Funktionen count borde ta emot ett argument!";
  }

  /** Field ER_COULDNOT_FIND_FUNCTION          */
  public static final int ER_COULDNOT_FIND_FUNCTION = 47;

  static
  {
    contents[ER_COULDNOT_FIND_FUNCTION][1] = "Hittade inte funktionen: {0}";
  }

  /** Field ER_UNSUPPORTED_ENCODING          */
  public static final int ER_UNSUPPORTED_ENCODING = 48;

  static
  {
    contents[ER_UNSUPPORTED_ENCODING][1] = "Ej underst\u00f6dd kodning: {0}";
  }

  /** Field ER_PROBLEM_IN_DTM_NEXTSIBLING          */
  public static final int ER_PROBLEM_IN_DTM_NEXTSIBLING = 49;

  static
  {
    contents[ER_PROBLEM_IN_DTM_NEXTSIBLING][1] =
      "Problem intr\u00e4ffade i DTM i getNextSibling... f\u00f6rs\u00f6ker \u00e5terh\u00e4mta";
  }

  /** Field ER_CANNOT_WRITE_TO_EMPTYNODELISTIMPL          */
  public static final int ER_CANNOT_WRITE_TO_EMPTYNODELISTIMPL = 50;

  static
  {
    contents[ER_CANNOT_WRITE_TO_EMPTYNODELISTIMPL][1] =
      "Programmerarfel: EmptyNodeList kan inte skrivas till.";
  }

  /** Field ER_SETDOMFACTORY_NOT_SUPPORTED          */
  public static final int ER_SETDOMFACTORY_NOT_SUPPORTED = 51;

  static
  {
    contents[ER_SETDOMFACTORY_NOT_SUPPORTED][1] =
      "setDOMFactory underst\u00f6ds inte av XPathContext!";
  }

  /** Field ER_PREFIX_MUST_RESOLVE          */
  public static final int ER_PREFIX_MUST_RESOLVE = 52;

  static
  {
    contents[ER_PREFIX_MUST_RESOLVE][1] =
      "Prefix must resolve to a namespace: {0}";
  }

  /** Field ER_PARSE_NOT_SUPPORTED          */
  public static final int ER_PARSE_NOT_SUPPORTED = 53;

  static
  {
    contents[ER_PARSE_NOT_SUPPORTED][1] =
      "parse (InputSource source) underst\u00f6ds inte av XPathContext! Kan inte \u00f6ppna {0}";
  }

  /** Field ER_CREATEDOCUMENT_NOT_SUPPORTED          */
  public static final int ER_CREATEDOCUMENT_NOT_SUPPORTED = 54;

  static
  {
    contents[ER_CREATEDOCUMENT_NOT_SUPPORTED][1] =
      "createDocument() underst\u00f6ds inte av XPathContext!";
  }

  /** Field ER_CHILD_HAS_NO_OWNER_DOCUMENT          */
  public static final int ER_CHILD_HAS_NO_OWNER_DOCUMENT = 55;

  static
  {
    contents[ER_CHILD_HAS_NO_OWNER_DOCUMENT][1] =
      "Attributbarn saknar \u00e4gardokument!";
  }

  /** Field ER_CHILD_HAS_NO_OWNER_DOCUMENT_ELEMENT          */
  public static final int ER_CHILD_HAS_NO_OWNER_DOCUMENT_ELEMENT = 56;

  static
  {
    contents[ER_CHILD_HAS_NO_OWNER_DOCUMENT_ELEMENT][1] =
      "Attributbarn saknar \u00e4gardokumentelement!";
  }

  /** Field ER_SAX_API_NOT_HANDLED          */
  public static final int ER_SAX_API_NOT_HANDLED = 57;

  static
  {
    contents[ER_SAX_API_NOT_HANDLED][1] =
      "SAX API-tecken(char ch[]... hanteras inte av DTM!";
  }

  /** Field ER_IGNORABLE_WHITESPACE_NOT_HANDLED          */
  public static final int ER_IGNORABLE_WHITESPACE_NOT_HANDLED = 58;

  static
  {
    contents[ER_IGNORABLE_WHITESPACE_NOT_HANDLED][1] =
      "ignorableWhitespace(char ch[]... hanteras inte av DTM!";
  }

  /** Field ER_DTM_CANNOT_HANDLE_NODES          */
  public static final int ER_DTM_CANNOT_HANDLE_NODES = 59;

  static
  {
    contents[ER_DTM_CANNOT_HANDLE_NODES][1] =
      "DTMLiaison kan inte hantera noder av typen {0}";
  }

  /** Field ER_XERCES_CANNOT_HANDLE_NODES          */
  public static final int ER_XERCES_CANNOT_HANDLE_NODES = 60;

  static
  {
    contents[ER_XERCES_CANNOT_HANDLE_NODES][1] =
      "DOM2Helper kan inte hantera noder av typen {0}";
  }

  /** Field ER_XERCES_PARSE_ERROR_DETAILS          */
  public static final int ER_XERCES_PARSE_ERROR_DETAILS = 61;

  static
  {
    contents[ER_XERCES_PARSE_ERROR_DETAILS][1] =
      "DOM2Helper.parse-fel: SystemID \u0096 {0} rad \u0096 {1}";
  }

  /** Field ER_XERCES_PARSE_ERROR          */
  public static final int ER_XERCES_PARSE_ERROR = 62;

  static
  {
    contents[ER_XERCES_PARSE_ERROR][1] = "DOM2Helper.parse-fel";
  }

  /** Field ER_CANT_OUTPUT_TEXT_BEFORE_DOC          */
  public static final int ER_CANT_OUTPUT_TEXT_BEFORE_DOC = 63;

  static
  {
    contents[ER_CANT_OUTPUT_TEXT_BEFORE_DOC][1] =
      "Varning: kan inte skriva ut text innan dokumentelement!  Ignorerar...";
  }

  /** Field ER_CANT_HAVE_MORE_THAN_ONE_ROOT          */
  public static final int ER_CANT_HAVE_MORE_THAN_ONE_ROOT = 64;

  static
  {
    contents[ER_CANT_HAVE_MORE_THAN_ONE_ROOT][1] =
      "Kan inte ha mer \u00e4n en rot p\u00e5 en DOM!";
  }

  /** Field ER_INVALID_UTF16_SURROGATE          */
  public static final int ER_INVALID_UTF16_SURROGATE = 65;

  static
  {
    contents[ER_INVALID_UTF16_SURROGATE][1] =
      "Ogiltigt UTF-16-surrogat uppt\u00e4ckt: {0} ?";
  }

  /** Field ER_OIERROR          */
  public static final int ER_OIERROR = 66;

  static
  {
    contents[ER_OIERROR][1] = "IO-fel";
  }

  /** Field ER_CANNOT_CREATE_URL          */
  public static final int ER_CANNOT_CREATE_URL = 67;

  static
  {
    contents[ER_CANNOT_CREATE_URL][1] = "Kan inte skapa url f\u00f6r: {0}";
  }

  /** Field ER_XPATH_READOBJECT          */
  public static final int ER_XPATH_READOBJECT = 68;

  static
  {
    contents[ER_XPATH_READOBJECT][1] = "I XPath.readObject: {0}";
  }
  
  /** Field ER_XPATH_READOBJECT         */
  public static final int ER_FUNCTION_TOKEN_NOT_FOUND = 69;

  static
  {
    contents[ER_FUNCTION_TOKEN_NOT_FOUND][1] =
      "funktionstecken saknas.";
  }
  
   /**  Argument 'localName' is null  */
  public static final int ER_ARG_LOCALNAME_NULL = 70;

  static
  {
    contents[ER_ARG_LOCALNAME_NULL][1] =
       "Argument 'localName' \u00e4r null";
  }
  
   /**  Can not deal with XPath type:   */
  public static final int ER_CANNOT_DEAL_XPATH_TYPE = 71;

  static
  {
    contents[ER_CANNOT_DEAL_XPATH_TYPE][1] =
       "Kan inte hantera XPath-typ: {0}";
  }
  
   /**  This NodeSet is not mutable  */
  public static final int ER_NODESET_NOT_MUTABLE = 72;

  static
  {
    contents[ER_NODESET_NOT_MUTABLE][1] =
       "NodeSet \u00e4r of\u00f6r\u00e4nderlig";
  }
  
   /**  This NodeSetDTM is not mutable  */
  public static final int ER_NODESETDTM_NOT_MUTABLE = 73;

  static
  {
    contents[ER_NODESETDTM_NOT_MUTABLE][1] =
       "NodeSetDTM \u00e4r of\u00f6r\u00e4nderlig";
  }
  
   /**  Variable not resolvable:   */
  public static final int ER_VAR_NOT_RESOLVABLE = 74;

  static
  {
    contents[ER_VAR_NOT_RESOLVABLE][1] =
        "Variabel ej l\u00f6sbar: {0}";
  }
  
   /** Null error handler  */
  public static final int ER_NULL_ERROR_HANDLER = 75;

  static
  {
    contents[ER_NULL_ERROR_HANDLER][1] =
        "Null error handler";
  }
  
   /**  Programmer's assertion: unknown opcode  */
  public static final int ER_PROG_ASSERT_UNKNOWN_OPCODE = 76;

  static
  {
    contents[ER_PROG_ASSERT_UNKNOWN_OPCODE][1] =
       "Programmerares f\u00f6rs\u00e4kran: ok\u00e4nd op-kod: {0}";
  }
  
   /**  0 or 1   */
  public static final int ER_ZERO_OR_ONE = 77;

  static
  {
    contents[ER_ZERO_OR_ONE][1] =
       "0 eller 1";
  }
  
   /**  2 or 3   */
  public static final int ER_TWO_OR_THREE = 78;

  static
  {
    contents[ER_TWO_OR_THREE][1] =
       "0 eller 1";
  }
  
  
  
   /**  rtf() not supported by XRTreeFragSelectWrapper   */
  public static final int ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER = 78;

  static
  {
    contents[ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER][1] =
       "rtf() underst\u00f6ds inte av XRTreeFragSelectWrapper!";
  }
  
   /**  asNodeIterator() not supported by XRTreeFragSelectWrapper   */
  public static final int ER_ASNODEITERATOR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER = 79;

  static
  {
    contents[ER_ASNODEITERATOR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER][1] =
       "asNodeIterator() underst\u00f6ds inte av XRTreeFragSelectWrapper!";
  }
  
   /**  fsb() not supported for XStringForChars   */
  public static final int ER_FSB_NOT_SUPPORTED_XSTRINGFORCHARS = 80;

  static
  {
    contents[ER_FSB_NOT_SUPPORTED_XSTRINGFORCHARS][1] =
       "fsb() underst\u00f6ds inte av XRStringForChars!";
  }
  
   /**  Could not find variable with the name of   */
  public static final int ER_COULD_NOT_FIND_VAR = 81;

  static
  {
    contents[ER_COULD_NOT_FIND_VAR][1] =
      "Hittade inte variabeln med namn {0}";
  }
  
   /**  XStringForChars can not take a string for an argument   */
  public static final int ER_XSTRINGFORCHARS_CANNOT_TAKE_STRING = 82;

  static
  {
    contents[ER_XSTRINGFORCHARS_CANNOT_TAKE_STRING][1] =
      "XStringForChars kan inte ta en str\u00e4ng som argument";
  }
  
   /**  The FastStringBuffer argument can not be null   */
  public static final int ER_FASTSTRINGBUFFER_CANNOT_BE_NULL = 83;

  static
  {
    contents[ER_FASTSTRINGBUFFER_CANNOT_BE_NULL][1] =
      "FastStringBuffer-argumentet f\u00e5r inte vara null";
  }  
  
  /**  Unable to resolve prefix with null prefix resolver.   */
  public static final int ER_NULL_RESOLVER = 84;
  static
  {
	contents[ER_NULL_RESOLVER][1] =
	  "Unable to resolve prefix with null prefix resolver.";
  }  
  
  /**  Context node does not belong to the document that is bound to this XPathEvaluator.   */
  public static final int ER_WRONG_DOCUMENT = 85;
  static
  {
	contents[ER_WRONG_DOCUMENT][1] =
	  "Context node does not belong to the document that is bound to this XPathEvaluator.";
  }  
  
  /**  The context node type is not supported.   */
  public static final int ER_WRONG_NODETYPE = 86;
  static
  {
	contents[ER_WRONG_NODETYPE][1] =
	  "The context node type is not supported.";
  }  
  
  /**  Invalid XPath type argument: {0}   */
  public static final int ER_INVALID_XPATH_TYPE = 87;
  static
  {
	contents[ER_INVALID_XPATH_TYPE][1] =
	  "Invalid XPath type argument: {0}";
  }  
  
  /**  Empty XPath result object   */
  public static final int ER_EMPTY_XPATH_RESULT = 88;
  static
  {
	contents[ER_EMPTY_XPATH_RESULT][1] =
	  "Empty XPath result object";
  }  
  
  /**  The returned type: {0} cannot be coerced into the specified type: {1}   */
  public static final int ER_INCOMPATIBLE_TYPES = 89;
  static
  {
	contents[ER_INCOMPATIBLE_TYPES][1] =
	  "The returned type: {0} cannot be coerced into the specified type: {1}";
  }  
  
  /**  Cannot convert {0} to a string.   */
  public static final int ER_CANT_CONVERT_TO_STRING = 90;
  static
  {
	contents[ER_CANT_CONVERT_TO_STRING][1] =
	  "Cannot convert {0} to a string.";
  }  

  /**  Cannot convert {0} to a boolean.   */
  public static final int ER_CANT_CONVERT_TO_BOOLEAN = 91;
  static
  {
	contents[ER_CANT_CONVERT_TO_BOOLEAN][1] =
	  "Cannot convert {0} to a boolean.";
  }  

  /**  Cannot convert {0} to a single node. This getter applies to types ANY_UNORDERED_NODE_TYPE and FIRST_ORDERED_NODE_TYPE.   */
  public static final int ER_CANT_CONVERT_TO_SINGLENODE = 92;
  static
  {
	contents[ER_CANT_CONVERT_TO_SINGLENODE][1] =
	  "Cannot convert {0} to a single node. This getter applies to types ANY_UNORDERED_NODE_TYPE and FIRST_ORDERED_NODE_TYPE.";
  }  

  /**  Cannot get snapshot length on type: {0}. This getter applies to types UNORDERED_NODE_SNAPSHOT_TYPE and ORDERED_NODE_SNAPSHOT_TYPE.   */
  public static final int ER_CANT_GET_SNAPSHOT_LENGTH = 93;
  static
  {
	contents[ER_CANT_GET_SNAPSHOT_LENGTH][1] =
	  "Cannot get snapshot length on type: {0}. This getter applies to types UNORDERED_NODE_SNAPSHOT_TYPE and ORDERED_NODE_SNAPSHOT_TYPE.";
  }  

  /**  Cannot iterate over non-iterator type: {0}   */
  public static final int ER_NON_ITERATOR_TYPE = 94;
  static
  {
	contents[ER_NON_ITERATOR_TYPE][1] =
	  "Cannot iterate over non-iterator type: {0}";
  }  

  /**  Document mutated since result was returned. Iterator is invalid.   */
  public static final int ER_DOC_MUTATED = 95;
  static
  {
	contents[ER_DOC_MUTATED][1] =
	  "Document mutated since result was returned. Iterator is invalid.";
  }  

  /**  Cannot call snapshotItem on type: {0}. This method applies to types UNORDERED_NODE_SNAPSHOT_TYPE and ORDERED_NODE_SNAPSHOT_TYPE.   */
  public static final int ER_NON_SNAPSHOT_TYPE = 96;
  static
  {
	contents[ER_NON_SNAPSHOT_TYPE][1] =
	  "Cannot call snapshotItem on type: {0}. This method applies to types UNORDERED_NODE_SNAPSHOT_TYPE and ORDERED_NODE_SNAPSHOT_TYPE.";
  }  

  // Warnings...

  /** Field WG_LOCALE_NAME_NOT_HANDLED          */
  public static final int WG_LOCALE_NAME_NOT_HANDLED = 1;

  static
  {
    contents[WG_LOCALE_NAME_NOT_HANDLED + MAX_CODE][1] =
      "locale-namnet i format-number-funktionen \u00e4nnu inte hanterat!";
  }

  /** Field WG_PROPERTY_NOT_SUPPORTED          */
  public static final int WG_PROPERTY_NOT_SUPPORTED = 2;

  static
  {
    contents[WG_PROPERTY_NOT_SUPPORTED + MAX_CODE][1] =
      "XSL-Egenskap underst\u00f6ds inte: {0}";
  }

  /** Field WG_DONT_DO_ANYTHING_WITH_NS          */
  public static final int WG_DONT_DO_ANYTHING_WITH_NS = 3;

  static
  {
    contents[WG_DONT_DO_ANYTHING_WITH_NS + MAX_CODE][1] =
      "G\u00f6r f\u00f6r n\u00e4rvarande inte n\u00e5gonting med namespace {0} i egenskap: {1}";
  }

  /** Field WG_SECURITY_EXCEPTION          */
  public static final int WG_SECURITY_EXCEPTION = 4;

  static
  {
    contents[WG_SECURITY_EXCEPTION + MAX_CODE][1] =
      "SecurityException vid f\u00f6rs\u00f6k att f\u00e5 tillg\u00e5ng till XSL-systemegenskap: {0}";
  }

  /** Field WG_QUO_NO_LONGER_DEFINED          */
  public static final int WG_QUO_NO_LONGER_DEFINED = 5;

  static
  {
    contents[WG_QUO_NO_LONGER_DEFINED + MAX_CODE][1] =
      "Gammal syntax: quo(...) \u00e4r inte l\u00e4ngre definierad i XPath.";
  }

  /** Field WG_NEED_DERIVED_OBJECT_TO_IMPLEMENT_NODETEST          */
  public static final int WG_NEED_DERIVED_OBJECT_TO_IMPLEMENT_NODETEST = 6;

  static
  {
    contents[WG_NEED_DERIVED_OBJECT_TO_IMPLEMENT_NODETEST + MAX_CODE][1] =
      "XPath beh\u00f6ver ett deriverat objekt f\u00f6r att implementera nodeTest!";
  }

  /** Field WG_FUNCTION_TOKEN_NOT_FOUND          */
  public static final int WG_FUNCTION_TOKEN_NOT_FOUND = 7;

  static
  {
    contents[WG_FUNCTION_TOKEN_NOT_FOUND + MAX_CODE][1] =
      "funktionstecken saknas.";
  }

  /** Field WG_COULDNOT_FIND_FUNCTION          */
  public static final int WG_COULDNOT_FIND_FUNCTION = 8;

  static
  {
    contents[WG_COULDNOT_FIND_FUNCTION + MAX_CODE][1] =
      "Hittade inte funktion: {0}";
  }

  /** Field WG_CANNOT_MAKE_URL_FROM          */
  public static final int WG_CANNOT_MAKE_URL_FROM = 9;

  static
  {
    contents[WG_CANNOT_MAKE_URL_FROM + MAX_CODE][1] =
      "Kan inte skapa URL fr\u00e5n: {0}";
  }

  /** Field WG_EXPAND_ENTITIES_NOT_SUPPORTED          */
  public static final int WG_EXPAND_ENTITIES_NOT_SUPPORTED = 10;

  static
  {
    contents[WG_EXPAND_ENTITIES_NOT_SUPPORTED + MAX_CODE][1] =
      "Alternativet -E underst\u00f6ds inte f\u00f6r DTM-tolk";
  }

  /** Field WG_ILLEGAL_VARIABLE_REFERENCE          */
  public static final int WG_ILLEGAL_VARIABLE_REFERENCE = 11;

  static
  {
    contents[WG_ILLEGAL_VARIABLE_REFERENCE + MAX_CODE][1] =
      "VariableReference angiven f\u00f6r variabel som \u00e4r utanf\u00f6r sammanhanget eller som saknar definition!  Namn = {0}";
  }

  /** Field WG_UNSUPPORTED_ENCODING          */
  public static final int WG_UNSUPPORTED_ENCODING = 12;

  static
  {
    contents[ER_UNSUPPORTED_ENCODING][1] = "Ej underst\u00f6dd kodning: {0}";
  }

  // Other miscellaneous text used inside the code...
  static
  {
    contents[MAX_MESSAGES][0] = "ui_language";
    contents[MAX_MESSAGES][1] = "sv";
    contents[MAX_MESSAGES + 1][0] = "help_language";
    contents[MAX_MESSAGES + 1][1] = "sv";
    contents[MAX_MESSAGES +2 ][0] = "language";
    contents[MAX_MESSAGES + 2][1] = "sv";
    contents[MAX_MESSAGES + 3][0] = "BAD_CODE";
    contents[MAX_MESSAGES + 3][1] =
      "Parameter till createMessage ligger utanf\u00f6r till\u00e5tet intervall";
    contents[MAX_MESSAGES + 4][0] = "FORMAT_FAILED";
    contents[MAX_MESSAGES + 4][1] =
      "Undantag utl\u00f6st vid messageFormat-anrop";
    contents[MAX_MESSAGES + 5][0] = "version";
    contents[MAX_MESSAGES + 5][1] = ">>>>>>> Xalan Version";
    contents[MAX_MESSAGES + 6][0] = "version2";
    contents[MAX_MESSAGES + 6][1] = "<<<<<<<";
    contents[MAX_MESSAGES + 7][0] = "yes";
    contents[MAX_MESSAGES + 7][1] = "ja";
    contents[MAX_MESSAGES + 8][0] = "line";
    contents[MAX_MESSAGES + 8][1] = "Rad #";
    contents[MAX_MESSAGES + 9][0] = "column";
    contents[MAX_MESSAGES + 9][1] = "Kolumn #";
    contents[MAX_MESSAGES +10][0] = "xsldone";
    contents[MAX_MESSAGES + 10][1] = "XSLProcessor f\u00e4rdig";
    contents[MAX_MESSAGES + 11][0] = "xpath_option";
    contents[MAX_MESSAGES + 11][1] = "xpath-alternativ";
    contents[MAX_MESSAGES +12][0] = "optionIN";
    contents[MAX_MESSAGES +12][1] = "    [-in inputXMLURL]";
    contents[MAX_MESSAGES +13][0] = "optionSelect";
    contents[MAX_MESSAGES +13][1] = "[-select xpath-uttryck]";
    contents[MAX_MESSAGES +14][0] = "optionMatch";
    contents[MAX_MESSAGES + 14][1] =
      "   [-match matchningsm\u00f6nster (f\u00f6r matchningsdiagnostik)]";
    contents[MAX_MESSAGES +15][0] = "optionAnyExpr";
    contents[MAX_MESSAGES + 15][1] =
      "Eller bara ett xpath-uttryck kommer att g\u00f6ra en diagnostik-dump";
    contents[MAX_MESSAGES +16 ][0] = "noParsermsg1";
    contents[MAX_MESSAGES +16][1] = "XSL-Process misslyckades.";
    contents[MAX_MESSAGES +17 ][0] = "noParsermsg2";
    contents[MAX_MESSAGES +17][1] = "** Hittade inte tolk **";
    contents[MAX_MESSAGES +18 ][0] = "noParsermsg3";
    contents[MAX_MESSAGES +18][1] = "V\u00e4nligen kontrollera din classpath";
    contents[MAX_MESSAGES + 19][0] = "noParsermsg4";
    contents[MAX_MESSAGES + 19][1] =
      "Om du inte har IBMs XML-Tolk f\u00f6r Java, kan du ladda ner den fr\u00e5n";
    contents[MAX_MESSAGES +20 ][0] = "noParsermsg5";
    contents[MAX_MESSAGES + 20][1] =
      "IBMs AlphaWorks: http://www.alphaworks.ibm.com/formula/xml";
  }

  // ================= INFRASTRUCTURE ======================

  /** Field BAD_CODE          */
//  public static final String BAD_CODE = "D\u00c5LIG_KOD";
	public static final String BAD_CODE = "BAD_CODE";

  /** Field FORMAT_FAILED          */
//  public static final String FORMAT_FAILDE = "FORMATTERING_MISSLYCKADES";
  public static final String FORMAT_FAILED = "FORMAT_FAILED";

  /** Field ERROR_RESOURCES          */
  public static final String ERROR_RESOURCES =
    "org.apache.xpath.res.XPATHErrorResources";

  /** Field ERROR_STRING          */
  public static final String ERROR_STRING = "#fel";

  /** Field ERROR_HEADER          */
  public static final String ERROR_HEADER = "Fel: ";

  /** Field WARNING_HEADER          */
  public static final String WARNING_HEADER = "Varning: ";

  /** Field XSL_HEADER          */
  public static final String XSL_HEADER = "XSL ";

  /** Field XML_HEADER          */
  public static final String XML_HEADER = "XML ";

  /** Field QUERY_HEADER          */
  public static final String QUERY_HEADER = "M\u00d6NSTER ";

  /**
 * Get the association list.
 * @return  The association list.
 * @uml.property  name="contents"
 */
  public Object[][] getContents()
  {
    return contents;
  }

  /**
   * Return a named ResourceBundle for a particular locale.  This method mimics the behavior
   * of ResourceBundle.getBundle().
   *
   * @param res the name of the resource to load.
   * @param locale the locale to prefer when searching for the bundle
   *
   * @param className Name of local-specific subclass.
   * @return the ResourceBundle
   * @throws MissingResourceException
   */
  public static final XPATHErrorResources loadResourceBundle(String className)
          throws MissingResourceException
  {

    Locale locale = Locale.getDefault();
    String suffix = getResourceSuffix(locale);

    try
    {

      // first try with the given locale
      return (XPATHErrorResources) ResourceBundle.getBundle(className
              + suffix, locale);
    }
    catch (MissingResourceException e)
    {
      try  // try to fall back to en_US if we can't load
      {

        // Since we can't find the localized property file,
        // fall back to en_US.
        return (XPATHErrorResources) ResourceBundle.getBundle(className,
                new Locale("en", "US"));
      }
      catch (MissingResourceException e2)
      {

        // Now we are really in trouble.
        // very bad, definitely very bad...not going to get very far
        throw new MissingResourceException(
          "Kunde inte ladda n\u00e5gra resurspaket.", className, "");
      }
    }
  }

  /**
   * Return the resource file suffic for the indicated locale
   * For most locales, this will be based the language code.  However
   * for Chinese, we do distinguish between Taiwan and PRC
   *
   * @param locale the locale
   * @return an String suffix which canbe appended to a resource name
   */
  private static final String getResourceSuffix(Locale locale)
  {

    String suffix = "_" + locale.getLanguage();
    String country = locale.getCountry();

    if (country.equals("TW"))
      suffix += "_" + country;

    return suffix;
  }

  /**
   * Get the error string associated with the error code
   *
   * @param errorCode Error code
   *
   * @return error string associated with the given error code
   */
  public String getMessageKey(int errorCode)
  {

    if (errorCode > MAX_CODE)
      return null;
    else
    {
      DecimalFormat df = new DecimalFormat("0000");

      return ERROR_SUFFIX + df.format(errorCode);
    }
  }

  /**
   * Get the warning string associated with the error code
   *
   * @param errorCode Error code
   * 
   * @return warning string associated with the given error code
   */
  public String getWarningKey(int errorCode)
  {

    if (errorCode > MAX_WARNING)
      return null;
    else
    {
      DecimalFormat df = new DecimalFormat("0000");

      return WARNING_SUFFIX + df.format(errorCode);
    }
  }

  /**
   * Get the key string for an error based on the integer representation.
   *
   * @param errorCode Error code
   * 
   * @return key string that may be used for lookup in the association table.
   */
  public static String getMKey(int errorCode)
  {

    if (errorCode > MAX_CODE)
      return null;
    else
    {
      DecimalFormat df = new DecimalFormat("0000");

      return ERROR_SUFFIX + df.format(errorCode);
    }
  }

  /**
   * Get the key string for an warning based on the integer representation.
   *
   * @param errorCode Error code
   * 
   * @return key string that may be used for lookup in the association table.
   */
  public static String getWKey(int errorCode)
  {

    if (errorCode > MAX_WARNING)
      return null;
    else
    {
      DecimalFormat df = new DecimalFormat("0000");

      return WARNING_SUFFIX + df.format(errorCode);
    }
  }
}

/**
 * <meta name="usage" content="advanced"/>
 * Set up error messages.
 * We build a two dimensional array of message keys and
 * message strings. In order to add a new message here,
 * you need to first add a Static string constant for the
 * Key and update the contents array with Key, Value pair
  * Also you need to  update the count of messages(MAX_CODE)or
 * the count of warnings(MAX_WARNING) [ Information purpose only]
 *-/
public class XPATHErrorResources extends XResourceBundleBase {
/*
 * General notes to translators:
 *
 * This file contains error and warning messages related to XPath Error
 * Handling.
 *
 *  1) Xalan (or more properly, Xalan-interpretive) and XSLTC are names of
 *     components.
 *     XSLT is an acronym for "XML Stylesheet Language: Transformations".
 *     XSLTC is an acronym for XSLT Compiler.
 *
 *  2) A stylesheet is a description of how to transform an input XML document
 *     into a resultant XML document (or HTML document or text).  The
 *     stylesheet itself is described in the form of an XML document.
 *
 *  3) A template is a component of a stylesheet that is used to match a
 *     particular portion of an input document and specifies the form of the
 *     corresponding portion of the output document.
 *
 *  4) An element is a mark-up tag in an XML document; an attribute is a
 *     modifier on the tag.  For example, in <elem attr='val' attr2='val2'>
 *     "elem" is an element name, "attr" and "attr2" are attribute names with
 *     the values "val" and "val2", respectively.
 *
 *  5) A namespace declaration is a special attribute that is used to associate
 *     a prefix with a URI (the namespace).  The meanings of element names and
 *     attribute names that use that prefix are defined with respect to that
 *     namespace.
 *
 *  6) "Translet" is an invented term that describes the class file that
 *     results from compiling an XML stylesheet into a Java class.
 *
 *  7) XPath is a specification that describes a notation for identifying
 *     nodes in a tree-structured representation of an XML document.  An
 *     instance of that notation is referred to as an XPath expression.
 *
 *  8) The context node is the node in the document with respect to which an
 *     XPath expression is being evaluated.
 *
 *  9) An iterator is an object that traverses nodes in the tree, one at a time.
 *
 *  10) NCName is an XML term used to describe a name that does not contain a
 *     colon (a "no-colon name").
 *
 *  11) QName is an XML term meaning "qualified name".
 *-/

  /** Field MAX_CODE          *-/
  public static final int MAX_CODE = 108;  // this is needed to keep track of the number of messages

  /** Field MAX_WARNING          *-/
  public static final int MAX_WARNING = 11;  // this is needed to keep track of the number of warnings

  /** Field MAX_OTHERS          *-/
  public static final int MAX_OTHERS = 20;

  /** Field MAX_MESSAGES          *-/
  public static final int MAX_MESSAGES = MAX_CODE + MAX_WARNING + 1;


  /** Field ERROR_SUFFIX          *-/
  public static final String ERROR_SUFFIX = "ER";

  /** Field WARNING_SUFFIX          *-/
  public static final String WARNING_SUFFIX = "WR";

  /* 
   * static variables
   *-/
   public static final String ERROR0000_SZ =  "ERROR0000";
   public static final String ER_CURRENT_NOT_ALLOWED_IN_MATCH_SZ =  "ER_CURRENT_NOT_ALLOWED_IN_MATCH";
   public static final String ER_CURRENT_TAKES_NO_ARGS_SZ =  "ER_CURRENT_TAKES_NO_ARGS";
   public static final String ER_DOCUMENT_REPLACED_SZ =  "ER_DOCUMENT_REPLACED";
   public static final String ER_CONTEXT_HAS_NO_OWNERDOC_SZ =  "ER_CONTEXT_HAS_NO_OWNERDOC";
   public static final String ER_LOCALNAME_HAS_TOO_MANY_ARGS_SZ =  "ER_LOCALNAME_HAS_TOO_MANY_ARGS";
   public static final String ER_NAMESPACEURI_HAS_TOO_MANY_ARGS_SZ =  "ER_NAMESPACEURI_HAS_TOO_MANY_ARGS";
   public static final String ER_NORMALIZESPACE_HAS_TOO_MANY_ARGS_SZ =  "ER_NORMALIZESPACE_HAS_TOO_MANY_ARGS";
   public static final String ER_NUMBER_HAS_TOO_MANY_ARGS_SZ =  "ER_NUMBER_HAS_TOO_MANY_ARGS";
   public static final String ER_NAME_HAS_TOO_MANY_ARGS_SZ =  "ER_NAME_HAS_TOO_MANY_ARGS";
   public static final String ER_STRING_HAS_TOO_MANY_ARGS_SZ =  "ER_STRING_HAS_TOO_MANY_ARGS";
   public static final String ER_STRINGLENGTH_HAS_TOO_MANY_ARGS_SZ =  "ER_STRINGLENGTH_HAS_TOO_MANY_ARGS";
   public static final String ER_TRANSLATE_TAKES_3_ARGS_SZ =  "ER_TRANSLATE_TAKES_3_ARGS";
   public static final String ER_UNPARSEDENTITYURI_TAKES_1_ARG_SZ =  "ER_UNPARSEDENTITYURI_TAKES_1_ARG";
   public static final String ER_NAMESPACEAXIS_NOT_IMPLEMENTED_SZ =  "ER_NAMESPACEAXIS_NOT_IMPLEMENTED";
   public static final String ER_UNKNOWN_AXIS_SZ =  "ER_UNKNOWN_AXIS";
   public static final String ER_UNKNOWN_MATCH_OPERATION_SZ =  "ER_UNKNOWN_MATCH_OPERATION";
   public static final String ER_INCORRECT_ARG_LENGTH_SZ = "ER_INCORRECT_ARG_LENGTH";
   public static final String ER_CANT_CONVERT_TO_NUMBER_SZ =  "ER_CANT_CONVERT_TO_NUMBER";
   public static final String ER_CANT_CONVERT_TO_NODELIST_SZ =  "ER_CANT_CONVERT_TO_NODELIST";
   public static final String ER_CANT_CONVERT_TO_MUTABLENODELIST_SZ =  "ER_CANT_CONVERT_TO_MUTABLENODELIST";
   public static final String ER_CANT_CONVERT_TO_TYPE_SZ = "ER_CANT_CONVERT_TO_TYPE";
   public static final String ER_EXPECTED_MATCH_PATTERN_SZ =  "ER_EXPECTED_MATCH_PATTERN";
   public static final String ER_COULDNOT_GET_VAR_NAMED_SZ =  "ER_COULDNOT_GET_VAR_NAMED";
   public static final String ER_UNKNOWN_OPCODE_SZ =  "ER_UNKNOWN_OPCODE";
   public static final String ER_EXTRA_ILLEGAL_TOKENS_SZ = "ER_EXTRA_ILLEGAL_TOKENS";
   public static final String ER_EXPECTED_DOUBLE_QUOTE_SZ =  "ER_EXPECTED_DOUBLE_QUOTE";
   public static final String ER_EXPECTED_SINGLE_QUOTE_SZ =  "ER_EXPECTED_SINGLE_QUOTE";
   public static final String ER_EMPTY_EXPRESSION_SZ =  "ER_EMPTY_EXPRESSION";
   public static final String ER_EXPECTED_BUT_FOUND_SZ =  "ER_EXPECTED_BUT_FOUND";
   public static final String ER_INCORRECT_PROGRAMMER_ASSERTION_SZ =  "ER_INCORRECT_PROGRAMMER_ASSERTION";
   public static final String ER_BOOLEAN_ARG_NO_LONGER_OPTIONAL_SZ =  "ER_BOOLEAN_ARG_NO_LONGER_OPTIONAL";
   public static final String ER_FOUND_COMMA_BUT_NO_PRECEDING_ARG_SZ =  "ER_FOUND_COMMA_BUT_NO_PRECEDING_ARG";
   public static final String ER_FOUND_COMMA_BUT_NO_FOLLOWING_ARG_SZ =  "ER_FOUND_COMMA_BUT_NO_FOLLOWING_ARG";
   public static final String ER_PREDICATE_ILLEGAL_SYNTAX_SZ =  "ER_PREDICATE_ILLEGAL_SYNTAX";
   public static final String ER_ILLEGAL_AXIS_NAME_SZ =  "ER_ILLEGAL_AXIS_NAME";
   public static final String ER_UNKNOWN_NODETYPE_SZ =  "ER_UNKNOWN_NODETYPE";
   public static final String ER_PATTERN_LITERAL_NEEDS_BE_QUOTED_SZ =  "ER_PATTERN_LITERAL_NEEDS_BE_QUOTED";
   public static final String ER_COULDNOT_BE_FORMATTED_TO_NUMBER_SZ =  "ER_COULDNOT_BE_FORMATTED_TO_NUMBER";
   public static final String ER_COULDNOT_CREATE_XMLPROCESSORLIAISON_SZ =  "ER_COULDNOT_CREATE_XMLPROCESSORLIAISON";
   public static final String ER_DIDNOT_FIND_XPATH_SELECT_EXP_SZ =  "ER_DIDNOT_FIND_XPATH_SELECT_EXP";
   public static final String ER_COULDNOT_FIND_ENDOP_AFTER_OPLOCATIONPATH_SZ =  "ER_COULDNOT_FIND_ENDOP_AFTER_OPLOCATIONPATH";
   public static final String ER_ERROR_OCCURED_SZ =  "ER_ERROR_OCCURED";
   public static final String ER_ILLEGAL_VARIABLE_REFERENCE_SZ =  "ER_ILLEGAL_VARIABLE_REFERENCE";
   public static final String ER_AXES_NOT_ALLOWED_SZ =  "ER_AXES_NOT_ALLOWED";
   public static final String ER_KEY_HAS_TOO_MANY_ARGS_SZ =  "ER_KEY_HAS_TOO_MANY_ARGS";
   public static final String ER_COUNT_TAKES_1_ARG_SZ =  "ER_COUNT_TAKES_1_ARG";
   public static final String ER_COULDNOT_FIND_FUNCTION_SZ =  "ER_COULDNOT_FIND_FUNCTION";
   public static final String ER_UNSUPPORTED_ENCODING_SZ = "ER_UNSUPPORTED_ENCODING";
   public static final String ER_PROBLEM_IN_DTM_NEXTSIBLING_SZ =  "ER_PROBLEM_IN_DTM_NEXTSIBLING";
   public static final String ER_CANNOT_WRITE_TO_EMPTYNODELISTIMPL_SZ =  "ER_CANNOT_WRITE_TO_EMPTYNODELISTIMPL";
   public static final String ER_SETDOMFACTORY_NOT_SUPPORTED_SZ =  "ER_SETDOMFACTORY_NOT_SUPPORTED";
   public static final String ER_PREFIX_MUST_RESOLVE_SZ =  "ER_PREFIX_MUST_RESOLVE";
   public static final String ER_PARSE_NOT_SUPPORTED_SZ =  "ER_PARSE_NOT_SUPPORTED";
   public static final String ER_CREATEDOCUMENT_NOT_SUPPORTED_SZ =  	 "ER_CREATEDOCUMENT_NOT_SUPPORTED";
   public static final String ER_CHILD_HAS_NO_OWNER_DOCUMENT_SZ =  	 "ER_CHILD_HAS_NO_OWNER_DOCUMENT";
   public static final String ER_CHILD_HAS_NO_OWNER_DOCUMENT_ELEMENT_SZ =  	 "ER_CHILD_HAS_NO_OWNER_DOCUMENT_ELEMENT";
   public static final String ER_SAX_API_NOT_HANDLED_SZ =  "ER_SAX_API_NOT_HANDLED";
   public static final String ER_IGNORABLE_WHITESPACE_NOT_HANDLED_SZ =  "ER_IGNORABLE_WHITESPACE_NOT_HANDLED";
   public static final String ER_DTM_CANNOT_HANDLE_NODES_SZ =  "ER_DTM_CANNOT_HANDLE_NODES";
   public static final String ER_XERCES_CANNOT_HANDLE_NODES_SZ =  "ER_XERCES_CANNOT_HANDLE_NODES";
   public static final String ER_XERCES_PARSE_ERROR_DETAILS_SZ =  "ER_XERCES_PARSE_ERROR_DETAILS";
   public static final String ER_XERCES_PARSE_ERROR_SZ =  "ER_XERCES_PARSE_ERROR";
   public static final String ER_CANT_OUTPUT_TEXT_BEFORE_DOC_SZ =  	 "ER_CANT_OUTPUT_TEXT_BEFORE_DOC";
   public static final String ER_CANT_HAVE_MORE_THAN_ONE_ROOT_SZ =  	 "ER_CANT_HAVE_MORE_THAN_ONE_ROOT";
   public static final String ER_INVALID_UTF16_SURROGATE_SZ =  "ER_INVALID_UTF16_SURROGATE";
   public static final String ER_OIERROR_SZ =  "ER_OIERROR";
   public static final String ER_CANNOT_CREATE_URL_SZ =  "ER_CANNOT_CREATE_URL";
   public static final String ER_XPATH_READOBJECT_SZ =  "ER_XPATH_READOBJECT";
   public static final String ER_FUNCTION_TOKEN_NOT_FOUND_SZ =  "ER_FUNCTION_TOKEN_NOT_FOUND";
   public static final String ER_ARG_LOCALNAME_NULL_SZ =  "ER_ARG_LOCALNAME_NULL";
   public static final String ER_CANNOT_DEAL_XPATH_TYPE_SZ =  "ER_CANNOT_DEAL_XPATH_TYPE";
   public static final String ER_NODESET_NOT_MUTABLE_SZ =  "ER_NODESET_NOT_MUTABLE";
   public static final String ER_NODESETDTM_NOT_MUTABLE_SZ =  "ER_NODESETDTM_NOT_MUTABLE";
   /**  Variable not resolvable:   *-/
   public static final String ER_VAR_NOT_RESOLVABLE_SZ =  "ER_VAR_NOT_RESOLVABLE";
   /** Null error handler  *-/
   public static final String ER_NULL_ERROR_HANDLER_SZ =  "ER_NULL_ERROR_HANDLER";
   /**  Programmer's assertion: unknown opcode  *-/
   public static final String ER_PROG_ASSERT_UNKNOWN_OPCODE_SZ =  "ER_PROG_ASSERT_UNKNOWN_OPCODE";
   /**  0 or 1   *-/
   public static final String ER_ZERO_OR_ONE_SZ =  "ER_ZERO_OR_ONE";
   /**  rtf() not supported by XRTreeFragSelectWrapper   *-/
   public static final String ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER_SZ =  "ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER";
   /**  asNodeIterator() not supported by XRTreeFragSelectWrapper   *-/
   public static final String ER_ASNODEITERATOR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER_SZ =  "ER_ASNODEITERATOR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER";
   /**  fsb() not supported for XStringForChars   *-/
   public static final String ER_FSB_NOT_SUPPORTED_XSTRINGFORCHARS_SZ =  "ER_FSB_NOT_SUPPORTED_XSTRINGFORCHARS";
   /**  Could not find variable with the name of   *-/
   public static final String ER_COULD_NOT_FIND_VAR_SZ =  "ER_COULD_NOT_FIND_VAR";
   /**  XStringForChars can not take a string for an argument   *-/
   public static final String ER_XSTRINGFORCHARS_CANNOT_TAKE_STRING_SZ =  "ER_XSTRINGFORCHARS_CANNOT_TAKE_STRING";
   /**  The FastStringBuffer argument can not be null   *-/
   public static final String ER_FASTSTRINGBUFFER_CANNOT_BE_NULL_SZ =  "ER_FASTSTRINGBUFFER_CANNOT_BE_NULL";
   /**  2 or 3   *-/
   public static final String ER_TWO_OR_THREE_SZ =  "ER_TWO_OR_THREE";
   /** Variable accessed before it is bound! *-/
   public static final String ER_VARIABLE_ACCESSED_BEFORE_BIND_SZ =  "ER_VARIABLE_ACCESSED_BEFORE_BIND";
   /** XStringForFSB can not take a string for an argument! *-/
   public static final String ER_FSB_CANNOT_TAKE_STRING_SZ =  "ER_FSB_CANNOT_TAKE_STRING";
   /** Error! Setting the root of a walker to null! *-/
   public static final String ER_SETTING_WALKER_ROOT_TO_NULL_SZ =  "ER_SETTING_WALKER_ROOT_TO_NULL";
   /** This NodeSetDTM can not iterate to a previous node! *-/
   public static final String ER_NODESETDTM_CANNOT_ITERATE_SZ =  "ER_NODESETDTM_CANNOT_ITERATE";
   /** This NodeSet can not iterate to a previous node! *-/
   public static final String ER_NODESET_CANNOT_ITERATE_SZ =  "ER_NODESET_CANNOT_ITERATE";
   /** This NodeSetDTM can not do indexing or counting functions! *-/
   public static final String ER_NODESETDTM_CANNOT_INDEX_SZ =  "ER_NODESETDTM_CANNOT_INDEX";
   /** This NodeSet can not do indexing or counting functions! *-/
   public static final String ER_NODESET_CANNOT_INDEX_SZ =  "ER_NODESET_CANNOT_INDEX";
   /** Can not call setShouldCacheNodes after nextNode has been called! *-/
   public static final String ER_CANNOT_CALL_SETSHOULDCACHENODE_SZ =  "ER_CANNOT_CALL_SETSHOULDCACHENODE";
   /** {0} only allows {1} arguments *-/
   public static final String ER_ONLY_ALLOWS_SZ =  "ER_ONLY_ALLOWS";
   /** Programmer's assertion in getNextStepPos: unknown stepType: {0} *-/
   public static final String ER_UNKNOWN_STEP_SZ =  "ER_UNKNOWN_STEP";
   /** Problem with RelativeLocationPath *-/
   public static final String ER_EXPECTED_REL_LOC_PATH_SZ =  "ER_EXPECTED_REL_LOC_PATH";
   /** Problem with LocationPath *-/
   public static final String ER_EXPECTED_LOC_PATH_SZ =  "ER_EXPECTED_LOC_PATH";
   /** Problem with Step *-/
   public static final String ER_EXPECTED_LOC_STEP_SZ =  "ER_EXPECTED_LOC_STEP";
   /** Problem with NodeTest *-/
   public static final String ER_EXPECTED_NODE_TEST_SZ =  "ER_EXPECTED_NODE_TEST";
   /** Expected step pattern *-/
   public static final String ER_EXPECTED_STEP_PATTERN_SZ =  "ER_EXPECTED_STEP_PATTERN";
   /** Expected relative path pattern *-/
   public static final String ER_EXPECTED_REL_PATH_PATTERN_SZ =  "ER_EXPECTED_REL_PATH_PATTERN";
   /** localname in QNAME should be a valid NCName *-/
   public static final String ER_ARG_LOCALNAME_INVALID_SZ =  	 "ER_ARG_LOCALNAME_INVALID";
   /** prefix in QNAME should be a valid NCName *-/
   public static final String ER_ARG_PREFIX_INVALID_SZ =  "ER_ARG_PREFIX_INVALID";
   /** Field ER_CANT_CONVERT_TO_BOOLEAN          *-/
   public static final String ER_CANT_CONVERT_TO_BOOLEAN_SZ =  "ER_CANT_CONVERT_TO_BOOLEAN";
   /** Field ER_CANT_CONVERT_TO_SINGLENODE       *-/
   public static final String ER_CANT_CONVERT_TO_SINGLENODE_SZ =  "ER_CANT_CONVERT_TO_SINGLENODE";
   /** Field ER_CANT_GET_SNAPSHOT_LENGTH         *-/
   public static final String ER_CANT_GET_SNAPSHOT_LENGTH_SZ =  "ER_CANT_GET_SNAPSHOT_LENGTH";
   /** Field ER_NON_ITERATOR_TYPE                *-/
   public static final String ER_NON_ITERATOR_TYPE_SZ =  "ER_NON_ITERATOR_TYPE";
   /** Field ER_DOC_MUTATED                      *-/
   public static final String ER_DOC_MUTATED_SZ =  "ER_DOC_MUTATED";
   public static final String ER_INVALID_XPATH_TYPE_SZ =  "ER_INVALID_XPATH_TYPE";
   public static final String ER_EMPTY_XPATH_RESULT_SZ =  "ER_EMPTY_XPATH_RESULT";
   public static final String ER_INCOMPATIBLE_TYPES_SZ =  "ER_INCOMPATIBLE_TYPES";
   public static final String ER_NULL_RESOLVER_SZ =  "ER_NULL_RESOLVER";
   public static final String ER_CANT_CONVERT_TO_STRING_SZ =  "ER_CANT_CONVERT_TO_STRING";
   public static final String ER_NON_SNAPSHOT_TYPE_SZ =  "ER_NON_SNAPSHOT_TYPE";
   public static final String ER_WRONG_DOCUMENT_SZ =  "ER_WRONG_DOCUMENT";
   /**
   * Note to translators:  The XPath expression cannot be evaluated with respect
   * to this type of node.
   *-/
   /** Field ER_WRONG_NODETYPE                    *-/
   public static final String ER_WRONG_NODETYPE_SZ =  "ER_WRONG_NODETYPE";
   public static final String ER_XPATH_ERROR_SZ =  "ER_XPATH_ERROR";
   public static final String WG_LOCALE_NAME_NOT_HANDLED_SZ =  "WG_LOCALE_NAME_NOT_HANDLED";
   public static final String WG_PROPERTY_NOT_SUPPORTED_SZ =  "WG_PROPERTY_NOT_SUPPORTED";
   public static final String WG_DONT_DO_ANYTHING_WITH_NS_SZ =  "WG_DONT_DO_ANYTHING_WITH_NS";
   public static final String WG_SECURITY_EXCEPTION_SZ =  "WG_SECURITY_EXCEPTION";
   public static final String WG_QUO_NO_LONGER_DEFINED_SZ =  "WG_QUO_NO_LONGER_DEFINED";
   public static final String WG_NEED_DERIVED_OBJECT_TO_IMPLEMENT_NODETEST_SZ =  "WG_NEED_DERIVED_OBJECT_TO_IMPLEMENT_NODETEST";
   public static final String WG_FUNCTION_TOKEN_NOT_FOUND_SZ =  "WG_FUNCTION_TOKEN_NOT_FOUND";
   public static final String WG_COULDNOT_FIND_FUNCTION_SZ =  "WG_COULDNOT_FIND_FUNCTION";
   public static final String WG_CANNOT_MAKE_URL_FROM_SZ = "WG_CANNOT_MAKE_URL_FROM";
   public static final String WG_EXPAND_ENTITIES_NOT_SUPPORTED_SZ =  "WG_EXPAND_ENTITIES_NOT_SUPPORTED";
   public static final String WG_ILLEGAL_VARIABLE_REFERENCE_SZ =  "WG_ILLEGAL_VARIABLE_REFERENCE";
   public static final String WG_UNSUPPORTED_ENCODING_SZ = "WG_UNSUPPORTED_ENCODING";


  /** Field ERROR0000          *-/
  public static final int ERROR0000 = 0;
  /** Field ER_CURRENT_NOT_ALLOWED_IN_MATCH          *-/
  public static final int ER_CURRENT_NOT_ALLOWED_IN_MATCH = 1;
  /** Field ER_CURRENT_TAKES_NO_ARGS          *-/
  public static final int ER_CURRENT_TAKES_NO_ARGS = 2;
  /** Field ER_DOCUMENT_REPLACED          *-/
  public static final int ER_DOCUMENT_REPLACED = 3;
  /** Field ER_CONTEXT_HAS_NO_OWNERDOC          *-/
  public static final int ER_CONTEXT_HAS_NO_OWNERDOC = 4;
  /** Field ER_LOCALNAME_HAS_TOO_MANY_ARGS          *-/
  public static final int ER_LOCALNAME_HAS_TOO_MANY_ARGS = 5;
  /** Field ER_NAMESPACEURI_HAS_TOO_MANY_ARGS          *-/
  public static final int ER_NAMESPACEURI_HAS_TOO_MANY_ARGS = 6;
  /** Field ER_NORMALIZESPACE_HAS_TOO_MANY_ARGS          *-/
  public static final int ER_NORMALIZESPACE_HAS_TOO_MANY_ARGS = 7;
  /** Field ER_NUMBER_HAS_TOO_MANY_ARGS          *-/
  public static final int ER_NUMBER_HAS_TOO_MANY_ARGS = 8;
  /** Field ER_NAME_HAS_TOO_MANY_ARGS          *-/
  public static final int ER_NAME_HAS_TOO_MANY_ARGS = 9;
  /** Field ER_STRING_HAS_TOO_MANY_ARGS          *-/
  public static final int ER_STRING_HAS_TOO_MANY_ARGS = 10;
  /** Field ER_STRINGLENGTH_HAS_TOO_MANY_ARGS          *-/
  public static final int ER_STRINGLENGTH_HAS_TOO_MANY_ARGS = 11;
  /** Field ER_TRANSLATE_TAKES_3_ARGS          *-/
  public static final int ER_TRANSLATE_TAKES_3_ARGS = 12;
  /** Field ER_UNPARSEDENTITYURI_TAKES_1_ARG          *-/
  public static final int ER_UNPARSEDENTITYURI_TAKES_1_ARG = 13;
  /** Field ER_NAMESPACEAXIS_NOT_IMPLEMENTED          *-/
  public static final int ER_NAMESPACEAXIS_NOT_IMPLEMENTED = 14;
  /** Field ER_UNKNOWN_AXIS          *-/
  public static final int ER_UNKNOWN_AXIS = 15;
  /** Field ER_UNKNOWN_MATCH_OPERATION          *-/
  public static final int ER_UNKNOWN_MATCH_OPERATION = 16;
  /** Field ER_INCORRECT_ARG_LENGTH          *-/
  public static final int ER_INCORRECT_ARG_LENGTH = 17;
  /** Field ER_CANT_CONVERT_TO_NUMBER          *-/
  public static final int ER_CANT_CONVERT_TO_NUMBER = 18;
  /** Field ER_CANT_CONVERT_TO_NODELIST          *-/
  public static final int ER_CANT_CONVERT_TO_NODELIST = 19;
  /** Field ER_CANT_CONVERT_TO_MUTABLENODELIST          *-/
  public static final int ER_CANT_CONVERT_TO_MUTABLENODELIST = 20;
  /** Field ER_CANT_CONVERT_TO_TYPE          *-/
  public static final int ER_CANT_CONVERT_TO_TYPE = 21;
  /** Field ER_EXPECTED_MATCH_PATTERN          *-/
  public static final int ER_EXPECTED_MATCH_PATTERN = 22;
  /** Field ER_COULDNOT_GET_VAR_NAMED          *-/
  public static final int ER_COULDNOT_GET_VAR_NAMED = 23;
  /** Field ER_UNKNOWN_OPCODE          *-/
  public static final int ER_UNKNOWN_OPCODE = 24;
  /** Field ER_EXTRA_ILLEGAL_TOKENS          *-/
  public static final int ER_EXTRA_ILLEGAL_TOKENS = 25;
  /** Field ER_EXPECTED_DOUBLE_QUOTE          *-/
  public static final int ER_EXPECTED_DOUBLE_QUOTE = 26;
  /** Field ER_EXPECTED_SINGLE_QUOTE          *-/
  public static final int ER_EXPECTED_SINGLE_QUOTE = 27;
  /** Field ER_EMPTY_EXPRESSION          *-/
  public static final int ER_EMPTY_EXPRESSION = 28;
  /** Field ER_EXPECTED_BUT_FOUND          *-/
  public static final int ER_EXPECTED_BUT_FOUND = 29;
  /** Field ER_INCORRECT_PROGRAMMER_ASSERTION          *-/
  public static final int ER_INCORRECT_PROGRAMMER_ASSERTION = 30;
  /** Field ER_BOOLEAN_ARG_NO_LONGER_OPTIONAL          *-/
  public static final int ER_BOOLEAN_ARG_NO_LONGER_OPTIONAL = 31;
  /** Field ER_FOUND_COMMA_BUT_NO_PRECEDING_ARG          *-/
  public static final int ER_FOUND_COMMA_BUT_NO_PRECEDING_ARG = 32;
  /** Field ER_FOUND_COMMA_BUT_NO_FOLLOWING_ARG          *-/
  public static final int ER_FOUND_COMMA_BUT_NO_FOLLOWING_ARG = 33;
  /** Field ER_PREDICATE_ILLEGAL_SYNTAX          *-/
  public static final int ER_PREDICATE_ILLEGAL_SYNTAX = 34;
  /** Field ER_ILLEGAL_AXIS_NAME          *-/
  public static final int ER_ILLEGAL_AXIS_NAME = 35;
  /** Field ER_UNKNOWN_NODETYPE          *-/
  public static final int ER_UNKNOWN_NODETYPE = 36;
  /** Field ER_PATTERN_LITERAL_NEEDS_BE_QUOTED          *-/
  public static final int ER_PATTERN_LITERAL_NEEDS_BE_QUOTED = 37;
  /** Field ER_COULDNOT_BE_FORMATTED_TO_NUMBER          *-/
  public static final int ER_COULDNOT_BE_FORMATTED_TO_NUMBER = 38;
  /** Field ER_COULDNOT_CREATE_XMLPROCESSORLIAISON          *-/
  public static final int ER_COULDNOT_CREATE_XMLPROCESSORLIAISON = 39;
  /** Field ER_DIDNOT_FIND_XPATH_SELECT_EXP          *-/
  public static final int ER_DIDNOT_FIND_XPATH_SELECT_EXP = 40;
  /** Field ER_COULDNOT_FIND_ENDOP_AFTER_OPLOCATIONPATH          *-/
  public static final int ER_COULDNOT_FIND_ENDOP_AFTER_OPLOCATIONPATH = 41;
  /** Field ER_ERROR_OCCURED          *-/
  public static final int ER_ERROR_OCCURED = 42;
  /** Field ER_ILLEGAL_VARIABLE_REFERENCE          *-/
  public static final int ER_ILLEGAL_VARIABLE_REFERENCE = 43;
  /** Field ER_AXES_NOT_ALLOWED          *-/
  public static final int ER_AXES_NOT_ALLOWED = 44;
  /** Field ER_KEY_HAS_TOO_MANY_ARGS          *-/
  public static final int ER_KEY_HAS_TOO_MANY_ARGS = 45;
  /** Field ER_COUNT_TAKES_1_ARG          *-/
  public static final int ER_COUNT_TAKES_1_ARG = 46;
  /** Field ER_COULDNOT_FIND_FUNCTION          *-/
  public static final int ER_COULDNOT_FIND_FUNCTION = 47;
  /** Field ER_UNSUPPORTED_ENCODING          *-/
  public static final int ER_UNSUPPORTED_ENCODING = 48;
  /** Field ER_PROBLEM_IN_DTM_NEXTSIBLING          *-/
  public static final int ER_PROBLEM_IN_DTM_NEXTSIBLING = 49;
  /** Field ER_CANNOT_WRITE_TO_EMPTYNODELISTIMPL          *-/
  public static final int ER_CANNOT_WRITE_TO_EMPTYNODELISTIMPL = 50;
  /** Field ER_SETDOMFACTORY_NOT_SUPPORTED          *-/
  public static final int ER_SETDOMFACTORY_NOT_SUPPORTED = 51;
  /** Field ER_PREFIX_MUST_RESOLVE          *-/
  public static final int ER_PREFIX_MUST_RESOLVE = 52;
  /** Field ER_PARSE_NOT_SUPPORTED          *-/
  public static final int ER_PARSE_NOT_SUPPORTED = 53;
  /** Field ER_CREATEDOCUMENT_NOT_SUPPORTED          *-/
  public static final int ER_CREATEDOCUMENT_NOT_SUPPORTED = 54;
  /** Field ER_CHILD_HAS_NO_OWNER_DOCUMENT          *-/
  public static final int ER_CHILD_HAS_NO_OWNER_DOCUMENT = 55;
  /** Field ER_CHILD_HAS_NO_OWNER_DOCUMENT_ELEMENT          *-/
  public static final int ER_CHILD_HAS_NO_OWNER_DOCUMENT_ELEMENT = 56;
  /** Field ER_SAX_API_NOT_HANDLED          *-/
  public static final int ER_SAX_API_NOT_HANDLED = 57;
  /** Field ER_IGNORABLE_WHITESPACE_NOT_HANDLED          *-/
  public static final int ER_IGNORABLE_WHITESPACE_NOT_HANDLED = 58;
  /** Field ER_DTM_CANNOT_HANDLE_NODES          *-/
  public static final int ER_DTM_CANNOT_HANDLE_NODES = 59;
  /** Field ER_XERCES_CANNOT_HANDLE_NODES          *-/
  public static final int ER_XERCES_CANNOT_HANDLE_NODES = 60;
  /** Field ER_XERCES_PARSE_ERROR_DETAILS          *-/
  public static final int ER_XERCES_PARSE_ERROR_DETAILS = 61;
  /** Field ER_XERCES_PARSE_ERROR          *-/
  public static final int ER_XERCES_PARSE_ERROR = 62;
  /** Field ER_CANT_OUTPUT_TEXT_BEFORE_DOC          *-/
  public static final int ER_CANT_OUTPUT_TEXT_BEFORE_DOC = 63;
  /** Field ER_CANT_HAVE_MORE_THAN_ONE_ROOT          *-/
  public static final int ER_CANT_HAVE_MORE_THAN_ONE_ROOT = 64;
  /** Field ER_INVALID_UTF16_SURROGATE          *-/
  public static final int ER_INVALID_UTF16_SURROGATE = 65;
  /** Field ER_OIERROR          *-/
  public static final int ER_OIERROR = 66;
  /** Field ER_CANNOT_CREATE_URL          *-/
  public static final int ER_CANNOT_CREATE_URL = 67;
  /** Field ER_XPATH_READOBJECT          *-/
  public static final int ER_XPATH_READOBJECT = 68;
  /** Field ER_FUNCTION_TOKEN_NOT_FOUND         *-/
  public static final int ER_FUNCTION_TOKEN_NOT_FOUND = 69;
  /**  Argument 'localName' is null  *-/
  public static final int ER_ARG_LOCALNAME_NULL = 70;
  /**  Can not deal with XPath type:   *-/
  public static final int ER_CANNOT_DEAL_XPATH_TYPE = 71;
  /**  This NodeSet is not mutable  *-/
  public static final int ER_NODESET_NOT_MUTABLE = 72;
  /**  This NodeSetDTM is not mutable  *-/
  public static final int ER_NODESETDTM_NOT_MUTABLE = 73;
  /**  Variable not resolvable:   *-/
  public static final int ER_VAR_NOT_RESOLVABLE = 74;
  /** Null error handler  *-/
  public static final int ER_NULL_ERROR_HANDLER = 75;
  /**  Programmer's assertion: unknown opcode  *-/
  public static final int ER_PROG_ASSERT_UNKNOWN_OPCODE = 76;
  /**  0 or 1   *-/
  public static final int ER_ZERO_OR_ONE = 77;
  /**  rtf() not supported by XRTreeFragSelectWrapper   *-/
  public static final int ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER = 78;
  /**  asNodeIterator() not supported by XRTreeFragSelectWrapper   *-/
  public static final int ER_ASNODEITERATOR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER = 79;
  /**  fsb() not supported for XStringForChars   *-/
  public static final int ER_FSB_NOT_SUPPORTED_XSTRINGFORCHARS = 80;
  /**  Could not find variable with the name of   *-/
  public static final int ER_COULD_NOT_FIND_VAR = 81;
  /**  XStringForChars can not take a string for an argument   *-/
  public static final int ER_XSTRINGFORCHARS_CANNOT_TAKE_STRING = 82;
  /**  The FastStringBuffer argument can not be null   *-/
  public static final int ER_FASTSTRINGBUFFER_CANNOT_BE_NULL = 83;
  /* MANTIS_XALAN CHANGE: BEGIN *-/
  /**  2 or 3   *-/
  public static final int ER_TWO_OR_THREE = 84;
  /** Variable accessed before it is bound! *-/
  public static final int ER_VARIABLE_ACCESSED_BEFORE_BIND = 85;
  /** XStringForFSB can not take a string for an argument! *-/
  public static final int ER_FSB_CANNOT_TAKE_STRING = 86;
  /** Error! Setting the root of a walker to null! *-/
  public static final int ER_SETTING_WALKER_ROOT_TO_NULL = 87;
  /** This NodeSetDTM can not iterate to a previous node! *-/
  public static final int ER_NODESETDTM_CANNOT_ITERATE = 88;
  /** This NodeSet can not iterate to a previous node! *-/
  public static final int ER_NODESET_CANNOT_ITERATE = 89;
  /** This NodeSetDTM can not do indexing or counting functions! *-/
  public static final int ER_NODESETDTM_CANNOT_INDEX = 90;
  /** This NodeSet can not do indexing or counting functions! *-/
  public static final int ER_NODESET_CANNOT_INDEX = 91;
  /** Can not call setShouldCacheNodes after nextNode has been called! *-/
  public static final int ER_CANNOT_CALL_SETSHOULDCACHENODE = 92;
  /** 
  public static final int ER_ONLY_ALLOWS = 93;
  /** Programmer's assertion in getNextStepPos: unknown stepType: 
  public static final int ER_UNKNOWN_STEP = 94;
//	Note to translators:  A relative location path is a form of XPath expression.
//	 The message indicates that such an expression was expected following the
//	 characters '/' or '//', but was not found.
  /** Problem with RelativeLocationPath *-/
  public static final int ER_EXPECTED_REL_LOC_PATH = 95;
//	 Note to translators:  A location path is a form of XPath expression.
//	 The message indicates that syntactically such an expression was expected,but
//	 the characters specified by the substitution text were encountered instead.
  /** Problem with LocationPath *-/
  public static final int ER_EXPECTED_LOC_PATH = 96;
//	 Note to translators:  A location step is part of an XPath expression.
//	 The message indicates that syntactically such an expression was expected
//	 following the specified characters.
  /** Problem with Step *-/
  public static final int ER_EXPECTED_LOC_STEP = 97;
//	 Note to translators:  A node test is part of an XPath expression that is
//	 used to test for particular kinds of nodes.  In this case, a node test that
//	 consists of an NCName followed by a colon and an asterisk or that consists
//	 of a QName was expected, but was not found.
  /** Problem with NodeTest *-/
  public static final int ER_EXPECTED_NODE_TEST = 98;
//	 Note to translators:  A step pattern is part of an XPath expression.
//	 The message indicates that syntactically such an expression was expected, // but the specified character was found in the expression instead.
  /** Expected step pattern *-/
  public static final int ER_EXPECTED_STEP_PATTERN = 99;
//	 Note to translators: A relative path pattern is part of an XPath expression.
//	 The message indicates that syntactically such an expression was expected, // but was not found.
  /** Expected relative path pattern *-/
  public static final int ER_EXPECTED_REL_PATH_PATTERN = 100;
//	 Note to translators:  A QNAME has the syntactic form [NCName:]NCName
//	 The localname is the portion after the optional colon; the message indicates
//	 that there is a problem with that part of the QNAME.
  /** localname in QNAME should be a valid NCName *-/
  public static final int ER_ARG_LOCALNAME_INVALID = 101;
//	 Note to translators:  A QNAME has the syntactic form [NCName:]NCName
//	 The prefix is the portion before the optional colon; the message indicates
//	 that there is a problem with that part of the QNAME.
  /** prefix in QNAME should be a valid NCName *-/
  public static final int ER_ARG_PREFIX_INVALID = 102;
//	 Note to translators:  The substitution text is the name of a data type.  The
//	 message indicates that a value of a particular type could not be converted
//	 to a value of type string.
  /** Field ER_CANT_CONVERT_TO_BOOLEAN          *-/
  public static final int ER_CANT_CONVERT_TO_BOOLEAN = 103;
//	 Note to translators: Do not translate ANY_UNORDERED_NODE_TYPE and
//	 FIRST_ORDERED_NODE_TYPE.
  /** Field ER_CANT_CONVERT_TO_SINGLENODE       *-/
  public static final int ER_CANT_CONVERT_TO_SINGLENODE = 104;
//	 Note to translators: Do not translate UNORDERED_NODE_SNAPSHOT_TYPE and
//	 ORDERED_NODE_SNAPSHOT_TYPE.
  /** Field ER_CANT_GET_SNAPSHOT_LENGTH         *-/
  public static final int ER_CANT_GET_SNAPSHOT_LENGTH = 105;
  /** Field ER_NON_ITERATOR_TYPE                *-/
  public static final int ER_NON_ITERATOR_TYPE        = 106;
//	 Note to translators: This message indicates that the document being operated
//	 upon changed, so the iterator object that was being used to traverse the
//	 document has now become invalid.
  /** Field ER_DOC_MUTATED                      *-/
  public static final int ER_DOC_MUTATED              = 107;
  /** Field ER_INVALID_XPATH_TYPE               *-/
  public static final int ER_INVALID_XPATH_TYPE       = 108;
  /** Field ER_EMPTY_XPATH_RESULT                *-/
  public static final int ER_EMPTY_XPATH_RESULT       = 109;
  /** Field ER_INCOMPATIBLE_TYPES                *-/
  public static final int ER_INCOMPATIBLE_TYPES       = 110;
  /** Field ER_NULL_RESOLVER                     *-/
  public static final int ER_NULL_RESOLVER            = 111;
//	 Note to translators:  The substitution text is the name of a data type.  The
//	 message indicates that a value of a particular type could not be converted
//	 to a value of type string.
  /** Field ER_CANT_CONVERT_TO_STRING            *-/
  public static final int ER_CANT_CONVERT_TO_STRING   = 112;
//	 Note to translators: Do not translate snapshotItem, // UNORDERED_NODE_SNAPSHOT_TYPE and ORDERED_NODE_SNAPSHOT_TYPE.
  /** Field ER_NON_SNAPSHOT_TYPE                 *-/
  public static final int ER_NON_SNAPSHOT_TYPE       = 113;
//	 Note to translators:  XPathEvaluator is a Java interface name.  An
//	 XPathEvaluator is created with respect to a particular XML document, and in
//	 this case the expression represented by this object was being evaluated with
//	 respect to a context node from a different document.
  /** Field ER_WRONG_DOCUMENT                    *-/
  public static final int ER_WRONG_DOCUMENT          = 114;
//	 Note to translators:  The XPath expression cannot be evaluated with respect
//	 to this type of node.
  /** Field ER_WRONG_NODETYPE                    *-/
  public static final int ER_WRONG_NODETYPE          = 115;
  /** Field ER_XPATH_ERROR                       *-/
  public static final int ER_XPATH_ERROR             = 116;
//	 Warnings...
  /** Field WG_LOCALE_NAME_NOT_HANDLED          *-/
  public static final int WG_LOCALE_NAME_NOT_HANDLED = 1;
  /** Field WG_PROPERTY_NOT_SUPPORTED          *-/
  public static final int WG_PROPERTY_NOT_SUPPORTED = 2;
  /** Field WG_DONT_DO_ANYTHING_WITH_NS          *-/
  public static final int WG_DONT_DO_ANYTHING_WITH_NS = 3;
  /** Field WG_SECURITY_EXCEPTION          *-/
  public static final int WG_SECURITY_EXCEPTION = 4;
  /** Field WG_QUO_NO_LONGER_DEFINED          *-/
  public static final int WG_QUO_NO_LONGER_DEFINED = 5;
  /** Field WG_NEED_DERIVED_OBJECT_TO_IMPLEMENT_NODETEST          *-/
  public static final int WG_NEED_DERIVED_OBJECT_TO_IMPLEMENT_NODETEST = 6;
  /** Field WG_FUNCTION_TOKEN_NOT_FOUND          *-/
  public static final int WG_FUNCTION_TOKEN_NOT_FOUND = 7;
  /** Field WG_COULDNOT_FIND_FUNCTION          *-/
  public static final int WG_COULDNOT_FIND_FUNCTION = 8;
  /** Field WG_CANNOT_MAKE_URL_FROM          *-/
  public static final int WG_CANNOT_MAKE_URL_FROM = 9;
  /** Field WG_EXPAND_ENTITIES_NOT_SUPPORTED          *-/
  public static final int WG_EXPAND_ENTITIES_NOT_SUPPORTED = 10;
  /** Field WG_ILLEGAL_VARIABLE_REFERENCE          *-/
  public static final int WG_ILLEGAL_VARIABLE_REFERENCE = 11;
  /** Field WG_UNSUPPORTED_ENCODING          *-/
  public static final int WG_UNSUPPORTED_ENCODING = 12;

  // Error messages...

  public static final Object[][] contents = {
  { ERROR0000_SZ , "{0}" },
  { ER_CURRENT_NOT_ALLOWED_IN_MATCH_SZ, "The current() function is not allowed in a match pattern!" },
  { ER_CURRENT_TAKES_NO_ARGS_SZ, "The current() function does not accept arguments!" },
  { ER_DOCUMENT_REPLACED_SZ, "document() function implementation has been replaced by org.apache.xalan.xslt.FuncDocument!"},
  { ER_CONTEXT_HAS_NO_OWNERDOC_SZ, "context does not have an owner document!"},
  { ER_LOCALNAME_HAS_TOO_MANY_ARGS_SZ, "local-name() has too many arguments."},
  { ER_NAMESPACEURI_HAS_TOO_MANY_ARGS_SZ, "namespace-uri() has too many arguments."},
  { ER_NORMALIZESPACE_HAS_TOO_MANY_ARGS_SZ, "normalize-space() has too many arguments."},
  { ER_NUMBER_HAS_TOO_MANY_ARGS_SZ, "number() has too many arguments."},
  { ER_NAME_HAS_TOO_MANY_ARGS_SZ, "name() has too many arguments."},
  { ER_STRING_HAS_TOO_MANY_ARGS_SZ, "string() has too many arguments."},
  { ER_STRINGLENGTH_HAS_TOO_MANY_ARGS_SZ, "string-length() has too many arguments."},
  { ER_TRANSLATE_TAKES_3_ARGS_SZ, "The translate() function takes three arguments!"},
  { ER_UNPARSEDENTITYURI_TAKES_1_ARG_SZ, "The unparsed-entity-uri function should take one argument!"},
  { ER_NAMESPACEAXIS_NOT_IMPLEMENTED_SZ, "namespace axis not implemented yet!"},
  { ER_UNKNOWN_AXIS_SZ, "unknown axis: {0}"},
  { ER_UNKNOWN_MATCH_OPERATION_SZ, "unknown match operation!"},
  { ER_INCORRECT_ARG_LENGTH_SZ, "Arg length of processing-instruction() node test is incorrect!"},
  { ER_CANT_CONVERT_TO_NUMBER_SZ, "Can not convert {0} to a number"},
  { ER_CANT_CONVERT_TO_NODELIST_SZ, "Can not convert {0} to a NodeList!"},
  { ER_CANT_CONVERT_TO_MUTABLENODELIST_SZ, "Can not convert {0} to a NodeSetDTM!"},
  { ER_CANT_CONVERT_TO_TYPE_SZ, "Can not convert {0} to a type#{1}"},
  { ER_EXPECTED_MATCH_PATTERN_SZ, "Expected match pattern in getMatchScore!"},
  { ER_COULDNOT_GET_VAR_NAMED_SZ, "Could not get variable named {0}"},
  { ER_UNKNOWN_OPCODE_SZ, "ERROR! Unknown op code: {0}"},
  { ER_EXTRA_ILLEGAL_TOKENS_SZ, "Extra illegal tokens: {0}"},
  { ER_EXPECTED_DOUBLE_QUOTE_SZ, "misquoted literal... expected double quote!"},
  { ER_EXPECTED_SINGLE_QUOTE_SZ, "misquoted literal... expected single quote!"},
  { ER_EMPTY_EXPRESSION_SZ, "Empty expression!"},
  { ER_EXPECTED_BUT_FOUND_SZ, "Expected {0}, but found: {1}"},
  { ER_INCORRECT_PROGRAMMER_ASSERTION_SZ, "Programmer assertion is incorrect! - {0}"},
  { ER_BOOLEAN_ARG_NO_LONGER_OPTIONAL_SZ, "boolean(...) argument is no longer optional with 19990709 XPath draft."},
  { ER_FOUND_COMMA_BUT_NO_PRECEDING_ARG_SZ, "Found ',' but no preceding argument!"},
  { ER_FOUND_COMMA_BUT_NO_FOLLOWING_ARG_SZ, "Found ',' but no following argument!"},
  { ER_PREDICATE_ILLEGAL_SYNTAX_SZ, "'..[predicate]' or '.[predicate]' is illegal syntax.  Use 'self::node()[predicate]' instead."},
  { ER_ILLEGAL_AXIS_NAME_SZ, "illegal axis name: {0}"},
  { ER_UNKNOWN_NODETYPE_SZ, "Unknown nodetype: {0}"},
  { ER_PATTERN_LITERAL_NEEDS_BE_QUOTED_SZ, "Pattern literal ({0}) needs to be quoted!"},
  { ER_COULDNOT_BE_FORMATTED_TO_NUMBER_SZ, "{0} could not be formatted to a number!"},
  { ER_COULDNOT_CREATE_XMLPROCESSORLIAISON_SZ, "Could not create XML TransformerFactory Liaison: {0}"},
  { ER_DIDNOT_FIND_XPATH_SELECT_EXP_SZ, "Error! Did not find xpath select expression (-select)."},
  { ER_COULDNOT_FIND_ENDOP_AFTER_OPLOCATIONPATH_SZ, "ERROR! Could not find ENDOP after OP_LOCATIONPATH"},
  { ER_ERROR_OCCURED_SZ, "Error occured!"},
  { ER_ILLEGAL_VARIABLE_REFERENCE_SZ, "VariableReference given for variable out of context or without definition!  Name = {0}"},
  { ER_AXES_NOT_ALLOWED_SZ, "Only child:: and attribute:: axes are allowed in match patterns!  Offending axes = {0}"},
  { ER_KEY_HAS_TOO_MANY_ARGS_SZ, "key() has an incorrect number of arguments."},
  { ER_COUNT_TAKES_1_ARG_SZ, "The count function should take one argument!"},
  { ER_COULDNOT_FIND_FUNCTION_SZ, "Could not find function: {0}"},
  { ER_UNSUPPORTED_ENCODING_SZ, "Unsupported encoding: {0}"},
  { ER_PROBLEM_IN_DTM_NEXTSIBLING_SZ, "Problem occured in DTM in getNextSibling... trying to recover"},
  { ER_CANNOT_WRITE_TO_EMPTYNODELISTIMPL_SZ, "Programmer error: EmptyNodeList can not be written to."},
  { ER_SETDOMFACTORY_NOT_SUPPORTED_SZ, "setDOMFactory is not supported by XPathContext!"},
  { ER_PREFIX_MUST_RESOLVE_SZ, "Prefix must resolve to a namespace: {0}"},
  { ER_PARSE_NOT_SUPPORTED_SZ, "parse (InputSource source) not supported in XPathContext! Can not open {0}"},
  { ER_SAX_API_NOT_HANDLED_SZ, "SAX API characters(char ch[]... not handled by the DTM!"},
  { ER_IGNORABLE_WHITESPACE_NOT_HANDLED_SZ, "ignorableWhitespace(char ch[]... not handled by the DTM!"},
  { ER_DTM_CANNOT_HANDLE_NODES_SZ, "DTMLiaison can not handle nodes of type {0}"},
  { ER_XERCES_CANNOT_HANDLE_NODES_SZ, "DOM2Helper can not handle nodes of type {0}"},
  { ER_XERCES_PARSE_ERROR_DETAILS_SZ, "DOM2Helper.parse error: SystemID - {0} line - {1}"},
  { ER_XERCES_PARSE_ERROR_SZ, "DOM2Helper.parse error"},
  { ER_INVALID_UTF16_SURROGATE_SZ, "Invalid UTF-16 surrogate detected: {0} ?"},
  { ER_OIERROR_SZ, "IO error"},
  { ER_CANNOT_CREATE_URL_SZ, "Cannot create url for: {0}"},
  { ER_XPATH_READOBJECT_SZ, "In XPath.readObject: {0}"},
  { ER_FUNCTION_TOKEN_NOT_FOUND_SZ, "function token not found."},
  { ER_CANNOT_DEAL_XPATH_TYPE_SZ, "Can not deal with XPath type: {0}"},
  { ER_NODESET_NOT_MUTABLE_SZ, "This NodeSet is not mutable"},
  { ER_NODESETDTM_NOT_MUTABLE_SZ, "This NodeSetDTM is not mutable"},
  { ER_VAR_NOT_RESOLVABLE_SZ, "Variable not resolvable: {0}"},
  { ER_NULL_ERROR_HANDLER_SZ, "Null error handler"},
  { ER_PROG_ASSERT_UNKNOWN_OPCODE_SZ, "Programmer''s assertion: unknown opcode: {0}"},
  { ER_ZERO_OR_ONE_SZ, "0 or 1"},
  { ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER_SZ, "rtf() not supported by XRTreeFragSelectWrapper"},
  { ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER_SZ, "asNodeIterator() not supported by XRTreeFragSelectWrapper"},
  { ER_FSB_NOT_SUPPORTED_XSTRINGFORCHARS_SZ, "fsb() not supported for XStringForChars"},
  { ER_COULD_NOT_FIND_VAR_SZ, "Could not find variable with the name of {0}"},
  { ER_XSTRINGFORCHARS_CANNOT_TAKE_STRING_SZ, "XStringForChars can not take a string for an argument"},
  { ER_FASTSTRINGBUFFER_CANNOT_BE_NULL_SZ, "The FastStringBuffer argument can not be null"},
  { ER_TWO_OR_THREE_SZ, "2 or 3"},
  { ER_VARIABLE_ACCESSED_BEFORE_BIND_SZ, "Variable accessed before it is bound!"},
  { ER_FSB_CANNOT_TAKE_STRING_SZ, "XStringForFSB can not take a string for an argument!"},
  { ER_SETTING_WALKER_ROOT_TO_NULL_SZ, "\n !!!! Error! Setting the root of a walker to null!!!"},
  { ER_NODESETDTM_CANNOT_ITERATE_SZ, "This NodeSetDTM can not iterate to a previous node!"},
  { ER_NODESET_CANNOT_ITERATE_SZ, "This NodeSet can not iterate to a previous node!"},
  { ER_NODESETDTM_CANNOT_INDEX_SZ, "This NodeSetDTM can not do indexing or counting functions!"},
  { ER_NODESET_CANNOT_INDEX_SZ, "This NodeSet can not do indexing or counting functions!"},
  { ER_CANNOT_CALL_SETSHOULDCACHENODE_SZ, "Can not call setShouldCacheNodes after nextNode has been called!"},
  { ER_ONLY_ALLOWS_SZ, "{0} only allows {1} arguments"},
  { ER_UNKNOWN_STEP_SZ, "Programmer''s assertion in getNextStepPos: unknown stepType: {0}"},
  { ER_EXPECTED_REL_LOC_PATH_SZ, "A relative location path was expected following the '/' or ' ' token."},
  { ER_EXPECTED_LOC_PATH_SZ, "A location path was expected, but the following token was encountered\u003a  {0}"},
  { ER_EXPECTED_LOC_STEP_SZ, "A location step was expected following the '/' or ' ' token."},
  { ER_EXPECTED_NODE_TEST_SZ, "A node test that matches either NCName:* or QName was expected."},
  { ER_EXPECTED_STEP_PATTERN_SZ, "A step pattern was expected, but '/' was encountered."},
  { ER_EXPECTED_REL_PATH_PATTERN_SZ, "A relative path pattern was expected."},
  { ER_CANT_CONVERT_TO_BOOLEAN_SZ, "Cannot convert {0} to a boolean."},
  { ER_CANT_CONVERT_TO_SINGLENODE_SZ, "Cannot convert {0} to a single node. This getter applies to types ANY_UNORDERED_NODE_TYPE and FIRST_ORDERED_NODE_TYPE."},
  { ER_CANT_GET_SNAPSHOT_LENGTH_SZ, "Cannot get snapshot length on type: {0}. This getter applies to types UNORDERED_NODE_SNAPSHOT_TYPE and ORDERED_NODE_SNAPSHOT_TYPE."},
  { ER_NON_ITERATOR_TYPE_SZ, "Cannot iterate over non-iterator type: {0}"},
  { ER_DOC_MUTATED_SZ, "Document mutated since result was returned. Iterator is invalid."},
  { ER_INVALID_XPATH_TYPE_SZ, "Invalid XPath type argument: {0}"},
  { ER_EMPTY_XPATH_RESULT_SZ, "Empty XPath result object"},
  { ER_INCOMPATIBLE_TYPES_SZ, "The returned type: {0} cannot be coerced into the specified type: {1}"},
  { ER_NULL_RESOLVER_SZ, "Unable to resolve prefix with null prefix resolver."},
  { ER_CANT_CONVERT_TO_STRING_SZ, "Cannot convert {0} to a string."},
  { ER_NON_SNAPSHOT_TYPE_SZ, "Cannot call snapshotItem on type: {0}. This method applies to types UNORDERED_NODE_SNAPSHOT_TYPE and ORDERED_NODE_SNAPSHOT_TYPE."},
  { ER_WRONG_DOCUMENT_SZ, "Context node does not belong to the document that is bound to this XPathEvaluator."},
  { ER_WRONG_NODETYPE_SZ, "The context node type is not supported."},
  { ER_XPATH_ERROR_SZ, "Unknown error in XPath."},
  { WG_LOCALE_NAME_NOT_HANDLED_SZ, "locale name in the format-number function not yet handled!"},
  { WG_PROPERTY_NOT_SUPPORTED_SZ, "XSL Property not supported: {0}"},
  { WG_DONT_DO_ANYTHING_WITH_NS_SZ, "Do not currently do anything with namespace {0} in property: {1}"},
  { WG_SECURITY_EXCEPTION_SZ, "SecurityException when trying to access XSL system property: {0}"},
  { WG_QUO_NO_LONGER_DEFINED_SZ, "Old syntax: quo(...) is no longer defined in XPath."},
  { WG_NEED_DERIVED_OBJECT_TO_IMPLEMENT_NODETEST_SZ, "XPath needs a derived object to implement nodeTest!"},
  { WG_FUNCTION_TOKEN_NOT_FOUND_SZ, "function token not found."},
  { WG_COULDNOT_FIND_FUNCTION_SZ, "Could not find function: {0}"},
  { WG_CANNOT_MAKE_URL_FROM_SZ, "Can not make URL from: {0}"},
  { WG_EXPAND_ENTITIES_NOT_SUPPORTED_SZ, "-E option not supported for DTM parser"},
  { WG_ILLEGAL_VARIABLE_REFERENCE_SZ, "VariableReference given for variable out of context or without definition!  Name = {0}"},
  { WG_UNSUPPORTED_ENCODING_SZ, "Unsupported encoding: {0}"},
  { "ui_language", "en"},
  { "help_language", "en"},
  { "language", "en"},
  { "BAD_CODE", "Parameter to createMessage was out of bounds"},
  { "FORMAT_FAILED", "Exception thrown during messageFormat call"},
  { "version", ">>>>>>> Xalan Version "},
  { "version2", "<<<<<<<"},
  { "yes", "yes"},
  { "line", "Line #"},
  { "column", "Column #"},
  { "xsldone", "XSLProcessor: done"},
  { "xpath_option", "xpath options: "},
  { "optionIN", "   [-in inputXMLURL]"},
  { "optionSelect", "   [-select xpath expression]"},
  { "optionMatch", "   [-match match pattern (for match diagnostics)]"},
  { "optionAnyExpr", "Or just an xpath expression will do a diagnostic dump"},
  { "noParsermsg1", "XSL Process was not successful."},
  { "noParsermsg2", "** Could not find parser **"},
  { "noParsermsg3", "Please check your classpath."},
  { "noParsermsg4", "If you don't have IBM's XML Parser for Java, you can download it from"},
  { "noParsermsg5", "IBM's AlphaWorks: http://www.alphaworks.ibm.com/formula/xml"}, 
  { "gtone", ">1" },
  { "zero", "0" },
  { "one", "1" },
  { "two" , "2" },
  { "three", "3" }
  };

  // ================= INFRASTRUCTURE ======================

  /** Field BAD_CODE          *-/
  public static final String BAD_CODE = "BAD_CODE";

  /** Field FORMAT_FAILED          *-/
  public static final String FORMAT_FAILED = "FORMAT_FAILED";

  /** Field ERROR_RESOURCES          *-/
  public static final String ERROR_RESOURCES =
	"org.apache.xpath.res.XPATHErrorResources";

  /** Field ERROR_STRING          *-/
  public static final String ERROR_STRING = "#error";

  /** Field ERROR_HEADER          *-/
  public static final String ERROR_HEADER = "Error: ";

  /** Field WARNING_HEADER          *-/
  public static final String WARNING_HEADER = "Warning: ";

  /** Field XSL_HEADER          *-/
  public static final String XSL_HEADER = "XSL ";

  /** Field XML_HEADER          *-/
  public static final String XML_HEADER = "XML ";

  /** Field QUERY_HEADER          *-/
  public static final String QUERY_HEADER = "PATTERN ";

  /**
   * Get the association list.
   *
   * @return The association list.
   *-/
  public Object[][] getContents()
  {
	return contents;
  }

  /**
   * Return a named ResourceBundle for a particular locale.  This method mimics the behavior
   * of ResourceBundle.getBundle().
   *
   * @param res the name of the resource to load.
   * @param locale the locale to prefer when searching for the bundle
   *
   * @param className Name of local-specific subclass.
   * @return the ResourceBundle
   * @throws MissingResourceException
   *-/
  public static final XPATHErrorResources loadResourceBundle(String className)
		  throws MissingResourceException
  {

	Locale locale = Locale.getDefault();
	String suffix = getResourceSuffix(locale);

	try
	{

	  // first try with the given locale
	  return (XPATHErrorResources) ResourceBundle.getBundle(className
			  + suffix, locale);
	}
	catch (MissingResourceException e)
	{
	  try  // try to fall back to en_US if we can't load
	  {

		// Since we can't find the localized property file,
		// fall back to en_US.
		return (XPATHErrorResources) ResourceBundle.getBundle(className,
				new Locale("en", "US"));
	  }
	  catch (MissingResourceException e2)
	  {

		// Now we are really in trouble.
		// very bad, definitely very bad...not going to get very far
		throw new MissingResourceException(
		  "Could not load any resource bundles.", className, "");
	  }
	}
  }

  /**
   * Return the resource file suffic for the indicated locale
   * For most locales, this will be based the language code.  However
   * for Chinese, we do distinguish between Taiwan and PRC
   *
   * @param locale the locale
   * @return an String suffix which canbe appended to a resource name
   *-/
  private static final String getResourceSuffix(Locale locale)
  {

	String suffix = "_" + locale.getLanguage();
	String country = locale.getCountry();

	if (country.equals("TW"))
	  suffix += "_" + country;

	return suffix;
  }

/* (non-Javadoc)
 * @see framework.ressource.xpath.res.XResourceBundleBase#getMessageKey(int)
 *-/
public String getMessageKey(int errorCode) {
	if (errorCode > MAX_CODE)
	  return null;
	else
	{
	  DecimalFormat df = new DecimalFormat("0000");

	  return ERROR_SUFFIX + df.format(errorCode);
	}
}

/* (non-Javadoc)
 * @see framework.ressource.xpath.res.XResourceBundleBase#getWarningKey(int)
 *-/
public String getWarningKey(int errorCode) {
	// TODO Raccord de méthode auto-généré
	return null;
}

}
*/