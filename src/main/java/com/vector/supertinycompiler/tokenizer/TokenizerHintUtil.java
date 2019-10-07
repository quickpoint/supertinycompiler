/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.tokenizer;

/**
 * 
 * @author  quickpoint 
 * @version $Id: TokenizerHintUtil.java, v 1.0 2019 Exp $
 */
public class TokenizerHintUtil {

    private TokenizerHintUtil() {
    }

    public static boolean isWhiteSpace(char ch) {
        return Character.isWhitespace(ch);
    }

    public static boolean isLeftParentsis(char ch) {
        return (ch == Token.LP);
    }

    public static boolean isRightParentsis(char ch) {
        return (ch == Token.RP);
    }

    public static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    public static boolean isQuote(char ch) {
        return (ch == Token.QUOTE);
    }

    public static boolean isLetter(char ch) {
        return Character.isLetter(ch);
    }

}
