package Graphs.FirstHalf;

import java.util.Arrays;

public class Prog9_XO {
    public static void main(String[] args) {
        char[][] grid= {
                {'x','x','x','x','x'},
                {'x','o','o','x','o'},
                {'x','x','o','x','o'},
                {'x','o','x','o','x'},
                {'o','o','x','x','x'},
        };
        System.out.println("Given Matrix : ");
        for(char[] a : grid){
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
        solve(grid);
        System.out.println("Flipped Matrix : ");
        for(char[] a : grid) {
            System.out.println(Arrays.toString(a));
        }
    }

    private static void solve(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int n = grid.length;
        int m = grid[0].length;

        //1st row
        for(int j = 0; j < m ; j++){
            if(!vis[0][j] && grid[0][j] == 'o'){
                dfs(0,j,vis,grid);
            }
        }

        //first col
        for(int i = 0; i < n; i++){
            if(!vis[i][0] && grid[i][0] == 'o'){
                dfs(i,0,vis,grid);
            }
        }

        // last row
        for(int j = 0; j < m; j++){
            if(!vis[n-1][j] && grid[n-1][j] == 'o'){
                dfs(n-1,j,vis,grid);
            }
        }

        //last col
        for(int i = 0; i < n; i++){
            if(!vis[i][m-1] && grid[i][m-1] == 'o'){
                dfs(i,m-1,vis,grid);
            }
        }

        // make changes
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 'o' && !vis[i][j]){
                    grid[i][j] = 'x';
                }
            }
        }
    }

    private static void dfs(int i, int j, boolean[][] vis, char[][] grid) {
        vis[i][j] = true;
        int[] xDir = {0,-1,0,1};
        int[] yDir = {-1,0,1,0};
        for(int k = 0; k < 4; k++){
            int x = i + xDir[k];
            int y = j + yDir[k];
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 'o' && !vis[x][y]){
                dfs(x,y,vis,grid);
            }
        }
    }
}
