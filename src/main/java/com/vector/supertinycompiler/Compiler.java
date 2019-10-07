/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler;

/**
 * Compiler is a process of translating one pieces of codes into another pieces of codes.
 * 
 * @author  quickpoint 
 * @version $Id: Compiler.java, v 1.0 2019 Exp $
 */
public interface Compiler {

    /**
     * Compile the input codes into output codes.
     * 
     * @param input input codes
     * @return output codes
     * @throws ParseException thrown when compiling failed
     */
    String compile(String input) throws ParseException;
}
