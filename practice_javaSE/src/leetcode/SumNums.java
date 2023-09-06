package leetcode;

//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/9h44cj/
//求 1 + 2 + … + n
public class SumNums {

    public static int sumNums(int n) {
        if(n==0) return 0;
        //递归实现累加
        return n+sumNums(n-1);
    }


}
