import java.util.HashSet;
import java.util.Set;

public class HappyNumbers {
    private static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int num = n;
        int sum;
        while(set.add(num)) {
            sum = 0;
            while (num > 0) {
                int last = num % 10;
                sum += last * last;
                num /= 10;
            }
            if(sum == 1)
                return true;
            num = sum;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(14));
    }
}
