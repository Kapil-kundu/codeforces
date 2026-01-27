import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

public class F {
 	public static void main(String[] args) {
 		Scanner sc = new Scanner(System.in);
 		int t = sc.nextInt();
 		while(t-- > 0) {
 			int n = sc.nextInt();
 			int[] arr = new int[n];
 			Map<Integer, Integer> mp = new HashMap<>();
 			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int x : arr) {
				mp.put(x, mp.getOrDefault(x, 0) + 1);
			}
			
			int freqOne = mp.getOrDefault(1, 0);
			Arrays.sort(arr);
			int last = arr[n - 1];
			if(last > 1) {
				freqOne += 1;
			}
			
			if(freqOne % 2 == 1) {
				System.out.println("Alice");
			} else {
				System.out.println("Bob");
			}
		}
	}
}
