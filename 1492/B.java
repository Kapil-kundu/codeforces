import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int a[] = new int [n];
			int poi[] = new int[n + 1];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				poi[a[i]] = i;
			}
			int l = 0, h = n;
			for(int i = n; i > 0; i--) {
				l = poi[i];
				if(h > l) {
					for(int j = l; j < h; j++) {
						System.out.print(a[j] + " ");
					}
					h = l;
				}
			}
			System.out.println();
		}
	}

}