class Solution {
    public int findKRotation(int[] arr) {
        int low = 0, high = arr.length - 1;
        
        while (low <= high) {
            if (arr[low] <= arr[high]) {
                // Array is already sorted in this range
                return low;
            }
            
            int mid = low + (high - low) / 2;
            int next = (mid + 1) % arr.length;
            int prev = (mid - 1 + arr.length) % arr.length;
            
            // Check if mid is minimum element
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            }
            
            if (arr[mid] >= arr[low]) {
                // Left half is sorted, move right
                low = mid + 1;
            } else {
                // Right half is sorted, move left
                high = mid - 1;
            }
        }
        
        return 0; // No rotation
    }
}
