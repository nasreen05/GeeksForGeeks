import java.util.Arrays;

class Solution {
    public void rearrange(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);  // Step 1: Sort the array
        
        int maxIdx = n - 1; // index of maximum element
        int minIdx = 0;     // index of minimum element
        int maxElem = arr[maxIdx] + 1; // element > max in array
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // Place maximum element at even indices
                arr[i] += (arr[maxIdx] % maxElem) * maxElem;
                maxIdx--;
            } else {
                // Place minimum element at odd indices
                arr[i] += (arr[minIdx] % maxElem) * maxElem;
                minIdx++;
            }
        }
        
        // Decode values by dividing by maxElem
        for (int i = 0; i < n; i++) {
            arr[i] /= maxElem;
        }
    }
}
