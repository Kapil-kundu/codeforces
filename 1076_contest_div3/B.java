import java.util.Scanner;

public class B {
    public static void main(String[] arsg) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            
            int[] p = new int[n];

            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                int want = n - i;

                if (p[i] == want) {
                    continue;
                }

                int pos = i;
                while (p[pos] != want) {
                    pos++;
                }

                int l = i, r = pos;
                while (l < r) {
                    int temp = p[l];
                    p[l] = p[r];
                    p[r] = temp;
                    l++;
                    r--;
                }

                break; 
            }

            for (int i = 0; i < n; i++) {
                System.out.print(p[i] + " ");
            }
            System.out.println();
        }
            
    }
}
