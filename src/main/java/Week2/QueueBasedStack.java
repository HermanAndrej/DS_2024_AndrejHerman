package Week2;

public class QueueBasedStack<T> {
    private Queue<T> q1;
    private Queue<T> q2;

    public QueueBasedStack() {
        q1 = new Queue<T>();
        q2 = new Queue<T>();
    }

    //To add a new element to the stack → push():
    //Add the element to q2.
    //One by one, remove all elements from q1 and add them to q2.
    //Swap the queues q1 and q2.
    public void push(T data) {
        q2.enqueue(data);
        while(!q1.isEmpty()){
            q2.enqueue(q1.dequeue());
        }
        Queue<T> tempQueue = new Queue<>();
        tempQueue = q1;
        q1 = q2;
        q2 = tempQueue;
    }

    public T pop() {
        return q1.dequeue();
    }

    public T peek() {
        return q1.peek();
    }

    public int size() {
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}