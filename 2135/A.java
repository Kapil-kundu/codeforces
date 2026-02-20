import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int[] a = new int[n + 1];
            int[] dp = new int[n + 1];

            List<ArrayDeque<Integer>> q = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                q.add(new ArrayDeque<>());
            }

            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 1; i <= n; i++) {

                dp[i] = dp[i - 1];

                int x = a[i];

                q.get(x).addLast(i);

                if (q.get(x).size() > x) {
                    q.get(x).pollFirst();
                }

                if (q.get(x).size() == x) {
                    int start = q.get(x).peekFirst();
                    dp[i] = Math.max(dp[i], dp[start - 1] + x);
                }
            }

            System.out.println(dp[n]);
        }
    }
}
