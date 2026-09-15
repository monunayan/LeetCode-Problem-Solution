class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        backtrack(nums, 0, new ArrayList<>());

        return ans;
    }

    void backtrack(int[] nums, int start, List<Integer> path) {

        // Current path itself is a valid subset
        ans.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {

            // Choose
            path.add(nums[i]);

            // Explore
            backtrack(nums, i + 1, path);

            // Undo
            path.remove(path.size() - 1);
        }
    }
}