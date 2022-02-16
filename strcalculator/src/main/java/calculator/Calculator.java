package calculator;

import java.util.function.IntBinaryOperator;

public class Calculator {
    IntBinaryOperator intAddOperator = (left , right ) -> left + right;
    IntBinaryOperator intSubtractOperator = (left , right ) -> left - right;
    IntBinaryOperator intMultiplyOperator = (left , right ) -> left * right;
    IntBinaryOperator intDivideOperator = (left , right ) -> left / right;

    int calculator(int num1, int num2, String sign){
        int data = 0;

        switch(sign.charAt(0)){
            case '+':
                data= intAddOperator.applyAsInt(num1, num2);
                break;
            case '-':
                data= intSubtractOperator.applyAsInt(num1, num2);
                break;
            case '*':
                data= intMultiplyOperator.applyAsInt(num1, num2);
                break;
            case '/':
                data= intDivideOperator.applyAsInt(num1, num2);
                break;
        }

        return data;
    }

    int add(int num1, int num2){
        return intAddOperator.applyAsInt(num1, num2);
    }

    int subtract(int num1, int num2){
        return intSubtractOperator.applyAsInt(num1, num2);
    }

    int multiply(int num1, int num2){
        return intMultiplyOperator.applyAsInt(num1, num2);
    }

    int divide(int num1, int num2){
        return intDivideOperator.applyAsInt(num1, num2);
    }


}
