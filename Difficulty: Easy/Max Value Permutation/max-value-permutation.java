class Solution {
    int maxValue(int arr[]) {
        int MOD = 1000000007;
        int n = arr.length;
        
        // Sort the array
        java.util.Arrays.sort(arr);
        
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (long)arr[i] * i;
            result %= MOD;  // modulo after each addition to keep it in range
        }
        
        return (int)result;
    }
}
