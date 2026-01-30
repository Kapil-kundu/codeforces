import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] p = new int[n + 1]; // 1-based
            boolean[] used = new boolean[n + 1];

            for (int i = n - 1; i >= 1; i--) {
                if (p[i] != 0 || p[i + 1] != 0) continue;

                for (int x = 1; x <= n; x++) {
                    if (!used[x]) {
                        int y = x + i;
                        if (y <= n && !used[y]) {
                            p[i] = x;
                            p[i + 1] = y;
                            used[x] = used[y] = true;
                            break;
                        }
                        y = x - i;
                        if (y >= 1 && !used[y]) {
                            p[i] = x;
                            p[i + 1] = y;
                            used[x] = used[y] = true;
                            break;
                        }
                    }
                }
            }

            // 🔧 Fix leftover (for odd n)
            int leftoverNumber = -1;
            int leftoverIndex = -1;

            for (int i = 1; i <= n; i++) {
                if (!used[i]) {
                    leftoverNumber = i;
                    break;
                }
            }

            for (int i = 1; i <= n; i++) {
                if (p[i] == 0) {
                    leftoverIndex = i;
                    break;
                }
            }

            if (leftoverIndex != -1) {
                p[leftoverIndex] = leftoverNumber;
            }

            for (int i = 1; i <= n; i++) {
                System.out.print(p[i] + " ");
            }
            System.out.println();
        }
    }
}
