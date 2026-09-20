import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.Set;

public class LinkedListCycle2 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode pointer = head;
            ListNode fasterPointer = head;

            Set<ListNode> visited = Collections.newSetFromMap(new IdentityHashMap<>());

            while(true) {
                if (pointer == null || fasterPointer == null || fasterPointer.next == null) {
                    return null;
                }
                else if (visited.contains(fasterPointer)) {
                    return fasterPointer;
                }
                else if (visited.contains(fasterPointer.next)) {
                    return fasterPointer.next;
                }

                visited.add(pointer);
                pointer = pointer.next;
                fasterPointer = fasterPointer.next.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedListCycle2.Solution solution = new LinkedListCycle2().new Solution();
        LinkedListCycle2.ListNode listNode = new LinkedListCycle2().new ListNode(3);

        LinkedListCycle2.ListNode listNode2 = new LinkedListCycle2().new ListNode(2);
        LinkedListCycle2.ListNode pos = new LinkedListCycle2().new ListNode(0);
        LinkedListCycle2.ListNode listNode3 = new LinkedListCycle2().new ListNode(-4);
        LinkedListCycle2.ListNode listNode4 = new LinkedListCycle2().new ListNode(5);
        LinkedListCycle2.ListNode listNode5 = new LinkedListCycle2().new ListNode(6);
        LinkedListCycle2.ListNode listNode6 = new LinkedListCycle2().new ListNode(7);

        listNode.next = listNode2;
        listNode.next.next = pos;
        listNode.next.next.next = listNode3;
        listNode.next.next.next.next = listNode4;
        listNode.next.next.next.next.next = listNode5;
        listNode.next.next.next.next.next.next= listNode6;
        listNode6.next = pos;

        var result = solution.detectCycle(listNode);
        System.out.println(result);
    }
}
