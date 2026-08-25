class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            int j = 0;
            int len = Math.min(prefix.length(), strs[i].length());

            while (j < len && prefix.charAt(j) == strs[i].charAt(j)) {
                j++;
            }

            prefix = prefix.substring(0, j);

            if (prefix.length() == 0) {
                return "";
            }
        }

        return prefix;
    }
}