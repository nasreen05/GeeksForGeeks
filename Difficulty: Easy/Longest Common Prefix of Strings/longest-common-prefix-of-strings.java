class Solution {
    public String longestCommonPrefix(String arr[]) {
        if (arr == null || arr.length == 0) return "";

        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // Reduce prefix length until it matches the current string's prefix
            while (arr[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
