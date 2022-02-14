package org.example.calculate;

import java.util.function.IntBinaryOperator;

public enum ArithmeticOperation {
    PLUS("+", ArithmeticOperation::sum),
    MINUS("-", ArithmeticOperation::minus),
    DIVIDE("/", ArithmeticOperation::div),
    MULTI("*", ArithmeticOperation::multi);

    private final String value;
    private final IntBinaryOperator intBinaryOperator;

    ArithmeticOperation(String value, IntBinaryOperator intBinaryOperator) {
        this.value = value;
        this.intBinaryOperator = intBinaryOperator;
    }
    public int result(int left,int right){
        return this.intBinaryOperator.applyAsInt(left,right);
    }

    private static int sum(int left,int right){
        return left + right;
    }
    private static int minus(int left,int right){
        return left - right;
    }
    private static int div(int left,int right){
        return left / right;
    }
    private static int multi(int left,int right){
        return left * right;
    }
}
