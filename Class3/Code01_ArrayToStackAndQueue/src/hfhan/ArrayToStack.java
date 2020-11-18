package hfhan;

/**
 * 用数组实现不超过固定大小的栈
 * @author hanhuafeng
 * @version V1.0
 * @description
 * @date 2020/11/17
 */
public class ArrayToStack {
    /**
     * 初始化一个数组，用于实现队列
     */
    private int[] arr;
    /**
     * 有一个指针，去指向当前插入或移除的位置
     */
    private int index;

    /**
     * 初始化一个指定长度的数组
     * @param size
     */
    public ArrayToStack(int size){
        // 初始化一个指定长度的数组
        arr = new int[size];
        // 初始化指针位置在0
        index = 0;
    }

    /**
     * 实现入栈方法
     */
    public void push(int num){
        if(index >= arr.length){
            throw new RuntimeException("栈满了");
        }
        arr[index++] = num;
    }

    /**
     * 实现出栈方法
     * @return 返回栈中最后一个入栈的数据
     */
    public int pop(){
        if(index == 0){
            throw new RuntimeException("栈空了");
        }
        return arr[--index];
    }


    /**
     * 打印当前栈元素
     */
    public void print(){
        for (int value : arr) {
            System.out.print(value + ",");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ArrayToStack arrayToStack = new ArrayToStack(5);
        arrayToStack.push(5);
        arrayToStack.print();
        System.out.println(arrayToStack.pop());
        arrayToStack.print();
        // 这边会提示栈空了
        //System.out.println(arrayToStack.pop());
        arrayToStack.push(6);
        arrayToStack.push(7);
        arrayToStack.push(8);
        arrayToStack.push(9);
        arrayToStack.push(10);
        // 这边会提示栈满了
        //arrayToStack.push(8);
        arrayToStack.print();
        System.out.println(arrayToStack.pop());
        arrayToStack.print();
    }
}
