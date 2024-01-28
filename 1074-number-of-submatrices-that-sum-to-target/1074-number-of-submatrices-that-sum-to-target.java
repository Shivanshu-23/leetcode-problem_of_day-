
public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // Initialize result variable
        int res = 0;

        // Get the number of rows and columns in the matrix
        int m = matrix.length;    // Number of rows
        int n = matrix[0].length;  // Number of columns

        // Preprocess the matrix by calculating the prefix sum along each row
        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                matrix[i][j] += matrix[i][j - 1];

        // Iterate through all possible pairs of columns (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Map to store the count of prefix sums
                Map<Integer, Integer> counter = new HashMap<>();
                
                // Variable to track the current sum
                int cur = 0;
                
                // Iterate through all rows using the current pair of columns
                for (int k = 0; k < m; k++) {
                    // Calculate the current sum in the submatrix using the prefix sum
                    cur += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    
                    // Check if the current sum equals the target, increment result
                    if (cur == target) {
                        res++;
                    }
                    
                    // Increment result by the count of submatrices with the target sum
                    res += counter.getOrDefault(cur - target, 0);
                    
                    // Update the count of prefix sums in the map
                    counter.put(cur, counter.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}
