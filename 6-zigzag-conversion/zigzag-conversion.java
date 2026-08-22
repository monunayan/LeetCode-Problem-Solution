class Solution {
    public String convert(String s, int numRows) {

        int n = s.length();

        if (numRows == 1 || numRows >= n) {
            return s;
        }

        StringBuilder result = new StringBuilder(n);

        int cycle = 2 * numRows - 2;

        for (int row = 0; row < numRows; row++) {

            for (int i = row; i < n; i += cycle) {

                result.append(s.charAt(i));

                // Middle rows have an additional character
                int diagonal = i + cycle - 2 * row;

                if (row != 0 &&
                    row != numRows - 1 &&
                    diagonal < n) {

                    result.append(s.charAt(diagonal));
                }
            }
        }

        return result.toString();
    }
}