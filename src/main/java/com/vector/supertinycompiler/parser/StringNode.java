/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.parser;

/**
 * The node for String.
 * 
 * @author  quickpoint 
 * @version $Id: StringNode.java, v 1.0 2019 Exp $
 */
public class StringNode extends BaseNode {

    /**
     * Construct a <code>StringNode</code> with given value.
     * 
     * @param value given value
     */
    public StringNode(String value) {
        super(NodeType.STRING, value);
    }

}
