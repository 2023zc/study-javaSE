package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode刷题:https://leetcode-cn.com/problems/find-median-from-data-stream/
//数据中的中位数

public class MedianFinder {

    //小根堆,存储大的那一半
    private Queue<Integer> minpriorityQueue=new PriorityQueue<>();
    //大根堆,存储小的那一半
    private Queue<Integer> maxPriorityQueue=new PriorityQueue<>((x,y)->(y -x));

    //查找中位数
    public MedianFinder() {
    }

    //添加数据
    public void addNum(int num) {
        //表明小根堆的数据数量较多,需要将数据添加到大根堆中
        if(minpriorityQueue.size()!=maxPriorityQueue.size()){
            //需要先将数据添加到小根堆中进行排序,之后将排序得到的顶上最小的数据存到大根堆中
            minpriorityQueue.add(num);
            maxPriorityQueue.add(minpriorityQueue.poll());
        }
        //表明大根堆的数据数量较多,需要将数据添加到小根堆中
        else{
            maxPriorityQueue.add(num);
            minpriorityQueue.add(maxPriorityQueue.poll());
        }
    }

    public double findMedian() {
        return minpriorityQueue.size()==maxPriorityQueue.size() ? (minpriorityQueue.peek()+maxPriorityQueue.peek())/2.0 : minpriorityQueue.peek();
    }

}
