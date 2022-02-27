import java.util.EnumSet;
import java.util.NoSuchElementException;

public enum GameRoleType {
    BALL(0, "볼"),
    STRIKE(1, "스트라이크");

    private final int status;
    private final String text;

    GameRoleType(int status, String text) {
        this.status = status;
        this.text = text;
    }

    public int getStatus() {
        return status;
    }

    public String getText() {
        return text;
    }
}
