package Graphs.FirstHalf;

import java.util.*;

public class Prog1_BFS {
    public static void main(String[] args) {
        int[][] edges = {
                {1,2}
                ,{1,6}
                ,{2,3}
                ,{2,4}
                ,{6,7}
                ,{6,8}
                ,{3,10}
                ,{4,5}
                ,{7,5}
                ,{8,9}
        };
        int nodes = 10;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= nodes; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] a : edges){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }
        System.out.println("BFS : ");
        bfs(nodes,adj);
    }
    private static void bfs(int nodes, List<List<Integer>> adj){
        boolean[] vis = new boolean[nodes+1];
        Arrays.fill(vis,false);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        vis[1] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Integer out = queue.poll();
                System.out.print(out + " ");
                for (Integer i : adj.get(out)) {
                    if (!vis[i]) {
                        vis[i] = true;
                        queue.add(i);
                    }
                }
                size--;
            }
            System.out.println();
        }
    }
}
