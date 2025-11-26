class Solution {
    public static void triangle(int s) {
        for (int i = 1; i <= s; i++) {
            if (i == 1) {
                // First row, print a single '*'
                System.out.println("*");
            } else if (i == s) {
                // Last row, print stars separated by single spaces
                for (int j = 1; j <= s; j++) {
                    System.out.print("* ");
                }
                System.out.println(); // New line after last row
            } else {
                // Middle rows: star, spaces, star
                System.out.print("*");
                // Print spaces between stars (2 * (i - 2) + 1 spaces)
                for (int space = 1; space <= 2 * (i - 2) + 1; space++) {
                    System.out.print(" ");
                }
                System.out.println("*"); // End of row star and new line
            }
        }
    }
}
