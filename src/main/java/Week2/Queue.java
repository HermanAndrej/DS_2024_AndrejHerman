package Week2;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public void enqueue(T data){
        Node<T> node = new Node<>();
        node.data = data;
        if(size != 0){
            tail.next = node;
            tail = node;
        } else{
            head = tail = node;
        }
        size++;
    }

    public T dequeue(){
        T data;
        if(size == 0){
            throw new NoSuchElementException("Queue is empty!");
        } else if(size == 1){
            data = head.data;
            head = tail = null;
        }else{
            data = head.data;
            head = head.next;
        }
        size--;
        return data;
    }

    public T peek(){
        if(size == 0){
            throw new NoSuchElementException("Queue empty!");
        }
        else{
            return head.data;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

}
