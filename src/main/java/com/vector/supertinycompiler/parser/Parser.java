/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.parser;

import java.util.List;

import com.vector.supertinycompiler.ParseException;
import com.vector.supertinycompiler.tokenizer.Token;

/**
 *  *Syntactic Analysis* takes the tokens and reformats them into a
 *    representation that describes each part of the syntax and their relation
 *    to one another. This is known as an intermediate representation or
 *    Abstract Syntax Tree.
 *
 *    An Abstract Syntax Tree, or AST for short, is a deeply nested object that
 *    represents code in a way that is both easy to work with and tells us a lot
 *    of information.
 * 
 * @author  quickpoint 
 * @version $Id: Parser.java, v 1.0 2019 Exp $
 */
public interface Parser {

    /**
     * Parse.
     * 
     * @param tokens input tokens
     * @return the root Node of AST
     * @throws ParseException thrown when failed to parse
     */
    Node parse(List<Token> tokens) throws ParseException;
}
