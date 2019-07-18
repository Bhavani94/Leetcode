public class ClimbStairs {
    private static int climbStairs(int n) {
        if(n == 1 || n == 2)
            return n;
        int f1 = 1;
        int f2 = 2;
        int counter = 3;
        int f3 = f1 + f2;
        while(counter++ <= n){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    private static int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0, f3;
        for(int i = 0; i < cost.length; i++) {
            f3 = cost[i] + Math.min(f1, f2);
            f1 = f2;
            f2 = f3;
        }
        return Math.min(f1, f2);
    }

    public static void main(String[] args) {

        System.out.println(climbStairs(5));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
