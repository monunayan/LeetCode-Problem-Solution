class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> path, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (candidates[i] > target)
                continue;

            path.add(candidates[i]);

            // i hi rahega → same number dobara use ho sakta hai
            backtrack(candidates, target - candidates[i], i, path, ans);

            path.remove(path.size() - 1);
        }
    }
}