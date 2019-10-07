/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.tokenizer;

import java.util.List;

import com.vector.supertinycompiler.ParseException;

import junit.framework.TestCase;

/**
 * ParserTest
 * 
 * @author  quickpoint 
 * @version $Id: TokenizerTest.java, v 1.0 2019 Exp $
 */
public class TokenizerTest extends TestCase {

    private Tokenizer tokenizer = new ReTinyTokenizer();

    public void testScan() throws ParseException {
        String input = "(add 2 (subtract 4 2)) (add 6 7) ";

        List<Token> tokens = tokenizer.scan(input);
        for (Token each : tokens) {
            System.out.println(each);
        }
    }
}
