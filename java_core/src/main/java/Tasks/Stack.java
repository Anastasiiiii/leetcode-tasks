package Tasks;

import java.util.Arrays;

public class Stack<C> {
    private int[] stack;
    private int first;
    private int capacity;
    private int size;

    public Stack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        first = 0;
        size = 0;
    }

    public boolean isFull(){
        return size==capacity;
    }

    public boolean isEmpty(){
        return size==0;
    }


    public void insertElement(int data){
        if(isFull()){
            System.out.println("The stack is full");
        }
        stack[first] = data;
        first++;
        size++;
    }

    public int deleteElement() {
        if(isEmpty()){
            System.out.println("The stack is empty");
            return Integer.MIN_VALUE;
        }
        int element;
        first--;
        element = stack[first];
        stack[first] = 0;
        size--;
        return element;
    }

    public void stackShow() {
        if(isEmpty()){
            System.out.println("The stack is empty");
        }
        System.out.println(Arrays.toString(stack));
    }
}
