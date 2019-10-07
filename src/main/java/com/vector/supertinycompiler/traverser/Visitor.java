/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.traverser;

import com.vector.supertinycompiler.ParseException;
import com.vector.supertinycompiler.parser.Node;

/**
 * Visitors
 *
 *<p>
 * The basic idea here is that we are going to create a “visitor” object that
 * has methods that will accept different node types.
 *
 *<pre>
 *   visitor = {
 *     NumberLiteral() {},
 *     CallExpression() {},
 *   };
 *</pre>
 *
 *<p>
 * When we traverse our AST, we will call the methods on this visitor whenever we
 * "enter" a node of a matching type.
 *
 *<p>
 * In order to make this useful we will also pass the node and a reference to
 * the parent node.
 *
 *<pre>
 *   visitor = {
 *     NumberLiteral(node, parent) {},
 *     CallExpression(node, parent) {},
 *   };
 * </pre>
 * 
 * @author  quickpoint 
 * @version $Id: Visitor.java, v 1.0 2019 Exp $
 */
public interface Visitor {

    /**
     * Start to visit the AST node.
     * 
     * @param node the AST node
     * @param parent parent node
     * @return true if success, false if failed
     * @throws ParseException thrown when failed to start.
     */
    boolean enter(Node node, Node parent) throws ParseException;

    /**
     * End to visit the AST node.
     * 
     * @param node the AST node
     * @param parent parent node
     * @return true if success, false if failed
     * @throws ParseException thrown when failed to end.
     */
    boolean exit(Node node, Node parent) throws ParseException;
}
