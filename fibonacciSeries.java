import java.util.*;

class fibonacciSeries{
    // to find the nth fibo number.
    
    public static void main(String []args){
        int n = 4;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(spaceFibo(n));
    }


    // Dp & recursion TC : O(n)  , SC : O(2n) --> O(n) recc stack space + o(n) dp array
    // Also known as memoization || (top bottom)
    // here timeComplex is linear becauser at max recc call is made for n times.

    public static int ReccFibo(int n,int []dp){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n] = ReccFibo(n-1,dp) + ReccFibo(n-2,dp);
    }


    // Tabulation Mathod TC : O(n) , SC : O(n)
    // also known as bottom up 

    public static int tabuFibo(int n,int []dp){
        if(n==0) return 0;
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
       return dp[n]; 
    }


    // space optimization TC : O(n) , SC : O(1) --->> optimal solution

    public static int spaceFibo(int n){
        if(n==0) return 0;
        int prevPrev = 0;
        int prev = 1;
        for(int i=2;i<=n;i++){
            int curr = prev + prevPrev;
            prevPrev = prev;
            prev = curr;
        }
       return prev; 
    }
}