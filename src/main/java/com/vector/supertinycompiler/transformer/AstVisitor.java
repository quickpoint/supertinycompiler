/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.transformer;

import com.vector.supertinycompiler.ParseException;
import com.vector.supertinycompiler.parser.CallExprNewNode;
import com.vector.supertinycompiler.parser.CallExprNode;
import com.vector.supertinycompiler.parser.ExprStmtNode;
import com.vector.supertinycompiler.parser.Node;
import com.vector.supertinycompiler.parser.NodeType;
import com.vector.supertinycompiler.parser.NumberNode;
import com.vector.supertinycompiler.parser.ProgramNode;
import com.vector.supertinycompiler.parser.StringNode;
import com.vector.supertinycompiler.traverser.Visitor;

/**
 * An implementation of <code>Visitor</code>.
 * 
 * @author  quickpoint 
 * @version $Id: AstVisitor.java, v 1.0 2019 Exp $
 */
public class AstVisitor implements Visitor {

    /** 
     * @see com.vector.supertinycompiler.traverser.Visitor#enter(com.vector.supertinycompiler.parser.Node, Node)
     */
    public boolean enter(Node ast, Node parent) throws ParseException {

        if (NodeType.PROGRAM == ast.getType()) {
            enter((ProgramNode) ast, parent);
        }

        if (NodeType.NUMBER == ast.getType()) {
            enter((NumberNode) ast, parent);
        }

        if (NodeType.STRING == ast.getType()) {
            enter((StringNode) ast, parent);
        }

        if (NodeType.CALL == ast.getType()) {
            enter((CallExprNode) ast, parent);
        }

        return true;
    }

    /** 
     * @see com.vector.supertinycompiler.traverser.Visitor#exit(com.vector.supertinycompiler.parser.Node, Node)
     */
    public boolean exit(Node ast, Node parent) throws ParseException {

        return true;
    }

    public boolean enter(ProgramNode node, Node parent) throws ParseException {

        return true;
    }

    public boolean enter(NumberNode node, Node parent) {

        parent.pushContext(node);

        return true;
    }

    public boolean enter(StringNode node, Node parent) {

        parent.pushContext(node);

        return true;
    }

    public boolean enter(CallExprNode node, Node parent) throws ParseException {

        Node expression = new CallExprNewNode(node.getName());

        for (Node each : node.getParams()) {
            enter(each, node);
        }

        for (Node each : node.getContext()) {
            ((CallExprNewNode) expression).pushArgument(each);
        }

        if (NodeType.CALL != parent.getType()) {
            expression = new ExprStmtNode(expression);
        }

        parent.pushContext(expression);

        return true;
    }
}
