import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] v = new long[n];
            for (int i = 0; i < n; i++) {
                v[i] = sc.nextLong();
            }
            long current = -v[n - 1];
            long difference = v[n - 1];
            long ans = 0;

            for (int i = n - 2; i >= 0; --i) {
                long val = v[i];
                long opt = current + Math.max(0L, val + difference);
                current -= val;
                difference = Math.max(difference, opt - current);
                if (i == 0) {
                    ans = opt;
                }
            }
            System.out.println(ans);
        }
    }
}

