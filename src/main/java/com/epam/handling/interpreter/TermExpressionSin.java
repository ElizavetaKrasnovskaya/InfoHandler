package com.epam.handling.interpreter;

import java.util.Stack;

public class TermExpressionSin extends MathExpression{
    @Override
    public void interpret(Stack<Double> context) {
        context.push(Math.sin(context.pop()));
    }
}
