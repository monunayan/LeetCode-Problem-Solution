class Solution {

    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {

        List<TreeNode> result = new ArrayList<>();

        // No node
        if (start > end) {
            result.add(null);
            return result;
        }

        // Every value can be root
        for (int root = start; root <= end; root++) {

            // Generate all possible left subtrees
            List<TreeNode> leftTrees = generate(start, root - 1);

            // Generate all possible right subtrees
            List<TreeNode> rightTrees = generate(root + 1, end);

            // Combine every left tree with every right tree
            for (TreeNode left : leftTrees) {

                for (TreeNode right : rightTrees) {

                    TreeNode node = new TreeNode(root);

                    node.left = left;
                    node.right = right;

                    result.add(node);
                }
            }
        }

        return result;
    }
}