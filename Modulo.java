import java.util.Scanner;

public class Modulo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int count = 0;
		
		boolean[] rem = new boolean[42];
		for (int i=0; i<42; i++) {
			rem[i] = true;
		}
		
		for (int i=0; i<10; i++) {
			n = sc.nextInt();
			rem[n%42] = false;
		}
		
		for (int i=0; i<42; i++) {
			if (!rem[i]) {
				count += 1;
			}
		}
		System.out.println();
		System.out.println(count);
		sc.close();
	}

}
