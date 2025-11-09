class Solution {
    public int chocolatePickup(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        // dp[i1][j1][j2] stores max chocolates when robot1 is at (i1, j1) and robot2 at (i2, j2)
        int[][][] dp = new int[n][m][m];

        // Initialize all values to -1 (impossible)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        // Base case: both robots at (n-1, n-1)
        if (mat[n-1][n-1] != -1) {
            dp[n-1][n-1][n-1] = mat[n-1][n-1];
        }

        // Fill dp table from bottom-right to top-left
        for (int i1 = n-1; i1 >= 0; i1--) {
            for (int j1 = m-1; j1 >= 0; j1--) {
                for (int j2 = m-1; j2 >= 0; j2--) {
                    if (i1 == n-1 && j1 == m-1 && j2 == m-1) continue;

                    int i2 = i1 + j1 - j2; // Since both robots move same steps, i2 is determined
                    if (i2 < 0 || i2 >= n || mat[i1][j1] == -1 || mat[i2][j2] == -1) {
                        dp[i1][j1][j2] = -1;
                        continue;
                    }

                    int ans = -1;
                    int[][] dir = {{1, 0}, {0, 1}}; // Down and Right

                    for (int[] d1 : dir) {
                        for (int[] d2 : dir) {
                            int ni1 = i1 + d1[0], nj1 = j1 + d1[1];
                            int ni2 = i2 + d2[0], nj2 = j2 + d2[1];

                            if (ni1 < n && ni2 < n && nj1 < m && nj2 < m && dp[ni1][nj1][nj2] != -1) {
                                ans = Math.max(ans, dp[ni1][nj1][nj2]);
                            }
                        }
                    }

                    if (ans == -1) {
                        dp[i1][j1][j2] = -1;
                    } else {
                        ans += mat[i1][j1];
                        if (i1 != i2 || j1 != j2) { // If robots are not at same cell
                            ans += mat[i2][j2];
                        }
                        dp[i1][j1][j2] = ans;
                    }
                }
            }
        }

        return Math.max(0, dp[0][0][0]);
    }
}
