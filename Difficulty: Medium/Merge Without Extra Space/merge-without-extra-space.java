class Solution {
    
    // Helper function to calculate next gap
    private int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }
    
    public void mergeArrays(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int gap = n + m;
        
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            int i = 0, j = gap;
            
            while (j < (n + m)) {
                if (j < n && a[i] > a[j]) {
                    // Both pointers in first array
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                } else if (j >= n && i < n && a[i] > b[j - n]) {
                    // i in first array, j in second array
                    int temp = a[i];
                    a[i] = b[j - n];
                    b[j - n] = temp;
                } else if (j >= n && i >= n && b[i - n] > b[j - n]) {
                    // Both pointers in second array
                    int temp = b[i - n];
                    b[i - n] = b[j - n];
                    b[j - n] = temp;
                }
                i++;
                j++;
            }
        }
    }
}
