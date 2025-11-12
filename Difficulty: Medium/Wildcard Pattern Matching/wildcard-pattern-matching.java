class Solution {
    public boolean wildCard(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        
        // DP table: dp[i][j] = true if txt[0..i-1] matches pat[0..j-1]
        boolean[][] dp = new boolean[n+1][m+1];
        
        // Empty pattern matches empty text
        dp[0][0] = true;
        
        // '*' can match empty text, so fill first row accordingly
        for (int j = 1; j <= m; j++) {
            if (pat.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pat.charAt(j-1) == txt.charAt(i-1) || pat.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (pat.charAt(j-1) == '*') {
                    // '*' matches zero (dp[i][j-1]) or one/more characters (dp[i-1][j])
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[n][m];
    }
}
