import java.util.*;

public class B {

    static final int MAXN = 400001;
    static int[] l = new int[MAXN];
    static int[] r = new int[MAXN];
    static int[] sum = new int[MAXN];
    static int[] cnt = new int[MAXN];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            solve(sc);
        }

        sc.close();
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();

        for (int i = 1; i <= 2 * n; i++) {
            sum[i] = 0;
            cnt[i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();

            if (l[i] == r[i]) {
                sum[l[i]] = 1;
                cnt[l[i]]++;
            }
        }

        for (int i = 2; i <= 2 * n; i++) {
            sum[i] += sum[i - 1];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (l[i] == r[i]) {
                if (cnt[l[i]] <= 1)
                    sb.append("1");
                else
                    sb.append("0");
            } else {
                int totalFixed = sum[r[i]] - sum[l[i] - 1];
                int length = r[i] - l[i] + 1;

                if (totalFixed < length) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
