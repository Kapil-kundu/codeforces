import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class A {

    static void solve(Scanner sc) {
       
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ttt = sc.nextInt();
        while (ttt-- > 0) {
             int n = sc.nextInt();
            String s = sc.next();
            
            char[] sortedArr = s.toCharArray();
            Arrays.sort(sortedArr);
            String sorted = new String(sortedArr);

            if (s.equals(sorted)) {
                System.out.println("Bob");
                continue;
            }

            ArrayList<Integer> idx = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != sorted.charAt(i)) {
                    idx.add(i + 1);
                }
            }


            System.out.println("Alice");
            System.out.println(idx.size());
            for (int i : idx) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}