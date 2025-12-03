class Solution {
    public int tsp(int[][] cost) {
        int n = cost.length;
        int INF = Integer.MAX_VALUE / 2;
        int FULL = 1 << n;
        int[][] dp = new int[FULL][n];
        
        // Initialize DP table with infinity
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        
        // Start from city 0 with mask = 1 (only city 0 visited)
        dp[1][0] = 0;
        
        // Fill DP table bottom-up
        for (int mask = 0; mask < FULL; mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0 || dp[mask][i] == INF) {
                    continue;
                }
                
                // Try going to every unvisited city j
                for (int j = 0; j < n; j++) {
                    if ((mask & (1 << j)) == 0) {
                        int nextMask = mask | (1 << j);
                        dp[nextMask][j] = Math.min(dp[nextMask][j], 
                                                  dp[mask][i] + cost[i][j]);
                    }
                }
            }
        }
        
        // Find minimum cost to return to city 0 from any final state
        int fullMask = FULL - 1;
        int result = INF;
        for (int i = 0; i < n; i++) {
            if (dp[fullMask][i] != INF) {
                result = Math.min(result, dp[fullMask][i] + cost[i][0]);
            }
        }
        
        return result;
    }
}
