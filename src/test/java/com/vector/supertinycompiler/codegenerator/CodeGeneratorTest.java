/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.codegenerator;

import java.util.List;

import com.vector.supertinycompiler.ParseException;
import com.vector.supertinycompiler.parser.Node;
import com.vector.supertinycompiler.parser.Parser;
import com.vector.supertinycompiler.parser.ReTinyParser;
import com.vector.supertinycompiler.tokenizer.ReTinyTokenizer;
import com.vector.supertinycompiler.tokenizer.Token;
import com.vector.supertinycompiler.tokenizer.Tokenizer;
import com.vector.supertinycompiler.transformer.TinyTransformer;
import com.vector.supertinycompiler.transformer.Transformer;

import junit.framework.TestCase;

/**
 * CodeGeneratorTest
 * 
 * @author  quickpoint 
 * @version $Id: CodeGeneratorTest.java, v 1.0 2019 Exp $
 */
public class CodeGeneratorTest extends TestCase {

    private CodeGenerator codeGenerator = new TinyCodeGenerator();

    public void testIt() throws ParseException {
        String input = "(add 2 (subtract 4 2)) (add 6 7)";

        Tokenizer tokenizer = new ReTinyTokenizer();
        List<Token> tokens = tokenizer.scan(input);

        Parser parser = new ReTinyParser();
        Node ast = parser.parse(tokens);

        Transformer transformer = new TinyTransformer();
        Node newAst = transformer.transform(ast);
        
        StringBuilder output = new StringBuilder();
        codeGenerator.generate(newAst, output);

        System.out.println(output.toString());
    }
}
