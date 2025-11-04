class Solution {
    int minCost(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        dp[0] = 0; // Starting at the first stair with zero cost
        
        for (int i = 1; i < n; i++) {
            int costOneStep = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
            int costTwoSteps = i > 1 ? dp[i - 2] + Math.abs(height[i] - height[i - 2]) : Integer.MAX_VALUE;
            dp[i] = Math.min(costOneStep, costTwoSteps);
        }
        
        return dp[n - 1]; // Minimum cost to reach the last stair
    }
}
