class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;

        // If it's impossible to end up with exactly 1 pile
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }

        // Prefix sum for range sum queries
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        // dp[i][j] -> min cost to merge stones[i...j] into (tbd) piles
        int[][] dp = new int[n][n];

        // Initialize dp with large values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 0;
            }
        }

        // l = length of interval
        for (int len = k; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // We merge in steps of k-1
                for (int mid = i; mid < j; mid += (k - 1)) {
                    if (dp[i][mid] == Integer.MAX_VALUE || dp[mid + 1][j] == Integer.MAX_VALUE) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);
                }

                // If this segment can be merged into 1 pile
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += prefix[j + 1] - prefix[i];
                }
            }
        }

        return dp[0][n - 1];
    }
}