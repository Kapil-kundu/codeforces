import java.util.Scanner;
import java.util.Stack;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String str = sc.next();
            Stack<Character> st = new Stack<>();
            for (int i = str.length() - 1; i >= 0; i--) {
                st.push(str.charAt(i));
            }

            boolean flag = true;

            while (st.size() > 1) {
                char A = st.pop();
                char B = st.pop();

                if (A == 'Y' && B == 'Y') {
                    System.out.println("NO");
                    flag = false;
                    break;
                } else if (A == 'Y' || B == 'Y') {
                    st.push('Y');
                } else {
                    st.push('N');
                }
            }

            if (flag) {
                System.out.println("YES");
            }
        }
    }
}

