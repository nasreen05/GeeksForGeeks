import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        ArrayList<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        
        // Directions represent right, down, left, up movements
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        int r = 0, c = 0, direction = 0;
        
        for (int i = 0; i < m * n; i++) {
            result.add(mat[r][c]);
            visited[r][c] = true;
            
            int newR = r + dr[direction];
            int newC = c + dc[direction];
            
            // Check whether next cell is valid and not visited
            if (newR >= 0 && newR < m && newC >= 0 && newC < n && !visited[newR][newC]) {
                r = newR;
                c = newC;
            } else {
                // Change direction clockwise
                direction = (direction + 1) % 4;
                r += dr[direction];
                c += dc[direction];
            }
        }
        
        return result;
    }
}
