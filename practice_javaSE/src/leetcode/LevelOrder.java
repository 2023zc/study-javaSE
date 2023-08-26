package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/9ackoe/
//从上到下打印二叉树

public class LevelOrder {

    //因为要同层从左到右打印数据,所以需要使用广度优先算法(bfs),遍历二叉树即可
    private List<Integer> ans =new ArrayList<>();
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];   //特判
        Queue<TreeNode> Nodearr=new LinkedList<>();
        Nodearr.add(root);
        while(!Nodearr.isEmpty()){   //bfs过程
            TreeNode nownode=Nodearr.poll();
            ans.add(nownode.val);
            if(nownode.left!=null) Nodearr.add(nownode.left);
            if(nownode.right!=null) Nodearr.add(nownode.right);
        }
        int[] finalans=new int[ans.size()];
        for (int i = 0; i < finalans.length; i++) {
            finalans[i]=ans.get(i);
        }
        return finalans;
    }


    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
