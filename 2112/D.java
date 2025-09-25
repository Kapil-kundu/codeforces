import java.util.*;

public class D {

	static private void dfs(ArrayList<ArrayList<Integer>> list, int node, boolean[] vis, int[] direction, int check) {
		vis[node] = true;
		
		for(int child: list.get(node)) {
			if(!vis[child]) {
				if(direction[node] == 0) {
					direction[child] = 1;
					System.out.println((child + 1) + " " + (node + 1));
				} else if(node == check) {
					System.out.println((child + 1) + " " + (node + 1));
					direction[child] = 1;
					check = -1;
				} else {
					direction[child] = 0;
					System.out.println((node + 1) + " " + (child + 1));
				}
				dfs(list, child, vis, direction, check);
			}
		}				
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				list.add(new ArrayList<>());
			}
		
			int[] check_degree = new int[n];
			boolean is_ans_possible = false;
			int node_with_degree_2 = 0;
			int u, v;
			
			for(int i = 0; i < n - 1; i++) {
				u = sc.nextInt();
				v = sc.nextInt();
				u = u - 1;
				v = v - 1;
				list.get(u).add(v);
				list.get(v).add(u);
				check_degree[u]++;
				check_degree[v]++;
			}
			
			for(int i = 0; i < n; i++) {
				if(check_degree[i] == 2) {
					is_ans_possible = true;
					node_with_degree_2 = i;
					break;
				}
			}
			//System.out.println("node with degree 2 is " + (node_with_degree_2 + 1));
			
			int is_assigned = 1;
			if(is_ans_possible == false) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
				boolean[] vis = new boolean[n];
				int[] direction = new int[n]; // if direction == 0 means that is a outgoing node else it is a incoming node 
				direction[node_with_degree_2] = -1;
				for(int child : list.get(node_with_degree_2)) {
					if(is_assigned == 1) {
						//vis[child] = true;
						direction[child] = 1;
						is_assigned = 0;
					} else {
						direction[child] = 0;
						//vis[child] = true;
					}
				}		
				int check = 0;
				dfs(list, node_with_degree_2, vis, direction, node_with_degree_2);
			}
		}
	}
}
			
			
			
			

				
					
				
				
