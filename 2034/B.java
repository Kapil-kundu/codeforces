import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int zeroCount = 0;
            int answer = 0;
            for(int i = 0; i < n; i++) {
                
               if(s.charAt(i) == '0') {
                    zeroCount++;
               } 

               if(zeroCount == m) {
                    answer++;
                    i = i + k - 1;
                    zeroCount = 0;
               }

               if(i >= n) {
                    break;
               }

               if(s.charAt(i) == '1') {
                    zeroCount = 0;
               }
               
            }
            System.out.println(answer);
        }
    }
}