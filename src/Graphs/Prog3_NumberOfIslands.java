package Graphs;

import javax.swing.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prog3_NumberOfIslands {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println("Number of islands : "+ solve(matrix));
    }
    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static int solve(char[][] matrix) {
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        for(boolean[] b : vis){
            Arrays.fill(b,false);
        }
        Queue<Pair> queue = new LinkedList<>();
        int[] xDir = {-1,0,1,0};
        int[] yDir = {0,-1,0,1};
        int cnt = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == '0') continue;
                if(!vis[i][j]){
                    queue.add(new Pair(i,j));
                    vis[i][j] = true;
                    while (!queue.isEmpty()){
                        Pair p = queue.poll();
                        int R = p.x;
                        int C = p.y;
                        for(int k = 0; k < 4; k++){
                            int nx = R + xDir[k];
                            int ny = C + yDir[k];
                            if(nx >= 0 && nx <matrix.length && ny >= 0 && ny < matrix[0].length && !vis[nx][ny] && matrix[nx][ny] == '1'){
                                queue.add(new Pair(nx, ny));
                                vis[nx][ny] = true;
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
