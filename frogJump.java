// https://www.codingninjas.com/studio/problems/frog-jump_3621012?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
import java.util.Arrays;

public class frogJump {
    public static void main(String[] args) {
        int[] heights = {30, 10, 60, 10, 60, 50};
        int dp[] = new int[heights.length];
        Arrays.fill(dp, -1);
        System.out.println(solvefrogJump(heights.length-1, heights, dp));
    }

    /*  Memoization Method TC : O(N)  SC : O(N) + O(N) --> recursion stack + dp 
    Reason: The overlapping subproblems will return the answer in constant time O(1). Therefore the total number of new subproblems we solve is ‘n’. 
    Hence total time complexity is O(N).  */

    
    public static int solvefrogJump(int n, int heights[],int[] dp) {
        int ans = Integer.MAX_VALUE;
        if(n==0) return 0;
        int right = Integer.MAX_VALUE;

        if(dp[n]!=-1){
            return dp[n];
        } 

        int left = solvefrogJump(n-1, heights, dp) + Math.abs(heights[n]-heights[n-1]);
        if(n>1)
        right = solvefrogJump(n-2, heights, dp) + Math.abs(heights[n]-heights[n-2]);
        
        return dp[n]=Math.min(left, right);
    }
}
