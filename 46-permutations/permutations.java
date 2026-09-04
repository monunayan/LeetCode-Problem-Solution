class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(nums, 0, ans);

        return ans;
    }

    private void backtrack(int[] nums, int index,
                            List<List<Integer>> ans) {

        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();

            for (int x : nums)
                list.add(x);

            ans.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {

            // swap
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;

            backtrack(nums, index + 1, ans);

            // backtrack: original arrangement wapas
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }
}