package calculator;

import java.lang.annotation.Target;
import java.util.EnumSet;
import java.util.NoSuchElementException;
import java.util.function.IntBinaryOperator;

public enum CalcOperator {

    ADD("+", (left , right ) -> left + right),
    SUBTRACT("-", (left , right ) -> left - right),
    MULTIPLY("*", (left , right ) -> left * right),
    DIVIDE("/", (left , right ) -> left / right);

    private String sign;
    private IntBinaryOperator intBinaryOperator;

    CalcOperator(String sign, IntBinaryOperator intBinaryOperator) {
        this.sign = sign;
        this.intBinaryOperator = intBinaryOperator;
    }

    public int operator(int num1, int num2){
        return intBinaryOperator.applyAsInt(num1, num2);
    }

    public String getSign(){return this.sign;}

    public static CalcOperator workOperator(String sign){
        return EnumSet.allOf(CalcOperator.class).stream()
                .filter(e->e.getSign().equals(sign))
                .findAny()
                .orElseThrow(()-> new NoSuchElementException());
    }
}
