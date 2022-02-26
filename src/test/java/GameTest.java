import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class GameTest {

    @Test
    void createGame() {
        // 게임 인스턴스의 생성 검증
        Assertions.assertThatCode(() -> {
            Game.create(Player.create(), Computer.create(new RandomValueGenerator()), GameRole.create(), GameConsole.create());}).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource
    void setPlayerValue(List<Integer> playerValue) {
        Game game = Game.create(Player.create(), Computer.create(new RandomValueGenerator()), GameRole.create(), GameConsole.create());
        // 사용자의 숫자를 세팅한다
        game.setPlayerValue(playerValue);
        List<Integer> currentPlayerValue = game.currentPlayerValue();
        Assertions.assertThat(currentPlayerValue).isEqualTo(playerValue);
    }

    static Stream<Arguments> setPlayerValue(){
        return Stream.of(
                Arguments.of(List.of(1,2,3))
        );
    }

}
