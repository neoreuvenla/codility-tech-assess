// Write a function that, given a positive integer N, prints the consecutive numbers from 1 to N, 
// each on a separate line. However, any number divisible by 2, 3, or 5 should be replaced by the 
// word "Codility", "Test", or "Coders" respectively. If a number is divisible by more than one of 
// the numbers: 2, 3, or 5, it should be replaced by a concatenation of the respective words: 
// "Codility", "Test," and "Coders", in that order.

import java.util.*; 

public class Main {
    
    // takes an integer N as input
    public static void solution(int N) {  
        
        int start = 1;  
        
        // loop while start is less than or equal to N
        while (start <= N) {  
            
            // create an empty list to store output
            List<String> output = new ArrayList<>();  
            
            // check if start is divisible by 2 3 or 5
            if (start % 2 == 0) {
                output.add("Codility");
            }
            
            if (start % 3 == 0) {
                output.add("Test");
            }
            
            if (start % 5 == 0) {
                output.add("Coders");
            }
            
            // if no strings added add the current start value
            if (output.isEmpty()) {
                output.add(Integer.toString(start));
            }
            
            // print concatenated string
            System.out.println(String.join("", output));
            
            // increment start
            start++;
        }
    }

    // test with a given input value
    public static void main(String[] args) {  
        solution(24); 
    }
}

