class Solution {

    int[][][] dp;

    public boolean isScramble(String s1, String s2) {

        int n = s1.length();

        dp = new int[n][n][n + 1];

        // -1 means not calculated yet
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(s1, s2, 0, 0, n);
    }


    private boolean solve(String s1, String s2,
                          int i, int j, int len) {

        // Already calculated
        if (dp[i][j][len] != -1) {
            return dp[i][j][len] == 1;
        }

        // Same substring
        if (s1.regionMatches(i, s2, j, len)) {
            dp[i][j][len] = 1;
            return true;
        }

        // Character frequency check
        int[] count = new int[26];

        for (int k = 0; k < len; k++) {
            count[s1.charAt(i + k) - 'a']++;
            count[s2.charAt(j + k) - 'a']--;
        }

        for (int x : count) {
            if (x != 0) {
                dp[i][j][len] = 0;
                return false;
            }
        }

        // Try every split
        for (int cut = 1; cut < len; cut++) {

            // Case 1: No swap
            boolean noSwap =
                solve(s1, s2, i, j, cut)
                &&
                solve(s1, s2, i + cut, j + cut, len - cut);

            if (noSwap) {
                dp[i][j][len] = 1;
                return true;
            }


            // Case 2: Swap
            boolean swap =
                solve(s1, s2, i, j + len - cut, cut)
                &&
                solve(s1, s2, i + cut, j, len - cut);

            if (swap) {
                dp[i][j][len] = 1;
                return true;
            }
        }

        dp[i][j][len] = 0;
        return false;
    }
}