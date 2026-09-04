class Solution {
    public boolean isMatch(String s, String p) {

        int i = 0, j = 0;
        int star = -1;
        int match = 0;

        while (i < s.length()) {

            // Normal character ya '?'
            if (j < p.length() &&
                (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            }

            // '*' mila
            else if (j < p.length() && p.charAt(j) == '*') {
                star = j;
                match = i;
                j++;
            }

            // Mismatch hua, lekin pehle '*' mila tha
            else if (star != -1) {
                j = star + 1;
                match++;
                i = match;
            }

            else {
                return false;
            }
        }

        // Bache hue pattern mein sirf '*' hone chahiye
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}