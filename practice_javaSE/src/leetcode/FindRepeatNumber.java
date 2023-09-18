package leetcode;

import java.util.HashSet;
import java.util.Set;


//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/59bjss/
//数组中重复的数字

public class FindRepeatNumber {
    
    public int findRepeatNumber(int[] nums) {
        Set<Integer> hashMap = new HashSet<>();
        //使用hash表,遍历nums,对于每一个num,先查找hash表中是否存在该数,否则就加入hash表中
        for (int num : nums) {
            if(hashMap.contains(num)) return num;
            hashMap.add(num);
        }
        return 0;
    }
}
