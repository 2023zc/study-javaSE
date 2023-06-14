package bases;

import java.util.*;
import java.util.stream.Collectors;


public class Array_list {
    public static void main(String[] args) {

        //1.通过集合工具包Collextions.addAll的方法添加(最高效)
        Integer[] a1 = {8, 1, 96, 41, 2, 3, 52};   //这里的Integer并不等于int,具体看:https://blog.csdn.net/m0_47743353/article/details/122810501
        List<Integer> lists1 = new ArrayList<>(a1.length);
        Collections.addAll(lists1, a1);
        /*
        2.通过JDK8的Stream流将3总基本类型数组转为List,
        分别是int[],long[],double[],不支持short[],byte[],char[]在JDK1.8中暂不支持.
         */
        int[] ints = {2, 34, 55, 22, 11};
        long[] longs = {1, 2, 3};
        double[] doubles = {1, 2, 3};

        List<Integer> list_int = Arrays.stream(ints).boxed().collect(Collectors.toList());
        List<Long> list_long = Arrays.stream(longs).boxed().collect(Collectors.toList());
        List<Double> list_doubles = Arrays.stream(doubles).boxed().collect(Collectors.toList());

        //之后就可以使用list类的十分方便的方法了
        list_int.size();//获取长度
        //list_int.isEmpty(); //是否为空
        System.out.println(list_int.contains(2));  //判断2是否在列表中
        System.out.println(list_int.get(4));  //获取指定下标的数据
        list_int.clear(); //全部删除，清空
        /*
        ............
         */
    }

}
