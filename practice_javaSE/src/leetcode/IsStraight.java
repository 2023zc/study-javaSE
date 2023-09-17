package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/57mpoj/
//扑克牌中的顺子
public class IsStraight {

    /*
    第一种方法:统计0的个数,也就是万能牌的数量,并且遍历整个数组,如果前后两个数差距大到连用万能牌填补都不可以,那就是不行,否则就是可行
     */
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int everynum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                everynum++;
                continue;
            }
            if (i != 0 && nums[i - 1] != 0) {
                //与上一张牌相等
                if (nums[i] == nums[i - 1]) return false;
                //比上一张牌大不止1
                if (nums[i] != nums[i - 1] + 1) {
                    int distance = nums[i] - nums[i - 1];
                    if (distance - 1 > everynum) return false;
                    else everynum -= (distance - 1);
                }
            }
        }
        return true;
    }

    /*
    第二种方法:统计最小数和最大数之间的差距(遇到0直接跳过),如果max-min>5,说明不可能形成顺子,否则就是可以
     */
    public boolean isStraight2(int[] nums) {
        Set<Integer> numsset = new HashSet<>();
        int min=14,max=0;
        for (int num : nums) {
            if(num==0) continue;
            if(num>max) max=num;
            if(num<min) min=num;
            if(numsset.contains(num)) return false;
            numsset.add(num);
        }
        return max-min<5;
    }
}
