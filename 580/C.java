/*

Problem Name :-> Kefa and Park
Problem Link :-> https://codeforces.com/contest/580/problem/C

Description :-> 

Kefa decided to celebrate his first big salary by going to the restaurant.

He lives by an unusual park. The park is a rooted tree consisting of n vertices with the root at vertex 1.
Vertex 1 also contains Kefa's house. Unfortunaely for our hero, the park also contains cats. Kefa has already
found out what are the vertices with cats in them.

The leaf vertices of the park contain restaurants. Kefa wants to choose a restaurant where he will go,
but unfortunately he is very afraid of cats, so there is no way he will go to the restaurant if the path from
the restaurant to his house contains more than m consecutive vertices with cats.

Your task is to help Kefa count the number of restaurants where he can go.

Input
The first line contains two integers, n and m (2 ≤ n ≤ 105, 1 ≤ m ≤ n) — the number of vertices of the tree and 
the maximum number of consecutive vertices with cats that is still ok for Kefa.

The second line contains n integers a1, a2, ..., an, where each ai either equals to 0 (then vertex i has no cat), 
or equals to 1 (then vertex i has a cat).

Next n - 1 lines contains the edges of the tree in the format "xi yi" (without the quotes) (1 ≤ xi, yi ≤ n, xi ≠ yi), 
where xi and yi are the vertices of the tree, connected by an edge.

It is guaranteed that the given set of edges specifies a tree.

Output
A single integer — the number of distinct leaves of a tree the path to which from Kefa's home contains at most m 
consecutive vertices with cats.



        Logic :-> 

at first we use dfs function and while dfs is running we continuously checking if the node have cats or not 
if that node contains cat we increase consicutive and also check if out consicutive is greater then out limit 
we return immediately from there and set consicuitve count is zero.
At last if we reach at leaf node we increase our answer by 1 and when the dfs is end we print the answer

Time complexity = O(n)  
Space complexity = O(n)
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class C {
    static int answer = 0;
    private static void  dfs(ArrayList<ArrayList<Integer>> list, int[] arr, boolean[] visited, int node, int m, int count_consicutive) {
        visited[node] = true;
        if(arr[node] == 1) {
            count_consicutive++;
        } else {
            count_consicutive = 0;
        }
        if(count_consicutive > m) {
            return;
        }
        boolean isLeaf = true;
        for (int neighbor : list.get(node)) {
            if (!visited[neighbor]) {
                isLeaf = false;
                dfs(list, arr, visited, neighbor, m, count_consicutive);
            }
        }
        if(isLeaf) {
            answer++;
        }
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();  //number of vertices
            int m = sc.nextInt();  // max number of consicutive vertices
            int[] arr = new int[n];
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());  // initialize adjacency list
            }
            int u, v;
            for(int i = 0; i < n - 1; i++) {
                u = sc.nextInt();
                v = sc.nextInt();
                list.get(u - 1).add(v - 1);
                list.get(v - 1).add(u - 1);
            }
            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);
            int node = 0;
            dfs(list, arr, visited, node, m, 0);
            System.out.println(answer);
        }   
    }
}
