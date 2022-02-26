import java.util.List;

public class GameApplication {

    public static void main(String[] args) {
        Game.create(
                Player.create(),
                Computer.create(new RandomValueGenerator()),
                GameRole.create(),
                GameConsole.create()
                ).start();
    }

}
