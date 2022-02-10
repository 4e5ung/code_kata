package car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InGameCarTest {

    @Test
    void createInGameCars() throws IllegalAccessException {
        // 테스트 자동차 생성
        List<Car> cars = List.of(
                Car.createCar("car1"),
                Car.createCar("car2"),
                Car.createCar("car3")
        );
        // 게임 인스턴스 생성
        assertThatCode(() -> {InGameCars.createInGameCars(cars);}).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @EmptySource
    void createInGameCarsInputEmptyError(List<Car> cars) {
        assertThatThrownBy(() -> {InGameCars.createInGameCars(cars);})
                .isInstanceOf(IllegalArgumentException.class);
    }

}
