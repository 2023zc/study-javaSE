package leetcode;

import java.util.ArrayList;
import java.util.List;

//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/eubbnm/
//撞色搭配

public class SockCollocation {

    private List<Integer> list=new ArrayList<Integer>();
    public int[] sockCollocation(int[] sockets) {
        //对数组进行排序
        quicksort(0,sockets.length-1,sockets);
        //判断该袜子是否落单
        if(sockets[0]!=sockets[1]) list.add(sockets[0]);
        for(int i=1;i<sockets.length-1;i++){
            if(sockets[i]!=sockets[i-1]&&sockets[i]!=sockets[i+1]) list.add(sockets[i]);
        }
        if(sockets[sockets.length-1]!=sockets[sockets.length-2]) list.add(sockets[sockets.length-1]);
        //记录数据
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }

    //手写快排qwq
    private int quickcur(int l,int r,int[] arr){
        int flag_num=arr[l],cp_l=l;
        while(l<r){
            //一定要右指针先动,因为很有可能右指针会一直走到最左边，此时就是l与l自身交换
            while(l<r && arr[r]>=flag_num) r--;
            while(l<r && arr[l]<=flag_num) l++;
            swap(l,r,arr);
        }
        swap(cp_l,l,arr);
        return l;
    }
    private void swap(int x,int y,int[] arr){
        int tmp=arr[x];
        arr[x]=arr[y];
        arr[y]=tmp;
    }
    private void quicksort(int l,int r,int[] arr){
        if(l>=r) return;
        int mid=quickcur(l,r,arr);
        quicksort(l,mid-1,arr);
        quicksort(mid+1,r,arr);
    }
}
