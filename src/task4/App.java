package task4;

interface Expression {
    boolean isEqual(int n);
}


public class App {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 5, 8, 9};
        int x = sum(nums, (n) -> n == 5);
        System.out.println(x);
        x = sum(nums, (n) -> n >= 6 && n <= 9);
        System.out.println(x);
        x = sum(nums, (n) -> n >0);
        System.out.println(x);
        x = sum(nums, (n) -> n <0);
        System.out.println(x);

    }

    private static int sum(int[] numbers, Expression func) {
        int result = 0;
        for (int i : numbers) {
            if (func.isEqual(i))
                result += i;
        }
        return result;
    }
}
