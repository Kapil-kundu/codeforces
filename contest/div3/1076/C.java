import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n; i++) b[i] = sc.nextInt();

            int[] temp = new int[n];

            // build temp array
            temp[n - 1] = Math.max(a[n - 1], b[n - 1]);
            for (int i = n - 2; i >= 0; i--) {
                temp[i] = Math.max(a[i], b[i]);
                temp[i] = Math.max(temp[i], temp[i + 1]);
            }

            // build prefix sum
            long[] prefix = new long[n];
            prefix[0] = temp[0];
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] + temp[i];
            }

            // answer queries in O(1)
            while (q-- > 0) {
                int c = sc.nextInt() - 1;
                int d = sc.nextInt() - 1;

                long sum = prefix[d] - (c > 0 ? prefix[c - 1] : 0);
                System.out.println(sum);
            }
        }
    }
}
