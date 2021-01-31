package com.epam.handling.interpreter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    public static Calculator calculator = new Calculator();

    @Test
    public void calculateTestSingle() {
        String singleExpr = "1";
        String singleExprResult = "1";
        assertEquals(singleExprResult, calculator.calculate(singleExpr));
    }

    @Test
    public void calculateTestSimple() {
        String simpleExpr = "2*4";
        String simpleExprResult = "8";
        assertEquals(simpleExprResult, calculator.calculate(simpleExpr));
    }

    @Test
    public void calculateTestSin() {
        String sinExpr = "sin(1)";
        String sinExprResult = "1";
        assertEquals(sinExprResult, calculator.calculate(sinExpr));
    }

    @Test
    public void calculateTestFull() {
        String fullExpr = "2+3*4/(cos(2+3)-3*(2.3-3.43))";
        String fullExprResult = "5";
        assertEquals(fullExprResult, calculator.calculate(fullExpr));
    }

}
