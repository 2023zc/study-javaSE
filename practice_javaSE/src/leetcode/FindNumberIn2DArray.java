package leetcode;

//leetcode刷题:https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
//二维数组中的查找

public class FindNumberIn2DArray {

    /*
    因为数组是已经排好序的,所以可以对每个数组进行一次二分搜索即可
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //特殊[[]]的情况
        if(matrix.length==1 && matrix[0].length==0) return false;
        for(int i=0;i<matrix.length;i++){
            //剪枝
            if(matrix[i][matrix[i].length-1]<target) continue;
            if(matrix[i][0]>target) break;
            if(search(matrix[i],target)) return true;
        }
        return false;
    }


    //二分搜索
    private boolean search(int[] array, int target){
        int l=0,r=array.length-1;
        if(array[l]==target || array[r]==target) return true;
        while(l!=r-1){
            int mid=(l+r)/2;
            if(array[mid]>target) r=mid;
            else if(array[mid]<target) l=mid;
            else return true;
        }
        return false;
    }

    /*
    第二种方法:讲数组从右上角开始看,那么可看成一棵二叉搜索树,向左移动就是在减小,向下移动就是在增大,那么只需要不停搜索下去,直到找到目标或者数组越界
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        //特殊情况:[] 或者 [[]]
        if(matrix.length==0 || (matrix.length==1 && matrix[0].length==0 )) return false;
        //二叉搜索树的根节点,向左减小,向右增大
        int root=matrix[0][matrix[0].length-1],x=0,y=matrix[0].length-1;
        while(root!=target){
            if(root>target) y--;
            else if(root<target) x++;
            else break;
            if(x>matrix.length-1||y<0) return false;
            root=matrix[x][y];
        }
        return true;
    }

}
