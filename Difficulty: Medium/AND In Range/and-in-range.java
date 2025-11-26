class Solution {
    public int andInRange(int l, int r) {
        int shift = 0;
        // Find the common prefix by right-shifting both l and r
        while (l != r) {
            l >>= 1;
            r >>= 1;
            shift++;
        }
        // Shift the common prefix back to the left
        return l << shift;
    }
}
