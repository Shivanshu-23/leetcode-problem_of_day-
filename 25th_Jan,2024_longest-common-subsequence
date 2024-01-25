2024-01-25
1143. Longest Common Subsequence

Topic: String, Dynamic Programming
Difficulty: Medium

Problem:
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

• For example, "ace" is a subsequence of "abcde".

A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.


Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.


Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.


Constraints:

• 1 <= text1.length, text2.length <= 1000
• text1 and text2 consist of only lowercase English characters.




Solution --->>>
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
