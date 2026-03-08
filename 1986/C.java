import java.util.*;

public class C {

    static class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int f, int s) {
            first = f;
            second = s;
        }
        public int compareTo(Pair o) {
            if(first != o.first) {
                return first - o.first;
            } 
            return second - o.second;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] cnt = new int[n + 1];
            Pair[] p = new Pair[m];

            StringBuilder a = new StringBuilder(sc.next());

            for (int i = 0; i < m; i++) {
                int ind = sc.nextInt() - 1;
                p[i] = new Pair(cnt[ind]++, ind);
            }

            char[] c = sc.next().toCharArray();

            Arrays.sort(p);
            Arrays.sort(c);

            for (int i = m - 1; i >= 0; i--) {
                a.setCharAt(p[i].second, c[i]);
            }

            System.out.println(a);
        }
    }
}