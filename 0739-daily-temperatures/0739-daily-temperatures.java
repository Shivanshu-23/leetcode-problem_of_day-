class Solution {
    public int[] dailyTemperatures(int[] temps) {
        // Create an array to store the result
        int[] results = new int[temps.length];
        
        // Use a stack to keep track of indices of temperatures
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through the temperatures array
        for (int i = 0; i < temps.length; i++) {
            // Check if the current temperature is greater than the temperature at the index
            // corresponding to the top of the stack
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                // If yes, update the result for the index at the top of the stack
                results[stack.peek()] = i - stack.pop();
            }
            
            // Push the current index onto the stack
            stack.push(i);
        }

        // The remaining indices in the stack have no warmer temperatures to the right
        // Set their result values to 0
        while (!stack.isEmpty()) {
            results[stack.pop()] = 0;
        }

        // Return the final results
        return results;
    }
}
