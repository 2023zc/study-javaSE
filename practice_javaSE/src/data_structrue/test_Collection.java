package data_structrue;

import java.util.ArrayList;
import java.util.Collection;


public class test_Collection {
    public static void main(String[] args) {
        //Collection是接口,只能生成接口的实现类
        Collection<String> collection=new ArrayList<>();

        //add返回是否添加成功的布尔值
        collection.add("111");
        collection.add("222");
        collection.add("333");

        //remove返回是否删除成功的布尔值
        collection.remove("111");


        //contains是调用对象的equals方法进行逐个比较
        //所有如果对象是自定义对象,那么就必须重写equals方法
        //否则会调用Object类中的equals方法进行比较(比较地址值)
        System.out.println(collection.contains("222"));

        //判断是否为空
        collection.isEmpty();

        //获取集合的长度
        int a=collection.size();
        System.out.println(a);
    }
}
