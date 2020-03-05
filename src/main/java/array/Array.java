package array;

import java.util.Arrays;

public class Array {
    private int[] data;
    private int size;

    /**
     * 自定义容量大小
     */
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }

    /**
     * 默认容量10
     */
    public Array(){
        this(10);
    }
    /**
     * 获取数组中元素个数
     */
    public int getSize(){
        return size;
    }
    /**
     * 获取数组容量
     */
    public int getCapacity(){
        return data.length;
    }
    /**
     * 判读数组是否为空
     */
    public boolean isEmpty(){
        return size == 0 ? true:false;
    }

    /**
     * 追加元素
     * @param e
     */
    public void add(int e){
        if (size == data.length){
            throw new IllegalArgumentException("数组已满");
        }
        data[size] = e;
        size++;
    }
    /**
     *
     *     //[1][2][3][4]
     *     // 0  1  2  3
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size >= data.length){
            throw new IllegalArgumentException("数组已满");
        }
        if (index<0 || index>size) {
            throw new IllegalArgumentException("下标超出界");
        }
        // 添加元素的下标
        for (int i=size-1 ;index<=i; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     * @param index
     * @return
     */
    public int remove(int index){
        if (index<0 || index>size) {
            throw new IllegalArgumentException("下标超出界");
        }
        int result = data[index];
        for (int i =index+1; i<size; i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = 0;
        return result;
    }

    /**
     * 查询元素下标
     * @param e
     * @return
     */
    public int find(int e){
        int index = -1;
        for (int i=0; i<size;i++){
            if (e==data[i]){
                index=i;
            }
        }
        return index;
    }

    /**
     * 根据元素删除
     * @param e
     */
    public void removeElement(int e){
        int i = find(e);
        if (i !=-1){
            remove(i);
        }
    }


    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
