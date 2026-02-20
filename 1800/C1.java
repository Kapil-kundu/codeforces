import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;
public class C1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			PriorityQueue<Integer> myArmy = new PriorityQueue<>(Collections.reverseOrder());

			int el;
			long answer = 0;
			for(int i = 0; i < n; i++) {
				el = sc.nextInt();
				if(el == 0) {
					if(!myArmy.isEmpty()) {
						answer += myArmy.poll();
					}
				} else {
					myArmy.add(el);
				}

			}

			System.out.println(answer);
		}
	}
}