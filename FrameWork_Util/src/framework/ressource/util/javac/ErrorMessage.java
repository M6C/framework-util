/*
 * @(#)ErrorMessage.java	1.15 00/02/02
 *
 * Copyright 1994-2000 Sun Microsystems, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of Sun Microsystems, Inc.
 * Use is subject to license terms.
 *
 */

package framework.ressource.util.javac;

/**
 * A sorted list of error messages
 */
final
class ErrorMessage {
    long where;
    String message;
    ErrorMessage next;

    /**
     * Constructor
     */
    ErrorMessage(long where, String message) {
	this.where = where;
	this.message = message;
    }
}
