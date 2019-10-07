/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.parser;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * <code>ProgramNode</code> is a node for program. 
 * 
 * <p> This node is generally denoted as the root of the codes.
 * The structure of the node as follows:
 * 
 * <pre>
 *        ProgramNode
 *            |
 *         body array  
 * </pre>
 * 
 * @author  quickpoint 
 * @version $Id: ProgramNode.java, v 1.0 2019 Exp $
 */
public class ProgramNode extends BaseNode {

    /**
     * body of the program
     */
    private List<Node> body;

    /**
     * Construct a program node.
     */
    public ProgramNode() {
        super(NodeType.PROGRAM, "");
    }

    /**
     * Push a node to the body.
     * @param node node
     */
    public void push(Node node) {
        if (null == body) {
            body = new ArrayList<Node>();
        }

        body.add(node);
        node.setParent(this);
    }

    /**
     * Get the body of the program.
     * 
     * @return body of the program
     */
    public List<Node> getBody() {
        return body;
    }

    /** 
     * @see com.vector.supertinycompiler.parser.BaseNode#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
