import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            String s = sc.next();
            String t = sc.next();
            int n = sc.nextInt();

            char[][] transform = new char[n][2];
            for (int i = 0; i < n; i++) {
                transform[i][0] = sc.next().charAt(0);
                transform[i][1] = sc.next().charAt(0);
            }

            int[] cost = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = sc.nextInt();
            }

            int result = minCost(s, t, transform, cost);
            System.out.println(result);
        }
        sc.close();
    }

    public static int minCost(String s, String t, char[][] transform, int[] cost) {
        int length = s.length();
        int INF = Integer.MAX_VALUE / 2;
        int[][] dp = new int[26][26];

        // Initialize dp matrix
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }

        // Fill direct transformation costs
        for (int i = 0; i < transform.length; i++) {
            int from = transform[i][0] - 'a';
            int to = transform[i][1] - 'a';
            dp[from][to] = Math.min(dp[from][to], cost[i]);
        }

        // Floyd-Warshall to get min costs for all pairs
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }

        int totalCost = 0;
        for (int i = 0; i < length; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (c1 == c2) continue;

            int from = c1 - 'a';
            int to = c2 - 'a';
            int minPairCost = INF;

            // Try all possible intermediate characters as meeting point
            for (int mid = 0; mid < 26; mid++) {
                int cost1 = dp[from][mid];
                int cost2 = dp[to][mid];
                if (cost1 == INF || cost2 == INF) continue;
                minPairCost = Math.min(minPairCost, cost1 + cost2);
            }

            if (minPairCost == INF) return -1;
            totalCost += minPairCost;
            if (totalCost < 0) return -1; // overflow safety
        }

        return totalCost;
    }
}
