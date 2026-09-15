class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] need = new int[128];
        int[] window = new int[128];

        // Frequency of characters in t
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int count = 0;

        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            window[c]++;

            // Required character satisfy hua
            if (window[c] <= need[c]) {
                count++;
            }

            // Window valid hai
            while (count == t.length()) {

                // Minimum window update
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Left character remove karo
                char leftChar = s.charAt(left);
                window[leftChar]--;

                if (window[leftChar] < need[leftChar]) {
                    count--;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}