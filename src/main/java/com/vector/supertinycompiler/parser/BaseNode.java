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
 * The default base AST Node.
 * 
 * @author  quickpoint 
 * @version $Id: BaseNode.java, v 1.0 2019 Exp $
 */
public class BaseNode implements Node {

    /** Node type. */
    private NodeType   type;

    /** Node value. */
    private String     value;

    /** Node context. */
    private List<Node> context;

    /** parent Node. */
    private Node       parent;

    /**
     * Construct a <code>BaseNode</code> with given type and value.
     * 
     * @param type given type
     * @param value given value
     */
    public BaseNode(NodeType type, String value) {
        this.type = type;
        this.value = value;
    }

    /** 
     * @see com.vector.supertinycompiler.parser.Node#getType()
     */
    public NodeType getType() {
        return type;
    }

    /** 
     * @see com.vector.supertinycompiler.parser.Node#getValue()
     */
    public String getValue() {
        return value;
    }

    /** 
     * @see com.vector.supertinycompiler.parser.Node#pushContext(com.vector.supertinycompiler.parser.Node)
     */
    public void pushContext(Node node) {
        if (null == context) {
            context = new ArrayList<Node>();
        }

        context.add(node);
    }

    /** 
     * @see com.vector.supertinycompiler.parser.Node#getContext()
     */
    public List<Node> getContext() {
        return context;
    }

    /** 
     * @see com.vector.supertinycompiler.parser.Node#setParent(com.vector.supertinycompiler.parser.Node)
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /** 
     * @see com.vector.supertinycompiler.parser.Node#getParent()
     */
    public Node getParent() {
        return parent;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
