// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WrongNumberArgsException.java

package framework.ressource.xalan.xpath.functions;


public class WrongNumberArgsException extends Exception
{

    public WrongNumberArgsException(String argsExpected)
    {
        super(argsExpected);
    }

    static final long serialVersionUID = 0xc0d58cbebb2a2300L;
}
