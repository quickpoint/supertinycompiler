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
 * <code>CallExprNewNode</code> is a node for call expression.
 * 
 * <p> The structure of the node is as follows:
 * 
 * <pre>
 *          CallExprNewNode
 *               |
 *          Callee(An Identifier)  - Argument1(Node) - Argument2(Node) - Argument3(Node)     
 * 
 * </pre>
 * 
 * @author  quickpoint 
 * @version $Id: CallExprNewNode.java, v 1.0 2019 Exp $
 */
public class CallExprNewNode extends BaseNode {

    /** callee  */
    private Node       callee;

    /** call arguments */
    private List<Node> arguments;

    /**
     * Construct a <code>CallExprNewNode</code> with given name.
     * 
     * @param name callee function name
     */
    public CallExprNewNode(String name) {

        super(NodeType.CALL_NEW, name);

        callee = new IdentifierNode(name);
    }

    /**
     * Add argument node to the expression.
     * 
     * @param node the argument node
     */
    public void pushArgument(Node node) {

        if (null == arguments) {
            arguments = new ArrayList<Node>();
        }

        arguments.add(node);
    }

    public Node getCallee() {
        return callee;
    }

    public List<Node> getArguments() {
        return arguments;
    }

    /** 
     * @see com.vector.supertinycompiler.parser.BaseNode#toString()
     */
    @Override
    public String toString() {
       return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
