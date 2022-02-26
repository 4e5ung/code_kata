import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final MakeValue makeValue;
    private List<Integer> values;

    Computer(MakeValue makeValue) {
        this.makeValue = makeValue;
        this.values = makeValue.makeRandomValue();
    }

    public static Computer create(MakeValue makeValue) {
        return new Computer(makeValue);
    }

//    public void setRandomValues(List<Integer> values) {
//        if (values.isEmpty()){
//            throw new IllegalArgumentException("VALUES IS EMPTY");
//        }
//        this.values = makeValue.makeRandomValue();
//    }

    public void reGenerateRandomValue() {
        this.values = makeValue.makeRandomValue();
    }

    public List<Integer> getValues() {
        return values;
    }
}
