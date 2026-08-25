class Solution {
    public int maxArea(int[] height) {

        int l = 0;
        int r = height.length - 1;
        int max = 0;

        while (l < r) {

            int hl = height[l];
            int hr = height[r];

            int area;

            if (hl < hr) {
                area = hl * (r - l);
                l++;
            } else {
                area = hr * (r - l);
                r--;
            }

            if (area > max) {
                max = area;
            }
        }

        return max;
    }
}