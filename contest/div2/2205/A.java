import java.util.Scanner;

public class A {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n + 1];
			
			int max = 0;
			int maxInd = 0;
			for(int i = 1; i <= n; i++) {
				arr[i] = sc.nextInt();
				if(arr[i] > max) {
					max = arr[i];
					maxInd = i;
				}
			}
			int temp = arr[1];
			 arr[1] = arr[maxInd];
			arr[maxInd] = temp; 

			for(int i = 1; i <= n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			

		}

	}
}