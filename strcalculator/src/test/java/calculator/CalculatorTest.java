package calculator;

import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @ParameterizedTest
    @MethodSource("workingInputParam")
    void doCalculator(String nums, int result){
        Calculator calculator = new Calculator();
        Assertions.assertThat(calculator.working(nums)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("calcInputParam")
    void workCalculatorisRight(int num1, int num2, String sign, int result){
        Assertions.assertThat(CalcOperator.workOperator(sign).operator(num1, num2)).isEqualTo(result);
    }

    @Test
    void addCalculatorisRight() {
        Assertions.assertThat(CalcOperator.ADD.operator(10, 20)).isEqualTo(30);
    }

    @Test
    void subtractCalculatorisRight() {
        Assertions.assertThat(CalcOperator.SUBTRACT.operator(20, 10)).isEqualTo(10);
    }

    @Test
    void multiplyCalculatorisRight() {
        Assertions.assertThat(CalcOperator.MULTIPLY.operator(10, 10)).isEqualTo(100);
    }

    @Test
    void divideCalculatorisRight() {
        Assertions.assertThat(CalcOperator.DIVIDE.operator(10, 10)).isEqualTo(1);
    }

    @Test
    void divideZeroError(){
        Assertions.assertThatThrownBy(() -> {
            CalcOperator.DIVIDE.operator(10, 0);
        }).isInstanceOf(ArithmeticException.class);
    }

    private static Stream<Arguments> calcInputParam() {
        return Stream.of(
                Arguments.of(10, 10, "+", 20),
                Arguments.of(10, 10, "-", 0),
                Arguments.of(10, 10, "*", 100),
                Arguments.of(10, 10, "/", 1)
        );
    }

    private static Stream<Arguments> workingInputParam() {
        return Stream.of(
                Arguments.of("10 + 10 - 20", 0)
        );
    }
}
