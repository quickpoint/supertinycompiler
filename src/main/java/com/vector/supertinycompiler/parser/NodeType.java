/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.parser;

/**
 * NodeType.
 * 
 * @author  quickpoint 
 * @version $Id: NodeType.java, v 1.0 2019 Exp $
 */
public enum NodeType {

                      NUMBER("NumberLiteral"),

                      STRING("StringLiteral"),

                      CALL("CallExpression"),

                      CALL_NEW("CallExpression_New"),

                      EXPR_STMT("ExpressionStatement"),

                      IDENTIFIER("Identifier"),

                      PROGRAM("Program"),

    ;

    /** Description of the node type. */
    private String message;

    /**
     * Construct a <code></code> with given description.
     * 
     * @param message given description
     */
    NodeType(String message) {
        this.message = message;
    }

    /**
     * Get the description of the node type.
     * 
     * @return the description of the node type.
     */
    public String getMessage() {
        return message;
    }
}
