class Solution {
    static String conRevstr(String S1, String S2) {
        String concatenated = S1 + S2;
        StringBuilder sb = new StringBuilder(concatenated);
        sb.reverse();
        return sb.toString();
    }
}
