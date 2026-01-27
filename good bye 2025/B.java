import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            String str = sc.next();
            int n = str.length();
            int result = 0;
            int index = 0;

            while (index < n) {
                if (str.charAt(index) == 's') {
                    index++;
                    continue;
                }
                int end = index;
                while (end < n && str.charAt(end) == 'u') {
                    end++;
                }

                int length = end - index;
                int extra = 0;

                if (index == 0) {
                    extra++;
                }
                if (end == n) {
                    extra++;
                }

                int remaining = Math.max(0, length - extra);
                result += extra + remaining / 2;
                index = end;
            }

            System.out.println(result);
        }
    }
}

