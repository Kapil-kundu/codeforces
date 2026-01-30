import java.util.*;

public class A {
    public static void main(String[] arsg) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int x = sc.nextInt();
            int sum = 0;
            for(int i = 0; i < n; i++) {
                int a = sc.nextInt();
                sum += a;
            }
            if(sum > s) {
                System.out.println("NO");
              
            } else if(sum == s) {
                System.out.println("YES");
                
            } else {
                 int afterSubt = s - sum;
                if(afterSubt % x == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        }
    }
}