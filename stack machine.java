// A word machine is a system that performs a sequence of simple operations on a stack of integers. 
// The sequence of operations is given as a string and operations are separated by single spaces. 
// The following operations may be specified:
// - Any integers between 0 and 2 ** 20 − 1 is pushed into the stack
// - "POP removes the top most number from the stack
// - "DUP" pushes a duplicate of the top most number into the stack
// - "+" pops the two top most elements from the stack, adds them together, 
//   and pushes the sum into the stack
// - "-" pops the two top most elements from the stack, subtracts the second one from the first, 
//   and pushes the difference onto the stack
// After processing all the operations, the machine returns the topmost value from the stack.

import java.util.Stack;

public class Main {

    // takes a string of space separated instructions
    public static int solution(String S) {
        
        // create an empty stack for integers
        Stack<Integer> stack = new Stack<>();

        // split input string into an array
        for (String i : S.split(" ")) {

            // if a number push into stack
            if (i.matches("\\d+")) {
                stack.push(Integer.parseInt(i));
            } 
            
            // if "pop" remove the top element from stack
            else if (i.equals("POP") && !stack.isEmpty()) {
                stack.pop();
            } 
            
            // if "dup" duplicate the top element and push into stack
            else if (i.equals("DUP") && !stack.isEmpty()) {
                stack.push(stack.peek());
            } 
            // if "+" pop the top two elements add and push into stack
            else if (i.equals("+") && stack.size() > 1) {
            
                int a = stack.pop();
                int b = stack.pop();

                // check if the result is within the limits
                if ((long) a + b <= (long) (Math.pow(2, 20) - 1)) {
                    stack.push(a + b);
                    
                // if the result is out of bounds return -1 
                } else {
                    return -1;
                }
            } 
            
            // if "-" pop the top two elements subtract and push result into stack
            else if (i.equals("-") && stack.size() > 1) {
            
                int a = stack.pop();
                int b = stack.pop();

                // if the result is positive
                if (a - b > 0) {
                    stack.push(a - b);
                    
                // if result is negative or zero
                } else {
                    return -1;
                }
            } 
            
            // if not recognized return -1
            else {
                return -1;
            }
        }

        // return the top element of stack or -1 if empty
        return stack.isEmpty() ? -1 : stack.peek();
    }

    // test with a given set of input strings and expected outputs
    public static void main(String[] args) {
        
        String[] test_strings = {"4 5 6 - 7 +", "13 DUP 4 POP 5 DUP + DUP + -", "5 6 + -", "3 DUP 5 - -", "1048575 DUP +"};
        int[] test_answers = {8, 7, -1, -1, -1};

        // iterate over the test cases
        for (int i = 0; i < test_strings.length; i++) {
        
            if (solution(test_strings[i]) == test_answers[i]) {
                System.out.println("Pass");
                
            } else {
                System.out.println("Fail");
            }
        }
    }
}

