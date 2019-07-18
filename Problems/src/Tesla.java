import java.util.Stack;

public class Tesla {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0) {
            return 0;
        }

        int sum = 0;
        for(int i = 0; i < A.length; i++){
            if((A[i] > 9 && A[i] < 100) || (A[i] > -100 && A[i] < -9) )
                sum += A[i];
        }
        return sum;
    }

    public static int solution(String S) {
        // write your code in Java SE 8

        String[] strs = S.split(" ");
        Stack<String> stack = new Stack<>();
        for(String s : strs){
        }

        return -1;
    }

    public static int beads(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE, sum;

        for (int i = 0; i < A.length; i++) {
            sum = 0;
            if (A[i] != -1) {
                int index = i;
                while (A[index] < A.length && A[index] != -1) {
                    sum ++;
                    int t = A[index];
                    A[index] = -1;
                    index = t;
                }
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1000, 80, -91}));
//        solution(solution("13 DUP 4 POP 5 DUP + DUP + -"))
        System.out.println(beads(new int[]{5, 4, 0, 3, 1, 5, 2}));
    }
}
