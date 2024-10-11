package Graphs;

import java.util.Arrays;

public class Prog3_NoOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {
                {1,0,1},
                {0,1,0},
                {1,0,1}
        };
        System.out.println("Number of provinces : " + numberOfProvinces(isConnected));
    }

    private static int numberOfProvinces(int[][] isConnected) {
        boolean[] vis = new boolean[isConnected.length];
        Arrays.fill(vis,false);
        int cnt = 0;
        for(int i = 0; i < vis.length; i++){
            if(!vis[i]){
                dfs(isConnected,vis,i);
                cnt++;
            }
        }
        return cnt;
    }

    private static void dfs(int[][] isConnected, boolean[] vis,int node) {
        vis[node] = true;
        for(int i= 0; i < isConnected.length; i++){
            if(isConnected[node][i] == 1 && !vis[i]){
                dfs(isConnected,vis,i);
            }
        }
    }
}
