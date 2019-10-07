/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler;

import java.util.List;

import com.vector.supertinycompiler.codegenerator.CodeGenerator;
import com.vector.supertinycompiler.parser.Node;
import com.vector.supertinycompiler.parser.Parser;
import com.vector.supertinycompiler.tokenizer.Token;
import com.vector.supertinycompiler.tokenizer.Tokenizer;
import com.vector.supertinycompiler.transformer.Transformer;

/**
 * A tiny implementation of <code>Compiler</code>.
 * 
 *  we will link together every part of the pipeline.
 *
 *  <pre>
 *   1. input  => tokenizer   => tokens
 *   2. tokens => parser      => ast
 *   3. ast    => transformer => newAst
 *   4. newAst => generator   => output
 *  </pre>
 *   
 * @author  quickpoint 
 * @version $Id: TinyCompiler.java, v 1.0 2019 Exp $
 */
public class TinyCompiler implements Compiler {

    /** 
     *  tokenizer.
     */
    private Tokenizer     tokenizer;

    /**
     * parser.
     */
    private Parser        parser;

    /**
     * transformer.
     */
    private Transformer   transformer;

    /**
     * code generator.
     */
    private CodeGenerator codeGenerator;

    /** 
     * @see com.vector.supertinycompiler.Compiler#compile(java.lang.String)
     */
    public String compile(String input) throws ParseException {

        List<Token> tokens = tokenizer.scan(input);

        Node ast = parser.parse(tokens);

        Node newAst = transformer.transform(ast);

        StringBuilder output = new StringBuilder();
        codeGenerator.generate(newAst, output);

        return output.toString();
    }

    /**
     * Setter method for property <tt>tokenizer</tt>.
     * 
     * @param tokenizer value to be assigned to property tokenizer
     */
    public void setTokenizer(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    /**
     * Setter method for property <tt>parser</tt>.
     * 
     * @param parser value to be assigned to property parser
     */
    public void setParser(Parser parser) {
        this.parser = parser;
    }

    /**
     * Setter method for property <tt>transformer</tt>.
     * 
     * @param transformer value to be assigned to property transformer
     */
    public void setTransformer(Transformer transformer) {
        this.transformer = transformer;
    }

    /**
     * Setter method for property <tt>codeGenerator</tt>.
     * 
     * @param codeGenerator value to be assigned to property codeGenerator
     */
    public void setCodeGenerator(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

}
