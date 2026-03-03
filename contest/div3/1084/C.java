import java.util.Scanner;
import java.util.Stack;

public class C{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();

            Stack<Character> st = new Stack<>();
            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);
                if (!st.isEmpty() && c == st.peek()) {
                    st.pop();
                } else {
                    st.push(c);
                }
            }

            if (st.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}