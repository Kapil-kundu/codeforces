/*
Problem Link: https://codeforces.com/contest/1169/problem/B

In this problem We have to find any 2 common intervals from all the pairs if they exist
we have to print "Yes" else we print or return "NO"

$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        Logic:

firstly we take both integers from the first pair
then check if all other pair(except first) contain any value from the selected integers we continue
else, we increase the array(deifned while checking the integers in pairs) at the index of the pair value
and take another variable(all -> In this code), and then increase the varialbe by 1
at last we check the maximum value in the array should be equal to the variable(all)
if the value is equal we simply return or print "YES" else return or print "NO"
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$



*/
import java.util.Scanner;
import java.util.ArrayList;
public class B {

    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1; // convert to 0-index
            int b = sc.nextInt() - 1;
            pairs.add(new Pair(a, b));
        }

        // take first pair's values
        int[] values = {pairs.get(0).first, pairs.get(0).second};

        for (int x : values) {
            int[] val = new int[n];
            int all = 0;

            for (Pair c : pairs) {
                if (c.first != x && c.second != x) {
                    val[c.first]++;
                    val[c.second]++;
                    all++;
                }
            }

            int maxVal = 0;
            for (int v : val) {
                maxVal = Math.max(maxVal, v);
            }

            if (maxVal == all) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}