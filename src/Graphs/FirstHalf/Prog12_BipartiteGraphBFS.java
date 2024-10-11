package Graphs.FirstHalf;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prog12_BipartiteGraphBFS {
    public static void main(String[] args) {
        int[][] adj = {
                {},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}
        };
        System.out.println("Is Bipartite : "+ isBipartite(adj));
    }

    private static boolean isBipartite(int[][] adj) {
        int[] color = new int[adj.length];
        Arrays.fill(color,-1);
        for(int i=0; i < color.length; i++){
            if(color[i] == -1){
                if(!bfs(i,color,adj)) return false;
            }
        }
        return true;
    }

    private static boolean bfs(int i, int[] color, int[][] adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        color[i] = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            int nodeColor = color[node];
            for(int a : adj[node]){
                if(color[a] == -1){
                    if(nodeColor == 1){
                        color[a] = 0;
                    }else{
                        color[a] = 1;
                    }
                }else if(nodeColor == color[a]) return false;
            }
        }
        return true;
    }
}
