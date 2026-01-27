import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0 ) {
            int s = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            
            int lastFlip = (m / k) * k;
            int elapsed = m - lastFlip;
            int answer = Math.max(0, s - elapsed);

            System.out.println(answer);
        }
    }
}
