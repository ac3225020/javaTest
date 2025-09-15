package LinkedList;

// https://leetcode.cn/problems/reverse-linked-list-ii
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //反转left 到 right 的节点 需要记住 left -1 和 right + 1 的节点
        if (head == null) {
            return head;
        }

        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode leftNodeBefore = null;
        ListNode rightNodeNext = null;
        int index = 1;

        ListNode current = head;
        ListNode before = null;
        //从m开始到n结束
        while( current != null && index <= n) {
            if (index == n) {
                rightNode = current;
                rightNodeNext = current.next;
            }

            if (index == m) {
                leftNode = current;
                leftNodeBefore = before;
            }

            if ( index <=m) {
                before = current;
                current = current.next;
            }else {
                ListNode temp = current.next;
                current.next = before;
                before = current;
                current = temp;
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
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        System.out.println(new ReverseLinkedList2().reverseBetween(l1,2,4).val);

    }

}
