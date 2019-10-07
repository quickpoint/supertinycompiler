/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.transformer;

import java.util.List;

import com.vector.supertinycompiler.ParseException;
import com.vector.supertinycompiler.parser.Node;
import com.vector.supertinycompiler.parser.Parser;
import com.vector.supertinycompiler.parser.ReTinyParser;
import com.vector.supertinycompiler.tokenizer.ReTinyTokenizer;
import com.vector.supertinycompiler.tokenizer.Token;
import com.vector.supertinycompiler.tokenizer.Tokenizer;

import junit.framework.TestCase;

/**
 * ParserTest
 * 
 * @author  quickpoint 
 * @version $Id: TransformerTest.java, v 1.0 2019 Exp $
 */
public class TransformerTest extends TestCase {

    private Transformer transformer = new TinyTransformer();

    public void testIt() throws ParseException {

        String input = "(add 2 (subtract 4 2)) (add 6 7)";

        Tokenizer tokenizer = new ReTinyTokenizer();
        List<Token> tokens = tokenizer.scan(input);

        Parser parser = new ReTinyParser();
        Node ast = parser.parse(tokens);

        Node newAst = transformer.transform(ast);

        System.out.println(newAst);

    }
}
