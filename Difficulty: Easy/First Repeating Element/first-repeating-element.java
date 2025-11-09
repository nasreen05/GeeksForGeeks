import java.util.HashSet;

class Solution {
    public static int firstRepeated(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int minIndex = Integer.MAX_VALUE;

        // Traverse from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            if (set.contains(arr[i])) {
                minIndex = i;
            } else {
                set.add(arr[i]);
            }
        }

        return (minIndex == Integer.MAX_VALUE) ? -1 : minIndex + 1; // convert 0-based to 1-based
    }
}
