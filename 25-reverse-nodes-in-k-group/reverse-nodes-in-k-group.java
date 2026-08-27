class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            // Check k nodes
            ListNode kth = groupPrev;

            for (int i = 0; i < k; i++) {
                kth = kth.next;
                if (kth == null) return dummy.next;
            }

            ListNode groupNext = kth.next;

            // Reverse
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect
            ListNode oldStart = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = oldStart;
        }
    }
}