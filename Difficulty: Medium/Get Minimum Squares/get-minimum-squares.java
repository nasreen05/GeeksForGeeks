class Solution {
    public int minSquares(int n) {
        int[] dp = new int[n + 1];
        // Fill dp array with large values
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // maximum squares needed is i (all 1s)
            for (int j = 1; j * j <= i; j++) {
                int sq = j * j;
                if (sq <= i) {
                    dp[i] = Math.min(dp[i], dp[i - sq] + 1);
                }
            }
        }
        return dp[n];
    }
}
