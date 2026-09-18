class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;

        while (curr != null && curr.next != null) {

            if (curr.val == curr.next.val) {

                // Remove duplicate node
                curr.next = curr.next.next;

            } else {

                // Move forward
                curr = curr.next;
            }
        }

        return head;
    }
}