/*
 * %W% %E%
 *
 * Copyright 1996-2000 Sun Microsystems, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of Sun Microsystems, Inc.
 * Use is subject to license terms.
 *
 */

package framework.ressource.util.javac;

/**
 * Allows for easier parsing of errors and warnings from the compiler
 */

public
interface ErrorConsumer {
	public void pushError(String errorFileName,
							int line,
							String message,
							String referenceText, String referenceTextPointer);
};
