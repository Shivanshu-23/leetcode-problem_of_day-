class Solution {
    // Method to find the number of paths in a grid
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // If no moves are allowed, there are no paths
        if (maxMove == 0) return 0;

        // Initialize two 2D arrays to store counts of paths for current and last moves
        int[][] dpCurr = new int[m + 2][n + 2], dpLast = new int[m + 2][n + 2];

        // Initialize counts for boundary cells of dpCurr
        for (int i = 1; i <= m; i++) {
            dpCurr[i][1]++;
            dpCurr[i][n]++;
        }
        for (int j = 1; j <= n; j++) {
            dpCurr[1][j]++;
            dpCurr[m][j]++;
        }

        // Initialize ans with the count of paths at the starting position
        int ans = dpCurr[startRow + 1][startColumn + 1];

        // Iterate through each move
        for (int d = 1; d < maxMove; d++) {
            // Swap dpCurr and dpLast arrays using a temporary array
            int[][] temp = dpCurr;
            dpCurr = dpLast;
            dpLast = temp;

            // Update counts in dpCurr based on counts in neighboring cells of dpLast
            for (int i = 1; i <= m; i++)
                for (int j = 1; j <= n; j++)
                    dpCurr[i][j] = (int)(((long)dpLast[i - 1][j] + dpLast[i + 1][j] + dpLast[i][j - 1] + dpLast[i][j + 1]) % 1000000007L);

            // Add the count of paths at the starting position for the current move to ans
            ans = (ans + dpCurr[startRow + 1][startColumn + 1]) % 1000000007;
        }

        // Return the final result modulo 1000000007
        return ans;
    }
}
