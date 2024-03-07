package Week2;

import java.util.NoSuchElementException;

public class Stack<T> {
    private Node<T> top = null;
    private int size = 0;

    public void push(T data){
        Node<T> newNode = new Node();
        newNode.data = data;
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop(){
        if(size == 0){
            throw new NoSuchElementException("No such element!");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek(){
        if(size == 0){
            throw new NoSuchElementException("No such element!");
        }
        return top.data;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
}
