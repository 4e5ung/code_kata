package car;
import java.util.random.RandomGenerator;

public class RandomConditionService implements RandomCondition{
    public static final RandomGenerator RANDOM_GENERATOR = RandomGenerator.getDefault();


    @Override
    public boolean getCondition() {
        return RANDOM_GENERATOR.nextInt(10) >= 4;
    }
}
