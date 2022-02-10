package car;

import java.util.List;

public class RacingGame {
    private RandomCondition randomCondition = new RandomConditionService();
    private final InGameCars inGameCars;

    public RacingGame(InGameCars inGameCars) {
        this.inGameCars = inGameCars;
    }

    public static RacingGame createGame(InGameCars inGameCars) {
        return new RacingGame(inGameCars);
    }

//    public void carMove(){
//        cars.forEach(car ->{
//          if (randomCondition.makeRandomInt() >= 4){
//              car.move();
//          }
//        });
//    }

}
