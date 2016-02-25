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
          case '�' : ret.append("&iexcl;");  break;
          case '�' : ret.append("&cent;");  break;
          case '�' : ret.append("&pound;");  break;
          case '�' : ret.append("&curren;");  break;
          case '�' : ret.append("&yen;");  break;
          case '�' : ret.append("&brvbar;");  break;
          case '�' : ret.append("&sect;");  break;
          case '�' : ret.append("&uml;");  break;
          case '�' : ret.append("&copy;");  break;
          case '�' : ret.append("&ordf;");  break;
          case '�' : ret.append("&laquo;");  break;
          case '�' : ret.append("&not;");  break;
          case '�'  : ret.append("&shy;");  break;
          case '�' : ret.append("&reg;");  break;
          case '�' : ret.append("&macr;");  break;
          case '�' : ret.append("&deg;");  break;
          case '�' : ret.append("&plusmn;");  break;
          case '�' : ret.append("&sup2;");  break;
          case '�' : ret.append("&sup3;");  break;
          case '�' : ret.append("&acute;");  break;
          case '�' : ret.append("&micro;");  break;
          case '�' : ret.append("&para;");  break;
          case '�' : ret.append("&middot;");  break;
          case '�' : ret.append("&cedil;");  break;
          case '�' : ret.append("&sup1;");  break;
          case '�' : ret.append("&ordm;");  break;
          case '�' : ret.append("&raquo;");  break;
          case '�' : ret.append("&frac14;");  break;
          case '�' : ret.append("&frac12;");  break;
          case '�' : ret.append("&frac34;");  break;
          case '�' : ret.append("&iquest;");  break;
          case '�' : ret.append("&Agrave;");  break;
          case '�' : ret.append("&Aacute;");  break;
          case '�' : ret.append("&Acirc;");  break;
          case '�' : ret.append("&Atilde;");  break;
          case '�' : ret.append("&Auml;");  break;
          case '�' : ret.append("&Aring;");  break;
          case '�' : ret.append("&AElig;");  break;
          case '�' : ret.append("&Ccedil;");  break;
          case '�' : ret.append("&Egrave;");  break;
          case '�' : ret.append("&Eacute;");  break;
          case '�' : ret.append("&Ecirc;");  break;
          case '�' : ret.append("&Euml;");  break;
          case '�' : ret.append("&Igrave;");  break;
          case '�' : ret.append("&Iacute;");  break;
          case '�' : ret.append("&Iuml;");  break;
          case '�' : ret.append("&ETH;");  break;
          case '�' : ret.append("&Ntilde;");  break;
          case '�' : ret.append("&Ograve;");  break;
          case '�' : ret.append("&Oacute;");  break;
          case '�' : ret.append("&Ocirc;");  break;
          case '�' : ret.append("&Otilde;");  break;
          case '�' : ret.append("&Ouml;");  break;
          case '�' : ret.append("&times;");  break;
          case '�' : ret.append("&Oslash;");  break;
          case '�' : ret.append("&Ugrave;");  break;
          case '�' : ret.append("&Uacute;");  break;
          case '�' : ret.append("&Ucirc;");  break;
          case '�' : ret.append("&Uuml;");  break;
          case '�' : ret.append("&Yacute;");  break;
          case '�' : ret.append("&THORN;");  break;
          case '�' : ret.append("&szlig;");  break;
          case '�' : ret.append("&agrave;");  break;
          case '�' : ret.append("&aacute;");  break;
          case '�' : ret.append("&acirc;");  break;
          case '�' : ret.append("&atilde;");  break;
          case '�' : ret.append("&auml;");  break;
          case '�' : ret.append("&aring;");  break;
          case '�' : ret.append("&aelig;");  break;
          case '�' : ret.append("&ccedil;");  break;
          case '�' : ret.append("&egrave;");  break;
          case 233 : ret.append("&eacute;");  break;
          case '�' : ret.append("&ecirc;");  break;
          case '�' : ret.append("&euml;");  break;
          case '�' : ret.append("&igrave;");  break;
          case '�' : ret.append("&iacute;");  break;
          case '�' : ret.append("&icirc;");  break;
          case '�' : ret.append("&iuml;");  break;
          case '�' : ret.append("&eth;");  break;
          case '�' : ret.append("&ntilde;");  break;
          case '�' : ret.append("&ograve;");  break;
          case '�' : ret.append("&oacute;");  break;
          case '�' : ret.append("&ocirc;");  break;
          case '�' : ret.append("&otilde;");  break;
          case '�' : ret.append("&ouml;");  break;
          case '�' : ret.append("&divide;");  break;
          case '�' : ret.append("&oslash;");  break;
          case '�' : ret.append("&ugrave;");  break;
          case '�' : ret.append("&uacute;");  break;
          case '�' : ret.append("&ucirc;");  break;
          case '�' : ret.append("&uuml;");  break;
          case '�' : ret.append("&yacute;");  break;
          case '�' : ret.append("&thorn;");  break;
          case '�' : ret.append("&yuml;");  break;
          case '�' : ret.append("&Icirc;");  break;
          case '\'': ret.append("&#39;");  break;
          case '"' : ret.append("&quot;");  break;
          default  : ret.append(c);
        }
      }
    }
    return ret.toString();
  }
}