class Solution {
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int mod = 1000000007; // To avoid overflow
        
        int[][] dp = new int[n + 1][target + 1];
        
        // There is always one subset (empty set) for sum=0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= target; sum++) {
                if (nums[i - 1] <= sum) {
                    dp[i][sum] = (dp[i - 1][sum] + dp[i - 1][sum - nums[i - 1]]) % mod;
                } else {
                    dp[i][sum] = dp[i - 1][sum];
                }
            }
        }
        
        return dp[n][target];
    }
}
