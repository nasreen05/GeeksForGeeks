class Solution {
    public static void utility(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        System.out.print(result.toString());
    }
}
