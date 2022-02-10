package car;

public class Car {
    private final String carName;
    private int distance; // 여기에 들어가지않나요??

    public Car(String carName) throws IllegalAccessException { // 여기가좋겟죠
        if(carName == null || carName.isBlank() || carName.length() >= 5){
            throw new IllegalAccessException();
        }
        this.carName = carName;
    }


    public static Car createCar(String carName) throws IllegalAccessException {
        return new Car(carName);
    }



    public void move() {
        this.distance += 1;
    }

    public int getDistance() {
        return this.distance;
    }

}
