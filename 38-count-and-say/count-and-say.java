class Solution {
    public String countAndSay(int n) {

        String s = "1";

        while (--n > 0) {
            StringBuilder sb = new StringBuilder(s.length() * 2);

            for (int i = 0; i < s.length();) {

                int j = i + 1;

                while (j < s.length() && s.charAt(j) == s.charAt(i))
                    j++;

                sb.append(j - i).append(s.charAt(i));
                i = j;
            }

            s = sb.toString();
        }

        return s;
    }
}