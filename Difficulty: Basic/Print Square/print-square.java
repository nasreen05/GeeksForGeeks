class Solution {
    public void square(int s) {
        // Top border: print s asterisks with space between
        for (int i = 0; i < s; i++) {
            System.out.print("* ");
        }
        System.out.println();
        
        // Middle rows: first * , spaces, last *
        for (int i = 1; i < s - 1; i++) {
            System.out.print("* ");
            // Print (s-2) double spaces for hollow interior
            for (int j = 1; j < s - 1; j++) {
                System.out.print("  ");
            }
            System.out.println("*");
        }
        
        // Bottom border (only if s > 1)
        if (s > 1) {
            for (int i = 0; i < s; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
