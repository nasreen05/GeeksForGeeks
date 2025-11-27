class Solution {
    int subsetXORSum(int arr[]) {
        int n = arr.length;
        int result = 0;
        // For each bit position (0-10 because arr[i] ≤ 10^3)
        for (int bit = 0; bit <= 10; bit++) {
            int bitValue = 1 << bit;
            int countOnes = 0;
            for (int num : arr) {
                if ((num & bitValue) != 0) {
                    countOnes++;
                }
            }
            // If this bit is set in at least one element,
            // it will contribute to 2^(n-1) subsets' XOR sums
            if (countOnes > 0) {
                result += bitValue * (1 << (n - 1));
            }
        }
        return result;
    }
}
