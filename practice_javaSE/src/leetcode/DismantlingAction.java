package leetcode;

import java.util.LinkedList;
import java.util.Queue;

//leetcode:https://leetcode.cn/leetbook/read/illustration-of-algorithm/5viisg/
//招式拆解 II
public class DismantlingAction {
    public char dismantlingAction(String list) {
        Queue<Character> queue=new LinkedList<>();
        //计数数组
        int[] count=new int[26];
        //标记数组
        boolean[] book=new boolean[26];
        for (char c : list.toCharArray()) {
            //计数
            count[c-'a']++;
            //如果是第一个,那么就加入队列中
            if(count[c-'a']==1) queue.add(c);
            //当队列中首个原始
            if(count[c-'a']>1 && !book[c-'a'] && queue.peek()==c) {
                //将首个的第一次出现的出现次数为1的找出来
                while(!queue.isEmpty() && count[queue.peek()-'a']>1){
                    book[queue.peek()-'a']=true;
                    queue.remove();
                }
            }
        }
        if(queue.isEmpty()) return ' ';
        return queue.peek();
    }
}
