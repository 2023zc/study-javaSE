package leetcode;


//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/5dshwe/(树的子结构)
public class SubTree {

        //从头节点开始向下遍历,如果找到A节点的值与B节点的头节点的值相同就调用recur函数搜索
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if(A==null || B==null) return false;  //剪枝
            boolean ans;
            ans=recur(A,B);  //从当前节点开始搜索
            if(ans) return true;  //如果已经找到了直接返回true即可
            //用 || 连接,一旦找到true就直接向上传递
            ans=isSubStructure(A.left,B)||isSubStructure(A.right,B);
            return ans;
        }

        //从当前节点开始搜索,判断B是否为A的子树
        public boolean recur(TreeNode A,TreeNode B){
            //当B空时表示已经找到了子树,返回true
            if(B==null) return true;
            if(A==null ||A.val!=B.val) return false;
            //一直向下找
            return recur(A.left,B.left)&&recur(A.right,B.right);
        }

        //树节点
        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
       }
}
