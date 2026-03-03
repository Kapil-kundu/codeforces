/* codeforces -> 701B
	
	Approach for this question 
	This code calculates how many cells remain unblocked in an n * n grid after each operation.
	Initially, the total number of cells in the grid is n * n. For every operation, a row and a column
	are marked. The program uses two HashSets to store distinct rows and columns so that duplicate 
	entries are not counted more than once. After each insertion, it calculates the number of unique 
	marked rows(x) and unique marked columns(y). Each marked row blocks n cells, and each marked
	column also blocks n cells. However, the cells at the intersections of marked rows and columns
	get counted twice, so they must be added back once. Using the inclusion-exclusion principle, the number
	of remaining unblocked cells is computed as (n * n - x * n - y * n + y* x). This process is repeated 
	after every operation, and the result is printed immediately..
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long m = sc.nextInt();
		HashSet<Integer> col = new HashSet<Integer>();
		HashSet<Integer> row = new HashSet<Integer>();
		for(int i = 0; i < m; i++) {
			col.add(sc.nextInt());
			row.add(sc.nextInt());
			long x = row.size();
			long y = col.size();
			System.out.println(n * n - x * n - y * n + (long)y* x);
		}
	}
}
