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
        List<Integer> pieces=new ArrayList<>();  //初始化
        findans(sum,root,pieces);
        return ans;
    }

    private void findans(int sum, TreeNode nownode,List<Integer> pieces) {
        pieces.add(nownode.val);
        if(nownode.left==null&&nownode.right==null){  //终止条件
            if(sum==Target) {
                ans.add(new ArrayList<>(pieces));  //注意要新建一个List,因为这里的添加都是地址传递,如果直接添加的话后面在修改pieces时也会同时修改ans
            }
            //记得回溯
            return;
        }
        if(nownode.left!=null) {
            findans(sum+nownode.left.val,nownode.left,pieces);
            pieces.remove(pieces.size()-1);  //每次回溯都要将最后一个数删除
        }
        if(nownode.right!=null){
            findans(sum+nownode.right.val,nownode.right,pieces);
            pieces.remove(pieces.size()-1);  //每次回溯都要将最后一个数删除
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
