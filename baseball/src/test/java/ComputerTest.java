import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class ComputerTest {
    private Computer computer;

    @BeforeEach
    void initComputer(){
        this.computer = Computer.create(new RandomValueGenerator());
    }

    @Test
    void createComputer(){
        assertThatCode(() ->{
            Computer computer = Computer.create(new RandomValueGenerator());
        }).doesNotThrowAnyException();
    }

    @Test
    void computerValues(){
        computer.reGenerateRandomValue();
        assertThat(computer.getValues().size()).isEqualTo(3);
    }

//    @Test
//    void computerValuesWithEmptyValue(){
//        assertThatThrownBy(() -> {
//            computer.reGenerateRandomValue();
//        }).isInstanceOf(IllegalArgumentException.class);
//    }

}
