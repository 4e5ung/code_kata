<<<<<<< HEAD
import org.junit.jupiter.api.BeforeEach;
=======
>>>>>>> 1124c5f8973cd06016e765c04dd11d12292643f3
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class ComputerTest {
<<<<<<< HEAD
    private Computer computer;

    @BeforeEach
    void initComputer(){
        this.computer = Computer.create(new RandomValueGenerator());
    }
=======
    Computer computer = Computer.create(new RandomValueGenerator());
>>>>>>> 1124c5f8973cd06016e765c04dd11d12292643f3

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
