import java.util.Scanner;
import java.util.*;
//jimport java.util.LinkedList;
public class B {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// int t = sc.nextInt();
		// while(t-- > 0) {
			int n = sc.nextInt();
			long k  = sc.nextLong();
			Queue<Integer> q = new LinkedList<>();
			for(int i = 0; i < n; i++) {
				q.add(sc.nextInt());
			}

			
			
			int first = q.poll();
			int second = q.poll();
			int winnerPower = -1;
			int winCnt = 0;
			int lastWin;
			if(first > second) {
				winnerPower = first;
				winCnt++;
				lastWin = first;
				q.add(second);
			} else {
				winnerPower = second;
				winCnt++;
				lastWin = second;
				q.add(first);
			}
			
			int cntOfWin = 0;
			
			while(true) {
				int a = q.poll();
				if(a < winnerPower) {
					winCnt++;
					lastWin = winnerPower;
					q.add(a);
				}
				else {
					winCnt = 1;
					lastWin = a;
					q.add(winnerPower);
					winnerPower = a;
				}
				if(winnerPower == n) {
					System.out.println(n);
					break;
				}
				if(winCnt >= k) {
					System.out.println(winnerPower);
					break;
				}




			}
		//}
	}
}