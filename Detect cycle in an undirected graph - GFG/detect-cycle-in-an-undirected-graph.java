//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int node;
    int parent;
    public Pair(int n,int p ){
        this.node = n;
        this.parent = p;
    }
}

class Solution {
    
    public boolean isCycle_BFS(int no,ArrayList<ArrayList<Integer>> adj,boolean [] visited){
        
        Queue <Pair> q = new LinkedList<>();
        visited[no] = true;
        q.add(new Pair(no,-1));
        
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int n = temp.node;
            int p = temp.parent;
            
            for(int i :adj.get(n)){
                
                if(visited[i] == false ){
                    visited[i] = true;
                    q.add(new Pair(i,n));
                }
                else if(i != p){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean [] visited = new boolean[V];
        for(int i =0; i < V;i++){
            if(visited[i] == false ){
                if(isCycle_BFS(i,adj,visited)){
                    return true;
                }
            }
        }
        return false;

    }
}