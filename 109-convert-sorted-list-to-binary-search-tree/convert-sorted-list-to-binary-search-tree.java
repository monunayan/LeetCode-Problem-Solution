class Solution {

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }

        // Only one node
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // Find middle node
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Break left half
        prev.next = null;

        // slow is middle
        TreeNode root = new TreeNode(slow.val);

        // Left half
        root.left = sortedListToBST(head);

        // Right half
        root.right = sortedListToBST(slow.next);

        return root;
    }
}