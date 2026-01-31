import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			long a[] = new long[n + 1];

			int maxIndex = 0;
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				if(a[i] > a[maxIndex]) {
					maxIndex = i;
				}
			}

			a[n] = a[0];

			long answer = -a[maxIndex];
			for(int i = 0; i < n; i++) {
				answer += Math.max(a[i], a[i + 1]);
			}
			System.out.println(answer);
		}
	}
}