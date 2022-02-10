package car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @Test
    void createCar(){
        //이제는 다시 정상적으로 차를 먼저 테스트 해봅니다
        String carName = "Chan";
        Assertions.assertThatCode(() -> {
            Car car = Car.createCar(carName); // 차객체 생성
        }).doesNotThrowAnyException(); // 에러가 안터져야하니
    } // 오늘은 인코딩 에러땜에..

    @ParameterizedTest
    @NullAndEmptySource
    void createCarInputNullAlwaysError(String carName){ // 네!
        Assertions.assertThatThrownBy(() ->{
            Car car = Car.createCar(carName);
        }).isInstanceOf(IllegalAccessException.class);
        //이제에러가 터지겟죠 Illegal이 안나와서
    }

    //차이름이 5글자 이상일경우 에러
    @Test
    void createInputGreaterThanFive(){
        String carName = "carfive";
        Assertions.assertThatThrownBy(() ->{
            Car car = Car.createCar(carName);
        }).isInstanceOf(IllegalAccessException.class);
        // 5글자 이상일 경우의 에러
    }

    @Test
    void moveCar() throws IllegalAccessException {
        Car car = Car.createCar("car1");
        int distance = car.getDistance();
        car.move();
        // 자동차가 거리만큼 이동했는지 검증
        Assertions.assertThat(car.getDistance()).isEqualTo(distance + 1);
    }

}
