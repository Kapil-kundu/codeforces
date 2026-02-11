import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        Stack<Character> stack = new Stack<>();
        int moves = 0;

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                moves++;       
            } else {
                stack.push(c);
            }
        }

        if (moves % 2 == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
