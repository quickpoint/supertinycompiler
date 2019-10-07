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
 * <p> This is the revised version.
 * 
 * @author  quickpoint 
 * @version $Id: ReTinyParser.java, v 1.0 2019 Exp $
 */
public class ReTinyParser implements Parser {

    /** 
     * @see com.vector.supertinycompiler.parser.Parser#parse(java.util.List)
     */
    public Node parse(List<Token> tokens) throws ParseException {

        TokenForwardScanner scanner = new TokenForwardScanner(tokens);

        ProgramNode ast = new ProgramNode();
        while (scanner.hasNext()) {
            ast.push(walk(scanner));
        }

        return ast;
    }

    /**
     * Walk along the token array and do the parsing.
     * @param scanner token scanner
     * @return AST 
     * @throws ParseException thrown when failed to parse
     */
    private Node walk(TokenForwardScanner scanner) throws ParseException {

        Token token = scanner.current();

        if (TokenType.NUMBER == token.getType()) {
            scanner.indexNext();
            return new NumberNode(token.getValue());
        }

        if (TokenType.STRING == token.getType()) {
            scanner.indexNext();
            return new StringNode(token.getValue());
        }

        if (TokenType.LPAREN == token.getType()) {
            token = scanner.next();

            CallExprNode expr = new CallExprNode(token.getValue());

            token = scanner.next();

            while (TokenType.RPAREN != token.getType()) {
                expr.pushParam(walk(scanner));
                token = scanner.current();
            }

            scanner.indexNext();
            return expr;
        }

        throw new ParseException("we don't recognize the type:" + token.getType());
    }

    /**
     * Instance of <code>TokenForwardScanner</code> is a wrapper for tokens cache, with a pointer.
     */
    private static class TokenForwardScanner {

        /** current position */
        private int         current;

        /** token array length */
        private int         len;

        /** token array */
        private List<Token> tokens;

        /**
         * Construct a <code>TokenForwardScanner</code> with given token array.
         * 
         * @param tokens token array
         */
        public TokenForwardScanner(List<Token> tokens) {
            this.current = 0;
            this.len = tokens.size();
            this.tokens = tokens;
        }

        /**
         * Move pointer forward.
         */
        public void indexNext() {
            current++;
        }

        /**
         * Get token in the current pointer position.
         *  
         * @return token
         * @throws ParseException thrown when the boundary exceeds.
         */
        public Token current() throws ParseException {
            check();

            return tokens.get(current);
        }

        /**
         * Forward and get token in the pointer position.
         * 
         * @return token
         * @throws ParseException thrown when the boundary exceeds.
         */
        public Token next() throws ParseException {
            current++;

            check();

            return tokens.get(current);
        }

        /**
         * Check if there are more tokens in the token array 
         * 
         * @return true if yes, false if no
         */
        public boolean hasNext() {
            return (current < len);
        }

        /**
         * Check if the boundary exceeds.
         * @throws ParseException thrown when the boundary exceeds
         */
        private void check() throws ParseException {
            if (current >= len) {
                throw new ParseException("parse length overflow, cur:" + current + ", len:" + len);
            }
        }
    }
}
