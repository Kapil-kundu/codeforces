import java.util.*;

public class C {
    public static void main(String[] arsg) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++) {
                int ignore = sc.nextInt();
            }
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int maxPre[] = new int[n];
            maxPre[n - 1] = arr[n - 1];
            for(int i = n - 2; i >= 0; i--) {
                maxPre[i] = Math.max(arr[i], maxPre[i + 1]);
            }

           
            
            for(int i = 0; i < q; i++) {
                 int sum = 0;
                int a = sc.nextInt();
                int b = sc.nextInt();
                a -= 1;
                b -= 1;
                for(int j = a; j <= b; j++) {
                    sum += maxPre[j];
                }
                System.out.println(sum);

            }
        }

    }
}