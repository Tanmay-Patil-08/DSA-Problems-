//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    Set<String> set = new HashSet<String>();
    
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] direction = {{-1,0},{0,-1},{1,0},{0,1}};

        boolean [][] visited = new boolean  [n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < m ;j++){
                if(grid[i][j] == 1 && visited[i][j] == false ){
                    bfs(i,j,grid,visited,direction);
                }
            }
        }
        return set.size();
    }
    public void bfs(int row,int col,int[][] grid,boolean[][] visited,int[][]direction){
        int n = grid.length;
        int m = grid[0].length;
        int[] base = {row,col};
        visited[row][col] = true;
        ArrayList <Pair> shape = new ArrayList<Pair> ();
        // shape.add(new Pair(0,0);
        
        Queue <Pair> q = new LinkedList<Pair> ();
        q.add(new Pair(row,col));
        
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int r = temp.x;
            int c = temp.y;
            
            for(int [] i : direction){
            int nrow = r + i[0];
            int ncol = c + i[1];

            if(nrow < n && ncol < m && nrow >= 0 && ncol >= 0 && visited[nrow][ncol] == false && grid[nrow][ncol] == 1 ){
                visited[nrow][ncol] = true;
                q.add(new Pair(nrow,ncol));
                shape.add(new Pair((nrow - base[0]),(ncol-base[1])));
            }
        }

        }
        String temp = to_string(shape);
        set.add(temp);
    }
    public String to_string(ArrayList<Pair> arr ){
        String ans = "";
        for(Pair i : arr ){
            ans += "("+i.x+","+i.y+") ";
        }
        // System.out.println(ans);
        return ans;
    }
}
