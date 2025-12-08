class Solution {
    public String matrixChainOrder(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] bracket = new int[n][n];

        // dp[i][i] = 0 cost since a single matrix requires no multiplication
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + arr[i-1] * arr[k] * arr[j];

                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        bracket[i][j] = k;
                    }
                }
            }
        }

        return printOrder(bracket, 1, n - 1);
    }

    private String printOrder(int[][] bracket, int i, int j) {
        if (i == j) {
            return String.valueOf((char)('A' + i - 1));
        }

        return "(" +
                printOrder(bracket, i, bracket[i][j]) +
                printOrder(bracket, bracket[i][j] + 1, j) +
                ")";
    }
}
