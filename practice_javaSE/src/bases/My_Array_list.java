package bases;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class My_Array_list {
    public static void main(String[] args) {
        ArrayList <String> list=new ArrayList<>();

        list.add("黑枸杞");
        list.add("枸杞子");
        list.add("人字拖");
        list.add("特极枸杞");
        list.add("宁夏枸杞");
        list.add("Java入门");
        System.out.println(list);
        //删除集合中的数据时有两种方法:
        /*
        方法一:正着删，每次删除都让i--；
        方法二:反着删除即可
         */
        for(int i=list.size()-1;i>=0;i--){
            String str=list.get(i);
            if(str.contains("枸杞")){
                list.remove(str);
            }
        }
        System.out.println(list);
    }
}
