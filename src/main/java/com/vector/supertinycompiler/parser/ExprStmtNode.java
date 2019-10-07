/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.parser;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The node for Expression Statement.
 * 
 * <p> The structure of the node is as follows:
 * 
 * <pre>
 *          ExprStmtNode
 *                 |
 *           expr(Expression)      
 * </pre>
 * 
 * @author  quickpoint 
 * @version $Id: ExprStmtNode.java, v 1.0 2019 Exp $
 */
public class ExprStmtNode extends BaseNode {

    /** expression */
    private Node expr;

    /**
     * Construct a <code>ExprStmtNode</code> with given expression.
     * 
     * @param node given expression
     */
    public ExprStmtNode(Node node) {
        super(NodeType.EXPR_STMT, "");
        this.expr = node;
    }

    /**
     * Get the expression.
     * 
     * @return expression
     */
    public Node getExpression() {
        return expr;
    }

    /** 
     * @see com.vector.supertinycompiler.parser.BaseNode#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
