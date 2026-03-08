import java.util.Scanner;
 
public class C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		String s = sc.next();
		int count = 0, pos = 1;
		for(int i = 0; i < l; i++) {
			if(s.charAt(i) == '(' ) {
				count++;
			} else {
				count--;
			}
			if(count < -1) {
				pos = 0;
				break;
			}
		}
		if(count == 0 ) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		} 	
	}
}
 