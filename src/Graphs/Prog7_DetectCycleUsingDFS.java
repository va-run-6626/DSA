package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Prog7_DetectCycleUsingDFS {
    public static void main(String[] args) {
        int[][] edges = {
                {1,2},{2,5},{5,7},{7,6},{6,3},{3,1},{3,4}
        };
        int nodes = 7;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= nodes; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        System.out.println("Detected Cycle : " + detectCycle(nodes,adj));
    }

    private static boolean detectCycle(int nodes, List<List<Integer>> adj) {
        boolean[] vis = new boolean[nodes+1];
        for(int i = 1; i < vis.length; i++){
            if(!vis[i]){
                if(checkCycle(i,-1,adj,vis)) return true;
            }
        }
        return false;
    }

    private static boolean checkCycle(int src,int parent, List<List<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        for(Integer i : adj.get(src)){
            if(!vis[i]){
                if(checkCycle(i,src,adj,vis)) return true;
            }else if(i != parent) return true;
        }
        return false;
    }
}
