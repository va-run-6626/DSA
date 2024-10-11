package Graphs.FirstHalf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prog11_NoOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,1,1,1},
                {1,1,0,0,0}
        };
        System.out.println("Number of Distinct Islands :"+ solve(grid));
    }

    private static int solve(int[][] grid) {
        int n = grid.length; 
        int m = grid[0].length;
        Set<List<String>> set = new HashSet<>();
        boolean[][] vis = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    List<String> list = new ArrayList<>();
                    dfs(i,j,vis,grid,list,i,j);
                    set.add(list);
                }
            }
        }

        return set.size();
    }

    private static void dfs(int i, int j, boolean[][] vis, int[][] grid, List<String> list, int bx, int by) {
        vis[i][j] = true;
        int dx = i-bx;
        int dy = j-by;
        String cal = "( "+dx+", "+dy+" )";
        list.add(cal);
        int n = grid.length;
        int m = grid[0].length;
        int[] xDir = {-1,0,1,0};
        int[] yDir = {0,-1,0,1};
        for(int a = 0; a < 4; a++){
            int x = i + xDir[a];
            int y = j + yDir[a];
            if(x >= 0 && x < n && y >= 0 && y < m && !vis[x][y] && grid[x][y] == 1){
                dfs(x,y,vis,grid,list,bx,by);
            }
        }
    }
}
