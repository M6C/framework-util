package framework.ressource.util;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class UtilIndent {
  public UtilIndent() {
  }

  /**
   * Return an Indented String from str
   * @param str
   * @return
   */
  public static String indentHtml(String str) {
    return indentHtml(str, "    ");
  }
  /**
   * Return an Indented String from str
   * @param str
   * @return
   */
  public static String indentHtml(String str, String indent) {
    StringBuffer ret = new StringBuffer("");
    String strU = str.toUpperCase();
    StringBuffer szTag = new StringBuffer("");
    String szRetour = "\r\n";
    int iIndent = 0;
    boolean bTag = false;
    boolean bCommentaire = false;

    for (int i = 0; i < str.length() - 1; i++) {
      boolean bContinue = true;
      char c = str.charAt(i);
      if (bCommentaire) {
        bTag = false;
        // Teste si c'est la fin d'un commentaire de la forme <!-- bla bla bla -->
        if ( (c == '>') && (str.length() > 3) && (str.charAt(i - 1) == '-') && (str.charAt(i - 2) == '-'))
          bCommentaire = false;
      }
      else if (c == '<') {
        if ( (str.charAt(i + 1) == '/') && (iIndent > 0))
          iIndent--;

          // Teste si c'est le début d'un commentaire de la forme <!-- bla bla bla -->
        bCommentaire = (str.charAt(i + 1) == '!');

        // Supprime tout les caractères superflu avant l'ouverture d'une balise
        while ( (ret.length() > 0) && bContinue) {
          char car = ret.charAt(ret.length() - 1);
          switch (car) {
            case ' ':
            case '\n':
            case '\r':
            case '\t':
              ret.deleteCharAt(ret.length() - 1);
              break;
            default:
              bContinue = false;
          }
        }

        ret.append(szRetour);
        for (int j = 0; j < iIndent; j++)
          ret.append(indent);

        bTag = true;
      }
      else if (c == '>') {
        if (strU.indexOf("</" + szTag.toString().toUpperCase(), i) >= 0)
          iIndent++;
        bTag = false;
        szTag = new StringBuffer("");
        // Passe tous les caractères superflu après la fin d'une balise
        while ( (i < str.length() - 1) && bContinue) {
          char car = str.charAt(i + 1);
          switch (car) {
            case ' ':
            case '\n':
            case '\r':
            case '\t':
              i++;
              break;
            default:
              bContinue = false;
          }
        }
      }
      else {
        if ( (i > 0) && (!bTag) && (ret.length() > 0) && (ret.charAt(ret.length() - 1) == '>')) {
          ret.append(szRetour);
          for (int j = 0; j < iIndent; j++)
            ret.append(indent);
        }
        else if (bTag && (c == ' '))
          bTag = false;
        else if (bTag)
          szTag.append(c);
      }
      switch (c) {
        case '\n':
        case '\r':
        case '\t':
          break;
        case ' ': {
          switch (str.charAt(i + 1)) {
            case ' ':
            case '\n':
            case '\r':
            case '\t':
              break;
            default:
              ret.append(c);
          }
          break;
        }
        default:
          ret.append(c);
      }
    }
    return ret.toString();
  }
}
