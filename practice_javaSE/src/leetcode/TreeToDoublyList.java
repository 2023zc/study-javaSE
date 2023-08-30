package leetcode;

//leetcode刷题:https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
//二叉搜索树与双向链表
public class TreeToDoublyList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    /*
    q:什么是二叉搜索树?
    a:若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树
     */

    private Node head,pre;   //head表示头节点,也就是最左边的叶子节点,pre表示之前的一个节点
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;  //特判
        dfs(root);
        //最后调整一下节点即可
        head.left=pre;
        pre.right=head;
        return head;
    }


    private void dfs(Node nownode){
        if(nownode==null) return;
        //需要中序遍历
        //1.先遍历左子树
        dfs(nownode.left);
        //2.当前节点
        //当达到最后一个叶子节点时,因为pre初始化为null,所以就会确定head头节点
        //否则就让前一个节点与当前节点建立链表关系
        if(pre!=null) pre.right=nownode;
        else head=nownode;
        nownode.left=pre;
        //更新前一个节点
        pre=nownode;
        //3.最后遍历右子树
        dfs(nownode.right);
    }
}
