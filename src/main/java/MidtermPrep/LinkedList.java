package MidtermPrep;

import java.util.NoSuchElementException;

public class LinkedList <T>{
    private Node<T> head;
    private int size = 0;

    public void addToFront(T data){
        Node<T> node = new Node<T>();
        node.data = data;
        node.next = head;
        head = node;
        size++;
    }

    public void addToRear(T data){
        Node<T> node = new Node<T>();
        node.data = data;
        if(head == null){
            head = node;
        }else{
            Node<T> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    public void removeFromFront(){
        if(head == null){
            throw new NoSuchElementException();
        } else{
            head = head.next;
            size--;
        }
    }

    public void removeFromRear(){
        if(head == null){
            throw new NoSuchElementException();
        } else if(size == 1){
            head = null;
        }else{
            Node<T> current = head;
            while(current.next.next != null){
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    public int count(){
        return size;
    }

    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }

        return current.data;
    }
}
