package Tasks;

import java.util.Arrays;

public class Queue {
    private int[] queue;
    private int first;
    private int last;
    private int size;
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        first = 0;
        last = capacity - 1;
        size = 0;
    }

    public boolean isFull() {
        return size==capacity;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void insertElement(int element) {
        if(isFull()) {
            System.out.println("The queue is full");
            return;
        }
        last = (last + 1) % capacity;
        queue[last] = element;
        size++;
    }
    public int deleteElement() {
        if(isEmpty()) {
            System.out.println("The queue is empty");
            return Integer.MIN_VALUE;
        }
        int element = queue[first];
        queue[first] = 0;
        first = (first + 1) % capacity;
        size--;
        return element;
    }

    public void queueShow(){
        if(isEmpty()){
            System.out.println("The queue is empty");
            return;
        }
        System.out.println(Arrays.toString(queue));
    }
}
