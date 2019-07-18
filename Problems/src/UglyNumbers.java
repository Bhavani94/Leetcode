import java.util.HashSet;
import java.util.Set;

public class UglyNumbers {
    public static boolean isUgly(int num) {
        Set<Integer> uglySet = new HashSet<>();
        uglySet.add(2);
        uglySet.add(3);
        uglySet.add(5);
        if(num > 0)
            for(int i : uglySet)
                while(num % i == 0) {
                    num /= i;
                }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(8));
    }
}
