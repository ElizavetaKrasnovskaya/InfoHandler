package com.epam.handling.interpreter;

import java.util.Stack;

public class NonTermExpressionNumber extends MathExpression{

    private Double number;

    public NonTermExpressionNumber(Double number){
        this.number = number;
    }

    @Override
    public void interpret(Stack<Double> context) {
        context.push(number);
    }
}
