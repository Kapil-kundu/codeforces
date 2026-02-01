import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[m];

            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();

            Map<Integer, Integer> need = new HashMap<>();
            for (int x : b) {
                need.put(x, need.getOrDefault(x, 0) + 1);
            }

            Map<Integer, Integer> have = new HashMap<>();
            int matches = 0;
            int answer = 0;

            for (int i = 0; i < m; i++) {
                int x = a[i];
                have.put(x, have.getOrDefault(x, 0) + 1);
                if (have.get(x) <= need.getOrDefault(x, 0)) {
                    matches++;
                }
            }

            if (matches >= k) answer++;

            for (int i = m; i < n; i++) {
                int add = a[i];
                int remove = a[i - m];

                // add element
                have.put(add, have.getOrDefault(add, 0) + 1);
                if (have.get(add) <= need.getOrDefault(add, 0)) {
                    matches++;
                }

                // remove element
                if (have.get(remove) <= need.getOrDefault(remove, 0)) {
                    matches--;
                }
                have.put(remove, have.get(remove) - 1);

                if (matches >= k) answer++;
            }

            System.out.println(answer);
        }
    }
}
