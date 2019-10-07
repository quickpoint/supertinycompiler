/**
 * quickpoint
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.vector.supertinycompiler.transformer;

import com.vector.supertinycompiler.ParseException;
import com.vector.supertinycompiler.parser.Node;

/**
 * <code>Transformer</code> transforms one AST into another.
 * 
 * @author  quickpoint 
 * @version $Id: Transformer.java, v 1.0 2019 Exp $
 */
public interface Transformer {

    /**
     * Transform one AST into another.
     * 
     * @param ast original AST
     * @return another AST
     * @throws ParseException thrown when failed to parse
     */
    Node transform(Node ast) throws ParseException;
}
