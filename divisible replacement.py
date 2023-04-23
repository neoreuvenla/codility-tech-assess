# Write a function that, given a positive integer N, prints the consecutive numbers from 1 to N, 
# each on a separate line. However, any number divisible by 2, 3, or 5 should be replaced by the 
# word "Codility", "Test", or "Coders" respectively. If a number is divisible by more than one of 
# the numbers: 2, 3, or 5, it should be replaced by a concatenation of the respective words: 
# "Codility", "Test," and "Coders", in that order.

def solution(N):
    
    start = 1
    
    while start <= N:
        
        output = []
        
        if (start % 2) == 0:
            output.append("Codility")
        if (start % 3) == 0:
            output.append("Test")
        if (start % 5) == 0:
            output.append("Coders")
        if len(output) == 0:
            output.append(start)
            
        print (''.join(str(v) for v in output))
            
        start+=1

# test
solution(24)