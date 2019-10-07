/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.tokenizer;

/**
 * TokenType.
 * 
 * @author  quickpoint 
 * @version $Id: TokenType.java, v 1.0 2019 Exp $
 */
public enum TokenType {

                       UT("Unknown Type"),

                       LPAREN("left-parenthesis"),

                       RPAREN("right-parenthesis"),

                       STRING("string"),

                       NAME("name"),

                       NUMBER("number"),

                       PROGRAM("program"),

    ;

    /**
     * Description of the token type.
     */
    private String message;

    /**
     * Construct a token type.
     * 
     * @param message description of the token type
     */
    TokenType(String message) {
        this.message = message;
    }

    /**
     * Get description of the token type.
     * @return description of the token type
     */
    public String getMessage() {
        return message;
    }
}
