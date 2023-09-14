package leetcode;

import java.util.Random;

//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/ohvl0d/
//最小的 k 个数
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        quicksort(arr,0,arr.length-1);
        mergesort(arr,0,arr.length-1);
        int[] arr2 = new int[k];
        System.arraycopy(arr, 0, arr2, 0, k);
        return arr2;
    }


    /**
     * 快速排序
     * @param arr
     * @param l
     * @param r
     */
    private void quicksort(int[] arr,int l,int r){
        if(l>=r) return;
        int m=findflag(arr,l,r);
        quicksort(arr,l,m-1);
        quicksort(arr,m+1,r);
    }

    //找基准数
    private int findflag(int[] arr,int l,int r){
        //使用随机基准数进行优化
        Random random=new Random();
        int ma=random.nextInt(l,r+1);
        my_swap(arr,l,ma);
        int a=l,b=r;

        while(a<b){
            /*
            注意:一定是先从右向左查找的,因为最后是要和a交换基准数的,如果b没有找到,最后和a相撞,那么也是正确的,如果是a就错了
             */
            while(a<b && arr[b]>=arr[l]) b--;
            while(a<b && arr[a]<=arr[l]) a++;
            my_swap(arr,a,b);
        }
        my_swap(arr,a,l);
        return a;
    }


    //交换数组中两个数的函数
    private void my_swap(int[] arr,int x,int y){
        int tmp=arr[x];
        arr[x]=arr[y];
        arr[y]=tmp;
    }

    /**
     * 递归排序
     * @param l
     * @param r
     */
    private void mergesort(int[] ans,int l,int r){
        //当数组长度小于等于1时返回
        if(l>=r) return;
        int m=(l+r)/2;
        //递归排序
        mergesort(ans,l,m);
        mergesort(ans,m+1,r);
        //临时输出，存放排序之前的数据
        int[] tmp=new int[r-l+1];
        if (r - l + 1 >= 0) System.arraycopy(ans, l, tmp, 0, r - l + 1);
        int a=0,b=m-l+1;
        for(int i=l;i<=r;i++){
            if(a==m-l+1) ans[i]=tmp[b++];
            else if(b==r-l+1 || tmp[a]<tmp[b]) ans[i]=tmp[a++];
            else ans[i]=tmp[b++];
        }
    }
}
