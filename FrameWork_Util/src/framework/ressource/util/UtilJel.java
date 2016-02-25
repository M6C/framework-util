package framework.ressource.util;

import edu.mit.ai.psg.jevaES.JevaES;
import edu.mit.ai.psg.jevaES.ParseException;
import edu.mit.ai.psg.jevaES.ThrowException;
import edu.mit.ai.psg.jevaES.VerifyingException;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class UtilJel {
  /**
   *
   * @param expression String
   * @throws Exception trows ThrowException, VerifyingException and ParseException exceptions
   * @return boolean result of expression
   */
  public static boolean safeResolveBooleanExpression(String expression) {
    boolean ret = false;
    try {ret = resolveBooleanExpression(expression);}
    catch (ThrowException ex) {}
    catch (VerifyingException ex) {}
    catch (ParseException ex) {}
    catch (Exception ex) {}
    return ret;
  }

  public static boolean resolveBooleanExpression(String expression) throws Exception {
      return ( (Boolean) JevaES.parseEvalStringExpression(expression)).booleanValue();
  }

  public static String safeResolveStringExpression(String expression) {
    String ret = "";
    try {ret = resolveStringExpression(expression);}
    catch (ThrowException ex) {}
    catch (VerifyingException ex) {}
    catch (ParseException ex) {}
    catch (Exception ex) {}
    return ret;
  }

  public static String resolveStringExpression(String expression) throws ThrowException, VerifyingException, ParseException, Exception {
      return (String)JevaES.parseEvalStringExpression(expression);
  }
}
