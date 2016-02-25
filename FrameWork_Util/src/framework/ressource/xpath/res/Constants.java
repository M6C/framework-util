package framework.ressource.xpath.res;

/**
 * <meta name="usage" content="advanced"/>
 * Primary constants used in the TransformerImpl classes.
 */
public class Constants
{

  /** 
   * Mnemonics for standard XML Namespace URIs, as Java Strings:
   * <ul>
   * <li>S_XMLNAMESPACEURI (http://www.w3.org/XML/1998/namespace) is the
   * URI permanantly assigned to the "xml:" prefix. This is used for some
   * features built into the XML specification itself, such as xml:space 
   * and xml:lang. It was defined by the W3C's XML Namespaces spec.</li>
   * <li>S_XSLNAMESPACEURL (http://www.w3.org/1999/XSL/Transform) is the
   * URI which indicates that a name may be an XSLT directive. In most
   * XSLT stylesheets, this is bound to the "xsl:" prefix. It's defined
   * by the W3C's XSLT Recommendation.</li>
   * <li>S_OLDXSLNAMESPACEURL (http://www.w3.org/XSL/Transform/1.0) was
   * used in early prototypes of XSLT processors for much the same purpose
   * as S_XSLNAMESPACEURL. It is now considered obsolete, and the version
   * of XSLT which it signified is not fully compatable with the final
   * XSLT Recommendation, so what it really signifies is a badly obsolete
   * stylesheet.</li>
   * </ul> */
  public static final String S_XMLNAMESPACEURI = "http://www.w3.org/XML/1998/namespace" ;
  /** 
   * Mnemonics for standard XML Namespace URIs, as Java Strings:
   * <ul>
   * <li>S_XMLNAMESPACEURI (http://www.w3.org/XML/1998/namespace) is the
   * URI permanantly assigned to the "xml:" prefix. This is used for some
   * features built into the XML specification itself, such as xml:space 
   * and xml:lang. It was defined by the W3C's XML Namespaces spec.</li>
   * <li>S_XSLNAMESPACEURL (http://www.w3.org/1999/XSL/Transform) is the
   * URI which indicates that a name may be an XSLT directive. In most
   * XSLT stylesheets, this is bound to the "xsl:" prefix. It's defined
   * by the W3C's XSLT Recommendation.</li>
   * <li>S_OLDXSLNAMESPACEURL (http://www.w3.org/XSL/Transform/1.0) was
   * used in early prototypes of XSLT processors for much the same purpose
   * as S_XSLNAMESPACEURL. It is now considered obsolete, and the version
   * of XSLT which it signified is not fully compatable with the final
   * XSLT Recommendation, so what it really signifies is a badly obsolete
   * stylesheet.</li>
   * </ul> */
  public static final String S_XSLNAMESPACEURL = "http://www.w3.org/1999/XSL/Transform" ;
  /** 
   * Mnemonics for standard XML Namespace URIs, as Java Strings:
   * <ul>
   * <li>S_XMLNAMESPACEURI (http://www.w3.org/XML/1998/namespace) is the
   * URI permanantly assigned to the "xml:" prefix. This is used for some
   * features built into the XML specification itself, such as xml:space 
   * and xml:lang. It was defined by the W3C's XML Namespaces spec.</li>
   * <li>S_XSLNAMESPACEURL (http://www.w3.org/1999/XSL/Transform) is the
   * URI which indicates that a name may be an XSLT directive. In most
   * XSLT stylesheets, this is bound to the "xsl:" prefix. It's defined
   * by the W3C's XSLT Recommendation.</li>
   * <li>S_OLDXSLNAMESPACEURL (http://www.w3.org/XSL/Transform/1.0) was
   * used in early prototypes of XSLT processors for much the same purpose
   * as S_XSLNAMESPACEURL. It is now considered obsolete, and the version
   * of XSLT which it signified is not fully compatable with the final
   * XSLT Recommendation, so what it really signifies is a badly obsolete
   * stylesheet.</li>
   * </ul> */
  public static final String S_OLDXSLNAMESPACEURL = "http://www.w3.org/XSL/Transform/1.0" ;

  /** Authorship mnemonics, as Java Strings. Not standardized, 
   * as far as I know.
   * <ul>
   * <li>S_VENDOR -- the name of the organization/individual who published
   * this XSLT processor. </li>
   * <li>S_VENDORURL -- URL where one can attempt to retrieve more
   * information about this publisher and product.</li>
   * </ul>
   */
  public static final String S_VENDOR = "Apache Software Foundation" ;
  /** Authorship mnemonics, as Java Strings. Not standardized, 
   * as far as I know.
   * <ul>
   * <li>S_VENDOR -- the name of the organization/individual who published
   * this XSLT processor. </li>
   * <li>S_VENDORURL -- URL where one can attempt to retrieve more
   * information about this publisher and product.</li>
   * </ul>
   */
  public static final String S_VENDORURL = "http://xml.apache.org" ;

  /** S_BUILTIN_EXTENSIONS_URL is a mnemonic for the XML Namespace 
   *(http://xml.apache.org/xslt) predefined to signify Xalan's
   * built-in XSLT Extensions. When used in stylesheets, this is often 
   * bound to the "xalan:" prefix.
   */
  public static final String 
    S_BUILTIN_EXTENSIONS_URL = "http://xml.apache.org/xslt"; 
  
  /**
   * The minimum version of XSLT supported by this processor.
   */
  public static final double XSLTVERSUPPORTED = 1.0;

  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_UNDEFINED = - 1 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_WITHPARAM = 2 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_ADDATTRIBUTE = 4 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_ANCHOR = 22 ;
  //  ELEMNAME_ANCHOR_PATTERN = 23,
 /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_APPLY_TEMPLATES = 50 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_USE = 34 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_CHILDREN = 6 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_CHOOSE = 37 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_COMMENT = 59 ;
  // my own
 /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_CONSTRUCT = 7 ;
  // my own
 /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_CONTENTS = 8 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_COPY = 9 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_COPY_OF = 74 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_DECIMALFORMAT = 83 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_DEFINEATTRIBUTESET = 40 ;
  //  ELEMNAME_DEFINECONSTANT = 29,
 //  ELEMNAME_DEFINEMACRO = 10,
 /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_DEFINESCRIPT = 11 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_DISPLAYIF = 12 ;
  // my own
 /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_EMPTY = 14 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_EVAL = 15 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_EXPECTEDCHILDREN = 16 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_EXTENSION = 54 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_EXTENSIONHANDLER = 63 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_FOREACH = 28 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_KEY = 31 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_IF = 36 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_IMPORT = 26 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_INCLUDE = 27 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_CALLTEMPLATE = 17 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_PARAMVARIABLE = 41 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_NUMBER = 35 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_NSALIAS = 84 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_OTHERWISE = 39 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_PI = 58 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_PRESERVESPACE = 33 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_REMOVEATTRIBUTE = 5 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_TEMPLATE = 19 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_SORT = 64 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_STRIPSPACE = 32 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_STYLESHEET = 25 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_TEXT = 42 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_VALUEOF = 30 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_WHEN = 38 ;
  // Pattern by example support  
 /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_ROOT = 44 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_ANY = 45 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_ELEMENT = 46 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_TARGETELEMENT = 47 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_ATTRIBUTE = 48 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_TARGETATTRIBUTE = 49 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_URL = 52 ;
  // my own
 /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_CALL = 55 ;
  // my own
 //  ELEMNAME_WITHPARAM = 56,
 /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_FALLBACK = 57 ;
  // my own
 /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_TARGETPI = 60 ;
  // my own
 /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_TARGETCOMMENT = 61 ;
  // my own
 /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_TARGETTEXT = 62 ;
  // my own
 /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_CSSSTYLECONVERSION = 65 ;
  // my own
 /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_COUNTER = 66 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_COUNTERS = 67 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_COUNTERINCREMENT = 68 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_COUNTERRESET = 69 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_COUNTERSCOPE = 71 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_APPLY_IMPORTS = 72 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_VARIABLE = 73 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_MESSAGE = 75 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_LOCALE = 76 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_LITERALRESULT = 77 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_TEXTLITERALRESULT = 78 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_EXTENSIONCALL = 79 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_EXTENSIONDECL = 85 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_EXTENSIONSCRIPT = 86 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_OUTPUT = 80 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_COMPONENT = 81 ;
  /**
   * IDs for XSL element types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   * (It's a pity Java doesn't have a real Enumerated Mnemonic
   * datatype... or a C-like preprocessor in lieu thereof which
   * could be used to generate and maintain synch between these lists.)
   */
  public static final int ELEMNAME_SCRIPT = 82 ;

  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_ANCHOR_STRING = "anchor" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_ANY_STRING = "any" ;
  // pattern-by-example support
 // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_APPLY_IMPORTS_STRING = "apply-imports" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_APPLY_TEMPLATES_STRING = "apply-templates" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_ARG_STRING = "arg" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_ATTRIBUTESET_STRING = "attribute-set" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_ATTRIBUTE_STRING = "attribute" ;
  // pattern-by-example support
 // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_CALLTEMPLATEARG_STRING = "invoke-arg" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_CALLTEMPLATE_STRING = "call-template" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_CALL_STRING = "call" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_CHILDREN_STRING = "children" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_CHOOSE_STRING = "choose" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_COMMENT_STRING = "comment" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_COMPONENT_STRING = "component" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_CONSTRUCT_STRING = "construct" ;
  // my own
 // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_CONTENTS_STRING = "contents" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_COPY_OF_STRING = "copy-of" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_COPY_STRING = "copy" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_COUNTERINCREMENT_STRING = "counter-increment" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_COUNTERRESET_STRING = "counter-reset" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_COUNTERSCOPE_STRING = "counter-scope" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_COUNTERS_STRING = "counters" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_COUNTER_STRING = "counter" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_CSSSTYLECONVERSION_STRING = "css-style-conversion" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_DECIMALFORMAT_STRING = "decimal-format" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_DISPLAYIF_STRING = "display-if" ;
  // my own
 // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_ELEMENT_STRING = "element" ;
  // pattern-by-example support
 // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_EMPTY_STRING = "empty" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_EVAL_STRING = "eval" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_EXPECTEDCHILDREN_STRING = "expectedchildren" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_EXTENSIONHANDLER_STRING = "code-dispatcher" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_EXTENSION_STRING = "functions" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_FALLBACK_STRING = "fallback" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_FOREACH_STRING = "for-each" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_IF_STRING = "if" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_IMPORT_STRING = "import" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_INCLUDE_STRING = "include" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_KEY_STRING = "key" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_LOCALE_STRING = "locale" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_MESSAGE_STRING = "message" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_NSALIAS_STRING = "namespace-alias" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_NUMBER_STRING = "number" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_OTHERWISE_STRING = "otherwise" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_OUTPUT_STRING = "output" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_PARAMVARIABLE_STRING = "param" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_PI_OLD_STRING = "pi" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_PI_STRING = "processing-instruction" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_PRESERVESPACE_STRING = "preserve-space" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_ROOT_STRING = "root" ;
  // pattern-by-example support
 // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_SCRIPT_STRING = "script" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_SORT_STRING = "sort" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_STRIPSPACE_STRING = "strip-space" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_STYLESHEET_STRING = "stylesheet" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_TARGETATTRIBUTE_STRING = "target-attribute" ;
  // pattern-by-example support
 // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_TARGETCOMMENT_STRING = "target-comment" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_TARGETELEMENT_STRING = "target-element" ;
  // pattern-by-example support
 // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_TARGETPI_STRING = "target-pi" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_TARGETTEXT_STRING = "target-text" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_TEMPLATE_STRING = "template" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_TEXT_STRING = "text" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_TRANSFORM_STRING = "transform" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_URL_STRING = "uri" ;
  // pattern-by-example support
 // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_USE_STRING = "use" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_VALUEOF_STRING = "value-of" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_VARIABLE_STRING = "variable" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_WHEN_STRING = "when" ;
  // Next free number: 87

  /**
   * Literals for XSL element names.  Note that there are more
   * names than IDs, because some names map to the same ID.
   */
  public static final String ELEMNAME_WITHPARAM_STRING = "with-param" ;
  
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_AMOUNT = "amount" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_ANCESTOR = "ancestor" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_ARCHIVE = "archive" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_ATTRIBUTE = "attribute" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_ATTRIBUTE_SET = "attribute-set" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_CASEORDER = "case-order" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_CLASS = "class" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_CLASSID = "classid" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_CODEBASE = "codebase" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_CODETYPE = "type" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_CONDITION = "condition" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_COPYTYPE = "copy-type" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_COUNT = "count" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_DATATYPE = "data-type" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_DECIMALSEPARATOR = "decimal-separator" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_DEFAULT = "default" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_DEFAULTSPACE = "default-space" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_DEPTH = "with-children" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_DIGIT = "digit" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_DIGITGROUPSEP = "digit-group-sep" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_DISABLE_OUTPUT_ESCAPING = "disable-output-escaping" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_ELEMENT = "element" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_ELEMENTS = "elements" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_EXCLUDE_RESULT_PREFIXES = "exclude-result-prefixes" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_EXPR = "expr" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_EXTENSIONELEMENTPREFIXES = "extension-element-prefixes" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_FORMAT = "format" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_FROM = "from" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_GROUPINGSEPARATOR = "grouping-separator" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_GROUPINGSIZE = "grouping-size" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_HREF = "href" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_ID = "id" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_IMPORTANCE = "importance" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_INDENTRESULT = "indent-result" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_INFINITY = "infinity" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_LANG = "lang" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_LETTERVALUE = "letter-value" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_LEVEL = "level" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_MATCH = "match" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_METHOD = "calls" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_MINUSSIGN = "minus-sign" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_MODE = "mode" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_NAME = "name" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_NAMESPACE = "namespace" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_NAN = "NaN" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_NDIGITSPERGROUP = "n-digits-per-group" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_NS = "ns" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_ONLY = "only" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_ORDER = "order" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_OUTPUT_CDATA_SECTION_ELEMENTS = "cdata-section-elements" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_OUTPUT_DOCTYPE_PUBLIC = "doctype-public" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_OUTPUT_DOCTYPE_SYSTEM = "doctype-system" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_OUTPUT_ENCODING = "encoding" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_OUTPUT_INDENT = "indent" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_OUTPUT_MEDIATYPE = "media-type" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_OUTPUT_METHOD = "method" ;
  // qname, 
 /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_OUTPUT_OMITXMLDECL = "omit-xml-declaration" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_OUTPUT_STANDALONE = "standalone" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_OUTPUT_VERSION = "version" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_PATTERNSEPARATOR = "pattern-separator" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_PERCENT = "percent" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_PERMILLE = "per-mille" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_PRIORITY = "priority" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_REFID = "refID" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_RESULTNS = "result-ns" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_RESULT_PREFIX = "result-prefix" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_SELECT = "select" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_SEQUENCESRC = "sequence-src" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_STYLE = "style" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_STYLESHEET_PREFIX = "stylesheet-prefix" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_TERMINATE = "terminate" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_TEST = "test" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_TOSTRING = "to-string" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_TYPE = "type" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_USE = "use" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_USEATTRIBUTESETS = "use-attribute-sets" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_VALUE = "value" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_VERSION = "version" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_XMLNS = "xmlns:" ;
  // namespace declaration prefix -- NOT an attribute by itself
 /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_XMLNSDEF = "xmlns" ;
  // default namespace
 /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_XMLSPACE = "xml:space" ;
  /**
   * Literals for XSL attribute names.  Note that there may be more
   * names than IDs, because some names may map to the same ID.
   */
  public static final String ATTRNAME_ZERODIGIT = "zero-digit" ;

  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_OUTPUT_METHOD = 1 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_AMOUNT = 2 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_ANCESTOR = 3 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_ARCHIVE = 4 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_ATTRIBUTE = 5 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_ATTRIBUTE_SET = 6 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_CASEORDER = 7 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_CLASS = 8 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_CLASSID = 9 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_CODEBASE = 10 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_CODETYPE = 11 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_CONDITION = 12 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_COPYTYPE = 13 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_COUNT = 14 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_DATATYPE = 15 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_DEFAULT = 16 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_DEFAULTSPACE = 17 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_DEPTH = 18 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_DIGITGROUPSEP = 19 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_DISABLE_OUTPUT_ESCAPING = 20 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_ELEMENT = 21 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_ELEMENTS = 22 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_EXPR = 23 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_EXTENSIONELEMENTPREFIXES = 24 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_FORMAT = 25 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_FROM = 26 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_GROUPINGSEPARATOR = 27 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_GROUPINGSIZE = 28 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_HREF = 29 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_ID = 30 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_IMPORTANCE = 31 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_INDENTRESULT = 32 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_LANG = 33 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_LETTERVALUE = 34 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_LEVEL = 35 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_MATCH = 36 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_METHOD = 37 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_MODE = 38 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_NAME = 39 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_NAMESPACE = 40 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_NDIGITSPERGROUP = 41 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_NS = 42 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_ONLY = 43 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_ORDER = 44 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_OUTPUT_CDATA_SECTION_ELEMENTS = 45 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_OUTPUT_DOCTYPE_PUBLIC = 46 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_OUTPUT_DOCTYPE_SYSTEM = 47 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_OUTPUT_ENCODING = 48 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_OUTPUT_INDENT = 49 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_OUTPUT_MEDIATYPE = 50 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_OUTPUT_STANDALONE = 51 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_OUTPUT_VERSION = 52 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_OUTPUT_OMITXMLDECL = 53 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_PRIORITY = 54 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_REFID = 55 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_RESULTNS = 56 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_SELECT = 57 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_SEQUENCESRC = 58 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_STYLE = 59 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_TEST = 60 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_TOSTRING = 61 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_TYPE = 62 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_USE = 63 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_USEATTRIBUTESETS = 64 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_VALUE = 65 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_XMLNSDEF = 66 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_XMLNS = 67 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_XMLSPACE = 68 ;
  /** IDs for XSL attribute types. These are associated
   * with the string literals in the TransformerImpl class.
   * Don't change the numbers. NOTE THAT THESE ARE NOT IN
   * ALPHABETICAL ORDER!
   */
  public static final int TATTRNAME_EXCLUDE_RESULT_PREFIXES = 69 ;

  /** Mnemonics for the possible values of the xsl:output element's
   * method= attribute:
   * <ul>
   * <li>ATTRVAL_OUTPUT_METHOD_XML = Use an XML formatter to
   * produce the output document (basic XSLT operation).</li>
   * <li>ATTRVAL_OUTPUT_METHOD_HTML: Use an HTML formatter to
   * produce the output document. When generating HTML documents,
   * this may yield better results; it does things like escaping
   * characters in href attributes.</li>
   * </li>ATTRVAL_OUTPUT_METHOD_TEXT:  Use a Text formatter to
   * produce the output document. Generally the right choice if your
   * stylesheet wants to take over _all_ the details of formatting,
   * most often when producing something that isn't an XML or HTML
   * document.</li>
   * </ul> 
   * */
  public static final String ATTRVAL_OUTPUT_METHOD_HTML = "html" ;
  /** Mnemonics for the possible values of the xsl:output element's
   * method= attribute:
   * <ul>
   * <li>ATTRVAL_OUTPUT_METHOD_XML = Use an XML formatter to
   * produce the output document (basic XSLT operation).</li>
   * <li>ATTRVAL_OUTPUT_METHOD_HTML: Use an HTML formatter to
   * produce the output document. When generating HTML documents,
   * this may yield better results; it does things like escaping
   * characters in href attributes.</li>
   * </li>ATTRVAL_OUTPUT_METHOD_TEXT:  Use a Text formatter to
   * produce the output document. Generally the right choice if your
   * stylesheet wants to take over _all_ the details of formatting,
   * most often when producing something that isn't an XML or HTML
   * document.</li>
   * </ul> 
   * */
  public static final String ATTRVAL_OUTPUT_METHOD_XML = "xml" ;
  /** Mnemonics for the possible values of the xsl:output element's
   * method= attribute:
   * <ul>
   * <li>ATTRVAL_OUTPUT_METHOD_XML = Use an XML formatter to
   * produce the output document (basic XSLT operation).</li>
   * <li>ATTRVAL_OUTPUT_METHOD_HTML: Use an HTML formatter to
   * produce the output document. When generating HTML documents,
   * this may yield better results; it does things like escaping
   * characters in href attributes.</li>
   * </li>ATTRVAL_OUTPUT_METHOD_TEXT:  Use a Text formatter to
   * produce the output document. Generally the right choice if your
   * stylesheet wants to take over _all_ the details of formatting,
   * most often when producing something that isn't an XML or HTML
   * document.</li>
   * </ul> 
   * */
  public static final String ATTRVAL_OUTPUT_METHOD_TEXT = "text" ;

  
  /* For space-att*/
  public static final int ATTRVAL_PRESERVE = 1 ;
  /* For space-att*/
  public static final int ATTRVAL_STRIP = 2 ;

  
  /** For indent-result          */
  public static final boolean ATTRVAL_YES = true ;
  /** For indent-result          */
  public static final boolean ATTRVAL_NO = false ;

  
  /** For letter-value attribute (part of conversion attributes).          */
  public static final String ATTRVAL_ALPHABETIC = "alphabetic" ;
  /** For letter-value attribute (part of conversion attributes).          */
  public static final String ATTRVAL_OTHER = "other" ;
  /** For letter-value attribute (part of conversion attributes).          */
  public static final String ATTRVAL_TRADITIONAL = "traditional" ;

  
  /** For level attribute in xsl:number.          */
  public static final String ATTRVAL_SINGLE = "single" ;
  /** For level attribute in xsl:number.          */
  public static final String ATTRVAL_MULTI = "multiple" ;
  /** For level attribute in xsl:number.          */
  public static final String ATTRVAL_ANY = "any" ;

  
  /** For Stylesheet-prefix and result-prefix in xsl:namespace-alias          */
  public static final String ATTRVAL_DEFAULT_PREFIX = "#default";

  
  /** Integer equivelents for above        */
  public static final int NUMBERLEVEL_SINGLE = 1 ;
  /** Integer equivelents for above        */
  public static final int NUMBERLEVEL_MULTI = 2 ;
  /** Integer equivelents for above        */
  public static final int NUMBERLEVEL_ANY = 3 ;
  /** Integer equivelents for above        */
  public static final int MAX_MULTI_COUNTING_DEPTH = 32 ;

  
  /** some stuff for my patterns-by-example         */
  public static final String ATTRVAL_THIS = "." ;
  /** some stuff for my patterns-by-example         */
  public static final String ATTRVAL_PARENT = ".." ;
  /** some stuff for my patterns-by-example         */
  public static final String ATTRVAL_ANCESTOR = "ancestor" ;
  /** some stuff for my patterns-by-example         */
  public static final String ATTRVAL_ID = "id" ;

  
  /** Stuff for sorting      */
  public static final String ATTRVAL_DATATYPE_TEXT = "text" ;
  /** Stuff for sorting      */
  public static final String ATTRVAL_DATATYPE_NUMBER = "number" ;
  /** Stuff for sorting      */
  public static final String ATTRVAL_ORDER_ASCENDING = "ascending" ;
  /** Stuff for sorting      */
  public static final String ATTRVAL_ORDER_DESCENDING = "descending" ;
  /** Stuff for sorting      */
  public static final String ATTRVAL_CASEORDER_UPPER = "upper-first" ;
  /** Stuff for sorting      */
  public static final String ATTRVAL_CASEORDER_LOWER = "lower-first" ;

  
  /** some stuff for Decimal-format       */
  public static final String ATTRVAL_INFINITY = "Infinity" ;
  /** some stuff for Decimal-format       */
  public static final String ATTRVAL_NAN = "NaN" ;
  /** some stuff for Decimal-format       */
  public static final String DEFAULT_DECIMAL_FORMAT = "#default" ;

  
  /** temp dummy         */
  public static final String ATTRNAME_XXXX = "XXXX";
}
