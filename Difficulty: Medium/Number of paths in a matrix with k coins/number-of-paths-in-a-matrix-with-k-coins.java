class Solution {
    public int numberOfPath(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        // DP table: dp[i][j][coins] stands for number of ways to reach (i,j) with 'coins' coins collected
        int[][][] dp = new int[n][m][k+1];
        
        // Initialize for the top-left cell
        if (mat[0][0] <= k) {
            dp[0][0][mat[0][0]] = 1;
        }
        
        // Fill DP table
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int coins = 0; coins <= k; coins++) {
                    // Skip for top-left cell (already initialized)
                    if (i == 0 && j == 0) continue;
                    
                    int curr = mat[i][j];
                    if (coins < curr) continue; // Not possible
                    
                    int remaining = coins - curr;
                    
                    // From top
                    if (i > 0) {
                        dp[i][j][coins] += dp[i-1][j][remaining];
                    }
                    // From left
                    if (j > 0) {
                        dp[i][j][coins] += dp[i][j-1][remaining];
                    }
                }
            }
        }
        
        // Answer: number of ways to reach bottom-right with exactly k coins
        return dp[n-1][m-1][k];
    }
}
