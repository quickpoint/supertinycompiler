/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.tokenizer;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Token.
 * 
 * @author  quickpoint 
 * @version $Id: Token.java, v 1.0 2019 Exp $
 */
public class Token {

    /**
     * constants definition.
     */
    public static final char LP    = '(';
    public static final char RP    = ')';
    public static final char QUOTE = '\"';

    /**
     * token type.
     */
    private TokenType        type;

    /**
     * token value.
     */
    private String           value;

    /**
     * offset in the stream.
     */
    private int              offset;

    /**
     * Construct a token with given type and value.
     * @param type token type
     * @param value token value
     */
    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    /**
     * Construct a token with given type, value and offset.
     * @param type token type
     * @param value token value
     * @param offset offset in the stream
     */
    public Token(TokenType type, String value, int offset) {
        this.type = type;
        this.value = value;
        this.offset = offset;
    }

    /**
     * Getter method for property <tt>type</tt>.
     * 
     * @return property value of type
     */
    public TokenType getType() {
        return type;
    }

    /**
     * Getter method for property <tt>value</tt>.
     * 
     * @return property value of value
     */
    public String getValue() {
        return value;
    }

    /**
     * Getter method for property <tt>offset</tt>.
     * 
     * @return property value of offset
     */
    public int getOffset() {
        return offset;
    }

    /** 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    /** 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Token that = (Token) obj;

        if (type != that.type) {
            return false;
        }

        if (null == value) {
            if (that.value != null) {
                return false;
            }
        } else if (!value.equals(that.value)) {
            return false;
        }

        return true;
    }

    /** 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
