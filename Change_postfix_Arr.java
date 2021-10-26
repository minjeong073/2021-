
import java.util.EmptyStackException;
import java.util.Scanner;

class ListStack<E> {
    private E stack[];
    private int top;
    public ListStack() {
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

    //delete
    public void delete() {
        if (isEmpty()) throw new EmptyStackException();
        stack[top--] = null;

        if (size()>0 && size() == stack.length/4) {
            resize(stack.length/2);
        }
    }

   
}

//중위표기법을 후위표기법으로 변경
public class Change_postfix_Arr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListStack<String> stack = new ListStack<String>(); //임시버퍼
        ListStack<String> print = new ListStack<String>(); //출력내용버퍼

        String A = sc.next();
        String[] arr = A.split("");
        String[] print_f = new String[A.length()]; //출력
        String[] oper = {"+", "-", "*", "/"};
        sc.close();

        //(A+B)*C
        for (int i=0; i<arr.length; i++) {

            // +,-
            if (arr[i].equals(oper[0]) || arr[i].equals(oper[1])) {
                
                //저장된 값이 *,/ 인 경우
                if (stack.peek().equals(oper[2]) || stack.peek().equals(oper[3])) {
                    print.push(stack.pop());
                    stack.push(arr[i]);
                }
                else {
                    stack.push(arr[i]);
                }
                
            }

            // *,/
            else if (arr[i].equals(oper[2]) || arr[i].equals(oper[3])) {
                stack.push(arr[i]);
            }

            // ()
            else if (arr[i].equals("(")) {
                stack.push("(");

            }

            else if (arr[i].equals(")")) {
                print.push(stack.pop());
                stack.delete();

            }

            //숫자
            else {
                print.push(arr[i]);
            }
        }
        for (int i=0; i<stack.size(); i++) {
            
        }
        for (int i=0; i<A.length(); i++) {
            System.out.println(print.pop());

        }
        
        for (int j=0; j<A.length(); j++) {
            for (int i=A.length()-1; i>=0; i--) {
                print_f[i] = print.pop();
            }
            System.out.print(print_f[j]+" ");
        }

    }
    
}
