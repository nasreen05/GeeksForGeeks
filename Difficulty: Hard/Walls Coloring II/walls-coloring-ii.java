class Solution {
    int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;

        int k = costs[0].length;
        if (k == 0) return -1;

        // If only 1 color and more than 1 wall → impossible
        if (k == 1 && n > 1) return -1;

        // DP Array replacement using min tracking
        int min1, min2, idx1;

        min1 = min2 = Integer.MAX_VALUE;
        idx1 = -1;

        // Initialize first row
        for (int j = 0; j < k; j++) {
            if (costs[0][j] < min1) {
                min2 = min1;
                min1 = costs[0][j];
                idx1 = j;
            } else if (costs[0][j] < min2) {
                min2 = costs[0][j];
            }
        }

        // Process the rest of the walls
        for (int i = 1; i < n; i++) {
            int newMin1 = Integer.MAX_VALUE;
            int newMin2 = Integer.MAX_VALUE;
            int newIdx1 = -1;

            for (int j = 0; j < k; j++) {

                // if previous min1 has same color index -> use min2
                int cost = costs[i][j] + (j == idx1 ? min2 : min1);

                if (cost < newMin1) {
                    newMin2 = newMin1;
                    newMin1 = cost;
                    newIdx1 = j;
                } else if (cost < newMin2) {
                    newMin2 = cost;
                }
            }

            min1 = newMin1;
            min2 = newMin2;
            idx1 = newIdx1;
        }

        return min1;
    }
}
