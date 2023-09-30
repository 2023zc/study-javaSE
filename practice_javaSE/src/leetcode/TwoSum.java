package leetcode;

import java.util.*;

//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/5832fi/
//查找总价格为目标值的两个商品

public class TwoSum {

    //使用hash表解决
    public int[] twoSum1(int[] price, int target) {
        int[] ans=new int[2];
        Set<Integer> hash=new HashSet<>();
        for (int j : price) {
            //表示查找到可以凑成target的两个数
            if (hash.contains(target - j)) {
                ans[0] = j;
                ans[1] = target - j;
                return ans;
            }
            //把当前数添加到hash表中
            hash.add(j);
        }
        return ans;
    }

    //用双指针解决(因为数列已经升序排列)
    public int[] twoSum2(int[] price ,int target){
        int l=0,r=price.length-1;
        while(l!=r){
            if(price[l]+price[r]>target) r--;
            else if(price[l]+price[r]<target) l++;
            else return new int[]{price[l], price[r]};
        }
        return new int[]{-1,-1};
    }
}
