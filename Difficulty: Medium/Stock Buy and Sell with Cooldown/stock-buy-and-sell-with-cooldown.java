class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        // dp[i][0]: max profit at day i, not holding stock
        // dp[i][1]: max profit at day i, holding stock
        int[] dp0 = new int[n + 2]; // Not holding stock
        int[] dp1 = new int[n + 2]; // Holding stock

        // Initialize for future days
        dp0[n] = dp0[n+1] = 0;
        dp1[n] = dp1[n+1] = 0;

        // Bottom-up DP
        for (int i = n - 1; i >= 0; i--) {
            // If not holding stock: max of skipping or buying today
            dp0[i] = Math.max(dp0[i + 1], -arr[i] + dp1[i + 1]);
            // If holding stock: max of skipping or selling today (plus cooldown)
            dp1[i] = Math.max(dp1[i + 1], arr[i] + dp0[i + 2]);
        }
        // Start at day 0 with no stock
        return dp0[0];
    }
}
