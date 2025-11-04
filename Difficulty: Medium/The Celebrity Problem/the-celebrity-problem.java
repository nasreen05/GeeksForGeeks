class Solution {
    public int celebrity(int[][] mat) {
        int n = mat.length;
        int a = 0, b = n - 1;

        // Step 1: Find the celebrity candidate
        while (a < b) {
            if (mat[a][b] == 1) { // a knows b, so a can't be celebrity
                a++;
            } else { // a doesn't know b, so b can't be celebrity
                b--;
            }
        }
        int candidate = a;

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // candidate should not know i and i should know candidate
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }
        return candidate;
    }
}
