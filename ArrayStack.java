import java.util.EmptyStackException;
import java.util.Scanner;

public class ArrayStack<E> {
	private E s[];
	private int top;
	
	public ArrayStack() {
		s = (E[]) new Object[1];
		top = -1;
	}
	public int size() {
		return top+1;
	}
	public boolean isEmpty() {
		return (top == -1);
	}
	
	//peek
	public E peek() {
		if (isEmpty()) throw new EmptyStackException();
		return s[top];
	}
	//push
	public void push(E newItem) {
		if (size() == s.length)
			resize(2*s.length);
		s[++top] = newItem;
	}
	//pop
	public E pop() {
		if(isEmpty()) throw new EmptyStackException();
		E item = s[top];
		s[top--] = null;
		if (size()>0 && size()==s.length/4)
			resize(s.length/2);
		return item;
	}
	//resize
	private void resize(int newSize) {
		Object[] t = new Object[newSize];
		for (int i=0; i<size(); i++)
			t[i] = s[i];
		s = (E[]) t;
	}
	//입력받기
	public static void main(String[] args) {
		ArrayStack<String> stack = new ArrayStack<String>();
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String[] input = a.split("");
		
		for(String str : input) {
			//열린 괄호 push로 넣기
			if(str.equals("(") || str.equals("{") || str.equals("["))
				stack.push(str);
			//")" 괄호이고, ()가 맞으면 pop
			else if(str.equals(")") && !stack.isEmpty() && stack.peek().equals("("))
				stack.pop();
			//"}" 괄호이고, {}가 맞으면 pop
			else if(str.equals("}") && !stack.isEmpty() && stack.peek().equals("{"))
				stack.pop();
			//"]" 괄호이고, []가 맞으면 pop
			else if(str.equals("]") && !stack.isEmpty() && stack.peek().equals("["))
				stack.pop();
			//짝이 맞지 않은 닫힌 괄호 push로 넣기
			else if(str.equals(")") || str.equals("}") || str.equals("]"))
				stack.push(str);
		}	
		
		if(stack.isEmpty())
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
