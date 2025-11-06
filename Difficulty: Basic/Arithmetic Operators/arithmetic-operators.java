class Solution {
    public int[] computeOperations(int x, int y) {
        int p = x + y;  // Addition
        int q = x - y;  // Subtraction
        int r = x * y;  // Multiplication
        
        // For division and modulo, handle division by zero to avoid runtime errors.
        int s = 0;
        int t = 0;
        if (y != 0) {
            s = x / y;  // Division
            t = x % y;  // Modulo
        }
        
        return new int[]{p, q, r, s, t};
    }
}
