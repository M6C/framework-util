// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ObjectFactory.java

package framework.ressource.xalan.xpath.functions;

import java.io.*;
import java.util.Properties;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            SecuritySupport

class ObjectFactory
{
    static class ConfigurationError extends Error
    {

        Exception getException()
        {
            return exception;
        }

        static final long serialVersionUID = 0xafc121544e837ae9L;
        private Exception exception;

        ConfigurationError(String msg, Exception x)
        {
            super(msg);
            exception = x;
        }
    }


    ObjectFactory()
    {
    }

    static Object createObject(String factoryId, String fallbackClassName)
        throws ConfigurationError
    {
        return createObject(factoryId, null, fallbackClassName);
    }

    static Object createObject(String factoryId, String propertiesFilename, String fallbackClassName)
        throws ConfigurationError
    {
        Class factoryClass = lookUpFactoryClass(factoryId, propertiesFilename, fallbackClassName);
        if(factoryClass == null)
            throw new ConfigurationError("Provider for " + factoryId + " cannot be found", null);
        try
        {
            Object instance = factoryClass.newInstance();
            debugPrintln("created new instance of factory " + factoryId);
            return instance;
        }
        catch(Exception x)
        {
            throw new ConfigurationError("Provider for factory " + factoryId + " could not be instantiated: " + x, x);
        }
    }

    static Class lookUpFactoryClass(String factoryId)
        throws ConfigurationError
    {
        return lookUpFactoryClass(factoryId, null, null);
    }

    static Class lookUpFactoryClass(String factoryId, String propertiesFilename, String fallbackClassName)
        throws ConfigurationError
    {
        String factoryClassName = lookUpFactoryClassName(factoryId, propertiesFilename, fallbackClassName);
        ClassLoader cl = findClassLoader();
        if(factoryClassName == null)
            factoryClassName = fallbackClassName;
        try
        {
            Class providerClass = findProviderClass(factoryClassName, cl, true);
            debugPrintln("created new instance of " + providerClass + " using ClassLoader: " + cl);
            return providerClass;
        }
        catch(ClassNotFoundException x)
        {
            throw new ConfigurationError("Provider " + factoryClassName + " not found", x);
        }
        catch(Exception x)
        {
            throw new ConfigurationError("Provider " + factoryClassName + " could not be instantiated: " + x, x);
        }
    }

    static String lookUpFactoryClassName(String factoryId, String propertiesFilename, String fallbackClassName)
    {
        SecuritySupport ss = SecuritySupport.getInstance();
        try
        {
            String systemProp = ss.getSystemProperty(factoryId);
            if(systemProp != null)
            {
                debugPrintln("found system property, value=" + systemProp);
                return systemProp;
            }
        }
        catch(SecurityException se) { }
        String factoryClassName = null;
        if(propertiesFilename == null)
        {
            File propertiesFile = null;
            boolean propertiesFileExists = false;
            try
            {
                String javah = ss.getSystemProperty("java.home");
                propertiesFilename = javah + File.separator + "lib" + File.separator + "xalan.properties";
                propertiesFile = new File(propertiesFilename);
                propertiesFileExists = ss.getFileExists(propertiesFile);
            }
            catch(SecurityException e)
            {
                fLastModified = -1L;
                fXalanProperties = null;
            }
            synchronized(framework.ressource.xalan.xpath.functions.ObjectFactory.class)
            {
                boolean loadProperties = false;
                FileInputStream fis = null;
                try
                {
                    if(fLastModified >= 0L)
                    {
                        if(propertiesFileExists && fLastModified < (fLastModified = ss.getLastModified(propertiesFile)))
                            loadProperties = true;
                        else
                        if(!propertiesFileExists)
                        {
                            fLastModified = -1L;
                            fXalanProperties = null;
                        }
                    } else
                    if(propertiesFileExists)
                    {
                        loadProperties = true;
                        fLastModified = ss.getLastModified(propertiesFile);
                    }
                    if(loadProperties)
                    {
                        fXalanProperties = new Properties();
                        fis = ss.getFileInputStream(propertiesFile);
                        fXalanProperties.load(fis);
                    }
                }
                catch(Exception x)
                {
                    fXalanProperties = null;
                    fLastModified = -1L;
                }
                finally
                {
                    if(fis != null)
                        try
                        {
                            fis.close();
                        }
                        catch(IOException exc) { }
                }
            }
            if(fXalanProperties != null)
                factoryClassName = fXalanProperties.getProperty(factoryId);
        } else
        {
            FileInputStream fis = null;
            try
            {
                fis = ss.getFileInputStream(new File(propertiesFilename));
                Properties props = new Properties();
                props.load(fis);
                factoryClassName = props.getProperty(factoryId);
            }
            catch(Exception x) { }
            finally
            {
                if(fis != null)
                    try
                    {
                        fis.close();
                    }
                    catch(IOException exc) { }
            }
        }
        if(factoryClassName != null)
        {
            debugPrintln("found in " + propertiesFilename + ", value=" + factoryClassName);
            return factoryClassName;
        } else
        {
            return findJarServiceProviderName(factoryId);
        }
    }

    private static void debugPrintln(String s)
    {
    }

    static ClassLoader findClassLoader()
        throws ConfigurationError
    {
        SecuritySupport ss = SecuritySupport.getInstance();
        ClassLoader context = ss.getContextClassLoader();
        ClassLoader system = ss.getSystemClassLoader();
        ClassLoader chain = system;
        do
        {
            if(context == chain)
            {
                ClassLoader current = (framework.ressource.xalan.xpath.functions.ObjectFactory.class).getClassLoader();
                chain = system;
                do
                {
                    if(current == chain)
                        return system;
                    if(chain != null)
                        chain = ss.getParentClassLoader(chain);
                    else
                        return current;
                } while(true);
            }
            if(chain != null)
                chain = ss.getParentClassLoader(chain);
            else
                return context;
        } while(true);
    }

    static Object newInstance(String className, ClassLoader cl, boolean doFallback)
        throws ConfigurationError
    {
        try
        {
            Class providerClass = findProviderClass(className, cl, doFallback);
            Object instance = providerClass.newInstance();
            debugPrintln("created new instance of " + providerClass + " using ClassLoader: " + cl);
            return instance;
        }
        catch(ClassNotFoundException x)
        {
            throw new ConfigurationError("Provider " + className + " not found", x);
        }
        catch(Exception x)
        {
            throw new ConfigurationError("Provider " + className + " could not be instantiated: " + x, x);
        }
    }

    static Class findProviderClass(String className, ClassLoader cl, boolean doFallback)
        throws ClassNotFoundException, ConfigurationError
    {
        SecurityManager security = System.getSecurityManager();
        try
        {
            if(security != null)
            {
                int lastDot = className.lastIndexOf(".");
                String packageName = className;
                if(lastDot != -1)
                    packageName = className.substring(0, lastDot);
                security.checkPackageAccess(packageName);
            }
        }
        catch(SecurityException e)
        {
            throw e;
        }
        Class providerClass;
        if(cl == null)
            providerClass = Class.forName(className);
        else
            try
            {
                providerClass = cl.loadClass(className);
            }
            catch(ClassNotFoundException x)
            {
                if(doFallback)
                {
                    ClassLoader current = (framework.ressource.xalan.xpath.functions.ObjectFactory.class).getClassLoader();
                    if(current == null)
                        providerClass = Class.forName(className);
                    else
                    if(cl != current)
                    {
                        cl = current;
                        providerClass = cl.loadClass(className);
                    } else
                    {
                        throw x;
                    }
                } else
                {
                    throw x;
                }
            }
        return providerClass;
    }

    private static String findJarServiceProviderName(String factoryId)
    {
        SecuritySupport ss = SecuritySupport.getInstance();
        String serviceId = "META-INF/services/" + factoryId;
        java.io.InputStream is = null;
        ClassLoader cl = findClassLoader();
        is = ss.getResourceAsStream(cl, serviceId);
        if(is == null)
        {
            ClassLoader current = (framework.ressource.xalan.xpath.functions.ObjectFactory.class).getClassLoader();
            if(cl != current)
            {
                cl = current;
                is = ss.getResourceAsStream(cl, serviceId);
            }
        }
        if(is == null)
            return null;
        debugPrintln("found jar resource=" + serviceId + " using ClassLoader: " + cl);
        BufferedReader rd;
        try
        {
            rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        }
        catch(UnsupportedEncodingException e)
        {
            rd = new BufferedReader(new InputStreamReader(is));
        }
        String factoryClassName = null;
        try
        {
            factoryClassName = rd.readLine();
        }
        catch(IOException x)
        {
            String s = null;
            return s;
        }
        finally
        {
            try
            {
                rd.close();
            }
            catch(IOException exc) { }
        }
        if(factoryClassName != null && !"".equals(factoryClassName))
        {
            debugPrintln("found in resource, value=" + factoryClassName);
            return factoryClassName;
        } else
        {
            return null;
        }
    }

    private static final String DEFAULT_PROPERTIES_FILENAME = "xalan.properties";
    private static final String SERVICES_PATH = "META-INF/services/";
    private static final boolean DEBUG = false;
    private static Properties fXalanProperties = null;
    private static long fLastModified = -1L;

}
