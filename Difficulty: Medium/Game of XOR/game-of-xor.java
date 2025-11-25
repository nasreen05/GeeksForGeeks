class Solution {
    public int subarrayXor(int[] arr) {
        int n = arr.length;
        int ans = 0;

        // If length is even, result is 0 directly
        if (n % 2 == 0) {
            return 0;
        }

        // If length is odd, XOR all elements at even indices
        for (int i = 0; i < n; i += 2) {
            ans ^= arr[i];
        }

        return ans;
    }
}
