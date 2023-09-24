package leetcode;

//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/505fc7/
//删除链表的节点

public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode tmp=head,pre=null;
        //特判
        if(head.val==val) return head.next;
        //用前后两个指针实现删除节点操作
        while(tmp!=null){
            if(tmp.val==val) {
                pre.next=tmp.next;
                tmp.next=null;
                break;
            }
            pre=tmp;
            tmp=tmp.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
