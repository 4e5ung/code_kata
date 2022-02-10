package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {

    @Test
    void createRacingGame() throws IllegalAccessException {
        // 테스트 자동차 생성
        List<Car> cars = List.of(
                Car.createCar("car1"),
                Car.createCar("car2"),
                Car.createCar("car3")
        );

        // 게임 인스턴스 생성
        assertThatCode(() -> {RacingGame.createGame(cars);}).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @EmptySource
    void createRacingGameInputEmptyError(List<Car> cars) {
        // 게임에 참가하는 자동차가 없을 경우 게임은 생성되지 않는다
        assertThatThrownBy(() -> {RacingGame.createGame(cars);})
                .isInstanceOf(IllegalArgumentException.class);
    }

}