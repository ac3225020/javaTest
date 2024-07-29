package LinkedList;

//https://leetcode.cn/problems/merge-two-sorted-lists
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (list1 != null || list2 != null) {
            Integer n1 = 0;
            Integer n2 = 0;
            if (list1 != null && list2 != null) {
                n1 = list1.val;
                n2 = list2.val;
                if (n2 > n1) {
                    //这里要考虑n2 大于下一个l1的情况
                    if (list1.next != null && list1.next.val >= n2) {
                        temp.next = new ListNode(n1);
                        temp.next.next = new ListNode(n2);
                        temp = temp.next.next;
                        list1 = list1.next;
                        list2 = list2.next;
                    }else {
                        temp.next = new ListNode(n1);
                        temp = temp.next;
                        list1 = list1.next;
                    }
                }else {
                    if (list2.next != null && list2.next.val >= n1) {
                        temp.next = new ListNode(n2);
                        temp.next.next = new ListNode(n1);
                        temp = temp.next.next;
                        list1 = list1.next;
                        list2 = list2.next;
                    }else {
                        temp.next = new ListNode(n2);
                        temp = temp.next;
                        list2 = list2.next;
                    }
                }

            }else if (list1 != null && list2 == null) {
                n1 = list1.val;
                temp.next = new ListNode(n1);
                temp = temp.next;
                list1 = list1.next;
            }else if (list1 == null && list2 != null) {
                n2 = list2.val;
                temp.next = new ListNode(n2);
                temp = temp.next;
                list2 = list2.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);

        System.out.println(new MergeTwoSortedLists().mergeTwoLists(l1,l2));
    }
}
