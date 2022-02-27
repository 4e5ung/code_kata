import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class GameTest {
    private Game game;

    @BeforeEach
    void initGame(){
        this.game = Game.create(Player.create(), Computer.create(new RandomValueGenerator()), GameRole.create(), GameConsole.create());
    }

    @Test
    void createGame() {
        // 게임 인스턴스의 생성 검증
        Assertions.assertThatCode(() -> {
            Game.create(Player.create(), Computer.create(new RandomValueGenerator()), GameRole.create(), GameConsole.create());}).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource
    void reStartStatus(Integer status, boolean result){
        Assertions.assertThat(game.reStartStatus(status)).isEqualTo(result);
    }

    static Stream<Arguments> reStartStatus(){
        return Stream.of(
                Arguments.of(1, false),
                Arguments.of(2, true));
    }
}
