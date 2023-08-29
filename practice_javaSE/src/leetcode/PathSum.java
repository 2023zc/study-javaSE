package leetcode;

import java.util.ArrayList;
import java.util.List;

//leetcode刷题:https://leetcode-cn.com/problems/path-sum-ii/
//二叉树中和为某一值的路径
public class PathSum {


    private List<List<Integer>> ans=new ArrayList<>();
    private int Target;

    public List<List<Integer> > pathSum(TreeNode root, int target) {
        int sum=0;
        Target=target;
        if(root==null) return ans;
        sum+=root.val;
        List<Integer> pieces=new ArrayList<>();
        findans(sum,root,pieces);
        return ans;
    }

    private void findans(int sum, TreeNode nownode,List<Integer> pieces) {
        pieces.add(nownode.val);
        if(nownode.left==null&&nownode.right==null){
            if(sum==Target) {
                ans.add(new ArrayList<>(pieces));
            }
            return;
        }
        if(nownode.left!=null) {
            findans(sum+nownode.left.val,nownode.left,pieces);
            pieces.remove(pieces.size()-1);
        }
        if(nownode.right!=null){
            findans(sum+nownode.right.val,nownode.right,pieces);
            pieces.remove(pieces.size()-1);
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
