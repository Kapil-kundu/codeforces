import java.util.*;

public class D {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            long h = sc.nextLong();

            long arr[] = new long[n];

            for(int i = 0; i < n; i++){
                arr[i] = sc.nextLong();
            }

            long temp[] = Arrays.copyOf(arr, n);

            while(m-- > 0) {

                int bi = sc.nextInt();
                long ci = sc.nextLong();
                bi -= 1;

                temp[bi] += ci;
                if(temp[bi] > h){
                    temp = Arrays.copyOf(arr, n);
                }
            }
            for(int i = 0; i < n; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
        }
    }
}

