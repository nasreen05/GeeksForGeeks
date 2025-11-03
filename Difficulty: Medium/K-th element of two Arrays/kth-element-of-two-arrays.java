class Solution {
    public int kthElement(int[] a, int[] b, int k) {
        int n = a.length, m = b.length;
        // Ensure a is the smaller array
        if (n > m) {
            return kthElement(b, a, k);
        }
        
        int left = Math.max(0, k - m), right = Math.min(k, n);
        while (left <= right) {
            int midA = (left + right) / 2;
            int midB = k - midA;

            int leftA = (midA == 0) ? Integer.MIN_VALUE : a[midA - 1];
            int leftB = (midB == 0) ? Integer.MIN_VALUE : b[midB - 1];
            int rightA = (midA == n) ? Integer.MAX_VALUE : a[midA];
            int rightB = (midB == m) ? Integer.MAX_VALUE : b[midB];

            if (leftA <= rightB && leftB <= rightA) {
                return Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                right = midA - 1;
            } else {
                left = midA + 1;
            }
        }
        return -1; // should never be reached if inputs are valid
    }
}
