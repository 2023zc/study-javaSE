package leetcode;

//leetcode刷题:https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
//二叉树的深度
public class MaxDepth {

    private int ans;
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        dfs(root,1);
        return ans;
    }

    //dfs深度搜索最大深度
    public void dfs(TreeNode nownode,int depth) {
        //更新最大值
        if(depth>ans) ans=depth;
        if(nownode.left!=null) dfs(nownode.left,depth+1);
        if(nownode.right!=null) dfs(nownode.right,depth+1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
