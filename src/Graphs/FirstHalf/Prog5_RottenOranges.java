package Graphs.FirstHalf;

import java.util.LinkedList;
import java.util.Queue;

public class Prog5_RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println("Time Required : " + solve(grid));
    }

    private static int solve(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int freshOranges = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1) freshOranges++;
                else if(grid[i][j] == 2) queue.add(new Pair(i,j));
            }
        }
        if(freshOranges == 0) return 0;
        int[] xDir = {0,-1,0,1};
        int[] yDir = {-1,0,1,0};
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                Pair p = queue.poll();
                int x = p.x;
                int y = p.y;
                for(int i = 0; i < 4; i++){
                    int r = x + xDir[i];
                    int c = y + yDir[i];
                    if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1){
                        grid[r][c] = 2;
                        queue.add(new Pair(r,c));
                        freshOranges--;
                    }
                }
                size--;
            }
            time++;
        }
        if(freshOranges == 0) return time;
        else return -1;
    }

    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
