import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt() - 1;   

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int x = n;
            for (int i = 0; i < n; i++) {
                if (a[i] > a[k]) {
                    x = i;
                    break;
                }
            }
            int[] pos = new int[n];
            for (int i = 0; i < n; i++) {
                pos[i] = i;
            }

            int ans = 0;

            int[] check = {0, x};

            for (int idx = 0; idx < 2; idx++) {

                int i = check[idx];
                if (i == n) continue;

                int temp = pos[i];
                pos[i] = pos[k];
                pos[k] = temp;

                int[] stt = new int[n];

                int u = pos[0];
                for (int j = 1; j < n; j++) {
                    int v = pos[j];
                    if (a[v] >= a[u]) {
                        u = v;
                    }
                    stt[u]++;
                }
                
                temp = pos[i];
                pos[i] = pos[k];
                pos[k] = temp;

                ans = Math.max(ans, stt[k]);
            }

            System.out.println(ans);
        }

        sc.close();
    }
}