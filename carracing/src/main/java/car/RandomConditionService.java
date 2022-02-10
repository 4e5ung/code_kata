package car;


import java.util.Random;
import java.util.random.RandomGenerator;

// 테스트의 용이성을위해서요
public class RandomConditionService implements RandomCondition{
    private static final RandomGenerator RANDOM_GENERATOR = RandomGenerator.getDefault();

    // 빨간줄이왜뜨죠..?
    // 자바 17 기능입니당
    // 네 0~9까지 뽑을수있어요
    @Override
    public int makeRandomInt() {
        return RANDOM_GENERATOR.nextInt(10);
    }
}
