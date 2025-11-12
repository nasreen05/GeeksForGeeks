class Solution {
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        
        int prev2 = arr[0]; // max loot up to two houses ago
        int prev1 = Math.max(arr[0], arr[1]); // max loot up to one house ago
        
        for (int i = 2; i < n; i++) {
            int current = Math.max(prev1, prev2 + arr[i]);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}
