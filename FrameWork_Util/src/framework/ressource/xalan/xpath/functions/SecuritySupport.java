// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SecuritySupport.java

package framework.ressource.xalan.xpath.functions;

import java.io.*;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            SecuritySupport12

class SecuritySupport
{

    SecuritySupport()
    {
    }

    static SecuritySupport getInstance()
    {
        return (SecuritySupport)securitySupport;
    }

    ClassLoader getContextClassLoader()
    {
        return null;
    }

    ClassLoader getSystemClassLoader()
    {
        return null;
    }

    ClassLoader getParentClassLoader(ClassLoader cl)
    {
        return null;
    }

    String getSystemProperty(String propName)
    {
        return System.getProperty(propName);
    }

    FileInputStream getFileInputStream(File file)
        throws FileNotFoundException
    {
        return new FileInputStream(file);
    }

    InputStream getResourceAsStream(ClassLoader cl, String name)
    {
        InputStream ris;
        if(cl == null)
            ris = ClassLoader.getSystemResourceAsStream(name);
        else
            ris = cl.getResourceAsStream(name);
        return ris;
    }

    boolean getFileExists(File f)
    {
        return f.exists();
    }

    long getLastModified(File f)
    {
        return f.lastModified();
    }

    private static final Object securitySupport;

    static 
    {
        SecuritySupport ss = null;
        try
        {
            Class c = Class.forName("java.security.AccessController");
            ss = new SecuritySupport12();
        }
        catch(Exception ex) { }
        finally
        {
            if(ss == null)
                ss = new SecuritySupport();
            securitySupport = ss;
        }
    }
}
