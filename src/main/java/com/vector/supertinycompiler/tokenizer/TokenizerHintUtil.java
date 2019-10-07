/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.tokenizer;

/**
 * Utilities for tokenization.
 * 
 * @author  quickpoint 
 * @version $Id: TokenizerHintUtil.java, v 1.0 2019 Exp $
 */
public class TokenizerHintUtil {

    /**
     * constants definition.
     */
    public static final char LP    = '(';
    public static final char RP    = ')';
    public static final char QUOTE = '\"';

    /**
     * private constructor.
     */
    private TokenizerHintUtil() {
    }

    /**
     * Is the char a whilte space?
     * 
     * @param ch char
     * @return true if yes, false if no
     */
    public static boolean isWhiteSpace(char ch) {
        return Character.isWhitespace(ch);
    }

    /**
     * Is the char a left parenthesis?
     * 
     * @param ch char
     * @return true if yes, false if no
     */
    public static boolean isLeftParenthesis(char ch) {
        return (ch == LP);
    }

    /**
     * Is the char a right parenthesis?
     * 
     * @param ch char
     * @return true if yes, false if no
     */
    public static boolean isRightParentsis(char ch) {
        return (ch == RP);
    }

    /**
     * Is the char a digit?
     * 
     * @param ch char
     * @return true if yes, false if no
     */
    public static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    /**
     * Is the char a quote?
     * 
     * @param ch char
     * @return true if yes, false if no
     */
    public static boolean isQuote(char ch) {
        return (ch == QUOTE);
    }

    /**
     * Is the char a letter?
     * 
     * @param ch char
     * @return true if yes, false if no
     */
    public static boolean isLetter(char ch) {
        return Character.isLetter(ch);
    }

}
