package org.example.calculate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("계산기 생성")
    void makeCalculator(){
        Assertions.assertThatCode(Calculator::create)
                .doesNotThrowAnyException();
    }
    @Test
    @DisplayName("문자열을 받는다.")
    void inputStringToCalculator(){
        Calculator calculator = Calculator.create();
        calculator.setStringValue("test");

        assertThat(calculator.getStringValue()).isEqualTo("test");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열을 받는다.")
    void inputStringToCalculator(String nullString){
        Calculator calculator = Calculator.create();
        Assertions.assertThatThrownBy(() -> {
            calculator.setStringValue(nullString);
        }).isInstanceOf(NullPointerException.class); // <=- 이건 **제맘**이거든요
    }

    @ParameterizedTest
    @MethodSource(value = "printCalculate")
    @DisplayName("문자열 계산 결과를 출력한다.")
    void printCalculate(String inputDate, int result){
        Calculator calculator = Calculator.create();
        calculator.setStringValue(inputDate);

        assertThat(calculator.execute()).isEqualTo(result);

        System.out.println("calculator.execute() = " + calculator.execute());
    }

    static Stream<Arguments> printCalculate(){
        return Stream.of(
                Arguments.of("2 + 3 * 4 / 2", 10),
                Arguments.of("1 + 5 * 4 / 2", 12),
                Arguments.of("5 * 4 / 2 + 1", 11)
        );
    }


}
