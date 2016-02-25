// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XPATHMessages.java

package framework.ressource.xalan.xpath.res;

import java.text.MessageFormat;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;
import org.apache.xml.res.XMLMessages;

public class XPATHMessages extends XMLMessages
{

    public XPATHMessages()
    {
    }

    public static final String createXPATHMessage(String msgKey, Object args[])
    {
        if(XPATHBundle == null)
            XPATHBundle = XMLMessages.loadResourceBundle("framework.ressource.xalan.xpath.res.XPATHErrorResources");
        if(XPATHBundle != null)
            return createXPATHMsg(XPATHBundle, msgKey, args);
        else
            return "Could not load any resource bundles.";
    }

    public static final String createXPATHWarning(String msgKey, Object args[])
    {
        if(XPATHBundle == null)
            XPATHBundle = XMLMessages.loadResourceBundle("framework.ressource.xalan.xpath.res.XPATHErrorResources");
        if(XPATHBundle != null)
            return createXPATHMsg(XPATHBundle, msgKey, args);
        else
            return "Could not load any resource bundles.";
    }

    public static final String createXPATHMsg(ListResourceBundle fResourceBundle, String msgKey, Object args[])
    {
        String fmsg = null;
        boolean throwex = false;
        String msg = null;
        if(msgKey != null)
            msg = fResourceBundle.getString(msgKey);
        if(msg == null)
        {
            msg = fResourceBundle.getString("BAD_CODE");
            throwex = true;
        }
        if(args != null)
            try
            {
                int n = args.length;
                for(int i = 0; i < n; i++)
                    if(null == args[i])
                        args[i] = "";

                fmsg = MessageFormat.format(msg, args);
            }
            catch(Exception e)
            {
                fmsg = fResourceBundle.getString("FORMAT_FAILED");
                fmsg = fmsg + " " + msg;
            }
        else
            fmsg = msg;
        if(throwex)
            throw new RuntimeException(fmsg);
        else
            return fmsg;
    }

    private static ListResourceBundle XPATHBundle = null;
    private static final String XPATH_ERROR_RESOURCES = "framework.ressource.xalan.xpath.res.XPATHErrorResources";

}
