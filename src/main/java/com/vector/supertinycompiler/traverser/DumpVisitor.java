/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.traverser;

import com.vector.supertinycompiler.ParseException;
import com.vector.supertinycompiler.parser.CallExprNode;
import com.vector.supertinycompiler.parser.Node;
import com.vector.supertinycompiler.parser.NodeType;
import com.vector.supertinycompiler.parser.NumberNode;
import com.vector.supertinycompiler.parser.ProgramNode;
import com.vector.supertinycompiler.parser.StringNode;

/**
 * A default visitor implementation.
 * 
 * <p>
 * It just dumps the content of the node it encounters during traversing.
 * 
 * <p>
 *  As we traverse down, we're going to reach branches with dead ends. As we
 * finish each branch of the tree we "exit" it. So going down the tree we
 * "enter" each node, and going back up we "exit".
 *
 *  <pre>
 *   -> Program (enter)
 *     -> CallExpression (enter)
 *       -> Number Literal (enter)
 *       <- Number Literal (exit)
 *       -> Call Expression (enter)
 *          -> Number Literal (enter)
 *          <- Number Literal (exit)
 *          -> Number Literal (enter)
 *          <- Number Literal (exit)
 *       <- CallExpression (exit)
 *     <- CallExpression (exit)
 *   <- Program (exit)
 *  </pre>
 *  
 * @author  quickpoint 
 * @version $Id: DumpVisitor.java, v 1.0 2019 Exp $
 */
public class DumpVisitor implements Visitor {

    /** 
     * @see com.vector.supertinycompiler.traverser.Visitor#enter(com.vector.supertinycompiler.parser.Node, Node)
     */
    public boolean enter(Node ast, Node parent) throws ParseException {

        if (NodeType.PROGRAM == ast.getType()) {
            enter((ProgramNode) ast);
        }

        if (NodeType.NUMBER == ast.getType()) {
            enter((NumberNode) ast);
        }

        if (NodeType.STRING == ast.getType()) {
            enter((StringNode) ast);
        }

        if (NodeType.CALL == ast.getType()) {
            enter((CallExprNode) ast);
        }

        return true;
    }

    /** 
     * @see com.vector.supertinycompiler.traverser.Visitor#exit(com.vector.supertinycompiler.parser.Node, Node)
     */
    public boolean exit(Node ast, Node parent) throws ParseException {

        if (NodeType.PROGRAM == ast.getType()) {
            exit((ProgramNode) ast);
        }

        if (NodeType.NUMBER == ast.getType()) {
            exit((NumberNode) ast);
        }

        if (NodeType.STRING == ast.getType()) {
            exit((StringNode) ast);
        }

        if (NodeType.CALL == ast.getType()) {
            exit((CallExprNode) ast);
        }

        return true;
    }

    public boolean enter(ProgramNode node) {

        System.out.println("Program " + node.getValue() + " Enter");

        return true;
    }

    public boolean enter(NumberNode node) {

        System.out.println("NumberNode " + node.getValue() + " Enter");

        return true;
    }

    public boolean enter(StringNode node) {

        System.out.println("StringNode " + node.getValue() + " Enter");

        return true;
    }

    public boolean enter(CallExprNode node) {

        System.out.println("CallNode " + node.getName() + " Enter");

        return true;
    }

    public boolean exit(ProgramNode node) {

        System.out.println("Program " + node.getValue() + " Exit");

        return true;
    }

    public boolean exit(NumberNode node) {

        System.out.println("NumberNode " + node.getValue() + " Exit");

        return true;
    }

    public boolean exit(StringNode node) {

        System.out.println("StringNode " + node.getValue() + " Exit");

        return true;
    }

    public boolean exit(CallExprNode node) {

        System.out.println("CallNode " + node.getName() + " Exit");

        return true;
    }

}
