import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int[] b = a.clone();
            Arrays.sort(b);

            if (Arrays.equals(a, b)) {
                System.out.println(-1);
                continue;
            }

            int mn = b[0];
            int mx = b[n - 1];
            int ans = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) {
                    int val = Math.max(a[i] - mn, mx - a[i]);
                    ans = Math.min(ans, val);
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
