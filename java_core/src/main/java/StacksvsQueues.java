public class StacksvsQueues {
    public static void main (String[] args){
        //STACK
        Stack<Integer> stack = new Stack<Integer>(6);
        stack.insertElement(5);
        stack.insertElement(6);
        stack.insertElement(8);
        System.out.println("The stack is: ");
        stack.stackShow();
        System.out.println("The deleted element is: " + stack.deleteElement());
        stack.stackShow();


        //QUEUE
        Queue queue = new Queue(5);
        queue.insertElement(5);
        queue.insertElement(7);
        queue.insertElement(8);
        System.out.println("The queue is: ");
        queue.queueShow();
        System.out.println("The deleted element is: " + queue.deleteElement());
        queue.queueShow();

    }
}
