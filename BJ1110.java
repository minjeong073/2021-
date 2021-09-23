import java.util.Scanner;

public class BJ1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int T = N; // 처음 입력값 복사 --> 새로운 변수 N과 비교하기 위함
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
