package LinkedList;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.cn/problems/rotate-list
public class RotateList {

    //主要是为了计算每个节点的位置
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return head;
        }
        if (k == 0) {
            return head;
        }
        ListNode temp = head;
        List<ListNode> nodeList = new ArrayList<>();
        Map<Integer,ListNode> nodeMap = new HashMap<>();
        while (temp != null) {
            nodeList.add(temp);
            temp = temp.next;
        }
        int size = nodeList.size();
        for (int i = 0; i < size; i++) {
            ListNode current = nodeList.get(i);
            Integer newIndex = (k+i) % size;
            nodeMap.put(newIndex,current);
        }
        ListNode dump = new ListNode(-1);
        ListNode nextNode = dump;
        for (int i = 0; i < size; i++) {
            nextNode.next = nodeMap.get(i);
            nextNode = nextNode.next;
        }
        nextNode.next = null;
        return dump.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(new RotateList().rotateRight(l1,1));
    }
}
