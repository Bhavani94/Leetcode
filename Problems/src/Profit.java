public class Profit {
    public static int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1)
            return 0;
        int low = prices[0];
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            int temp = prices[i] - low;
            profit = temp > profit ? temp : profit;
            low = prices[i] < low ? prices[i] : low;
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
