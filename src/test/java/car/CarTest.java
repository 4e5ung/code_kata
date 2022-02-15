package car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

public class CarTest {

    @Test
    void createCar() {
        //이제는 다시 정상적으로 차를 먼저 테스트 해봅니다
        String carName = "Chan";
        Assertions.assertThatCode(() -> {
            Car.createCar(carName); // 차객체 생성
        }).doesNotThrowAnyException(); // 에러가 안터져야하니
    } // 인텔리제이 다시키고올게요..

    @ParameterizedTest
    @NullAndEmptySource
    void createCarInputNullAlwaysError(String carName) { // 네!
        Assertions.assertThatThrownBy(() -> {
            Car.createCar(carName);
        }).isInstanceOf(IllegalAccessException.class);
        //이제에러가 터지겟죠 Illegal이 안나와서
    }

    //차이름이 5글자 이상일경우 에러
    @ParameterizedTest
    @ValueSource(strings = {"aaaa123,abcd1234"})
    void createInputGreaterThanFive(String value) {
        Assertions.assertThatThrownBy(() -> {
            Car.createCar(value);
        }).isInstanceOf(IllegalAccessException.class);
        // 5글자 이상일 경우의 에러
    }

//    @Test
//    void moveCarWithRandomConditionDonMove() throws IllegalAccessException {
//        RandomCondition randomOverThanFour = () -> 3;
//
//        Car car = Car.createCar("car1");
//        int distance = car.getDistance();
//        car.move();
//        // 자동차가 거리만큼 이동했는지 검증
//        Assertions.assertThat(car.getDistance()).isEqualTo(distance);
//    }


    // 네 게임에서 처리한다는느낌이져
//    @Test
//    void moveCarWithRandomConditionMove() throws IllegalAccessException {
//        RandomCondition randomOverThanFour = () -> 4;
//
//        Car car = Car.createCar("move");
//        int distance = car.getDistance();
//        car.move();
//        // 이메서드가 RacingTest쪽에빠져야될거같아요
//
//        Assertions.assertThat(car.getDistance()).isEqualTo(distance + 1);
//    }

    @Test
    void moveCarWithRandomConditionMove() throws IllegalAccessException {
        RandomCondition randomOverThanFour = () -> true;
        // 자동차가 random값에 의해 전진 하는 테스트 케이스
        Car car = Car.createCar("move");
        car.move(randomOverThanFour);
        Assertions.assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void nonMoveCarWithRandomConditionMove() throws IllegalAccessException {
        RandomCondition randomOverThanFour = () -> false;
        // 자동차가 random값에 의해 전진하지 못하는 하는 테스트 케이스
        Car car = Car.createCar("move");
        car.move(randomOverThanFour);
        Assertions.assertThat(car.getDistance()).isEqualTo(0);
    }

}


