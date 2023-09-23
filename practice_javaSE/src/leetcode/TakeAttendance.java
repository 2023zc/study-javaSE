package leetcode;


//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/58iqo5/
//点名

public class TakeAttendance {

    //使用二分搜索方法,判断条件就是record[i]是否等于i
    public int takeAttendance(int[] record) {
        int l = 0, r = record.length - 1;
        if (record[l] != l) return l;
        //代表最后一个同学没来
        if(record[r] == r) return r+1;
        while (l != r-1) {
            int m = (l + r) / 2;
            if (record[m] == m) l = m;
            else r=m;
        }
        return l+1;
    }
}
