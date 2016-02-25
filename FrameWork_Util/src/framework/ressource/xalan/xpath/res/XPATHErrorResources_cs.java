// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPATHErrorResources_cs.java

package framework.ressource.xalan.xpath.res;

import java.util.*;

// Referenced classes of package framework.ressource.xalan.xpath.res:
//            XPATHErrorResources

public class XPATHErrorResources_cs extends ListResourceBundle
{

    public XPATHErrorResources_cs()
    {
    }

    public Object[][] getContents()
    {
        return (new Object[][] {
            new Object[] {
                "ERROR0000", "{0}"
            }, new Object[] {
                "ER_CURRENT_NOT_ALLOWED_IN_MATCH", "Funkce current() nen\355 ve vzorku shody povolena!"
            }, new Object[] {
                "ER_CURRENT_TAKES_NO_ARGS", "Funkce current() neakceptuje argumenty!"
            }, new Object[] {
                "ER_DOCUMENT_REPLACED", "implementace funkce document() byla nahrazena funkc\355 org.apache.xalan.xslt.FuncDocument!"
            }, new Object[] {
                "ER_CONTEXT_HAS_NO_OWNERDOC", "Parametr context nem\341 dokument vlastn\355ka!"
            }, new Object[] {
                "ER_LOCALNAME_HAS_TOO_MANY_ARGS", "P\u0159\355li\u0161 mnoho argument\u016F funkce local-name()."
            }, new Object[] {
                "ER_NAMESPACEURI_HAS_TOO_MANY_ARGS", "P\u0159\355li\u0161 mnoho argument\u016F funkce namespace-uri()."
            }, new Object[] {
                "ER_NORMALIZESPACE_HAS_TOO_MANY_ARGS", "P\u0159\355li\u0161 mnoho argument\u016F funkce normalize-space()."
            }, new Object[] {
                "ER_NUMBER_HAS_TOO_MANY_ARGS", "P\u0159\355li\u0161 mnoho argument\u016F funkce number()."
            }, new Object[] {
                "ER_NAME_HAS_TOO_MANY_ARGS", "P\u0159\355li\u0161 mnoho argument\u016F funkce name()."
            }, new Object[] {
                "ER_STRING_HAS_TOO_MANY_ARGS", "P\u0159\355li\u0161 mnoho argument\u016F funkce string()."
            }, new Object[] {
                "ER_STRINGLENGTH_HAS_TOO_MANY_ARGS", "P\u0159\355li\u0161 mnoho argument\u016F funkce string-length()."
            }, new Object[] {
                "ER_TRANSLATE_TAKES_3_ARGS", "Funkce translate() akceptuje t\u0159i argumenty!"
            }, new Object[] {
                "ER_UNPARSEDENTITYURI_TAKES_1_ARG", "Funkce unparsed-entity-uri mus\355 akceptovat jeden argument!"
            }, new Object[] {
                "ER_NAMESPACEAXIS_NOT_IMPLEMENTED", "Obor n\341zv\u016F axis nebyl je\u0161t\u011B implementov\341n!"
            }, new Object[] {
                "ER_UNKNOWN_AXIS", "nezn\341m\375 parametr axis: {0}"
            }, new Object[] {
                "ER_UNKNOWN_MATCH_OPERATION", "nezn\341m\341 operace shody!"
            }, new Object[] {
                "ER_INCORRECT_ARG_LENGTH", "Nespr\341vn\341 d\351lka argumentu testu uzlu processing-instruction()!"
            }, new Object[] {
                "ER_CANT_CONVERT_TO_NUMBER", "{0} nelze p\u0159ev\351st na parametr number"
            }, new Object[] {
                "ER_CANT_CONVERT_TO_NODELIST", "{0} nelze p\u0159ev\351st na parametr NodeList!"
            }, new Object[] {
                "ER_CANT_CONVERT_TO_MUTABLENODELIST", "{0} nelze p\u0159ev\351st na parametr NodeSetDTM!"
            }, new Object[] {
                "ER_CANT_CONVERT_TO_TYPE", "{0} nelze p\u0159ev\351st na parametr type#{1}"
            }, new Object[] {
                "ER_EXPECTED_MATCH_PATTERN", "Funkce getMatchScore o\u010Dek\341v\341 parametr!"
            }, new Object[] {
                "ER_COULDNOT_GET_VAR_NAMED", "Nelze z\355skat prom\u011Bnnou s n\341zvem {0}"
            }, new Object[] {
                "ER_UNKNOWN_OPCODE", "Chyba! Nezn\341m\375 k\363d operace: {0}"
            }, new Object[] {
                "ER_EXTRA_ILLEGAL_TOKENS", "Dal\u0161\355 nepovolen\351 tokeny: {0}"
            }, new Object[] {
                "ER_EXPECTED_DOUBLE_QUOTE", "nespr\341vn\u011B uveden\375 liter\341l... Byly o\u010Dek\341v\341ny uvozovky!"
            }, new Object[] {
                "ER_EXPECTED_SINGLE_QUOTE", "nespr\341vn\u011B uveden\375 liter\341l... Byly o\u010Dek\341v\341ny jednoduch\351 uvozovky!"
            }, new Object[] {
                "ER_EMPTY_EXPRESSION", "Pr\341zdn\375 v\375raz!"
            }, new Object[] {
                "ER_EXPECTED_BUT_FOUND", "O\u010Dek\341v\341no: {0}, ale nalezeno: {1}"
            }, new Object[] {
                "ER_INCORRECT_PROGRAMMER_ASSERTION", "Nespr\341vn\351 tvrzen\355 program\341tora! - {0}"
            }, new Object[] {
                "ER_BOOLEAN_ARG_NO_LONGER_OPTIONAL", "booleovsk\375(...) argument ji\u017E nen\355 v n\341vrhu 19990709 XPath voliteln\375."
            }, new Object[] {
                "ER_FOUND_COMMA_BUT_NO_PRECEDING_ARG", "Byl nalezen znak ',' bez p\u0159edchoz\355ho argumentu!"
            }, new Object[] {
                "ER_FOUND_COMMA_BUT_NO_FOLLOWING_ARG", "Byl nalezen znak ',' bez n\341sleduj\355c\355ho argumentu!"
            }, new Object[] {
                "ER_PREDICATE_ILLEGAL_SYNTAX", "V\375raz '..[predicate]' nebo '.[predicate]' m\341 nespr\341vnou syntaxi. Pou\u017Eijte m\355sto toho 'self::node()[predicate]'."
            }, new Object[] {
                "ER_ILLEGAL_AXIS_NAME", "nepovolen\375 n\341zev osy: {0}"
            }, new Object[] {
                "ER_UNKNOWN_NODETYPE", "Nezn\341m\375 typ uzlu: {0}"
            }, new Object[] {
                "ER_PATTERN_LITERAL_NEEDS_BE_QUOTED", "Je nutno uv\351st vzorek liter\341lu ({0})!"
            }, new Object[] {
                "ER_COULDNOT_BE_FORMATTED_TO_NUMBER", "{0} nelze zform\341tovat jako \u010D\355slo!"
            }, new Object[] {
                "ER_COULDNOT_CREATE_XMLPROCESSORLIAISON", "Nelze vytvo\u0159it prvek XML TransformerFactory Liaison: {0}"
            }, new Object[] {
                "ER_DIDNOT_FIND_XPATH_SELECT_EXP", "Chyba! Nebyl nalezen v\375raz v\375b\u011Bru xpath (-select)."
            }, new Object[] {
                "ER_COULDNOT_FIND_ENDOP_AFTER_OPLOCATIONPATH", "Chyba! Nebyl nalezen v\375raz ENDOP po OP_LOCATIONPATH"
            }, new Object[] {
                "ER_ERROR_OCCURED", "Do\u0161lo k chyb\u011B!"
            }, new Object[] {
                "ER_ILLEGAL_VARIABLE_REFERENCE", "Odkaz VariableReference uveden k prom\u011Bnn\351 mimo kontext nebo bez definice!  N\341zev = {0}"
            }, new Object[] {
                "ER_AXES_NOT_ALLOWED", "Ve vzorc\355ch shody jsou povoleny pouze osy child:: a attribute::!  Nepovolen\351 osy = {0}"
            }, new Object[] {
                "ER_KEY_HAS_TOO_MANY_ARGS", "nespr\341vn\375 po\u010Det argument\u016F parametru key()."
            }, new Object[] {
                "ER_COUNT_TAKES_1_ARG", "Funkce count mus\355 obsahovat jeden argument!"
            }, new Object[] {
                "ER_COULDNOT_FIND_FUNCTION", "Nelze nal\351zt funkci: {0}"
            }, new Object[] {
                "ER_UNSUPPORTED_ENCODING", "Nepodporovan\351 k\363dov\341n\355: {0}"
            }, new Object[] {
                "ER_PROBLEM_IN_DTM_NEXTSIBLING", "Ve funkci getNextSibling do\u0161lo v DTM k chyb\u011B... Prob\355h\341 pokus o obnovu"
            }, new Object[] {
                "ER_CANNOT_WRITE_TO_EMPTYNODELISTIMPL", "Chyba program\341tora: Do funkce EmptyNodeList nelze zapisovat."
            }, new Object[] {
                "ER_SETDOMFACTORY_NOT_SUPPORTED", "Funkce XPathContext nepodporuje funkci setDOMFactory!"
            }, new Object[] {
                "ER_PREFIX_MUST_RESOLVE", "P\u0159edponu mus\355 b\375t mo\u017Eno p\u0159elo\u017Eit do oboru n\341zv\u016F: {0}"
            }, new Object[] {
                "ER_PARSE_NOT_SUPPORTED", "Funkce XPathContext nepodporuje anal\375zu (InputSource source)! {0} - nelze otev\u0159\355t"
            }, new Object[] {
                "ER_SAX_API_NOT_HANDLED", "Znaky SAX API (char ch[]... nen\355 v DTM zpracov\341v\341na!"
            }, new Object[] {
                "ER_IGNORABLE_WHITESPACE_NOT_HANDLED", "Funkce ignorableWhitespace(char ch[]... nen\355 v DTM zpracov\341v\341na!"
            }, new Object[] {
                "ER_DTM_CANNOT_HANDLE_NODES", "Funkce DTMLiaison nem\u016F\u017Ee zpracov\341vat uzly typu {0}"
            }, new Object[] {
                "ER_XERCES_CANNOT_HANDLE_NODES", "Funkce DOM2Helper nem\u016F\u017Ee zpracov\341vat uzly typu {0}"
            }, new Object[] {
                "ER_XERCES_PARSE_ERROR_DETAILS", "Chyba funkce DOM2Helper.parse: SystemID - {0} \u0159\341dek - {1}"
            }, new Object[] {
                "ER_XERCES_PARSE_ERROR", "Chyba funkce DOM2Helper.parse"
            }, new Object[] {
                "ER_INVALID_UTF16_SURROGATE", "Byla zji\u0161t\u011Bna neplatn\341 n\341hrada UTF-16: {0} ?"
            }, new Object[] {
                "ER_OIERROR", "Chyba vstupu/v\375stupu"
            }, new Object[] {
                "ER_CANNOT_CREATE_URL", "Nelze vytvo\u0159it url pro: {0}"
            }, new Object[] {
                "ER_XPATH_READOBJECT", "Ve funkci XPath.readObject: {0}"
            }, new Object[] {
                "ER_FUNCTION_TOKEN_NOT_FOUND", "nebyl nalezen token funkce."
            }, new Object[] {
                "ER_CANNOT_DEAL_XPATH_TYPE", "Nelze pracovat s typem XPath: {0}"
            }, new Object[] {
                "ER_NODESET_NOT_MUTABLE", "Tento prvek NodeSet nelze m\u011Bnit"
            }, new Object[] {
                "ER_NODESETDTM_NOT_MUTABLE", "Tento prvek NodeSetDTM nelze m\u011Bnit"
            }, new Object[] {
                "ER_VAR_NOT_RESOLVABLE", "Prom\u011Bnnou nelze p\u0159elo\u017Eit: {0}"
            }, new Object[] {
                "ER_NULL_ERROR_HANDLER", "Obslu\u017En\375 program pro zpracov\341n\355 chyb hodnoty null"
            }, new Object[] {
                "ER_PROG_ASSERT_UNKNOWN_OPCODE", "Tvrzen\355 program\341tora: nezn\341m\375 k\363d operace: {0}"
            }, new Object[] {
                "ER_ZERO_OR_ONE", "0 nebo 1"
            }, new Object[] {
                "ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "Modul XRTreeFragSelectWrapper nepodporuje rtf()"
            }, new Object[] {
                "ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "Modul XRTreeFragSelectWrapper nepodporuje funkci asNodeIterator()"
            }, new Object[] {
                "ER_DETACH_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "Modul XRTreeFragSelectWrapper nepodporuje funkci detach()"
            }, new Object[] {
                "ER_NUM_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "Modul XRTreeFragSelectWrapper nepodporuje funkci num()"
            }, new Object[] {
                "ER_XSTR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "Modul XRTreeFragSelectWrapper nepodporuje funkci xstr()"
            }, new Object[] {
                "ER_STR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "Modul XRTreeFragSelectWrapper nepodporuje funkci str()"
            }, new Object[] {
                "ER_FSB_NOT_SUPPORTED_XSTRINGFORCHARS", "Funkce XStringForChars nepodporuje funkci fsb()"
            }, new Object[] {
                "ER_COULD_NOT_FIND_VAR", "Nelze nal\351zt prom\u011Bnnou s n\341zvem {0}"
            }, new Object[] {
                "ER_XSTRINGFORCHARS_CANNOT_TAKE_STRING", "Argumentem funkce XStringForChars nem\u016F\u017Ee b\375t \u0159et\u011Bzec"
            }, new Object[] {
                "ER_FASTSTRINGBUFFER_CANNOT_BE_NULL", "Argument funkce FastStringBuffer nem\u016F\u017Ee m\355t hodnotu null"
            }, new Object[] {
                "ER_TWO_OR_THREE", "2 nebo 3"
            }, new Object[] {
                "ER_VARIABLE_ACCESSED_BEFORE_BIND", "P\u0159\355stup k prom\u011Bnn\351 p\u0159edt\355m, ne\u017E je z\341vazn\341!"
            }, new Object[] {
                "ER_FSB_CANNOT_TAKE_STRING", "Argumentem funkce XStringForFSB nem\u016F\u017Ee b\375t \u0159et\u011Bzec!"
            }, new Object[] {
                "ER_SETTING_WALKER_ROOT_TO_NULL", "\n !!!! Chyba! Nastaven\355 ko\u0159ene objektu walker na hodnotu null!!!"
            }, new Object[] {
                "ER_NODESETDTM_CANNOT_ITERATE", "Tato funkce NodeSetDTM nem\u016F\u017Ee b\375t stejn\341 jako p\u0159edch\341zej\355c\355 uzel!"
            }, new Object[] {
                "ER_NODESET_CANNOT_ITERATE", "Tato funkce NodeSet nem\u016F\u017Ee b\375t stejn\341 jako p\u0159edch\341zej\355c\355 uzel!"
            }, new Object[] {
                "ER_NODESETDTM_CANNOT_INDEX", "Tato funkce NodeSetDTM nem\u016F\u017Ee prov\341d\u011Bt indexovac\355 nebo po\u010Detn\355 funkce!"
            }, new Object[] {
                "ER_NODESET_CANNOT_INDEX", "Tato funkce NodeSet nem\u016F\u017Ee prov\341d\u011Bt indexovac\355 nebo po\u010Detn\355 funkce!"
            }, new Object[] {
                "ER_CANNOT_CALL_SETSHOULDCACHENODE", "Nelze volat funkci setShouldCacheNodes pot\351, co byla vol\341na funkce nextNode!"
            }, new Object[] {
                "ER_ONLY_ALLOWS", "{0} povoluje pouze {1} argument\u016F"
            }, new Object[] {
                "ER_UNKNOWN_STEP", "Tvrzen\355 program\341tora ve funkci getNextStepPos: nezn\341m\375 typ stepType: {0}"
            }, new Object[] {
                "ER_EXPECTED_REL_LOC_PATH", "Po tokenu '/' nebo '//' byla o\u010Dek\341v\341na cesta relativn\355ho um\355st\u011Bn\355."
            }, new Object[] {
                "ER_EXPECTED_LOC_PATH", "O\u010Dek\341vala se cesta um\355st\u011Bn\355, av\u0161ak byl zaznamen\341n n\341sleduj\355c\355 token:  {0}"
            }, new Object[] {
                "ER_EXPECTED_LOC_PATH_AT_END_EXPR", "Byla o\u010Dek\341v\341na cesta um\355st\u011Bn\355, m\355sto toho v\u0161ak byl nalezen konec v\375razu XPath. "
            }, new Object[] {
                "ER_EXPECTED_LOC_STEP", "Po tokenu '/' nebo '//' byl o\u010Dek\341v\341n krok um\355st\u011Bn\355"
            }, new Object[] {
                "ER_EXPECTED_NODE_TEST", "Byl o\u010Dek\341v\341n test uzlu, kter\375 odpov\355d\341 bu\u010F prvk\u016Fm NCName:* nebo QName."
            }, new Object[] {
                "ER_EXPECTED_STEP_PATTERN", "Byl o\u010Dek\341v\341n vzorek kroku, av\u0161ak byl zaznamen\341n znak '/'."
            }, new Object[] {
                "ER_EXPECTED_REL_PATH_PATTERN", "Byl o\u010Dek\341v\341n vzorek relativn\355 cesty."
            }, new Object[] {
                "ER_CANT_CONVERT_TO_BOOLEAN", "Hodnota XPathResult v\375razu XPath ''{0}'' je typu XPathResultType {1}, kter\375 nelze p\u0159ev\351st na booleovsk\375 typ. "
            }, new Object[] {
                "ER_CANT_CONVERT_TO_SINGLENODE", "Hodnota XPathResult v\375razu XPath ''{0}'' je typu XPathResultType {1}, kter\375 nelze p\u0159ev\351st na jedin\375 uzel. Metoda getSingleNodeValue je pou\u017Eiteln\341 pouze pro typy ANY_UNORDERED_NODE_TYPE a FIRST_ORDERED_NODE_TYPE. "
            }, new Object[] {
                "ER_CANT_GET_SNAPSHOT_LENGTH", "Metodu getSnapshotLength nelze volat v datech XPathResult ani ve v\375razu XPath ''{0}'', proto\u017Ee jej\355 typ XPathResultType je {1}. Tato metoda se pou\u017E\355v\341 pouze pro typy UNORDERED_NODE_SNAPSHOT_TYPE a ORDERED_NODE_SNAPSHOT_TYPE. "
            }, new Object[] {
                "ER_NON_ITERATOR_TYPE", "Metodu iterateNext nelze volat v datech XPathResult ani ve v\375razu XPath ''{0}'', proto\u017Ee jej\355 typ XPathResultType je {1}. Tato metoda se pou\u017E\355v\341 pouze pro typy UNORDERED_NODE_ITERATOR_TYPE a ORDERED_NODE_ITERATOR_TYPE. "
            }, new Object[] {
                "ER_DOC_MUTATED", "Dokument se od doby, kdy byly vr\341ceny v\375sledky, zm\u011Bnil. Iter\341tor je neplatn\375."
            }, new Object[] {
                "ER_INVALID_XPATH_TYPE", "Neplatn\375 argument typu XPath: {0}"
            }, new Object[] {
                "ER_EMPTY_XPATH_RESULT", "Pr\341zdn\375 objekt v\375sledku XPath"
            }, new Object[] {
                "ER_INCOMPATIBLE_TYPES", "Hodnota XPathResult v\375razu XPath ''{0}'' je typu XPathResultType {1}, kter\375 nelze vynucen\u011B p\u0159ev\351st na zadan\375 typ XPathResultType {2}. "
            }, new Object[] {
                "ER_NULL_RESOLVER", "Nelze \u0159e\u0161it p\u0159edponu \u0159e\u0161itelem (resolver) s p\u0159edponou hodnoty null."
            }, new Object[] {
                "ER_CANT_CONVERT_TO_STRING", "Hodnota XPathResult v\375razu XPath ''{0}'' je typu XPathResultType {1}, kter\375 nelze p\u0159ev\351st na \u0159et\u011Bzec. "
            }, new Object[] {
                "ER_NON_SNAPSHOT_TYPE", "Metodu snapshotItem nelze volat v datech XPathResult ani ve v\375razu of XPath ''{0}'', proto\u017Ee jej\355 typ XPathResultType je {1}. Tato metoda se pou\u017E\355v\341 pouze pro typy UNORDERED_NODE_SNAPSHOT_TYPE a ORDERED_NODE_SNAPSHOT_TYPE. "
            }, new Object[] {
                "ER_WRONG_DOCUMENT", "Uzel kontextu nepat\u0159\355 mezi dokumenty, kter\351 jsou v\341z\341ny k XPathEvaluator."
            }, new Object[] {
                "ER_WRONG_NODETYPE", "Typ uzlu kontextu nen\355 podporov\341n."
            }, new Object[] {
                "ER_XPATH_ERROR", "Nezn\341m\341 chyba objektu XPath."
            }, new Object[] {
                "ER_CANT_CONVERT_XPATHRESULTTYPE_TO_NUMBER", "Hodnota XPathResult v\375razu XPath ''{0}'' je typu XPathResultType {1}, kter\375 nelze p\u0159ev\351st na \u010D\355slo. "
            }, new Object[] {
                "ER_EXTENSION_FUNCTION_CANNOT_BE_INVOKED", "Roz\u0161i\u0159uj\355c\355 funkci ''{0}'' nelze vyvolat, pokud je funkce XMLConstants.FEATURE_SECURE_PROCESSING nastavena na hodnotu True. "
            }, new Object[] {
                "ER_RESOLVE_VARIABLE_RETURNS_NULL", "Funkce resolveVariable pro prom\u011Bnnou {0} vrac\355 hodnotu Null"
            }, new Object[] {
                "ER_UNSUPPORTED_RETURN_TYPE", "Nepodporovan\375 n\341vratov\375 typ: {0}"
            }, new Object[] {
                "ER_SOURCE_RETURN_TYPE_CANNOT_BE_NULL", "Zdrojov\375 a n\341vratov\375 typ nesm\355 m\355t hodnotu Null"
            }, new Object[] {
                "ER_ARG_CANNOT_BE_NULL", "Argument {0} nesm\355 m\355t hodnotu Null"
            }, new Object[] {
                "ER_OBJECT_MODEL_NULL", "Funkci {0}#isObjectModelSupported( String objectModel ) nelze volat s hodnotou objectModel == Null"
            }, new Object[] {
                "ER_OBJECT_MODEL_EMPTY", "Funkci {0}#isObjectModelSupported( String objectModel ) nelze volat s hodnotou objectModel == \"\""
            }, new Object[] {
                "ER_FEATURE_NAME_NULL", "Pokus o nastaven\355 funkce s n\341zvem s hodnotou Null: {0}#setFeature( null, {1})"
            }, new Object[] {
                "ER_FEATURE_UNKNOWN", "Pokus o nastaven\355 nezn\341m\351 funkce \"{0}\":{1}#setFeature({0},{2})"
            }, new Object[] {
                "ER_GETTING_NULL_FEATURE", "Pokus o na\u010Dten\355 funkce s n\341zvem s hodnotou Null: {0}#getFeature(null)"
            }, new Object[] {
                "ER_GETTING_UNKNOWN_FEATURE", "Pokus o z\355sk\341n\355 nezn\341m\351 funkce \"{0}\":{1}#getFeature({0})"
            }, new Object[] {
                "ER_NULL_XPATH_FUNCTION_RESOLVER", "Pokus o nastaven\355 parametru XPathFunctionResolver s hodnotou Null:{0}#setXPathFunctionResolver(null)"
            }, new Object[] {
                "ER_NULL_XPATH_VARIABLE_RESOLVER", "Pokus o nastaven\355 parametru XPathVariableResolver s hodnotou Null:{0}#setXPathVariableResolver(null)"
            }, new Object[] {
                "WG_LOCALE_NAME_NOT_HANDLED", "funkce format-number prozat\355m nezpracovala n\341zev n\341rodn\355ho prost\u0159ed\355 (locale)!"
            }, new Object[] {
                "WG_PROPERTY_NOT_SUPPORTED", "Vlastnost XSL nen\355 podporov\341na: {0}"
            }, new Object[] {
                "WG_DONT_DO_ANYTHING_WITH_NS", "Aktu\341ln\u011B ned\u011Blejte nic s oborem n\341zv\u016F {0} vlastnosti: {1}"
            }, new Object[] {
                "WG_SECURITY_EXCEPTION", "P\u0159i pokusu o p\u0159\355stup k syst\351mov\351 vlastnosti XSL do\u0161lo k v\375jimce SecurityException: {0}"
            }, new Object[] {
                "WG_QUO_NO_LONGER_DEFINED", "Zastaral\341 syntaxe: quo(...) ji\u017E nen\355 v XPath definov\341no."
            }, new Object[] {
                "WG_NEED_DERIVED_OBJECT_TO_IMPLEMENT_NODETEST", "XPath pot\u0159ebuje k implementaci funkce nodeTest odvozen\375 objekt!"
            }, new Object[] {
                "WG_FUNCTION_TOKEN_NOT_FOUND", "nebyl nalezen token funkce."
            }, new Object[] {
                "WG_COULDNOT_FIND_FUNCTION", "Nelze nal\351zt funkci: {0}"
            }, new Object[] {
                "WG_CANNOT_MAKE_URL_FROM", "Nelze vytvo\u0159it adresu URL z: {0}"
            }, new Object[] {
                "WG_EXPAND_ENTITIES_NOT_SUPPORTED", "Analyz\341tor DTM nepodporuje volbu -E"
            }, new Object[] {
                "WG_ILLEGAL_VARIABLE_REFERENCE", "Odkaz VariableReference uveden k prom\u011Bnn\351 mimo kontext nebo bez definice!  N\341zev = {0}"
            }, new Object[] {
                "WG_UNSUPPORTED_ENCODING", "Nepodporovan\351 k\363dov\341n\355: {0}"
            }, new Object[] {
                "ui_language", "cs"
            }, new Object[] {
                "help_language", "cs"
            }, new Object[] {
                "language", "cs"
            }, new Object[] {
                "BAD_CODE", "Parametr funkce createMessage je mimo limit"
            }, new Object[] {
                "FORMAT_FAILED", "P\u0159i vol\341n\355 funkce messageFormat do\u0161lo k v\375jimce"
            }, new Object[] {
                "version", ">>>>>>> Verze Xalan "
            }, new Object[] {
                "version2", "<<<<<<<"
            }, new Object[] {
                "yes", "ano"
            }, new Object[] {
                "line", "\u0158\341dek #"
            }, new Object[] {
                "column", "Sloupec #"
            }, new Object[] {
                "xsldone", "XSLProcessor: hotovo"
            }, new Object[] {
                "xpath_option", "volby xpath: "
            }, new Object[] {
                "optionIN", "   [-in inputXMLURL]"
            }, new Object[] {
                "optionSelect", "   [-select v\375raz xpath]"
            }, new Object[] {
                "optionMatch", "   [-match vzorek shody (pro diagnostiku shody)]"
            }, new Object[] {
                "optionAnyExpr", "Jinak v\375pis diagnostiky provede pouze v\375raz xpath"
            }, new Object[] {
                "noParsermsg1", "Proces XSL nebyl \372sp\u011B\u0161n\375."
            }, new Object[] {
                "noParsermsg2", "** Nelze naj\355t analyz\341tor **"
            }, new Object[] {
                "noParsermsg3", "Zkontrolujte cestu classpath."
            }, new Object[] {
                "noParsermsg4", "Nem\341te-li analyz\341tor XML jazyka Java spole\u010Dnosti IBM, m\u016F\u017Eete si jej st\341hnout z adresy:"
            }, new Object[] {
                "noParsermsg5", "AlphaWorks: http://www.alphaworks.ibm.com/formula/xml"
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
            return (XPATHErrorResources)ResourceBundle.getBundle(className, new Locale("cs", "CZ"));
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
    public static final String ERROR_STRING = "#chyba";
    public static final String ERROR_HEADER = "Chyba: ";
    public static final String WARNING_HEADER = "Varov\341n\355: ";
    public static final String XSL_HEADER = "XSL ";
    public static final String XML_HEADER = "XML ";
    public static final String QUERY_HEADER = "PATTERN ";
}
