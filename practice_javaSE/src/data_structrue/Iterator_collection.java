package data_structrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class Iterator_collection {
    public static void main(String[] args) {

        Collection<String> collection=new ArrayList<>();
        collection.add("hello");
        collection.add("world");
        //1.迭代器遍历
        //如果集合中没有元素，那么创建迭代器会报错
        Iterator<String> it=collection.iterator();
        //hasNext是判断当前位置是否有元素
        while(it.hasNext()) {
            //next方法是获取当前位置的元素并移动指针
            System.out.println(it.next());
        }

        /*
        迭代器小细节：
        1.报错NoSuchElementException(循环完成后)
        2.迭代器遍历完毕，指针不会复位(如果要必须重新生成一个迭代器对象)
        3.循环中只能用一次next方法
        4.迭代器遍历时，不能用集合的方法进行增加或者删除
         如果要删除可以使用迭代器的删除方法
         */

        //2.强化for循环
        //底层其实就是一个迭代器,目的是为了简化书写
        //s是第三方变量,在循环中依次表示集合中的每一个数据
        for(String s:collection) {
            System.out.println(s);
        }

        //3.lambda表达式遍历
        //底层原理:通过for循环依次得到每一个数据
        //再将每个元素传递到下面的accept方法
        //s表示每一个元素
        collection.forEach(s -> System.out.println(s));

        //如果想要删除元素，可以使用迭代器遍历
    }
}
