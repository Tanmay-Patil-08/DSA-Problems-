//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    int n = M;
	    int sum = V; 
	    int [][] dp = new int[n+1][sum+1];
	    
	    
	    for(int i = 0 ; i <= sum;i++){
	        dp[0][i] = Integer.MAX_VALUE - 1; 
	    }
	    for(int i = 1 ; i <= sum;i++){
	        if(i % coins[0] != 0 ){
	            dp[1][i] = Integer.MAX_VALUE - 1; 
	        }
	        else {
	            dp[1][i] = i % coins[0];
	        }
	    }
	    
	    for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= sum; j++){
                dp[i][j] = dp[i-1][j];
                
                if(coins[i-1] <= j ){
                    dp[i][j] =Math.min(dp[i-1][j] , 1 + dp[i][j -coins[i-1]]);
                }
            }
        }
        if( dp[n][sum] == Integer.MAX_VALUE-1 ){
            return -1;
        }
        
        return  dp[n][sum] ;
	    
	} 
}