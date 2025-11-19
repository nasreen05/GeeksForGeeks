import java.util.*;

class Solution {
    private final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int minCostPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] effort = new int[n][m];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        pq.offer(new int[]{0, 0, 0}); // effort, x, y
        effort[0][0] = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], x = curr[1], y = curr[2];
            if (x == n - 1 && y == m - 1) return cost;
            
            for (int[] d : DIRS) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int newEffort = Math.max(cost, Math.abs(mat[x][y] - mat[nx][ny]));
                    if (newEffort < effort[nx][ny]) {
                        effort[nx][ny] = newEffort;
                        pq.offer(new int[]{newEffort, nx, ny});
                    }
                }
            }
        }
        return 0; 
    }
}
