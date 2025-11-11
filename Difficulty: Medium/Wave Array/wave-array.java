class Solution {
    public void sortInWave(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i += 2) {
            // Swap adjacent elements
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
