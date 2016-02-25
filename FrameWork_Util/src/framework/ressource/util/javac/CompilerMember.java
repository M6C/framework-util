/*
 * @(#)CompilerMember.java	1.15 00/02/02
 *
 * Copyright 1994-2000 Sun Microsystems, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of Sun Microsystems, Inc.
 * Use is subject to license terms.
 *
 */

package framework.ressource.util.javac;

import sun.tools.asm.Assembler;
import sun.tools.java.MemberDefinition;

/**
 * This class is used to represents fields while they are being compiled
 */
final
class CompilerMember implements Comparable {
    MemberDefinition field;
    Assembler asm;
    Object value;
    String name;
    String sig;
    String key;

    CompilerMember(MemberDefinition field, Assembler asm) {
	this.field = field;
	this.asm = asm;
	name = field.getName().toString();
	sig = field.getType().getTypeSignature();
    }

    public int compareTo(Object o) {
	CompilerMember cm = (CompilerMember) o;
	return getKey().compareTo(cm.getKey());
    }

    /**
	 * @return  the key
	 * @uml.property  name="key"
	 */
    String getKey() {
	if (key==null)
	    key = name+sig;
	return key;
    }

}
