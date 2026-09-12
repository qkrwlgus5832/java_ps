import javax.sound.midi.MidiDevice;
import java.util.ArrayList;
import java.util.List;

public class MiddleoftheLinkedList {
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
        public ListNode middleNode(ListNode head) {
            List<ListNode> listNodes = new ArrayList<ListNode>();

            int count = 0;

            while (true) {
                if (head == null) {
                    break;
                }
                listNodes.add(head);
                head = head.next;
                count++;
            }

            return listNodes.get(count / 2);
        }
    }

    public static void main(String[] args) {
        MiddleoftheLinkedList.Solution solution = new MiddleoftheLinkedList().new Solution();
        MiddleoftheLinkedList.ListNode listNode = new MiddleoftheLinkedList().new ListNode(1);
        listNode.next = new MiddleoftheLinkedList().new ListNode(2);
        listNode.next.next = new MiddleoftheLinkedList().new ListNode(3);
        listNode.next.next.next = new MiddleoftheLinkedList().new ListNode(4);
        listNode.next.next.next.next = new MiddleoftheLinkedList().new ListNode(5);
        listNode.next.next.next.next.next = new MiddleoftheLinkedList().new ListNode(6);

        ListNode result = solution.middleNode(listNode);
        System.out.println(result);
    }
}
