package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode刷题:https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/submissions/
//字符串的排列

public class Permutation {


    private List<String> ans=new ArrayList<>();

    private char[] S;
    private boolean[] book;
    public String[] permutation(String s) {
        StringBuilder str=new StringBuilder();
        //标记数组
        book=new boolean[s.length()];
        S=s.toCharArray();
        //我们首先对原字符串排序，保证相同的字符都相邻
        Arrays.sort(S);
        dfs(str);
        String[] Ans=new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            Ans[i]=ans.get(i);
        }
        return Ans;
    }

    public void dfs(StringBuilder str) {
        if(str.length()==S.length){
            ans.add(str.toString());
            return;
        }
        for(int i=0;i<S.length;i++){
            /*
            这里是去重条件:
            "i > 0 && !book[i - 1] && S[i - 1] == S[i]"
            1.i > 0既然是重复字符，就从i>0开始判断；
            2.!book[i - 1]前一个字符没有被填充（不满足顺序填充的要求）；
            3.S[i - 1] == S[i]前一个字符和自己相同（为重复字符串）。
             */
                if (book[i] || (i > 0 && !book[i - 1] && S[i - 1] == S[i])) {
                    continue;
                }
                //用回溯法求排序
                book[i]=true;
                str.append(S[i]);
                dfs(str);
                str.deleteCharAt(str.length()-1);
                book[i]=false;
        }
    }

    public static void main(String[] args) {
        String s="aja";
        Permutation permutation= new Permutation();
        String[] permutation1 = permutation.permutation(s);
        for (String i : permutation1) {
            System.out.println(i);
        }
    }
}
