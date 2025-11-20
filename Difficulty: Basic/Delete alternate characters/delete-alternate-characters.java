class Solution {
    static String delAlternate(String S) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < S.length(); i += 2) {
            result.append(S.charAt(i));
        }
        return result.toString();
    }
}
