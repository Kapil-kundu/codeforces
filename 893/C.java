/*
Problem link: https://codeforces.com/contest/893/problem/C
Problem Name: Rumor 

Description: 
	Vova knows that there are n characters in Overcity. Some characters are friends to each other,
 	and they share information they got. Also Vova knows that he can bribe each character so he or 
  	she starts spreading the rumor; i-th character wants ci gold in exchange for spreading the rumor.
   	When a character hears the rumor, he tells it to all his friends, and they start spreading the
	rumor to their friends (for free), and so on.

	The quest is finished when all n characters know the rumor. What is the minimum amount of
 	gold Vova needs to spend in order to finish the quest?

	Take a look at the notes if you think you haven't understood the problem 
 	completely.

  	$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
								Logic ---> 

  	This is a graph components problem, In this problem we are given some graph components
   	and we have to find minimum amount of gold from each component and at last we have to sum 
	all minimum amount of gold we have 

 	For this problem : 	
  	we use dfs for each component and find minimum amount of gold from each component
   
	$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$


*/

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
		
