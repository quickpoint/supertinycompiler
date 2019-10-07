/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.transformer;

import com.vector.supertinycompiler.ParseException;
import com.vector.supertinycompiler.parser.Node;
import com.vector.supertinycompiler.traverser.TinyTraverser;
import com.vector.supertinycompiler.traverser.Traverser;

/**
 * A tiny implementation of the <code>Transformer</code>.
 * 
 * @author  quickpoint 
 * @version $Id: TinyTransformer.java, v 1.0 2019 Exp $
 */
public class TinyTransformer implements Transformer {

    /** 
     * @see com.vector.supertinycompiler.transformer.Transformer#transform(com.vector.supertinycompiler.parser.Node)
     */
    public Node transform(Node ast) throws ParseException {

        Traverser traverser = new TinyTraverser();

        traverser.traverse(ast, ast, new AstVisitor());

        return ast;
    }

}
