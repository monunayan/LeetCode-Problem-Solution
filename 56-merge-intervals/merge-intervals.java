import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1)
            return intervals;

        // Start ke according sort
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= end) {
                // Overlap -> merge
                end = Math.max(end, intervals[i][1]);
            } else {
                // Overlap nahi -> purana interval add
                ans.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Last interval
        ans.add(new int[]{start, end});

        return ans.toArray(new int[ans.size()][]);
    }
}