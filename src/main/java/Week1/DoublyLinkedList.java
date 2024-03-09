package Week1;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size = 0;

    /* Add a new node to the front of the doubly linked list */
    public void addToFront(T data) {
        DoubleNode<T> newNode = new DoubleNode<>();
        newNode.data = data;
        if(size == 0){
            newNode.prev = newNode.next = null;
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /* Remove a node from the front of the doubly linked list */
    public void removeFromFront() {
        if(size == 0){
            throw new IndexOutOfBoundsException("List is empty!");
        }

        if(size == 1){
            head = tail = null;
        }
        assert head != null;
        head = head.next;
        head.prev = null;
        size--;
    }

    /* Add a new node to the end of the doubly linked list */
    public void addToRear(T data) {
        DoubleNode<T> newNode = new DoubleNode<>();
        newNode.data = data;
        if(size == 0) {
            newNode.prev = newNode.next = null;
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    /* Remove a node at the end of the doubly linked list */
    public void removeFromRear() {
        if(size == 0){
            throw new IndexOutOfBoundsException("List is empty!");
        }

        if(size == 1){
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    /* Get a linked list node by index (0-indexed) */
    public T get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid node!");
        }
        int i = 0;
        DoubleNode<T> current = head;
        while(i < index){
            current = current.next;
            i++;
        }
        return current.data;
    }

    /* Add an element to a doubly linked list by index (0-index) */
    public void add(int index, T data) {
        DoubleNode<T> newNode = new DoubleNode<>();
        newNode.data = data;
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        if(index == 0){
            if (head != null) {
                head.prev = newNode;
            }
            newNode.next = head;
            head = newNode;
        } else {
            DoubleNode<T> current = head;
            for(int i = 0; i < index - 1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            newNode.prev = current;

        }
        size++;
    }

    /* Delete an element from a doubly linked list by index (0-index) */
    public void remove(int index) {
        if(index < 0 || index > size){
            throw new NullPointerException("Index out of bounds!");
        }
        if(index == 0){
            head = head.next;
            if(head != null){
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            DoubleNode<T> current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    /* Return the current size of the doubly linked list */
    public int count() {
        //your code
        return size;
    }

    /* Return an Iterator Object */
    @Override
    public Iterator<T> iterator() {
        //your code
        return new DoublyLinkedListIterator();
    }

    /* Define the Iterator class, and hasNext() and next() methods */
    private class DoublyLinkedListIterator implements Iterator<T> {
        private DoubleNode<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if(hasNext()){
                current = current.next;
                return current.data;
            }
            return null;
        }
    }

    /* Get head node (for test purposes) */
    public DoubleNode<T> getHead() {
        return head;
    }

    /* Get tail node (for test purposes) */
    public DoubleNode<T> getTail() {
        return tail;
    }
}
