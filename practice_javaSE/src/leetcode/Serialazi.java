package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode刷题:https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
//二叉树的序列化和反序列化
public class Serialazi {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    String serialize(TreeNode root) {
        return buildstring(root);
    }

    private String str="";
    private String buildstring(TreeNode cur) {
        //null用于区分叶子节点和普通节点
        if(cur==null){
            str+="null,";
        }
        else {
            //其他节点就直接加上值即可
            str+=(cur.val+",");
            //这里采用的是深度搜索的先序遍历
            buildstring(cur.left);
            buildstring(cur.right);
        }
        return str;
    }
     //Decodes your encoded data to tree.
    TreeNode deserialize(String data) {
        if(data==null) return null;
        //用","分割成每个节点的值
        String[] strarr=data.split(",");
        LinkedList<String> nodes_val=new LinkedList<>(Arrays.asList(strarr));  //分解成每个节点的值
        return redeserialize(nodes_val);
    }

    private TreeNode redeserialize(List<String> nodes_val){
        //如果是null就直接返回null
        if(nodes_val.get(0).equals("null")){
            //记得每次都要将第一个值删除
            nodes_val.remove(0);
            return null;
        }
        //建节点
        TreeNode root=new TreeNode(Integer.parseInt(nodes_val.get(0)));
        //记得每次都要将第一个值删除
        nodes_val.remove(0);
        //建立左节点
        root.left=redeserialize(nodes_val);
        //建立右节点
        root.right=redeserialize(nodes_val);
        return root;
    }

    public static void main(String[] args) {
        String str="1,2,null,null,3,null,null,";
        Serialazi s=new Serialazi();
        TreeNode node = s.deserialize(str);
        String serialize = s.serialize(node);
        System.out.println(serialize);
    }

}
