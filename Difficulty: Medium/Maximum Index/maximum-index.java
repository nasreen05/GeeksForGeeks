class Solution {
    int maxIndexDiff(int[] arr) {
        int n = arr.length;

        int[] LMin = new int[n];
        int[] RMax = new int[n];

        LMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            LMin[i] = Math.min(arr[i], LMin[i - 1]);
        }

        RMax[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            RMax[j] = Math.max(arr[j], RMax[j + 1]);
        }

        int i = 0, j = 0, maxDiff = 0;
        while (i < n && j < n) {
            if (LMin[i] <= RMax[j]) {  // Allow equals, change comparison here if problem requires
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }
        return maxDiff;
    }
}
