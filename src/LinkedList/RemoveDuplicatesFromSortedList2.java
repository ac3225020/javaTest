package LinkedList;


//https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii
public class RemoveDuplicatesFromSortedList2 {

    //删除链表中的重复元素
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                //cur.next和当前next值一直循环到不一样为止
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;



    }

}
