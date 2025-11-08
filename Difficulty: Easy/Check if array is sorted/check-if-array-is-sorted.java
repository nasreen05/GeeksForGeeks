class Solution {
    public boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false; // Found an element less than previous, not sorted
            }
        }
        return true; // No such element found, array is sorted
    }
}
