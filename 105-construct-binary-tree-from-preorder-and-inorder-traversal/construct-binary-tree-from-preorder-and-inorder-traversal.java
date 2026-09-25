class Solution {

    private int preIndex = 0;
    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Inorder ke value -> index store karo
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        if (left > right) {
            return null;
        }

        // Preorder ka current element root hai
        int value = preorder[preIndex++];

        TreeNode root = new TreeNode(value);

        // Inorder mein root ki position
        int index = map.get(value);

        // Pehle LEFT subtree
        root.left = build(preorder, left, index - 1);

        // Phir RIGHT subtree
        root.right = build(preorder, index + 1, right);

        return root;
    }
}