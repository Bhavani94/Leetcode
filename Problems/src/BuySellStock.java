public class BuySellStock {
    //If you were only permitted to complete at most one transaction
    private static int maxProfit(int[] prices) {
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

    /*
    Design an algorithm to find the maximum profit.
    You may complete as many transactions as you like
    (i.e., buy one and sell one share of the stock multiple times).
     */
    private static int maxProfitII(int[] prices) {
        if(prices.length == 0 || prices.length == 1)
            return 0;
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfitII(new int[]{7,1,5,3,6,4}));
    }
}
