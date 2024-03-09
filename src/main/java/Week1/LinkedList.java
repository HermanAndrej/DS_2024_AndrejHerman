package Week1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList <T> implements Iterable<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public void addToFront(T data){
        Node<T> newNode = new Node();
        newNode.data = data;
        if(size == 0){
            newNode.next = null;
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addToRear(T data){
        Node<T> newNode = new Node();
        newNode.data = data;
        if(head == null){
            head = newNode;
        } else {
            Node<T> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void removeFromFront(){
        if(size == 0){
            throw new NoSuchElementException("List is empty!");
        } else {
            head = head.next;
            size--;
        }
    }

    public void removeFromRear(){
        if(size == 0){
            throw new NoSuchElementException("List is empty!");
        } else if(size == 1){
            head = null;
        } else {
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
            throw new IndexOutOfBoundsException("Invalid node!");
        }
        int i = 0;
        Node<T> current = head;
        while(i < index){
            current = current.next;
            i++;
        }
        return current.data;
    }

    public void reverse(){
        Node<T> current = head;
        Node<T> previous = null;

        while(current != null){
            Node<T> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    // Example: If the list is 1 → 2 → 3 → 4, and add(2, 5) is invoked,
    // the resulting list should be: 1 → 2 → 5 → 3 → 4

    public void add(int index, T data){
        Node<T> newNode = new Node<>();
        newNode.data = data;
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        if(index == 0){
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for(int i = 0; i < index - 1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    // Example:  If the list is 1 → 2 → 3 → 4, and remove(2) is invoked,
    // the resulting list should be: 1 → 2 → 4

    public void remove(int index){
        if(index < 0 || index > size){
            throw new NullPointerException("Index out of bounds!");
        }
        if(index == 0){
            head = head.next;
        } else {
            Node<T> current = head;
            for(int i = 0; i < index-1; i++){
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>{
        Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}

