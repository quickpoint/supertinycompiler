/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler;

/**
 * Signals that an error has been reached unexpectedly while parsing.
 * 
 * @author  quickpoint 
 * @version $Id: ParseException.java, v 1.0 2019 Exp $
 */
public class ParseException extends Exception {

    /** serialVersionUID */
    private static final long serialVersionUID = 4719335129172725184L;

    /**
     * Construct an exception with given message.
     * 
     * @param message given message
     */
    public ParseException(String message) {
        super(message);
    }

    /**
     * Construct an exception with given message and cause.
     * 
     * @param message given message
     * @param cause given cause
     */
    public ParseException(String message, Throwable cause) {
        super(message, cause);
    }

}
