How Function Call works?
All the function calls go to stack and once the function has finished executing,
it's popped out from the stack

Important:
Base condition --> 
   to come out of recursion
   to stop the recursion call to go on indefinitely
   
If we are calling the same function again, each function call would be in
the stack - separate memory for variables and function call.

Why Recursion?
Function calling itself is called Recursion.
And Recursion helps us in solving bigger complex problems in a simpler way
We can convert recursive solutions into iterative solutions and vice versa

Space Complexity --> Not constant because of the function calls in stack. (O(N))

How to study/code using recursion?
Try to draw Recurrence Tree
Try to come up with the recurrence relation


Tail Recursion:
If you have a recursive call as the last function call - then it's called tail
recursion.

Ex: PrintNumber --> tail Recursion
Fib Number --> Not a tail recursion

How to understand a problem?
1) Identify if you can break down the problem into subproblems
2) write the recurrence relation if needed
3) Draw the recursive tree
4) About the tree
    --> see the flow of functions how they are getting in stack
    --> identify and focus on left tree calls and right tree calls


Types of Recurrence relation
1) Linear recurrence relation - fibonacci
2) Divide and Conquer recurrence relation - BinarySearch

