package leetcode;

//leetcode刷题:https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
//训练计划 V

public class GetIntersectionNode {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode headACopy =headA, haedBCopy =headB;
        //先走一轮让headA与headB之间从开头开始是同一个起点,之后如果走到一起,那么就一定是共同节点
        while(headA!=null || headB!=null) {
            if(headA==null) headA=headACopy;
            else if(headB==null) headB=haedBCopy;
            if(headA==headB) break;
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
