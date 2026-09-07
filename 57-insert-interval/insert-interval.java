import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {

            // Current interval newInterval se pehle hai
            if (interval[1] < newInterval[0]) {
                ans.add(interval);
            }

            // Current interval newInterval ke baad hai
            else if (interval[0] > newInterval[1]) {
                ans.add(newInterval);
                newInterval = interval;
            }

            // Overlap
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        // Last newInterval add karo
        ans.add(newInterval);

        return ans.toArray(new int[ans.size()][]);
    }
}