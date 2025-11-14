class Solution {
    int minDist(int arr[], int x, int y) {
        int minDist = Integer.MAX_VALUE;
        int prev = -1; // stores index of last seen x or y
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x || arr[i] == y) {
                if (prev != -1 && arr[i] != arr[prev]) {
                    minDist = Math.min(minDist, i - prev);
                }
                prev = i;
            }
        }
        return (minDist == Integer.MAX_VALUE) ? -1 : minDist;
    }
}
