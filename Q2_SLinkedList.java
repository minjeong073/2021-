package Stack.Q2;

import java.util.EmptyStackException;
import java.util.Scanner;


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
        Node p = top;
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


public class Q2_SLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLinkedStack<String> stack = new SLinkedStack<String>();

        String A = sc.next();
        String[] arr = A.split("");
        
        sc.close();

        
        for (int i=0; i<A.length(); i++) {
            //연산자
            if (arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("*") || arr[i].equals("/")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());

                switch(arr[i]) {
                    case "+" :
                    int c = b+a;
                    stack.push(Integer.toString(c));
                    break;

                    case "-" :
                    c = b-a;
                    stack.push(Integer.toString(c));
                    break;

                    case "*" :
                    c = b*a;
                    stack.push(Integer.toString(c));
                    break;

                    case "/" :
                    c = b/a;
                    stack.push(Integer.toString(c));
                    break;

                }
                

            }
            //숫자
            else {
                stack.push(arr[i]);
            }
        }

        System.out.println("연산 결과 : "+ stack.pop());

        if (stack.isEmpty()) {
            System.out.println("연산을 종료합니다");
        }
        else {
            System.out.println("식이 올바르지 않습니다");
        }
    }
}
