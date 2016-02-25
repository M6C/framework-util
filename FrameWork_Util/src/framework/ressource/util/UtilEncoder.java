package framework.ressource.util;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author non attribuable
 * @version 1.0
 */

public class UtilEncoder {

  private UtilEncoder() {
  }

  public static String encodeHTML(String str){
    StringBuffer ret = new StringBuffer();
    if (UtilString.isNotEmpty(str)){
      char c;
      char[] charArray = str.toCharArray();
      int size = charArray.length;
      for(int i=0 ; i<size ; i++){
        c = charArray[i];
        switch(c) {
          case ' ' : ret.append("&nbsp;");  break;
          case '\r' : break;
          case '\n' : ret.append("<br>"); break;
          case '\'' : ret.append("&#39;");  break;
          case '"'  : ret.append("&quot;"); break;
          case '<'  : ret.append("&lt;");   break;
          case '>'  : ret.append("&gt;");   break;
          default   : ret.append(c);
        }
      }
    }
    return ret.toString();
  }

  public static String encodeHTMLSpecialChars(String str){
    StringBuffer ret = new StringBuffer();
    if (UtilString.isNotEmpty(str)){
      char c;
      char[] charArray = str.toCharArray();
      int size = charArray.length;
      for(int i=0 ; i<size ; i++){
        c = charArray[i];
        switch(c) {
          case '&' : ret.append("&amp;");  break;
          case '"' : ret.append("&quot;"); break;
          case '\'': ret.append("&#039;"); break;
          case '<' : ret.append("&lt;");   break;
          case '>' : ret.append("&gt;");   break;
          default  : ret.append(c);
        }
      }
    }
    return ret.toString();
  }

  public static String encodeHTMLEntities(String str){
    StringBuffer ret = new StringBuffer();
    if (UtilString.isNotEmpty(str)){
      char c;
      char[] charArray = str.toCharArray();
      int size = charArray.length;
      for(int i=0 ; i<size ; i++){
        c = charArray[i];
        switch(c) {
          case '&' : ret.append("&amp;");  break;
          case '<' : ret.append("&lt;");  break;
          case '>' : ret.append("&gt;");  break;
          case ' ' : ret.append("&nbsp;");  break;
          case '¡' : ret.append("&iexcl;");  break;
          case '¢' : ret.append("&cent;");  break;
          case '£' : ret.append("&pound;");  break;
          case '¤' : ret.append("&curren;");  break;
          case '¥' : ret.append("&yen;");  break;
          case '¦' : ret.append("&brvbar;");  break;
          case '§' : ret.append("&sect;");  break;
          case '¨' : ret.append("&uml;");  break;
          case '©' : ret.append("&copy;");  break;
          case 'ª' : ret.append("&ordf;");  break;
          case '«' : ret.append("&laquo;");  break;
          case '¬' : ret.append("&not;");  break;
          case '­'  : ret.append("&shy;");  break;
          case '®' : ret.append("&reg;");  break;
          case '¯' : ret.append("&macr;");  break;
          case '°' : ret.append("&deg;");  break;
          case '±' : ret.append("&plusmn;");  break;
          case '²' : ret.append("&sup2;");  break;
          case '³' : ret.append("&sup3;");  break;
          case '´' : ret.append("&acute;");  break;
          case 'µ' : ret.append("&micro;");  break;
          case '¶' : ret.append("&para;");  break;
          case '·' : ret.append("&middot;");  break;
          case '¸' : ret.append("&cedil;");  break;
          case '¹' : ret.append("&sup1;");  break;
          case 'º' : ret.append("&ordm;");  break;
          case '»' : ret.append("&raquo;");  break;
          case '¼' : ret.append("&frac14;");  break;
          case '½' : ret.append("&frac12;");  break;
          case '¾' : ret.append("&frac34;");  break;
          case '¿' : ret.append("&iquest;");  break;
          case 'À' : ret.append("&Agrave;");  break;
          case 'Á' : ret.append("&Aacute;");  break;
          case 'Â' : ret.append("&Acirc;");  break;
          case 'Ã' : ret.append("&Atilde;");  break;
          case 'Ä' : ret.append("&Auml;");  break;
          case 'Å' : ret.append("&Aring;");  break;
          case 'Æ' : ret.append("&AElig;");  break;
          case 'Ç' : ret.append("&Ccedil;");  break;
          case 'È' : ret.append("&Egrave;");  break;
          case 'É' : ret.append("&Eacute;");  break;
          case 'Ê' : ret.append("&Ecirc;");  break;
          case 'Ë' : ret.append("&Euml;");  break;
          case 'Ì' : ret.append("&Igrave;");  break;
          case 'Í' : ret.append("&Iacute;");  break;
          case 'Ï' : ret.append("&Iuml;");  break;
          case 'Ð' : ret.append("&ETH;");  break;
          case 'Ñ' : ret.append("&Ntilde;");  break;
          case 'Ò' : ret.append("&Ograve;");  break;
          case 'Ó' : ret.append("&Oacute;");  break;
          case 'Ô' : ret.append("&Ocirc;");  break;
          case 'Õ' : ret.append("&Otilde;");  break;
          case 'Ö' : ret.append("&Ouml;");  break;
          case '×' : ret.append("&times;");  break;
          case 'Ø' : ret.append("&Oslash;");  break;
          case 'Ù' : ret.append("&Ugrave;");  break;
          case 'Ú' : ret.append("&Uacute;");  break;
          case 'Û' : ret.append("&Ucirc;");  break;
          case 'Ü' : ret.append("&Uuml;");  break;
          case 'Ý' : ret.append("&Yacute;");  break;
          case 'Þ' : ret.append("&THORN;");  break;
          case 'ß' : ret.append("&szlig;");  break;
          case 'à' : ret.append("&agrave;");  break;
          case 'á' : ret.append("&aacute;");  break;
          case 'â' : ret.append("&acirc;");  break;
          case 'ã' : ret.append("&atilde;");  break;
          case 'ä' : ret.append("&auml;");  break;
          case 'å' : ret.append("&aring;");  break;
          case 'æ' : ret.append("&aelig;");  break;
          case 'ç' : ret.append("&ccedil;");  break;
          case 'è' : ret.append("&egrave;");  break;
          case 233 : ret.append("&eacute;");  break;
          case 'ê' : ret.append("&ecirc;");  break;
          case 'ë' : ret.append("&euml;");  break;
          case 'ì' : ret.append("&igrave;");  break;
          case 'í' : ret.append("&iacute;");  break;
          case 'î' : ret.append("&icirc;");  break;
          case 'ï' : ret.append("&iuml;");  break;
          case 'ð' : ret.append("&eth;");  break;
          case 'ñ' : ret.append("&ntilde;");  break;
          case 'ò' : ret.append("&ograve;");  break;
          case 'ó' : ret.append("&oacute;");  break;
          case 'ô' : ret.append("&ocirc;");  break;
          case 'õ' : ret.append("&otilde;");  break;
          case 'ö' : ret.append("&ouml;");  break;
          case '÷' : ret.append("&divide;");  break;
          case 'ø' : ret.append("&oslash;");  break;
          case 'ù' : ret.append("&ugrave;");  break;
          case 'ú' : ret.append("&uacute;");  break;
          case 'û' : ret.append("&ucirc;");  break;
          case 'ü' : ret.append("&uuml;");  break;
          case 'ý' : ret.append("&yacute;");  break;
          case 'þ' : ret.append("&thorn;");  break;
          case 'ÿ' : ret.append("&yuml;");  break;
          case 'Î' : ret.append("&Icirc;");  break;
          case '\'': ret.append("&#39;");  break;
          case '"' : ret.append("&quot;");  break;
          default  : ret.append(c);
        }
      }
    }
    return ret.toString();
  }
}