package task3;



import java.util.Arrays;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {
        Function<int[], Integer> max = x -> Arrays.stream(x).max().getAsInt();
        Function<int[], Integer> min = x -> Arrays.stream(x).min().getAsInt();
        int[]arr={1,2,3,4};
        System.out.println(max.apply(arr));
        System.out.println(min.apply(arr));

    }
}
