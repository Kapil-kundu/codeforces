/*
Problem Link: https://codeforces.com/contest/821/problem/C
Problem Name: Okabe and Boxes

$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            Approach

1) -> Maintain a stack to represent the current boxes.

2) -> Track last_removed → the last number successfully removed.

      -Initially last_removed = 0.

      -Each remove increases last_removed by 1.

3) -> For each operation:

      -If add x: push x into the stack.

      -If remove:

          -If the stack’s top = last_removed + 1, pop normally.

          -Otherwise:

              -Increase reordered_boxes.

              -Clear the stack (simulate sorting — no need to actually sort).

              -Increment last_removed (because after sorting, the required box is always on top, so it gets removed).

*/

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Stack<Integer> stack = new Stack<>();
        int last_removed = 0;
        int reordered_boxes = 0;

        for (int i = 0; i < 2 * n; i++) {
            String st = sc.nextLine();

            if (st.startsWith("add")) {
                int num = Integer.parseInt(st.split(" ")[1]);
                stack.push(num);
            } else { // remove
                if (!stack.isEmpty() && stack.peek() == last_removed + 1) {
                    stack.pop();
                    last_removed++;
                } else if (!stack.isEmpty()) {
                    reordered_boxes++;
                    stack.clear();      // remove all from stack
                    last_removed++;     // remove the expected element after reordering
                } else {
                    last_removed++;     // edge case: stack empty, just increment
                }
            }
        }

        System.out.println(reordered_boxes);
    }
}
