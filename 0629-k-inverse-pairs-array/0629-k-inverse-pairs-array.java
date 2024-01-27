class Solution {
    public int kInversePairs(int n, int k) {
        int MOD = 1000000007;
        
        // 2D array to store intermediate results
        int[][] opt = new int[k + 1][n];
        
        // Loop through all possible values of i (number of inverse pairs)
        for (int i = 0; i <= k; i++) {
            // Loop through all possible values of j (array size)
            for (int j = 0; j < n; j++) {
                // Base case: if i is 0, there is only one way to arrange the elements
                if (i == 0) {
                    opt[i][j] = 1;
                } else if (j > 0) {
                    // Recursive relation: opt[i][j] = opt[i - 1][j] + opt[i][j - 1]
                    // This counts the number of arrangements without considering inverse pairs
                    opt[i][j] = (opt[i - 1][j] + opt[i][j - 1]) % MOD;
                    
                    // Adjust for cases where i is greater than or equal to j + 1
                    if (i >= j + 1) {
                        // Subtract the arrangement count with i - j - 1 and j - 1 elements
                        // This eliminates arrangements that create more inverse pairs than allowed
                        opt[i][j] = (opt[i][j] - opt[i - j - 1][j - 1] + MOD) % MOD;
                    }
                }
            }
        }

        // The final result is stored in opt[k][n - 1]
        return opt[k][n - 1];
    }
}
