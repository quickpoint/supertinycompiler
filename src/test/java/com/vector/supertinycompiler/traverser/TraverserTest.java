/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.traverser;

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
 * TraverserTest
 * 
 * @author  quickpoint 
 * @version $Id: TraverserTest.java, v 1.0 2019 Exp $
 */
public class TraverserTest extends TestCase {

    private Traverser traverser = new TinyTraverser();

    public void testIt() throws ParseException {
        String input = "(add 2 (subtract 4 2))";

        Tokenizer tokenizer = new ReTinyTokenizer();
        List<Token> tokens = tokenizer.scan(input);

        Parser parser = new ReTinyParser();
        Node ast = parser.parse(tokens);

        traverser.traverse(ast, ast, new DumpVisitor());
    }
}
