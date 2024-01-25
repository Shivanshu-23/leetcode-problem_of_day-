import java.util.Arrays;

class Solution {
    int n, m;
    int[][] t;

    public int longestCommonSubsequence(String text1, String text2) {
        n = text1.length();
        m = text2.length();
        t = new int[n + 1][m + 1];
        // Fill the memoization table with -1
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        return solve(text1, text2, 0, 0);
    }

    private int solve(String text1, String text2, int i, int j) {
        if (i == n || j == m) {
            // Base case: either of the strings is exhausted
            return 0;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            // Characters match, include them in the subsequence
            return t[i][j] = 1 + solve(text1, text2, i + 1, j + 1);
        } else {
            // Characters do not match, try both possibilities and choose the maximum
            return t[i][j] = Math.max(solve(text1, text2, i, j + 1), solve(text1, text2, i + 1, j));
        }
    }
}
