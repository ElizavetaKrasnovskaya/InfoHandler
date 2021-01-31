package com.epam.handling.interpreter;

import java.util.Stack;

public abstract class MathExpression {
    public abstract void interpret(Stack<Double> context);
}
