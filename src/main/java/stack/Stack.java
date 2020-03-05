package stack;

public class Stack {
    private int [] data;
    private int size;
    private int capacity;
    /**
     * 初始化栈
     * @param capacity
     */
    public Stack(int capacity){
        this.data = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * 入栈
     * @return
     */
    public boolean push(int e){
        boolean flag = false;
        if (size == capacity){
            throw new IllegalArgumentException("栈已满");
        }
        data[size] = e;
        size++;
        return flag;
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        if (size==0) {
            throw new IllegalArgumentException("栈中没有元素");
        }
        int result = data[size-1];
        size--;
        return result;
    }
}
