class Solution {
    // Function to find the first occurrence of target
    private int firstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int first = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                first = mid;
                high = mid - 1; // move left to find earlier occurrence
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }
    
    // Function to find the last occurrence of target
    private int lastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int last = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                last = mid;
                low = mid + 1; // move right to find later occurrence
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }
    
    int countFreq(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        if (first == -1) return 0; // target not found
        int last = lastOccurrence(arr, target);
        return last - first + 1;
    }
}
