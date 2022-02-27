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


public class GameRoleTest {

<<<<<<< HEAD
    private GameRole gameRole;

    @BeforeEach
    void initGameRole(){
        this.gameRole = GameRole.create();
    }

=======
>>>>>>> 1124c5f8973cd06016e765c04dd11d12292643f3
    @Test
    void createGameRole(){
        Assertions.assertThatCode(() -> {GameRole.create();}).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource
    void getResult(List<Integer> player, List<Integer> computer, List<Integer> result){
<<<<<<< HEAD
=======
        GameRole gameRole = GameRole.create();
>>>>>>> 1124c5f8973cd06016e765c04dd11d12292643f3
        Assertions.assertThat(gameRole.getResult(player, computer)).isEqualTo(result);
    }

    static Stream<Arguments> getResult(){
        return Stream.of(
                Arguments.of(List.of(1,2,3), List.of(1,2,3), List.of(0, 3)),
                Arguments.of(List.of(1,4,5), List.of(1,2,3), List.of(0, 1)),
                Arguments.of(List.of(1,6,4), List.of(2,1,3), List.of(1, 0)));
    }

    @ParameterizedTest
    @MethodSource
    void getStrikeOfResult(List<Integer> result, int strike){
<<<<<<< HEAD
=======
        GameRole gameRole = GameRole.create();
>>>>>>> 1124c5f8973cd06016e765c04dd11d12292643f3
        Assertions.assertThat(gameRole.getStrikeOfResult(result)).isEqualTo(strike);
    }
    static Stream<Arguments> getStrikeOfResult(){
        return Stream.of(
                Arguments.of(List.of(0, 3), 3),
                Arguments.of(List.of(0, 1), 1),
                Arguments.of(List.of(1, 0), 0));
    }

    @ParameterizedTest
    @MethodSource
    void getBallOfResult(List<Integer> result, int ball){
<<<<<<< HEAD
=======
        GameRole gameRole = GameRole.create();
>>>>>>> 1124c5f8973cd06016e765c04dd11d12292643f3
        Assertions.assertThat(gameRole.getBallOfResult(result)).isEqualTo(ball);
    }

    static Stream<Arguments> getBallOfResult(){
        return Stream.of(
                Arguments.of(List.of(0, 3), 0),
                Arguments.of(List.of(2, 1), 2),
                Arguments.of(List.of(1, 0), 1));
    }


    @ParameterizedTest
    @MethodSource
    void getGameStatus(List<Integer> result, boolean status){
<<<<<<< HEAD
=======
        GameRole gameRole = GameRole.create();
>>>>>>> 1124c5f8973cd06016e765c04dd11d12292643f3
        Assertions.assertThat(gameRole.getGameStatus(result)).isEqualTo(status);
    }

    static Stream<Arguments> getGameStatus(){
        return Stream.of(
                Arguments.of(List.of(0, 3), true),
                Arguments.of(List.of(2, 1), false),
                Arguments.of(List.of(1, 0), false));
    }

}
