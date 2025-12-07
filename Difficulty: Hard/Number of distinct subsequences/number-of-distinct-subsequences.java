class Solution {
    int distinctSubseq(String str) {
        int n = str.length();
        final int MOD = 1000000007;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        int[] last = new int[26];
        java.util.Arrays.fill(last, -1);
        
        for (int i = 1; i <= n; i++) {
            dp[i] = (int) ((2L * dp[i - 1]) % MOD);
            
            int charIndex = str.charAt(i - 1) - 'a';
            if (last[charIndex] != -1) {
                dp[i] = (int) ((dp[i] - (long)dp[last[charIndex]] + MOD) % MOD);
            }
            
            last[charIndex] = i - 1;  // 0-based index for dp array
        }
        
        // CRITICAL: Platform includes EMPTY subsequence!
        return dp[n];  // Return 16 for "iduy" (includes "")
    }
}
