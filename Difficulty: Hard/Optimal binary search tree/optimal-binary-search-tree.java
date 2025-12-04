class Solution {
    public int minCost(int[] keys, int[] freq) {
        int n = keys.length;
        
        // Create 2D DP table - dp[i][j] = min cost for keys[i..j]
        int[][] dp = new int[n][n];
        
        // Base case: single node cost is its frequency (level 1)
        for (int i = 0; i < n; i++) {
            dp[i][i] = freq[i];
        }
        
        // Fill dp table for chains of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;  // end index
                
                // Initialize with max value
                dp[i][j] = Integer.MAX_VALUE;
                
                // Calculate sum of frequencies in range [i..j]
                int fsum = 0;
                for (int k = i; k <= j; k++) {
                    fsum += freq[k];
                }
                
                // Try every key in [i..j] as root
                for (int r = i; r <= j; r++) {
                    // Cost = left subtree cost + right subtree cost + freq sum
                    int leftCost = (r > i) ? dp[i][r - 1] : 0;
                    int rightCost = (r < j) ? dp[r + 1][j] : 0;
                    int totalCost = leftCost + rightCost + fsum;
                    
                    // Update minimum cost
                    if (totalCost < dp[i][j]) {
                        dp[i][j] = totalCost;
                    }
                }
            }
        }
        
        return dp[0][n - 1];  // Minimum cost for all keys
    }
}
