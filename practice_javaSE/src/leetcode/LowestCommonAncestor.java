package leetcode;


public class LowestCommonAncestor {


//leetcode刷题:https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//二叉搜索树的最近公共祖先

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans=new TreeNode(0);
        if((root.val>p.val&&root.val<q.val)||(root.val<p.val&&root.val>q.val)) return root;
        if(root.val==p.val||root.val==q.val) return root;
        //都在左树
        if(root.val>p.val&&root.val>q.val){
            ans=lowestCommonAncestor(root.left,p,q);
        }
        //都在右树
        if(root.val<p.val&&root.val<q.val){
            ans=lowestCommonAncestor(root.right,p,q);
        }
        return ans;
    }

    /*
    以下为更简单的写法,不需要递归,节省了空间
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(root.val>p.val&&root.val>q.val)root=root.left;
            else if(root.val<p.val&&root.val<q.val)root=root.right;
            else break;
        }
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
