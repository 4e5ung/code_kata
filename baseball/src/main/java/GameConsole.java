import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameConsole {
    private final Scanner console = new Scanner(System.in);

    public static GameConsole create() {
        return new GameConsole();
    }

    public List<Integer> startConsole() {
        return Arrays.stream(this.console.nextLine().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer reStartConsole() {
        return this.console.nextInt();
    }

    public void printInputMessage(String message) {
        System.out.println(message + " : ");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printGameResultMessage(int ballCount, int strikeCount) {
        StringBuilder gameResultMessage = new StringBuilder();

        if( ballCount > 0 )
            gameResultMessage.append(ballCount).append(GameRoleResultType.BALL.getText()).append(" ");

        if( strikeCount > 0 )
            gameResultMessage.append(strikeCount).append(GameRoleResultType.STRIKE.getText()).append(" ");

        System.out.println(gameResultMessage.toString().trim());
    }
}
