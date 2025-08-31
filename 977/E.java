/*
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

Problem name : Cyclic Components
Problem Link : https://codeforces.com/problemset/problem/977/E

$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

Description : 
    Basically we are given connected components of graph
    and we have to how many components have cycles

$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

                Properties of cyclic graph :> 

- A cycle has exactly n edges.

- In a cycle every node has degree 2(every node has exactly 2 
    adjacent nodes).

- Node 'i' has neighbors i - 1 and i + 1 only....

$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

                        LOGIC :-> 

i) Use DFS to explore each connected component of the graph

ii) For the current connected component check if it is a cycle

Que:-> How do we check if a connected component is a cycle?
Ans :-> Just check if every node in that connected component has 
        degree exactly 2

$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

*/

import java.util.Scanner;
import java.util.ArrayList;

public class E{
    public static boolean[] vis = new boolean[(int)2e5 + 5];
    public static boolean isCycle = true;
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private static void dfs(int node) {
        vis[node] = true;
        if(list.get(node).size() != 2) {
            isCycle = false;
        }
        for(int x : list.get(node)) {
            if(vis[x] == false) {
                dfs(x);
            }
        }
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();
           
            for(int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }
            int u, v;
            for(int i = 0; i < m; i++) {
                u = sc.nextInt();
                v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int answer = 0;
            for(int i = 1; i <= n; i++) {
                if(vis[i] == false) {
                    isCycle = true;
                    dfs(i);
                    if(isCycle) {
                       // System.out.println("I am increasing at " + i);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
