package org.example.calculate;

import java.util.Stack;
import java.util.function.IntBinaryOperator;

public class Calculator {
    private String stringValue;
    private int result;

    public Calculator() {
    }

    public static Calculator create(){
        return new Calculator();
    }

    public int execute() {
        int data = 0;
        Stack<Character> stack = new Stack<>();
//        stack.push()
//        stack.push()
//        stack.push()

        // 계산하기
        int temp = Integer.parseInt(String.valueOf(stringValue.charAt(0)));
        String temp2;
        for (int i = 1; stringValue.length() > 2 * i -1; i++) {
            temp2 = String.valueOf(this.stringValue.charAt(2 * i - 1));

            switch (temp2) {
                case "+" -> temp += Integer.parseInt(String.valueOf(stringValue.charAt(2 * i)));
                case "-" -> temp -= Integer.parseInt(String.valueOf(stringValue.charAt(2 * i)));
                case "*" -> temp *= Integer.parseInt(String.valueOf(stringValue.charAt(2 * i)));
                case "/" -> temp /= Integer.parseInt(String.valueOf(stringValue.charAt(2 * i)));
            }
        }

        return temp;
    }

    public int getResult() {
        return result;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        if(stringValue == null || stringValue.isBlank()){
            throw new NullPointerException();
        }
        this.stringValue = stringValue.replace(" ","");
    }
}
