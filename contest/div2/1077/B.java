import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            char[] s = sc.next().toCharArray();

            int ans = 0;
            for (char c : s) {
                if (c == '1') {
                	 ans++;   
               	}
            }

            int i = 0;
            while (i < n) {
                if (s[i] == '0') {
                    boolean left = (i == 0 || s[i - 1] == '0');
                    boolean right= (i == n - 1 || s[i + 1] == '0');

                    if (left && right) {
                        ans++;
                        if (i + 1 < n) {
                            s[i + 1] = '1';
                        } else {
                            s[i] = '1';
                        }
                        i += 2;
                        continue;
                    }
                }
                i++;
            }

            System.out.println(ans);
        }
    }
}