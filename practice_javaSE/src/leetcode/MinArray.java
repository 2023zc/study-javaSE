package leetcode;

//leetcode:https://leetcode.cn/leetbook/read/illustration-of-algorithm/5055b1/
//旋转数组的最小数字

public class MinArray {
    public int minArray(int[] numbers) {
        int min=numbers[0];
        for(int i=0;i<numbers.length;i++){
            //如果找到降低的数,那么这个就是最小值
            if(numbers[i]<numbers[i-1]) return numbers[i];
        }
        return min;
    }
}
