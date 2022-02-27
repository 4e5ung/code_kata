import org.assertj.core.api.Assertions;
<<<<<<< HEAD
import org.junit.jupiter.api.BeforeEach;
=======
>>>>>>> 1124c5f8973cd06016e765c04dd11d12292643f3
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class GameTest {

<<<<<<< HEAD
    private Game game;

    @BeforeEach
    void initGame(){
        this.game = Game.create(Player.create(), Computer.create(new RandomValueGenerator()), GameRole.create(), GameConsole.create());
    }

=======
>>>>>>> 1124c5f8973cd06016e765c04dd11d12292643f3
    @Test
    void createGame() {
        // 게임 인스턴스의 생성 검증
        Assertions.assertThatCode(() -> {
            Game.create(Player.create(), Computer.create(new RandomValueGenerator()), GameRole.create(), GameConsole.create());}).doesNotThrowAnyException();
    }


<<<<<<< HEAD
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
=======
>>>>>>> 1124c5f8973cd06016e765c04dd11d12292643f3
}
