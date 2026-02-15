import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
        
            if(a == b && b == c && c == d && d == a) {
                System.out.println("YES");
                continue;
            } else {
                System.out.println("NO");
            }
        }
    }
}