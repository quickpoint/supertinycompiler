/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.traverser;

import java.util.List;

import com.vector.supertinycompiler.ParseException;
import com.vector.supertinycompiler.parser.CallExprNode;
import com.vector.supertinycompiler.parser.Node;
import com.vector.supertinycompiler.parser.ProgramNode;

/**
 * A tiny implementation of <code>Traverser</code>.
 * 
 * @author  quickpoint 
 * @version $Id: TinyTraverser.java, v 1.0 2019 Exp $
 */
public class TinyTraverser implements Traverser {

    /** 
     * @see com.vector.supertinycompiler.traverser.Traverser#traverse(com.vector.supertinycompiler.parser.Node, com.vector.supertinycompiler.parser.Node, com.vector.supertinycompiler.traverser.Visitor)
     */
    public void traverse(Node ast, Node parent, Visitor visitor) throws ParseException {

        visitor.enter(ast, parent);

        switch (ast.getType()) {
            case PROGRAM:
                ProgramNode node = (ProgramNode) ast;
                traverseArray(node.getBody(), parent, visitor);
                break;

            case CALL:
                CallExprNode expr = (CallExprNode) ast;
                traverseArray(expr.getParams(), parent, visitor);
                break;

            case STRING:
                break;

            case NUMBER:
                break;

            default:
                throw new ParseException("type error:" + ast.getType());
        }

        visitor.exit(ast, parent);
    }

    /**
     * Traverse an array of nodes.
     * 
     * @param nodes an array of nodes
     * @param parent parent node
     * @param visitor visitor
     * @throws ParseException thrown when failed during traversing.
     */
    private void traverseArray(List<Node> nodes, Node parent,
                               Visitor visitor) throws ParseException {
        if (null != nodes) {
            for (Node each : nodes) {
                traverse(each, parent, visitor);
            }
        }
    }

}
