package leetcode;


//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/o58jfs/
//数组中的逆序对

public class ReversePairs {

    private int[] tmp;
    public int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        //使用归并排序寻找逆序对
        return mergeSort(nums,0,nums.length-1);
    }

    private int mergeSort(int[] nums,int l,int r){
        if(l>=r) return 0;
        //储存未修改之前的nums，这样修改时直接取tmp里面的值即可
        int mid=(l+r)/2;
        //递归返回
        int res=mergeSort(nums,l,mid)+mergeSort(nums,mid+1,r);
        for(int i=l;i<=r;i++) tmp[i]=nums[i];
        int a=l,b=mid+1;
        for(int i=l;i<=r;i++){
            //这里是将l-->mid.和mid+1-->r的这两个数组合并的过程
            //说明左数组以及全部用完,那么直接加入右边的数组即可
            if(a==mid+1){
                nums[i]=tmp[b++];
            }
            //b==r+1说明右数组已经用完
            else if(b==r+1 || tmp[a]<=tmp[b]){
                nums[i]=tmp[a++];
            }
            //当nums[a]>nums[b]时,说明左边数组的这些项都比右边数组大(因为是按有序排列的,最小的都大,那么其他肯定也大)
            else{
                nums[i]=tmp[b++];
                //统计逆序对
                res+=(mid+1-a);
            }
        }
        return res;
    }

}
