import java.util.Scanner;

public class BJ1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int T = N; // ó�� �Է°� ���� --> ���ο� ���� N�� ���ϱ� ����
		int count = 0;
		
		while(true) {
			N = ((N%10)*10) + (((N/10)+(N%10))%10) ;
			count++;
			
			if(T == N)
				break;
		}
		System.out.println(count);

	}

}
