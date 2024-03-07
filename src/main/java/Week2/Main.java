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
    }
}
