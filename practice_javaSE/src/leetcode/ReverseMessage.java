package leetcode;

import java.util.ArrayList;
import java.util.List;

//leetcode刷题:https://leetcode-cn.com/problems/reverse-words-in-a-string/
//字符串中的单词反转
public class ReverseMessage {
    public String reverseMessage(String message) {
        //去除头尾空格
        String newMessage = message.strip();
        if(newMessage.equals("")) return "";
        StringBuilder tmp = new StringBuilder(),ans=new StringBuilder();
        List<String> list=new ArrayList<>();
        for(int i=0;i<newMessage.length();i++) {
            if(newMessage.charAt(i)!=' '){
                while(i<newMessage.length() && newMessage.charAt(i)!=' ') {
                    tmp.append(newMessage.charAt(i));
                    i++;
                }
                //保存字符串,并更新tmp
                i--;
                list.add(tmp.toString());
                tmp=new StringBuilder();
            }
        }
        //拼装结果
        for(int i=list.size()-1;i>0;i--){
            ans.append(list.get(i)).append(" ");
        }
        //最后一个字符串后不需要空格
        ans.append(list.get(0));
        return ans.toString();
    }
}
