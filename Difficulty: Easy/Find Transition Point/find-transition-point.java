class Solution {
    int transitionPoint(int arr[]) {
        int n = arr.length;
        
        // If no 1 present, return -1
        boolean hasOne = false;
        boolean hasZero = false;
        for (int val : arr) {
            if (val == 1) hasOne = true;
            if (val == 0) hasZero = true;
        }
        if (!hasOne) return -1;
        if (!hasZero) return 0;
        
        int low = 0, high = n - 1;
        int result = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == 1) {
                result = mid;
                high = mid - 1;  // Try to find earlier 1
            } else {
                low = mid + 1;
            }
        }
        
        return result;
    }
}
