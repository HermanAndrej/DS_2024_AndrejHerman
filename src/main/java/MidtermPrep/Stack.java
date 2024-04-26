package MidtermPrep;

public class Stack<Item> {

    /* Node implementation */
    private class Node <Item>{
        Item data;
        Node<Item> next;
    }

    private Node<Item> top = null;
    private int size = 0;

    /* Push an item onto the stack */
    public void push(Item item) {
        Node<Item> newNode = new Node<Item>();
        newNode.data = item;
        if(isEmpty()){
            top = newNode;
        } else{
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    /* Check if the stack is empty */
    public boolean isEmpty() {
        return size==0;
    }

    /* Remove the top item from the stack, and return its data */
    public Item pop() {
        if(isEmpty()){
            throw new RuntimeException();
        }
        Item nodeData = top.data;
        top = top.next;
        size--;
        return nodeData;
    }

    /* Return the current size of the stack */
    public int size() {
        return size;
    }
}