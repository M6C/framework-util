// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SecuritySupport12.java

package framework.ressource.xalan.xpath.functions;

import java.io.*;
import java.security.*;

// Referenced classes of package framework.ressource.xalan.xpath.functions:
//            SecuritySupport

class SecuritySupport12 extends SecuritySupport
{

    SecuritySupport12()
    {
    }

    ClassLoader getContextClassLoader()
    {
        return (ClassLoader)AccessController.doPrivileged(new PrivilegedAction() {

            public Object run()
            {
                ClassLoader cl = null;
                try
                {
                    cl = Thread.currentThread().getContextClassLoader();
                }
                catch(SecurityException ex) { }
                return cl;
            }

        }
);
    }

    ClassLoader getSystemClassLoader()
    {
        return (ClassLoader)AccessController.doPrivileged(new PrivilegedAction() {

            public Object run()
            {
                ClassLoader cl = null;
                try
                {
                    cl = ClassLoader.getSystemClassLoader();
                }
                catch(SecurityException ex) { }
                return cl;
            }

        }
);
    }

    ClassLoader getParentClassLoader(final ClassLoader cl)
    {
        return (ClassLoader)AccessController.doPrivileged(new PrivilegedAction() {

            public Object run()
            {
                ClassLoader parent = null;
                try
                {
                    parent = cl.getParent();
                }
                catch(SecurityException ex) { }
                return parent != cl ? parent : null;
            }

        }
);
    }

    String getSystemProperty(final String propName)
    {
        return (String)AccessController.doPrivileged(new PrivilegedAction() {

            public Object run()
            {
                return System.getProperty(propName);
            }

        }
);
    }

    FileInputStream getFileInputStream(final File file)
        throws FileNotFoundException
    {
        try
        {
            return (FileInputStream)AccessController.doPrivileged(new PrivilegedExceptionAction() {

                public Object run()
                    throws FileNotFoundException
                {
                    return new FileInputStream(file);
                }

            }
);
        }
        catch(PrivilegedActionException e)
        {
            throw (FileNotFoundException)e.getException();
        }
    }

    InputStream getResourceAsStream(final ClassLoader cl, final String name)
    {
        return (InputStream)AccessController.doPrivileged(new PrivilegedAction() {

            public Object run()
            {
                InputStream ris;
                if(cl == null)
                    ris = ClassLoader.getSystemResourceAsStream(name);
                else
                    ris = cl.getResourceAsStream(name);
                return ris;
            }

        }
);
    }

    boolean getFileExists(final File f)
    {
        return ((Boolean)AccessController.doPrivileged(new PrivilegedAction() {

            public Object run()
            {
                return new Boolean(f.exists());
            }

        }
)).booleanValue();
    }

    long getLastModified(final File f)
    {
        return ((Long)AccessController.doPrivileged(new PrivilegedAction() {

            public Object run()
            {
                return new Long(f.lastModified());
            }

        }
)).longValue();
    }
}
