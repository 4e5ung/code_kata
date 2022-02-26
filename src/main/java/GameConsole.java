import java.util.List;

public class GameConsole {

    private final PrintOut printOut = new PrintOut();
    private final InputIO inputIO = new InputIO();

    public static GameConsole create() {
        return new GameConsole();
    }

    public List<Integer> startConsole() {
        printOut.printRequireInputMessage();
        return inputIO.getPlayerInput();
    }


    public void printGameResultMessage(List<Integer> gameResult) {
        if (myReuslt(gameResult)) return;

        printOut.printInteger(gameResult.get(0));
        printOut.printBall();
        printOut.printInteger(gameResult.get(1));
        printOut.printStrike();

        if (gameResult.get(1) == 3){
            printOut.printCompleteGameMessage();
            return;
        }
    }

    private boolean myReuslt(List<Integer> gameResult) {
        if (gameResult.get(0).equals(1) && gameResult.get(1).equals(0)){
            printOut.printNothing();
            return true;
        }
        return false;
    }

}
