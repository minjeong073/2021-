
public class Main {
	
	//d(n) 함수
	public static int d(int num) {
		int sum = num;
		while (num>0) {
			sum += num%10;
			num = num/10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		boolean[] check = new boolean[10001];
		
		//생성자 있는 숫자 true로 저장
		for (int i=1; i<10001; i++) {
			int n = d(i);
			
			if (n<10001) {
				check[n] = true;
			}
		}
		
		//false인 숫자(=셀프넘버)만 출력
		for (int i=1; i<10001; i++) {
			if (!check[i]) {
				System.out.println(i);
			}
		}
	}

}
