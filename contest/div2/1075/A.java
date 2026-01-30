import java.util.*;

public class A {
	public static void main(String[] ars) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int h = sc.nextInt();
			int l = sc.nextInt();
			
			int arr[] = new int[n];
			for(int i  = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			int maxPossibleInd = -1;
			for(int i = n - 1; i >= 0; i--) {
				if(arr[i] <= Math.max(h, l)) {
					maxPossibleInd = i;
					break;
				}
			}

			int cnt =0;
			int start = 0;
			
			for(int i = maxPossibleInd; i > start; i--) {
				if((arr[i] <= h && arr[start] <= l) || (arr[i] <= l && arr[start] <= h)) {
					cnt++;
					start++;
				}
			}
			System.out.println(cnt);
		}
	}
}
						
						
					
				
			
			
			
