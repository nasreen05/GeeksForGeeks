class Solution {
    public void rotate(int[] arr) {
        int n = arr.length;
        if (n <= 1) return; // No rotation needed for empty or single element array

        int last = arr[n - 1];
        // Shift all elements one position to the right
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        // Place last element at the front
        arr[0] = last;
    }
}
