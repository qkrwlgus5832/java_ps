public class RemoveNthNodeFromEndofList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode tmp = head;
            int count = 1;

            while (true) {
                if (tmp.next != null) {
                    tmp = tmp.next;
                    count++;
                } else {
                    break;
                }
            }

            ListNode previous = head;
            ListNode current = head;

            if (count - n == 0) {
                return head.next;
            }

            for (int i=0; i<count - n; i++) {
                previous = current;
                current = current.next;
            }

            previous.next = current.next;

            return head;
        }
    }

    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndofList().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = solution.removeNthFromEnd(head, 2);
        System.out.println(result);
    }
}
