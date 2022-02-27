import org.assertj.core.api.Assertions;
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

    @Test
    void createGameConsole() {
        Assertions.assertThatCode(() -> {GameConsole.create();}).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {145, 324})
    void startConsole(Integer value){
        InputStream in = generateUserInput(Integer.toString(value));
        System.setIn(in);
        Assertions.assertThat(GameConsole.create().startConsole().size()).isEqualTo(3);

    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
