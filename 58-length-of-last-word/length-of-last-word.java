class Solution {
    public int lengthOfLastWord(String s) {

        int i = s.length() - 1;

        // End ke spaces skip karo
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        int count = 0;

        // Last word count karo
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }
}