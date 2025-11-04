class Solution {
    public int rowWithMax1s(int[][] arr) {
        int n = arr.length;    // Number of rows
        int m = arr[0].length; // Number of columns
        
        int maxOnes = 0;
        int maxRowIndex = -1;
        
        for (int i = 0; i < n; i++) {
            // Count number of 1s in this row by finding the first occurrence of 1 using binary search
            int low = 0, high = m - 1;
            int firstOneIndex = m;  // If no 1 found, index stays as m
            
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[i][mid] == 1) {
                    firstOneIndex = mid;
                    high = mid - 1;  // Search left half for earlier 1
                } else {
                    low = mid + 1;
                }
            }
            
            int countOnes = m - firstOneIndex;
            if (countOnes > maxOnes) {
                maxOnes = countOnes;
                maxRowIndex = i;
            }
        }
        
        return maxRowIndex;
    }
}
