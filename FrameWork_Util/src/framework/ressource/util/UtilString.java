package framework.ressource.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.Vector;
import java.util.List;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */

public class UtilString {

  private UtilString() {
  }

  public static boolean isEmpty(String str) {
    return ((str==null)||(str.equals("")));
  }

  public static boolean isNotEmpty(String str) {
    return ((str!=null)&&(!str.equals("")));
  }

  public static boolean isEquals(String str1, String str2){
    return ((str1!=null)&&(str1.equals(str2)));
  }

  public static boolean isNotEquals(String str1, String str2){
    return ((str1==null)||(str2==null)||(!str1.equals(str2)));
  }

  public static boolean isEqualsIgnoreCase(String str1, String str2){
    return ((str1!=null)&&(str2!=null)&&(str1.toUpperCase().equals(str2.toUpperCase())));
  }

  public static boolean isNotEqualsIgnoreCase(String str1, String str2){
    return ((str1==null)||(str2==null)||(!str1.toUpperCase().equals(str2.toUpperCase())));
  }

  public static boolean isBeginBy(String str1, String str2){
    return ((str1!=null)&&(str2!=null)&&(str1.indexOf(str2)==0));
  }

  public static boolean isNotBeginBy(String str1, String str2){
    return ((str1==null)||(str2==null)||(str1.indexOf(str2)!=0));
  }

  public static boolean isEndBy(String str1, String str2){
    return ((str1!=null)&&(str2!=null)&&((str1.indexOf(str2)+str2.length())==str1.length()));
  }

  public static boolean isEndByIgnoreCase(String str1, String str2){
    return ((str1!=null)&&(str2!=null)&&((str1.toUpperCase().indexOf(str2.toUpperCase())+str2.length())==str1.length()));
  }

  public static boolean isNotEndBy(String str1, String str2){
    return ((str1==null)||(str2==null)||((str1.indexOf(str2)+str2.length())!=str1.length()));
  }

  public static boolean isBeginByIgnoreCase(String str1, String str2){
    return ((str1!=null)&&(str2!=null)&&(str1.toUpperCase().indexOf(str2.toUpperCase())==0));
  }

  public static boolean isNotBeginByIgnoreCase(String str1, String str2){
    return ((str1==null)||(str2==null)||(str1.toUpperCase().indexOf(str2.toUpperCase())!=0));
  }

  public static String cutAfterLastIndexOf(String str, int chr) {
    String ret = str;
    if(isNotEmpty(str)) {
      int pos = str.lastIndexOf(chr);
      ret = (pos>=0) ? str.substring(pos+1) : str;
    }
    return ret;
  }

  /**
   * Index d'un mot complet dans un text
   * @param text String
   * @param word String
   * @return int -1 si non trouvé >=0 dans les autres cas
   */
  public static int indexOfWordOnly(String text, String word) {
    return indexOfWordOnly(text, word, 0);
  }

  /**
   * Index d'un mot complet dans un text à partir d'un index
   * @param text String
   * @param word String
   * @param index int
   * @return int -1 si non trouvé >=0 dans les autres cas
   */
  public static int indexOfWordOnly(String text, String word, int index) {
    int ret = -1, idx = index;
    int lenWord = word.length();
    int lenText = text.length();
    char carBefore = 0, carAfter = 0;
    boolean isLoop = false;
    do {
      idx = text.indexOf(word, idx);
      if ((idx == 0) && (lenText==lenWord)){
    	  ret = idx;
      }
      else if (idx >= 0) {
        carBefore = (idx==0) ? ' ' : text.charAt(idx - 1);
        carAfter = text.charAt(idx + lenWord);
        isLoop = (!isSpaceCar(carBefore) || !isSpaceCar(carAfter)) ||
            // entre A et Z
            (((carBefore >= 65) && (carBefore <= 90))) ||
            // entre a et z
            (((carBefore >= 97) && (carBefore <= 122))) ||
            // entre A et Z
            (((carAfter >= 65) && (carAfter <= 90))) ||
            // entre a et z
            (((carAfter >= 97) && (carAfter <= 122))) ||
            // entre À [&Agrave;] et ÿ [&yuml;] sauf × [&times;], ÷ [&divide;]
            (((carBefore >= 192) && (carBefore <= 255) && (carAfter != 215) && (carAfter != 247))) ||
            // entre À [&Agrave;] et ÿ [&yuml;] sauf × [&times;], ÷ [&divide;]
            (((carAfter >= 192) && (carAfter <= 255) && (carAfter != 215) && (carAfter != 247)))
            ;
        if (!isLoop)
          ret = idx;
        idx++;
      }
      else
        isLoop = false;
    }
    while (isLoop);
    return ret;
  }

  /**
   * Verifi si c'est un caractère d'espacement (' ', '\t', '\r', '\n', '%A0')
   * @param car char Caractère a verifier
   * @return boolean true si car est un caractère d'espacement
   */
  public static boolean isSpaceCar(char car) {
    return ((car==' ') || (car=='\t') || (car=='\r') || (car=='\n') || (car==160) || (car==10) || (car==32));
  }

  /**
   * Retourne le mots juste avant une position dans le texte
   * Recherche jusqu'aux caractères : ';', '?', ':', '+', '-', '>', '<', '(',
   * ')', '[', ']', '{', '}'
   * Ou jusqu'aux caractères : ' ', '\t', '\r', '\n' si un mot à été trouvé
   * @param text String
   * @param pos int
   * @return String null if pos is not valide or Empty string
   */
  public static String getWordBeforePos (String text, int pos, boolean wordReverse) {
    String ret = null;
    int size = text.length();
    if ((pos>0) && (pos<=size)) {
      StringBuffer sbVar = new StringBuffer();
      char car = 0;
      for (int i = (pos - 1); i >= 0; i--) {
        car = text. charAt(i);
        switch(car) {
          case ' ' :
          case '\t' :
          case '\r' :
          case '\n' :
          case 160 : // %A0
            if (sbVar.length()>0)
              i = 0;
            break;
          case ';' : case '?' : case ':' : case '+' : case '-' :
          case '>' : case '<' : case '(' : case ')' :
          case '[' : case ']' : case '{' : case '}' :
            i = 0;
            break;
          default :
            sbVar.append(car);
        }
      }
      if (wordReverse)
        ret = sbVar.toString().trim();
      else
        ret = sbVar.reverse().toString().trim();
    }
    return ret;
  }

  public static String reverseString(String str) {
    return (str==null) ? null : new StringBuffer(str).reverse().toString();
  }

  /**
   * Equivalent de split dans le JDK 1.4 car bug dans le JDK 1.3
   *
   * @param uneChaine chaine à splitter
   * @param separateur séparateur
   * @return tableau
   */
  public static String[] split(String uneChaine, char separateur) {

    Vector lesTokens = new Vector();
    split(uneChaine, separateur, lesTokens);

    Enumeration e = lesTokens.elements();

    String[] ret = new String[lesTokens.size()];
    int i = 0;
    while (e.hasMoreElements()) {
      Object unToken = e.nextElement();
      //if (isNotEmpty((String)unToken))
        ret[i++] = (String)unToken;
    }
    if (i<ret.length){
      String[] res = new String[i];
      for(int j=0 ; j<i ; res[j]=ret[j++]);
      ret = res;
    }

    return ret;

  }

  /**
   * Equivalent de split dans le JDK 1.4 car bug dans le JDK 1.3
   *
   * @param uneChaine chaine à splitter
   * @param separateur séparateur
   * @param res vecteur auquel on a rajouté le resultat du split
   */
  public static void split(String uneChaine, char separateur, List res) {
    if (res == null) {
      res = new Vector();

    }
    if (uneChaine!=null) {
      int indexFirstPos = uneChaine.indexOf(separateur);
      if (indexFirstPos != -1) {
        String unToken = uneChaine.substring(0, indexFirstPos);
        String sousChaineSansToken = uneChaine.substring(indexFirstPos+1);
        res.add(unToken);
        split(sousChaineSansToken, separateur, res);
      }
      else {
        res.add(uneChaine);
      }
    }
  }

  /**
   * Replace txt1 by txt2 into str
   * @param str
   * @param txt1
   * @param txt2
   * @return
   */
  public static String replaceAll( String str, String txt1, String txt2 )
  {
    int index = 0;
    int iTxt1Len = txt1.length();
    int iTxt2Len = txt2.length();
    StringBuffer ret = new StringBuffer(str);
    while( (index=ret.toString().indexOf(txt1, index))>=0 )
    {
      ret.delete(index, (index+iTxt1Len));
      ret.insert(index, txt2);
      index+=iTxt2Len;
    }
    return ret.toString();
  }

  /**
   * Remplace toutes les occurences trouvé à partir de txt1B jusqu'à la fin de txt1E par txt2
   * @param str Text a parcourir
   * @param txt1B Debut du texte de debut de recherche
   * @param txt1E Fin du texte de debut de recherche
   * @param txt2 Nouveau text a inserer a la place
   * @return Le text modifie
   */
  public static String replaceAll( String str, String txt1B, String txt1E, String txt2 ) {
	  StringBuffer ret = new StringBuffer(str);
	  int iTxt1B=0, iTxt1E=0;
	  int lenTxt1E=txt1E.length();
	  do {
		  iTxt1B = str.indexOf(txt1B, iTxt1E);
		  iTxt1E = str.indexOf(txt1E, iTxt1B);
		  if (iTxt1B>-1 && iTxt1E>iTxt1B) {
			  iTxt1E+=lenTxt1E;
		      ret.delete(iTxt1B, iTxt1E);
		      ret.insert(iTxt1B, txt2);
		      str = ret.toString();
		  }
		  else {
			  break;
		  }
	  }
	  while (true);
	  return ret.toString();
  }

  /**
   * Replace txt1 by txt2 into str
   * @param str
   * @param txt1
   * @param txt2
   * @return
   */
  public static int countOf(String str, char car ) {
    int ret = 0, i = 0;
    while(true) {
      i=str.indexOf(car, i)+1;
      if (i>0)
        ret++;
      else
        break;
    }

    return ret;
  }

  public static String readLine(String str, int lineStart, int nbLine) throws IOException {
	StringBuffer ret = new StringBuffer();
	if ((nbLine!=0) && (str!=null)) {
		StringReader sr = new StringReader(str);
		BufferedReader in = new BufferedReader(sr);

	    if (!in.ready())
	        throw new IOException();

	    try {
			String line;
			// Avance dans le fichier
		    for (int i=1;(i<lineStart)&&(in.readLine()!=null); i++);
		    // Recuper le nombre de ligne demandé
		    for (int i=1;(i<=nbLine)&&((line=in.readLine())!=null); i++) {
	    		ret.append(line).append("\r\n");
		    }
	    } finally {
	    	in.close();
	    }
	}

	return ret.toString();
  }

  /**
   * Extrait toutes les occurences trouvé à partir de begin jusqu'à la fin de end
   * @param str Text a parcourir
   * @param begin Texte de debut de recherche
   * @param end Texte de fin de recherche
   * @return La liste des occurances trouvees
   */
  public static List extractPart(String str, String begin, String end) {
	  List<String> ret = new Vector<String>();
	  int iBegin=0, iEnd=0;
	  int lenEnd=end.length();
	  do {
		  iBegin = str.indexOf(begin, iEnd);
		  iBegin = str.indexOf(end, iBegin);
		  if (iBegin>-1 && iEnd>iBegin) {
			  iEnd+=lenEnd;
			  ret.add(str.substring(iBegin, iEnd));
		  }
		  else {
			  break;
		  }
	  }
	  while (true);
	  return ret;
  }

  /**
   * Extrait toutes les occurences trouvé à partir de beginB jusqu'à la fin de endE
   * @param str Text a parcourir
   * @param beginB Debut du texte de debut de recherche
   * @param beginE Fin du texte de debut de recherche
   * @param endB Debut du texte de fin de recherche
   * @param endE Fin du texte de fin de recherche
   * @return La liste des occurances trouvees
   */
  public static List extractPart(String str, String beginB, String beginE, String endB, String endE) {
	  List<String> ret = new Vector<String>();
	  int iBeginB=0, iBeginE=0, iEndB=0, iEndE=0;
	  int lenEndE=endE.length();
	  do {
		  iBeginB = str.indexOf(beginB, iEndE);
		  iBeginE = str.indexOf(beginE, iBeginB);
		  iEndB = str.indexOf(endB, iBeginE);
		  iEndE = str.indexOf(endE, iEndB);
		  if (iBeginB>-1 && iBeginE>iBeginB && iEndB>iBeginE && iEndE>iEndB) {
			  iEndE+=lenEndE;
			  ret.add(str.substring(iBeginB, iEndE));
		  }
		  else {
			  break;
		  }
	  }
	  while (true);
	  return ret;
  }
}
