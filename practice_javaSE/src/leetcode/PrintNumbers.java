package leetcode;

//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/594wfg/
//打印从 1 到最大的 n 位数

public class PrintNumbers{
    public int[] printNumbers(int n) {
        int end= (int) (Math.pow(10,n)-1);
        int[] ans=new int[end];
        for(int i=1;i<=end;i++){
            ans[i-1]=i;
        }
        return ans;
    }

}
