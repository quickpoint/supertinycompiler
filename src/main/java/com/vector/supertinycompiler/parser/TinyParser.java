/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.parser;

import java.util.List;

import com.vector.supertinycompiler.ParseException;
import com.vector.supertinycompiler.tokenizer.Token;
import com.vector.supertinycompiler.tokenizer.TokenType;

/**
 * A tiny implementation of <code>Parser</code>.
 * 
 * <p> This is the original version.
 * 
 * @author  quickpoint 
 * @version $Id: TinyParser.java, v 1.0 2019 Exp $
 */
public class TinyParser implements Parser {

    private int current = 0;

    /** 
     * @see com.vector.supertinycompiler.parser.Parser#parse(java.util.List)
     */
    public Node parse(List<Token> tokens) throws ParseException {

        current = 0;

        ProgramNode ast = new ProgramNode();

        while (current < tokens.size()) {
            ast.push(walk(tokens));
        }

        return ast;
    }

    /**
     * Walk along the token array and do the parsing.
     * @param tokens token array
     * @return AST 
     * @throws ParseException thrown when failed to parse
     */
    private Node walk(List<Token> tokens) throws ParseException {

        Token token = tokens.get(current);

        if (TokenType.NUMBER == token.getType()) {
            current++;
            return new NumberNode(token.getValue());
        }

        if (TokenType.STRING == token.getType()) {
            current++;
            return new StringNode(token.getValue());
        }

        if (TokenType.LPAREN == token.getType()) {
            token = tokens.get(++current);

            CallExprNode expr = new CallExprNode(token.getValue());

            token = tokens.get(++current);

            while (TokenType.RPAREN != token.getType()) {
                expr.pushParam(walk(tokens));
                token = tokens.get(current);
            }

            current++;
            return expr;
        }

        throw new ParseException("we don't recognize the type:" + token.getType());
    }
}
