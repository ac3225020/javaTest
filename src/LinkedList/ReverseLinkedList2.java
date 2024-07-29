package LinkedList;

// https://leetcode.cn/problems/reverse-linked-list-ii
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //反转left 到 right 的节点 需要记住 left -1 和 right + 1 的节点
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode leftNodeBefore = null;
        ListNode rightNodeNext = null;
        int index = 1;

        ListNode last =null;
        ListNode current = head;

        while (current != null && index <= right) {
            if (index == left) {
                leftNodeBefore = last;
                leftNode = current;
            }
            if (index == right) {
                rightNode = current;
                rightNodeNext = current.next;
            }
            if (index > left) {
                ListNode tempNext = current.next;
                current.next = last;
                last = current;
                current = tempNext;
            }else {
                last = current;
                current = current.next;
            }

            index++;
        }
        if (leftNodeBefore != null) {
            leftNodeBefore.next = rightNode;
        }else {
            head = rightNode;
        }
        leftNode.next = rightNodeNext;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);

        System.out.println(new ReverseLinkedList2().reverseBetween(l1,1,1));

    }

}
