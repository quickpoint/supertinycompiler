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
 * <p> This is original version.  
 * @see ReTinyTokenizer
 * 
 * @author  quickpoint 
 * @version $Id: TinyTokenizer.java, v 1.0 2019 Exp $
 */
public class TinyTokenizer implements Tokenizer {

    /** 
     * @see com.vector.supertinycompiler.tokenizer.Tokenizer#scan(java.lang.String)
     */
    public List<Token> scan(String input) throws ParseException {

        if (StringUtils.isBlank(input)) {
            return Collections.emptyList();
        }

        int current = 0;
        int len = input.length();
        List<Token> tokens = new ArrayList<Token>();

        while (current < len) {
            char pos = input.charAt(current);

            if (Character.isWhitespace(pos)) {
                current++;
                continue;
            }

            if (pos == '(') {
                tokens.add(new Token(TokenType.LPAREN, String.valueOf(pos)));
                current++;
                continue;
            }

            if (pos == ')') {
                tokens.add(new Token(TokenType.RPAREN, String.valueOf(pos)));
                current++;
                continue;
            }

            if (Character.isDigit(pos)) {
                StringBuilder value = new StringBuilder();
                while (Character.isDigit(pos)) {
                    value.append(pos);
                    pos = input.charAt(++current);
                }

                tokens.add(new Token(TokenType.NUMBER, value.toString()));

                continue;
            }

            if (pos == '\"') {
                StringBuilder value = new StringBuilder();

                pos = input.charAt(++current);

                while (pos != '\"') {
                    value.append(pos);
                    pos = input.charAt(++current);
                }

                ++current;

                tokens.add(new Token(TokenType.STRING, value.toString()));

                continue;
            }

            if (Character.isLetter(pos)) {
                StringBuilder value = new StringBuilder();

                while (Character.isLetter(pos)) {
                    value.append(pos);
                    pos = input.charAt(++current);
                }

                tokens.add(new Token(TokenType.NAME, value.toString()));

                continue;
            }

            throw new ParseException("I dont know what this character is: " + pos);
        }

        return tokens;
    }
    
}
