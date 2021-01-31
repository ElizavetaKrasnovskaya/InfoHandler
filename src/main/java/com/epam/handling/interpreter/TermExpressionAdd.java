package com.epam.handling.interpreter;

import java.util.Stack;

public class TermExpressionAdd extends MathExpression{
    @Override
    public void interpret(Stack<Double> context) {
        context.push(context.pop() + context.pop());
    }
}
