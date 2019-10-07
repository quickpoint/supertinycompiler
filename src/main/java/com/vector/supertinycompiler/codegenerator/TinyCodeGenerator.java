/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.codegenerator;

import com.vector.supertinycompiler.ParseException;
import com.vector.supertinycompiler.parser.CallExprNewNode;
import com.vector.supertinycompiler.parser.CallExprNode;
import com.vector.supertinycompiler.parser.ExprStmtNode;
import com.vector.supertinycompiler.parser.IdentifierNode;
import com.vector.supertinycompiler.parser.Node;
import com.vector.supertinycompiler.parser.NumberNode;
import com.vector.supertinycompiler.parser.ProgramNode;
import com.vector.supertinycompiler.parser.StringNode;

/**
 * A tiny implementation of <code>CodeGenerator</code>.
 * 
 * @author  quickpoint 
 * @version $Id: TinyCodeGenerator.java, v 1.0 2019 Exp $
 */
public class TinyCodeGenerator implements CodeGenerator {

    /** 
     * @see com.vector.supertinycompiler.codegenerator.CodeGenerator#generate(com.vector.supertinycompiler.parser.Node, java.lang.StringBuilder)
     */
    public void generate(Node ast, StringBuilder sb) throws ParseException {
        switch (ast.getType()) {
            case PROGRAM:
                ProgramNode program = (ProgramNode) ast;

                for (Node each : program.getBody()) {
                    generate(each, sb);
                    sb.append("\n");
                }
                break;

            case EXPR_STMT:
                ExprStmtNode stmt = (ExprStmtNode) ast;
                generate(stmt.getExpression(), sb);
                sb.append(";");
                break;

            case CALL_NEW:
                CallExprNewNode expr = (CallExprNewNode) ast;
                generate(expr.getCallee(), sb);
                sb.append("(");
                for (Node each : expr.getArguments()) {
                    generate(each, sb);
                    sb.append(",");
                }
                sb.append(")");
                break;

            case CALL:
                CallExprNode call = (CallExprNode) ast;
                sb.append(call.getName());
                sb.append("(");
                for (Node each : call.getParams()) {
                    generate(each, sb);
                    sb.append(",");
                }
                sb.append(")");
                break;

            case IDENTIFIER:
                IdentifierNode identifier = (IdentifierNode) ast;
                sb.append(identifier.getName());
                break;

            case NUMBER:
                NumberNode number = (NumberNode) ast;
                sb.append(number.getValue());
                break;

            case STRING:
                StringNode str = (StringNode) ast;
                sb.append("\"").append(str.getValue()).append("\"");
                break;

            default:
                throw new ParseException("we don't know the type: " + ast.getType());
        }

    }

}
