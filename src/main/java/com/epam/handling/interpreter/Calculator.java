package com.epam.handling.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {

    private static final String BLANK_REGEX = "\\p{Blank}";
    private static final String NUMBER_REGEX = "[\\d\\.]";
    private static final String OPEN_BRACKET_REGEX = "[(]";
    private static final String CLOSE_BRACKET_REGEX = "[)]";
    private static final String OPERATOR_REGEX = "[*/+-]";
    private static final String COS_SIN_REGEX = "[sc]";
    private static final String MULT_DIV_REGEX = "[*/]";
    private static final String ADD_SUBTR_REGEX = "[+-]";

    public String calculate(String expression) {
        Stack<Double> context = new Stack<>();
        for(MathExpression expr : parseExpr(expression)) {
            expr.interpret(context);
        }
        String result = String.valueOf(Math.round(context.pop()));
        return result;
    }

    private List<MathExpression> parseExpr(String expression) {
        List<MathExpression> expressionList = new ArrayList<>();

        String newExpression = expression.replace("sin", "s").replace("cos", "c");
        for (String symbol : convertToRpn(newExpression).split(BLANK_REGEX)) {
            if (symbol.isEmpty()) {
                continue;
            }

            switch (symbol.charAt(0)) {
                case '+':
                    expressionList.add(new TermExpressionAdd());
                    break;
                case '-':
                    expressionList.add(new TermExpressionSubtract());
                    break;
                case '*':
                    expressionList.add(new TermExpressionMultiply());
                    break;
                case '/':
                    expressionList.add(new TermExpressionDivide());
                    break;
                case 's':
                    expressionList.add(new TermExpressionSin());
                    break;
                case 'c':
                    expressionList.add(new TermExpressionCos());
                    break;
                default:
                    Scanner scan = new Scanner(symbol);
                    if (scan.hasNextDouble()) {
                        expressionList.add(new NonTermExpressionNumber(scan.nextDouble()));
                    }
            }
        }
        return expressionList;
    }

    private String convertToRpn(String expression) {
        StringBuilder exit = new StringBuilder();
        Stack<String> stack = new Stack<>();

        Scanner sc = new Scanner(expression);
        sc.useDelimiter("");

        while (sc.hasNext()) {
            if (sc.hasNext(NUMBER_REGEX)) {
                while (sc.hasNext(NUMBER_REGEX)) {
                    exit.append(sc.next(NUMBER_REGEX));
                }
                exit.append(" ");

            } else if (sc.hasNext(OPEN_BRACKET_REGEX)) {
                stack.push(sc.next(OPEN_BRACKET_REGEX));

            } else if (sc.hasNext(CLOSE_BRACKET_REGEX)) {
                String item;

                while (!stack.isEmpty() && !(item = stack.pop()).matches(OPEN_BRACKET_REGEX)) {
                    exit.append(item).append(" ");
                }
                if (!stack.isEmpty() && stack.peek().matches(COS_SIN_REGEX)) {
                    exit.append(stack.pop()).append(" ");
                }
                sc.next(CLOSE_BRACKET_REGEX);

            } else if (sc.hasNext(COS_SIN_REGEX)) {
                stack.push(sc.next(COS_SIN_REGEX));

            } else if (sc.hasNext(OPERATOR_REGEX)) {
                String oper = sc.next(OPERATOR_REGEX);

                if (!stack.isEmpty() && isNotSmallerPrecedence(stack.peek(), oper)) {   // if operator on stack's precedence
                    exit.append(stack.pop()).append(" ");                       // is greater, pop it
                }

                stack.push(oper);
            }
        }

        while (!stack.isEmpty()) {
            exit.append(stack.pop()).append(" ");
        }

        sc.close();
        return exit.toString();
    }

    private boolean isNotSmallerPrecedence(String op1, String op2) {
        return op1.matches(MULT_DIV_REGEX) ||
                (op1.matches(ADD_SUBTR_REGEX) && op2.matches(ADD_SUBTR_REGEX));
    }
}
