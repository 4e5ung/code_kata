public enum GameRoleConsoleType {
    MESSAGE_GAME_START("숫자를 입력해주세요"),
    MESSAGE_GAME_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    MESSAGE_COMPLETE_GAME("3개의 숫자를 모두 맞히셨습니다! 게임종료");

    private final String text;

    GameRoleConsoleType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
