/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler;

import com.vector.supertinycompiler.codegenerator.TinyCodeGenerator;
import com.vector.supertinycompiler.parser.ReTinyParser;
import com.vector.supertinycompiler.tokenizer.ReTinyTokenizer;
import com.vector.supertinycompiler.transformer.TinyTransformer;

import junit.framework.TestCase;

/**
 * CompilerTest
 * 
 * @author  quickpoint 
 * @version $Id: CompilerTest.java, v 1.0 2019 Exp $
 */
public class CompilerTest extends TestCase {

    private TinyCompiler compiler;

    /** 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        compiler = new TinyCompiler();
        compiler.setTokenizer(new ReTinyTokenizer());
        compiler.setParser(new ReTinyParser());
        compiler.setTransformer(new TinyTransformer());
        compiler.setCodeGenerator(new TinyCodeGenerator());
    }

    public void testIt() throws ParseException {

        String input = "(add 2 (subtract 4 2))";

        String output = compiler.compile(input);

        System.out.println(output);
    }
}
