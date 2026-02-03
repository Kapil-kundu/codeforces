import java.io.*;
import java.util.*;

public class D {

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long nextLong() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return Long.parseLong(st.nextToken());
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    static void solve(FastScanner fs, StringBuilder out) throws Exception {
        int n = fs.nextInt();
        int sz = n + 2;

        long[] a = new long[sz];
        long sum = 0;

        for (int i = 0; i < sz; i++) {
            a[i] = fs.nextLong();
            sum += a[i];
        }

        Arrays.sort(a);

        long s = sum - a[sz - 1];

        for (int i = 0; i < sz - 1; i++) {
            if (s - a[i] == a[sz - 1]) {
                for (int j = 0; j < sz - 1; j++) {
                    if (j != i) out.append(a[j]).append(" ");
                }
                out.append("\n");
                return;
            }
        }

        if (sum - a[sz - 1] - a[sz - 2] == a[sz - 2]) {
            for (int i = 0; i < sz - 2; i++) {
                out.append(a[i]).append(" ");
            }
            out.append("\n");
            return;
        }

        out.append("-1\n");
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            solve(fs, out);
        }

        System.out.print(out);
    }
}
