class Solution {

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = height(root.left);

        // Left subtree unbalanced
        if (left == -1) {
            return -1;
        }

        int right = height(root.right);

        // Right subtree unbalanced
        if (right == -1) {
            return -1;
        }

        // Current node unbalanced
        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
