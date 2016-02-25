package framework.ressource.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author non attribuable
 * @version 1.0
 */

public class UtilReflect {
  protected UtilReflect() {
  }

  public static ClassLoader getContextClassLoader() {
    return Thread.currentThread().getContextClassLoader();
  }
  public static Class loadClass(String className) throws ClassNotFoundException {
    return getContextClassLoader().loadClass(className);
  }
  public static Object newInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    Class cls=loadClass(className);
    return (cls!=null ?  cls.newInstance() : null);
  }

  public static Object safeInvokeField(Object obj, String fieldName) {
	return safeInvokeField(obj.getClass(), fieldName);
  }

  public static Object safeInvokeField(Class aClass, String fieldName) {
    Object ret = null;
	try {
		ret = invokeField(aClass, fieldName);
	} catch (SecurityException ex) {
	} catch (IllegalAccessException ex) {
	} catch (IllegalArgumentException ex) {
	} catch (NoSuchFieldException e) {
	}
	return ret;
  }

  public static Object invokeField(Object obj, String fieldName) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
	return invokeField(obj.getClass(), fieldName);
  }

  public static Object invokeField(Class aClass, String fieldName) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    Object ret = null;
	Field field = null;
	if (Modifier.isPublic(aClass.getModifiers())) {
		field = aClass.getField(fieldName);
		ret = field.get(null);
	}
	return ret;
  }

  public static Object safeInvokeMethod(Object obj, String methodName, Class[] type, Object[] value) {
    Object ret = null;
    try {
      ret = invokeMethod(obj, methodName, type, value);
    }
    catch (NoSuchMethodException ex) {
    }
    catch (InvocationTargetException ex) {
    	//ex.printStackTrace();
    }
    catch (IllegalAccessException ex) {
    	//ex.printStackTrace();
    }
    catch (IllegalArgumentException ex) {
    	//ex.printStackTrace();
    }
    return ret;
  }

  public static Object invokeMethod(Object obj, String methodName, Class[] type, Object[] value) throws
      IllegalArgumentException, IllegalAccessException,
      InvocationTargetException, NoSuchMethodException
  {
    Object ret = null;
    if (obj != null)
    {
/*
      Method method = obj.getClass().getMethod(methodName, type);
      ret = method.invoke(obj, value);
*/
/*
    	Class aClass = obj.getClass();
    	while (!Modifier.isPublic(aClass.getModifiers())) {
    			aClass = aClass.getSuperclass();
    	}
      Method method = aClass.getMethod(methodName, type);
      ret = method.invoke(obj, value);
*/
        Method method = null;
    	Class aClass = obj.getClass();
        while((method==null)&&(aClass.getSuperclass()!=null)) {
        	if (Modifier.isPublic(aClass.getModifiers())) {
        		if ((value!=null) && ((type==null) || type.length!=value.length))  {
        			// Si on a pas passé les types de parametre ou que le nombre est different avec les parametres
        			// on appel toutes les methodes du même nom et qui ont le même nombre de paramètres
    	        	Method[] methods = aClass.getMethods();
    	        	if (methods!=null) {
    	        		int size = methods.length;
    	        		for(int i=0 ; i<size ; i++) {
    						try {
    							if (methods[i].getName().equals(methodName) && methods[i].getParameterTypes().length==value.length) {
	    							ret = methods[i].invoke(obj, value);
	        	        			method = methods[i];
	    							break;
    							}
    						}
    						catch (Exception ex) {
    						}
    	        		}
    	        		break;
    	        	}
        		}
        		else {
	        	    try {
		          	      method = aClass.getMethod(methodName, type);
		        	      ret = method.invoke(obj, value);
	        	      }
	        	      catch (NoSuchMethodException ex) {
	        	      }
	        	      break;
        		}
	    	}
        	else {
	        	Class[] interfaces = aClass.getInterfaces();
	        	if (interfaces!=null) {
	        		int size = interfaces.length;
	        		for(int i=0 ; i<size ; i++) {
						try {
							method = interfaces[i].getMethod(methodName, type);
							ret = method.invoke(obj, value);
							break;
						}
						catch (NoSuchMethodException ex) {
						}
	        		}
	        	}
    			aClass = aClass.getSuperclass();
        	}
        }
    }
    return ret;
  }

  public static Method[] getMethods(String className) throws
      InstantiationException, ClassNotFoundException, NoSuchMethodException,
      InvocationTargetException, IllegalAccessException,
      IllegalArgumentException {
    return getMethods(loadClass(className));
  }

  public static Method[] getMethods(Object obj) throws
      IllegalArgumentException, IllegalAccessException,
      InvocationTargetException, NoSuchMethodException {
      return getMethods(obj.getClass());
  }

  public static Method[] getMethods(Class cls) throws
      IllegalArgumentException, IllegalAccessException,
      InvocationTargetException, NoSuchMethodException {
    Method[] ret = null;
    if (cls != null)
      ret = cls.getDeclaredMethods();
    return ret;
  }
}
