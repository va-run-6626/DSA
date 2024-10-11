package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prog4_FloodFill {
    public static void main(String[] args) {
        int[][] img = {
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,1,1,1,1,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}
        };
        int sr = 1;
        int sc = 1;
        int color = 2;
        System.out.println("before flood fill : ");
        for(int[] a : img){
            System.out.println(Arrays.toString(a));
        }
        img = solve(img,sr,sc,color);
        System.out.println("After flood fill : ");
        for(int[] a : img){
            System.out.println(Arrays.toString(a));
        }
    }
    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int[][] solve(int[][] img, int sr, int sc, int color) {
        boolean[][] vis = new boolean[img.length][img[0].length];
        int[] xDir = {-1,0,1,0};
        int[] yDir = {0,-1,0,1};
        int prevColor = img[sr][sc];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        vis[sr][sc] = true;
        img[sr][sc] = color;
        while(!queue.isEmpty()){
            Pair p =queue.poll();
            int x = p.x;
            int y = p.y;
            for(int i = 0; i < 4; i++){
                int nx = x + xDir[i];
                int ny = y + yDir[i];
                if(nx >= 0 && nx < img.length && ny >= 0 && ny < img[0].length && img[nx][ny] == prevColor && !vis[nx][ny]){
                    queue.add(new Pair(nx,ny));
                    vis[nx][ny] = true;
                    img[nx][ny] = color;
                }
            }
        }
        return img;
    }
}
