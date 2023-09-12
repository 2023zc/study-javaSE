package leetcode;


//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/5vwxx5/
//二叉搜索树的后序遍历序列
public class VerifyPostorder {


    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }

    private boolean recur (int[] postorder,int l,int r){
        //判断当前子树的节点数量,如果l>=r说明当前子树的节点数等于1或根本没有该子树,则直接返回true即可
        if(l>=r) return true;
        int p=l;
        //postorder[r]即为根节点,因为后序遍历的是先左子树-->右子树-->根节点的,这里是在从最左侧开始寻找左边界
        while(postorder[p]<postorder[r]) p++;
        //因为后序遍历是:左子树-->右子树-->根节点的
        //所以找到左子树的右边界也就是找到了右子树的左边界了,m也就是
        int m=p;
        //这里是找右子树的有边界
        while (postorder[p]>postorder[r]) p++;
        //p==j是为了判断该树的正确性,因为如果它满足后序遍历和二叉搜索树的特性,那么最后的p指针一定会移动到根节点处,也就是postorder[j]处
        return p==r && recur(postorder,l,m-1)&& recur(postorder,m,r-1);
    }
}
