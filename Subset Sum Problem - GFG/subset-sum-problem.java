//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    // static Boolean isSubsetSum(int N, int arr[], int sum){
    //     if (sum == 0 && N == 0){
    //         return true;
    //     }else if ( sum == 0 && N != 0){
    //         return true;
    //     }else if (N == 0 && sum != 0 ){
    //         return false; 
    //     }
        
        
    //     if (arr[N-1] <= sum ){
    //         return  isSubsetSum(N-1 , arr, sum -arr[N-1]) ||  isSubsetSum(N-1,arr,sum);
    //     }else{
    //         return isSubsetSum(N-1,arr,sum);
    //     }
    //     // code here
    // }
       static Boolean isSubsetSum(int N, int arr[], int sum){
           
           Boolean t[][]= new Boolean[N+1][sum+1];
           
           for (int i = 0 ; i < N+1 ; i++ ){
               t[i][0] = true;
           }
           for (int i = 1; i < sum+1 ; i++ ){
               t[0][i] = false;
           }
           
           for (int i = 1 ; i < N+1 ; i++ ){
               for(int j = 1 ; j < sum+1 ; j++){
                    t[i][j] =t[i-1][j]; 
                    if (arr[i-1] <= j ){
                        
                         t[i][j] = t[i-1][j - arr[i-1]] || t[i][j];
                    }else{

                        }
                   
               }
           }
           
           return t[N][sum];
        // code here
    }
}