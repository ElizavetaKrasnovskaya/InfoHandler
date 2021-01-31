package com.epam.handling.interpreter;

import java.util.Stack;

public class TermExpressionCos extends MathExpression{
    @Override
    public void interpret(Stack<Double> context) {
        context.push(Math.cos(context.pop()));
    }
}
