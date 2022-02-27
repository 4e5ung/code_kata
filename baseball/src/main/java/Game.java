import java.util.List;

public class Game {
    private final GameConsole gameConsole;
    private final Player player;
    private final Computer computer;
    private final GameRole gameRole;

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

        boolean result;

        do {
            gameConsole.printRequireInputMessage();
            player.setValues(gameConsole.startConsole());
            List<Integer> gameResult = gameRole.getResult(player.getValues(), computer.getValues());
            gameConsole.printGameResultMessage(gameRole.getBallOfResult(gameResult), gameRole.getStrikeOfResult(gameResult));
            result = gameRole.getGameStatus(gameResult);
            if(result) gameConsole.printCompleteGameMessage();
        }while( !result );
    }
}
