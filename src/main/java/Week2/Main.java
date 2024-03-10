package Week2;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("a");
        stack.push("b");
        stack.push("c");

        //System.out.println(stack.pop());
        //System.out.println(stack.peek());


        // Queue test
        Queue<Double> queue = new Queue<>();
        queue.enqueue(4.5);
        queue.enqueue(3.14);
        queue.enqueue(-2.01);

        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());

        Queue<Integer> queue2 = new Queue<>();

        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);

        System.out.println("Queue demo: ");
        System.out.println("peek: " + queue2.peek());
        System.out.println(queue2.dequeue());
        System.out.println(queue2.dequeue());
        System.out.println(queue2.dequeue());
        queue2.enqueue(4);

        System.out.println("queue size: " + queue2.size());
    }
}
