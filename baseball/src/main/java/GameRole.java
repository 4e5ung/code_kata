import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GameRole {

    private final Integer FINISHED_STRIKE_COUNT = 3;

    public static GameRole create() {
        return new GameRole();
    }

    public List<Integer> getResult(List<Integer> player, List<Integer> computer) {
        List<Integer> result = new ArrayList<>(2);

        int strike = 0;
        int ball = 0;

        // 스트라이크
        strike = getStrike(player, computer, strike);

        // 스트라이크+볼
        ball = getStrikeBall(player, computer, ball);

        result.add(GameRoleResultType.BALL.getStatus(), Math.abs(strike-ball));
        result.add(GameRoleResultType.STRIKE.getStatus(), strike);

        return result;
    }

    private int getStrikeBall(List<Integer> player, List<Integer> computer, int ball) {
        for(int i = 0; i < Player.PLAYER_BALL_SIZE; i++) {
            ball += Collections.frequency(computer, player.get(i));
        }
        return ball;
    }

    private int getStrike(List<Integer> player, List<Integer> computer, int strike) {
        for(int i = 0; i < Player.PLAYER_BALL_SIZE; i++){
            strike = getStrike(player, computer, strike, i);
        }
        return strike;
    }

    private int getStrike(List<Integer> player, List<Integer> computer, int strike, int i) {
        if(Objects.equals(player.get(i), computer.get(i))){
            strike++;
        }
        return strike;
    }

    public int getBallOfResult(List<Integer> result) {
        return result.get(GameRoleResultType.BALL.getStatus());
    }

    public int getStrikeOfResult(List<Integer> result) {
        return result.get(GameRoleResultType.STRIKE.getStatus());
    }

    public boolean getGameStatus(List<Integer> result){
        return Objects.equals(result.get(GameRoleResultType.STRIKE.getStatus()), FINISHED_STRIKE_COUNT);
    }
}
