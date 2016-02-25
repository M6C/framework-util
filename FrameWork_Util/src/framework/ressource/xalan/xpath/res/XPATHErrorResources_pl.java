// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPATHErrorResources_pl.java

package framework.ressource.xalan.xpath.res;

import java.util.*;

// Referenced classes of package framework.ressource.xalan.xpath.res:
//            XPATHErrorResources

public class XPATHErrorResources_pl extends ListResourceBundle
{

    public XPATHErrorResources_pl()
    {
    }

    public Object[][] getContents()
    {
        return (new Object[][] {
            new Object[] {
                "ERROR0000", "{0}"
            }, new Object[] {
                "ER_CURRENT_NOT_ALLOWED_IN_MATCH", "Funkcja current() jest niedozwolona we wzorcu!"
            }, new Object[] {
                "ER_CURRENT_TAKES_NO_ARGS", "Funkcja current() nie akceptuje argument\363w!"
            }, new Object[] {
                "ER_DOCUMENT_REPLACED", "Implementacja funkcji document() zosta\u0142a zast\u0105piona przez org.apache.xalan.xslt.FuncDocument!"
            }, new Object[] {
                "ER_CONTEXT_HAS_NO_OWNERDOC", "Kontekst nie ma dokumentu w\u0142a\u015Bciciela!"
            }, new Object[] {
                "ER_LOCALNAME_HAS_TOO_MANY_ARGS", "Funkcja local-name() ma zbyt wiele argument\363w."
            }, new Object[] {
                "ER_NAMESPACEURI_HAS_TOO_MANY_ARGS", "Funkcja namespace-uri() ma zbyt wiele argument\363w."
            }, new Object[] {
                "ER_NORMALIZESPACE_HAS_TOO_MANY_ARGS", "Funkcja normalize-space() ma zbyt wiele argument\363w."
            }, new Object[] {
                "ER_NUMBER_HAS_TOO_MANY_ARGS", "Funkcja number() ma zbyt wiele argument\363w."
            }, new Object[] {
                "ER_NAME_HAS_TOO_MANY_ARGS", "Funkcja name() ma zbyt wiele argument\363w."
            }, new Object[] {
                "ER_STRING_HAS_TOO_MANY_ARGS", "Funkcja string() ma zbyt wiele argument\363w."
            }, new Object[] {
                "ER_STRINGLENGTH_HAS_TOO_MANY_ARGS", "Funkcja string-length() ma zbyt wiele argument\363w."
            }, new Object[] {
                "ER_TRANSLATE_TAKES_3_ARGS", "Funkcja translate() akceptuje trzy argumenty!"
            }, new Object[] {
                "ER_UNPARSEDENTITYURI_TAKES_1_ARG", "Funkcja unparsed-entity-uri() akceptuje tylko jeden argument!"
            }, new Object[] {
                "ER_NAMESPACEAXIS_NOT_IMPLEMENTED", "O\u015B przestrzeni nazw nie zosta\u0142a jeszcze zaimplementowana!"
            }, new Object[] {
                "ER_UNKNOWN_AXIS", "nieznana o\u015B: {0}"
            }, new Object[] {
                "ER_UNKNOWN_MATCH_OPERATION", "Nieznana operacja uzgadniania!"
            }, new Object[] {
                "ER_INCORRECT_ARG_LENGTH", "D\u0142ugo\u015B\u0107 argumentu testu w\u0119z\u0142a processing-instruction() jest niepoprawna!"
            }, new Object[] {
                "ER_CANT_CONVERT_TO_NUMBER", "Nie mo\u017Cna przekszta\u0142ci\u0107 {0} w liczb\u0119"
            }, new Object[] {
                "ER_CANT_CONVERT_TO_NODELIST", "Nie mo\u017Cna przekszta\u0142ci\u0107 {0} w NodeList!"
            }, new Object[] {
                "ER_CANT_CONVERT_TO_MUTABLENODELIST", "Nie mo\u017Cna przekszta\u0142ci\u0107 {0} w NodeSetDTM!"
            }, new Object[] {
                "ER_CANT_CONVERT_TO_TYPE", "Nie mo\u017Cna przekszta\u0142ci\u0107 {0} w type#{1}"
            }, new Object[] {
                "ER_EXPECTED_MATCH_PATTERN", "Oczekiwano wzorca uzgadniania w getMatchScore!"
            }, new Object[] {
                "ER_COULDNOT_GET_VAR_NAMED", "Nie mo\u017Cna pobra\u0107 zmiennej o nazwie {0}"
            }, new Object[] {
                "ER_UNKNOWN_OPCODE", "B\u0141\u0104D! Nieznany kod operacji: {0}"
            }, new Object[] {
                "ER_EXTRA_ILLEGAL_TOKENS", "Nadmiarowe niedozwolone leksemy: {0}"
            }, new Object[] {
                "ER_EXPECTED_DOUBLE_QUOTE", "Litera\u0142 bez cudzys\u0142owu... oczekiwano podw\363jnego cudzys\u0142owu!"
            }, new Object[] {
                "ER_EXPECTED_SINGLE_QUOTE", "Litera\u0142 bez cudzys\u0142owu... oczekiwano pojedynczego cudzys\u0142owu!"
            }, new Object[] {
                "ER_EMPTY_EXPRESSION", "Puste wyra\u017Cenie!"
            }, new Object[] {
                "ER_EXPECTED_BUT_FOUND", "Oczekiwano {0}, ale znaleziono: {1}"
            }, new Object[] {
                "ER_INCORRECT_PROGRAMMER_ASSERTION", "Asercja programisty jest niepoprawna! - {0}"
            }, new Object[] {
                "ER_BOOLEAN_ARG_NO_LONGER_OPTIONAL", "argument boolean(...) nie jest ju\u017C opcjonalny wg projektu 19990709 XPath draft."
            }, new Object[] {
                "ER_FOUND_COMMA_BUT_NO_PRECEDING_ARG", "Znaleziono znak ',', ale nie ma poprzedzaj\u0105cego argumentu!"
            }, new Object[] {
                "ER_FOUND_COMMA_BUT_NO_FOLLOWING_ARG", "Znaleziono znak ',', ale nie ma nast\u0119puj\u0105cego argumentu!"
            }, new Object[] {
                "ER_PREDICATE_ILLEGAL_SYNTAX", "'..[predykat]' lub '.[predykat]' to niedozwolona sk\u0142adnia. U\u017Cyj zamiast tego 'self::node()[predykat]'."
            }, new Object[] {
                "ER_ILLEGAL_AXIS_NAME", "Niedozwolona nazwa osi: {0}"
            }, new Object[] {
                "ER_UNKNOWN_NODETYPE", "Nieznany typ w\u0119z\u0142a: {0}"
            }, new Object[] {
                "ER_PATTERN_LITERAL_NEEDS_BE_QUOTED", "Litera\u0142 wzorca ({0}) musi by\u0107 w cudzys\u0142owie!"
            }, new Object[] {
                "ER_COULDNOT_BE_FORMATTED_TO_NUMBER", "Nie mo\u017Cna sformatowa\u0107 {0} do postaci liczbowej!"
            }, new Object[] {
                "ER_COULDNOT_CREATE_XMLPROCESSORLIAISON", "Nie mo\u017Cna utworzy\u0107 po\u0142\u0105czenia XML TransformerFactory: {0}"
            }, new Object[] {
                "ER_DIDNOT_FIND_XPATH_SELECT_EXP", "B\u0142\u0105d! Nie znaleziono wyra\u017Cenia wyboru xpath (-select)."
            }, new Object[] {
                "ER_COULDNOT_FIND_ENDOP_AFTER_OPLOCATIONPATH", "B\u0141\u0104D! Nie mo\u017Cna znale\u017A\u0107 ENDOP po OP_LOCATIONPATH"
            }, new Object[] {
                "ER_ERROR_OCCURED", "Wyst\u0105pi\u0142 b\u0142\u0105d!"
            }, new Object[] {
                "ER_ILLEGAL_VARIABLE_REFERENCE", "VariableReference nadana zmiennej nie nale\u017Cy do kontekstu lub nie ma definicji!  Nazwa = {0}"
            }, new Object[] {
                "ER_AXES_NOT_ALLOWED", "We wzorcach zgodno\u015Bci dozwolone s\u0105 tylko osie child:: oraz attribute::!  Niew\u0142a\u015Bciwe osie = {0}"
            }, new Object[] {
                "ER_KEY_HAS_TOO_MANY_ARGS", "Funkcja key() ma niepoprawn\u0105 liczb\u0119 argument\363w."
            }, new Object[] {
                "ER_COUNT_TAKES_1_ARG", "Funkcja count() akceptuje tylko jeden argument!"
            }, new Object[] {
                "ER_COULDNOT_FIND_FUNCTION", "Nie mo\u017Cna znale\u017A\u0107 funkcji: {0}"
            }, new Object[] {
                "ER_UNSUPPORTED_ENCODING", "Nieobs\u0142ugiwane kodowanie: {0}"
            }, new Object[] {
                "ER_PROBLEM_IN_DTM_NEXTSIBLING", "Wyst\u0105pi\u0142 problem w DTM w getNextSibling... pr\363ba wyj\u015Bcia z b\u0142\u0119du"
            }, new Object[] {
                "ER_CANNOT_WRITE_TO_EMPTYNODELISTIMPL", "B\u0142\u0105d programisty: Nie mo\u017Cna zapisywa\u0107 do EmptyNodeList."
            }, new Object[] {
                "ER_SETDOMFACTORY_NOT_SUPPORTED", "setDOMFactory nie jest obs\u0142ugiwane przez XPathContext!"
            }, new Object[] {
                "ER_PREFIX_MUST_RESOLVE", "Przedrostek musi da\u0107 si\u0119 przet\u0142umaczy\u0107 na przestrze\u0144 nazw: {0}"
            }, new Object[] {
                "ER_PARSE_NOT_SUPPORTED", "parse (InputSource \u017Ar\363d\u0142o) nie jest obs\u0142ugiwane w XPathContext! Nie mo\u017Cna otworzy\u0107 {0}"
            }, new Object[] {
                "ER_SAX_API_NOT_HANDLED", "SAX API characters(char ch[]... nie jest obs\u0142ugiwane przez DTM!"
            }, new Object[] {
                "ER_IGNORABLE_WHITESPACE_NOT_HANDLED", "ignorableWhitespace(char ch[]... nie jest obs\u0142ugiwane przez DTM!"
            }, new Object[] {
                "ER_DTM_CANNOT_HANDLE_NODES", "DTMLiaison nie mo\u017Ce obs\u0142u\u017Cy\u0107 w\u0119z\u0142\363w typu {0}"
            }, new Object[] {
                "ER_XERCES_CANNOT_HANDLE_NODES", "DOM2Helper nie mo\u017Ce obs\u0142u\u017Cy\u0107 w\u0119z\u0142\363w typu {0}"
            }, new Object[] {
                "ER_XERCES_PARSE_ERROR_DETAILS", "B\u0142\u0105d DOM2Helper.parse : ID systemu - {0} wiersz - {1}"
            }, new Object[] {
                "ER_XERCES_PARSE_ERROR", "B\u0142\u0105d DOM2Helper.parse"
            }, new Object[] {
                "ER_INVALID_UTF16_SURROGATE", "Wykryto niepoprawny odpowiednik UTF-16: {0} ?"
            }, new Object[] {
                "ER_OIERROR", "B\u0142\u0105d we/wy"
            }, new Object[] {
                "ER_CANNOT_CREATE_URL", "Nie mo\u017Cna utworzy\u0107 adresu url dla {0}"
            }, new Object[] {
                "ER_XPATH_READOBJECT", "W XPath.readObject: {0}"
            }, new Object[] {
                "ER_FUNCTION_TOKEN_NOT_FOUND", "Nie znaleziono leksemu funkcji."
            }, new Object[] {
                "ER_CANNOT_DEAL_XPATH_TYPE", "Nie mo\u017Cna upora\u0107 si\u0119 z typem XPath {0}"
            }, new Object[] {
                "ER_NODESET_NOT_MUTABLE", "Ten NodeSet nie jest zmienny"
            }, new Object[] {
                "ER_NODESETDTM_NOT_MUTABLE", "Ten NodeSetDTM nie jest zmienny"
            }, new Object[] {
                "ER_VAR_NOT_RESOLVABLE", "Nie mo\u017Cna rozstrzygn\u0105\u0107 zmiennej {0}"
            }, new Object[] {
                "ER_NULL_ERROR_HANDLER", "Pusta procedura obs\u0142ugi b\u0142\u0119du"
            }, new Object[] {
                "ER_PROG_ASSERT_UNKNOWN_OPCODE", "Asercja programisty: nieznany kod opcode: {0}"
            }, new Object[] {
                "ER_ZERO_OR_ONE", "0 lub 1"
            }, new Object[] {
                "ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "Funkcja rtf() nie jest obs\u0142ugiwana przez XRTreeFragSelectWrapper"
            }, new Object[] {
                "ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "Funkcja asNodeIterator() nie jest obs\u0142ugiwana przez XRTreeFragSelectWrapper"
            }, new Object[] {
                "ER_DETACH_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "Funkcja detach() nie jest obs\u0142ugiwana przez XRTreeFragSelectWrapper"
            }, new Object[] {
                "ER_NUM_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "Funkcja num() nie jest obs\u0142ugiwana przez XRTreeFragSelectWrapper"
            }, new Object[] {
                "ER_XSTR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "Funkcja xstr() nie jest obs\u0142ugiwana przez XRTreeFragSelectWrapper"
            }, new Object[] {
                "ER_STR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "Funkcja str() nie jest obs\u0142ugiwana przez XRTreeFragSelectWrapper"
            }, new Object[] {
                "ER_FSB_NOT_SUPPORTED_XSTRINGFORCHARS", "Funkcja fsb() nie jest obs\u0142ugiwana dla XStringForChars"
            }, new Object[] {
                "ER_COULD_NOT_FIND_VAR", "Nie mo\u017Cna znale\u017A\u0107 zmiennej o nazwie {0}"
            }, new Object[] {
                "ER_XSTRINGFORCHARS_CANNOT_TAKE_STRING", "XStringForChars nie mo\u017Ce pobra\u0107 ci\u0105gu znak\363w jako argumentu"
            }, new Object[] {
                "ER_FASTSTRINGBUFFER_CANNOT_BE_NULL", "Argument FastStringBuffer nie mo\u017Ce by\u0107 pusty"
            }, new Object[] {
                "ER_TWO_OR_THREE", "2 lub 3"
            }, new Object[] {
                "ER_VARIABLE_ACCESSED_BEFORE_BIND", "Nast\u0105pi\u0142o odwo\u0142anie do zmiennej, zanim zosta\u0142a ona zwi\u0105zana!"
            }, new Object[] {
                "ER_FSB_CANNOT_TAKE_STRING", "XStringForFSB nie mo\u017Ce pobra\u0107 ci\u0105gu znak\363w jako argumentu!"
            }, new Object[] {
                "ER_SETTING_WALKER_ROOT_TO_NULL", "\n !!!! B\u0142\u0105d! Ustawienie root w\u0119drownika na null!!!"
            }, new Object[] {
                "ER_NODESETDTM_CANNOT_ITERATE", "Ten NodeSetDTM nie mo\u017Ce iterowa\u0107 do poprzedniego w\u0119z\u0142a!"
            }, new Object[] {
                "ER_NODESET_CANNOT_ITERATE", "Ten NodeSet nie mo\u017Ce iterowa\u0107 do poprzedniego w\u0119z\u0142a!"
            }, new Object[] {
                "ER_NODESETDTM_CANNOT_INDEX", "Ten NodeSetDTM nie mo\u017Ce wykona\u0107 funkcji indeksowania lub zliczania!"
            }, new Object[] {
                "ER_NODESET_CANNOT_INDEX", "Ten NodeSet nie mo\u017Ce wykona\u0107 funkcji indeksowania lub zliczania!"
            }, new Object[] {
                "ER_CANNOT_CALL_SETSHOULDCACHENODE", "Nie mo\u017Cna wywo\u0142a\u0107 setShouldCacheNodes po wywo\u0142aniu nextNode!"
            }, new Object[] {
                "ER_ONLY_ALLOWS", "{0} zezwala tylko na {1} argument\363w"
            }, new Object[] {
                "ER_UNKNOWN_STEP", "Asercja programisty w getNextStepPos: nieznany stepType: {0}"
            }, new Object[] {
                "ER_EXPECTED_REL_LOC_PATH", "Po leksemie '/' oraz '//' oczekiwana by\u0142a \u015Bcie\u017Cka wzgl\u0119dna po\u0142o\u017Cenia."
            }, new Object[] {
                "ER_EXPECTED_LOC_PATH", "Oczekiwano \u015Bcie\u017Cki po\u0142o\u017Cenia, ale napotkano nast\u0119puj\u0105cy leksem:  {0}"
            }, new Object[] {
                "ER_EXPECTED_LOC_PATH_AT_END_EXPR", "Oczekiwano \u015Bcie\u017Cki po\u0142o\u017Cenia, ale zamiast niej znaleziono koniec wyra\u017Cenia XPath."
            }, new Object[] {
                "ER_EXPECTED_LOC_STEP", "Po leksemie '/' oraz '//' oczekiwany by\u0142 krok po\u0142o\u017Cenia."
            }, new Object[] {
                "ER_EXPECTED_NODE_TEST", "Oczekiwano testu w\u0119z\u0142a zgodnego albo z NCName:*, albo z QName."
            }, new Object[] {
                "ER_EXPECTED_STEP_PATTERN", "Oczekiwano wzorca kroku, ale napotkano '/'."
            }, new Object[] {
                "ER_EXPECTED_REL_PATH_PATTERN", "Oczekiwano wzorca \u015Bcie\u017Cki wzgl\u0119dnej."
            }, new Object[] {
                "ER_CANT_CONVERT_TO_BOOLEAN", "Rezultat (XPathResult) wyra\u017Cenia XPath ''{0}'' ma typ (XPathResultType) {1}, kt\363rego nie mo\u017Cna przekszta\u0142ci\u0107 w typ boolowski."
            }, new Object[] {
                "ER_CANT_CONVERT_TO_SINGLENODE", "Rezultat (XPathResult) wyra\u017Cenia XPath ''{0}'' ma typ (XPathResultType) {1}, kt\363rego nie mo\u017Cna przekszta\u0142ci\u0107 w pojedynczy w\u0119ze\u0142. Metod\u0119 getSingleNodeValue mo\u017Cna stosowa\u0107 tylko do typ\363w ANY_UNORDERED_NODE_TYPE oraz FIRST_ORDERED_NODE_TYPE."
            }, new Object[] {
                "ER_CANT_GET_SNAPSHOT_LENGTH", "Metody getSnapshotLength nie mo\u017Cna wywo\u0142a\u0107 na rezultacie (XPathResult) wyra\u017Cenia XPath ''{0}'', poniewa\u017C jego typem (XPathResultType) jest {1}. Metod\u0119 t\u0119 mo\u017Cna stosowa\u0107 tylko do typ\363w UNORDERED_NODE_SNAPSHOT_TYPE oraz ORDERED_NODE_SNAPSHOT_TYPE."
            }, new Object[] {
                "ER_NON_ITERATOR_TYPE", "Metody iterateNext nie mo\u017Cna wywo\u0142a\u0107 na rezultacie (XPathResult) wyra\u017Cenia XPath ''{0}'', poniewa\u017C jego typem (XPathResultType) jest {1}. Metod\u0119 t\u0119 mo\u017Cna stosowa\u0107 tylko do typ\363w UNORDERED_NODE_ITERATOR_TYPE oraz ORDERED_NODE_ITERATOR_TYPE."
            }, new Object[] {
                "ER_DOC_MUTATED", "Dokument uleg\u0142 zmianie od czasu zwr\363cenia rezultatu. Iterator jest niepoprawny."
            }, new Object[] {
                "ER_INVALID_XPATH_TYPE", "Niepoprawny argument typu XPath: {0}"
            }, new Object[] {
                "ER_EMPTY_XPATH_RESULT", "Pusty obiekt rezultatu XPath"
            }, new Object[] {
                "ER_INCOMPATIBLE_TYPES", "Rezultat (XPathResult) wyra\u017Cenia XPath ''{0}'' ma typ (XPathResultType) {1}, na kt\363rym nie mo\u017Cna wymusi\u0107 dzia\u0142ania jak na okre\u015Blonym typie (XPathResultType) {2}."
            }, new Object[] {
                "ER_NULL_RESOLVER", "Nie mo\u017Cna przet\u0142umaczy\u0107 przedrostka za pomoc\u0105 procedury t\u0142umacz\u0105cej o pustym przedrostku."
            }, new Object[] {
                "ER_CANT_CONVERT_TO_STRING", "Rezultat (XPathResult) wyra\u017Cenia XPath ''{0}'' ma typ (XPathResultType) {1}, kt\363rego nie mo\u017Cna przekszta\u0142ci\u0107 w typ \u0142a\u0144cuchowy."
            }, new Object[] {
                "ER_NON_SNAPSHOT_TYPE", "Metody snapshotItem nie mo\u017Cna wywo\u0142a\u0107 na rezultacie (XPathResult) wyra\u017Cenia XPath ''{0}'', poniewa\u017C jego typem (XPathResultType) jest {1}. Metod\u0119 t\u0119 mo\u017Cna stosowa\u0107 tylko do typ\363w UNORDERED_NODE_SNAPSHOT_TYPE oraz ORDERED_NODE_SNAPSHOT_TYPE."
            }, new Object[] {
                "ER_WRONG_DOCUMENT", "W\u0119ze\u0142 kontekstu nie nale\u017Cy do dokumentu, kt\363ry jest zwi\u0105zany z tym interfejsem XPathEvaluator."
            }, new Object[] {
                "ER_WRONG_NODETYPE", "Nieobs\u0142ugiwany typ w\u0119z\u0142a kontekstu."
            }, new Object[] {
                "ER_XPATH_ERROR", "Nieznany b\u0142\u0105d w XPath."
            }, new Object[] {
                "ER_CANT_CONVERT_XPATHRESULTTYPE_TO_NUMBER", "Rezultat (XPathResult) wyra\u017Cenia XPath ''{0}'' ma typ (XPathResultType) {1}, kt\363rego nie mo\u017Cna przekszta\u0142ci\u0107 w typ liczbowy."
            }, new Object[] {
                "ER_EXTENSION_FUNCTION_CANNOT_BE_INVOKED", "Nie mo\u017Cna wywo\u0142a\u0107 funkcji rozszerzenia ''{0}'', kiedy opcja XMLConstants.FEATURE_SECURE_PROCESSING ma warto\u015B\u0107 true."
            }, new Object[] {
                "ER_RESOLVE_VARIABLE_RETURNS_NULL", "resolveVariable zwraca warto\u015B\u0107 null dla zmiennej {0}"
            }, new Object[] {
                "ER_UNSUPPORTED_RETURN_TYPE", "Nieobs\u0142ugiwany typ zwracany : {0}"
            }, new Object[] {
                "ER_SOURCE_RETURN_TYPE_CANNOT_BE_NULL", "Typ \u017Ar\363d\u0142owy i/lub zwracany nie mo\u017Ce mie\u0107 warto\u015Bci null"
            }, new Object[] {
                "ER_ARG_CANNOT_BE_NULL", "Argument {0} nie mo\u017Ce mie\u0107 warto\u015Bci null"
            }, new Object[] {
                "ER_OBJECT_MODEL_NULL", "Nie mo\u017Cna wywo\u0142a\u0107 {0}#isObjectModelSupported( String objectModel ) ze zmienn\u0105 objectModel o warto\u015Bci null"
            }, new Object[] {
                "ER_OBJECT_MODEL_EMPTY", "Nie mo\u017Cna wywo\u0142a\u0107 {0}#isObjectModelSupported( String objectModel ) ze zmienn\u0105 objectModel o warto\u015Bci \"\""
            }, new Object[] {
                "ER_FEATURE_NAME_NULL", "Pr\363ba ustawienia opcji o nazwie r\363wnej null: {0}#setFeature( null, {1})"
            }, new Object[] {
                "ER_FEATURE_UNKNOWN", "Pr\363ba ustawienia nieznanej opcji \"{0}\":{1}#setFeature({0},{2})"
            }, new Object[] {
                "ER_GETTING_NULL_FEATURE", "Pr\363ba pobrania opcji o nazwie r\363wnej null: {0}#getFeature(null)"
            }, new Object[] {
                "ER_GETTING_UNKNOWN_FEATURE", "Pr\363ba pobrania nieznanej opcji \"{0}\":{1}#getFeature({0})"
            }, new Object[] {
                "ER_NULL_XPATH_FUNCTION_RESOLVER", "Pr\363ba ustawienia XPathFunctionResolver o warto\u015Bci null:{0}#setXPathFunctionResolver(null)"
            }, new Object[] {
                "ER_NULL_XPATH_VARIABLE_RESOLVER", "Pr\363ba ustawienia XPathVariableResolver o warto\u015Bci null:{0}#setXPathVariableResolver(null)"
            }, new Object[] {
                "WG_LOCALE_NAME_NOT_HANDLED", "Nazwa ustawie\u0144 narodowych w funkcji format-number nie jest jeszcze obs\u0142ugiwana!"
            }, new Object[] {
                "WG_PROPERTY_NOT_SUPPORTED", "Nieobs\u0142ugiwana w\u0142a\u015Bciwo\u015B\u0107 XSL {0}"
            }, new Object[] {
                "WG_DONT_DO_ANYTHING_WITH_NS", "Nie r\363b teraz niczego z przestrzeni\u0105 nazw {0} we w\u0142a\u015Bciwo\u015Bci {1}"
            }, new Object[] {
                "WG_SECURITY_EXCEPTION", "Wyj\u0105tek SecurityException podczas pr\363by dost\u0119pu do w\u0142a\u015Bciwo\u015Bci systemowej XSL {0}"
            }, new Object[] {
                "WG_QUO_NO_LONGER_DEFINED", "Stara sk\u0142adnia: quo(...) nie jest ju\u017C zdefiniowana w XPath."
            }, new Object[] {
                "WG_NEED_DERIVED_OBJECT_TO_IMPLEMENT_NODETEST", "XPath potrzebuje obiektu pochodnego, aby zaimplementowa\u0107 nodeTest!"
            }, new Object[] {
                "WG_FUNCTION_TOKEN_NOT_FOUND", "Nie znaleziono leksemu funkcji."
            }, new Object[] {
                "WG_COULDNOT_FIND_FUNCTION", "Nie mo\u017Cna znale\u017A\u0107 funkcji: {0}"
            }, new Object[] {
                "WG_CANNOT_MAKE_URL_FROM", "Nie mo\u017Cna utworzy\u0107 adresu URL z {0}"
            }, new Object[] {
                "WG_EXPAND_ENTITIES_NOT_SUPPORTED", "Opcja -E nie jest obs\u0142ugiwana przez analizator DTM"
            }, new Object[] {
                "WG_ILLEGAL_VARIABLE_REFERENCE", "VariableReference nadana zmiennej nie nale\u017Cy do kontekstu lub nie ma definicji!  Nazwa = {0}"
            }, new Object[] {
                "WG_UNSUPPORTED_ENCODING", "Nieobs\u0142ugiwane kodowanie: {0}"
            }, new Object[] {
                "ui_language", "pl"
            }, new Object[] {
                "help_language", "pl"
            }, new Object[] {
                "language", "pl"
            }, new Object[] {
                "BAD_CODE", "Parametr createMessage by\u0142 spoza zakresu"
            }, new Object[] {
                "FORMAT_FAILED", "Podczas wywo\u0142ania messageFormat zg\u0142oszony zosta\u0142 wyj\u0105tek"
            }, new Object[] {
                "version", ">>>>>>> Wersja Xalan "
            }, new Object[] {
                "version2", "<<<<<<<"
            }, new Object[] {
                "yes", "tak"
            }, new Object[] {
                "line", "Nr wiersza: "
            }, new Object[] {
                "column", "Nr kolumny: "
            }, new Object[] {
                "xsldone", "XSLProcessor: gotowe"
            }, new Object[] {
                "xpath_option", "opcje xpath: "
            }, new Object[] {
                "optionIN", "[-in wej\u015BciowyXMLURL]"
            }, new Object[] {
                "optionSelect", "[-select wyra\u017Cenie xpath]"
            }, new Object[] {
                "optionMatch", "[-match wzorzec (do diagnostyki odnajdywania zgodno\u015Bci ze wzorcem)]"
            }, new Object[] {
                "optionAnyExpr", "Lub po prostu wyra\u017Cenie xpath dokona zrzutu diagnostycznego"
            }, new Object[] {
                "noParsermsg1", "Proces XSL nie wykona\u0142 si\u0119 pomy\u015Blnie."
            }, new Object[] {
                "noParsermsg2", "** Nie mo\u017Cna znale\u017A\u0107 analizatora **"
            }, new Object[] {
                "noParsermsg3", "Sprawd\u017A classpath."
            }, new Object[] {
                "noParsermsg4", "Je\u015Bli nie masz analizatora XML dla j\u0119zyka Java firmy IBM, mo\u017Cesz go pobra\u0107 "
            }, new Object[] {
                "noParsermsg5", "z serwisu AlphaWorks firmy IBM: http://www.alphaworks.ibm.com/formula/xml"
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
            return (XPATHErrorResources)ResourceBundle.getBundle(className, new Locale("pl", "PL"));
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
    public static final String ERROR_STRING = "nr b\u0142\u0119du";
    public static final String ERROR_HEADER = "B\u0142\u0105d: ";
    public static final String WARNING_HEADER = "Ostrze\u017Cenie: ";
    public static final String XSL_HEADER = "XSL ";
    public static final String XML_HEADER = "XML ";
    public static final String QUERY_HEADER = "WZORZEC ";
}
