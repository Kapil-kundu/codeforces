import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] arr = new int[n];
        int[] lastUpdate = new int[n];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
            lastUpdate[i] = 0;
        }

        int globalValue = 0;
        int lastFillTime = -1;
        int time = 0;


        while (q-- > 0) {
            time++;
            int t = sc.nextInt();

            if (t == 1) {
                int i = sc.nextInt() - 1;
                int x = sc.nextInt();

                int old;
                if (lastUpdate[i] < lastFillTime) {
                    old = globalValue;
                } else {
                    old = arr[i];
                }

                sum = sum - old + x;
                arr[i] = x;
                lastUpdate[i] = time;

                System.out.println(sum);

            } else {
                int x = sc.nextInt();
                globalValue = x;
                sum = (long) x * n;
                lastFillTime = time;

                System.out.println(sum);
            }
        }
    }
}
