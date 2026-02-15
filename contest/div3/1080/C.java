import java.util.Scanner;

public class C {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];

			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			int answer = 0;
			for(int i = 0; i < n - 1; i++) {
				int element = arr[i];
				int pair = 7 - element;

				if(arr[i + 1] == pair || arr[i + 1] == element) {
					answer++;
					i++;
				}
			}
			System.out.println(answer);
		}
	}
}