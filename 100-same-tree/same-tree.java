class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Dono empty hain
        if (p == null && q == null) {
            return true;
        }

        // Sirf ek empty hai
        if (p == null || q == null) {
            return false;
        }

        // Value different hai
        if (p.val != q.val) {
            return false;
        }

        // Left aur right subtree check karo
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}