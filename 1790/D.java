import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
             int n = sc.nextInt();

            int[] a = new int[n];
            Map<Integer, Integer> cnt = new HashMap<>();
            Set<Integer> b = new TreeSet<>();

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

                cnt.put(a[i], cnt.getOrDefault(a[i], 0) + 1);

                b.add(a[i]);
                b.add(a[i] + 1);
            }

            int last = 0;
            int res = 0;

            for (int x : b) {
                int c = cnt.getOrDefault(x, 0);
                res += Math.max(0, c - last);
                last = c;
            }

            System.out.println(res);
        }
    }
}