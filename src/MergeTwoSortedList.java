public class MergeTwoSortedList {
    public class ListNode {
        int val = 0;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode root = new ListNode();
            ListNode tmpRoot = root;

            if (list1 == null && list2 == null) {
                return null;
            }
            while(true) {
                if (list2 == null || list1 != null && list1.val < list2.val) {
                    tmpRoot.val = list1.val;
                    list1 = list1.next;
                }
                else {
                    tmpRoot.val = list2.val;
                    list2 = list2.next;
                }

                if (list1 == null && list2 == null) {
                    break;
                }


                tmpRoot.next = new ListNode();
                tmpRoot = tmpRoot.next;
            }

            return root;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedList outer = new MergeTwoSortedList();
        Solution solution = outer.new Solution();


//        ListNode listNode1 = outer.new ListNode();
//        ListNode listNode2 = outer.new ListNode(0);
        ListNode listNode1 = outer. new ListNode(1);
        listNode1.next = outer.new ListNode(2);
        listNode1.next.next = outer.new ListNode(4);

        ListNode listNode2 = outer. new ListNode(1);
        listNode2.next = outer.new ListNode(3);
        listNode2.next.next = outer.new ListNode(4);

        ListNode result = solution.mergeTwoLists(listNode1, listNode2);
        System.out.println(result);
    }
}
