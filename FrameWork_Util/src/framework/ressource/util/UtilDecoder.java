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
		ret.replaceAll("&iexcl;", "¡");
    	ret.replaceAll("&cent;", "¢");
    	ret.replaceAll("&pound;", "£");
    	ret.replaceAll("&curren;", "¤");
    	ret.replaceAll("&yen;", "¥");
    	ret.replaceAll("&brvbar;", "¦");
    	ret.replaceAll("&sect;", "§");
    	ret.replaceAll("&uml;", "¨");
    	ret.replaceAll("&copy;", "©");
    	ret.replaceAll("&ordf;", "ª");
    	ret.replaceAll("&laquo;", "«");
    	ret.replaceAll("&not;", "¬");
    	ret.replaceAll("&shy;", "­");
    	ret.replaceAll("&reg;", "®");
    	ret.replaceAll("&macr;", "¯");
    	ret.replaceAll("&deg;", "°");
    	ret.replaceAll("&plusmn;", "±");
    	ret.replaceAll("&sup2;", "²");
        ret.replaceAll("&sup3;", "³");
        ret.replaceAll("&acute;", "´");
        ret.replaceAll("&micro;", "µ");
        ret.replaceAll("&para;", "¶");
        ret.replaceAll("&middot;", "·");
        ret.replaceAll("&cedil;", "¸");
        ret.replaceAll("&sup1;", "¹");
        ret.replaceAll("&ordm;", "º");
        ret.replaceAll("&raquo;", "»");
        ret.replaceAll("&frac14;", "¼");
        ret.replaceAll("&frac12;", "½");
        ret.replaceAll("&frac34;", "¾");
        ret.replaceAll("&iquest;", "¿");
        ret.replaceAll("&Agrave;", "À");
        ret.replaceAll("&Aacute;", "Á");
        ret.replaceAll("&Acirc;", "Â");
        ret.replaceAll("&Atilde;", "Ã");
        ret.replaceAll("&Auml;", "Ä");
        ret.replaceAll("&Aring;", "Å");
        ret.replaceAll("&AElig;", "Æ");
        ret.replaceAll("&Ccedil;", "Ç");
        ret.replaceAll("&Egrave;", "È");
        ret.replaceAll("&Eacute;", "É");
        ret.replaceAll("&Ecirc;", "Ê");
        ret.replaceAll("&Euml;", "Ë");
        ret.replaceAll("&Igrave;", "Ì");
        ret.replaceAll("&Iacute;", "Í");
        ret.replaceAll("&Iuml;", "Ï");
        ret.replaceAll("&ETH;", "Ð");
        ret.replaceAll("&Ntilde;", "Ñ");
        ret.replaceAll("&Ograve;", "Ò");
        ret.replaceAll("&Oacute;", "Ó");
        ret.replaceAll("&Ocirc;", "Ô");
        ret.replaceAll("&Otilde;", "Õ");
        ret.replaceAll("&Ouml;", "Ö");
        ret.replaceAll("&times;", "×");
        ret.replaceAll("&Oslash;", "Ø");
        ret.replaceAll("&Ugrave;", "Ù");
        ret.replaceAll("&Uacute;", "Ú");
        ret.replaceAll("&Ucirc;", "Û");
        ret.replaceAll("&Uuml;", "Ü");
        ret.replaceAll("&Yacute;", "Ý");
        ret.replaceAll("&THORN;", "Þ");
        ret.replaceAll("&szlig;", "ß");
        ret.replaceAll("&agrave;", "à");
        ret.replaceAll("&aacute;", "á");
        ret.replaceAll("&acirc;", "â");
        ret.replaceAll("&atilde;", "ã");
        ret.replaceAll("&auml;", "ä");
        ret.replaceAll("&aring;", "å");
        ret.replaceAll("&aelig;", "æ");
        ret.replaceAll("&ccedil;", "ç");
        ret.replaceAll("&egrave;", "è");
        ret.replaceAll("&eacute;", "é");
        ret.replaceAll("&ecirc;", "ê");
        ret.replaceAll("&euml;", "ë");
        ret.replaceAll("&igrave;", "ì");
        ret.replaceAll("&iacute;", "í");
        ret.replaceAll("&icirc;", "î");
        ret.replaceAll("&iuml;", "ï");
        ret.replaceAll("&eth;", "ð");
        ret.replaceAll("&ntilde;", "ñ");
        ret.replaceAll("&ograve;", "ò");
        ret.replaceAll("&oacute;", "ó");
        ret.replaceAll("&ocirc;", "ô");
        ret.replaceAll("&otilde;", "õ");
        ret.replaceAll("&ouml;", "ö");
        ret.replaceAll("&divide;", "÷");
        ret.replaceAll("&oslash;", "ø");
        ret.replaceAll("&ugrave;", "ù");
        ret.replaceAll("&uacute;", "ú");
        ret.replaceAll("&ucirc;", "û");
        ret.replaceAll("&uuml;", "ü");
        ret.replaceAll("&yacute;", "ý");
        ret.replaceAll("&thorn;", "þ");
        ret.replaceAll("&yuml;", "ÿ");
        ret.replaceAll("&Icirc;", "Î");
        ret.replaceAll("'", "&#039;");
        ret.replaceAll("&quot;", "\"");
    }
    return ret;
  }
}