import java.util.*;

public class C {
    public static void main(String[] ars) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            long  s = 0, mn = 0, bst = 0;
            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                s += x;
                long cur = (i + 1) * (long)(i + 2) - s;
                mn = Math.min(mn, cur);
                bst = Math.max(bst, cur - mn);
            }
               System.out.println(s + bst);

        }
    }
}