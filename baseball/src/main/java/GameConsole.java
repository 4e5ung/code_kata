import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameConsole {

    private final static String MESSAGE_GAME_START = "숫자를 입력해주세요";
    private final static String MESSAGE_COMPLETE_GAME = "개의 숫자를 모두 맞히셨습니다! 게임종료";
    private final Scanner console = new Scanner(System.in);

    public static GameConsole create() {
        return new GameConsole();
    }

    public List<Integer> startConsole() {
        return Arrays.stream(this.console.nextLine().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void printRequireInputMessage() {
        System.out.println(MESSAGE_GAME_START + " : ");
    }

    public void printCompleteGameMessage() {
        System.out.println(MESSAGE_COMPLETE_GAME);
    }

    public void printGameResultMessage(int ballCount, int strikeCount) {
        StringBuilder gameResultMessage = new StringBuilder();

        if( ballCount > 0 )
            gameResultMessage.append(ballCount).append(GameRoleType.BALL.getText()).append(" ");

        if( strikeCount > 0 )
            gameResultMessage.append(strikeCount).append(GameRoleType.STRIKE.getText()).append(" ");

        System.out.println(gameResultMessage.toString().trim());
    }
}
