package car;

public class Car {
    private final String carName;
    private int distance; // 여기에 들어가지않나요??


    public Car(String carName) { // 여기가좋겟죠

        if(carName == null || carName.isBlank() || carName.length() >= 5){
            try {
                throw new IllegalAccessException();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        this.carName = carName;
    }


    public static Car createCar(String carName) {
        return new Car(carName);
    }

    public void move(RandomCondition randomCondition) {
        if (randomCondition.getCondition()) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }

}
