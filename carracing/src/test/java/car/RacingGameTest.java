package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    private InGameCars inGameCars;

    @BeforeEach
    void createInGameCars() throws IllegalAccessException {
        // 테스트 자동차 생성
        List<Car> cars = List.of(
                Car.createCar("car1"),
                Car.createCar("car2"),
                Car.createCar("car3")
        );
        this.inGameCars = InGameCars.createInGameCars(cars);
    }

    @Test
    void createRacingGame() {
        // 게임 인스턴스 생성
        assertThatCode(() -> {RacingGame.createGame(this.inGameCars);}).doesNotThrowAnyException();
    }

//    @ParameterizedTest
//    @MethodSource("createRacingGameInputArguments")
//    void createRacingGameInputEmptyError(InGameCars cars) {
//        // 게임에 참가하는 자동차가 없을 경우 게임은 생성되지 않는다
//        assertThatThrownBy(() -> {RacingGame.createGame(cars);})
//                .isInstanceOf(IllegalArgumentException.class);
//    }

    // 게임에서 한턴을 진행하였을 경우 자동차들의 움직임 테스트
//    void startRacingGame() {
//
//    }

}