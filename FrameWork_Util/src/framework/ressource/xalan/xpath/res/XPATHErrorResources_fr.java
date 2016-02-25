// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPATHErrorResources_fr.java

package framework.ressource.xalan.xpath.res;

import java.util.*;

// Referenced classes of package framework.ressource.xalan.xpath.res:
//            XPATHErrorResources

public class XPATHErrorResources_fr extends ListResourceBundle
{

    public XPATHErrorResources_fr()
    {
    }

    public Object[][] getContents()
    {
        return (new Object[][] {
            new Object[] {
                "ERROR0000", "{0}"
            }, new Object[] {
                "ER_CURRENT_NOT_ALLOWED_IN_MATCH", "La fonction current() n'est pas admise dans un motif de correspondance !"
            }, new Object[] {
                "ER_CURRENT_TAKES_NO_ARGS", "La fonction current() n'accepte pas d'arguments !"
            }, new Object[] {
                "ER_DOCUMENT_REPLACED", "L'impl\351mentation de la fonction document() a \351t\351 remplac\351e par org.apache.xalan.xslt.FuncDocument !"
            }, new Object[] {
                "ER_CONTEXT_HAS_NO_OWNERDOC", "Le contexte ne poss\350de pas de document propri\351taire !"
            }, new Object[] {
                "ER_LOCALNAME_HAS_TOO_MANY_ARGS", "local-name() poss\350de trop d'arguments."
            }, new Object[] {
                "ER_NAMESPACEURI_HAS_TOO_MANY_ARGS", "namespace-uri() poss\350de trop d'arguments."
            }, new Object[] {
                "ER_NORMALIZESPACE_HAS_TOO_MANY_ARGS", "normalize-space() poss\350de trop d'arguments."
            }, new Object[] {
                "ER_NUMBER_HAS_TOO_MANY_ARGS", "number() poss\350de trop d'arguments."
            }, new Object[] {
                "ER_NAME_HAS_TOO_MANY_ARGS", "name() poss\350de trop d'arguments."
            }, new Object[] {
                "ER_STRING_HAS_TOO_MANY_ARGS", "string() poss\350de trop d'arguments."
            }, new Object[] {
                "ER_STRINGLENGTH_HAS_TOO_MANY_ARGS", "string-length() poss\350de trop d'arguments."
            }, new Object[] {
                "ER_TRANSLATE_TAKES_3_ARGS", "La fonction translate() accepte trois arguments !"
            }, new Object[] {
                "ER_UNPARSEDENTITYURI_TAKES_1_ARG", "Un argument doit \352tre fournie \340 la fonction unparsed-entity-uri !"
            }, new Object[] {
                "ER_NAMESPACEAXIS_NOT_IMPLEMENTED", "L'axe de l'espace de noms n'est pas impl\351ment\351 !"
            }, new Object[] {
                "ER_UNKNOWN_AXIS", "axe inconnu : {0}"
            }, new Object[] {
                "ER_UNKNOWN_MATCH_OPERATION", "op\351ration de correspondance inconnue !"
            }, new Object[] {
                "ER_INCORRECT_ARG_LENGTH", "La longueur d'argument du test du noeud processing-instruction() n'est pas correcte !"
            }, new Object[] {
                "ER_CANT_CONVERT_TO_NUMBER", "Impossible de convertir {0} en un nombre"
            }, new Object[] {
                "ER_CANT_CONVERT_TO_NODELIST", "Impossible de convertir {0} en un NodeList !"
            }, new Object[] {
                "ER_CANT_CONVERT_TO_MUTABLENODELIST", "Impossible de convertir {0} en un NodeSetDTM !"
            }, new Object[] {
                "ER_CANT_CONVERT_TO_TYPE", "Impossible de convertir {0} en un type#{1}"
            }, new Object[] {
                "ER_EXPECTED_MATCH_PATTERN", "Motif de correspondance obligatoire dans getMatchScore !"
            }, new Object[] {
                "ER_COULDNOT_GET_VAR_NAMED", "Impossible d''extraire la variable {0}"
            }, new Object[] {
                "ER_UNKNOWN_OPCODE", "ERREUR ! Code op\351ration inconnu : {0}"
            }, new Object[] {
                "ER_EXTRA_ILLEGAL_TOKENS", "Jetons incorrects suppl\351mentaires : {0}"
            }, new Object[] {
                "ER_EXPECTED_DOUBLE_QUOTE", "Erreur de guillemets dans un litt\351ral... Guillemet double obligatoire !"
            }, new Object[] {
                "ER_EXPECTED_SINGLE_QUOTE", "Erreur de guillemets dans un litt\351ral... Guillemet simple obligatoire !"
            }, new Object[] {
                "ER_EMPTY_EXPRESSION", "Expression vide !"
            }, new Object[] {
                "ER_EXPECTED_BUT_FOUND", "{1} a \351t\351 trouv\351 alors que {0} \351tait attendu :"
            }, new Object[] {
                "ER_INCORRECT_PROGRAMMER_ASSERTION", "Assertion de programme incorrecte ! - {0}"
            }, new Object[] {
                "ER_BOOLEAN_ARG_NO_LONGER_OPTIONAL", "L'argument bool\351en(...) n'est plus optionnel avec le document de normalisation XPath 19990709."
            }, new Object[] {
                "ER_FOUND_COMMA_BUT_NO_PRECEDING_ARG", "Virgule trouv\351e sans argument qui la pr\351c\350de !"
            }, new Object[] {
                "ER_FOUND_COMMA_BUT_NO_FOLLOWING_ARG", "Virgule trouv\351e sans argument qui la suit !"
            }, new Object[] {
                "ER_PREDICATE_ILLEGAL_SYNTAX", "La syntaxe '[pr\351dicat]' ou '.[pr\351dicat]' est incorrecte. Pr\351f\351rez 'self::node()[pr\351dicat]'."
            }, new Object[] {
                "ER_ILLEGAL_AXIS_NAME", "nom d''axe incorrect : {0}"
            }, new Object[] {
                "ER_UNKNOWN_NODETYPE", "Type de noeud inconnu : {0}"
            }, new Object[] {
                "ER_PATTERN_LITERAL_NEEDS_BE_QUOTED", "Le litt\351ral de motif ({0}) doit figurer entre guillemets !"
            }, new Object[] {
                "ER_COULDNOT_BE_FORMATTED_TO_NUMBER", "{0} ne peut \352tre format\351e sous forme num\351rique !"
            }, new Object[] {
                "ER_COULDNOT_CREATE_XMLPROCESSORLIAISON", "Impossible de cr\351er XML TransformerFactory Liaison : {0}"
            }, new Object[] {
                "ER_DIDNOT_FIND_XPATH_SELECT_EXP", "Erreur ! Impossible de trouver l'expression de s\351lection xpath (-select)."
            }, new Object[] {
                "ER_COULDNOT_FIND_ENDOP_AFTER_OPLOCATIONPATH", "ERREUR ! Impossible de trouver ENDOP apr\350s OP_LOCATIONPATH"
            }, new Object[] {
                "ER_ERROR_OCCURED", "Une erreur s'est produite !"
            }, new Object[] {
                "ER_ILLEGAL_VARIABLE_REFERENCE", "R\351f\351rence de la variable hors contexte ou sans d\351finition !  Nom = {0}"
            }, new Object[] {
                "ER_AXES_NOT_ALLOWED", "Seuls les axes child:: et attribute:: sont autoris\351s dans des motifs de correspondance !  Axes incorrects= {0}"
            }, new Object[] {
                "ER_KEY_HAS_TOO_MANY_ARGS", "key() poss\350de un nombre non valide d'arguments."
            }, new Object[] {
                "ER_COUNT_TAKES_1_ARG", "Un seul argument doit \352tre fourni \340 la fonction count !"
            }, new Object[] {
                "ER_COULDNOT_FIND_FUNCTION", "Impossible de trouver la fonction : {0}"
            }, new Object[] {
                "ER_UNSUPPORTED_ENCODING", "Codage non pris en charge : {0}"
            }, new Object[] {
                "ER_PROBLEM_IN_DTM_NEXTSIBLING", "Une erreur s'est produite dans la DTM de getNextSibling... Tentative de reprise en cours"
            }, new Object[] {
                "ER_CANNOT_WRITE_TO_EMPTYNODELISTIMPL", "Erreur de programme : Ecriture impossible dans EmptyNodeList."
            }, new Object[] {
                "ER_SETDOMFACTORY_NOT_SUPPORTED", "SetDOMFactory n'est pas pris en charge par XPathContext !"
            }, new Object[] {
                "ER_PREFIX_MUST_RESOLVE", "Le pr\351fixe doit se convertir en espace de noms : {0}"
            }, new Object[] {
                "ER_PARSE_NOT_SUPPORTED", "parse (InputSource source) non pris en charge dans XPathContext ! Ouverture de {0} impossible"
            }, new Object[] {
                "ER_SAX_API_NOT_HANDLED", "Caract\350res (char ch[]...) de l'API SAX non pris en charge par le DTM !"
            }, new Object[] {
                "ER_IGNORABLE_WHITESPACE_NOT_HANDLED", "ignorableWhitespace(char ch[]... non pris en charge par le DTM !"
            }, new Object[] {
                "ER_DTM_CANNOT_HANDLE_NODES", "DTMLiaison ne prend pas en charge des noeuds de type {0}"
            }, new Object[] {
                "ER_XERCES_CANNOT_HANDLE_NODES", "DOM2Helper ne prend pas en charge des noeuds de type {0}"
            }, new Object[] {
                "ER_XERCES_PARSE_ERROR_DETAILS", "Erreur de DOM2Helper.parse : ID syst\350me - {0} ligne - {1}"
            }, new Object[] {
                "ER_XERCES_PARSE_ERROR", "Erreur de DOM2Helper.parse"
            }, new Object[] {
                "ER_INVALID_UTF16_SURROGATE", "Substitut UTF-16 non valide d\351tect\351 : {0} ?"
            }, new Object[] {
                "ER_OIERROR", "Erreur d'E-S"
            }, new Object[] {
                "ER_CANNOT_CREATE_URL", "Impossible de cr\351er une URL pour : {0}"
            }, new Object[] {
                "ER_XPATH_READOBJECT", "Dans XPath.readObject : {0}"
            }, new Object[] {
                "ER_FUNCTION_TOKEN_NOT_FOUND", "jeton de fonction introuvable."
            }, new Object[] {
                "ER_CANNOT_DEAL_XPATH_TYPE", "Impossible de traiter le type XPath : {0}"
            }, new Object[] {
                "ER_NODESET_NOT_MUTABLE", "NodeSet indivisible"
            }, new Object[] {
                "ER_NODESETDTM_NOT_MUTABLE", "NodeSetDTM indivisible"
            }, new Object[] {
                "ER_VAR_NOT_RESOLVABLE", "Impossible de r\351soudre la variable : {0}"
            }, new Object[] {
                "ER_NULL_ERROR_HANDLER", "Gestionnaire d'erreurs vide"
            }, new Object[] {
                "ER_PROG_ASSERT_UNKNOWN_OPCODE", "Assertion de programme : code op\351ration inconnu : {0}"
            }, new Object[] {
                "ER_ZERO_OR_ONE", "0 ou 1"
            }, new Object[] {
                "ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "rtf() non pris en charge par XRTreeFragSelectWrapper"
            }, new Object[] {
                "ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "asNodeIterator() non pris en charge par XRTreeFragSelectWrapper"
            }, new Object[] {
                "ER_DETACH_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "detach() non pris en charge par XRTreeFragSelectWrapper"
            }, new Object[] {
                "ER_NUM_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "num() non pris en charge par XRTreeFragSelectWrapper"
            }, new Object[] {
                "ER_XSTR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "xstr() non pris en charge par XRTreeFragSelectWrapper"
            }, new Object[] {
                "ER_STR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER", "str() non pris en charge par XRTreeFragSelectWrapper"
            }, new Object[] {
                "ER_FSB_NOT_SUPPORTED_XSTRINGFORCHARS", "fsb() non pris en charge par XStringForChars"
            }, new Object[] {
                "ER_COULD_NOT_FIND_VAR", "Impossible de trouver la variable portant le nom {0}"
            }, new Object[] {
                "ER_XSTRINGFORCHARS_CANNOT_TAKE_STRING", "XStringForChars n'accepte pas de cha\356ne comme argument"
            }, new Object[] {
                "ER_FASTSTRINGBUFFER_CANNOT_BE_NULL", "L'argument FastStringBuffer ne doit pas \352tre vide"
            }, new Object[] {
                "ER_TWO_OR_THREE", "2 ou 3"
            }, new Object[] {
                "ER_VARIABLE_ACCESSED_BEFORE_BIND", "L'acc\350s \340 la variable a pr\351c\351d\351 la liaison de celle-ci !"
            }, new Object[] {
                "ER_FSB_CANNOT_TAKE_STRING", "XStringForFSB n'accepte pas de cha\356ne comme argument !"
            }, new Object[] {
                "ER_SETTING_WALKER_ROOT_TO_NULL", "\n !!!! Erreur ! D\351finition d'une valeur nulle pour la racine d'un \351l\351ment walker !!!"
            }, new Object[] {
                "ER_NODESETDTM_CANNOT_ITERATE", "Ce NodeSetDTM ne permet pas d'it\351ration vers un noeud pr\351c\351dent !"
            }, new Object[] {
                "ER_NODESET_CANNOT_ITERATE", "Ce NodeSet ne permet pas d'it\351ration vers un noeud pr\351c\351dent !"
            }, new Object[] {
                "ER_NODESETDTM_CANNOT_INDEX", "Ce NodeSetDTM ne peut pas effectuer de fonctions d'indexage ou de d\351nombrement !"
            }, new Object[] {
                "ER_NODESET_CANNOT_INDEX", "Ce NodeSet ne peut pas effectuer de fonctions d'indexage ou de d\351nombrement !"
            }, new Object[] {
                "ER_CANNOT_CALL_SETSHOULDCACHENODE", "Impossible d'appeler setShouldCacheNodes apr\350s nextNode !"
            }, new Object[] {
                "ER_ONLY_ALLOWS", "{0} accepte uniquement {1} arguments"
            }, new Object[] {
                "ER_UNKNOWN_STEP", "Assertion du programmeur dans getNextStepPos : stepType inconnu : {0}"
            }, new Object[] {
                "ER_EXPECTED_REL_LOC_PATH", "Un chemin d'emplacement relatif \351tait attendu apr\350s le jeton '/' ou '//'."
            }, new Object[] {
                "ER_EXPECTED_LOC_PATH", "Un chemin d''emplacement \351tait attendu, mais le jeton suivant a \351t\351 d\351tect\351 :  {0}"
            }, new Object[] {
                "ER_EXPECTED_LOC_PATH_AT_END_EXPR", "Un chemin d'emplacement \351tait attendu mais la fin de l'expression XPath a \351t\351 d\351tect\351e."
            }, new Object[] {
                "ER_EXPECTED_LOC_STEP", "Une \351tape d'emplacement \351tait attendue apr\350s le jeton '/' ou '//'."
            }, new Object[] {
                "ER_EXPECTED_NODE_TEST", "Un test de noeud correspondant \340 NCName:* ou QName \351tait attendu."
            }, new Object[] {
                "ER_EXPECTED_STEP_PATTERN", "Un mod\350le d'\351tape \351tait attendu, mais '/' a \351t\351 d\351tect\351."
            }, new Object[] {
                "ER_EXPECTED_REL_PATH_PATTERN", "Un mod\350le de chemin relatif \351tait attendu."
            }, new Object[] {
                "ER_CANT_CONVERT_TO_BOOLEAN", "Le r\351sultat XPathResult de l''expression XPath ''{0}'' a un type XPathResultType de {1} qui ne peut pas \352tre converti en valeur bool\351enne."
            }, new Object[] {
                "ER_CANT_CONVERT_TO_SINGLENODE", "Le r\351sultat XPathResult de l''expression XPath ''{0}'' a un type XPathResultType de {1} qui ne peut pas \352tre converti en noeud unique. La m\351thode getSingleNodeValue s''applique uniquement aux types ANY_UNORDERED_NODE_TYPE et FIRST_ORDERED_NODE_TYPE."
            }, new Object[] {
                "ER_CANT_GET_SNAPSHOT_LENGTH", "La m\351thode getSnapshotLength ne peut pas \352tre appel\351e sur le r\351sultat XPathResult de l''expression XPath ''{0}'' car son type XPathResultType est {1}. Cette m\351thode s''applique uniquement aux types UNORDERED_NODE_SNAPSHOT_TYPE et ORDERED_NODE_SNAPSHOT_TYPE."
            }, new Object[] {
                "ER_NON_ITERATOR_TYPE", "La m\351thode iterateNext ne peut pas \352tre appel\351e sur le r\351sultat XPathResult de l''expression XPath ''{0}'' car son type XPathResultType est {1}. Cette m\351thode s''applique uniquement aux types UNORDERED_NODE_ITERATOR_TYPE et ORDERED_NODE_ITERATOR_TYPE."
            }, new Object[] {
                "ER_DOC_MUTATED", "Mutation du document depuis le renvoi du r\351sultat. L'it\351rateur est incorrect."
            }, new Object[] {
                "ER_INVALID_XPATH_TYPE", "Argument de type XPath incorrect : {0}"
            }, new Object[] {
                "ER_EMPTY_XPATH_RESULT", "Objet r\351sultat XPath vide"
            }, new Object[] {
                "ER_INCOMPATIBLE_TYPES", "Le r\351sultat XPathResult de l''expression XPath ''{0}'' a un type XPathResultType de {1} qui ne peut pas \352tre forc\351 dans le type XPathResultType indiqu\351 de {2}."
            }, new Object[] {
                "ER_NULL_RESOLVER", "Conversion impossible du pr\351fixe avec un programme de r\351solution de pr\351fixe de valeur nulle."
            }, new Object[] {
                "ER_CANT_CONVERT_TO_STRING", "Le r\351sultat XPathResult de l''expression XPath ''{0}'' a un type XPathResultType de {1} qui ne peut pas \352tre converti en cha\356ne."
            }, new Object[] {
                "ER_NON_SNAPSHOT_TYPE", "La m\351thode snapshotItem ne peut pas \352tre appel\351e sur le r\351sultat XPathResult de l''expression XPath ''{0}'' car son type XPathResultType est {1}. Cette m\351thode s''applique uniquement aux types UNORDERED_NODE_SNAPSHOT_TYPE et ORDERED_NODE_SNAPSHOT_TYPE."
            }, new Object[] {
                "ER_WRONG_DOCUMENT", "Le noeud de contexte n'appartient pas au document li\351 \340 ce XPathEvaluator."
            }, new Object[] {
                "ER_WRONG_NODETYPE", "Le type de noeud contextuel n'est pas pris en charge."
            }, new Object[] {
                "ER_XPATH_ERROR", "Erreur inconnue d\351tect\351e dans XPath."
            }, new Object[] {
                "ER_CANT_CONVERT_XPATHRESULTTYPE_TO_NUMBER", "Le r\351sultat XPathResult de l''expression XPath ''{0}'' a un type XPathResultType de {1} qui ne peut pas \352tre converti en un nombre."
            }, new Object[] {
                "ER_EXTENSION_FUNCTION_CANNOT_BE_INVOKED", "La fonction d''extension : ''{0}'' ne peut pas \352tre appel\351e lorsque la fonction XMLConstants.FEATURE_SECURE_PROCESSING a la valeur true."
            }, new Object[] {
                "ER_RESOLVE_VARIABLE_RETURNS_NULL", "resolveVariable pour la variable {0} renvoyant la valeur null"
            }, new Object[] {
                "ER_UNSUPPORTED_RETURN_TYPE", "Type de retour non pris en charge : {0}"
            }, new Object[] {
                "ER_SOURCE_RETURN_TYPE_CANNOT_BE_NULL", "Le type de retour et/ou source ne peut pas avoir une valeur null"
            }, new Object[] {
                "ER_ARG_CANNOT_BE_NULL", "L''argument {0} ne peut pas avoir une valeur null"
            }, new Object[] {
                "ER_OBJECT_MODEL_NULL", "{0}#isObjectModelSupported( Cha\356ne objectModel ) ne peut pas \352tre appel\351 avec objectModel == null"
            }, new Object[] {
                "ER_OBJECT_MODEL_EMPTY", "{0}#isObjectModelSupported( Cha\356ne objectModel ) ne peut pas \352tre appel\351 avec objectModel == \"\""
            }, new Object[] {
                "ER_FEATURE_NAME_NULL", "Tentative de d\351finition d''une fonction ayant un nom null : {0}#setFeature( null, {1})"
            }, new Object[] {
                "ER_FEATURE_UNKNOWN", "Tentative de d\351finition d''une fonction inconnue \"{0}\":{1}#setFeature({0},{2})"
            }, new Object[] {
                "ER_GETTING_NULL_FEATURE", "Tentative de d\351finition d''une fonction ayant un nom null : {0}#getFeature(null)"
            }, new Object[] {
                "ER_GETTING_UNKNOWN_FEATURE", "Tentative d''extraction d''une fonction inconnue \"{0}\":{1}#getFeature({0})"
            }, new Object[] {
                "ER_NULL_XPATH_FUNCTION_RESOLVER", "Tentative de d\351finition d''un \351l\351ment XPathFunctionResolver null : {0}#setXPathFunctionResolver(null)"
            }, new Object[] {
                "ER_NULL_XPATH_VARIABLE_RESOLVER", "Tentative de d\351finition d''un \351l\351ment XPathVariableResolver null : {0}#setXPathVariableResolver(null)"
            }, new Object[] {
                "WG_LOCALE_NAME_NOT_HANDLED", "Le nom d'environnement local de la fonction format-number n'est pas encore pris en charge."
            }, new Object[] {
                "WG_PROPERTY_NOT_SUPPORTED", "Propri\351t\351 XSL non prise en charge : {0}"
            }, new Object[] {
                "WG_DONT_DO_ANYTHING_WITH_NS", "Espace de noms {0} inexploitable dans la propri\351t\351 : {1}"
            }, new Object[] {
                "WG_SECURITY_EXCEPTION", "Une exception de s\351curit\351 s''est produite lors de l''acc\350s \340 la propri\351t\351 : {0}"
            }, new Object[] {
                "WG_QUO_NO_LONGER_DEFINED", "L'ancienne syntaxe : quo(...) n'est plus d\351finie dans XPath."
            }, new Object[] {
                "WG_NEED_DERIVED_OBJECT_TO_IMPLEMENT_NODETEST", "XPath requiert un objet d\351riv\351 pour impl\351menter nodeTest !"
            }, new Object[] {
                "WG_FUNCTION_TOKEN_NOT_FOUND", "jeton de fonction introuvable."
            }, new Object[] {
                "WG_COULDNOT_FIND_FUNCTION", "Impossible de trouver la fonction : {0}"
            }, new Object[] {
                "WG_CANNOT_MAKE_URL_FROM", "Impossible de cr\351er l''URL \340 partir de : {0}"
            }, new Object[] {
                "WG_EXPAND_ENTITIES_NOT_SUPPORTED", "L'option -E n'est pas prise en charge pour l'analyseur DTM"
            }, new Object[] {
                "WG_ILLEGAL_VARIABLE_REFERENCE", "R\351f\351rence de la variable hors contexte ou sans d\351finition !  Nom = {0}"
            }, new Object[] {
                "WG_UNSUPPORTED_ENCODING", "Codage non pris en charge : {0}"
            }, new Object[] {
                "ui_language", "en"
            }, new Object[] {
                "help_language", "en"
            }, new Object[] {
                "language", "en"
            }, new Object[] {
                "BAD_CODE", "Le param\350tre de createMessage se trouve hors limites"
            }, new Object[] {
                "FORMAT_FAILED", "Exception soulev\351e lors de l'appel de messageFormat"
            }, new Object[] {
                "version", ">>>>>>> Version de Xalan "
            }, new Object[] {
                "version2", "<<<<<<<"
            }, new Object[] {
                "yes", "oui"
            }, new Object[] {
                "line", "Ligne #"
            }, new Object[] {
                "column", "Colonne #"
            }, new Object[] {
                "xsldone", "XSLProcessor : termin\351"
            }, new Object[] {
                "xpath_option", "options xpath : "
            }, new Object[] {
                "optionIN", "   [-in URLXMLentr\351e]"
            }, new Object[] {
                "optionSelect", "   [-select expression xpath]"
            }, new Object[] {
                "optionMatch", "   [-match motif de correspondance (diagnostics)]"
            }, new Object[] {
                "optionAnyExpr", "Une expression xpath effectuera un vidage de diagnostics"
            }, new Object[] {
                "noParsermsg1", "Echec du processus XSL."
            }, new Object[] {
                "noParsermsg2", "** Analyseur introuvable **"
            }, new Object[] {
                "noParsermsg3", "V\351rifiez le chemin d'acc\350s des classes."
            }, new Object[] {
                "noParsermsg4", "XML Parser for Java disponible en t\351l\351chargement sur le site"
            }, new Object[] {
                "noParsermsg5", "AlphaWorks de IBM : http://www.alphaworks.ibm.com/formula/xml"
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
            return (XPATHErrorResources)ResourceBundle.getBundle(className, new Locale("en", "US"));
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
    public static final String ERROR_HEADER = "Erreur : ";
    public static final String WARNING_HEADER = "Avertissement : ";
    public static final String XSL_HEADER = "XSL ";
    public static final String XML_HEADER = "XML ";
    public static final String QUERY_HEADER = "PATTERN ";
}
