class Solution {
    public static String utility(int n) {
        // If the number of apples is odd, "You" win; otherwise "Friend" wins
        if (n % 2 == 1) {
            return "You";
        } else {
            return "Friend";
        }
    }
}
