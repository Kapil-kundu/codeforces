/*
Problem Link : https://codeforces.com/contest/2112/problem/D
Problem Name : Reachability and Tree

Description : 
		In this problem we are given are a undirected graph and we have to make it 
		directed graph such that we have exactly n(number of vertices) paths.
		and if there is no such path we have to print "NO".


$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

				Logic : 

	For this problem if we have not a vertex with degree 2 than there is no possibilites
	to make that graph directed, else if we have a verted with degree 2 than for that particular node 
	we directed the one child to that node(node with degree 2) and the second child will be directed
	from the node and for all of the remaining nodes we directed all edges in opposite to each other 

	example :
	graph -> 
		[5]---[3]---[1]---[2]---[4]

		in this graph we have 2 nodes with degree 2 (node 2, 1, and 2)
		for this we select node 3, we direct the edge 3 to 5 and node 
		1 will point to 3 

		graph will become ->   [5] <--[3] <--[1]---[2]--[4]

		after this we will direct all edges opposite to each other
		graph will become -> [5] <--[3] <--[1] -->[2] <--[4]

		output :
			3 5
			1 3
			1 2
			4 2
		there is exactly n(5) paths 
		5 to 3
		1 to 3
		1 to 5
		1 to 2
		4 to 2
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

*/


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
			
			
			
			

				
					
				
				
