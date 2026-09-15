class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        backtrack(1, n, k, new ArrayList<>());

        return ans;
    }

    void backtrack(int start, int n, int k, List<Integer> path) {

        // k numbers choose ho gaye
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {

            // choose
            path.add(i);

            // explore
            backtrack(i + 1, n, k, path);

            // undo
            path.remove(path.size() - 1);
        }
    }
}