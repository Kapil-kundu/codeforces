import java.util.*;
 
public class C {
	static long total_cost = 0;
	private static int dfs(int node, boolean[] vis, int[] gold_amt, int current, ArrayList<ArrayList<Integer>> list) {
		vis[node] = true;
		for(int friend : list.get(node)) {
			if(!vis[friend]) {
				if(gold_amt[friend] <= current) {
					current = gold_amt[friend];
				}
				current = Math.min(current, dfs(friend, vis, gold_amt, current, list));
			}
		}
		return current;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int gold_amt[] = new int[n];
		for(int i = 0; i < n; i++) {
			gold_amt[i] = sc.nextInt();
		}
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}
		
		int u, v;
		for(int i = 0; i < m; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			u = u - 1;
			v = v - 1;
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		boolean[] vis = new boolean[n];
		Arrays.fill(vis, false);
		for(int i = 0; i < n; i++) {
			if(!vis[i]) {
				total_cost += dfs(i, vis, gold_amt, gold_amt[i], list);
			}
		}
		System.out.println(total_cost);
	}
}
		
