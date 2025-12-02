import java.util.*;

public class Solution {
    private static final long INF = Long.MIN_VALUE / 2; // to avoid overflow issues

    public int maxScore(String s, char[][] jumps) {
        int n = s.length();
        int[] ascii = new int[n];
        for (int i = 0; i < n; i++) ascii[i] = s.charAt(i);

        long[] prefixAscii = new long[n + 1];
        for (int i = 0; i < n; i++) prefixAscii[i + 1] = prefixAscii[i] + ascii[i];

        int[][] prefixCount = new int[26][n + 1];
        for (int c = 0; c < 26; c++) {
            for (int i = 0; i < n; i++) {
                prefixCount[c][i + 1] = prefixCount[c][i] + ((s.charAt(i) - 'a' == c) ? 1 : 0);
            }
        }

        boolean[][] canJump = new boolean[26][26];
        for (char[] jump : jumps) {
            canJump[jump[0] - 'a'][jump[1] - 'a'] = true;
        }

        long[] dp = new long[n];
        long[] maxVal = new long[26];
        Arrays.fill(maxVal, INF);

        // Start from the end
        dp[n - 1] = 0;
        int lastChar = s.charAt(n - 1) - 'a';
        maxVal[lastChar] = Math.max(maxVal[lastChar], prefixAscii[n - 1] - (long) prefixCount[lastChar][n - 1] * ('a' + lastChar) + dp[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            long maxScore = 0;
            int curr = s.charAt(i) - 'a';

            // Jump to same character
            if (maxVal[curr] != INF) {
                long scorePart = -prefixAscii[i] + (long) prefixCount[curr][i] * ('a' + curr);
                maxScore = Math.max(maxScore, scorePart + maxVal[curr]);
            }

            // Jump using jump rules
            for (int target = 0; target < 26; target++) {
                if (canJump[curr][target] && maxVal[target] != INF) {
                    long scorePart = -prefixAscii[i] + (long) prefixCount[target][i] * ('a' + target);
                    maxScore = Math.max(maxScore, scorePart + maxVal[target]);
                }
            }

            dp[i] = maxScore;

            // Update maxVal for curr
            long val = prefixAscii[i] - (long) prefixCount[curr][i] * ('a' + curr) + dp[i];
            maxVal[curr] = Math.max(maxVal[curr], val);
        }

        return (int) dp[0];
    }
}