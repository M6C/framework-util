package framework.ressource.util;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author non attribuable
 * @version 1.0
 */

public class UtilDecoder {

  private UtilDecoder() {
  }

  public static String decodeHTML(String str){
    String ret = new String();
    if (UtilString.isNotEmpty(str)){
    	ret = new String(str);
    	ret.replaceAll("&nbsp;", " ");
    	ret.replaceAll("<br>", "\r\n");
    	ret.replaceAll("&quot;", "\"");
    	ret.replaceAll("&#039;", "'");
    	ret.replaceAll("&lt;", "<");
    	ret.replaceAll("&gt;", ">");
    }
    return ret;
  }

  public static String decodeHTMLSpecialChars(String str){
    String ret = new String();
    if (UtilString.isNotEmpty(str)){
    	ret = new String(str);
    	ret.replaceAll("&amp;", "&");
    	ret.replaceAll("&quot;", "\"");
    	ret.replaceAll("&#039;", "'");
    	ret.replaceAll("&lt;", "<");
    	ret.replaceAll("&gt;", ">");
    }
    return ret;
  }

  public static String decodeHTMLEntities(String str){
	String ret = new String();
	if (UtilString.isNotEmpty(str)){
		ret = new String(str);
		ret.replaceAll("&amp;", "&");
		ret.replaceAll("&lt;", "<");
		ret.replaceAll("&gt;", ">");
		ret.replaceAll("&nbsp;", " ");
		ret.replaceAll("&iexcl;", "�");
    	ret.replaceAll("&cent;", "�");
    	ret.replaceAll("&pound;", "�");
    	ret.replaceAll("&curren;", "�");
    	ret.replaceAll("&yen;", "�");
    	ret.replaceAll("&brvbar;", "�");
    	ret.replaceAll("&sect;", "�");
    	ret.replaceAll("&uml;", "�");
    	ret.replaceAll("&copy;", "�");
    	ret.replaceAll("&ordf;", "�");
    	ret.replaceAll("&laquo;", "�");
    	ret.replaceAll("&not;", "�");
    	ret.replaceAll("&shy;", "�");
    	ret.replaceAll("&reg;", "�");
    	ret.replaceAll("&macr;", "�");
    	ret.replaceAll("&deg;", "�");
    	ret.replaceAll("&plusmn;", "�");
    	ret.replaceAll("&sup2;", "�");
        ret.replaceAll("&sup3;", "�");
        ret.replaceAll("&acute;", "�");
        ret.replaceAll("&micro;", "�");
        ret.replaceAll("&para;", "�");
        ret.replaceAll("&middot;", "�");
        ret.replaceAll("&cedil;", "�");
        ret.replaceAll("&sup1;", "�");
        ret.replaceAll("&ordm;", "�");
        ret.replaceAll("&raquo;", "�");
        ret.replaceAll("&frac14;", "�");
        ret.replaceAll("&frac12;", "�");
        ret.replaceAll("&frac34;", "�");
        ret.replaceAll("&iquest;", "�");
        ret.replaceAll("&Agrave;", "�");
        ret.replaceAll("&Aacute;", "�");
        ret.replaceAll("&Acirc;", "�");
        ret.replaceAll("&Atilde;", "�");
        ret.replaceAll("&Auml;", "�");
        ret.replaceAll("&Aring;", "�");
        ret.replaceAll("&AElig;", "�");
        ret.replaceAll("&Ccedil;", "�");
        ret.replaceAll("&Egrave;", "�");
        ret.replaceAll("&Eacute;", "�");
        ret.replaceAll("&Ecirc;", "�");
        ret.replaceAll("&Euml;", "�");
        ret.replaceAll("&Igrave;", "�");
        ret.replaceAll("&Iacute;", "�");
        ret.replaceAll("&Iuml;", "�");
        ret.replaceAll("&ETH;", "�");
        ret.replaceAll("&Ntilde;", "�");
        ret.replaceAll("&Ograve;", "�");
        ret.replaceAll("&Oacute;", "�");
        ret.replaceAll("&Ocirc;", "�");
        ret.replaceAll("&Otilde;", "�");
        ret.replaceAll("&Ouml;", "�");
        ret.replaceAll("&times;", "�");
        ret.replaceAll("&Oslash;", "�");
        ret.replaceAll("&Ugrave;", "�");
        ret.replaceAll("&Uacute;", "�");
        ret.replaceAll("&Ucirc;", "�");
        ret.replaceAll("&Uuml;", "�");
        ret.replaceAll("&Yacute;", "�");
        ret.replaceAll("&THORN;", "�");
        ret.replaceAll("&szlig;", "�");
        ret.replaceAll("&agrave;", "�");
        ret.replaceAll("&aacute;", "�");
        ret.replaceAll("&acirc;", "�");
        ret.replaceAll("&atilde;", "�");
        ret.replaceAll("&auml;", "�");
        ret.replaceAll("&aring;", "�");
        ret.replaceAll("&aelig;", "�");
        ret.replaceAll("&ccedil;", "�");
        ret.replaceAll("&egrave;", "�");
        ret.replaceAll("&eacute;", "�");
        ret.replaceAll("&ecirc;", "�");
        ret.replaceAll("&euml;", "�");
        ret.replaceAll("&igrave;", "�");
        ret.replaceAll("&iacute;", "�");
        ret.replaceAll("&icirc;", "�");
        ret.replaceAll("&iuml;", "�");
        ret.replaceAll("&eth;", "�");
        ret.replaceAll("&ntilde;", "�");
        ret.replaceAll("&ograve;", "�");
        ret.replaceAll("&oacute;", "�");
        ret.replaceAll("&ocirc;", "�");
        ret.replaceAll("&otilde;", "�");
        ret.replaceAll("&ouml;", "�");
        ret.replaceAll("&divide;", "�");
        ret.replaceAll("&oslash;", "�");
        ret.replaceAll("&ugrave;", "�");
        ret.replaceAll("&uacute;", "�");
        ret.replaceAll("&ucirc;", "�");
        ret.replaceAll("&uuml;", "�");
        ret.replaceAll("&yacute;", "�");
        ret.replaceAll("&thorn;", "�");
        ret.replaceAll("&yuml;", "�");
        ret.replaceAll("&Icirc;", "�");
        ret.replaceAll("'", "&#039;");
        ret.replaceAll("&quot;", "\"");
    }
    return ret;
  }
}