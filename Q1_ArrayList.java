package Stack.Q1;

import java.util.EmptyStackException;
import java.util.Scanner;

class ArrStack<E> {
    private E stack[];
    private int top;
    public ArrStack() {
        stack = (E[]) new Object[1];
        top = -1;
    }
    public int size() {return top+1;}
    public boolean isEmpty() {return (top == -1);}

    //push
    public void push(E newItem) {
        if (size() == stack.length) {
            resize(2*stack.length);
        }
        stack[++top] = newItem; 
    }

    //pop (반환 후 삭제)
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E item = stack[top];
        stack[top--] = null;

        if (size()>0 && size() == stack.length/4) {
            resize(stack.length/2);
        }
        return item;
    }

    //peek (반환)
    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top];
    }

    //resize
    public void resize(int newSize) {
        Object[] k = new Object[newSize];
        for (int i=0; i<size(); i++) {
            k[i] = stack[i];
        }
        stack = (E[]) k;
    }

    //print
    public String print() {
        String print = "### ";
        for (int i=0; i<size(); i++) {  
            print += stack[i];
            if (i<size()-1) {
                print += ',';
            }
        }
        return print + " ###";
    }
}

public class Q1_ArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrStack<Character> stack = new ArrStack<Character>();

        String a = sc.next(); 

        for (int i=0; i<a.length(); i++) {
            char c = a.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (c == ')') {
                if (stack.isEmpty()) {
                    stack.push(c);
                    break;
                }
                else if (!stack.isEmpty() && stack.peek().equals('(')) {
                    stack.pop();
                }
                else {
                    continue;
                }
            }
            else if (c == '}') {
                if (stack.isEmpty()) {
                    stack.push(c);
                    break;
                }
                else if (!stack.isEmpty() && stack.peek().equals('{')) {
                    stack.pop();
                }
                else {
                    continue;
                }
            }
            else if (c == ']') {
                if (stack.isEmpty()) {
                    stack.push(c);
                    break;
                }
                else if (!stack.isEmpty() && stack.peek().equals('[')) {
                    stack.pop();
                }
                else {
                    continue;
                }
            }
        }

        System.out.println("최종 stack : " + stack.print());

        if (stack.isEmpty()) {
            System.out.println("Yes finish!");
        } else {
            System.out.println("No :(");
        }
    }
}
