/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.traverser;

import com.vector.supertinycompiler.ParseException;
import com.vector.supertinycompiler.parser.Node;

/**
 * <code>Traverser</code> is a class for traversing the AST.
 * 
 * <p>
 * In order to navigate through all of these nodes, we need to be able to
 * traverse through them. This traversal process goes to each node in the AST
 * depth-first. 
 * 
 * @author  quickpoint 
 * @version $Id: Traverser.java, v 1.0 2019 Exp $
 */
public interface Traverser {

    /**
     * Traverse the whole AST with a visitor.
     * 
     * @param ast the AST node
     * @param parent parent node
     * @param visitor visitor
     * @throws ParseException thrown when processing failed.
     */
    void traverse(Node ast, Node parent, Visitor visitor) throws ParseException;
}
