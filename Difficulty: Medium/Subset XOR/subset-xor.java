class Solution {
    public static ArrayList<Integer> subsetXOR(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (n == 1) {
            ans.add(1);
            return ans;
        }

        int xr = 0;
        for (int i = 1; i <= n; i++) xr ^= i;

        if (xr == n) {            // case 1: perfect match
            for (int i = 1; i <= n; i++) ans.add(i);
            return ans;
        }

        int missing = xr ^ n;     // element to remove

        if (missing >= 1 && missing <= n) { // case 2: remove one element
            for (int i = 1; i <= n; i++) {
                if (i != missing) ans.add(i);
            }
            return ans;
        }

        // case 3: need to remove two numbers whose XOR = n
        // smallest lexicographic pair = (1, n-1)
        for (int i = 1; i <= n; i++) {
            if (i != 1 && i != n - 1) ans.add(i);
        }

        return ans;
    }
}
