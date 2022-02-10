package car;

import java.util.List;

public class InGameCars {

    private final List<Car> cars;

    InGameCars(List<Car> cars) {
        this.cars = cars;
    }

    public static InGameCars createInGameCars(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return new InGameCars(cars);
    }

    public boolean carsIsEmpty() {
        return this.cars.isEmpty();
    }

}
