import java.util.Scanner;

public class BJ2739 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int arr[] = new int[t];
		
		int i;
		for(i=0;i<t;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[i] = a + b;		
		}
		sc.close();
		
		for(i=0;i<t;i++) {
			System.out.println(arr[i]);
		}

	}

}
