import java.util.List;
import java.util.Objects;

public class Game {
    private final Integer RESTART_GAME = 1;
    private final Integer FINISHED_GAME = 2;

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
        boolean finished = false;

        do {
            gameConsole.printInputMessage(GameRoleConsoleType.MESSAGE_GAME_START.getText());
            player.setValues(gameConsole.startConsole());
            List<Integer> gameResult = gameRole.getResult(player.getValues(), computer.getValues());
            gameConsole.printGameResultMessage(gameRole.getBallOfResult(gameResult), gameRole.getStrikeOfResult(gameResult));
            if(gameRole.getGameStatus(gameResult)) {
                gameConsole.printMessage(GameRoleConsoleType.MESSAGE_COMPLETE_GAME.getText());
                gameConsole.printInputMessage(GameRoleConsoleType.MESSAGE_GAME_RESTART.getText());
                finished = reStartStatus(gameConsole.reStartConsole());
            }
        }while( !finished );
    }

    public boolean reStartStatus(Integer status){
        return Objects.equals(status, FINISHED_GAME);
    }
}
