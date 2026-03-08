/* Codeforces Problem - 2193D

Solution Logic -> 
    
    The logic of the code is to find the maximum possible value of a[i] × h for each test case.
    First, the program reads the number of test cases and, for each test case, reads
    the size of the arrays and the elements of arrays a and b. Then the array a is sorted in 
    descending order so that larger values are considered first, which helps in maximizing 
    the final result. The program uses two variables: h, which represents how many elements 
    from array b have been taken, and sum, which stores the total of the selected b values. 
    As the loop runs through each position i, it keeps adding elements from array b as long as 
    the total sum of those elements does not exceed i. Each time a new element from b is 
    included, h increases. For every position, the program calculates the value a[i] × h and 
    compares it with the current maximum answer, updating the answer if a larger value is found. 
    After checking all positions, the program prints the maximum value obtained.

*/

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Integer[] temp = new Integer[n];

            for (int i = 0; i < n; i++) {
                temp[i] = a[i];
            } 
            Arrays.sort(temp, Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                a[i] = temp[i];
            }

            int h = 0, sum = 0;
            long ans = 0;

            for (int i = 0; i < n; i++) {
                while (h < n && sum + b[h] <= i + 1) {
                    sum += b[h];
                    h++;
                }
                ans = Math.max(ans, (long) a[i] * h);
            }

            System.out.println(ans);
        }
    }
}