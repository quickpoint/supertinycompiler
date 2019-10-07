/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.parser;

import java.util.List;

import com.vector.supertinycompiler.ParseException;
import com.vector.supertinycompiler.tokenizer.ReTinyTokenizer;
import com.vector.supertinycompiler.tokenizer.Token;
import com.vector.supertinycompiler.tokenizer.Tokenizer;

import junit.framework.TestCase;

/**
 * ParserTest
 * 
 * @author  quickpoint 
 * @version $Id: ParserTest.java, v 1.0 2019 Exp $
 */
public class ParserTest extends TestCase {

    private Parser parser = new ReTinyParser();

    public void testParse() throws ParseException {
        String input = " (add 2 (subtract 4 2)) (add 23 43)";

        Tokenizer tokenizer = new ReTinyTokenizer();
        List<Token> tokens = tokenizer.scan(input);

        Node node = parser.parse(tokens);
        System.out.println(node);
    }
}
