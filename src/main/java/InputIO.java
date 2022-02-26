import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputIO {
    private final Scanner console = new Scanner(System.in);

    public List<Integer> getPlayerInput(){
        return Arrays.stream(this.console.nextLine().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
