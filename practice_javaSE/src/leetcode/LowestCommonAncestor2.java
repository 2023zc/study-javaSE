package leetcode;

import java.util.ArrayList;
import java.util.List;

//leetcode刷题:https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
//二叉树的最近公共祖先
public class LowestCommonAncestor2 {

    private List<TreeNode> arr=new ArrayList<>();
    private List<TreeNode> parr=new ArrayList<>();
    private List<TreeNode> qarr=new ArrayList<>();

    //思路:先找到到达p节点和到达q节点的路径,那么两个路径第一个不同节点的前一个节点也就是最进的祖先节点

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findtarget(root,p);
        arr.clear();
        findtarget(root,q);
        for (int i = 0; i < Math.min(parr.size(), qarr.size()); i++) {
            if(parr.get(i)!=qarr.get(i)){
                return parr.get(i-1);
            }
        }
        if(parr.size()<qarr.size()) return parr.get(parr.size()-1);
        else return qarr.get(qarr.size()-1);
    }

    private void findtarget(TreeNode nownode, TreeNode target){
        arr.add(nownode);
        if(nownode==target) {
            if(parr.isEmpty()) parr=new ArrayList<>(arr);
            else qarr=new ArrayList<>(arr);
            return;
        }
        if(nownode.left==null&&nownode.right==null) return;
        if(nownode.left!=null) {
            findtarget(nownode.left,target);
            arr.remove(arr.size()-1);
        }
        if(nownode.right!=null) {
            findtarget(nownode.right,target);
            arr.remove(arr.size()-1);
        }
    }

    /*
    题解方法:将该方法想象成一个可以返回p和q的最近祖先的函数,那么函数方法中的left表示在root左树下的p和q的最进公共祖先
           1.null就代表左树或右树下不存在.
           2.当遇上左节点或者右节点时直接返回节点
           3.如果left和right都不为空,那么就代表root就为左右节点的最近祖先直接向上返回
     */
    public TreeNode official_lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
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
