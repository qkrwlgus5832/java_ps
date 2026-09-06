public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode pointer = head;

            while (true) {
                if (pointer == null) {
                    return false;
                }
                if (pointer.val == Integer.MIN_VALUE) {
                    return true;
                }

                pointer.val = Integer.MIN_VALUE;
                pointer = pointer.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        Solution solution = linkedListCycle.new Solution();
        ListNode listNode = linkedListCycle.new ListNode(1);

        listNode.next = linkedListCycle.new ListNode(2);
        listNode.next.next = listNode;

//        ListNode duplicated = linkedListCycle.new ListNode(2);
//        ListNode listNode = linkedListCycle.new ListNode(2);
//        listNode.next = duplicated;
//        listNode.next.next = linkedListCycle.new ListNode(0);
//        listNode.next.next.next = linkedListCycle.new ListNode(-4);
//        listNode.next.next.next.next = duplicated;

        System.out.println(solution.hasCycle(listNode));
    }
}
