package leetcode;

//leetcode刷题:https://leetcode-cn.com/problems/number-of-1-bits/
//位 1 的个数

public class HammingWeight {
    public int hammingWeight(int n) {
        int res=0;
        while(n!=0){
            //每次先让n&1，表示判断最右侧数字是否为1
            res+=(n&1);
            //将n右移一位
            n>>>=1;
        }
        return res;
    }
}
