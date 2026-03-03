import java.util.Scanner;

public class B {

    static long minimumDivisor(long n) {
        long result = 1;

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                result *= i; 
                while (n % i == 0)
                    n /= i;   
            }
        }

        if (n > 1)
            result *= n;

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            System.out.println(minimumDivisor(n));
        }

        sc.close();
    }
}