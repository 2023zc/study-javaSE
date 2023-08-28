package leetcode;

import java.util.*;



//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/5vnp91/
//从上到下打印二叉树

public class LevelOrder3 {

    private List<List<Integer> > ans=new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> treeNodes=new LinkedList<>();
        if(root!=null) treeNodes.add(root);
        int num=0;
        while(!treeNodes.isEmpty()){
            LinkedList<Integer> tmp=new LinkedList<>();
            for(int i=treeNodes.size()-1;i>=0;i--){
                TreeNode nownode=treeNodes.poll();
                //与bfs唯一不同的就是要判断插入的顺序
                //奇数列就在队头加入,偶数列在队头加入
                //所以需要使用双端队列来实现算法
                if(num%2==0) tmp.addFirst(nownode.val);
                else tmp.addLast(nownode.val);
                if(nownode.left!=null) treeNodes.add(nownode.left);
                if(nownode.right!=null) treeNodes.add(nownode.right);
            }
            num++;
            ans.add(tmp);
        }
        return  ans;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }
}
