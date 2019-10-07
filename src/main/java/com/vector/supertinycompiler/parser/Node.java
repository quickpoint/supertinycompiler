/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.parser;

import java.util.List;

/**
 * The Ast Node.
 * 
 * @author  quickpoint 
 * @version $Id: Node.java, v 1.0 2019 Exp $
 */
public interface Node {

    /**
     * Get node type.
     * 
     * @return node type
     */
    NodeType getType();

    /**
     * Get node value.
     * @return node value
     */
    String getValue();

    /**
     * Put visited node into context.
     * 
     * @param node visited node
     */
    void pushContext(Node node);

    /**
     * Get context of the node.
     * 
     * @return context of the node
     */
    List<Node> getContext();

    /**
     * Set parent node.
     * 
     * @param parent parent node
     */
    void setParent(Node parent);

    /**
     * Get parent node of the node.
     * 
     * @return parent node of the node
     */
    Node getParent();

}
