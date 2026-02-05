import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();

            long maxSum;
            if (n % 2 == 0) {
                maxSum = (long) n * n / 2;
            } else {
                maxSum = ((long) n * n - 1) / 2;
            }

            if (k < 0 || k > maxSum || k % 2 != 0) {
                System.out.println("NO");
                continue;
            }

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = i + 1;
            } 

            int l = 0, r = n - 1;
            while (l < r && k > 0) {
                long gain = (long)2 * (r - l);
                if (gain <= k) {
                    int temp = a[l];
                    a[l] = a[r];
                    a[r] = temp;
                    k -= gain;
                    l++;
                    r--;
                } else {
                    int d = (int)(k / 2);
                    int temp = a[l];
                    a[l] = a[l + d];
                    a[l + d] = temp;
                    k = 0;
                }
            }

            if (k != 0) {
                System.out.println("NO");
                continue;
            }

            System.out.println("YES");
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}
