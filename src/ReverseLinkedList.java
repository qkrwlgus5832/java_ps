import java.util.ArrayList;

public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ArrayList<Integer> tmpList = new ArrayList<Integer>();

            ListNode pointer = head;
            while (true) {
                if (pointer == null) {
                    break;
                }
                tmpList.add(pointer.val);
                pointer = pointer.next;
            }

            ListNode result = null;
            pointer = null;

            for (int i = tmpList.size() - 1; i >= 0; i--) {
                if (pointer == null) {
                    pointer = new ListNode(tmpList.get(i));
                    result = pointer;
                } else {
                    pointer.val = tmpList.get(i);
                }

                if (i == 0) {
                    continue;
                }
                pointer.next = new ListNode();
                pointer = pointer.next;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ReverseLinkedList().new ListNode(34);
        listNode.next = new ReverseLinkedList().new ListNode(1);
        listNode.next.next = new ReverseLinkedList().new ListNode(234);
        listNode.next.next.next = new ReverseLinkedList().new ListNode(45);
        listNode.next.next.next.next = new ReverseLinkedList().new ListNode(11334);


        Solution solution = new ReverseLinkedList().new Solution();
        ListNode result = solution.reverseList(listNode);
        System.out.println(result);
    }
}
