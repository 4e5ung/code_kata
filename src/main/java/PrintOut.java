public class PrintOut {
    private final static String MESSAGE_GAME_START = "숫자를 입력해주세요";
    private final static String MESSAGE_COMPLETE_GAME = "숫자를 모두 맞히셨습니다! 게임종료";

    public void printRequireInputMessage() {
        System.out.print(MESSAGE_GAME_START + " : ");
    }

    public void printCompleteGameMessage() {
        System.out.print(MESSAGE_COMPLETE_GAME);
    }

    public void printBall(){
        System.out.print("볼");
    }
    public void printStrike(){
        System.out.println("스트라이크");
    }
    public void printNothing(){
        System.out.println("낫띵");
    }
    public void printInteger(int i){
        System.out.print(i);
    }
}
