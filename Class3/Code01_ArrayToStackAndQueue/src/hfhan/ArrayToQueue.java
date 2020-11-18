package hfhan;

/**
 * 用数组实现不超过固定大小的队列
 *
 * @author hanhuafeng
 * @version V1.0
 * @description
 * @date 2020/11/18
 */
public class ArrayToQueue {
    /**
     * 初始化一个数组，用于实现队列
     */
    private int[] arr;

    /**
     * 记录当前位置
     */
    private int size;

    /**
     * 插入的索引
     * 可以用if判断insert的位置是否大于size
     */
    private int insertIndex;

    /**
     * 弹出的索引
     */
    private int popIndex;

    /**
     * 数组的大小，规定不为0
     */
    private final int limit;


    public ArrayToQueue(int limit) {
        this.size = 0;
        this.arr = new int[limit];
        this.limit = limit;
        this.insertIndex = 0;
        this.popIndex = 0;
    }

    public void push(int num) {
        if (limit != size) {
            size++;
            arr[insertIndex] = num;
            insertIndex = nextIndex(insertIndex);
        } else {
            throw new RuntimeException("队列满了");
        }
    }

    public int pop() {
        if (size != 0) {
            size--;
            int ans = arr[popIndex];
            popIndex = nextIndex(popIndex);
            return ans;
        } else {
            throw new RuntimeException("队列空了");
        }
    }

    public boolean isEmpty(){
        return size==0;
    }

    private int nextIndex(int i){
        return i < limit - 1?i+1:0;
    }

    /**
     * 打印当前栈元素
     */
    public void print() {
        System.out.print("数组打印：");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayToQueue arrayToQueue = new ArrayToQueue(5);
        arrayToQueue.push(1);
        arrayToQueue.push(2);
        arrayToQueue.push(3);
        arrayToQueue.push(4);
        arrayToQueue.push(5);
        System.out.println("size:" + arrayToQueue.size);
        // 此处会报队列满了
        //arrayToQueue.push(6);
        // 打印出1,2,3,4,5,
        arrayToQueue.print();
        System.out.println("推出结果：" + arrayToQueue.pop());
        System.out.println("size:" + arrayToQueue.size);
        arrayToQueue.push(6);
        arrayToQueue.print();
        System.out.println("推出结果：" + arrayToQueue.pop());
        System.out.println("size:" + arrayToQueue.size);
        arrayToQueue.print();
        System.out.println("推出结果：" + arrayToQueue.pop());
        System.out.println("size:" + arrayToQueue.size);


    }
}
