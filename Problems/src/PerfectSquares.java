import java.util.Arrays;

/*
Given a positive integer n, find the least number of perfect square numbers
(for example, 1, 4, 9, 16, ...) which sum to n.
 */
public class PerfectSquares {
    private static int numSquares(int n) {
        int[] res = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                res[i] = Math.min(res[i], res[i - j * j] + 1);
                System.out.println(i + " -> " + j + " -> " + res[i]);
            }
        }
        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(5));
    }
}
