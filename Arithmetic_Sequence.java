import java.util.Scanner;

public class Arithmetic_Sequence {
	
	public static int seq(int num) {
		int a = 0;
		int b = 0;
		int c = 0;
		int check = 0;
		
		if (num==1000) {
			check = 0;
		}
		else {
			while (num>0) {	
				a = num%10;
				num = num/10;
				b = num%10;
				num = num/10;
				c = num%10;
				num = num/10;			
			}
			if (c==0) {	//1,2자리수
				check = 1;
			}
			else {	//3자리수
				if (c+a == 2*b) {
					check = 1;
				}
				else {
					check = 0;
				}
			}
		}
		
		return check;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상 1000이하의 정수를 입력하세요 > ");
		int N = sc.nextInt();
		int c = 0;
		
		for (int i=1; i<=N; i++) {
			c += seq(i);
		}
		System.out.println(c);
		sc.close();
	}

}
