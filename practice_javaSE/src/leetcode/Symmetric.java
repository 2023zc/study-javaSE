package leetcode;

//leetcode刷题:https://leetcode.cn/problems/symmetric-tree/
//镜像二叉树

public class Symmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;   //特判
        return findans(root.left,root.right);
    }

    private boolean findans(TreeNode NowNode_left, TreeNode NowNode_right) {

        //左节点和右节点为null的特判
        if(NowNode_left==null && NowNode_right!=null) return false;
        if(NowNode_left!=null && NowNode_right==null) return false;
        if(NowNode_left == null) return true;

        //向下递归
        return (NowNode_left.val==NowNode_right.val)&&findans(NowNode_left.left,NowNode_right.right)
                &&findans(NowNode_left.right,NowNode_right.left);

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
