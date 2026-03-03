import java.util.Scanner;
import java.util.Arrays;
public class A {
	public static void main(String[] arsg) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			int answer = 1;
			for(int i = n - 2; i >= 0; i--) {
				if(arr[i] == arr[i + 1]) {
					answer++;
				} else {
					break;
				}
			}
			System.out.println(answer);
		}
	}
}