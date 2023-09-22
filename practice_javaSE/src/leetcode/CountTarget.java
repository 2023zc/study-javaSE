package leetcode;

//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/5874p1/
//统计目标成绩的出现次数

public class CountTarget {
    public int countTarget(int[] scores, int target) {
        if(scores.length==0) return 0;
        //使用二分查找,找到中间的那个目标下标
        int index=search(target,scores),num=0;
        if(index==-1) return 0;
        int tmp=index;
        //在下标左右移动，统计数量
        while(tmp<scores.length && scores[tmp]==target) {
            tmp++;
            num++;
        }
        tmp=index;
        while(tmp>=0 && scores[tmp]==target){
            tmp--;
            num++;
        }
        //开始的那个数是重复的,所以要减一
        return num-1;
    }

    //二分查找
    private int search(int target,int[] array){
        int l=0,r=array.length-1,t=-1;
        if(array.length==1) {
            if(array[0]==target) return 0;
            else return -1;
        }
        if(array[l]==target) return l;
        else if(array[r]==target) return r;
        while(l!=r-1){
            int mid=(l+r)/2;
            if(array[mid]==target) {
                t=mid;
                break;
            }
            else if (array[mid]<target) l=mid;
            else r=mid;
        }
        return t;
    }
}
