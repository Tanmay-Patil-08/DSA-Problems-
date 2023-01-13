//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int prices[], int n) {

        
        // int [][] dp = new int[n+1][n+1];
        
        // for(int i = 0; i <= n ; i++){
        //     for(int j = 0  ; j <= n; j++){
        //         if ( i == 0 || j == 0 ){
        //             dp[i][j] = 0;
        //         }
        //         else {
                    
        //         if (i == 1) {
        //             dp[i][j] = j * price[i - 1];
        //         }
        //         else{
        //         if(i < j){
        //             dp[i][j] = Math.max((price[i-1]+dp[i][j-i]),dp[i-1][j]);
        //         }else{
        //             dp[i][j] = dp[i-1][j];
        //         }
                    
        //         }
        //         }
        //     }
        // }
        // return dp[n][n];
        int mat[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 0;
                }
                else {
                    if (i == 1) {
                        mat[i][j] = j * prices[i - 1];
                    }
                    else {
                        if (i > j) {
                            mat[i][j] = mat[i - 1][j];
                        }
                        else {
                            mat[i][j] = Math.max(
                                prices[i - 1]
                                    + mat[i][j - i],
                                mat[i - 1][j]);
                        }
                    }
                }
            }
            
        }
        return mat[n][n];
    }
}