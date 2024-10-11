package Graphs.FirstHalf;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prog8_01Matrix {
    public static void main(String[] args) {
        int[][] mat = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        System.out.println("Question : ");
        for(int[] i : mat){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
        System.out.println("Answer : ");
        int[][] ans = solve(mat);
        for(int[] i : ans){
            System.out.println(Arrays.toString(i));
        }
    }

    public static class DistanceInfo{
        int x;
        int y;
        int dist;
        public DistanceInfo(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private static int[][] solve(int[][] mat) {
        Queue<DistanceInfo> queue = new LinkedList<>();
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        int[][] distance = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j <mat[0].length; j++){
                if(mat[i][j] == 0){
                    queue.add(new DistanceInfo(i,j,0));
                    vis[i][j] = true;
                }
            }
        }
        int[] xDir = {-1,0,1,0};
        int[] yDir = {0,1,0,-1};
        while(!queue.isEmpty()){
            DistanceInfo info = queue.poll();
            int x = info.x;
            int y = info.y;
            int dist = info.dist;
            distance[x][y] = dist;
            for(int i= 0; i < 4; i++){
                int r = x + xDir[i];
                int c = y + yDir[i];

                if(r >= 0 && r < mat.length && c >= 0 && c < mat[0].length && mat[r][c] == 1 && !vis[r][c]){
                    queue.add(new DistanceInfo(r,c,dist+1));
                    vis[r][c] = true;
                }
            }
        }
        return distance;
    }

}
