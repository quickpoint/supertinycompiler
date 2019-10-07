/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.tokenizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.vector.supertinycompiler.ParseException;

/**
 * A tiny implementation of <code>Tokenizer</code>.
 * 
 * <p> This is the revised version.
 * 
 * @author  quickpoint 
 * @version $Id: ReTinyTokenizer.java, v 1.0 2019 Exp $
 */
public class ReTinyTokenizer implements Tokenizer {

    /** 
     * @see com.vector.supertinycompiler.tokenizer.Tokenizer#scan(java.lang.String)
     */
    public List<Token> scan(String input) throws ParseException {

        if (StringUtils.isBlank(input)) {
            return Collections.emptyList();
        }

        List<Token> tokens = new ArrayList<Token>();
        CharForwardScanner scanner = new CharForwardScanner(input);

        while (scanner.hasNext()) {
            char pos = scanner.current();

            if (TokenizerHintUtil.isWhiteSpace(pos)) {
                scanner.indexNext();
                continue;
            }

            if (TokenizerHintUtil.isLeftParentsis(pos)) {
                tokens.add(new Token(TokenType.LPAREN, String.valueOf(pos), pos));
                scanner.indexNext();
                continue;
            }

            if (TokenizerHintUtil.isRightParentsis(pos)) {
                tokens.add(new Token(TokenType.RPAREN, String.valueOf(pos), pos));
                scanner.indexNext();
                continue;
            }

            if (TokenizerHintUtil.isDigit(pos)) {
                scanner.markPos();
                StringBuilder value = new StringBuilder();
                while (TokenizerHintUtil.isDigit(pos)) {
                    value.append(pos);
                    pos = scanner.next();
                }

                tokens.add(new Token(TokenType.NUMBER, value.toString(), scanner.pos()));
                continue;
            }

            if (TokenizerHintUtil.isQuote(pos)) {
                scanner.markPos();

                StringBuilder value = new StringBuilder();
                pos = scanner.next();

                while (!TokenizerHintUtil.isQuote(pos)) {
                    value.append(pos);
                    pos = scanner.next();
                }

                scanner.indexNext();

                tokens.add(new Token(TokenType.STRING, value.toString(), scanner.pos()));

                continue;
            }

            if (TokenizerHintUtil.isLetter(pos)) {
                scanner.markPos();
                StringBuilder value = new StringBuilder();

                while (TokenizerHintUtil.isLetter(pos)) {
                    value.append(pos);
                    pos = scanner.next();
                }

                tokens.add(new Token(TokenType.NAME, value.toString(), scanner.pos()));

                continue;
            }

            throw new ParseException("I dont know what this character is: " + pos);
        }

        return tokens;
    }

    /**
     * Instance of <code>CharForwardScanner</code> is a wrapper of codes cache, with a pointer.
     */
    private static class CharForwardScanner {

        /** current position */
        private int    current;

        /** codes length */
        private int    len;

        /** codes string */
        private String input;

        /** start offset position */
        private int    pos;

        /**
         * Construct a <code>CharForwardScanner</code> with codes string.
         * 
         * @param input codes string
         */
        public CharForwardScanner(String input) {
            this.current = 0;
            this.input = input;
            this.len = input.length();
        }

        /**
         * Mark start offset position
         * @see #pos()
         */
        public void markPos() {
            this.pos = current;
        }

        /**
         * Get start offset position
         * @return start offset position last marked
         * @see #markPos()
         */
        public int pos() {
            return pos;
        }

        /**
         * Move pointer forward.
         */
        public void indexNext() {
            current++;
        }

        /**
         * Get char in the current pointer position.
         *  
         * @return char
         * @throws ParseException thrown when the boundary of the whole string is overflow.
         */
        public char current() throws ParseException {

            check();

            return input.charAt(current);
        }

        /**
         * Forward and get char in the pointer position.
         * 
         * @return char
         * @throws ParseException thrown when the boundary of the whole string is overflow.
         */
        public char next() throws ParseException {

            current++;

            check();

            return input.charAt(current);
        }

        /**
         * Check if there are more chars in the input array 
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
