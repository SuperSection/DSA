
/**
 * LeetCode Problem: 121. Best Time to Buy and Sell Stock
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(1)
 */
class SolutionLCP121 {

    public static int maxProfit(int[] prices) {
        // We need to Buy on LOWEST value
        // and Sell on HIGHEST value
        // BUT we must buy before we sell.

        if (prices.length == 1) {
            return 0;
        }

        int profit = 0;
        int buy = Integer.MAX_VALUE;

        for (int todaysPrice : prices) {
            if (todaysPrice < buy) {
                buy = todaysPrice;
            } else {
                profit = profit > (todaysPrice - buy) ? profit : (todaysPrice - buy);
            }
        }

        return profit;
    }
}

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(SolutionLCP121.maxProfit(
                new int[]{7, 1, 5, 3, 6, 4}
        ));
    }
}
