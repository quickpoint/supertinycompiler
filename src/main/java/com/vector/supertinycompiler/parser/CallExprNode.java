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
 * <code>CallExprNode</code> is a node for call expression.
 * 
 * <p> The structure of the node is as follows:
 * 
 * <pre>
 *          CallExprNode  (name)
 *                 |
 *              Param1(Node) - Param2(Node) - Param3(Node)
 * 
 * </pre>
 * 
 * @author  quickpoint 
 * @version $Id: CallExprNode.java, v 1.0 2019 Exp $
 */
public class CallExprNode extends BaseNode {

    private List<Node> params;

    /**
     * Construct a <code>CallExprNode</code> with given name.
     * 
     * @param name given name
     */
    public CallExprNode(String name) {
        super(NodeType.CALL, name);
    }

    /**
     * Get name of the node.
     * 
     * @return name of the node.
     */
    public String getName() {
        return getValue();
    }

    /**
     * Push node into params.
     * 
     * @param node node
     */
    public void pushParam(Node node) {
        if (null == params) {
            params = new ArrayList<Node>();
        }

        params.add(node);
        node.setParent(this);
    }

    /**
     * Get params.
     * 
     * @return params.
     */
    public List<Node> getParams() {
        return params;
    }

    /** 
     * @see com.vector.supertinycompiler.parser.BaseNode#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
