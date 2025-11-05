import java.util.ArrayList;

class Solution {
    // Function to remove duplicates from the given sorted array
    ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        if (n == 0) return result;

        // Add the first element as it is unique initially
        result.add(arr[0]);

        // Iterate through the array and add only elements different from the last added
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                result.add(arr[i]);
            }
        }
        
        return result;
    }
}
