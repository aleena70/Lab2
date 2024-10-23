public class ShareTrader {
    // Static variable to store the maximum profit
    private static int maxProfit = 0;

    // Static method to find the maximum profit
    public static int findMaxProfit(int[] prices) {
        int n = prices.length;

        // Base case: If the array has less than 2 elements, no profit can be made
        if (n < 2) {
            return 0;
        }

        // Iterate through the prices and explore the possibilities of buying and selling
        for (int i = 1; i < n; i++) {
            // Buy on the first day and sell on the current day
            int profit1 = prices[i] - prices[0];

            // Find the minimum price from the first day to the current day
            int minPrice = prices[0];
            for (int j = 1; j < i; j++) {
                minPrice = Math.min(minPrice, prices[j]);
            }

            // Buy on the day with the minimum price and sell on the current day
            int profit2 = prices[i] - minPrice;

            // Update the maximum profit
            maxProfit = Math.max(maxProfit, Math.max(profit1, profit2));
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Example usage
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit: " + findMaxProfit(prices)); // Output: 7
    }
}