# A word machine is a system that performs a sequence of simple operations on a stack of integers. 
# The sequence of operations is given as a string and operations are separated by single spaces. 
# The following operations may be specified:
# - Any integers between 0 and 2 ** 20 − 1 is pushed into the stack
# - "POP removes the top most number from the stack
# - "DUP" pushes a duplicate of the top most number into the stack
# - "+" pops the two top most elements from the stack, adds them together, 
#   and pushes the sum into the stack
# - "-" pops the two top most elements from the stack, subtracts the second one from the first, 
#   and pushes the difference onto the stack
# After processing all the operations, the machine returns the topmost value from the stack.

def solution(S):

    stack = []

    for i in S.split(" "):  # splits string on single spaces

        if i.isdigit():
            stack.append(int(i))  # pushes list item into the stack if a number

        elif i == "POP" and len(stack) > 0:  # check list isnt empty
            stack.pop()  # pops top most number from the stack

        elif i == "DUP" and len(stack) > 0:  # check list isnt empty
            stack.append(stack[-1])  # pushes a duplicate of the topmost number into the stack

        elif i == "+" and len(stack) > 1 and (stack[-1] + stack[-2]) <= ((2 ** 20) - 1):  # checks
            sum_top_two = stack[-1] + stack[-2]

            stack.pop()  # pops the top most numbers after addition
            stack.pop()

            stack.append(sum_top_two)  # pushes result into the stack

        elif i == "-" and (len(stack) > 1) and ((stack[-1] - stack[-2]) > 0):  # valid value checks
            sub_top_two = stack[-1] - stack[-2]

            stack.pop()  # pops the top most numbers after subtraction
            stack.pop()

            stack.append(sub_top_two)  # pushes result into the stack

        else:
            return -1  # return an error indicating number

    return stack[-1]  # returns top most number in the post loop stack

# test
test_strings = ["4 5 6 - 7 +", "13 DUP 4 POP 5 DUP + DUP + -", "5 6 + -", "3 DUP 5 - -", "1048575 DUP +"]
test_answers = [8, 7, -1, -1, -1]

i = 0

for string in test_strings:
    if solution(string) == test_answers[i]:
        print("Pass")

    else:
        print("Fail")

    i += 1
