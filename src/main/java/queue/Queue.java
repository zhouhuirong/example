package queue;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Queue {
    private int[] data;
    private int size;
    private int capacity;
    private int tempSize;

    //队列大小
    private final int QUEUE_LENGTH = 10000*10;
    private BlockingQueue<String> queue = new LinkedBlockingQueue<String>(QUEUE_LENGTH);

    /**
     * 初始化队列
     * @param capacity
     */
    public Queue(int capacity){
        this.data = new int[capacity];
        this.size = 0;
        this.tempSize = 0;
        this.capacity = capacity;
    }

    /**
     * 存放数据
     * 1 2 3 4 5
     * 4 3 2 1 0
     * @param e
     */
    public void push(int e){
        if (size == capacity){
            throw new IllegalArgumentException("队列已满");
        }
        if (size == 0){
            data[0] = e;
        }else {
            for (int i=size;i>0;i--){
                data[i] = data[i-1];
            }
            data[0] = e;
        }
        size++;
        tempSize++;
    }

    /**
     * 取出数据
     * @return
     */
    public int pop(){
        if (tempSize==0) {
            throw new IllegalArgumentException("队列中元素已取完");
        }
        int result = data[tempSize-1];
        tempSize--;
        return result;
    }

    /**
     * 删除头元素
     */
    public void remove(){
        if (size==0) {
            throw new IllegalArgumentException("队列中没有元素");
        }
        data[size-1] = 0;
        size--;
    }


    @Override
    public String toString() {
        return "Queue{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
