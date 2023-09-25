package leetcode;

//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/5v8a6t/
//训练计划 I

public class TrainingPlan {
    public int[] trainingPlan(int[] actions) {
        int[] result = new int[actions.length];
        //利用双指针,是奇数就在数列前添加,否则就在后面添加
        int n=result.length-1,l=0;
        for (int action : actions) {
            if (action % 2 == 0) {
                result[n--] = action;
            } else {
                result[l++] = action;
            }
        }
        return result;
    }
}
