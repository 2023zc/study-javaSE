package leetcode;


//leetcode刷题：https://leetcode-cn.com/problems/merge-two-sorted-lists/
//训练计划 IV

public class TrainningPlan3 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        ListNode dum=new ListNode(0),tmp=dum;
        //双指针添加数据
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tmp.next=new ListNode(l1.val);
                l1=l1.next;
            }
            else{
                tmp.next=new ListNode(l2.val);
                l2=l2.next;
            }
            tmp=tmp.next;
        }
        //剩余数据处理
        tmp.next= l1==null ? l2 : l1;
        return dum.next;
    }
}
