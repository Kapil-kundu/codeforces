import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			boolean isSorted = true;
			arr[0] = sc.nextInt();
			for(int i = 1; i < n; i++) {
				arr[i] = sc.nextInt();
				if(arr[i] < arr[i - 1]) {
					isSorted = false;
				}
			}
			if(isSorted) {
				System.out.println(n);
			} else {
				System.out.println("1");
			}
		}
	}
}