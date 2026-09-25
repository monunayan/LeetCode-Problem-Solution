class Solution {

    private int postIndex;
    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        // Inorder: value -> index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder,
                           int left, int right) {

        if (left > right) {
            return null;
        }

        // Postorder ka LAST element = Root
        int value = postorder[postIndex--];

        TreeNode root = new TreeNode(value);

        int index = map.get(value);

        // IMPORTANT:
        // Postorder reverse karne par Root -> Right -> Left
        // isliye pehle RIGHT banana hai
        root.right = build(inorder, postorder,
                           index + 1, right);

        root.left = build(inorder, postorder,
                          left, index - 1);

        return root;
    }
}