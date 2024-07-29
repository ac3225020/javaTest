package LinkedList;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.cn/problems/remove-nth-node-from-end-of-list
public class RemoveNthNodeFromEndOfList {

    //本质上是倒数第n-1个节点指向第n+1个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int total = 0;
        Map<Integer,ListNode> nodes = new HashMap<>();
        while (head != null) {
            total++;
            nodes.put(total,head);
            head = head.next;
        }
        //倒数第n个节点 如10个节点中 倒数第1个节点 应该第10个节点 10-1+1
        //到处第n-1个节点 是total-(n-1)+1 = total-n+2
        int before = total-n+1-1;
        int next = total -n +1 +1;
        if (before < 1) {
            //说明n是head节点
            return temp.next;
        }
        if (next > total) {
            //说明删除最后一个节点
            nodes.get(total-1).next = null;
        }
        nodes.get(before).next = nodes.get(next);
        return temp;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        //l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);
        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(l1,1));
    }


}
