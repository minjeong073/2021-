
import java.util.EmptyStackException;
import java.util.Scanner;


class Node_ <E> {
    private E item;
    private Node_<E> next;
    public Node_(E newItem, Node_<E> Node_) {
        item = newItem;
        next = Node_;
    }

    public E getItem() { return item; }
    public Node_<E> getNext() { return next; }
    public void setItem(E newItem) { item = newItem; }
    public void setNext(Node_<E> newNext) { next = newNext; }
}

class SLinkedStack <E> {
    protected Node_<E> top;
    private int size;
    public SLinkedStack() {
        top = null;
        size = 0;
    }
    public boolean isEmpty() { return size == 0; }
    
    //push
    public void push(E newItem) {
        Node_ newNode_ = new Node_(newItem, top);
        top = newNode_;
        size++;
    }

    //pop
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E topItem = top.getItem();
        top = top.getNext();
        size--;
        return topItem;
    }

    //peek
    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.getItem();
    }

    //print
    public void print() {
        System.out.println("***");
        Node_ p = top;
        for (int i=0 ; i< size; i++){
            System.out.print(p.getItem() + " ");
            p = p.getNext();
        }
        System.out.println();
        System.out.println("***");
    }

    //size
    public int size() {
        return size;
    }
}


public class Change_postfix_SLL {
    public static void main(String[] args) {

    }
}
