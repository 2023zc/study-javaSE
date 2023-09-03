package leetcode;

//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/58df23/
//二叉搜索树的第 k 大节点

public class KthLargest {

    private int ans;
    private int num;

    //因为给的是一个二叉搜索树，所有可以序列化为一个排列好的数组
    public int kthLargest(TreeNode root, int k) {
        dfs(root,k);
        return ans;
    }

    public void dfs(TreeNode nownode,int k) {
        //如果找到第k大的数直接返回
        if(num==k) return;
        //使用中序遍历
        if(nownode.right!=null) dfs(nownode.right,k);
        //判断第k大的数
        if(++num==k) ans=nownode.val;
        if(nownode.left!=null) dfs(nownode.left,k);
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
