package leetcode;

//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/59ypcj/
//把数组排成最小的数
public class MinNumber {

    //思路:如果相邻的两个数a,b的:a+b>b+a,那么就交换这两个数,当然可以用快排,归并的排序方法实现,这里使用最简单的冒泡排序,便于理解
    public String minNumber(int[] nums) {
        for(int i=0;i< nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(check(nums[j],nums[j+1])){
                    int tmp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    //判断是否a+b>b+a
    public boolean check(int x,int y){
        String a=String.valueOf(x);
        String b=String.valueOf(y);
        return Double.parseDouble(a + b) > Double.parseDouble(b + a);
    }


}
