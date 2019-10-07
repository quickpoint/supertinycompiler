/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.parser;

/**
 * The Node for Identifier.
 * 
 * @author  quickpoint 
 * @version $Id: IdentifierNode.java, v 1.0 2019 Exp $
 */
public class IdentifierNode extends BaseNode {

    /**
     * Name of the identifier.
     */
    private String name;

    /**
     * Construct an IndentifierNode with given name.
     * 
     * @param name name of the identifier
     */
    public IdentifierNode(String name) {
        super(NodeType.IDENTIFIER, name);
        this.name = name;
    }

    /**
     * Get the name of the identifier.
     * 
     * @return name of the identifier
     */
    public String getName() {
        return name;
    }
}
