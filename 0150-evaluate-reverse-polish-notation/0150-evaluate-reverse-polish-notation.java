class Solution {
    int result = 0;

    public int evalRPN(String[] tokens) {
        // Stack to store operands during the evaluation
        Stack<Integer> stack = new Stack<>();

        // Iterate through each token in the input array
        for (String token : tokens) {
            // Check if the current token is an operator
            if (isOperator(token)) {
                // Pop two operands from the stack
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                // Perform the operation and push the result back to the stack
                int intermediateResult = performOperation(operand1, operand2, token);
                stack.push(intermediateResult);
            } else {
                // If the token is not an operator, it must be an operand, so push it to the stack
                stack.push(Integer.parseInt(token));
            }
        }

        // The final result is the only element left in the stack
        return stack.pop();
    }

    // Check if a given token is an operator
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    // Perform the specified operation on two operands
    private int performOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                // This should not happen if the input is well-formed
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}