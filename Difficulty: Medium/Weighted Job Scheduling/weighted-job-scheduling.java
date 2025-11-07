import java.util.*;

class Solution {
    public int maxProfit(int[][] jobs) {
        int n = jobs.length;
        // Sort jobs by end time
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
        
        // DP: max profit up to every job
        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        
        for(int i = 1; i < n; i++) {
            // Profit including current job
            int include = jobs[i][2];
            int l = binarySearch(jobs, i);
            if(l != -1) include += dp[l];
            
            // Profit excluding current job
            dp[i] = Math.max(include, dp[i-1]);
        }
        
        return dp[n-1];
    }

    // Binary Search for the last job that doesn't overlap
    private int binarySearch(int[][] jobs, int idx) {
        int low = 0, high = idx - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(jobs[mid][1] <= jobs[idx][0]) {
                if(jobs[mid+1][1] <= jobs[idx][0]) low = mid + 1;
                else return mid;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
