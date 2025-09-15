package LinkedList;

//https://leetcode.cn/problems/merge-two-sorted-lists
public class MergeTwoSortedLists {

//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode head = new ListNode(-1);
//        ListNode temp = head;
//        while (list1 != null || list2 != null) {
//            Integer n1 = 0;
//            Integer n2 = 0;
//            if (list1 != null && list2 != null) {
//                n1 = list1.val;
//                n2 = list2.val;
//                if (n2 > n1) {
//                    //这里要考虑n2 大于下一个l1的情况
//                    if (list1.next != null && list1.next.val >= n2) {
//                        temp.next = new ListNode(n1);
//                        temp.next.next = new ListNode(n2);
//                        temp = temp.next.next;
//                        list1 = list1.next;
//                        list2 = list2.next;
//                    }else {
//                        temp.next = new ListNode(n1);
//                        temp = temp.next;
//                        list1 = list1.next;
//                    }
//                }else {
//                    if (list2.next != null && list2.next.val >= n1) {
//                        temp.next = new ListNode(n2);
//                        temp.next.next = new ListNode(n1);
//                        temp = temp.next.next;
//                        list1 = list1.next;
//                        list2 = list2.next;
//                    }else {
//                        temp.next = new ListNode(n2);
//                        temp = temp.next;
//                        list2 = list2.next;
//                    }
//                }
//
//            }else if (list1 != null && list2 == null) {
//                n1 = list1.val;
//                temp.next = new ListNode(n1);
//                temp = temp.next;
//                list1 = list1.next;
//            }else if (list1 == null && list2 != null) {
//                n2 = list2.val;
//                temp.next = new ListNode(n2);
//                temp = temp.next;
//                list2 = list2.next;
//            }
//        }
//        return head.next;
//    }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode prehead = new ListNode(-1);

            ListNode prev = prehead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }

            // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
            prev.next = l1 == null ? l2 : l1;

            return prehead.next;
        }

    public ListNode mergeTwoListsWithRecusive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
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
