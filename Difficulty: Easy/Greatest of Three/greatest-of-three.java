class Solution {
    public static int find_greatest_number(int a, int b, int c) {
        if (a >= b) {
            if (a >= c) {
                return a;
            }
            return c;
        } else {
            if (b >= c) {
                return b;
            }
            return c;
        }
    }
}
