package leetcode;

import java.util.HashMap;

//leetcode刷题:https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//重建二叉树
public class BuildTree {
    int[] preorder;
    //存放每个节点在中序遍历的索引
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }

    //前序遍历性质： 节点按照 [ 根节点 | 左子树 | 右子树 ] 排序。
    //中序遍历性质： 节点按照 [ 左子树 | 根节点 | 右子树 ] 排序。
    TreeNode recur(int root, int left, int right) {
        if (left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点,也就是前序遍历的root
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        /*
        1.左子树的头节点:因为先序遍历是按照根节点-->左子树-->右子树的,所以root=root+1;
        2.左子树的left:因为左子树在中序遍历的最左侧,所以一直都为0
        3.左子树的right:i求出的是在中序遍历中根节点的索引,根据中序遍历的特性(左子树-->根节点),其右边界必定在根节点的左侧,也就是root-1
         */
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        /*
        1.右子树的头节点:因为中序遍历的特性,左子树节点的值会一直在最前方,所以i-left也就为左子树的长度,之后再通过前序遍历,在根节点-->左子树-->右子树,
        所以root(在前序遍历的索引)+左子树长度+1=右子树的头节点索引
        2.右子树left:i为根节点在前序遍历的索引,那么i+1也就是右子树的最开始的范围
        3.右子树right:因为前序遍历的右子树是在最后面的,所以一直是总长度(inorder.length-1);
         */
        return node;                                           // 回溯返回根节点
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
