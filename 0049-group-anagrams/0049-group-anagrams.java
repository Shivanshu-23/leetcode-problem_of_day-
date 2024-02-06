import java.util.*;

class Solution {
    // Method to generate a key for a string based on its sorted character counts
    private String generate(String s) {
        // Array to store the count of each character in the string
        int[] count = new int[26];
        
        // Counting the occurrences of each character in the string
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        
        // StringBuilder to construct the key based on sorted character counts
        StringBuilder newS = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            // Appending characters to the new key based on their counts
            for (int j = 0; j < count[i]; j++) {
                newS.append((char) (i + 'a'));
            }
        }
        // Returning the generated key
        return newS.toString();
    }

    // Method to group anagrams together
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store groups of anagrams, where the key is the generated key and value is the list of anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        // Iterating through each string in the input array
        for (String s : strs) {
            // Generating key for the current string
            String newS = generate(s);

            // If the key doesn't exist in the map, create a new entry
            if (!map.containsKey(newS)) {
                map.put(newS, new ArrayList<>());
            }
            // Adding the current string to the list of anagrams corresponding to its key
            map.get(newS).add(s);
        }
        // Returning the list of groups of anagrams
        return new ArrayList<>(map.values());
    }
}
/*49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]*/
