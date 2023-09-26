package leetcode;

//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/58tl52/
//训练计划 II

public class TrainingPlan2 {

    private int num;
    private ListNode ans;
    public ListNode trainingPlan(ListNode head, int cnt) {
        findans2(head,cnt);
        return ans;
    }

    //这里用函数递归解决
    private void findans(ListNode nowNode, int cnt) {
        if(nowNode==null) return;
        findans(nowNode.next,cnt);
        //num也就是往回走的步数
        num++;
        if(num==cnt) {
            ans=nowNode;
        }
    }

    //运用快慢指针解决,前指针与后指针相距始终为cnt，那么当前指针为null时,后指针就为答案
    private void findans2(ListNode nowNode, int cnt) {
        ListNode head=nowNode,pre=nowNode;
        for(int i=0;i<cnt;i++){
            head=head.next;
        }
        while(head!=null){
            head=head.next;
            pre=pre.next;
        }
        ans=pre;
    }
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
}
