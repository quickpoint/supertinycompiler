/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.parser;

/**
 * The node for Number.
 * 
 * @author  quickpoint 
 * @version $Id: NumberNode.java, v 1.0 2019 Exp $
 */
public class NumberNode extends BaseNode {

    /**
     * Construct a number node with given value.
     * 
     * @param value value of the node
     */
    public NumberNode(String value) {
        super(NodeType.NUMBER, value);
    }

}
