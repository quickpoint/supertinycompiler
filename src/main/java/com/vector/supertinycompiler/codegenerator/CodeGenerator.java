/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.codegenerator;

import com.vector.supertinycompiler.ParseException;
import com.vector.supertinycompiler.parser.Node;

/**
 * <code>CodeGenerator</code> 
 * 
 * @author  quickpoint 
 * @version $Id: CodeGenerator.java, v 1.0 2019 Exp $
 */
public interface CodeGenerator {

    /**
     * Translate the source codes into target codes.
     * 
     * @param ast  the AST
     * @param output target codes
     * @throws ParseException thrown when failed to parse.
     */
    void generate(Node ast, StringBuilder output) throws ParseException;
}
