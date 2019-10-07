/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.tokenizer;

import java.util.List;

import com.vector.supertinycompiler.ParseException;

/**
 * Tokenizer.
 * 
 * Lexical Analysis takes the raw code and splits it apart into these things
 * called tokens by a thing called a tokenizer (or lexer).
 * 
 * @author  quickpoint 
 * @version $Id: Tokenizer.java, v 1.0 2019 Exp $
 */
public interface Tokenizer {

    /**
     * Scan the raw code and split into tokens.
     * 
     * @param input raw code inputs
     * @return tokens
     * @throws ParseException thrown when lexical analysis failed.
     */
    List<Token> scan(String input) throws ParseException;
}
