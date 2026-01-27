import java.util.Scanner;
import java.util.ArrayList;

public class D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int values[] = new int[n];
			for(int i = 0; i < n; i++) {
				values[i] = sc.nextInt();
			}
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				list.add(new ArrayList<>());
			}
			
			int u, v;
			for(int i = 0; i < n; i++) {
				u = sc.nextInt();
				v = sc.nextInt();
				u -= 1;
				v -= 1;
				list.get(u).add(v);
			}
			
			
			boolean vis[] = new int[n];
			Arrays.fill(vis, false);
			for(int i = 0; i < n; i++) {
				if(!vis[i]) {
					dfs(vis, list, values, 
			
				
			
