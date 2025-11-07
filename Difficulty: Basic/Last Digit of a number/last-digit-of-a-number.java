class Solution {
    public int lastDigit(int n) {
        // Return the last digit of the absolute value of n
        return Math.abs(n) % 10;
    }
}
