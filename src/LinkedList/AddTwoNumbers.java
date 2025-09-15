package LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.cn/problems/add-two-numbers
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        //逆序存储，要做到相加，第一步转stack
//        Stack<Integer> s1 = getStackByListNode(l1);
//        Stack<Integer> s2 = getStackByListNode(l2);
//        //相加的结果放到queue 因为是先进先出
//        Queue<Integer> result = new LinkedList<>();
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        Boolean jinweiFlag = false;
        while (l1 != null || l2 != null) {
            Integer n1 = 0;
            Integer n2 = 0;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }
            Integer sum = n2 + n1;
            if (jinweiFlag) {
                sum = sum + 1;
                jinweiFlag =false;
            }
            if (sum >= 10) {
                jinweiFlag = true;
                sum = sum -10;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
        }
        //最后一个进位如果没消化掉 有需要+1
        if (jinweiFlag) {
            temp.next = new ListNode(1);
        }
        return head.next;
    }

//    private ListNode getListNodeByQueue(Queue<Integer> queue) {
//        ListNode head = new ListNode(0);
//        if (queue == null || queue.isEmpty()) {
//            return head;
//        }
//        ListNode next = head;
//        while (!queue.isEmpty()) {
//            Integer top = queue.poll();
//            ListNode node = new ListNode(top);
//            next.next = node;
//            next = node;
//        }
//        return head.next;
//
//    }
//
//    private Stack<Integer> getStackByListNode(ListNode l1) {
//        if (l1 == null) {
//            return new Stack<>();
//        }
//        ListNode temp = l1;
//        Stack<Integer> stack = new Stack<>();
//        while (temp != null) {
//            stack.push(temp.val);
//            temp = temp.next;
//        }
//        return stack;
//    }


    public static ListNode addInList (ListNode head1, ListNode head2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while ( head1 != null) {
            s1.push(head1.val);
            head1 = head1.next;
        }

        while ( head2 != null) {
            s2.push(head2.val);
            head2 = head2.next;
        }

        //进位
        Integer nextFlag = 0;
        ListNode first = new ListNode(-1);
        ListNode next = first;
        Stack<ListNode> result = new Stack<>();
        while ( s1.size() > 0 || s2.size() > 0) {
            Integer temp = 0;
            if (s1.size() > 0 && s2.size() > 0 ) {
                temp = (s1.pop() + s2.pop() + nextFlag);
                if (temp > 9) {
                    temp = temp -10;
                    nextFlag =1;
                }
            }else if (s1.size() > 0) {
                temp = (s1.pop() + nextFlag) ;
                if (temp > 9) {
                    temp = temp -10;
                    nextFlag =1;
                }

            } else if (s2.size() > 0) {
                temp = (s2.pop() + nextFlag) ;
                if (temp > 9) {
                    temp = temp -10;
                    nextFlag =1;
                }
            }
            result.push(new ListNode(temp));
        }
        if (nextFlag == 1) {
            result.push(new ListNode(1));
        }
        while (result.size() > 0) {
            next.next = result.pop();
            next = next.next;
        }
        return first.next;
    }
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(9);
//
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//        l2.next.next.next = new ListNode(9);
//
//        System.out.println(new AddTwoNumbers().addTwoNumbers(l1,l2));
        ListNode L1 = new ListNode(9);
        ListNode L2 = new ListNode(3);
        ListNode L3 = new ListNode(7);
        L1.next = L2;
        L2.next = L3;

        ListNode L4 = new ListNode(6);
        ListNode L5 = new ListNode(3);
        L4.next = L5;

        System.out.println(addInList(L1,L4));





    }




}
