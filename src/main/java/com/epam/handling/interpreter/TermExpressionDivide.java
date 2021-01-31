package com.epam.handling.interpreter;

import java.util.Stack;

public class TermExpressionDivide extends MathExpression{
    @Override
    public void interpret(Stack<Double> context) {
        context.push(1/context.pop()*context.pop());
    }
}
