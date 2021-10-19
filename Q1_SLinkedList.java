package Stack.Q1;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import jdk.internal.foreign.abi.x64.sysv.SysVVaList;

class Node <E> {
    private E item;
    private Node<E> next;
    public Node(E newItem, Node<E> node) {
        item = newItem;
        next = node;
    }

    public E getItem() { return item; }
    public Node<E> getNext() { return next; }
    public void setItem(E newItem) { item = newItem; }
    public void setNext(Node<E> newNext) { next = newNext; }
}

class SLinkedStack <E> {
    protected Node<E> top;
    private int size;
    public SLinkedStack() {
        top = null;
        size = 0;
    }
    public boolean isEmpty() { return size == 0; }
    
    //push
    public void push(E newItem) {
        Node newNode = new Node(newItem, top);
        top = newNode;
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
        Node p = head;
        for (int i=0 ; i< size; i++){
            System.out.print(p.getItem() + " ");
            p = p.getNext();
        }
        System.out.println();
    }

    //size
    public int size() {
        return size;
    }
}


public class Q1_SLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLinkedStack<String> stack = new SLinkedStack<String>() ;
        
        String a = sc.next();
        String[] arr = new String[a.length()];
        arr = a.split("");

        for (int i=0; i<a.length(); i++) {
            if (arr[i] == "(" || arr[i] == "{" || arr[i] == "[") {

            }
        }
    }
}
