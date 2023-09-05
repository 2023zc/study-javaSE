package leetcode;

//leetcode刷题:https://leetcode-cn.com/problems/balanced-binary-tree/
//平衡二叉树

public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root)!=-1;
    }

    //采取先序遍历加剪枝的方法,找到不是平衡二叉树的节点直接向上返回
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        //找左侧节点的深度
        int left = maxDepth(root.left);
        if(left==-1) return -1;
        //找右侧节点的深度
        int right = maxDepth(root.right);
        if(right==-1) return -1;
        //根据平衡二叉树的定义,如果是就返回以该节点为根节点的深度(左子树和右子树深度最大值+1),防之就直接向上返回
        return Math.abs(left-right)<=-1?Math.max(left,right)+1:-1;
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
