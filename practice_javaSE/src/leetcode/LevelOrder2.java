package leetcode;

import java.util.*;

//leetcode刷题:https://leetcode.cn/problems/binary-tree-level-order-traversal/
//二叉树的层序遍历
public class LevelOrder2 {

    private List <List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null) queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> tmp=new ArrayList<>();
            //使用for循环将当前这层的所有数据加入对应的list中
            //一定要使用 下面的 for 循环结构,因为在加入左右节点时queue的大小会改变
            for (int i = queue.size()-1 ;i >=0 ; i--) {
                TreeNode nownode=queue.poll();
                tmp.add(nownode.val);
                if(nownode.left!=null) queue.add(nownode.left);
                if(nownode.right!=null) queue.add(nownode.right);
            }
            //将临时队列加入结果中
            ans.add(tmp);
        }
        return ans;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
