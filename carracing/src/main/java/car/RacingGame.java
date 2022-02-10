package car;

import java.util.List;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingGame createGame(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return new RacingGame(cars);
    }

}
