package hfhan;

import java.util.Stack;

/**
 * 实现从一个栈中取最小值GetMin，要求时间复杂度O(1)
 * @author hanhuafeng
 * @version V1.0
 * @description
 * @date 2020/11/18
 */
public class StackGetMin {
    private Stack<Integer> pushStack;

    private Stack<Integer> minStack;


    public StackGetMin(){
        pushStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val){
        if(minStack.empty()){
            minStack.push(val);
        }else{
            minStack.push(val<minStack.peek()?val:minStack.peek());
        }
        pushStack.push(val);
    }

    public int pop(){
        if (pushStack.empty()){
            throw new RuntimeException("栈还是空的!");
        }
        this.minStack.pop();
        return pushStack.pop();
    }

    public int getMin(){
        if(pushStack.empty()){
            throw new RuntimeException("栈还是空的!1");
        }
        return this.minStack.peek();
    }

    public static void main(String[] args) {
        StackGetMin stackGetMin = new StackGetMin();
        stackGetMin.push(1);
        stackGetMin.push(2);
        stackGetMin.push(3);
        stackGetMin.push(4);
        stackGetMin.push(0);
        System.out.println(stackGetMin.getMin());
        System.out.println(stackGetMin.pop());
        System.out.println(stackGetMin.getMin());
    }

}
