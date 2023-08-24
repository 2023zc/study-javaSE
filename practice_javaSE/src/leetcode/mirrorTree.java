package leetcode;

//leetcode刷题:https://leetcode.cn/problems/symmetric-tree/
//对称二叉树

public class mirrorTree {


    public TreeNode mirrorTree(TreeNode root) {
        changeTree(root);
        return root;
    }

    //负责交换当前节点的左右子树
    //并向下搜索
    public void changeTree(TreeNode a){
        if(a.left!=null||a.right!=null){
            //交换左右子树
            TreeNode tmp=a.left;
            a.left=a.right;
            a.right=tmp;
        }
        //向下搜索
        if(a.left!=null) changeTree(a.left);
        if(a.right!=null) changeTree(a.right);
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
