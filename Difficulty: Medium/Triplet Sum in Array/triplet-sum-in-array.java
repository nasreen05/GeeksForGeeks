import java.util.Arrays;

class Solution {
    public boolean hasTripletSum(int[] arr, int target) {
        Arrays.sort(arr); // Sorting the array for two-pointer approach
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];

                if (currentSum == target) {
                    return true; // Triplet found
                } else if (currentSum < target) {
                    left++; // Increase sum by moving left pointer to the right
                } else {
                    right--; // Decrease sum by moving right pointer to the left
                }
            }
        }
        return false; // No triplet found
    }
}
