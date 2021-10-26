package Stack.Q2;

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

   
}


public class Q2_ArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrStack<String> stack = new ArrStack<String>();

        String A = sc.next(); //327+*
        String[] arr = A.split("");
        String[] oper = {"+", "-", "*", "/"};

        sc.close();

        for (int i=0; i<arr.length; i++) {
            //입력 값이 연산자일 경우
            if (arr[i].equals(oper[0]) || arr[i].equals(oper[1]) || arr[i].equals(oper[2]) || arr[i].equals(oper[3])) {

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
            //숫자일 경우
            else {
                stack.push(arr[i]);
            }
        }

        System.out.println("연산 결과 = " + stack.pop());

        if (stack.isEmpty()) {
            System.out.println("연산이 끝났습니다");
        } else {
            System.out.println("Error! 식이 맞지 않습니다");
        }
        

    }
    
}
