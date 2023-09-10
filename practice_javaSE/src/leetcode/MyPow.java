package leetcode;

//leetcode刷题:https://leetcode-cn.com/problems/powx-n/
//数值的整数次方
public class MyPow {

    //本题使用快速幂的方法
    public static double myPow(double x, int n) {
        double ans;
        //终止条件
        if(n==1) return x;
        else if(n==-1) return 1.0/x;
        else if(n==0) return 1.0;
        //举例:求x^4=(x^2)*(x^2)
        if(n%2==0) {
            ans = myPow(x, n / 2);
            return ans * ans;
        }
        //举例:求x^5=(x^2)*(x^2)*x
        ans=myPow(x,(n-1)/2);
        return ans*ans*x;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.4, 5));
    }
}
