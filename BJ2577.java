import java.lang.Math;
import java.util.Scanner;

public class BJ2577 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int D = A*B*C;
		String d = Integer.toString(D);
		int n = d.length();
		int[] arr = new int[n];
		int[] arr2 = new int[10];
		
		//D를 string으로 변환해서 length 구해
		//string d = Integer.toString(D);
		//int n = d.length();
		//D = 233567 --> n = 6 10^n
		//arr[0]=(234567/10^4)-(234567/10^6)*10=2
		//2=2 --> arr2[2]=1
		//arr[1]=3 arr2[3]=1
		//arr[2]=3 --> arr2[3]=2
		//arr[6]=7 --> arr2[7]=1
		//23, 2를 빼야돼 
		//arr[0]=2, k=0
		for(int i=0; i<n; i++) {
			int a = (int) (Math.pow(10, (n-i-1)));
			int b = (int) (Math.pow(10,(n-i)));
			arr[i] = (D/a)-((D/b)*10);
						
			for(int k=0; k<=9; k++) {
				if(k == arr[i]) {
					arr2[k] += 1;
					break;
				} else
					continue;
				
			}
			
		}
		for(int i=0; i<10; i++) {
			System.out.println(arr2[i]);
		}
		
	}

}
