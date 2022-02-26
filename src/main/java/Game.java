import java.util.List;

public class Game {

    private final Player player;
    private final Computer computer;
    private final GameRole gameRole;
    private final GameConsole gameConsole;

    Game(Player player, Computer computer, GameRole gameRole, GameConsole gameConsole) {
        this.player = player;
        this.computer = computer;
        this.gameRole = gameRole;
        this.gameConsole = gameConsole;
    }

    public static Game create(Player player, Computer computer, GameRole gameRole, GameConsole gameConsole) {
        return new Game(player, computer, gameRole, gameConsole);
    }

    public void start() {
        while (true){
            player.setValues(gameConsole.startConsole());
            List<Integer> gameResult = gameRole.getResult(player.getValues(), computer.getValues());
            gameConsole.printGameResultMessage(gameResult);
            if (isStrike(gameResult)) return;
        }
    }

    private boolean isStrike(List<Integer> gameResult) {
        return gameResult.get(1) == 3;
    }

    public void setPlayerValue(List<Integer> playerValue) {
        player.setValues(playerValue);
    }

    public List<Integer> currentPlayerValue() {
        return player.getValues();
    }

}
