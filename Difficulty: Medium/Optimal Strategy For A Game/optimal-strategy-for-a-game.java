class Solution {
    public int maximumAmount(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        
        // Base case: single coin
        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i];
        }
        
        // Fill dp table for length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                // Option 1: Take arr[i], opponent takes optimal from remaining
                int takeLeft = arr[i];
                if (i + 1 <= j) {
                    takeLeft += Math.min(i + 2 <= j ? dp[i + 2][j] : 0, i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0);
                }
                
                // Option 2: Take arr[j], opponent takes optimal from remaining  
                int takeRight = arr[j];
                if (i <= j - 1) {
                    takeRight += Math.min(i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0, i <= j - 2 ? dp[i][j - 2] : 0);
                }
                
                dp[i][j] = Math.max(takeLeft, takeRight);
            }
        }
        
        return dp[0][n - 1];
    }
}
