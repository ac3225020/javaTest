package LinkedList;


//https://leetcode.cn/problems/reverse-linked-list/
public class ReverseLinkedList {


    public ListNode reverseList(ListNode head) {
        //本质上考虑last,current,next 3个节点
        //每次迭代都是这3个节点往前移动
        ListNode last = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = last;
            last = current;
            current = temp;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(new ReverseLinkedList().reverseList(l1));
    }

}
