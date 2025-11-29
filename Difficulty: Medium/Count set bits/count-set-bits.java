class Solution {
    public static int countSetBits(int n) {
        if (n == 0) return 0;
        
        int x = 31 - Integer.numberOfLeadingZeros(n);
        
       
        int fullBits = x * (1 << (x - 1));
        
       
        int msbBits = n - (1 << x) + 1;
        
       
        int remaining = n - (1 << x);
        int remainingBits = countSetBits(remaining);
        
        return fullBits + msbBits + remainingBits;
    }
}
