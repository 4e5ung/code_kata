package car;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static car.InGameCars.createInGameCars;

public class Context {
    public static final RandomConditionService conditionService = new RandomConditionService();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String data1 = "pobi,crong,honux";
        int data2 =5;
        InGameCars inGameCars = createInGameCars(Arrays.stream(data1.split(",")).map(Car::createCar).collect(Collectors.toList()));
        IntStream.rangeClosed(1,5).forEach((i) -> {
            inGameCars.getCars().forEach(car -> car.move(conditionService));
        });

        List<Car> result = inGameCars.getCars();
    }
}
