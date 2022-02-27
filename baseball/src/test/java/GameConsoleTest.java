import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Stream;

public class GameConsoleTest {

    private GameConsole gameConsole;

    @BeforeEach
    void initGameConsole(){
        this.gameConsole = GameConsole.create();
    }

    @Test
    void createGameConsole() {
        Assertions.assertThatCode(() -> {GameConsole.create();}).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {145, 324})
    void startConsole(Integer value){
        InputStream in = generateUserInput(Integer.toString(value));
        System.setIn(in);
        Assertions.assertThat(gameConsole.create().startConsole().size()).isEqualTo(3);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void reStartConsole(Integer value){
        InputStream in = generateUserInput(Integer.toString(value));
        System.setIn(in);
        Assertions.assertThat(GameConsole.create().reStartConsole()).isEqualTo(value);

    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @MethodSource
    void printGameResultMessage(int ballCount, int strikeCount) {
        Assertions.assertThatCode(() -> {gameConsole.printGameResultMessage(ballCount, strikeCount);}).doesNotThrowAnyException();
    }

    static Stream<Arguments> printGameResultMessage() {
        return Stream.of(
                Arguments.of(1, 1)
        );
    }

    @Test
    void printMessage() {
        Assertions.assertThatCode(() -> {gameConsole.printMessage(GameRoleConsoleType.MESSAGE_COMPLETE_GAME.getText());}).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource
    void printInputMessage(String message) {
        Assertions.assertThatCode(() -> {gameConsole.printInputMessage(message);}).doesNotThrowAnyException();
    }

    static Stream<Arguments> printInputMessage() {
        return Stream.of(
                Arguments.of(GameRoleConsoleType.MESSAGE_GAME_START.getText(),
                        GameRoleConsoleType.MESSAGE_GAME_RESTART.getText())
        );
    }
}
