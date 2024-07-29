package LinkedList;
//https://leetcode.cn/problems/linked-list-cycle
public class HasCycle {


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        //两个位置不一样 while才能执行
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != quick) {
            //只需要判断quick的 不需要判断slow的 因为如果真的有null的话 也是quick先到达
            if (quick == null || quick.next == null) {
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }
}
